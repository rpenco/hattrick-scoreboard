package org.hattrickscoreboardl.release.hattrick.models.arenas;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.models.arenas.ArenaDetails;
import org.hattrick.models.arenas.ArenaStat;
import org.hattrick.models.arenas.CurrentCapacity;
import org.hattrick.models.arenas.ExpandedCapacity;
import org.hattrick.models.arenas.MyArena;
import org.hattrick.models.arenas.OtherArenas;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrickscoreboardl.utils.Hattrick;

/**
 * Created by romain
 * on 02/11/2014.
*/
public class ArenasTest extends InstrumentationTestCase {

    HattrickParser parser;
    String PATH = "test/release/hattrick/models/";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //Init parser
        parser = new HattrickParser();
    }


    public void testArena() throws ParserException {

        //FILE 1
        ArenaDetails res = parser.parse(ArenaDetails.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "arenas", "arenadetails"));

        Assert.assertNotNull(res);
        Assert.assertNotNull(res.getArenaName());
        Assert.assertTrue(res.getArenaID() > 0);
        Assert.assertTrue(res.getLeagueID() > 0);
        Assert.assertTrue(res.getRegionID() > 0);
        Assert.assertTrue(res.getTeamID() > 0);
        Assert.assertNotNull(res.getLeagueName());
        Assert.assertNotNull(res.getRegionName());
        Assert.assertNotNull(res.getTeamName());

        CurrentCapacity cur = res.getCurrentCapacity();
        Assert.assertNotNull(cur.getRebuiltDate());
        Assert.assertTrue(cur.getBasic() > 0);
        Assert.assertTrue(cur.getRoof() > 0);
        Assert.assertTrue(cur.getTerraces() > 0);
        Assert.assertTrue(cur.getTotal() > 0);
        Assert.assertTrue(cur.getVIP() > 0);

        ExpandedCapacity exp = res.getExpandedCapacity();
        Assert.assertNull(exp);

    }

    public void testArenaBuilding() throws ParserException {

        //FILE 2
        ArenaDetails res = parser.parse(ArenaDetails.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "arenas", "arenadetails-building"));


        Assert.assertNotNull(res);
        Assert.assertNotNull(res.getArenaName());
        Assert.assertTrue(res.getArenaID() > 0);
        Assert.assertTrue(res.getLeagueID() > 0);
        Assert.assertTrue(res.getRegionID() > 0);
        Assert.assertTrue(res.getTeamID() > 0);
        Assert.assertNotNull(res.getLeagueName());
        Assert.assertNotNull(res.getRegionName());
        Assert.assertNotNull(res.getTeamName());

        CurrentCapacity cur = res.getCurrentCapacity();
        Assert.assertNull(cur.getRebuiltDate());
        Assert.assertTrue(cur.getBasic() > 0);
        Assert.assertTrue(cur.getRoof() > 0);
        Assert.assertTrue(cur.getTerraces() > 0);
        Assert.assertTrue(cur.getTotal() > 0);
        Assert.assertTrue(cur.getVIP() > 0);

        ExpandedCapacity exp = res.getExpandedCapacity();
        Assert.assertNotNull(exp.getExpansionDate());
        Assert.assertTrue(exp.getBasic() > 0);
        Assert.assertTrue(exp.getRoof() > 0);
        Assert.assertTrue(exp.getTerraces() > 0);
        Assert.assertTrue(exp.getTotal() > 0);
        Assert.assertTrue(exp.getVIP() > 0);
    }

    public void testMyArena() throws ParserException {

        //FILE 2
        MyArena res = parser.parse(MyArena.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "arenas", "myarena-supporters"));

        Assert.assertNotNull(res);
        Assert.assertTrue(res.getArenaID() > 0);
        Assert.assertTrue(res.getAverageBasic() > 0);
        Assert.assertTrue(res.getAverageRoof() > 0);
        Assert.assertTrue(res.getAverageTerraces() > 0);

    }

    public void testOtherArenas() throws ParserException {

        //FILE 2
        OtherArenas res = parser.parse(OtherArenas.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "arenas", "othersarena-supporters"));

        Assert.assertNotNull(res);
        Assert.assertNotNull(res.getArenas());

        for(int i = 0; i < res.getArenas().size(); i++){

            ArenaStat arena = res.getArenas().get(i);
            Assert.assertNotNull(arena);
            Assert.assertTrue(arena.getArenaID() > 0);
            Assert.assertTrue(arena.getArenaLeagueID() > 0);
            Assert.assertTrue(arena.getArenaSize() > 0);
            Assert.assertTrue(arena.getArenaRegionId() > 0);
        }


    }
}
