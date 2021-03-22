package org.hattrick.models.achievements;

import android.annotation.SuppressLint;

import org.hattrick.constants.Hattrick;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @SuppressLint("SimpleDateFormat")
    public Date getEventDate() {

        try {
            SimpleDateFormat formatter = new SimpleDateFormat(Hattrick.DATETIME);
            ParsePosition pos = new ParsePosition(0);
            return formatter.parse(EventDate, pos);
        } catch (RuntimeException e) {
            // e.printStackTrace();
        }
        return new Date();
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
