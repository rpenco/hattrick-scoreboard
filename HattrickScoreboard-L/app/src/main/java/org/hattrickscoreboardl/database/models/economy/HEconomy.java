package org.hattrickscoreboardl.database.models.economy;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HEconomy extends HModel {

    public HEconomy(){ }

    int TeamID;

    int Cash;

    int ExpectedCash;

    Integer SponsorsPopularity;

    Integer SupportersPopularity;

    int IncomeSpectators;

    int IncomeSponsors;

    int IncomeFinancial;

    int IncomeSoldPlayers;

    int IncomeSoldPlayersCommission;

    int IncomeTemporary;

    int IncomeSum;

    int CostsArena;

    int CostsPlayers;

    int CostsFinancial;

    int CostsStaff;

    int CostsBoughtPlayers;

    int CostsArenaBuilding;

    int CostsTemporary;

    int CostsYouth;

    int CostsSum;

    int ExpectedWeeksTotal;

    String FetchedDate;

    //Getter

    public int getTeamID() {
        return TeamID;
    }

    public int getCash() {
        return Cash;
    }

    public int getExpectedCash() {
        return ExpectedCash;
    }

    public Integer getSponsorsPopularity() {
        return SponsorsPopularity;
    }

    public Integer getSupportersPopularity() {
        return SupportersPopularity;
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


    public String getFetchedDate() {
        return FetchedDate;
    }


    //Setter

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setCash(int cash) {
        Cash = cash;
    }

    public void setExpectedCash(int expectedCash) {
        ExpectedCash = expectedCash;
    }

    public void setSponsorsPopularity(Integer sponsorsPopularity) {
        SponsorsPopularity = sponsorsPopularity;
    }

    public void setSupportersPopularity(Integer supportersPopularity) {
        SupportersPopularity = supportersPopularity;
    }

    public void setIncomeSpectators(int incomeSpectators) {
        IncomeSpectators = incomeSpectators;
    }

    public void setIncomeSponsors(int incomeSponsors) {
        IncomeSponsors = incomeSponsors;
    }

    public void setIncomeFinancial(int incomeFinancial) {
        IncomeFinancial = incomeFinancial;
    }

    public void setIncomeSoldPlayers(int incomeSoldPlayers) {
        IncomeSoldPlayers = incomeSoldPlayers;
    }

    public void setIncomeSoldPlayersCommission(int incomeSoldPlayersCommission) {
        IncomeSoldPlayersCommission = incomeSoldPlayersCommission;
    }

    public void setIncomeTemporary(int incomeTemporary) {
        IncomeTemporary = incomeTemporary;
    }

    public void setIncomeSum(int incomeSum) {
        IncomeSum = incomeSum;
    }

    public void setCostsArena(int costsArena) {
        CostsArena = costsArena;
    }

    public void setCostsPlayers(int costsPlayers) {
        CostsPlayers = costsPlayers;
    }

    public void setCostsFinancial(int costsFinancial) {
        CostsFinancial = costsFinancial;
    }

    public void setCostsStaff(int costsStaff) {
        CostsStaff = costsStaff;
    }

    public void setCostsBoughtPlayers(int costsBoughtPlayers) {
        CostsBoughtPlayers = costsBoughtPlayers;
    }

    public void setCostsArenaBuilding(int costsArenaBuilding) {
        CostsArenaBuilding = costsArenaBuilding;
    }

    public void setCostsTemporary(int costsTemporary) {
        CostsTemporary = costsTemporary;
    }

    public void setCostsYouth(int costsYouth) {
        CostsYouth = costsYouth;
    }

    public void setCostsSum(int costsSum) {
        CostsSum = costsSum;
    }

    public void setExpectedWeeksTotal(int expectedWeeksTotal) {
        ExpectedWeeksTotal = expectedWeeksTotal;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }
}

