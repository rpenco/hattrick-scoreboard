package org.hattrickscoreboardl.database.models.training;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HTrainingEvent extends HModel {

    public HTrainingEvent(){}

    int EventIndex;

    String EventDate;

    int SkillID;

    int OldLevel;

    int NewLevel;

    int Season;

    int MatchRound;

    int DayNumber;

    public int getIndex() {
        return EventIndex;
    }

    public void setEventIndex(int index) {
        EventIndex = index;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }

    public int getSkillID() {
        return SkillID;
    }

    public void setSkillID(int skillID) {
        SkillID = skillID;
    }

    public int getOldLevel() {
        return OldLevel;
    }

    public void setOldLevel(int oldLevel) {
        OldLevel = oldLevel;
    }

    public int getNewLevel() {
        return NewLevel;
    }

    public void setNewLevel(int newLevel) {
        NewLevel = newLevel;
    }

    public int getSeason() {
        return Season;
    }

    public void setSeason(int season) {
        Season = season;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public void setMatchRound(int matchRound) {
        MatchRound = matchRound;
    }

    public int getDayNumber() {
        return DayNumber;
    }

    public void setDayNumber(int dayNumber) {
        DayNumber = dayNumber;
    }
}
