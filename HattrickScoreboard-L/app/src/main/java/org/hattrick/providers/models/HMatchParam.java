package org.hattrick.providers.models;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HMatchParam {

    int matchID;

    String sourceSystem;

    public HMatchParam(String sourceSystem, int matchID) {
        this.sourceSystem = sourceSystem;
        this.matchID = matchID;
    }

    public int getMatchID() {
        return matchID;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }
}
