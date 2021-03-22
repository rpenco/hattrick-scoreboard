package org.hattrickscoreboardl.release.hattrick.models;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.models.achievements.Achievements;
import org.hattrick.models.alliances.AllianceDetails;
import org.hattrick.models.arenas.ArenaDetails;
import org.hattrick.models.avatars.PlayersAvatar;
import org.hattrick.models.avatars.StaffsAvatar;
import org.hattrick.models.bookmarks.Bookmarks;
import org.hattrick.models.challenges.Challenges;
import org.hattrick.models.clubs.Club;
import org.hattrick.models.cups.CupMatches;
import org.hattrick.models.economies.Economy;
import org.hattrick.models.fans.Fans;
import org.hattrick.models.hofplayers.HoFPlayers;
import org.hattrick.models.ladders.LadderDetails;
import org.hattrick.models.leagues.LeagueDetails;
import org.hattrick.models.leagues.LeagueFixtures;
import org.hattrick.models.managers.ManagerCompendium;
import org.hattrick.models.match.MatchDetails;
import org.hattrick.models.match.MatchLineUp;
import org.hattrick.models.matches.Matches;
import org.hattrick.models.matches.MatchesArchive;
import org.hattrick.models.matchorders.MatchOrders;
import org.hattrick.models.national.NationalTeamDetails;
import org.hattrick.models.national.NationalTeamMatches;
import org.hattrick.models.national.NationalTeamPlayers;
import org.hattrick.models.national.NationalTeamPlayersStats;
import org.hattrick.models.national.NationalTeams;
import org.hattrick.models.players.PlayerEvents;
import org.hattrick.models.players.Players;
import org.hattrick.models.regions.RegionDetails;
import org.hattrick.models.staffs.StaffList;
import org.hattrick.models.supporters.SupportedTeams;
import org.hattrick.models.supporters.SupporterTeams;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.models.tournaments.TournamentDetails;
import org.hattrick.models.tournaments.TournamentFixtures;
import org.hattrick.models.tournaments.TournamentLeagues;
import org.hattrick.models.tournaments.Tournaments;
import org.hattrick.models.training.Training;
import org.hattrick.models.training.TrainingEvents;
import org.hattrick.models.world.WorldDetails;
import org.hattrick.models.world.WorldLanguage;
import org.hattrick.models.worldcup.WorldCup;
import org.hattrick.models.worldcup.WorldGroups;
import org.hattrick.models.youth.YouthLeagueDetails;
import org.hattrick.models.youth.YouthLeagueFixtures;
import org.hattrick.models.youth.YouthPlayerDetails;
import org.hattrick.models.youth.YouthPlayers;
import org.hattrick.models.youth.YouthTeamDetails;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrickscoreboardl.utils.Hattrick;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class HattrickModelsParserTest extends InstrumentationTestCase{

    HattrickParser parser;
    String PATH = "test/release/hattrick/models/";
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //Init parser
        parser = new HattrickParser();
    }

    public void testAchievementsParser() throws ParserException {
        Achievements res = parser.parse(Achievements.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "achievements", "achievements"));
        Assert.assertNotNull(res);
    }

    public void testAllianceDetailsParser() throws ParserException {
        AllianceDetails res = parser.parse(AllianceDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "alliances", "alliancedetails"));
        Assert.assertNotNull(res);
    }

    public void testArenaParser() throws ParserException {
        ArenaDetails res = parser.parse(ArenaDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "arenas", "arenadetails"));
        Assert.assertNotNull(res);
    }

    public void testAvatarParser() throws ParserException {
        PlayersAvatar res = parser.parse(PlayersAvatar.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "avatars", "avatars"));
        Assert.assertNotNull(res);
    }

    public void testBookmarksParser() throws ParserException {
        Bookmarks res = parser.parse(Bookmarks.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "bookmarks", "bookmarks"));
        Assert.assertNotNull(res);
    }

    public void testChallengesParser() throws ParserException {

        //Default
        Challenges res = parser.parse(Challenges.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "challenges", "challenges-view"));
        Assert.assertNotNull(res);

        //Empty
        res = parser.parse(Challenges.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "challenges", "challenges-empty"));
        Assert.assertNotNull(res);
    }

    public void testClubParser() throws ParserException {
        Club res = parser.parse(Club.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "clubs", "club"));
        Assert.assertNotNull(res);
    }

    public void testCupMatchesParser() throws ParserException {

        //Default
        CupMatches res = parser.parse(CupMatches.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "cups", "cupmatches"));
        Assert.assertNotNull(res);

        //Others
        res = parser.parse(CupMatches.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "cups", "cupmatches-1-27-14"));
        Assert.assertNotNull(res);

        res = parser.parse(CupMatches.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "cups", "cupmatches-1-28-1"));
        Assert.assertNotNull(res);

        res = parser.parse(CupMatches.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "cups", "cupmatches-1-28-1-59348179"));
        Assert.assertNotNull(res);
    }

    public void testEconomyParser() throws ParserException {
        Economy res = parser.parse(Economy.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "economies", "economy"));
        Assert.assertNotNull(res);
    }

    public void testFansParser() throws ParserException {
        Fans res = parser.parse(Fans.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "fans", "fans"));
        Assert.assertNotNull(res);
    }

    public void testHoFPlayersParser() throws ParserException {
        HoFPlayers res = parser.parse(HoFPlayers.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "hofplayers", "hofplayers"));
        Assert.assertNotNull(res);
    }

    public void testLadderDetailsParser() throws ParserException {
        LadderDetails res = parser.parse(LadderDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "ladders", "ladderdetails"));
        Assert.assertNotNull(res);
    }

    public void testLeagueDetailsParser() throws ParserException {
        LeagueDetails res = parser.parse(LeagueDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "leagues", "leaguedetails"));
        Assert.assertNotNull(res);
    }

    public void testLeagueFixturesParser() throws ParserException {
        LeagueFixtures res = parser.parse(LeagueFixtures.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "leagues", "leaguefixtures"));
        Assert.assertNotNull(res);
    }

    public void testManagerCompendiumParser() throws ParserException {

        //Default
        ManagerCompendium res = parser.parse(ManagerCompendium.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "managers", "managercompendium"));
        Assert.assertNotNull(res);

        //Other
        res = parser.parse(ManagerCompendium.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "managers", "managercompendium-1531275"));
        Assert.assertNotNull(res);

        res = parser.parse(ManagerCompendium.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "managers", "managercompendium-6714957"));
        Assert.assertNotNull(res);

    }

    public void testMatchesParser() throws ParserException {
        Matches res = parser.parse(Matches.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "matches", "matches"));
        Assert.assertNotNull(res);
    }


    public void testMatchesArchiveParser() throws ParserException {

        //Default
        MatchesArchive res = parser.parse(MatchesArchive.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "matches", "matchesarchive"));
        Assert.assertNotNull(res);

        //Other
        res = parser.parse(MatchesArchive.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "matches", "matchesarchive-2"));
        Assert.assertNotNull(res);

        res = parser.parse(MatchesArchive.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "matches", "matchesarchive-3"));
        Assert.assertNotNull(res);

        res = parser.parse(MatchesArchive.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "matches", "matchesarchive-4"));
        Assert.assertNotNull(res);

    }

    public void testMatchDetailsParser() throws ParserException {
        MatchDetails res = parser.parse(MatchDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "match", "matchdetails"));
        Assert.assertNotNull(res);
    }

    public void testMatchLineupParser() throws ParserException {
        MatchLineUp res = parser.parse(MatchLineUp.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "match", "matchlineup"));
        Assert.assertNotNull(res);
    }

    public void testMatchOrdersParser() throws ParserException {

        //Default
        MatchOrders res = parser.parse(MatchOrders.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "matchorders", "matchorders"));
        Assert.assertNotNull(res);

        //Other
        res = parser.parse(MatchOrders.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "matchorders", "matchorders-empty"));
        Assert.assertNotNull(res);

    }

    public void testNationalTeamsParser() throws ParserException {
        NationalTeams res = parser.parse(NationalTeams.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "national", "nationalteams"));
        Assert.assertNotNull(res);

        //Other
        res = parser.parse(NationalTeams.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "national", "nationalteams-u20"));
        Assert.assertNotNull(res);
    }

    public void testNationalTeamDetailsParser() throws ParserException {
        NationalTeamDetails res = parser.parse(NationalTeamDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "national", "nationalteamdetails"));
        Assert.assertNotNull(res);
    }

    public void testNationalTeamMatchesParser() throws ParserException {
        NationalTeamMatches res = parser.parse(NationalTeamMatches.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "national", "nationalteammatches"));
        Assert.assertNotNull(res);
    }

    public void testNationalPlayersParser() throws ParserException {
        NationalTeamPlayers res = parser.parse(NationalTeamPlayers.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "national", "nationalplayers"));
        Assert.assertNotNull(res);

        //Other Supporters Only
        NationalTeamPlayersStats res2 = parser.parse(NationalTeamPlayersStats.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "national", "nationalteamdetails-supportersdetails"));
        Assert.assertNotNull(res2);
    }

    //PLAYER DETAILS !!


    public void testPlayersParser() throws ParserException {
        Players res = parser.parse(Players.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "players", "players"));
        Assert.assertNotNull(res);
    }

    public void testPlayerEventsParser() throws ParserException {
        PlayerEvents res = parser.parse(PlayerEvents.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "players", "playerevents"));
        Assert.assertNotNull(res);
    }

    public void testRegionDetailsParser() throws ParserException {
        RegionDetails res = parser.parse(RegionDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "regions", "regiondetails"));
        Assert.assertNotNull(res);
    }

    //SEARCH !!!


    public void testStaffAvatarParser() throws ParserException {
        StaffsAvatar res = parser.parse(StaffsAvatar.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "avatars", "staffavatars"));
        Assert.assertNotNull(res);
    }

    public void testStaffListParser() throws ParserException {
        StaffList res = parser.parse(StaffList.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "staffs", "stafflist"));
        Assert.assertNotNull(res);
    }


    public void testSupportedTeamsParser() throws ParserException {
        SupportedTeams res = parser.parse(SupportedTeams.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "supporters", "supporters"));
        Assert.assertNotNull(res);

        //Others
        res = parser.parse(SupportedTeams.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "supporters", "supporters-empty"));
        Assert.assertNotNull(res);
    }

    public void testMySupportedTeamsParser() throws ParserException {
        SupporterTeams res = parser.parse(SupporterTeams.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "supporters", "mysupporters"));
        Assert.assertNotNull(res);

        //Others
        res = parser.parse(SupporterTeams.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "supporters", "mysupporters-empty"));
        Assert.assertNotNull(res);
    }

    public void testTeamDetailsParser() throws ParserException {
        TeamDetails res = parser.parse(TeamDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "teams", "teamdetails"));
        Assert.assertNotNull(res);

        //Others team
        res = parser.parse(TeamDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "teams", "teamdetails-198547"));
        Assert.assertNotNull(res);

        res = parser.parse(TeamDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "teams", "teamdetails-936331"));
        Assert.assertNotNull(res);

        res = parser.parse(TeamDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "teams", "teamdetails-bot"));
        Assert.assertNotNull(res);

    }

    public void testTournamentDetailsParser() throws ParserException {
        TournamentDetails res = parser.parse(TournamentDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "tournaments", "tournamentdetails"));
        Assert.assertNotNull(res);
    }

    public void testTournamentFixturesParser() throws ParserException {
        TournamentFixtures res = parser.parse(TournamentFixtures.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "tournaments", "tournamentfixtures"));
        Assert.assertNotNull(res);
    }

    public void testTournamentLeaguesParser() throws ParserException {
        TournamentLeagues res = parser.parse(TournamentLeagues.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "tournaments", "tournamentleaguetables"));
        Assert.assertNotNull(res);
    }

    public void testTournamentsParser() throws ParserException {
        Tournaments res = parser.parse(Tournaments.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "tournaments", "tournamentlist"));
        Assert.assertNotNull(res);
    }

    public void testTrainingDetailsParser() throws ParserException {
        Training res = parser.parse(Training.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "training", "training"));
        Assert.assertNotNull(res);
    }


    public void testTrainingEventsParser() throws ParserException {
        TrainingEvents res = parser.parse(TrainingEvents.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "training", "trainingevents"));
        Assert.assertNotNull(res);
    }

    // Transfers !!

    public void testWorldCupParser() throws ParserException {
        WorldCup res = parser.parse(WorldCup.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "worldcup", "worldcup"));
        Assert.assertNotNull(res);

        WorldGroups res2 = parser.parse(WorldGroups.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "worldcup", "worldcup-viewgroups"));
        Assert.assertNotNull(res2);
    }


    public void testWorldDetailsParser() throws ParserException {
        WorldDetails res = parser.parse(WorldDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "world", "worlddetails"));
        Assert.assertNotNull(res);
    }

    public void testWorldLanguageParser() throws ParserException {
        WorldLanguage res = parser.parse(WorldLanguage.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "world", "worldlanguages"));
        Assert.assertNotNull(res);
    }

    public void testYouthLeagueDetailsParser() throws ParserException {
        YouthLeagueDetails res = parser.parse(YouthLeagueDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "youth", "youthleaguedetails"));
        Assert.assertNotNull(res);
    }

    public void testYouthLeagueFixturesParser() throws ParserException {
        YouthLeagueFixtures res = parser.parse(YouthLeagueFixtures.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "youth", "youthleaguefixtures"));
        Assert.assertNotNull(res);
    }

    public void testYouthPlayersParser() throws ParserException {
        YouthPlayers res = parser.parse(YouthPlayers.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "youth", "youthplayerlist"));
        Assert.assertNotNull(res);
    }


    public void testYouthPlayerDetailsParser() throws ParserException {
        YouthPlayerDetails res = parser.parse(YouthPlayerDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "youth", "youthplayerdetails"));
        Assert.assertNotNull(res);
    }

    public void testYouthTeamDetailsParser() throws ParserException {
        YouthTeamDetails res = parser.parse(YouthTeamDetails.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "youth", "youthteamdetails"));
        Assert.assertNotNull(res);
    }
}
