package org.hattrick.models.teams;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Trophy {

    @Element
    int TrophyTypeId;

    @Element
    int TrophySeason;

    @Element
    int LeagueLevel;

    @Element(required = false)
    String LeagueLevelUnitName;

    @Element
    String GainedDate;

    @Element(required = false)
    String ImageUrl;

    public int getTrophyTypeId() {
        return TrophyTypeId;
    }

    public int getTrophySeason() {
        return TrophySeason;
    }

    public int getLeagueLevel() {
        return LeagueLevel;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public String getGainedDate() {
       return GainedDate;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

}
