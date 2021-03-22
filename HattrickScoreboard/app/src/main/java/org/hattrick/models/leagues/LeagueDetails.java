package org.hattrick.models.leagues;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class LeagueDetails {

    @Element
    int LeagueID;

    @Element
    String LeagueName;

    @Element
    int LeagueLevel;

    @Element
    int MaxLevel;

    @Element
    int LeagueLevelUnitID;

    @Element
    String LeagueLevelUnitName;

    @Element
    int CurrentMatchRound;

    @ElementList(entry = "Team", inline = true)
    List<LeagueTeam> Team;

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getLeagueLevel() {
        return LeagueLevel;
    }

    public int getMaxLevel() {
        return MaxLevel;
    }

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public int getCurrentMatchRound() {
        return CurrentMatchRound;
    }

    public List<LeagueTeam> getTeams() {
        return Team;
    }

}
