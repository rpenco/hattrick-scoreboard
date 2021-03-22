package org.hattrick.models.match;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Goal {

    @Attribute
    private int Index;

    private int id;

    @Element
    private String ScorerPlayerID;
    @Element
    private String ScorerPlayerName;
    @Element
    private String ScorerTeamID;
    @Element
    private String ScorerHomeGoals;
    @Element
    private String ScorerAwayGoals;
    @Element
    private String ScorerMinute;

    public String getPlayerID() {
        return ScorerPlayerID;
    }

    public void setScorerPlayerID(String scorerPlayerID) {
        ScorerPlayerID = scorerPlayerID;
    }

    public String getPlayerName() {
        return ScorerPlayerName;
    }

    public void setScorerPlayerName(String scorerPlayerName) {
        ScorerPlayerName = scorerPlayerName;
    }

    public String getTeamID() {
        return ScorerTeamID;
    }

    public void setScorerTeamID(String scorerTeamID) {
        ScorerTeamID = scorerTeamID;
    }

    public String getHomeGoals() {
        return ScorerHomeGoals;
    }

    public void setScorerHomeGoals(String scorerHomeGoals) {
        ScorerHomeGoals = scorerHomeGoals;
    }

    public String getAwayGoals() {
        return ScorerAwayGoals;
    }

    public void setScorerAwayGoals(String scorerAwayGoals) {
        ScorerAwayGoals = scorerAwayGoals;
    }

    public String getMinute() {
        return ScorerMinute;
    }

    public void setScorerMinute(String scorerMinute) {
        ScorerMinute = scorerMinute;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
