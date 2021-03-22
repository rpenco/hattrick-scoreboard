package org.hattrick.models.national;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class NationalCupTeam {

    @Element
    int CupNationalTeamID;

    @Element
    String CupNationalTeamName;

    public int getCupNationalTeamID() {
        return CupNationalTeamID;
    }

    public String getCupNationalTeamName() {
        return CupNationalTeamName;
    }
}
