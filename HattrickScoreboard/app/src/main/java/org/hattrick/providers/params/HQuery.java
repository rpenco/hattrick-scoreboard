package org.hattrick.providers.params;

import org.hattrickscoreboard.database.models.DTeam;

/**
 * @author Khips
 * @since 23 june 2014
 */
public class HQuery {

    private DTeam subjectTeam;
    private DTeam objectTeam;
    private Object customObject;

    private int teamID;

    private boolean youth;

    public HQuery() {

    }

    public HQuery(DTeam subjectTeam, DTeam objectTeam) {
        this.subjectTeam = subjectTeam;
        this.objectTeam = objectTeam;
    }

    public DTeam getSubjectTeam() {
        return subjectTeam;
    }

    public void setSubjectTeam(DTeam subjectTeam) {
        this.subjectTeam = subjectTeam;
    }

    public DTeam getObjectTeam() {
        return objectTeam;
    }

    public void setObjectTeam(DTeam objectTeam) {
        this.objectTeam = objectTeam;
    }

    public int getTeamID() {
        if (teamID != 0)
            return teamID;
        else {
            if (subjectTeam != null)
                return subjectTeam.getTeamID();
            else if (objectTeam != null)
                return objectTeam.getTeamID();
            else
                return -1;
        }
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public boolean isYouth() {
        return youth;
    }

    public void setYouth(boolean youth) {
        this.youth = youth;
    }

    public Object getCustomObject() {
        return customObject;
    }

    public void setCustomObject(Object customObject) {
        this.customObject = customObject;
    }

}
