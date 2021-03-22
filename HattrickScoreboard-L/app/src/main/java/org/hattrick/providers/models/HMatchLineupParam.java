package org.hattrick.providers.models;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HMatchLineupParam {

    int matchID;

    int teamID;
    String sourceSystem;

    public HMatchLineupParam(String sourceSystem, int matchID, int teamID) {
        this.sourceSystem = sourceSystem;
        this.matchID = matchID;
        this.teamID = teamID;
    }

    public int getMatchID() {
        return matchID;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }
    public int getTeamID() {
        return teamID;
    }
}
