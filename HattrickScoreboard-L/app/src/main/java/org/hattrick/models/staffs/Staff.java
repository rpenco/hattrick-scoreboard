package org.hattrick.models.staffs;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Staff {

    @Element
    String Name;

    @Element
    int StaffId;

    @Element
    int StaffType;

    @Element
    int StaffLevel;

    @Element
    String HiredDate;

    @Element
    int Cost;

    public String getName() {
        return Name;
    }

    public int getStaffID() {
        return StaffId;
    }

    public int getStaffType() {
        return StaffType;
    }

    public int getStaffLevel() {
        return StaffLevel;
    }

    public String getHiredDate() {
        return HiredDate;
    }

    public int getCost() {
        return Cost;
    }


}
