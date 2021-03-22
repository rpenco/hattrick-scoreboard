package org.hattrickscoreboardl.database.models.matches;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HReferer extends HModel {

    public HReferer(){ }



    int RefereerId;

    String Name;

    int CountryId;

    String CountryName;

    int TeamId;

    String TeamName;

    public int getRefereerId() {
        return RefereerId;
    }

    public void setRefereerId(int id) {
        RefereerId = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
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
}

