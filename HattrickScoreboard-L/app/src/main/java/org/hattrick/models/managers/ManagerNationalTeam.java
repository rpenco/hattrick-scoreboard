package org.hattrick.models.managers;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class ManagerNationalTeam {

    @Element(required = false)
    int NationalTeamId;

    @Element(required = false)
    String NationalTeamName;

    public int getNationalTeamId() {
        return NationalTeamId;
    }

    public String getNationalTeamName() {
        return NationalTeamName;
    }
}
