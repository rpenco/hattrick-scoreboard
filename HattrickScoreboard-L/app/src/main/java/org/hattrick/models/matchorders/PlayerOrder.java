package org.hattrick.models.matchorders;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class PlayerOrder {

    @Element
    int PlayerOrderID;

    @Element
    int MatchMinuteCriteria;

    @Element
    int GoalDiffCriteria;

    @Element
    int RedCardCriteria;

    @Element
    int SubjectPlayerID;

    @Element
    int ObjectPlayerID;

    @Element
    int OrderType;

    @Element
    int NewPositionId;

    @Element
    int NewPositionBehaviour;


    @Element(required = false)
    int PlayerOrderExtraInteger;

    public int getPlayerOrderExtraInteger() {
        return PlayerOrderExtraInteger;
    }

    public int getPlayerOrderID() {
        return PlayerOrderID;
    }

    public int getMatchMinuteCriteria() {
        return MatchMinuteCriteria;
    }

    public int getGoalDiffCriteria() {
        return GoalDiffCriteria;
    }

    public int getRedCardCriteria() {
        return RedCardCriteria;
    }

    public int getSubjectPlayerID() {
        return SubjectPlayerID;
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
}
