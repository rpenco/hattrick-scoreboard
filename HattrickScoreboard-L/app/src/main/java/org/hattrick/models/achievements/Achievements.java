package org.hattrick.models.achievements;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class Achievements {

    @Element
    int MaxPoints;

    @ElementList
    ArrayList<Achievement> AchievementList;

    public int getMaxPoints() {
        return MaxPoints;
    }

    public ArrayList<Achievement> getAchievementList() {
        return AchievementList;
    }


}
