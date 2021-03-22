package org.hattrick.models.cups;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(strict = false)
public class CupMatches {

    @Element
    @Path("Cup")
    int CupID;

    @Element
    @Path("Cup")
    int CupSeason;

    @Element
    @Path("Cup")
    int CupRound;

    @Element
    @Path("Cup")
    String CupName;

    @ElementList(required = false)
    @Path("Cup")
    ArrayList<CupMatch> MatchList;

    public int getCupID() {
        return CupID;
    }

    public int getCupSeason() {
        return CupSeason;
    }

    public int getCupRound() {
        return CupRound;
    }

    public String getCupName() {
        return CupName;
    }

    public ArrayList<CupMatch> getMatchList() {
        return MatchList;
    }
}
