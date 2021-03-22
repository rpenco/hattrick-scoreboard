package org.hattrickscoreboard.database.relations;

import org.hattrickscoreboard.database.models.DLive;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Booking;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.Injury;
import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.models.match.Referee;
import org.hattrickscoreboard.database.models.match.Scorer;
import org.hattrickscoreboard.database.models.match.Substitution;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 6 aot 2014
 */
public class RMatch {

    private Match match;
    private DTeam teamHome;
    private DTeam teamAway;

    private ArrayList<Substitution> substitutions;
    private ArrayList<LineUp> homeLineup;
    private ArrayList<Booking> bookings;
    private ArrayList<Injury> injuryies;
    private ArrayList<Referee> referees;
    private ArrayList<Scorer> scorers;
    private ArrayList<LineUp> awayLineup;
    private ArrayList<Event> events;
    private DLive live;

    public Match getMatch() {
        return this.match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public DTeam getHomeTeam() {
        return teamHome;
    }

    public void setTeamHome(DTeam teamHome) {
        this.teamHome = teamHome;
    }

    public DTeam getAwayTeam() {
        return teamAway;
    }

    public void setTeamAway(DTeam teamAway) {
        this.teamAway = teamAway;
    }

    public ArrayList<Substitution> getSubstitutions() {
        return substitutions;
    }

    public void setSubstitutions(ArrayList<Substitution> substitutions) {
        this.substitutions = substitutions;
    }

    public ArrayList<LineUp> getHomeLineup() {
        return homeLineup;
    }

    public void setHomeLineup(ArrayList<LineUp> lineup) {
        this.homeLineup = lineup;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public ArrayList<Injury> getInjuryies() {
        return injuryies;
    }

    public void setInjuryies(ArrayList<Injury> injuryies) {
        this.injuryies = injuryies;
    }

    public ArrayList<Referee> getReferees() {
        return referees;
    }

    public void setReferees(ArrayList<Referee> referees) {
        this.referees = referees;
    }

    public ArrayList<Scorer> getScorers() {
        return scorers;
    }

    public void setScorers(ArrayList<Scorer> scorers) {
        this.scorers = scorers;
    }

    public ArrayList<LineUp> getAwayLineup() {
        return awayLineup;
    }

    public void setAwayLineup(ArrayList<LineUp> lineup) {
        this.awayLineup = lineup;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public DLive getLive() {
        return live;
    }

    public void setLive(DLive live) {
        this.live = live;
    }
}
