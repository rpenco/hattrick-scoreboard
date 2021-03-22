package org.hattrick.models.matchorders;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(strict = false)
public class MatchOrders {

    @Element
    int MatchID;

    @Element
    boolean IsYouth;

    @Element
    MatchData MatchData;

    public int getMatchID() {
        return MatchID;
    }

    public boolean isYouth() {
        return IsYouth;
    }

    public MatchData getMatchData() {
        return MatchData;
    }
}
