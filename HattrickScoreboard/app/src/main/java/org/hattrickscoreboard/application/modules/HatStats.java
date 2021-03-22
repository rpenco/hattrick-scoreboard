package org.hattrickscoreboard.application.modules;

import org.hattrickscoreboard.database.models.match.Match;

/**
 * Hatstats
 *
 * @author Khips
 * @since 23 august 2014
 */
public class HatStats {

    Match match;

    public HatStats(Match match) {
        this.match = match;
    }

    public int getHomeDefense() {
        return match.getHomeRatingLeftDef() + match.getHomeRatingRightDef()
                + match.getHomeRatingMidDef();
    }

    public int getAwayDefense() {
        return match.getAwayRatingLeftDef() + match.getAwayRatingRightDef()
                + match.getAwayRatingMidDef();
    }

    public int getHomeMiddle() {
        return 3 * match.getHomeRatingMidfield();
    }

    public int getAwayMiddle() {
        return 3 * match.getAwayRatingMidfield();
    }

    public int getHomeAttack() {
        return match.getHomeRatingLeftAtt() + match.getHomeRatingRightAtt()
                + match.getHomeRatingMidAtt();
    }

    public int getAwayAttack() {
        return match.getAwayRatingLeftAtt() + match.getAwayRatingRightAtt()
                + match.getAwayRatingMidAtt();
    }

    public int getHomeTotal() {
        return getHomeDefense() + getHomeMiddle() + getHomeAttack();
    }

    public int getAwayTotal() {
        return getAwayDefense() + getAwayMiddle() + getAwayAttack();
    }

}
