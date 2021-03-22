package org.hattrickscoreboardl.debug;

import android.graphics.Color;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import org.hattrickscoreboardl.utils.Preferences;

/**
 * Main class for testing connection and download file from
 * Hattrick
 * Created by romain on 28/10/2014.
 */
public class PreferencesTest extends AndroidTestCase {

    public void testPreferences() {

        Preferences pref = new Preferences(getContext());

        //Put
        pref.save(Preferences.SELECTED_LOCALE, "fr");
        pref.save(Preferences.TIMEZONE_OFFSET_1STTEAM, "Europe/Paris");
        pref.save(Preferences.FIRST_LAUNCH, true);
        pref.save(Preferences.COLOR_RGB_1STTEAM, Color.parseColor("#FF6600"));
        pref.save(Preferences.USER_ID, 1234);
        pref.save(Preferences.SELECTED_TEAM_ID, 17000);
        pref.save(Preferences.WORLD_1STTEAM, 5);
        pref.save(Preferences.NOTIF_1STTEAM_ECONOMICAL, true);
        pref.save(Preferences.NOTIF_1STTEAM_TRAINING, true);
        pref.save(Preferences.NOTIF_NATIONAL_REMINDER_1H, true);
        pref.save(Preferences.NOTIF_NATIONAL_REMINDER_30M, true);
        pref.save(Preferences.NOTIF_NATIONAL_KICKOFF, true);
        pref.save(Preferences.NOTIF_NATIONAL_HALFTIME, true);
        pref.save(Preferences.NOTIF_NATIONAL_GOALS, true);

        //Read
        Assert.assertEquals("fr", pref.get(Preferences.SELECTED_LOCALE, "en"));
        Assert.assertEquals("Europe/Paris", pref.get(Preferences.TIMEZONE_OFFSET_1STTEAM, "Amerique/Bresil"));
        Assert.assertTrue(pref.get(Preferences.FIRST_LAUNCH, false));
        Assert.assertEquals(Color.parseColor("#FF6600"), pref.get(Preferences.COLOR_RGB_1STTEAM, Color.parseColor("#FF0066")));
        Assert.assertEquals(1234, pref.get(Preferences.USER_ID, 0));
        Assert.assertEquals(17000, pref.get(Preferences.SELECTED_TEAM_ID, 0));
        Assert.assertEquals(5, pref.get(Preferences.WORLD_1STTEAM, 0));
        Assert.assertTrue(pref.get(Preferences.NOTIF_1STTEAM_ECONOMICAL, false));
        Assert.assertTrue(pref.get(Preferences.NOTIF_1STTEAM_TRAINING, false));
        Assert.assertTrue(pref.get(Preferences.NOTIF_NATIONAL_REMINDER_1H, false));
        Assert.assertTrue(pref.get(Preferences.NOTIF_NATIONAL_REMINDER_30M, false));
        Assert.assertTrue(pref.get(Preferences.NOTIF_NATIONAL_KICKOFF, false));
        Assert.assertTrue(pref.get(Preferences.NOTIF_NATIONAL_HALFTIME, false));
        Assert.assertTrue(pref.get(Preferences.NOTIF_NATIONAL_GOALS, false));

    }


}
