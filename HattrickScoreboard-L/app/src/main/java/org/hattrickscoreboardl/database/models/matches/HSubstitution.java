package org.hattrickscoreboardl.database.models.matches;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HSubstitution extends HModel {

    public HSubstitution(){ }

    int MatchID;

    int MatchContextID;

    int SubjectPlayerID;

    int TeamID;

    int ObjectPlayerID;

    int OrderType;

    int NewPositionId;

    int NewPositionBehaviour;

    int MatchMinute;

    public int getMatchID() {
        return MatchID;
    }

    public int getMatchContextID() {
        return MatchContextID;
    }

    public int getSubjectPlayerID() {
        return SubjectPlayerID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public int getObjectPlayerID() {
        return ObjectPlayerID;
    }

    public int getOrderType() {
        return OrderType;
    }

    public int getNewPositionId() {
        return NewPositionId;
    }

    public int getNewPositionBehaviour() {
        return NewPositionBehaviour;
    }

    public int getMatchMinute() {
        return MatchMinute;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public void setMatchContextID(int matchContextID) {
        MatchContextID = matchContextID;
    }

    public void setSubjectPlayerID(int subjectPlayerID) {
        SubjectPlayerID = subjectPlayerID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public void setObjectPlayerID(int objectPlayerID) {
        ObjectPlayerID = objectPlayerID;
    }

    public void setOrderType(int orderType) {
        OrderType = orderType;
    }

    public void setNewPositionId(int newPositionId) {
        NewPositionId = newPositionId;
    }

    public void setNewPositionBehaviour(int newPositionBehaviour) {
        NewPositionBehaviour = newPositionBehaviour;
    }

    public void setMatchMinute(int matchMinute) {
        MatchMinute = matchMinute;
    }
}

