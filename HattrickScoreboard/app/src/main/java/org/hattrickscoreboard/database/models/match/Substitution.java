package org.hattrickscoreboard.database.models.match;

/**
 * @author Khips
 * @since 7 aot 2014
 */
public class Substitution {

    long _id;
    int MatchID;
    String SourceSystem;
    int TeamID;
    int SubjectPlayerID;
    int ObjectPlayerID;
    int OrderType;
    int NewPositionId;
    int NewPositionBehaviour;
    int MatchMinute;

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

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public int getSubjectPlayerID() {
        return SubjectPlayerID;
    }

    public void setSubjectPlayerID(int subjectPlayerID) {
        SubjectPlayerID = subjectPlayerID;
    }

    public int getObjectPlayerID() {
        return ObjectPlayerID;
    }

    public void setObjectPlayerID(int objectPlayerID) {
        ObjectPlayerID = objectPlayerID;
    }

    public int getOrderType() {
        return OrderType;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }

    public int getNewPositionId() {
        return NewPositionId;
    }

    public void setNewPositionId(int newPositionId) {
        NewPositionId = newPositionId;
    }

    public int getNewPositionBehaviour() {
        return NewPositionBehaviour;
    }

    public void setNewPositionBehaviour(int newPositionBehaviour) {
        NewPositionBehaviour = newPositionBehaviour;
    }

    public int getMatchMinute() {
        return MatchMinute;
    }

    public void setMatchMinute(int matchMinute) {
        MatchMinute = matchMinute;
    }

}
