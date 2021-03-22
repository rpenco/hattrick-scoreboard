package org.hattrick.models.matches;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class Matches {

    @Element
    int UserID;

    @Element
    boolean IsYouth;

    @Element
    @Path("Team")
    int TeamID;

    @Element
    @Path("Team")
    String TeamName;

    @Element(required = false)
    @Path("Team")
    String ShortTeamName;

    @Element
    @Path("Team/League")
    int LeagueID;

    @Element(required = false)
    @Path("Team/League")
    String LeagueName;

    @Element
    @Path("Team/LeagueLevelUnit")
    int LeagueLevelUnitID;

    @Element(required = false)
    @Path("Team/LeagueLevelUnit")
    String LeagueLevelUnitName;

    @Element
    @Path("Team/LeagueLevelUnit")
    int LeagueLevel;

    @ElementList
    @Path("Team")
    ArrayList<Match> MatchList;

    public int getUserID() {
        return UserID;
    }

    public boolean isYouth() {
        return IsYouth;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getShortTeamName() {
        return ShortTeamName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
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

    public ArrayList<Match> getMatchList() {
        return MatchList;
    }

}
