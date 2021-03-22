package org.hattrickscoreboardl.release.hattrick.providers;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.constants.HErrorCodes;
import org.hattrick.models.clubs.Club;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrickscoreboardl.utils.Hattrick;

/**
 * @author Khips
 * @since 28 mars 2014
 */
public class HattrickParserTest extends InstrumentationTestCase {

    String PATH = "test/release/hattrick/";

    public void testNullParse() {

        String clubdata = null;
        HattrickParser parser = new HattrickParser();
        Club res = null;
        try {
            res = parser.parse(Club.class,clubdata);
            Assert.fail("Should have thrown CHPPParser exception");
        } catch (ParserException e) {
            Assert.assertEquals(e.getCode(), -2);
            Assert.assertNull(e.getContent());
        }
    }

    public void testNoXMLParse() {

        String clubdata = "An error occurred while sending the request. (The remote server returned an error: (404) Not Found.)";
        HattrickParser parser = new HattrickParser();
        Club res = null;
        try {
            res = parser.parse(Club.class,clubdata);
            Assert.fail("Should have thrown CHPPParser exception");
        } catch (ParserException e) {
            Assert.assertEquals(e.getCode(), -2);
            Assert.assertEquals(clubdata, e.getContent());
        }
    }

    public void testCHPPErrorKnownParse(){

        String chpperror = Hattrick.loadFixtureXML(getInstrumentation(), PATH, "chpp", "chpperror");
        HattrickParser parser = new HattrickParser();

        //Fake. Load "Club" (chpperror 59)
        Club res = null;
        try {

            res = parser.parse(Club.class,chpperror);
            Assert.fail("Should have thrown CHPPParser exception");
        } catch (ParserException e) {

            //Success if chpp exception return 59 (only owned)
            Assert.assertEquals(HErrorCodes.ONLY_OWNED, e.getCode());
        }
    }

    public void testCHPPErrorUnknownParse(){

        String chpperror = Hattrick.loadFixtureXML(getInstrumentation(), PATH, "chpp", "chpperror-unknown");
        HattrickParser parser = new HattrickParser();

        //Fake. Load "Club" (error 34059573)
        Club res = null;
        try {

            res = parser.parse(Club.class,chpperror);
            Assert.fail("Should have thrown CHPPParser exception");
        } catch (ParserException e) {

            //Success if chpp exception return 59 (only owned)
            Assert.assertEquals(34059573, e.getCode());
        }
    }
}
