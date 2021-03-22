package org.hattrickscoreboardl.database.models.matches;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HEvent extends HModel {

    public HEvent(){ }

    int MatchID;

    int MatchContextID;

    int Minute;

    int SubjectPlayerID;

    String SubjectPlayerName;

    int SubjectTeamID;

    int ObjectPlayerID;

    String ObjectPlayerName;

    String EventTypeID;

    String EventVariation;

    String EventText;

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public int getMatchContextID() {
        return MatchContextID;
    }

    public void setMatchContextID(int matchContextID) {
        MatchContextID = matchContextID;
    }

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int minute) {
        Minute = minute;
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

    public int getSubjectPlayerID() {
        return SubjectPlayerID;
    }

    public String getSubjectPlayerName() {
        return SubjectPlayerName;
    }

    public int getSubjectTeamID() {
        return SubjectTeamID;
    }

    public int getObjectPlayerID() {
        return ObjectPlayerID;
    }

    public String getObjectPlayerName() {
        return ObjectPlayerName;
    }

    public void setSubjectPlayerID(int subjectPlayerID) {
        SubjectPlayerID = subjectPlayerID;
    }

    public void setSubjectPlayerName(String subjectPlayerName) {
        SubjectPlayerName = subjectPlayerName;
    }

    public void setSubjectTeamID(int subjectTeamID) {
        SubjectTeamID = subjectTeamID;
    }

    public void setObjectPlayerID(int objectPlayerID) {
        ObjectPlayerID = objectPlayerID;
    }

    public void setObjectPlayerName(String objectPlayerName) {
        ObjectPlayerName = objectPlayerName;
    }
}

