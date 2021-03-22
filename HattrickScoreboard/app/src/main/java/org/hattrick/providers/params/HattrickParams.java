package org.hattrick.providers.params;

import android.util.Log;

import org.hattrick.models.achievements.Achievements;
import org.hattrick.models.arena.ArenaDetails;
import org.hattrick.models.avatar.PlayersAvatar;
import org.hattrick.models.avatar.StaffsAvatar;
import org.hattrick.models.bookmarks.Bookmarks;
import org.hattrick.models.club.Club;
import org.hattrick.models.economies.Economy;
import org.hattrick.models.fans.Fans;
import org.hattrick.models.leagues.LeagueDetails;
import org.hattrick.models.leagues.LeagueFixtures;
import org.hattrick.models.live.Live;
import org.hattrick.models.match.MatchDetails;
import org.hattrick.models.match.MatchLineUp;
import org.hattrick.models.matches.Matches;
import org.hattrick.models.players.Players;
import org.hattrick.models.search.SearchRequest;
import org.hattrick.models.search.SearchResponse;
import org.hattrick.models.staffs.StaffList;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.models.training.Training;
import org.hattrick.models.transfers.Transfers;
import org.hattrick.models.world.WorldDetails;
import org.hattrick.models.world.WorldLanguage;
import org.hattrick.providers.exceptions.HParamsProcessException;
import org.hattrickscoreboard.background.providers.IParams;

/**
 * @author Khips
 * @since 27 march 2014
 */
public class HattrickParams implements IParams {

    private static final String TAG = (HattrickParams.class).getSimpleName();

    private Class<?> classname;
    private Object object;

    @Override
    public Class<?> getResultClass() {
        return classname;
    }

    @Override
    public void setResultClass(Class<?> classname) {
        this.classname = classname;
    }

    @Override
    public void setResultClass(Object param, Class<?> classnameResult) {
        this.object = param;
        this.classname = classnameResult;
    }

    @Override
    public Object getObjectParam() {
        return object;
    }

    @Override
    public void setObjectParam(Object obj) {
        this.object = obj;
    }

    /**
     * Generate URL for request
     */
    @Override
    public String processParam() throws HParamsProcessException {
        String url = hattrickURL();
        return url.replace(" ", "%20");
    }

    private String hattrickURL() throws HParamsProcessException {
        if (classname == Achievements.class) {
            return "fixtures/achievements.xml";
        }

        if (classname == ArenaDetails.class) {
            HQuery obj = (HQuery) object;

            return "?file=arenadetails&version=1.5&StatsType=&arenaID="
                    + obj.getSubjectTeam().getArenaID();

        }

        if (classname == Bookmarks.class) {
            return "?file=bookmarks&version=1.0&BookmarkTypeID=1";
        }

        if (classname == Club.class) {
            HQuery obj = (HQuery) object;
            return "?file=club&version=1.4&teamId=" + obj.getTeamID();
        }

        if (classname == LeagueDetails.class) {

            HQuery obj = (HQuery) object;
            // return "?file=leaguedetails&version=1.4";
            return "?file=leaguedetails&version=1.4&leagueLevelUnitID="
                    + obj.getSubjectTeam().getLeagueLevelUnitID();
        }

        // HT Live
        if (classname == Live.class) {

            HLiveQuery query = (HLiveQuery) object;

            // View all events for all matches
            if (query.getActionType().equals(HLiveQuery.VIEW_ALL)) {
                return "?file=live&version=1.8&actionType=viewAll&includeStartingLineup=false";

                // Add to tracker
            } else if (query.getActionType().equals(HLiveQuery.ADD_MATCH)) {
                return "?file=live&version=1.8&actionType=addMatch&matchID="
                        + query.getMatchID() + "&sourceSystem="
                        + query.getSourceSystem()
                        + "&includeStartingLineup=false";

                // Remove live
            } else if (query.getActionType().equals(HLiveQuery.DEL_MATCH)) {
                return "?file=live&version=1.8&actionType=deleteMatch&matchID="
                        + query.getMatchID() + "&sourceSystem="
                        + query.getSourceSystem()
                        + "&includeStartingLineup=false";
            }
            // New live
            else if (query.getActionType().equals(HLiveQuery.VIEW_NEW)) {
                return "?file=live&version=1.8&actionType=viewNew&lastShownIndexes="
                        + query.getLastShowIndex();
            }
        }

        // Match lineup
        if (classname == MatchLineUp.class) {

            HQuery obj = (HQuery) object;
            HMatchQuery query = (HMatchQuery) obj.getCustomObject();

            return "?file=matchlineup&version=1.8&matchID="
                    + query.getMatchID() + "&teamID=" + obj.getTeamID()
                    + "&sourceSystem=" + query.getSourceSystem();
        }

        // Avatars
        if (classname == PlayersAvatar.class) {

            HQuery obj = (HQuery) object;

            return "?file=avatars&version=1.1&actionType=players&teamId="
                    + obj.getTeamID();
        }

        // Staff avatars
        if (classname == StaffsAvatar.class) {

            HQuery obj = (HQuery) object;

            return "?file=staffavatars&version=1.0&teamId=" + obj.getTeamID();
        }

        if (classname == TeamDetails.class) {
            HQuery obj = (HQuery) object;
            if (obj == null) {
                return "?file=teamdetails&version=3.2&includeDomesticFlags=true&includeFlags=true&includeSupporters=true";
            } else {
                return "?file=teamdetails&version=3.2&teamID="
                        + obj.getTeamID()
                        + "&includeDomesticFlags=true&includeFlags=true&includeSupporters=true";
            }
        }
        if (classname == StaffList.class) {
            HQuery obj = (HQuery) object;
            return "?file=stafflist&version=1.0&teamId=" + obj.getTeamID();
        }

        // Search
        if (classname == SearchResponse.class) {

            SearchRequest req = (SearchRequest) object;

            int searchType = req.getSearchType();
            String path = "?file=search&version=1.2&searchType=" + searchType;

            // Search with name or ID
            if (searchType == 1 || searchType == 2 || searchType == 3
                    || searchType == 4 || searchType == 5 || searchType == 6) {
                String searchString = req.getSearchString();
                if (searchString != null)
                    path += "&searchString=" + searchString;
                else
                    path += "&searchID=" + req.getSearchID();
                return path;
            }

            // Players
            if (searchType == 0) {

                String searchFirstName = req.getSearchString();
                String searchLastName = req.getSearchString2();

                if (searchFirstName != null && searchLastName != null) {
                    path += "&searchString=" + searchFirstName
                            + "&searchString2=" + searchLastName;
                } else {
                    path += "&searchID=" + req.getSearchID();
                }
                return path;
            }

            return path;
        }

        if (classname == Economy.class) {
            HQuery obj = (HQuery) object;
            return "?file=economy&version=1.3&teamId=" + obj.getTeamID();
        }

        if (classname == Fans.class) {
            HQuery obj = (HQuery) object;
            return "?file=fans&version=1.2&teamId=" + obj.getTeamID();
        }

        if (classname == LeagueFixtures.class) {
            HQuery obj = (HQuery) object;
            return "?file=leaguefixtures&version=1.2&leagueLevelUnitID="
                    + obj.getSubjectTeam().getLeagueLevelUnitID();
            // TODO
            // return
            // "?file=leaguefixtures&version=1.2&leagueLevelUnitID="+level+"&season="+saison;
        }

        if (classname == Matches.class) {
            HQuery obj = (HQuery) object;

            return "?file=matches&version=2.7&teamID=" + obj.getTeamID();

            // TODO
            // youth team
            // return "?file=matches&version=2.7&teamID=177237&isYouth=true";
        }

        if (classname == MatchDetails.class) {
            HMatchQuery query = (HMatchQuery) object;
            return "?file=matchdetails&version=2.5&matchEvents="
                    + query.isEvent() + "&matchID=" + query.getMatchID()
                    + "&sourceSystem=" + query.getSourceSystem();
        }

        if (classname == Players.class) {
            HQuery obj = (HQuery) object;
            return "?file=players&version=2.3&actionType=view&teamID="
                    + obj.getTeamID() + "&includeMatchInfo=true";
        }

        if (classname == Training.class) {
            HQuery obj = (HQuery) object;

            // View
            return "?file=training&version=2.2&actionType=view&teamId="
                    + obj.getTeamID();

            // TODO
            // Stats & setTraining
        }

        if (classname == Transfers.class) {
            HQuery obj = (HQuery) object;
            // TODO
            // Page index...
            int page = 1;
            return "?file=transfersteam&version=1.2&teamID=" + obj.getTeamID()
                    + "&pageIndex=" + page;
        }

        if (classname == WorldDetails.class) {
            return "?file=worlddetails&version=1.6&includeRegions=false";
        }

        if (classname == WorldLanguage.class) {
            return "?file=worldlanguages&version=1.2";
        }

        Log.e(TAG, "No PARAMS FOUND FOR :" + classname);
        throw new HParamsProcessException();
    }
}
