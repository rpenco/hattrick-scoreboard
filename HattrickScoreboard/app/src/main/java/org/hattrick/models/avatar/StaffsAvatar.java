package org.hattrick.models.avatar;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "HattrickData", strict = false)
public class StaffsAvatar {

    @ElementList
    private List<StaffAvatar> StaffMembers;


    public List<StaffAvatar> getStaff() {
        return StaffMembers;
    }

}
