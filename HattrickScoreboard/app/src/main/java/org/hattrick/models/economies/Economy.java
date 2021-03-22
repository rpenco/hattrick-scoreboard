package org.hattrick.models.economies;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.Map;

@Root(strict = false)
public class Economy {

    @Element
    @Path("Team")
    int TeamID;

    @Element
    @Path("Team")
    String TeamName;

    @Element
    @Path("Team")
    int Cash;

    @Element
    @Path("Team")
    int ExpectedCash;

    @ElementMap(entry = "SponsorsPopularity", key = "Available", attribute = true, data = true, inline = true, required = false)
    @Path("Team")
    Map<String, Integer> SponsorsPopularity;

    @ElementMap(entry = "SupportersPopularity", key = "Available", attribute = true, data = true, inline = true, required = false)
    @Path("Team")
    Map<String, Integer> SupportersPopularity;

    @Element
    @Path("Team")
    int FanClubSize;

    @Element
    @Path("Team")
    int IncomeSpectators;

    @Element
    @Path("Team")
    int IncomeSponsors;

    @Element
    @Path("Team")
    int IncomeFinancial;

    @Element
    @Path("Team")
    int IncomeSoldPlayers;

    @Element
    @Path("Team")
    int IncomeSoldPlayersCommission;

    @Element
    @Path("Team")
    int IncomeTemporary;

    @Element
    @Path("Team")
    int IncomeSum;

    @Element
    @Path("Team")
    int CostsArena;

    @Element
    @Path("Team")
    int CostsPlayers;

    @Element
    @Path("Team")
    int CostsFinancial;

    @Element
    @Path("Team")
    int CostsStaff;

    @Element
    @Path("Team")
    int CostsBoughtPlayers;

    @Element
    @Path("Team")
    int CostsArenaBuilding;

    @Element
    @Path("Team")
    int CostsTemporary;

    @Element
    @Path("Team")
    int CostsYouth;

    @Element
    @Path("Team")
    int CostsSum;

    @Element
    @Path("Team")
    int ExpectedWeeksTotal;

    @Element
    @Path("Team")
    int LastIncomeSpectators;

    @Element
    @Path("Team")
    int LastIncomeSponsors;

    @Element
    @Path("Team")
    int LastIncomeFinancial;

    @Element
    @Path("Team")
    int LastIncomeSoldPlayers;

    @Element
    @Path("Team")
    int LastIncomeSoldPlayersCommission;

    @Element
    @Path("Team")
    int LastIncomeTemporary;

    @Element
    @Path("Team")
    int LastIncomeSum;

    @Element
    @Path("Team")
    int LastCostsArena;

    @Element
    @Path("Team")
    int LastCostsPlayers;

    @Element
    @Path("Team")
    int LastCostsFinancial;

    @Element
    @Path("Team")
    int LastCostsStaff;

    @Element
    @Path("Team")
    int LastCostsBoughtPlayers;

    @Element
    @Path("Team")
    int LastCostsArenaBuilding;

    @Element
    @Path("Team")
    int LastCostsTemporary;

    @Element
    @Path("Team")
    int LastCostsYouth;

    @Element
    @Path("Team")
    int LastCostsSum;

    @Element
    @Path("Team")
    int LastWeeksTotal;

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getCash() {
        return Cash;
    }

    public int getExpectedCash() {
        return ExpectedCash;
    }

    public boolean isSponsorsPopularity() {
        return SponsorsPopularity.containsKey("True");
    }

    public int getSponsorsPopularity() {
        if (SponsorsPopularity.containsKey("True"))
            return SponsorsPopularity.get("True");
        return 0;
    }

    public boolean isSupportersAvailable() {
        return SupportersPopularity.containsKey("True");
    }

    public int getSupportersPopularity() {
        if (SupportersPopularity.containsKey("True"))
            return SupportersPopularity.get("True");
        return 0;
    }

    public int getFanClubSize() {
        return FanClubSize;
    }

    public int getIncomeSpectators() {
        return IncomeSpectators;
    }

    public int getIncomeSponsors() {
        return IncomeSponsors;
    }

    public int getIncomeFinancial() {
        return IncomeFinancial;
    }

    public int getIncomeSoldPlayers() {
        return IncomeSoldPlayers;
    }

    public int getIncomeSoldPlayersCommission() {
        return IncomeSoldPlayersCommission;
    }

    public int getIncomeTemporary() {
        return IncomeTemporary;
    }

    public int getIncomeSum() {
        return IncomeSum;
    }

    public int getCostsArena() {
        return CostsArena;
    }

    public int getCostsPlayers() {
        return CostsPlayers;
    }

    public int getCostsFinancial() {
        return CostsFinancial;
    }

    public int getCostsStaff() {
        return CostsStaff;
    }

    public int getCostsBoughtPlayers() {
        return CostsBoughtPlayers;
    }

    public int getCostsArenaBuilding() {
        return CostsArenaBuilding;
    }

    public int getCostsTemporary() {
        return CostsTemporary;
    }

    public int getCostsYouth() {
        return CostsYouth;
    }

    public int getCostsSum() {
        return CostsSum;
    }

    public int getExpectedWeeksTotal() {
        return ExpectedWeeksTotal;
    }

    public int getLastIncomeSpectators() {
        return LastIncomeSpectators;
    }

    public int getLastIncomeSponsors() {
        return LastIncomeSponsors;
    }

    public int getLastIncomeFinancial() {
        return LastIncomeFinancial;
    }

    public int getLastIncomeSoldPlayers() {
        return LastIncomeSoldPlayers;
    }

    public int getLastIncomeSoldPlayersCommission() {
        return LastIncomeSoldPlayersCommission;
    }

    public int getLastIncomeTemporary() {
        return LastIncomeTemporary;
    }

    public int getLastIncomeSum() {
        return LastIncomeSum;
    }

    public int getLastCostsArena() {
        return LastCostsArena;
    }

    public int getLastCostsPlayers() {
        return LastCostsPlayers;
    }

    public int getLastCostsFinancial() {
        return LastCostsFinancial;
    }

    public int getLastCostsStaff() {
        return LastCostsStaff;
    }

    public int getLastCostsBoughtPlayers() {
        return LastCostsBoughtPlayers;
    }

    public int getLastCostsArenaBuilding() {
        return LastCostsArenaBuilding;
    }

    public int getLastCostsTemporary() {
        return LastCostsTemporary;
    }

    public int getLastCostsYouth() {
        return LastCostsYouth;
    }

    public int getLastCostsSum() {
        return LastCostsSum;
    }

    public int getLastWeeksTotal() {
        return LastWeeksTotal;
    }

}
