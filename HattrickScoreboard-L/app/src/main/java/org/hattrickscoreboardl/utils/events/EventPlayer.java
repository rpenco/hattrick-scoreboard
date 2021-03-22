package org.hattrickscoreboardl.utils.events;

/**
 * Created by romain
 * on 06/12/2014.
 */
public class EventPlayer {

    int playerID;
    String playerName;

    public EventPlayer(String playerName, int playerID) {
        this.playerName = playerName;
        this.playerID = playerID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return playerName;
    }
}
