package org.hattrick.models.matchorders;

import org.hattrick.models.match.PlayerLineup;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;

import java.util.ArrayList;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class MatchData {

    @Attribute
    boolean Available;

    @Element(required = false)
    @Path("HomeTeam")
    int HomeTeamID;

    @Element(required = false)
    @Path("HomeTeam")
    String HomeTeamName;

    @Element(required = false)
    @Path("AwayTeam")
    int AwayTeamID;

    @Element(required = false)
    @Path("AwayTeam")
    String AwayTeamName;

    @Element(required = false)
    @Path("Arena")
    int ArenaID;

    @Element(required = false)
    @Path("Arena")
    String ArenaName;

    @Element(required = false)
    String MatchDate;

    @Element(required = false)
    int MatchType;

    @Element(required = false)
    int Attitude;

    @Element(required = false)
    int TacticType;

    @ElementList(required = false)
    ArrayList<PlayerLineup> Lineup;

    @ElementList(required = false)
    ArrayList<PlayerOrder> PlayerOrders;

    public boolean isAvailable() {
        return Available;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public int getMatchType() {
        return MatchType;
    }

    public int getAttitude() {
        return Attitude;
    }

    public int getTacticType() {
        return TacticType;
    }

    public ArrayList<PlayerLineup> getLineup() {
        return Lineup;
    }

    public ArrayList<PlayerOrder> getPlayerOrders() {
        return PlayerOrders;
    }
}
