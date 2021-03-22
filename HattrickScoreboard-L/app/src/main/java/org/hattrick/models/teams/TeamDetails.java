package org.hattrick.models.teams;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class TeamDetails {

    @Element
    int UserID;

    @Element
    User User;

    @ElementList
    ArrayList<Team> Teams;

    public int getUserID() {
        return UserID;
    }

    public User getUser() {
        return User;
    }

    public ArrayList<Team> getTeams() {
        return Teams;
    }


}
