package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DBookmark;
import org.hattrickscoreboard.database.models.DTeam;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 21 avr. 2014
 */
public class RCommunity {

    ArrayList<DTeam> teams;
    ArrayList<DBookmark> bookmarks;

    public ArrayList<DTeam> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<DTeam> teams) {
        this.teams = teams;
    }

    public ArrayList<DBookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(ArrayList<DBookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
