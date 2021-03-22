package org.hattrick.models.teams;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Flag {

    @Element
    int LeagueId;

    @Element
    String LeagueName;

    @Element
    String CountryCode;

    public int getLeagueId() {
        return LeagueId;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

}
