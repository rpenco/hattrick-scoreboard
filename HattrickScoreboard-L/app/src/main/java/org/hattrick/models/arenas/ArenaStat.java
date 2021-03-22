package org.hattrick.models.arenas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Supporters Only
 */
@Root(strict = false)
public class ArenaStat {

    @Element
    int ArenaID;

    @Element
    String ArenaName;

    @Element
    int ArenaSize;

    @Element
    int ArenaLeagueID;

    @Element
    String ArenaLeagueName;

    @Element
    int ArenaRegionId;

    @Element
    String ArenaRegionName;

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getArenaSize() {
        return ArenaSize;
    }

    public int getArenaLeagueID() {
        return ArenaLeagueID;
    }

    public String getArenaLeagueName() {
        return ArenaLeagueName;
    }

    public int getArenaRegionId() {
        return ArenaRegionId;
    }

    public String getArenaRegionName() {
        return ArenaRegionName;
    }
}
