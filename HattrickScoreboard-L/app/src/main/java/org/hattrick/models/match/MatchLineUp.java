package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class MatchLineUp {

    @Element
    private int UserID;

    @Element
    private int MatchID;

    @Element
    private boolean IsYouth;

    @Element
    private String FetchedDate;

    @Element
    private int MatchType;

    @Element
    private String MatchDate;

    @Element
    @Path("HomeTeam")
    private int HomeTeamID;

    @Element
    @Path("HomeTeam")
    private String HomeTeamName;

    @Element
    @Path("AwayTeam")
    private int AwayTeamID;

    @Element
    @Path("AwayTeam")
    private String AwayTeamName;

    @Element(required = false)
    @Path("Arena")
    private int ArenaID;

    @Element(required = false)
    @Path("Arena")
    private String ArenaName;

    @Element
    @Path("Team")
    private int TeamID;

    @Element
    @Path("Team")
    private String TeamName;

    @Element
    @Path("Team")
    private int ExperienceLevel;

    @ElementList(name = "StartingLineup")
    @Path("Team")
    private ArrayList<PlayerLineup> StartingLineup;

    @ElementList(name = "Lineup")
    @Path("Team")
    private ArrayList<PlayerLineup> Lineup;

    @ElementList(name = "Substitutions")
    @Path("Team")
    private ArrayList<Substitution> Substitutions;

    public int getUserID() {
        return UserID;
    }

    public int getMatchID() {
        return MatchID;
    }

    public boolean isYouth() {
        return IsYouth;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public int getMatchType() {
        return MatchType;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getExperienceLevel() {
        return ExperienceLevel;
    }

    public ArrayList<PlayerLineup> getStartingLineup() {
        return StartingLineup;
    }

    public ArrayList<PlayerLineup> getLineup() {
        return Lineup;
    }

    public ArrayList<Substitution> getSubstitutions() {
        return Substitutions;
    }
}
