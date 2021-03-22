package org.hattrickscoreboardl.debug.teams;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.models.achievements.Achievements;
import org.hattrick.models.arenas.ArenaDetails;
import org.hattrick.models.avatars.PlayersAvatar;
import org.hattrick.models.hofplayers.HoFPlayers;
import org.hattrick.models.ladders.LadderDetails;
import org.hattrick.models.leagues.LeagueDetails;
import org.hattrick.models.leagues.LeagueFixtures;
import org.hattrick.models.managers.ManagerCompendium;
import org.hattrick.models.matches.Matches;
import org.hattrick.models.matches.MatchesArchive;
import org.hattrick.models.players.Players;
import org.hattrick.models.supporters.SupportedTeams;
import org.hattrick.models.supporters.SupporterTeams;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.models.youth.YouthLeagueDetails;
import org.hattrick.models.youth.YouthLeagueFixtures;
import org.hattrick.models.youth.YouthPlayers;
import org.hattrick.models.youth.YouthTeamDetails;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by romain on 30/10/2014.
 */
public class HattrickTeam2385695ParserTest extends InstrumentationTestCase{

    static int TEAMID = 2385695;
    HattrickParser parser;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //Init parser
        parser = new HattrickParser();
    }

    String loadFixture(String name){
        try {
            InputStream stream = getInstrumentation().getTargetContext().getResources().getAssets().open("test/release/hattrick/models/others/teams/" +TEAMID+"/"+name + ".xml");
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

    public void testAchievementsParser() throws ParserException {
        Achievements res = parser.parse(Achievements.class, loadFixture("achievements"));
        Assert.assertNotNull(res);
    }

//    public void testAllianceDetailsParser() throws ParserException {
//        AllianceDetails res = parser.parse(AllianceDetails.class, loadFixtureXML("alliancedetails"));
//        Assert.assertNotNull(res);
//    }

    public void testArenaParser() throws ParserException {
        ArenaDetails res = parser.parse(ArenaDetails.class, loadFixture("arena"));
        Assert.assertNotNull(res);
    }

    public void testAvatarParser() throws ParserException {
        PlayersAvatar res = parser.parse(PlayersAvatar.class, loadFixture("avatars"));
        Assert.assertNotNull(res);
    }

//    public void testBookmarksParser() throws ParserException {
//        Bookmarks res = parser.parse(Bookmarks.class, loadFixtureXML("bookmarks"));
//        Assert.assertNotNull(res);
//    }

//    public void testChallengesParser() throws ParserException {
//        Challenges res = parser.parse(Challenges.class, loadFixtureXML("challenges-view"));
//        Assert.assertNotNull(res);
//    }

//    public void testClubParser() throws ParserException {
//        Club res = parser.parse(Club.class, loadFixtureXML("club"));
//        Assert.assertNotNull(res);
//    }

//    public void testCupMatchesParser() throws ParserException {
//        CupMatches res = parser.parse(CupMatches.class, loadFixtureXML("cupmatches"));
//        Assert.assertNotNull(res);
//    }

//    public void testEconomyParser() throws ParserException {
//        Economy res = parser.parse(Economy.class, loadFixtureXML("economy"));
//        Assert.assertNotNull(res);
//    }

//    public void testFansParser() throws ParserException {
//        Fans res = parser.parse(Fans.class, loadFixtureXML("fans"));
//        Assert.assertNotNull(res);
//    }

    public void testHoFPlayersParser() throws ParserException {
        HoFPlayers res = parser.parse(HoFPlayers.class, loadFixture("hofplayers"));
        Assert.assertNotNull(res);
    }

    public void testLadderDetailsParser() throws ParserException {
        LadderDetails res = parser.parse(LadderDetails.class, loadFixture("ladderdetails"));
        Assert.assertNotNull(res);
    }

    public void testLeagueDetailsParser() throws ParserException {
        LeagueDetails res = parser.parse(LeagueDetails.class, loadFixture("leaguedetails"));
        Assert.assertNotNull(res);
    }

    public void testLeagueFixturesParser() throws ParserException {
        LeagueFixtures res = parser.parse(LeagueFixtures.class, loadFixture("leaguefixtures"));
        Assert.assertNotNull(res);
    }

    public void testManagerCompendiumParser() throws ParserException {
        ManagerCompendium res = parser.parse(ManagerCompendium.class, loadFixture("managercompendium"));
        Assert.assertNotNull(res);
    }

    public void testMatchesParser() throws ParserException {
        Matches res = parser.parse(Matches.class, loadFixture("matches"));
        Assert.assertNotNull(res);
    }


    public void testMatchesArchiveParser() throws ParserException {
        MatchesArchive res = parser.parse(MatchesArchive.class, loadFixture("matchesarchive"));
        Assert.assertNotNull(res);
    }

//    public void testMatchDetailsParser() throws ParserException {
//        MatchDetails res = parser.parse(MatchDetails.class, loadFixtureXML("matchdetails"));
//        Assert.assertNotNull(res);
//    }

//    public void testMatchLineupParser() throws ParserException {
//        MatchLineUp res = parser.parse(MatchLineUp.class, loadFixtureXML("matchlineup"));
//        Assert.assertNotNull(res);
//    }

//    public void testMatchOrdersParser() throws ParserException {
//        MatchOrders res = parser.parse(MatchOrders.class, loadFixtureXML("matchorders"));
//        Assert.assertNotNull(res);
//    }

//    public void testNationalTeamsParser() throws ParserException {
//        NationalTeams res = parser.parse(NationalTeams.class, loadFixtureXML("nationalteams"));
//        Assert.assertNotNull(res);
//    }

//    public void testNationalTeamDetailsParser() throws ParserException {
//        NationalTeamDetails res = parser.parse(NationalTeamDetails.class, loadFixtureXML("nationalteamdetails"));
//        Assert.assertNotNull(res);
//    }

//    public void testNationalTeamMatchesParser() throws ParserException {
//        NationalTeamMatches res = parser.parse(NationalTeamMatches.class, loadFixtureXML("nationalteammatches"));
//        Assert.assertNotNull(res);
//    }

//    public void testNationalPlayersParser() throws ParserException {
//        NationalTeamPlayers res = parser.parse(NationalTeamPlayers.class, loadFixtureXML("nationalplayers"));
//        Assert.assertNotNull(res);
//    }

    //PLAYER DETAILS !!


    public void testPlayersParser() throws ParserException {
        Players res = parser.parse(Players.class, loadFixture("players"));
        Assert.assertNotNull(res);
    }

//    public void testPlayerEventsParser() throws ParserException {
//        PlayerEvents res = parser.parse(PlayerEvents.class, loadFixtureXML("playerevents"));
//        Assert.assertNotNull(res);
//    }

//    public void testRegionDetailsParser() throws ParserException {
//        RegionDetails res = parser.parse(RegionDetails.class, loadFixtureXML("regiondetails"));
//        Assert.assertNotNull(res);
//    }

    //SEARCH !!!


//    public void testStaffAvatarParser() throws ParserException {
//        StaffsAvatar res = parser.parse(StaffsAvatar.class, loadFixtureXML("staffavatars"));
//        Assert.assertNotNull(res);
//    }

//    public void testStaffListParser() throws ParserException {
//        StaffList res = parser.parse(StaffList.class, loadFixtureXML("stafflist"));
//        Assert.assertNotNull(res);
//    }


    public void testSupportedTeamsParser() throws ParserException {
        SupportedTeams res = parser.parse(SupportedTeams.class, loadFixture("supported"));
        Assert.assertNotNull(res);
    }

    public void testMySupportedTeamsParser() throws ParserException {
        SupporterTeams res = parser.parse(SupporterTeams.class, loadFixture("supporters"));
        Assert.assertNotNull(res);

    }

    public void testTeamDetailsParser() throws ParserException {
        TeamDetails res = parser.parse(TeamDetails.class, loadFixture("teamdetails"));
        Assert.assertNotNull(res);

    }

//    public void testTournamentDetailsParser() throws ParserException {
//        TournamentDetails res = parser.parse(TournamentDetails.class, loadFixtureXML("tournamentdetails"));
//        Assert.assertNotNull(res);
//    }
//
//    public void testTournamentFixturesParser() throws ParserException {
//        TournamentFixtures res = parser.parse(TournamentFixtures.class, loadFixtureXML("tournamentfixtures"));
//        Assert.assertNotNull(res);
//    }
//
//    public void testTournamentLeaguesParser() throws ParserException {
//        TournamentLeagues res = parser.parse(TournamentLeagues.class, loadFixtureXML("tournamentleaguetables"));
//        Assert.assertNotNull(res);
//    }
//
//    public void testTournamentsParser() throws ParserException {
//        Tournaments res = parser.parse(Tournaments.class, loadFixtureXML("tournamentlist"));
//        Assert.assertNotNull(res);
//    }
//
//    public void testTrainingDetailsParser() throws ParserException {
//        Training res = parser.parse(Training.class, loadFixtureXML("training"));
//        Assert.assertNotNull(res);
//    }
//
//
//    public void testTrainingEventsParser() throws ParserException {
//        TrainingEvents res = parser.parse(TrainingEvents.class, loadFixtureXML("trainingevents"));
//        Assert.assertNotNull(res);
//    }
//
//    // Transfers !!
//
//    public void testWorldCupParser() throws ParserException {
//        WorldCup res = parser.parse(WorldCup.class, loadFixtureXML("worldcup"));
//        Assert.assertNotNull(res);
//
//        WorldGroups res2 = parser.parse(WorldGroups.class, loadFixtureXML("worldcup-viewgroups"));
//        Assert.assertNotNull(res2);
//    }
//
//
//    public void testWorldDetailsParser() throws ParserException {
//        WorldDetails res = parser.parse(WorldDetails.class, loadFixtureXML("worlddetails"));
//        Assert.assertNotNull(res);
//    }
//
//    public void testWorldLanguageParser() throws ParserException {
//        WorldLanguage res = parser.parse(WorldLanguage.class, loadFixtureXML("worldlanguages"));
//        Assert.assertNotNull(res);
//    }

    public void testYouthMatchesParser() throws ParserException {
        Matches res = parser.parse(Matches.class, loadFixture("youth-matches"));
        Assert.assertNotNull(res);
    }

    public void testYouthMatchesArchiveParser() throws ParserException {
        MatchesArchive res = parser.parse(MatchesArchive.class, loadFixture("youth-matchesarchive"));
        Assert.assertNotNull(res);
    }

    public void testYouthLeagueDetailsParser() throws ParserException {
        YouthLeagueDetails res = parser.parse(YouthLeagueDetails.class, loadFixture("youthleaguedetails"));
        Assert.assertNotNull(res);
    }

    public void testYouthLeagueFixturesParser() throws ParserException {
        YouthLeagueFixtures res = parser.parse(YouthLeagueFixtures.class, loadFixture("youthleaguefixtures"));
        Assert.assertNotNull(res);
    }

    public void testYouthPlayersParser() throws ParserException {
        YouthPlayers res = parser.parse(YouthPlayers.class, loadFixture("youthplayerlist"));
        Assert.assertNotNull(res);
    }

    public void testYouthPlayersDetailsParser() throws ParserException {
        YouthPlayers res = parser.parse(YouthPlayers.class, loadFixture("youthplayerdetails"));
        Assert.assertNotNull(res);
    }


    public void testYouthTeamDetailsParser() throws ParserException {
        YouthTeamDetails res = parser.parse(YouthTeamDetails.class, loadFixture("youthteamdetails"));
        Assert.assertNotNull(res);
    }
}
