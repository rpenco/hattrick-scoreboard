package org.hattrickscoreboard.application.utils;

/**
 * Define after many time information expires (in seconds)
 *
 * @author Khips
 * @since 16 july 2014
 */
public class HattrickUpdater {

    static int MIN = 60;
    public static int VALIDITY_TEAM_DETAILS = 15 * MIN;
    static int HOUR = MIN * 60;
    public static int VALIDITY_CLUB = HOUR;
    public static int VALIDITY_PLAYER = HOUR;
    public static int VALIDITY_MATCH = HOUR;
    public static int VALIDITY_TRANSFER = HOUR;
    static int DAY = HOUR * 24;
    public static int VALIDITY_STAFF = DAY;
    public static int VALIDITY_ARENA = DAY;
    public static int VALIDITY_LEAGUE = DAY;
    public static int VALIDITY_ECONOMY = DAY;
    public static int VALIDITY_BOOKMARK = DAY;
    static int WEEK = DAY * 7;
    public static int VALIDITY_LANGUAGE = WEEK;
    public static int VALIDITY_TRAINING = WEEK;
    public static int VALIDITY_WORLD = WEEK;
}
