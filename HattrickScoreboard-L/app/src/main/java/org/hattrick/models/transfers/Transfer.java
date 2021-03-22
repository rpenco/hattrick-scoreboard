package org.hattrick.models.transfers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Transfer {

    @Element
    int TransferID;

    @Element
    String Deadline;

    @Element
    String TransferType;

    @Element
    String Price;

    @Element
    @Path("Player")
    int PlayerID;

    @Element
    @Path("Player")
    String PlayerName;

    @Element
    @Path("Player")
    int TSI;

    @Element
    @Path("Buyer")
    int BuyerTeamID;

    @Element
    @Path("Buyer")
    String BuyerTeamName;

    @Element
    @Path("Seller")
    int SellerTeamID;

    @Element
    @Path("Seller")
    String SellerTeamName;

    public int getTransferID() {
        return TransferID;
    }

    public String getDeadline() {
        return Deadline;
    }

    public String getTransferType() {
        return TransferType;
    }

    public String getPrice() {
        return Price;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public int getTSI() {
        return TSI;
    }

    public int getBuyerTeamID() {
        return BuyerTeamID;
    }

    public String getBuyerTeamName() {
        return BuyerTeamName;
    }

    public int getSellerTeamID() {
        return SellerTeamID;
    }

    public String getSellerTeamName() {
        return SellerTeamName;
    }

}
