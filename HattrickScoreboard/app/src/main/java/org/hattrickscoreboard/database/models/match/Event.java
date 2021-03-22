package org.hattrickscoreboard.database.models.match;

/**
 * @author Khips
 * @since 6 aot 2014
 */
public class Event {

    long _id;
    int MatchID;
    String SourceSystem;

    int Index;
    int SubjectPlayerID;
    int SubjectTeamID;
    int ObjectPlayerID;
    int EventTypeID;
    int EventVariation;
    String EventText;
    int Minute;

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

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int scorerMinute) {
        Minute = scorerMinute;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public int getSubjectPlayerID() {
        return SubjectPlayerID;
    }

    public void setSubjectPlayerID(int subjectPlayerID) {
        SubjectPlayerID = subjectPlayerID;
    }

    public int getSubjectTeamID() {
        return SubjectTeamID;
    }

    public void setSubjectTeamID(int subjectTeamID) {
        SubjectTeamID = subjectTeamID;
    }

    public int getObjectPlayerID() {
        return ObjectPlayerID;
    }

    public void setObjectPlayerID(int objectPlayerID) {
        ObjectPlayerID = objectPlayerID;
    }

    public int getEventTypeID() {
        return EventTypeID;
    }

    public void setEventTypeID(int eventTypeID) {
        EventTypeID = eventTypeID;
    }

    public int getEventVariation() {
        return EventVariation;
    }

    public void setEventVariation(int eventVariation) {
        EventVariation = eventVariation;
    }

    public String getEventText() {
        return EventText;
    }

    public void setEventText(String eventText) {
        EventText = eventText;
    }


}
