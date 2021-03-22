package org.hattrick.models.matches;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class MatchesArchive {

    @Element
    @Path("Team")
    int TeamID;

    @Element(required = false)
    @Path("Team")
    String TeamName;

    @Element(required = false)
    @Path("Team")
    String FirstMatchDate;

    @Element(required = false)
    @Path("Team")
    String LastMatchDate;

    @ElementList(required = false)
    @Path("Team")
    ArrayList<Match> MatchList;


    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getFirstMatchDate() {
        return FirstMatchDate;
    }

    public String getLastMatchDate() {
        return LastMatchDate;
    }

    public ArrayList<Match> getMatchList() {
        return MatchList;
    }

}
