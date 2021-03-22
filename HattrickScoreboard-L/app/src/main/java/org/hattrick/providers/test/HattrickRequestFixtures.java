package org.hattrick.providers.test;

import android.content.Context;
import android.util.Log;

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
import org.hattrick.models.match.MatchDetails;
import org.hattrick.models.match.MatchLineUp;
import org.hattrick.models.matches.Matches;
import org.hattrick.models.players.Players;
import org.hattrick.models.search.SearchResponse;
import org.hattrick.models.staffs.StaffList;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.models.training.Training;
import org.hattrick.models.transfers.Transfers;
import org.hattrick.models.world.WorldDetails;
import org.hattrick.models.world.WorldLanguage;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrick.providers.exceptions.ParserException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.HattrickAPI;
import org.scribe.model.OAuthRequest;
import org.scribe.model.SignatureType;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Like asyncTask...
 * TEST ASSET XML FILE!
 * @author Khips
 * @since 28 mars 2014
 */
public class HattrickRequestFixtures extends IRequest {

    static final String TAG = (HattrickRequestFixtures.class).getSimpleName();

    private CHPPToken token;
    private OAuthService service;
    private HattrickParam hparams;

    public HattrickRequestFixtures(Context ctx, CHPPToken token) {
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
        String query = (String) param;
        if(query != null)
            Log.v(TAG, query);


        // Prepare request
        Token accessToken = new Token(token.getToken(), token.getSecret());
        OAuthRequest request = new OAuthRequest(Verb.GET,
                Hattrick.RESOURCESURL + query);
        service.signRequest(accessToken, request);

        ///////////////////////////////////
        ///!\ FAKE RESPONSE
        return query;
        ///////////////////////////////////

    }

    @Override
    protected Object onPostExecute(Object result) {

        ///!\ FAKE RESPONSE
        String resp = load((String) result);
        if(resp != null)
            Log.v(TAG, resp);

        ///////////////////////////////////

        //Parse response
        try {

            HattrickParser hattrickParser = new HattrickParser();
            return hattrickParser.parse(hparams.getParserClass(), resp);

        }catch (ParserException e){
            e.printStackTrace();
            return null;
        }
    }

    String load(String filename){
        try {
            InputStream stream = getContext().getResources().getAssets().open(filename);
            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(stream));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String createHattrickURL(HattrickParam param){

        //Get Parser Class to apply correct URL
        Class classname = param.getParserClass();

        if (classname == Achievements.class) {
            return "fixtures/achievements.xml";
        }

        if (classname == ArenaDetails.class) {
            return "fixtures/arenadetails.xml";
        }

        if (classname == Bookmarks.class) {
            return "fixtures/bookmarks.xml";
        }

        if (classname == Club.class) {
            return "fixtures/club.xml";
        }

        //Economies
        if (classname == Economy.class) {
            return "fixtures/economy.xml";
        }

        //Fans
        if (classname == Fans.class) {
            return "fixtures/fans.xml";
        }

        if (classname == LeagueDetails.class) {
            return "fixtures/leaguedetails.xml";
        }

        //League listbutton.fixtures
        if (classname == LeagueFixtures.class) {
            return "fixtures/leaguefixtures.xml";
        }

        //Matches
        if (classname == Matches.class) {
            return "fixtures/matches.xml";
        }

        //Match detail
        if (classname == MatchDetails.class) {
            return "fixtures/matchdetails.xml";
        }

        // Match lineup
        if (classname == MatchLineUp.class) {
            return "fixtures/matchlineup.xml";
        }

        // My Arena
        if (classname == MyArena.class) {
            return "fixtures/myarena.xml";
        }

        //Players
        if (classname == Players.class) {
            return "fixtures/players.xml";
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
            return "fixtures/stafflist.xml";
        }

        //Team details
        if (classname == TeamDetails.class) {
            return "fixtures/teamdetails.xml";
        }

        //Training
        if (classname == Training.class) {
            return "fixtures/training.xml";
        }

        //Transfers
        if (classname == Transfers.class) {
            return "fixtures/transfersteam.xml";
        }

        //World details
        if (classname == WorldDetails.class) {
            return "fixtures/worlddetails.xml";
        }

        //World language
        if (classname == WorldLanguage.class) {
            return "fixtures/worldlanguages.xml";
        }


        Log.e(TAG, "No PARAMS FOUND FOR CLASS:" + classname);
        return null;
    }

}
