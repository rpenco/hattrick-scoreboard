package org.hattrick.models.world;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Cup {

    @Element
    int CupID;

    @Element
    String CupName;

    @Element(required = false)
    int CupLeagueLevel;

    @Element(required = false)
    int CupLevel;

    @Element(required = false)
    int CupLevelIndex;

    @Element(required = false)
    int MatchRound;

    @Element(required = false)
    int MatchRoundsLeft;

    public int getCupID() {
        return CupID;
    }

    public String getCupName() {
        return CupName;
    }

    public int getCupLeagueLevel() {
        return CupLeagueLevel;
    }

    public int getCupLevel() {
        return CupLevel;
    }

    public int getCupLevelIndex() {
        return CupLevelIndex;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public int getMatchRoundsLeft() {
        return MatchRoundsLeft;
    }


}
