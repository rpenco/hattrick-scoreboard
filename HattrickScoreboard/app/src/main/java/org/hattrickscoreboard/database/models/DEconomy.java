package org.hattrickscoreboard.database.models;

public class DEconomy extends DModel {

    long _id;
    int teamID;
    double currentCash;
    double expectedCash;
    int sponsorsPopularity;
    int supportersPopularity;
    double incomeSpectators;
    double incomeSponsors;
    double incomeFinancial;
    double incomeSold_players;
    double incomeSold_playersCommission;
    double incomeTemporary;
    double incomeSum;
    double costsArena;
    double costsPlayers;
    double costsFinancial;
    double costsStaff;
    double costsBoughtplayers;
    double costsArenabuilding;
    double costsTemporary;
    double costsYouth;
    double costsSum;
    double expectedWeeksTotal;
    int lastIncomeSpectators;
    int lastIncomeSponsors;
    double lastIncomeFinancial;
    double lastIncomeSoldplayers;
    double lastIncomeSoldPlayersCommission;
    double lastIncomeTemporary;
    double lastIncomeSum;
    double lastCostsArena;
    double lastCostsPlayers;
    double lastCostsFinancial;
    double lastCostsStaff;
    double lastCostsBought_players;
    double lastCostsArena_building;
    double lastCostsTemporary;
    double lastCostsYouth;
    double lastCostsSum;
    double lastWeeksTotal;

    public long getID() {
        return this._id;
    }

    public void setID(long id) {
        this._id = id;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public double getCurrentCash() {
        return currentCash;
    }

    public void setCurrentCash(double currentCash) {
        this.currentCash = currentCash;
    }

    public double getExpectedCash() {
        return expectedCash;
    }

    public void setExpectedCash(double expectedCash) {
        this.expectedCash = expectedCash;
    }

    public int getSponsorsPopularity() {
        return sponsorsPopularity;
    }

    public void setSponsorsPopularity(int sponsorsPopularity) {
        this.sponsorsPopularity = sponsorsPopularity;
    }

    public int getSupportersPopularity() {
        return supportersPopularity;
    }

    public void setSupportersPopularity(int supportersPopularity) {
        this.supportersPopularity = supportersPopularity;
    }

    public double getIncomeSpectators() {
        return incomeSpectators;
    }

    public void setIncomeSpectators(double incomeSpectators) {
        this.incomeSpectators = incomeSpectators;
    }

    public double getIncomeSponsors() {
        return incomeSponsors;
    }

    public void setIncomeSponsors(double incomeSponsors) {
        this.incomeSponsors = incomeSponsors;
    }

    public double getIncomeFinancial() {
        return incomeFinancial;
    }

    public void setIncomeFinancial(double incomeFinancial) {
        this.incomeFinancial = incomeFinancial;
    }

    public double getIncomeSoldPlayers() {
        return incomeSold_players;
    }

    public double getIncomeSoldPlayersCommission() {
        return incomeSold_playersCommission;
    }

    public double getIncomeTemporary() {
        return incomeTemporary;
    }

    public void setIncomeTemporary(double incomeTemporary) {
        this.incomeTemporary = incomeTemporary;
    }

    public double getIncomeSum() {
        return incomeSum;
    }

    public void setIncomeSum(double incomeSum) {
        this.incomeSum = incomeSum;
    }

    public double getCostsArena() {
        return costsArena;
    }

    public void setCostsArena(double costsArena) {
        this.costsArena = costsArena;
    }

    public double getCostsPlayers() {
        return costsPlayers;
    }

    public void setCostsPlayers(double costsPlayers) {
        this.costsPlayers = costsPlayers;
    }

    public double getCostsFinancial() {
        return costsFinancial;
    }

    public void setCostsFinancial(double costsFinancial) {
        this.costsFinancial = costsFinancial;
    }

    public double getCostsStaff() {
        return costsStaff;
    }

    public void setCostsStaff(double costsStaff) {
        this.costsStaff = costsStaff;
    }

    public double getCostsBoughtPlayers() {
        return costsBoughtplayers;
    }

    public double getCostsArenaBuilding() {
        return costsArenabuilding;
    }

    public double getCostsTemporary() {
        return costsTemporary;
    }

    public void setCostsTemporary(double costsTemporary) {
        this.costsTemporary = costsTemporary;
    }

    public double getCostsYouth() {
        return costsYouth;
    }

    public void setCostsYouth(double costsYouth) {
        this.costsYouth = costsYouth;
    }

    public double getCostsSum() {
        return costsSum;
    }

    public void setCostsSum(double costsSum) {
        this.costsSum = costsSum;
    }

    public double getExpectedWeeksTotal() {
        return expectedWeeksTotal;
    }

    public void setExpectedWeeksTotal(double expectedWeeksTotal) {
        this.expectedWeeksTotal = expectedWeeksTotal;
    }

    public int getLastIncomeSpectators() {
        return lastIncomeSpectators;
    }

    public void setLastIncomeSpectators(int lastIncomeSpectators) {
        this.lastIncomeSpectators = lastIncomeSpectators;
    }

    public int getLastIncomeSponsors() {
        return lastIncomeSponsors;
    }

    public void setLastIncomeSponsors(int lastIncomeSponsors) {
        this.lastIncomeSponsors = lastIncomeSponsors;
    }

    public double getLastIncomeFinancial() {
        return lastIncomeFinancial;
    }

    public void setLastIncomeFinancial(double lastIncomeFinancial) {
        this.lastIncomeFinancial = lastIncomeFinancial;
    }

    public double getLastIncomeSoldPlayers() {
        return lastIncomeSoldplayers;
    }

    public double getLastIncomeSoldPlayersCommission() {
        return lastIncomeSoldPlayersCommission;
    }

    public void setLastIncomeSoldPlayersCommission(
            double lastIncomeSoldPlayersCommission) {
        this.lastIncomeSoldPlayersCommission = lastIncomeSoldPlayersCommission;
    }

    public double getLastIncomeTemporary() {
        return lastIncomeTemporary;
    }

    public void setLastIncomeTemporary(double lastIncomeTemporary) {
        this.lastIncomeTemporary = lastIncomeTemporary;
    }

    public double getLastIncomeSum() {
        return lastIncomeSum;
    }

    public void setLastIncomeSum(double lastIncomeSum) {
        this.lastIncomeSum = lastIncomeSum;
    }

    public double getLastCostsArena() {
        return lastCostsArena;
    }

    public void setLastCostsArena(double lastCostsArena) {
        this.lastCostsArena = lastCostsArena;
    }

    public double getLastCostsPlayers() {
        return lastCostsPlayers;
    }

    public void setLastCostsPlayers(double lastCostsPlayers) {
        this.lastCostsPlayers = lastCostsPlayers;
    }

    public double getLastCostsFinancial() {
        return lastCostsFinancial;
    }

    public void setLastCostsFinancial(double lastCostsFinancial) {
        this.lastCostsFinancial = lastCostsFinancial;
    }

    public double getLastCostsStaff() {
        return lastCostsStaff;
    }

    public void setLastCostsStaff(double lastCostsStaff) {
        this.lastCostsStaff = lastCostsStaff;
    }

    public double getLastCostsBoughtPlayers() {
        return lastCostsBought_players;
    }

    public double getLastCostsArenaBuilding() {
        return lastCostsArena_building;
    }

    public double getLastCostsTemporary() {
        return lastCostsTemporary;
    }

    public void setLastCostsTemporary(double lastCostsTemporary) {
        this.lastCostsTemporary = lastCostsTemporary;
    }

    public double getLastCostsYouth() {
        return lastCostsYouth;
    }

    public void setLastCostsYouth(double lastCostsYouth) {
        this.lastCostsYouth = lastCostsYouth;
    }

    public double getLastCostsSum() {
        return lastCostsSum;
    }

    public void setLastCostsSum(double lastCostsSum) {
        this.lastCostsSum = lastCostsSum;
    }

    public double getLastWeeksTotal() {
        return lastWeeksTotal;
    }

    public void setLastWeeksTotal(double lastWeeksTotal) {
        this.lastWeeksTotal = lastWeeksTotal;
    }

    public void setIncomeSold_players(double incomeSold_players) {
        this.incomeSold_players = incomeSold_players;
    }

    public void setIncomeSold_playersCommission(
            double incomeSold_playersCommission) {
        this.incomeSold_playersCommission = incomeSold_playersCommission;
    }

    public void setCostsBoughtplayers(double costsBoughtplayers) {
        this.costsBoughtplayers = costsBoughtplayers;
    }

    public void setCostsArenabuilding(double costsArenabuilding) {
        this.costsArenabuilding = costsArenabuilding;
    }

    public void setLastIncomeSoldplayers(double lastIncomeSoldplayers) {
        this.lastIncomeSoldplayers = lastIncomeSoldplayers;
    }

    public void setLastCostsBought_players(double lastCostsBought_players) {
        this.lastCostsBought_players = lastCostsBought_players;
    }

    public void setLastCostsArena_building(double lastCostsArena_building) {
        this.lastCostsArena_building = lastCostsArena_building;
    }

}
