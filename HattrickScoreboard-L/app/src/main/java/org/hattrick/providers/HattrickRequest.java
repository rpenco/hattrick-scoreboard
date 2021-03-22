package org.hattrick.providers;

import android.content.Context;
import android.util.Log;

import org.hattrick.chpp.CHPPResponse;
import org.hattrick.chpp.CHPPToken;
import org.hattrick.constants.Hattrick;
import org.hattrick.models.achievements.Achievements;
import org.hattrick.models.arenas.ArenaDetails;
import org.hattrick.models.arenas.MyArena;
import org.hattrick.models.avatars.PlayersAvatar;
import org.hattrick.models.avatars.StaffsAvatar;
import org.hattrick.models.bookmarks.Bookmarks;
import org.hattrick.models.clubs.Club;
import org.hattrick.models.economies.Economy;
import org.hattrick.models.fans.Fans;
import org.hattrick.models.leagues.LeagueDetails;
import org.hattrick.models.leagues.LeagueFixtures;
import org.hattrick.models.live.Live;
import org.hattrick.models.managers.ManagerCompendium;
import org.hattrick.models.match.MatchDetails;
import org.hattrick.models.match.MatchLineUp;
import org.hattrick.models.matches.Matches;
import org.hattrick.models.national.NationalTeamDetails;
import org.hattrick.models.national.NationalTeamMatches;
import org.hattrick.models.national.NationalTeams;
import org.hattrick.models.players.PlayerDetails;
import org.hattrick.models.players.Players;
import org.hattrick.models.search.SearchResponse;
import org.hattrick.models.staffs.StaffList;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.models.training.Training;
import org.hattrick.models.transfers.CurrentBids;
import org.hattrick.models.transfers.TransferSearch;
import org.hattrick.models.transfers.Transfers;
import org.hattrick.models.world.WorldDetails;
import org.hattrick.models.world.WorldLanguage;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrick.providers.models.HLiveParam;
import org.hattrick.providers.models.HMatchLineupParam;
import org.hattrick.providers.models.HMatchParam;
import org.hattrick.providers.models.HTransfersSearch;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.HattrickAPI;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;


/**
 * Like asyncTask...
 * @author Khips
 * @since 28 mars 2014
 */
public class HattrickRequest extends IRequest {

    static final String TAG = (HattrickRequest.class).getSimpleName();

    private CHPPToken token;
    private OAuthService service;
    private HattrickParam hparams;

    public HattrickRequest(Context ctx, CHPPToken token) {
        super(ctx);
        this.token = token;
    }

    @Override
    protected Object onPreExecute(Object params) {

        //Create OAuth service
        service = new ServiceBuilder()
                .provider(HattrickAPI.class).apiKey(Hattrick.APIKEY)
                .apiSecret(Hattrick.APISECRET)
                .signatureType(SignatureType.Header).build();

        //Create custom URL
        hparams = (HattrickParam) params;
        String url = createHattrickURL(hparams);

        if(url != null){

            //Delete spaces
            return url.replace(" ", "%20");
        }

        return null;
    }

    @Override
    protected Object onExecute(Object param) {

        //Get custom URL
        String query = (String) param + Hattrick.SUPPORTER_OVERRIDE;
        Log.v(TAG, query);


        // Prepare request
        Token accessToken = new Token(token.getToken(), token.getSecret());

        OAuthRequest request = new OAuthRequest(Verb.GET,
                Hattrick.RESOURCESURL + query);
        service.signRequest(accessToken, request);

        //Get response
        Response response = request.send();

        return new CHPPResponse(response);
    }

    @Override
    protected Object onPostExecute(Object result) throws ParserException {

        //Check response
        CHPPResponse response = (CHPPResponse) result;
        String resp = response.getBody();
        if(resp != null) {
            Log.v(TAG, resp);
        }

        //Parse response

        HattrickParser hattrickParser = new HattrickParser();
        return hattrickParser.parse(hparams.getParserClass(), resp);

    }


    private String createHattrickURL(HattrickParam param){

        //Get Parser Class to apply correct URL
        Class classname = param.getParserClass();


        if (classname == Achievements.class) {
            int userID = 0;
            return "?file=achievements&version=1.1&userID="+userID;
        }

        if (classname == ArenaDetails.class) {
            int arenaID = (Integer) param.getObjectParam();
            return "?file=arenadetails&version=1.5&StatsType=&arenaID="+arenaID;
        }

        if (classname == MyArena.class) {
            return "?file=arenadetails&version=1.5&StatsType=MyArena&MatchType=All";
        }

        if (classname == Bookmarks.class) {
            return "fixtures/bookmarks.xml";
        }

        if (classname == Club.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=club&version=1.4&teamId="+teamID;
        }


        if (classname == CurrentBids.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=currentbids&version=1.0&actionType=view&teamId="+teamID;
        }

        //Economies
        if (classname == Economy.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=economy&version=1.3&teamId="+teamID;
        }

        //Fans
        if (classname == Fans.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=fans&version=1.2&teamId="+teamID;
        }

        if (classname == LeagueDetails.class) {
            int leagueLevelUnitID = (Integer) param.getObjectParam();
            return "?file=leaguedetails&version=1.4&leagueLevelUnitID="+leagueLevelUnitID;
        }

        //League
        if (classname == LeagueFixtures.class) {
            int leagueLevelUnitID = (Integer) param.getObjectParam();
            return "?file=leaguefixtures&version=1.2&leagueLevelUnitID="+leagueLevelUnitID;
        }

        // HT Live
        if (classname == Live.class) {

            HLiveParam query = (HLiveParam) param.getObjectParam();

            // View all events for all matches
            if (query.getActionType().equals(HLiveParam.VIEW_ALL)) {
                return "?file=live&version=1.8&actionType=viewAll&includeStartingLineup=false";

                // Add to tracker
            } else if (query.getActionType().equals(HLiveParam.ADD_MATCH)) {
                return "?file=live&version=1.8&actionType=addMatch&matchID="
                        + query.getMatchID() + "&sourceSystem="
                        + query.getSourceSystem()
                        + "&includeStartingLineup=false";

                // Remove live
            } else if (query.getActionType().equals(HLiveParam.DEL_MATCH)) {
                return "?file=live&version=1.8&actionType=deleteMatch&matchID="
                        + query.getMatchID() + "&sourceSystem="
                        + query.getSourceSystem()
                        + "&includeStartingLineup=false";
            }
            // New live
            else if (query.getActionType().equals(HLiveParam.VIEW_NEW)) {
                return "?file=live&version=1.8&actionType=viewNew&lastShownIndexes="
                        + query.getLastShowIndex();
            }
        }

        //Matches
        if (classname == Matches.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=matches&version=2.7&teamID="+teamID;
        }

        //Match detail
        if (classname == MatchDetails.class) {
            HMatchParam matchParam = (HMatchParam) param.getObjectParam();
            return "?file=matchdetails&version=2.6&matchEvents=true&matchID="+matchParam.getMatchID()+"&sourceSystem="+matchParam.getSourceSystem();
        }

        // Match lineup
        if (classname == MatchLineUp.class) {
            HMatchLineupParam matchParm = (HMatchLineupParam) param.getObjectParam();
            return "?file=matchlineup&version=1.8&matchID="+matchParm.getMatchID()+"&teamID="+matchParm.getTeamID();
        }

        // Manager compendium
        if (classname == ManagerCompendium.class) {
            int userID = (Integer) param.getObjectParam();
            if(userID > 0) {
                return "?file=managercompendium&version=1.0&userId=" + userID;
            }else
            {
                return "?file=managercompendium&version=1.0";
            }
        }

        // National teams
        if (classname == NationalTeams.class) {

            int LeagueOfficeTypeID = (Integer) param.getObjectParam();
            return "?file=nationalteams&version=1.5&LeagueOfficeTypeID="+LeagueOfficeTypeID;
        }

        // National team
        if (classname == NationalTeamDetails.class) {
            int nationTeamID = (Integer) param.getObjectParam();
            return "?file=nationalteamdetails&version=1.8&teamID="+nationTeamID;
        }

        // National team match
        if (classname == NationalTeamMatches.class) {
            int leagueOfficeTypeID = (Integer) param.getObjectParam();
            return "?file=nationalteammatches&version=1.3&LeagueOfficeTypeID="+leagueOfficeTypeID;
        }

        //Players
        if (classname == Players.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=players&version=2.3&actionType=view&teamID="+teamID+"&includeMatchInfo=true";
        }

        //Players details
        if (classname == PlayerDetails.class) {
            int playerID = (Integer) param.getObjectParam();
            return "?file=playerdetails&version=2.6&actionType=view&playerID="+playerID+"&includeMatchInfo=true";
        }

        // Avatars
        if (classname == PlayersAvatar.class) {
            return "fixtures/avatars.xml";
        }

        // Search
        if (classname == SearchResponse.class) {
            return "fixtures/search-teams.xml";
        }

        // Staff avatars
        if (classname == StaffsAvatar.class) {
            return "fixtures/staffavatars.xml";
        }

        //Staff list
        if (classname == StaffList.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=stafflist&version=1.0&teamId="+teamID;
        }

        //Team details
        if (classname == TeamDetails.class) {
            if(param.getObjectParam() == null){
                //My team(s)
                return "?file=teamdetails&version=3.2&includeDomesticFlags=true&includeFlags=true&includeSupporters=true";
            }
            else
            {
                int teamID = (Integer) param.getObjectParam();
                return "?file=teamdetails&version=3.2&includeDomesticFlags=true&includeFlags=true&includeSupporters=true&teamID="+teamID;
            }
        }

        //Training
        if (classname == Training.class) {
            return "fixtures/training.xml";
        }

        //Transfer Search
        if (classname == TransferSearch.class) {
            HTransfersSearch search = (HTransfersSearch) param.getObjectParam();
            return "?file=transfersearch&version=1.0"+search.getURL();
        }

        //Transfers
        if (classname == Transfers.class) {
            int teamID = (Integer) param.getObjectParam();
            return "?file=transfersteam&version=1.2&teamID="+teamID;
        }

        //World details
        if (classname == WorldDetails.class) {
            return "?file=worlddetails&version=1.6&includeRegions=true";
        }

        //World language
        if (classname == WorldLanguage.class) {
            return "?file=worldlanguages&version=1.2";
        }


        Log.e(TAG, "No PARAMS FOUND FOR CLASS:" + classname);
        return null;
    }

}
