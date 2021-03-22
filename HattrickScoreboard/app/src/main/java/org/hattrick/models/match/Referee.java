package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Referee {

    @Element
    private String RefereeId;
    @Element
    private String RefereeName;
    @Element
    private String RefereeCountryId;
    @Element
    private String RefereeCountryName;
    @Element
    private String RefereeTeamId;
    @Element
    private String RefereeTeamname;

    public String getId() {
        return RefereeId;
    }

    public void setRefereeId(String refereeId) {
        RefereeId = refereeId;
    }

    public String getName() {
        return RefereeName;
    }

    public void setRefereeName(String refereeName) {
        RefereeName = refereeName;
    }

    public String getCountryID() {
        return RefereeCountryId;
    }

    public void setRefereeCountryId(String refereeCountryId) {
        RefereeCountryId = refereeCountryId;
    }

    public String getCountryName() {
        return RefereeCountryName;
    }

    public void setRefereeCountryName(String refereeCountryName) {
        RefereeCountryName = refereeCountryName;
    }

    public String getTeamID() {
        return RefereeTeamId;
    }

    public void setRefereeTeamId(String refereeTeamId) {
        RefereeTeamId = refereeTeamId;
    }

    public String getTeamName() {
        return RefereeTeamname;
    }

    public void setRefereeTeamname(String refereeTeamname) {
        RefereeTeamname = refereeTeamname;
    }

}
