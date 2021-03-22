package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Referee {

    @Element
    private int RefereeId;
    @Element(required = false)
    private String RefereeName;
    @Element
    private int RefereeCountryId;
    @Element(required = false)
    private String RefereeCountryName;
    @Element
    private int RefereeTeamId;
    @Element(required = false)
    private String RefereeTeamname;


    public int getRefereeId() {
        return RefereeId;
    }

    public String getRefereeName() {
        return RefereeName;
    }

    public int getRefereeCountryId() {
        return RefereeCountryId;
    }

    public String getRefereeCountryName() {
        return RefereeCountryName;
    }

    public int getRefereeTeamId() {
        return RefereeTeamId;
    }

    public String getRefereeTeamname() {
        return RefereeTeamname;
    }
}
