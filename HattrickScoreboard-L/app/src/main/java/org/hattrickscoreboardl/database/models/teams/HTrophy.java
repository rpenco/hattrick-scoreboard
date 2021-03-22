package org.hattrickscoreboardl.database.models.teams;

import com.orm.SugarRecord;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HTrophy extends SugarRecord<HTrophy> {


    public HTrophy(){}

    int TeamID;

    int TrophyTypeId;

    int TrophySeason;

    int LeagueLevel;

    String LeagueLevelUnitName;

    String GainedDate;

    String ImageUrl;

    //Getter

    public int getTeamID() {
        return TeamID;
    }

    public int getTrophyTypeId() {
        return TrophyTypeId;
    }

    public int getTrophySeason() {
        return TrophySeason;
    }

    public int getLeagueLevel() {
        return LeagueLevel;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    public String getGainedDate() {
        return GainedDate;
    }

    public String getImageUrl() {
        return ImageUrl;
    }


    //Setter

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setTrophyTypeId(int trophyTypeId) {
        TrophyTypeId = trophyTypeId;
    }

    public void setTrophySeason(int trophySeason) {
        TrophySeason = trophySeason;
    }

    public void setLeagueLevel(int leagueLevel) {
        LeagueLevel = leagueLevel;
    }

    public void setLeagueLevelUnitName(String leagueLevelUnitName) {
        LeagueLevelUnitName = leagueLevelUnitName;
    }

    public void setGainedDate(String gainedDate) {
        GainedDate = gainedDate;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}

