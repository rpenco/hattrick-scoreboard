package org.hattrick.models.match;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Event {

    @Attribute
    public String Index;

    @Element
    public int Minute;

    @Element
    public String SubjectPlayerID;

    @Element
    public String SubjectTeamID;

    @Element
    public String ObjectPlayerID;

    @ElementUnion({@Element(name = "EventTypeID"), @Element(name = "EventKey")})
    @Element(required = false)
    public String EventTypeID;

    @Element(required = false)
    public String EventVariation;

    @Element(required = false)
    public String EventText;

    public int getIndex() {
        return Integer.parseInt(Index);
    }

    public void setIndex(String index) {
        Index = index;
    }

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int minute) {
        Minute = minute;
    }

    public String getSubjectPlayerID() {
        return SubjectPlayerID;
    }

    public void setSubjectPlayerID(String subjectPlayerID) {
        SubjectPlayerID = subjectPlayerID;
    }

    public String getSubjectTeamID() {
        return SubjectTeamID;
    }

    public void setSubjectTeamID(String subjectTeamID) {
        SubjectTeamID = subjectTeamID;
    }

    public String getObjectPlayerID() {
        return ObjectPlayerID;
    }

    public void setObjectPlayerID(String objectPlayerID) {
        ObjectPlayerID = objectPlayerID;
    }

    public String getEventTypeID() {
        return EventTypeID;
    }

    public void setEventTypeID(String eventTypeID) {
        EventTypeID = eventTypeID;
    }

    public String getEventVariation() {
        return EventVariation;
    }

    public void setEventVariation(String eventVariation) {
        EventVariation = eventVariation;
    }

    public String getEventText() {
        return EventText;
    }

    public void setEventText(String eventText) {
        EventText = eventText;
    }

    @Override
    public String toString() {
        return "Event > index: " + Index + " - " + Minute + "' - event type: "
                + EventTypeID;
    }

}
