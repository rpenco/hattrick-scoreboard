package org.hattrick.models.managers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class ManagerYouthTeam {

    @Element(required = false)
    int YouthTeamId;

    @Element(required = false)
    String YouthTeamName;

    @Element(required = false)
    @Path("YouthLeague")
    int YouthLeagueId;

    @Element(required = false)
    @Path("YouthLeague")
    String YouthLeagueName;

    public String getYouthLeagueName() {
        return YouthLeagueName;
    }

    public int getYouthTeamId() {
        return YouthTeamId;
    }

    public String getYouthTeamName() {
        return YouthTeamName;
    }

    public int getYouthLeagueId() {
        return YouthLeagueId;
    }
}
