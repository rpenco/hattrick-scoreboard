package org.hattrick.providers.models;

import java.util.ArrayList;

/**
 * @author titou
 * @since 14 aot 2014
 */
public class HLiveParam {

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


    public void setLastShowIndex(ArrayList<Long> matchID, ArrayList<String> sourceSystem, ArrayList<Integer> lastReadEventIndex ) {
        this.sourceSystem = "{\"matches\":[";

        for (int i=0; i< matchID.size(); i++) {

            long id = matchID.get(i);
            String source = sourceSystem.get(i);
            int lastReadEvent = lastReadEventIndex.get(i);

            this.sourceSystem += "{\"matchId\":\"" + id
                    + "\",\"sourceSystem\":\"" + source
                    + "\",\"index\":\"" + lastReadEvent + "\"},";

        }

        // Substring -1; (remove last ',')
        this.sourceSystem = this.sourceSystem.substring(0,
                this.sourceSystem.length() - 1);

        this.sourceSystem += "]}";

    }

}
