package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Collections;

@Root(name = "HattrickData", strict = false)
public class MatchDetails {

    @Element(required = false)
    private boolean UserSupporterTier;

    @Element
    private String SourceSystem;

    @Element
    @Path("Match")
    private String MatchID;

    @Element
    @Path("Match")
    private String MatchType;

    @Element
    @Path("Match")
    private String MatchDate;

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
    private String ArenaID;

    @Element(required = false)
    @Path("Match/Arena")
    private String ArenaName;

    @Element(required = false)
    @Path("Match/Arena")
    private String WeatherID;

    @Element(required = false)
    @Path("Match/Arena")
    private String SoldTotal;

    @Element(required = false)
    @Path("Match/Arena")
    private String SoldTerraces;

    @Element(required = false)
    @Path("Match/Arena")
    private String SoldBasic;

    @Element(required = false)
    @Path("Match/Arena")
    private String SoldRoof;

    @Element(required = false)
    @Path("Match/Arena")
    private String SoldVIP;

    @Element(required = false)
    @Path("Match")
    private String PossessionFirstHalfHome;

    @Element(required = false)
    @Path("Match")
    private String PossessionFirstHalfAway;

    @Element(required = false)
    @Path("Match")
    private String PossessionSecondHalfHome;

    @Element(required = false)
    @Path("Match")
    private String PossessionSecondHalfAway;

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

    public String getMatchID() {
        return MatchID;
    }

    public void setMatchID(String matchID) {
        MatchID = matchID;
    }

    public String getMatchType() {
        return MatchType;
    }

    public void setMatchType(String matchType) {
        MatchType = matchType;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(String matchDate) {
        MatchDate = matchDate;
    }

    public String getFinishedDate() {
        return FinishedDate;
    }

    public void setFinishedDate(String finishedDate) {
        FinishedDate = finishedDate;
    }

    public MatchTeam getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(MatchTeam homeTeam) {
        HomeTeam = homeTeam;
    }

    public MatchTeam getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(MatchTeam awayTeam) {
        AwayTeam = awayTeam;
    }

    public String getArenaID() {
        return ArenaID;
    }

    public void setArenaID(String arenaID) {
        ArenaID = arenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public void setArenaName(String arenaName) {
        ArenaName = arenaName;
    }

    public String getWeatherID() {
        return WeatherID;
    }

    public void setWeatherID(String weatherID) {
        WeatherID = weatherID;
    }

    public String getSoldTotal() {
        return SoldTotal;
    }

    public void setSoldTotal(String soldTotal) {
        SoldTotal = soldTotal;
    }

    public String getPossessionFirstHalfHome() {
        return PossessionFirstHalfHome;
    }

    public void setPossessionFirstHalfHome(String possessionFirstHalfHome) {
        PossessionFirstHalfHome = possessionFirstHalfHome;
    }

    public String getPossessionFirstHalfAway() {
        return PossessionFirstHalfAway;
    }

    public void setPossessionFirstHalfAway(String possessionFirstHalfAway) {
        PossessionFirstHalfAway = possessionFirstHalfAway;
    }

    public String getPossessionSecondHalfHome() {
        return PossessionSecondHalfHome;
    }

    public void setPossessionSecondHalfHome(String possessionSecondHalfHome) {
        PossessionSecondHalfHome = possessionSecondHalfHome;
    }

    public String getPossessionSecondHalfAway() {
        return PossessionSecondHalfAway;
    }

    public void setPossessionSecondHalfAway(String possessionSecondHalfAway) {
        PossessionSecondHalfAway = possessionSecondHalfAway;
    }

    public ArrayList<Goal> getScorers() {
        return Scorers;
    }

    public void setScorers(ArrayList<Goal> scorers) {
        Scorers = scorers;
    }

    public ArrayList<Booking> getBookings() {
        return Bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        Bookings = bookings;
    }

    public ArrayList<Injury> getInjuries() {
        return Injuries;
    }

    public void setInjuries(ArrayList<Injury> injuries) {
        Injuries = injuries;
    }

    public ArrayList<Event> getEventList() {
        return EventList;
    }

    public void setEventList(ArrayList<Event> eventList) {
        EventList = eventList;
    }

    public ArrayList<Event> getReverseEventList() {
        ArrayList<Event> reverseEvents = new ArrayList<Event>(EventList);
        Collections.reverse(reverseEvents);
        return reverseEvents;
    }

    public Referee getReferee() {
        return Referee;
    }

    public void setReferee(Referee referee) {
        Referee = referee;
    }

    public Referee getRefereeAssistant1() {
        return RefereeAssistant1;
    }

    public void setRefereeAssistant1(Referee refereeAssistant1) {
        RefereeAssistant1 = refereeAssistant1;
    }

    public Referee getRefereeAssistant2() {
        return RefereeAssistant2;
    }

    public void setRefereeAssistant2(Referee refereeAssistant2) {
        RefereeAssistant2 = refereeAssistant2;
    }

    public boolean isUserSupporterTier() {
        return UserSupporterTier;
    }

    public void setUserSupporterTier(boolean userSupporterTier) {
        UserSupporterTier = userSupporterTier;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public String getSoldTerraces() {
        return SoldTerraces;
    }

    public String getSoldBasic() {
        return SoldBasic;
    }

    public String getSoldRoof() {
        return SoldRoof;
    }

    public String getSoldVIP() {
        return SoldVIP;
    }

}
