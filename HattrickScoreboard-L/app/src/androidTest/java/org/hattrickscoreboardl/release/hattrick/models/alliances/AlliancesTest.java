package org.hattrickscoreboardl.release.hattrick.models.alliances;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.models.alliances.Alliance;
import org.hattrick.models.alliances.AllianceDetails;
import org.hattrick.models.alliances.Alliances;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrickscoreboardl.utils.Hattrick;

import java.util.ArrayList;

/**
 * Created by romain
 * on 02/11/2014.
*/
public class AlliancesTest extends InstrumentationTestCase{

    HattrickParser parser;
    String PATH = "test/release/hattrick/models/";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //Init parser
        parser = new HattrickParser();
    }


    public void testAlliances() throws ParserException {

        //FILE 1
        Alliances res = parser.parse(Alliances.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "alliances", "alliances"));

        Assert.assertNotNull(res);
        Assert.assertNotNull(res.getAlliances());
        Assert.assertEquals(25, res.getAlliances().size());
        Assert.assertEquals(0, res.getPageIndex());
        Assert.assertEquals(6, res.getPages());

        //Check all alliances
        ArrayList<Alliance> alliances = res.getAlliances();
        for (int i = 0; i < alliances.size() ; i++) {
            Alliance all = alliances.get(i);

            Assert.assertNotNull(all.getAllianceDescription());
            Assert.assertNotNull(all.getAllianceName());
            Assert.assertTrue(all.getAllianceID() > 0);
        }
        
    }

    public void testAlliancesEmpty() throws ParserException {

        //FILE 1
        Alliances res = parser.parse(Alliances.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "alliances", "alliances-empty"));

        Assert.assertNotNull(res);
        Assert.assertNull(res.getAlliances());
        Assert.assertEquals(0, res.getPageIndex());
        Assert.assertEquals(1, res.getPages());

    }

    public void testAllianceDetailView() throws ParserException {

        //FILE 1
        AllianceDetails res = parser.parse(AllianceDetails.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "alliances", "alliancedetails-view"));

        Assert.assertNotNull(res);

        Assert.assertTrue(res.getAllianceID() > 0);
        Assert.assertNotNull(res.getAllianceName());
        Assert.assertNotNull(res.getAbbreviation());
        Assert.assertNotNull(res.getDescription());
        Assert.assertNotNull(res.getLogoURL());
        Assert.assertNotNull(res.getTopRole());
        Assert.assertTrue(res.getTopUserID() > 0);
        Assert.assertNotNull(res.getTopLoginname());
        Assert.assertNotNull(res.getCreationDate());
        Assert.assertNotNull(res.getHomePageURL());
        Assert.assertTrue(res.getNumberOfMembers() > 0);


        Assert.assertTrue(res.getLanguages().size() > 0);
        Assert.assertNotNull(res.getMessage());
        Assert.assertNotNull(res.getRules());

        //FILE 2
        res = parser.parse(AllianceDetails.class,
                Hattrick.loadFixtureXML(getInstrumentation(), PATH, "alliances", "alliancedetails-view-2"));

        Assert.assertNotNull(res);

        Assert.assertTrue(res.getAllianceID() > 0);
        Assert.assertNotNull(res.getAllianceName());
        Assert.assertNotNull(res.getAbbreviation());
        Assert.assertNotNull(res.getDescription());
        Assert.assertNotNull(res.getLogoURL());
        Assert.assertNotNull(res.getTopRole());
        Assert.assertTrue(res.getTopUserID() > 0);
        Assert.assertNotNull(res.getTopLoginname());
        Assert.assertNotNull(res.getCreationDate());
        Assert.assertNotNull(res.getHomePageURL());
        Assert.assertTrue(res.getNumberOfMembers() > 0);

        Assert.assertTrue(res.getLanguages().size() > 0);
        Assert.assertNotNull(res.getMessage());
        Assert.assertNotNull(res.getRules());
    }
}
