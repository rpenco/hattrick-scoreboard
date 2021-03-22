package org.hattrick.models.live;

import org.hattrick.models.match.Event;
import org.hattrick.models.match.Substitution;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Match", strict = false)
public class LiveMatch {

    @Element
    private int MatchID;

    @Element(required = false)
    private String MatchDate;

    @Element
    private String SourceSystem;

    @Element(required = false)
    private String HomeGoals;

    @Element(required = false)
    private String AwayGoals;

    @Element(required = false)
    @Path(value = "HomeTeam")
    private int HomeTeamID;

    @Element(required = false)
    @Path(value = "HomeTeam")
    private String HomeTeamName;

    @Element(required = false)
    @Path(value = "HomeTeam")
    private String HomeTeamNameShortName;

    @Element(required = false)
    @Path(value = "AwayTeam")
    private int AwayTeamID;

    @Element(required = false)
    @Path(value = "AwayTeam")
    private String AwayTeamName;

    @Element(required = false)
    @Path(value = "AwayTeam")
    private String AwayTeamNameShortName;

    @ElementList(required = false)
    private List<Substitution> Substitutions;

    @ElementList(required = false)
    private List<Event> EventList;

    @Element(required = false)
    private String LastShownEventIndex;

    @Element(required = false)
    private String NextEventMinute;

    public int getMatchID() {
        return MatchID;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public String getHomeGoals() {
        return HomeGoals;
    }

    public String getAwayGoals() {
        return AwayGoals;
    }

    public int getHomeTeamID() {
        return HomeTeamID;
    }

    public String getHomeTeamName() {
        return HomeTeamName;
    }

    public String getHomeTeamShortName() {
        return HomeTeamNameShortName;
    }

    public int getAwayTeamID() {
        return AwayTeamID;
    }

    public String getAwayTeamName() {
        return AwayTeamName;
    }

    public String getAwayTeamShortName() {
        return AwayTeamNameShortName;
    }

    public List<Substitution> getSubstitutions() {
        return Substitutions;
    }

    public List<Event> getEventList() {
        return EventList;
    }

    public String getLastShownEventIndex() {
        return LastShownEventIndex;
    }

    public String getNextEventMinute() {
        return NextEventMinute;
    }

}
