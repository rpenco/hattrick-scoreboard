package org.hattrick.models.youth;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class YouthLeagueDetails {

    @Element
    int YouthLeagueID;

    @Element
    String YouthLeagueName;

    @Element
    int YouthLeagueType;

    @Element
    int Season;

    @Element
    int LastMatchRound;

    @Element
    int NrOfTeamsInLeague;

    @ElementList
    ArrayList<YouthTeam> Teams;

    public int getYouthLeagueID() {
        return YouthLeagueID;
    }

    public String getYouthLeagueName() {
        return YouthLeagueName;
    }

    public int getYouthLeagueType() {
        return YouthLeagueType;
    }

    public int getSeason() {
        return Season;
    }

    public int getLastMatchRound() {
        return LastMatchRound;
    }

    public int getNrOfTeamsInLeague() {
        return NrOfTeamsInLeague;
    }

    public ArrayList<YouthTeam> getTeams() {
        return Teams;
    }
}
