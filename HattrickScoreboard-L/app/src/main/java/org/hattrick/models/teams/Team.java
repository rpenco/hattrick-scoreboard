package org.hattrick.models.teams;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class Team {

    @Element
    int TeamID;

    @Element
    String TeamName;

    @Element
    String ShortTeamName;

    @Element
    boolean IsPrimaryClub;

    @Element
    String FoundedDate;

    @Element
    @Path("Arena")
    int ArenaID;

    @Element
    @Path("Arena")
    String ArenaName;

    @Element
    @Path("League")
    int LeagueID;

    @Element
    @Path("League")
    String LeagueName;

    @Element
    @Path("Region")
    int RegionID;

    @Element
    @Path("Region")
    String RegionName;

    @Element(name = "PlayerID")
    @Path("Trainer")
    int TrainerID;

    @Element(required = false)
    String HomePage;

    @Element
    String DressURI;

    @Element
    String DressAlternateURI;

    @Element(required = false)
    @Path("LeagueLevelUnit")
    int LeagueLevelUnitID;

    @Element(required = false)
    @Path("LeagueLevelUnit")
    String LeagueLevelUnitName;

    @Element(required = false)
    @Path("LeagueLevelUnit")
    int LeagueLevel;

    @Element(name = "IsBot")
    @Path("BotStatus")
    boolean bot;

    @Element(required = false)
    @Path("BotStatus")
    String BotSince;

    @Element(required = false)
    @Path("Cup")
    boolean StillInCup;

    @Element(required = false)
    @Path("Cup")
    int CupID;

    @Element(required = false)
    @Path("Cup")
    String CupName;


    @Element(required = false)
    @Path("Cup")
    int CupLeagueLevel;

    @Element(required = false)
    @Path("Cup")
    int CupLevel;

    @Element(required = false)
    @Path("Cup")
    int CupLevelIndex;

    @Element(required = false)
    @Path("Cup")
    int MatchRound;

    @Element(required = false)
    @Path("Cup")
    int MatchRoundsLeft;


    @Element(required = false)
    int FriendlyTeamID;

    @Element(required = false)
    int NumberOfVictories;

    @Element(required = false)
    int NumberOfUndefeated;

    @Element(required = false)
    int TeamRank;

    @Element
    @Path("Fanclub")
    int FanclubID;

    @Element(required = false)
    @Path("Fanclub")
    String FanclubName;

    @Element
    @Path("Fanclub")
    int FanclubSize;

    @Element(required = false)
    String LogoURL;

    @Element
    int YouthTeamID;

    @Element(required = false)
    String YouthTeamName;

    @Element
    int NumberOfVisits;

    @ElementList
    @Path("Flags")
    ArrayList<Flag> AwayFlags;

    @ElementList
    @Path("Flags")
    ArrayList<Flag> HomeFlags;

    @ElementList
    ArrayList<Trophy> TrophyList;

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getShortTeamName() {
        return ShortTeamName;
    }

    public boolean isIsPrimaryClub() {
        return IsPrimaryClub;
    }

    public String getFoundedDate() {
        return FoundedDate;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getRegionID() {
        return RegionID;
    }

    public String getRegionName() {
        return RegionName;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public String getHomePage() {
        return HomePage;
    }

    public String getDressURI() {
        return DressURI;
    }

    public String getDressAlternateURI() {
        return DressAlternateURI;
    }

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public int getLeagueLevel() {
        return LeagueLevel;
    }

    public boolean isBot() {
        return bot;
    }

    public String getBotSince() {
        return BotSince;
    }

    public boolean isStillInCup() {
        return StillInCup;
    }

    public int getCupID() {
        return CupID;
    }

    public String getCupName() {
        return CupName;
    }

    public int getFriendlyTeamID() {
        return FriendlyTeamID;
    }

    public int getNumberOfVictories() {
        return NumberOfVictories;
    }

    public int getNumberOfUndefeated() {
        return NumberOfUndefeated;
    }

    public int getTeamRank() {
        return TeamRank;
    }

    public int getFanclubID() {
        return FanclubID;
    }

    public String getFanclubName() {
        return FanclubName;
    }

    public int getFanclubSize() {
        return FanclubSize;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public int getYouthTeamID() {
        return YouthTeamID;
    }

    public String getYouthTeamName() {
        return YouthTeamName;
    }

    public int getNumberOfVisits() {
        return NumberOfVisits;
    }

    public ArrayList<Flag> getAwayFlags() {
        return AwayFlags;
    }

    public ArrayList<Flag> getHomeFlags() {
        return HomeFlags;
    }

    public ArrayList<Trophy> getTrophyList() {
        return TrophyList;
    }

    public int getCupLeagueLevel() {
        return CupLeagueLevel;
    }

    public int getCupLevel() {
        return CupLevel;
    }

    public int getCupLevelIndex() {
        return CupLevelIndex;
    }

    public int getCupMatchRound() {
        return MatchRound;
    }

    public int getCupMatchRoundsLeft() {
        return MatchRoundsLeft;
    }

}
