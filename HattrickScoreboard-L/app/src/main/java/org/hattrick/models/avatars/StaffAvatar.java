package org.hattrick.models.avatars;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Player", strict = false)
public class StaffAvatar {

    @Element
    private int StaffId;

    @Element
    private Avatar Avatar;

    public int getStaffID() {
        return StaffId;
    }

    public Avatar getAvatar() {
        return Avatar;
    }

}
