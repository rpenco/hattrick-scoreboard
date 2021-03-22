package org.hattrickscoreboardl.database.models.transfer;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HBid extends HModel {

    public HBid(){}

    int teamID;

    int TransferId;

    int PlayerId;

    String PlayerName;

    String HighestBidAmount;

    int HighestBidTeamId;

    String HighestBidTeamName;

    String Deadline;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTransferId() {
        return TransferId;
    }

    public void setTransferId(int transferId) {
        TransferId = transferId;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int playerId) {
        PlayerId = playerId;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public String getHighestBidAmount() {
        return HighestBidAmount;
    }

    public void setHighestBidAmount(String highestBidAmount) {
        HighestBidAmount = highestBidAmount;
    }

    public int getHighestBidTeamId() {
        return HighestBidTeamId;
    }

    public void setHighestBidTeamId(int highestBidTeamId) {
        HighestBidTeamId = highestBidTeamId;
    }

    public String getHighestBidTeamName() {
        return HighestBidTeamName;
    }

    public void setHighestBidTeamName(String highestBidTeamName) {
        HighestBidTeamName = highestBidTeamName;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }
}
