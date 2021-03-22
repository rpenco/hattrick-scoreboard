package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DStaff;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 19 avr. 2014
 */
public class RStaff {

    ArrayList<DStaff> stafflist = new ArrayList<DStaff>();

    // StaffAvatar;

    public RStaff(ArrayList<DStaff> staff) {
        this.stafflist = staff;
    }

    public ArrayList<DStaff> getStaff() {
        return stafflist;
    }

    public void setStaff(ArrayList<DStaff> staff) {
        this.stafflist = staff;
    }

    // ///////////////////////////////////////////////////////////

    public int nbStaff() {
        return stafflist.size();
    }

    /**
     * Get all staffs with type
     *
     * @param type 1,2,3,4,5,6
     * @return list
     */
    public ArrayList<DStaff> getStaffType(int type) {
        ArrayList<DStaff> res = new ArrayList<DStaff>();
        for (DStaff staff : stafflist) {
            if (staff.getStaffType() == type) {
                res.add(staff);
            }
        }
        return res;
    }

}
