package org.hattrick.models.ladders;

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
public class LadderDetails {

    @Element
    @Path("Ladder")
    int LadderId;

    @Element
    @Path("Ladder")
    String Name;

    @Element
    @Path("Ladder")
    int NumOfTeams;

    @Element
    @Path("Ladder")
    int PageSize;

    @Element
    @Path("Ladder")
    int PageIndex;

    @Element
    @Path("Ladder")
    int KingTeamId;

    @Element
    @Path("Ladder")
    String KingTeamName;

    @Element
    @Path("Ladder")
    String KingSince;

    @ElementList(name = "Team", inline = true)
    @Path("Ladder")
    ArrayList<LadderTeam> Teams;

    public int getLadderId() {
        return LadderId;
    }

    public String getName() {
        return Name;
    }

    public int getNumOfTeams() {
        return NumOfTeams;
    }

    public int getPageSize() {
        return PageSize;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public int getKingTeamId() {
        return KingTeamId;
    }

    public String getKingTeamName() {
        return KingTeamName;
    }

    public String getKingSince() {
        return KingSince;
    }

    public ArrayList<LadderTeam> getTeams() {
        return Teams;
    }
}
