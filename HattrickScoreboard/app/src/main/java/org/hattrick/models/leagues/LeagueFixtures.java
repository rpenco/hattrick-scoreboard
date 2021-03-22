package org.hattrick.models.leagues;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict = false)
public class LeagueFixtures {

    @Element
    int LeagueLevelUnitID;

    @Element
    String LeagueLevelUnitName;

    @Element
    int Season;

    @ElementList(entry = "Match", inline = true)
    List<Match> Match;

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public int getSeason() {
        return Season;
    }

    public List<Match> getMatchs() {
        return Match;
    }

}
