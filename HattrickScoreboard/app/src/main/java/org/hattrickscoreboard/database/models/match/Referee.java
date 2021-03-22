package org.hattrickscoreboard.database.models.match;

/**
 * @author Khips
 * @since 6 aot 2014
 */
public class Referee {

    long _id;
    int RefereeId;
    String RefereeName;
    int RefereeCountryId;
    String RefereeCountryName;
    int RefereeTeamId;
    String RefereeTeamname;

    public long getID() {
        return _id;
    }

    public void setID(long _id) {
        this._id = _id;
    }

    public int getRefereeId() {
        return RefereeId;
    }

    public void setId(int refereeId) {
        RefereeId = refereeId;
    }

    public String getRefereeName() {
        return RefereeName;
    }

    public void setName(String refereeName) {
        RefereeName = refereeName;
    }

    public int getRefereeCountryId() {
        return RefereeCountryId;
    }

    public void setCountryId(int refereeCountryId) {
        RefereeCountryId = refereeCountryId;
    }

    public String getRefereeCountryName() {
        return RefereeCountryName;
    }

    public void setCountryName(String refereeCountryName) {
        RefereeCountryName = refereeCountryName;
    }

    public int getRefereeTeamId() {
        return RefereeTeamId;
    }

    public void setTeamId(int refereeTeamId) {
        RefereeTeamId = refereeTeamId;
    }

    public String getRefereeTeamname() {
        return RefereeTeamname;
    }

    public void setTeamname(String refereeTeamname) {
        RefereeTeamname = refereeTeamname;
    }

}
