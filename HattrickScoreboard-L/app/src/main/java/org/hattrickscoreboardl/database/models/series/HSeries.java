package org.hattrickscoreboardl.database.models.series;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HSeries extends HModel {

    public HSeries(){ }

    int LeagueID;

    String LeagueName;

    int LeagueLevel;

    int MaxLevel;

    int LeagueLevelUnitID;

    String LeagueLevelUnitName;

    int CurrentMatchRound;

    String FetchedDate;

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
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

    public int getLeagueLevel() {
        return LeagueLevel;
    }

    public void setLeagueLevel(int leagueLevel) {
        LeagueLevel = leagueLevel;
    }

    public int getMaxLevel() {
        return MaxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        MaxLevel = maxLevel;
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

    public int getCurrentMatchRound() {
        return CurrentMatchRound;
    }

    public void setCurrentMatchRound(int currentMatchRound) {
        CurrentMatchRound = currentMatchRound;
    }
}

