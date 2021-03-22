package org.hattrickscoreboardl.database.models.live;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HLiveEvent extends HModel {

    public HLiveEvent(){}

    int MatchID;

    String SourceSystem;

    int EventIndex;

    int Minute;

    int SubjectPlayerID;

    String SubjectPlayerName;

    int SubjectTeamID;

    int ObjectPlayerID;

    String ObjectPlayerName;

    int EventTypeID;

    int EventVariation;

    String EventText;

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

    public int getEventIndex() {
        return EventIndex;
    }

    public void setEventIndex(int eventIndex) {
        EventIndex = eventIndex;
    }

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int minute) {
        Minute = minute;
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

    public String getSubjectPlayerName() {
        return SubjectPlayerName;
    }

    public void setSubjectPlayerName(String subjectPlayerName) {
        SubjectPlayerName = subjectPlayerName;
    }

    public String getObjectPlayerName() {
        return ObjectPlayerName;
    }

    public void setObjectPlayerName(String objectPlayerName) {
        ObjectPlayerName = objectPlayerName;
    }
}

