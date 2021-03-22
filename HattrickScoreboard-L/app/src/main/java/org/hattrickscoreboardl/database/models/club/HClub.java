package org.hattrickscoreboardl.database.models.club;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HClub extends HModel {

    public HClub(){ }

    boolean HasPromoted;

    int UserID;
    
    int TeamID;

    int AssistantTrainerLevels;

    int FinancialDirectorLevels;

    int FormCoachLevels;

    int MedicLevels;

    int SpokespersonLevels;

    int SportPsychologistLevels;

    int Investment;

    int YouthLevel;

    //Selected team?
    boolean Selected;

    String FetchedDate;

    //From transfers

    int TotalSumOfBuys;

    int TotalSumOfSales;

    int NumberOfBuys;

    int NumberOfSales;


    public boolean isHasPromoted() {
        return HasPromoted;
    }

    public void setHasPromoted(boolean hasPromoted) {
        HasPromoted = hasPromoted;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public int getAssistantTrainerLevels() {
        return AssistantTrainerLevels;
    }

    public void setAssistantTrainerLevels(int assistantTrainerLevels) {
        AssistantTrainerLevels = assistantTrainerLevels;
    }

    public int getFinancialDirectorLevels() {
        return FinancialDirectorLevels;
    }

    public void setFinancialDirectorLevels(int financialDirectorLevels) {
        FinancialDirectorLevels = financialDirectorLevels;
    }

    public int getFormCoachLevels() {
        return FormCoachLevels;
    }

    public void setFormCoachLevels(int formCoachLevels) {
        FormCoachLevels = formCoachLevels;
    }

    public int getMedicLevels() {
        return MedicLevels;
    }

    public void setMedicLevels(int medicLevels) {
        MedicLevels = medicLevels;
    }

    public int getSpokespersonLevels() {
        return SpokespersonLevels;
    }

    public void setSpokespersonLevels(int spokespersonLevels) {
        SpokespersonLevels = spokespersonLevels;
    }

    public int getSportPsychologistLevels() {
        return SportPsychologistLevels;
    }

    public void setSportPsychologistLevels(int sportPsychologistLevels) {
        SportPsychologistLevels = sportPsychologistLevels;
    }

    public int getInvestment() {
        return Investment;
    }

    public void setInvestment(int investment) {
        Investment = investment;
    }

    public int getYouthLevel() {
        return YouthLevel;
    }

    public void setYouthLevel(int youthLevel) {
        YouthLevel = youthLevel;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
    }

    public int getTotalSumOfBuys() {
        return TotalSumOfBuys;
    }

    public void setTotalSumOfBuys(int totalSumOfBuys) {
        TotalSumOfBuys = totalSumOfBuys;
    }

    public int getTotalSumOfSales() {
        return TotalSumOfSales;
    }

    public void setTotalSumOfSales(int totalSumOfSales) {
        TotalSumOfSales = totalSumOfSales;
    }

    public int getNumberOfBuys() {
        return NumberOfBuys;
    }

    public void setNumberOfBuys(int numberOfBuys) {
        NumberOfBuys = numberOfBuys;
    }

    public int getNumberOfSales() {
        return NumberOfSales;
    }

    public void setNumberOfSales(int numberOfSales) {
        NumberOfSales = numberOfSales;
    }
}

