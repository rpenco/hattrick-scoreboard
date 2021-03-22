package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(name = "HattrickData", strict = false)
public class MatchDetails {

    @Element
    private String SourceSystem;

    @Element
    @Path("Match")
    private int MatchID;

    @Element
    @Path("Match")
    private int MatchType;

    @Element
    @Path("Match")
    private String MatchDate;

    @Element
    @Path("Match")
    private int MatchContextId;

    @Element(required = false)
    @Path("Match")
    private String FinishedDate;

    @Element
    @Path("Match")
    private MatchTeam HomeTeam;

    @Element
    @Path("Match")
    private MatchTeam AwayTeam;

    @Element
    @Path("Match/Arena")
    private int ArenaID;

    @Element(required = false)
    @Path("Match/Arena")
    private String ArenaName;

    @Element(required = false)
    @Path("Match/Arena")
    private int WeatherID;

    @Element(required = false)
    @Path("Match/Arena")
    private int SoldTotal;

    @Element(required = false)
    @Path("Match/Arena")
    private int SoldTerraces;

    @Element(required = false)
    @Path("Match/Arena")
    private int SoldBasic;

    @Element(required = false)
    @Path("Match/Arena")
    private int SoldRoof;

    @Element(required = false)
    @Path("Match/Arena")
    private int SoldVIP;

    @Element(required = false)
    @Path("Match")
    private int PossessionFirstHalfHome;

    @Element(required = false)
    @Path("Match")
    private int PossessionFirstHalfAway;

    @Element(required = false)
    @Path("Match")
    private int PossessionSecondHalfHome;

    @Element(required = false)
    @Path("Match")
    private int PossessionSecondHalfAway;

    @ElementList(name = "Scorers", required = false)
    @Path("Match")
    private ArrayList<Goal> Scorers;

    @ElementList(name = "Bookings", required = false)
    @Path("Match")
    private ArrayList<Booking> Bookings;

    @ElementList(name = "Injuries", required = false)
    @Path("Match")
    private ArrayList<Injury> Injuries;

    @Element(name = "Referee", required = false)
    @Path("Match/MatchOfficials")
    private Referee Referee;

    @Element(name = "RefereeAssistant1", required = false)
    @Path("Match/MatchOfficials")
    private Referee RefereeAssistant1;

    @Element(name = "RefereeAssistant2", required = false)
    @Path("Match/MatchOfficials")
    private Referee RefereeAssistant2;

    @ElementList(name = "EventList", required = false)
    @Path("Match")
    private ArrayList<Event> EventList;

    public String getSourceSystem() {
        return SourceSystem;
    }

    public int getMatchID() {
        return MatchID;
    }

    public int getMatchType() {
        return MatchType;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public int getMatchContextId() {
        return MatchContextId;
    }

    public String getFinishedDate() {
        return FinishedDate;
    }

    public MatchTeam getHomeTeam() {
        return HomeTeam;
    }

    public MatchTeam getAwayTeam() {
        return AwayTeam;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getWeatherID() {
        return WeatherID;
    }

    public int getSoldTotal() {
        return SoldTotal;
    }

    public int getSoldTerraces() {
        return SoldTerraces;
    }

    public int getSoldBasic() {
        return SoldBasic;
    }

    public int getSoldRoof() {
        return SoldRoof;
    }

    public int getSoldVIP() {
        return SoldVIP;
    }

    public int getPossessionFirstHalfHome() {
        return PossessionFirstHalfHome;
    }

    public int getPossessionFirstHalfAway() {
        return PossessionFirstHalfAway;
    }

    public int getPossessionSecondHalfHome() {
        return PossessionSecondHalfHome;
    }

    public int getPossessionSecondHalfAway() {
        return PossessionSecondHalfAway;
    }

    public ArrayList<Goal> getScorers() {
        return Scorers;
    }

    public ArrayList<Booking> getBookings() {
        return Bookings;
    }

    public ArrayList<Injury> getInjuries() {
        return Injuries;
    }

    public Referee getReferee() {
        return Referee;
    }

    public Referee getRefereeAssistant1() {
        return RefereeAssistant1;
    }

    public Referee getRefereeAssistant2() {
        return RefereeAssistant2;
    }

    public ArrayList<Event> getEventList() {
        return EventList;
    }
}
