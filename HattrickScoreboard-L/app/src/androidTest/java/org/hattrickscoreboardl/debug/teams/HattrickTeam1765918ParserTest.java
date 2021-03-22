package org.hattrickscoreboardl.debug.teams;

import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import org.hattrick.models.achievements.Achievements;
import org.hattrick.models.arenas.ArenaDetails;
import org.hattrick.models.avatars.PlayersAvatar;
import org.hattrick.models.hofplayers.HoFPlayers;
import org.hattrick.models.matches.Matches;
import org.hattrick.models.teams.TeamDetails;
import org.hattrick.providers.HattrickParser;
import org.hattrick.providers.exceptions.ParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by romain on 30/10/2014.
 */
public class HattrickTeam1765918ParserTest extends InstrumentationTestCase{

    static int TEAMID = 1765918;
    HattrickParser parser;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //Init parser
        parser = new HattrickParser();
    }

    String loadFixture(String name){
        try {
            InputStream stream = getInstrumentation().getTargetContext().getResources().getAssets().open("test/release/hattrick/models/others/teams/" +TEAMID+"/"+name + ".xml");
            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(stream));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void testAchievementsParser() throws ParserException {
        Achievements res = parser.parse(Achievements.class, loadFixture("achievements"));
        Assert.assertNotNull(res);
    }

    public void testArenaParser() throws ParserException {
        ArenaDetails res = parser.parse(ArenaDetails.class, loadFixture("arena"));
        Assert.assertNotNull(res);
    }

    public void testAvatarParser() throws ParserException {
        PlayersAvatar res = parser.parse(PlayersAvatar.class, loadFixture("avatars"));
        Assert.assertNotNull(res);
    }

    public void testHoFPlayersParser() throws ParserException {
        HoFPlayers res = parser.parse(HoFPlayers.class, loadFixture("hofplayers"));
        Assert.assertNotNull(res);
    }

    public void testMatchesParser() throws ParserException {
        Matches res = parser.parse(Matches.class, loadFixture("matches"));
        Assert.assertNotNull(res);
    }

    public void testTeamDetailsParser() throws ParserException {
        TeamDetails res = parser.parse(TeamDetails.class, loadFixture("teamdetails"));
        Assert.assertNotNull(res);

    }

}
