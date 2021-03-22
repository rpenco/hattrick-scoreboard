package org.hattrickscoreboard.application.views.staff;

import org.hattrickscoreboard.database.models.DStaff;

import java.util.ArrayList;

public class StaffStat {

    ArrayList<DStaff> staffs;

    public StaffStat(ArrayList<DStaff> staffs) {
        this.staffs = staffs;
    }

    public int size() {
        if (staffs != null)
            return staffs.size();
        else
            return 0;
    }

    public double cost() {
        double result = 0;
        for (DStaff staff : staffs) {
            result += staff.getCost();
        }
        return result;
    }

}
