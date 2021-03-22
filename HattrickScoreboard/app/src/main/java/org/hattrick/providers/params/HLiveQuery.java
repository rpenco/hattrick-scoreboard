package org.hattrick.providers.params;

import org.hattrickscoreboard.database.models.DLive;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 14 august 2014
 */
public class HLiveQuery extends HQuery {

    public static String VIEW_ALL = "viewAll";
    public static String VIEW_NEW = "viewNew";
    public static String ADD_MATCH = "addMatch";
    public static String DEL_MATCH = "deleteMatch";

    private String actionType;
    private int matchID;
    private String sourceSystem;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getLastShowIndex() {
        return sourceSystem;
    }

    public void setLastShowIndex(ArrayList<DLive> lives) {
        this.sourceSystem = "{\"matches\":[";

        for (DLive live : lives) {
            this.sourceSystem += "{\"matchId\":\"" + live.getMatchID()
                    + "\",\"sourceSystem\":\"" + live.getSourceSystem()
                    + "\",\"index\":\"" + live.getLastReadEventIndex() + "\"},";

        }

        // Substring -1; (remove last ',')
        this.sourceSystem = this.sourceSystem.substring(0,
                this.sourceSystem.length() - 1);

        this.sourceSystem += "]}";

    }

    public void setLastShowIndex(DLive live) {

        ArrayList<DLive> lives = new ArrayList<DLive>();
        lives.add(live);
        setLastShowIndex(lives);
    }

}
