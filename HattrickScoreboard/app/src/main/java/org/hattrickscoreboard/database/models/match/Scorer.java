package org.hattrickscoreboard.database.models.match;

/**
 * @author Khips
 * @since 6 aot 2014
 */
public class Scorer {

    long _id;
    int MatchID;
    String SourceSystem;
    int ScorerPlayerID;
    String ScorerPlayerName;
    int ScorerTeamID;
    int ScorerHomeGoals;
    int ScorerAwayGoals;
    int ScorerMinute;

    public long getID() {
        return _id;
    }

    public void setID(long _id) {
        this._id = _id;
    }

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public int getScorerPlayerID() {
        return ScorerPlayerID;
    }

    public void setPlayerID(int scorerPlayerID) {
        ScorerPlayerID = scorerPlayerID;
    }

    public String getScorerPlayerName() {
        return ScorerPlayerName;
    }

    public void setPlayerName(String scorerPlayerName) {
        ScorerPlayerName = scorerPlayerName;
    }

    public int getScorerTeamID() {
        return ScorerTeamID;
    }

    public void setTeamID(int scorerTeamID) {
        ScorerTeamID = scorerTeamID;
    }

    public int getScorerHomeGoals() {
        return ScorerHomeGoals;
    }

    public void setHomeGoals(int scorerHomeGoals) {
        ScorerHomeGoals = scorerHomeGoals;
    }

    public int getScorerAwayGoals() {
        return ScorerAwayGoals;
    }

    public void setAwayGoals(int scorerAwayGoals) {
        ScorerAwayGoals = scorerAwayGoals;
    }

    public int getScorerMinute() {
        return ScorerMinute;
    }

    public void setMinute(int scorerMinute) {
        ScorerMinute = scorerMinute;
    }

}
