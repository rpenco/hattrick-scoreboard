package org.hattrickscoreboardl.release.hattrick.models;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.models.clubs.Club;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrickscoreboardl.utils.Hattrick;

/**
 * Created by romain on 30/10/2014.
 */
public class HattrickModelParserTest extends InstrumentationTestCase{

    HattrickParser parser;
    String PATH = "test/release/hattrick/models/";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //Init parser
        parser = new HattrickParser();
    }


    public void testParser() throws ParserException {
        Club res = parser.parse(Club.class, Hattrick.loadFixtureXML(getInstrumentation(), PATH, "clubs", "club"));
        Assert.assertNotNull(res);
    }

}
