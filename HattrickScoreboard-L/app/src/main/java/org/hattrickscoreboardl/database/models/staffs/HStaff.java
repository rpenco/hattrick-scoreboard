package org.hattrickscoreboardl.database.models.staffs;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HStaff extends HModel {

    public HStaff(){}

    int teamID;

    String Name;

    int StaffId;

    int StaffType;

    int StaffLevel;

    String HiredDate;

    int Cost;

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStaffId() {
        return StaffId;
    }

    public void setStaffId(int staffId) {
        StaffId = staffId;
    }

    public int getStaffType() {
        return StaffType;
    }

    public void setStaffType(int staffType) {
        StaffType = staffType;
    }

    public int getStaffLevel() {
        return StaffLevel;
    }

    public void setStaffLevel(int staffLevel) {
        StaffLevel = staffLevel;
    }

    public String getHiredDate() {
        return HiredDate;
    }

    public void setHiredDate(String hiredDate) {
        HiredDate = hiredDate;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }
}
