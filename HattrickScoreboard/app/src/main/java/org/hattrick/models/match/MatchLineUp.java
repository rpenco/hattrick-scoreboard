package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class MatchLineUp {

    @Element
    private String FileName;

    @Element
    private String Version;

    @Element
    private String UserID;

    @Element
    private String MatchID;

    @Element
    private boolean IsYouth;

    @Element
    private String FetchedDate;

    @Element
    private String MatchType;

    @Element
    private String MatchDate;

    @Element
    @Path("HomeTeam")
    private String HomeTeamID;

    @Element
    @Path("HomeTeam")
    private String HomeTeamName;

    @Element
    @Path("AwayTeam")
    private String AwayTeamID;

    @Element
    @Path("AwayTeam")
    private String AwayTeamName;

    @Element(required = false)
    @Path("Arena")
    private String ArenaID;

    @Element(required = false)
    @Path("Arena")
    private String ArenaName;

    @Element
    @Path("Team")
    private String TeamID;

    @Element
    @Path("Team")
    private String TeamName;

    @Element
    @Path("Team")
    private String ExperienceLevel;

    @ElementList(name = "StartingLineup")
    @Path("Team")
    private ArrayList<PlayerLineup> StartingLineup;

    @ElementList(name = "Lineup")
    @Path("Team")
    private ArrayList<PlayerLineup> Lineup;

    @ElementList(name = "Substitutions")
    @Path("Team")
    private ArrayList<Substitution> Substitutions;

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getMatchID() {
        return MatchID;
    }

    public void setMatchID(String matchID) {
        MatchID = matchID;
    }

    public boolean isIsYouth() {
        return IsYouth;
    }

    public void setIsYouth(boolean isYouth) {
        IsYouth = isYouth;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }

    public String getMatchType() {
        return MatchType;
    }

    public void setMatchType(String matchType) {
        MatchType = matchType;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(String matchDate) {
        MatchDate = matchDate;
    }

    public String getHomeTeamID() {
        return HomeTeamID;
    }

    public void setHomeTeamID(String homeTeamID) {
        HomeTeamID = homeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        HomeTeamName = homeTeamName;
    }

    public String getAwayTeamID() {
        return AwayTeamID;
    }

    public void setAwayTeamID(String awayTeamID) {
        AwayTeamID = awayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        AwayTeamName = awayTeamName;
    }

    public String getArenaID() {
        return ArenaID;
    }

    public void setArenaID(String arenaID) {
        ArenaID = arenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public void setArenaName(String arenaName) {
        ArenaName = arenaName;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getExperienceLevel() {
        return ExperienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        ExperienceLevel = experienceLevel;
    }

    public ArrayList<Substitution> getSubstitutions() {
        return Substitutions;
    }

    public void setSubstitutions(ArrayList<Substitution> substitutions) {
        Substitutions = substitutions;
    }

    public ArrayList<PlayerLineup> getStartingLineup() {
        return StartingLineup;
    }

    public void setStartingLineup(ArrayList<PlayerLineup> startingLineup) {
        StartingLineup = startingLineup;
    }

    public ArrayList<PlayerLineup> getLineup() {
        return Lineup;
    }

    public void setLineup(ArrayList<PlayerLineup> lineup) {
        Lineup = lineup;
    }

}
