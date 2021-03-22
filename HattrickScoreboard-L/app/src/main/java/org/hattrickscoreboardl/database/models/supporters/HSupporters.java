package org.hattrickscoreboardl.database.models.supporters;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HSupporters extends HModel {

    public HSupporters(){}

    int UserId;

    String LoginName;

    int TeamId;

    String TeamName;

    int LeagueID;

    String LeagueName;

    int LeagueLevelUnitID;

    String LeagueLevelUnitName;


    //Only Supported teams not supporter team.
    int LastMatchId;

    String LastMatchDate;

    int LastMatchHomeTeamId;

    String LastMatchHomeTeamName;

    int LastMatchHomeGoals;

    int LastMatchAwayTeamId;

    String LastMatchAwayTeamName;

    int LastMatchAwayGoals;

    int NextMatchId;

    String NextMatchMatchDate;

    int NextMatchHomeTeamId;

    String NextMatchHomeTeamName;

    int NextMatchAwayTeamId;

    String NextMatchAwayTeamName;

    String PressAnnouncementSendDate;

    String PressAnnouncementSubject;

    String PressAnnouncementBody;

    //Only on this application

    boolean hisHattrickSupporter;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public int getTeamId() {
        return TeamId;
    }

    public void setTeamId(int teamId) {
        TeamId = teamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public void setLeagueName(String leagueName) {
        LeagueName = leagueName;
    }

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public void setLeagueLevelUnitID(int leagueLevelUnitID) {
        LeagueLevelUnitID = leagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public void setLeagueLevelUnitName(String leagueLevelUnitName) {
        LeagueLevelUnitName = leagueLevelUnitName;
    }

    public int getLastMatchId() {
        return LastMatchId;
    }

    public void setLastMatchId(int lastMatchId) {
        LastMatchId = lastMatchId;
    }

    public String getLastMatchDate() {
        return LastMatchDate;
    }

    public void setLastMatchDate(String lastMatchDate) {
        LastMatchDate = lastMatchDate;
    }

    public int getLastMatchHomeTeamId() {
        return LastMatchHomeTeamId;
    }

    public void setLastMatchHomeTeamId(int lastMatchHomeTeamId) {
        LastMatchHomeTeamId = lastMatchHomeTeamId;
    }

    public String getLastMatchHomeTeamName() {
        return LastMatchHomeTeamName;
    }

    public void setLastMatchHomeTeamName(String lastMatchHomeTeamName) {
        LastMatchHomeTeamName = lastMatchHomeTeamName;
    }

    public int getLastMatchHomeGoals() {
        return LastMatchHomeGoals;
    }

    public void setLastMatchHomeGoals(int lastMatchHomeGoals) {
        LastMatchHomeGoals = lastMatchHomeGoals;
    }

    public int getLastMatchAwayTeamId() {
        return LastMatchAwayTeamId;
    }

    public void setLastMatchAwayTeamId(int lastMatchAwayTeamId) {
        LastMatchAwayTeamId = lastMatchAwayTeamId;
    }

    public String getLastMatchAwayTeamName() {
        return LastMatchAwayTeamName;
    }

    public void setLastMatchAwayTeamName(String lastMatchAwayTeamName) {
        LastMatchAwayTeamName = lastMatchAwayTeamName;
    }

    public int getLastMatchAwayGoals() {
        return LastMatchAwayGoals;
    }

    public void setLastMatchAwayGoals(int lastMatchAwayGoals) {
        LastMatchAwayGoals = lastMatchAwayGoals;
    }

    public int getNextMatchId() {
        return NextMatchId;
    }

    public void setNextMatchId(int nextMatchId) {
        NextMatchId = nextMatchId;
    }

    public String getNextMatchMatchDate() {
        return NextMatchMatchDate;
    }

    public void setNextMatchMatchDate(String nextMatchMatchDate) {
        NextMatchMatchDate = nextMatchMatchDate;
    }

    public int getNextMatchHomeTeamId() {
        return NextMatchHomeTeamId;
    }

    public void setNextMatchHomeTeamId(int nextMatchHomeTeamId) {
        NextMatchHomeTeamId = nextMatchHomeTeamId;
    }

    public String getNextMatchHomeTeamName() {
        return NextMatchHomeTeamName;
    }

    public void setNextMatchHomeTeamName(String nextMatchHomeTeamName) {
        NextMatchHomeTeamName = nextMatchHomeTeamName;
    }

    public int getNextMatchAwayTeamId() {
        return NextMatchAwayTeamId;
    }

    public void setNextMatchAwayTeamId(int nextMatchAwayTeamId) {
        NextMatchAwayTeamId = nextMatchAwayTeamId;
    }

    public String getNextMatchAwayTeamName() {
        return NextMatchAwayTeamName;
    }

    public void setNextMatchAwayTeamName(String nextMatchAwayTeamName) {
        NextMatchAwayTeamName = nextMatchAwayTeamName;
    }

    public String getPressAnnouncementSendDate() {
        return PressAnnouncementSendDate;
    }

    public void setPressAnnouncementSendDate(String pressAnnouncementSendDate) {
        PressAnnouncementSendDate = pressAnnouncementSendDate;
    }

    public String getPressAnnouncementSubject() {
        return PressAnnouncementSubject;
    }

    public void setPressAnnouncementSubject(String pressAnnouncementSubject) {
        PressAnnouncementSubject = pressAnnouncementSubject;
    }

    public String getPressAnnouncementBody() {
        return PressAnnouncementBody;
    }

    public void setPressAnnouncementBody(String pressAnnouncementBody) {
        PressAnnouncementBody = pressAnnouncementBody;
    }

    public boolean isHisHattrickSupporter() {
        return hisHattrickSupporter;
    }

    public void setHisHattrickSupporter(boolean hisHattrickSupporter) {
        this.hisHattrickSupporter = hisHattrickSupporter;
    }
}
