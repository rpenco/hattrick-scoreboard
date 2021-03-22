package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Substitution {

    @Element
    private int SubjectPlayerID;

    @Element
    private int TeamID;

    @Element
    private int ObjectPlayerID;

    @Element
    private int OrderType;

    @Element
    private int NewPositionId;

    @Element
    private int NewPositionBehaviour;

    @Element(required = false)
    private int MatchMinute;

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
}
