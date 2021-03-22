package org.hattrick.models.training;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class TrainingEvent {

    @Attribute
    int Index;

    @Element
    String EventDate;

    @Element
    int SkillID;

    @Element
    int OldLevel;

    @Element
    int NewLevel;

    @Element
    int Season;

    @Element
    int MatchRound;

    @Element
    int DayNumber;

    public int getIndex() {
        return Index;
    }

    public String getEventDate() {
        return EventDate;
    }

    public int getSkillID() {
        return SkillID;
    }

    public int getOldLevel() {
        return OldLevel;
    }

    public int getNewLevel() {
        return NewLevel;
    }

    public int getSeason() {
        return Season;
    }

    public int getMatchRound() {
        return MatchRound;
    }

    public int getDayNumber() {
        return DayNumber;
    }

}
