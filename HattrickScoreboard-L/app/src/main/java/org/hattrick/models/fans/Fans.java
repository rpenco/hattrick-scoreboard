package org.hattrick.models.fans;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class Fans {

    @Element
    @Path("Team")
    int TeamID;

    @Element
    @Path("Team")
    int FanclubId;

    @Element(required = false)
    @Path("Team")
    String FanClubName;

    @Element(required = false)
    @Path("Team")
    int FanMood;

    @Element
    @Path("Team")
    int Members;

    @Element
    @Path("Team")
    int FanSeasonExpectation;

    @ElementList()
    @Path("Team")
    ArrayList<Match> PlayedMatches;

    @ElementList
    @Path("Team")
    ArrayList<Match> UpcomingMatches;

    public int getTeamID() {
        return TeamID;
    }

    public int getFanClubId() {
        return FanclubId;
    }

    public String getFanClubName() {
        return FanClubName;
    }

    public int getFanMood() {
        return FanMood;
    }

    public int getMembers() {
        return Members;
    }

    public int getFanSeasonExpectation() {
        return FanSeasonExpectation;
    }

    public ArrayList<Match> getPlayedMatches() {
        return PlayedMatches;
    }

    public ArrayList<Match> getUpcomingMatches() {
        return UpcomingMatches;
    }

}
