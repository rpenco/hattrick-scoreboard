package org.hattrick.models.managers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class ManagerTeam {

    @Element
    int TeamId;

    @Element
    String TeamName;

    @Element
    @Path("Arena")
    int ArenaId;

    @Element
    @Path("Arena")
    String ArenaName;

    @Element
    @Path("League")
    int LeagueId;

    @Element
    @Path("League")
    String LeagueName;

    @Element
    @Path("LeagueLevelUnit")
    int LeagueLevelUnitId;

    @Element
    @Path("LeagueLevelUnit")
    String LeagueLevelUnitName;

    @Element
    @Path("Region")
    int RegionId;

    @Element
    @Path("Region")
    String RegionName;

    @Element(required = false)
    ManagerYouthTeam YouthTeam;

    public int getTeamId() {
        return TeamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getArenaId() {
        return ArenaId;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getLeagueId() {
        return LeagueId;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getLeagueLevelUnitId() {
        return LeagueLevelUnitId;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public int getRegionId() {
        return RegionId;
    }

    public String getRegionName() {
        return RegionName;
    }

    public ManagerYouthTeam getYouthTeam() {
        return YouthTeam;
    }
}
