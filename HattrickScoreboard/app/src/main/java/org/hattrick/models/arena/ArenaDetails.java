package org.hattrick.models.arena;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ArenaDetails {

    @Element
    @Path("Arena")
    int ArenaID;

    @Element
    @Path("Arena")
    String ArenaName;

    @Element
    @Path("Arena/Team")
    int TeamID;

    @Element
    @Path("Arena/Team")
    String TeamName;

    @Element
    @Path("Arena/League")
    int LeagueID;

    @Element
    @Path("Arena/League")
    String LeagueName;

    @Element
    @Path("Arena/Region")
    int RegionID;

    @Element
    @Path("Arena/Region")
    String RegionName;

    @Element
    @Path("Arena")
    CurrentCapacity CurrentCapacity;

    @Element
    @Path("Arena")
    ExpandedCapacity ExpandedCapacity;

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

    public CurrentCapacity getCurrentCapacity() {
        return CurrentCapacity;
    }

    public ExpandedCapacity getExpandedCapacity() {
        return ExpandedCapacity;
    }


}
