package org.hattrick.models.national;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class NationalTeams {

    @Element
    int LeagueOfficeTypeID;

    @Element
    @Path("Cup")
    int CupID;

    @ElementList
    ArrayList<NationalTeam> NationalTeams;

    @ElementList
    @Path("Cup")
    ArrayList<NationalCupTeam> CupTeams;

    public int getLeagueOfficeTypeID() {
        return LeagueOfficeTypeID;
    }

    public ArrayList<NationalTeam> getNationalTeams() {
        return NationalTeams;
    }

    public ArrayList<NationalCupTeam> getNationalCupTeams() {
        return CupTeams;
    }

    public int getCupID() {
        return CupID;
    }

    public ArrayList<NationalCupTeam> getCupTeams() {
        return CupTeams;
    }
}
