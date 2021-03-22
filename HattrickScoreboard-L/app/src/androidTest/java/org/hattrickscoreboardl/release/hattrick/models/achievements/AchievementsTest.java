package org.hattrickscoreboardl.release.hattrick.models.achievements;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.models.achievements.Achievement;
import org.hattrick.models.achievements.Achievements;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrickscoreboardl.utils.Hattrick;

import java.util.ArrayList;

/**
 * Created by romain
 * on 02/11/2014.
*/
public class AchievementsTest extends InstrumentationTestCase{

    HattrickParser parser;
    String PATH = "test/release/hattrick/models/";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //Init parser
        parser = new HattrickParser();
    }


    public void testAchievements() throws ParserException {

        //FILE 1 - ME
        Achievements res = parser.parse(Achievements.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "achievements", "achievements"));

        Assert.assertNotNull(res);
        Assert.assertNotNull(res.getAchievementList());
        Assert.assertEquals(16, res.getAchievementList().size());
        Assert.assertEquals(983, res.getMaxPoints());

        //Check all achievements
        ArrayList<Achievement> achievements = res.getAchievementList();
        for (int i = 0; i < achievements.size() ; i++) {
            Achievement ach = achievements.get(i);

            Assert.assertNotNull(ach.getAchievementText());
            Assert.assertNotNull(ach.getEventDate());
            Assert.assertTrue(ach.getAchievementTypeID() > 0);
            Assert.assertTrue(ach.getCategoryID() > 0);
            Assert.assertTrue(ach.getNumberOfEvents() > 0);
            Assert.assertTrue(ach.getPoints() > 0);
            Assert.assertTrue(ach.getRank() > 0);
        }

    }
}
