package org.hattrick.models.national;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class NationalPlayer {

    @Element
    int PlayerID;

    @Element
    String PlayerName;

    @Element(required = false)
    int NrOfMatches;

    public int getPlayerID() {
        return PlayerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public int getNrOfMatches() {
        return NrOfMatches;
    }
}
