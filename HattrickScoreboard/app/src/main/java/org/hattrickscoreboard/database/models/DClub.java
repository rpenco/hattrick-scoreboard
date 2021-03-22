package org.hattrickscoreboard.database.models;

public class DClub extends DModel {

    long _id;
    int userID;
    int teamID;
    String teamName;
    int assistantTrainerLevel;
    int financialDirectorLevel;
    int formCoachLevel;
    int medicLevel;
    int spokesmenLevel;
    int psychologistLevel;
    int youthInvestment;
    boolean hasPromoted;
    int youthLevel;

    public int getYouthLevel() {
        return youthLevel;
    }

    public void setYouthLevel(int youthLevel) {
        this.youthLevel = youthLevel;
    }

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getAssistantTrainerLevel() {
        return assistantTrainerLevel;
    }

    public void setAssistantTrainerLevel(int assistantTrainerLevel) {
        this.assistantTrainerLevel = assistantTrainerLevel;
    }

    public int getFinancialDirectorLevel() {
        return financialDirectorLevel;
    }

    public void setFinancialDirectorLevel(int financialDirectorLevel) {
        this.financialDirectorLevel = financialDirectorLevel;
    }

    public int getFormCoachLevel() {
        return formCoachLevel;
    }

    public void setFormCoachLevel(int formCoachLevel) {
        this.formCoachLevel = formCoachLevel;
    }

    public int getMedicLevel() {
        return medicLevel;
    }

    public void setMedicLevel(int medicLevel) {
        this.medicLevel = medicLevel;
    }

    public int getSpokesmenLevel() {
        return spokesmenLevel;
    }

    public void setSpokesmenLevel(int spokesmenLevel) {
        this.spokesmenLevel = spokesmenLevel;
    }

    public int getPsychologistLevel() {
        return psychologistLevel;
    }

    public void setPsychologistLevel(int psychologistLevel) {
        this.psychologistLevel = psychologistLevel;
    }

    public int getYouthInvestment() {
        return youthInvestment;
    }

    public void setYouthInvestment(int youthInvestment) {
        this.youthInvestment = youthInvestment;
    }

    public boolean isHasPromoted() {
        return hasPromoted;
    }

    public void setHasPromoted(boolean hasPromoted) {
        this.hasPromoted = hasPromoted;
    }

}
