package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Substitution {

    private int id;

    @Element
    private String SubjectPlayerID;

    @Element
    private String TeamID;

    @Element
    private String ObjectPlayerID;

    @Element
    private String OrderType;

    @Element
    private String NewPositionId;

    @Element
    private String NewPositionBehaviour;

    @Element(required = false)
    private String MatchMinute;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectPlayerID() {
        return SubjectPlayerID;
    }

    public void setSubjectPlayerID(String subjectPlayerID) {
        SubjectPlayerID = subjectPlayerID;
    }

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getObjectPlayerID() {
        return ObjectPlayerID;
    }

    public void setObjectPlayerID(String objectPlayerID) {
        ObjectPlayerID = objectPlayerID;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        OrderType = orderType;
    }

    public String getNewPositionId() {
        return NewPositionId;
    }

    public void setNewPositionId(String newPositionId) {
        NewPositionId = newPositionId;
    }

    public String getNewPositionBehaviour() {
        return NewPositionBehaviour;
    }

    public void setNewPositionBehaviour(String newPositionBehaviour) {
        NewPositionBehaviour = newPositionBehaviour;
    }

    public String getMatchMinute() {
        return MatchMinute;
    }

    public void setMatchMinute(String matchMinute) {
        MatchMinute = matchMinute;
    }

}
