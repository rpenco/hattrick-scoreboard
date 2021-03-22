package org.hattrick.models.achievements;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Achievement {

    @Element
    int AchievementTypeID;

    @Element
    String AchievementText;

    @Element
    int CategoryID;

    @Element
    String EventDate;

    @Element
    int Points;

    @Element
    boolean MultiLevel;

    @Element
    int Rank;

    @Element
    int NumberOfEvents;

    public int getAchievementTypeID() {
        return AchievementTypeID;
    }

    public String getAchievementText() {
        return AchievementText;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public String getEventDate() {
        return EventDate;
    }

    public int getPoints() {
        return Points;
    }

    public boolean isMultiLevel() {
        return MultiLevel;
    }

    public int getRank() {
        return Rank;
    }

    public int getNumberOfEvents() {
        return NumberOfEvents;
    }

}
