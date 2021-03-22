package org.hattrickscoreboardl.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.HattrickApplication;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.app.HUpdate;
import org.hattrickscoreboardl.database.models.nationals.HNationalTeam;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.database.models.teams.HUser;
import org.hattrickscoreboardl.services.live.LiveService;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.hattrick.ArenaProcess;
import org.hattrickscoreboardl.services.process.hattrick.ClubProcess;
import org.hattrickscoreboardl.services.process.hattrick.EconomyProcess;
import org.hattrickscoreboardl.services.process.hattrick.MatchesProcess;
import org.hattrickscoreboardl.services.process.hattrick.NationalMatchesProcess;
import org.hattrickscoreboardl.services.process.hattrick.NationalTeamProcess;
import org.hattrickscoreboardl.services.process.hattrick.NationalTeamsProcess;
import org.hattrickscoreboardl.services.process.hattrick.PlayersProcess;
import org.hattrickscoreboardl.services.process.hattrick.SeriesProcess;
import org.hattrickscoreboardl.services.process.hattrick.TeamProcess;
import org.hattrickscoreboardl.services.process.hattrick.TransfersProcess;
import org.hattrickscoreboardl.services.process.hattrick.WorldProcess;
import org.hattrickscoreboardl.utils.HattrickDate;
import org.hattrickscoreboardl.utils.Preferences;

import java.util.List;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class MainService extends IntentService implements UpdateListener {

    static final String TAG = (MainService.class).getSimpleName();

    //For update notification to application
    Intent intent;
    public static String INTENT = "org.hattrickscoreboard.service.receiver";
    public static String UPDATECODE = "updatecode";
    public static String UPDATEFROM = "updatefrom";

    //Force (re)loading all files
    public static String FORCE_LOAD = "load";

    Context ctx;

    // For chpp request
    IRequest request;

    //User preferences
    Preferences pref;

    //Force update process
    boolean force = false;

    public MainService() {
        super(TAG);
        intent = new Intent(INTENT);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG, "Service is starting...");

        //Get context
        ctx = this;

        //Preferences
        pref = new Preferences(ctx);

        //Create Hattrick Requester
        request = new HattrickRequest(this, ((HattrickApplication) getApplication()).getCHPPToken(this));

        //Get params
        if (intent.getExtras() != null) {
            force = intent.getExtras().getBoolean(FORCE_LOAD);
            if (force) {
                Log.i(TAG, "Force reload data...");
            }
        }

        //////////////////////////////////////////

        //Load part 1 (essential infos)
        Log.i(TAG, "Loading part 1...");

        //Reset loading counter
        ((HattrickApplication) getApplication()).getLoader().reset();

        //For each teams
        final MatchesProcess matches = new MatchesProcess(ctx, request, force);
        matches.setListener(this);

        final TransfersProcess transfers = new TransfersProcess(ctx, request, force);
        transfers.setListener(this);

        final PlayersProcess players = new PlayersProcess(ctx, request, force);
        players.setListener(this);

        final SeriesProcess series = new SeriesProcess(ctx, request, force);
        series.setListener(this);

        //For national teams
        final NationalMatchesProcess nMatches = new NationalMatchesProcess(ctx, request, force);
        nMatches.setListener(this);

        final NationalMatchesProcess nU20Matches = new NationalMatchesProcess(ctx, request, force);
        nU20Matches.setListener(this);

        final NationalTeamsProcess nationals = new NationalTeamsProcess(ctx, request, force);
        nationals.setListener(this);

        //First update all his teams
        TeamProcess teams = new TeamProcess(this, request, force);
        teams.setListener(new UpdateListener() {

            @Override
            public void onUpdateStart(String from) {

                //Add +1 for this part (fix 100% before real finish)
                ((HattrickApplication) getApplication()).getLoader().addLoad();

                Log.v(TAG, "Updated started from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());

                sendBrodcastNotification(from, UpdateCode.CODE_START);
            }

            @Override
            public void onUpdateError(String from, int code) {

                //Add finished for this part (fix 100% before real finish)
                ((HattrickApplication) getApplication()).getLoader().addFinishLoad();

                Log.e(TAG, "Updated failed from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());

                sendBrodcastNotification(from, UpdateCode.CODE_UNKNOWN_ERROR);
            }

            @Override
            public void onUpdateSuccess(String from) {

                //Get logged user & his teams
                HUser user = HUser.findById(HUser.class, 1l);
                List<HTeam> teams = HTeam.find(HTeam.class, "USER_ID = ?", user.getUserID() + "");

                //Add nb process corresponding nb teams
                ((HattrickApplication) getApplication()).getLoader().addLoad( teams.size() * 4);

                ///Add nb process corresponding national teams
                ((HattrickApplication) getApplication()).getLoader().addLoad(3);

                /////////////////////////////////////
                //User teams

                for (int i = 0; i < teams.size(); i++) {

                    HTeam team = teams.get(i);

                    //Update Matches (without full details)
                    matches.perform(team.getTeamID(), false);

                    //Update transfers steam
                    transfers.perform(team.getTeamID());

                    //Update players
                    players.perform(team.getTeamID(), false);

                    //Update Series
                    series.perform(team.getLeagueLevelUnitID());

                    /////////////////////////////////////
                    //Youth team
                    //TODO

                }

                /////////////////////////////////////
                //National teams

                //Get national senior & youth teams
                nationals.perform();

                //Update national league match
                nMatches.perform(2);

                //Update national U20 league match
                nU20Matches.perform(4);

                /////////////////////////////////////
                // Set default preferences (first launch)
                if(pref.get(Preferences.SELECTED_TEAM_ID, 0) == 0) {

                    pref.save(Preferences.SELECTED_LOCALE, getResources().getConfiguration().locale.toString());    /*fr_fr?*/
                    pref.save(Preferences.FIRST_LAUNCH, true);

                    pref.save(Preferences.COLOR_RGB_1STTEAM, getResources().getColor(R.color.appTheme));
                    pref.save(Preferences.TIMEZONE_OFFSET_1STTEAM, "+01:00");
                    pref.save(Preferences.COLOR_RGB_2NDTEAM, getResources().getColor(R.color.appTheme));
                    pref.save(Preferences.TIMEZONE_OFFSET_2NDTEAM, "+01:00");

                    //First team
                    HTeam primaryTeam = teams.get(0);

                    pref.save(Preferences.SELECTED_TEAM_ID, primaryTeam.getTeamID());
                    pref.save(Preferences.NATIONAL_LEAGUE_ID, primaryTeam.getLeagueID());
                    pref.save(Preferences.USER_ID, primaryTeam.getUserID());
                    pref.save(Preferences.WORLD_1STTEAM, primaryTeam.getLeagueID());

                    //Second team (if exist)
                    if(teams.size() == 2){

                        HTeam secondaryTeam = teams.get(1);
                        pref.save(Preferences.WORLD_2NDTEAM, secondaryTeam.getLeagueID());
                    }
                }
                /////////////////////////////////////

                //Add finished for this part (fix 100% before real finish)
                ((HattrickApplication) getApplication()).getLoader().addFinishLoad();

                Log.i(TAG, "Updated successed from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());

                sendBrodcastNotification(from, UpdateCode.CODE_SUCCESS);
            }
        });

        teams.perform(953281/*556652 / 953281*/);

        /////////////////////////////////////
        //Load teams details

        Log.i(TAG, "Loading part 2...");

        //Each senior teams
        final ArenaProcess arena = new ArenaProcess(ctx, request, force);
        arena.setListener(this);

        final ClubProcess club = new ClubProcess(ctx, request, force);
        club.setListener(this);

        final EconomyProcess eco = new EconomyProcess(ctx, request, force);
        eco.setListener(this);

        final PlayersProcess playersDetails = new PlayersProcess(ctx, request, force);
        playersDetails.setListener(this);

        final MatchesProcess matchesDetails = new MatchesProcess(ctx, request, force);
        matchesDetails.setListener(this);

        //National teams
        final NationalMatchesProcess nationalMatches = new NationalMatchesProcess(ctx, request, force);
        nationalMatches.setListener(this);

        final NationalTeamProcess nTeam = new NationalTeamProcess(ctx, request, force);
        nTeam.setListener(this);

        //Other league teams
        final TeamProcess team = new TeamProcess(ctx, request, force);
        team.setListener(this);

        //First update world info (dates)
        WorldProcess world = new WorldProcess(ctx, request, false);
        world.setListener(new UpdateListener() {

        @Override
        public void onUpdateStart(String from) {

            //Reset counter
            ((HattrickApplication) getApplication()).getLoader().reset();

            //Add +1 for this part (fix 100% before real finish)
            ((HattrickApplication) getApplication()).getLoader().addLoad();

            Log.v(TAG, "Updated started from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());

            sendBrodcastNotification(from, UpdateCode.CODE_START);
        }

        @Override
        public void onUpdateError(String from, int code) {

            //Add finished for this part (fix 100% before real finish)
            ((HattrickApplication) getApplication()).getLoader().addFinishLoad();

            Log.e(TAG, "Updated failed from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());

            sendBrodcastNotification(from, UpdateCode.CODE_UNKNOWN_ERROR);
        }


        @Override
        public void onUpdateSuccess(String from) {


            HUser user = HUser.findById(HUser.class, 1l);
            List<HTeam> teams = HTeam.find(HTeam.class, "USER_ID = ?", user.getUserID() + "");

            //Add nb process corresponding nb teams
            ((HattrickApplication) getApplication()).getLoader().addLoad( teams.size() * 5);

            ///Add nb process corresponding national teams
            ((HattrickApplication) getApplication()).getLoader().addLoad(2);

            //For each his teams
            for (int i = 0; i < teams.size(); i++) {

                HTeam t = teams.get(i);

                //Update arena
                arena.perform(t.getArenaID());

                //Update club
                //TODO change value
                club.perform(177327/*t.getTeamID()*/);

                //Update economy
                //TODO change value
                eco.perform(177327/*t.getTeamID()*/);

                //Update players
                playersDetails.perform(t.getTeamID(), true);

                //Update full matches finished
                matchesDetails.perform(t.getTeamID(), true);

            }

            //For each his youth teams
            for (int i = 0; i < teams.size(); i++) {
                //TODO
            }

            //National teams > Get leagueID
            int nationalLeagueID = pref.get(Preferences.NATIONAL_LEAGUE_ID, teams.get(0).getLeagueID());

            //For selected national team
            HNationalTeam nT = HNationalTeam.findOne(HNationalTeam.class,
                    "LEAGUE_OFFICE_TYPE_ID = 2 and LEAGUE_ID = ?", String.valueOf(nationalLeagueID));
            nTeam.perform(nT.getTeamID());


            //For selected national U20 team
            HNationalTeam nU20T = HNationalTeam.findOne(HNationalTeam.class,
                    "LEAGUE_OFFICE_TYPE_ID = 4 and LEAGUE_ID = ?", String.valueOf(nationalLeagueID));
            nTeam.perform(nU20T.getTeamID());

            ////////////////////////////////////
            // Update all other infos
            ////////////////////////////////////

            HUpdate update = HUpdate.findOne(HUpdate.class, "PROCESS_NAME = ?", "" + TAG);
            if(update == null) {
                update = new HUpdate();
            }

            //Check if need update
            if(!Validity.isUpToDate(TAG, force, update.getFetchedDate(), Validity.OTHERS_TEAMS)) {

                //Add nb process corresponding nb teams
                ((HattrickApplication) getApplication()).getLoader().addLoad( teams.size() * 8);

                //For each his teams
                for (int i = 0; i < teams.size(); i++) {

                    HTeam t = teams.get(i);

                    //Get all teams series
                    List<HTeam> teamsSeries = HTeam.find(HTeam.class, "LEAGUE_LEVEL_UNIT_ID = ?", t.getLeagueLevelUnitID() + "");

                    //For each teams in this series
                    for (int j = 0; j < teamsSeries.size(); j++) {

                        HTeam ts = teamsSeries.get(j);
                        Log.i(TAG, "Load additional informations for team ID: " + ts.getTeamID());
                        team.perform(ts.getTeamID());
                    }
                }

                //Save updater
                update.setProcessName(TAG);
                update.setFetchedDate(HattrickDate.getDateTime());
                update.save();
            }

            //Add finished for this part (fix 100% before real finish)
            ((HattrickApplication) getApplication()).getLoader().addFinishLoad();

            Log.i(TAG, "Updated successed from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());

            sendBrodcastNotification(from, UpdateCode.CODE_SUCCESS);
        }
        });
        world.perform(0);

        //Launch live services
        Log.i(TAG, "Start live service...");
        startService(new Intent(MainService.this, LiveService.class));


        Log.i(TAG, "Start updating service...");
        //TODO service update training, financial...

        Log.i(TAG, "End service...");
    }

    void sendBrodcastNotification(String from, int code) {
        intent.putExtra(UPDATEFROM, from);
        intent.putExtra(UPDATECODE, code);
        sendBroadcast(intent);
    }

    @Override
    public void onUpdateStart(String from) {
        Log.v(TAG, "Updated started from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());
        sendBrodcastNotification(from, UpdateCode.CODE_START);
    }

    @Override
    public void onUpdateSuccess(String from) {

        ((HattrickApplication) getApplication()).getLoader().addFinishLoad();

        Log.i(TAG, "Updated successed from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());
        sendBrodcastNotification(from, UpdateCode.CODE_SUCCESS);
    }

    @Override
    public void onUpdateError(String from, int code) {

        ((HattrickApplication) getApplication()).getLoader().addFinishLoad();

        Log.e(TAG, "Updated failed from '" + from + "'. " + ((HattrickApplication) getApplication()).getLoader().toString());
        sendBrodcastNotification(from, code);
    }

}
