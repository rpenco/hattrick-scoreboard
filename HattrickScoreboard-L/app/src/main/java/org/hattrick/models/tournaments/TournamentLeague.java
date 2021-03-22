package org.hattrick.models.tournaments;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class TournamentLeague {

    @Element
    int GroupId;

    @ElementList
    ArrayList<TournamentTeam> Teams;

    public int getGroupId() {
        return GroupId;
    }

    public ArrayList<TournamentTeam> getTeams() {
        return Teams;
    }
}
