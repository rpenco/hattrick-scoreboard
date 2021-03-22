package org.hattrickscoreboardl.database.models.transfer;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HTransfer extends HModel {

    public HTransfer(){}

    int teamID;

    int TransferID;

    String Deadline;

    String TransferType;

    String Price;

    int PlayerID;

    String PlayerName;

    int TSI;

    int BuyerTeamID;

    String BuyerTeamName;

    int SellerTeamID;

    String SellerTeamName;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public int getTransferID() {
        return TransferID;
    }

    public void setTransferID(int transferID) {
        TransferID = transferID;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getTransferType() {
        return TransferType;
    }

    public void setTransferType(String transferType) {
        TransferType = transferType;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public int getTSI() {
        return TSI;
    }

    public void setTSI(int TSI) {
        this.TSI = TSI;
    }

    public int getBuyerTeamID() {
        return BuyerTeamID;
    }

    public void setBuyerTeamID(int buyerTeamID) {
        BuyerTeamID = buyerTeamID;
    }

    public String getBuyerTeamName() {
        return BuyerTeamName;
    }

    public void setBuyerTeamName(String buyerTeamName) {
        BuyerTeamName = buyerTeamName;
    }

    public int getSellerTeamID() {
        return SellerTeamID;
    }

    public void setSellerTeamID(int sellerTeamID) {
        SellerTeamID = sellerTeamID;
    }

    public String getSellerTeamName() {
        return SellerTeamName;
    }

    public void setSellerTeamName(String sellerTeamName) {
        SellerTeamName = sellerTeamName;
    }
}
