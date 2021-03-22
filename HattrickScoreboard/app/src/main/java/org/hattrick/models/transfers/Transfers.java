package org.hattrick.models.transfers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class Transfers {

    @ElementList(entry = "Transfer", inline = true)
    @Path("Transfers")
    ArrayList<Transfer> Transfer;

    @Element
    @Path("Stats")
    String TotalSumOfBuys;

    @Element
    @Path("Stats")
    String TotalSumOfSales;

    @Element
    @Path("Stats")
    String NumberOfBuys;

    @Element
    @Path("Stats")
    String NumberOfSales;

    public ArrayList<Transfer> getTransfers() {
        return Transfer;
    }

    public String getTotalSumOfBuys() {
        return TotalSumOfBuys;
    }

    public String getTotalSumOfSales() {
        return TotalSumOfSales;
    }

    public String getNumberOfBuys() {
        return NumberOfBuys;
    }

    public String getNumberOfSales() {
        return NumberOfSales;
    }

}
