package org.hattrick.models.worldcup;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class WorldRound {

    @Element
    int MatchRound;

    @Element
    String StartDate;

    public int getMatchRound() {
        return MatchRound;
    }

    public String getStartDate() {
        return StartDate;
    }
}
