package org.hattrick.models.transfers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class BidItem {

    @Element
    int TransferId;

    @Element
    int PlayerId;

    @Element
    String PlayerName;

    @Element(name = "Amount", required = false)
    @Path("HighestBid")
    String HighestBidAmount;

    @Element(name = "TeamId", required = false)
    @Path("HighestBid")
    int HighestBidTeamId;

    @Element(name = "TeamName", required = false)
    @Path("HighestBid")
    String HighestBidTeamName;

    @Element
    String Deadline;

    public int getTransferId() {
        return TransferId;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public String getHighestBidAmount() {
        return HighestBidAmount;
    }

    public int getHighestBidTeamId() {
        return HighestBidTeamId;
    }

    public String getHighestBidTeamName() {
        return HighestBidTeamName;
    }

    public String getDeadline() {
        return Deadline;
    }
}
