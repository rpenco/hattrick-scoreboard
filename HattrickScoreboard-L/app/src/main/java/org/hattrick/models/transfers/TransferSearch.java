package org.hattrick.models.transfers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class TransferSearch {

    @ElementList(entry = "Transfer", inline = true)
    @Path("Transfers")
    ArrayList<Transfer> Transfer;

    @Element
    @Path("Stats")
    int TotalSumOfBuys;

    @Element
    @Path("Stats")
    int TotalSumOfSales;

    @Element
    @Path("Stats")
    int NumberOfBuys;

    @Element
    @Path("Stats")
    int NumberOfSales;

    public int getNumberOfSales() {
        return NumberOfSales;
    }

    public ArrayList<Transfer> getTransfers() {
        return Transfer;
    }

    public int getTotalSumOfBuys() {
        return TotalSumOfBuys;
    }

    public int getTotalSumOfSales() {
        return TotalSumOfSales;
    }

    public int getNumberOfBuys() {
        return NumberOfBuys;
    }
}
