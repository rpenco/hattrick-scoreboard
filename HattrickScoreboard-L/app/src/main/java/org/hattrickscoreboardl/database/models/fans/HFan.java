package org.hattrickscoreboardl.database.models.fans;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HFan extends HModel {

    public HFan(){ }

    int TeamID;

    int FanclubId;

    String FanClubName;

    int FanMood;

    int Members;

    int FanSeasonExpectation;

    String FetchedDate;

    //Getter


    public int getTeamID() {
        return TeamID;
    }

    public int getFanclubId() {
        return FanclubId;
    }

    public String getFanClubName() {
        return FanClubName;
    }

    public int getFanMood() {
        return FanMood;
    }

    public int getMembers() {
        return Members;
    }

    public int getFanSeasonExpectation() {
        return FanSeasonExpectation;
    }
    public String getFetchedDate() {
        return FetchedDate;
    }

    //Setter


    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setFanclubId(int fanclubId) {
        FanclubId = fanclubId;
    }

    public void setFanClubName(String fanClubName) {
        FanClubName = fanClubName;
    }

    public void setFanMood(int fanMood) {
        FanMood = fanMood;
    }

    public void setMembers(int members) {
        Members = members;
    }

    public void setFanSeasonExpectation(int fanSeasonExpectation) {
        FanSeasonExpectation = fanSeasonExpectation;
    }
    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }
}

