package org.hattrick.models.staffs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class StaffList {

    @ElementList
    @Path("StaffList")
    ArrayList<Staff> StaffMembers;

    @Element
    @Path("StaffList")
    String TotalStaffMembers;

    @Element
    @Path("StaffList")
    String TotalCost;

    public ArrayList<Staff> getStaffMembers() {
        return StaffMembers;
    }

    public String getTotalStaffMembers() {
        return TotalStaffMembers;
    }

    public String getTotalCost() {
        return TotalCost;
    }

}
