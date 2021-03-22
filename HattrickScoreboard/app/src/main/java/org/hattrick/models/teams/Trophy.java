package org.hattrick.models.teams;

import android.annotation.SuppressLint;

import org.hattrick.constants.Hattrick;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Root(strict = false)
public class Trophy {

    @Element
    int TrophyTypeId;

    @Element
    int TrophySeason;

    @Element
    int LeagueLevel;

    @Element(required = false)
    String LeagueLevelUnitName;

    @Element
    String GainedDate;

    @Element(required = false)
    String ImageUrl;

    public int getTrophyTypeId() {
        return TrophyTypeId;
    }

    public int getTrophySeason() {
        return TrophySeason;
    }

    public int getLeagueLevel() {
        return LeagueLevel;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }

    @SuppressLint("SimpleDateFormat")
    public Date getGainedDate() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    Hattrick.DATETIME);
            ParsePosition pos = new ParsePosition(0);
            return formatter.parse(GainedDate, pos);
        } catch (RuntimeException e) {
            // e.printStackTrace();
        }
        return new Date();
    }

    public String getImageUrl() {
        return ImageUrl;
    }

}
