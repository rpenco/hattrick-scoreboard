package org.hattrickscoreboardl.database.models.teams;

import com.orm.SugarRecord;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HFlag extends SugarRecord<HFlag> {


    public HFlag(){}

    int TeamID;

    int LeagueId;

    String LeagueName;

    String CountryCode;

    String FlagType;

    //Getter

    public int getTeamID() {
        return TeamID;
    }

    public int getLeagueId() {
        return LeagueId;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getFlagType() {
        return FlagType;
    }


    //Setter
    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setLeagueId(int leagueId) {
        LeagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        LeagueName = leagueName;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public void setFlagType(String flagType) {
        FlagType = flagType;
    }
}

