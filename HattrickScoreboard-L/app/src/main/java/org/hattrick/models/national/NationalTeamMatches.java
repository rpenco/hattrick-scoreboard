package org.hattrick.models.national;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class NationalTeamMatches {

    @Element
    int LeagueOfficeTypeID;

   @ElementList
    ArrayList<NationalMatch> Matches;

    public int getLeagueOfficeTypeID() {
        return LeagueOfficeTypeID;
    }

    public ArrayList<NationalMatch> getMatches() {
        return Matches;
    }
}
