package org.hattrick.models.challenges;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class Challenge {

    @Element
    int TrainingMatchID;

    @Element
    String MatchTime;

    @Element
    int MatchID;

    @Element
    int FriendlyType;

    @Element
    @Path("Opponent")
    int TeamID;

    @Element
    @Path("Opponent")
    String TeamName;

    @Element(required = false)
    @Path("Opponent")
    String LogoURL;

    @Element
    @Path("Arena")
    int ArenaID;

    @Element
    @Path("Arena")
    String ArenaName;

    @Element
    @Path("League")
    int LeagueID;

    @Element
    @Path("League")
    String LeagueName;

    @Element
    boolean IsAgreed;


    public int getTrainingMatchID() {
        return TrainingMatchID;
    }

    public String getMatchTime() {
        return MatchTime;
    }

    public int getMatchID() {
        return MatchID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public int getArenaID() {
        return ArenaID;
    }

    public String getArenaName() {
        return ArenaName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public boolean isAgreed() {
        return IsAgreed;
    }

    public int getFriendlyType() {
        return FriendlyType;
    }
}
