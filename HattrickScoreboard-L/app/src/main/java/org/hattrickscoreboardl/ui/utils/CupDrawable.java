package org.hattrickscoreboardl.ui.utils;

import org.hattrick.constants.HCupLevel;
import org.hattrickscoreboardl.R;

//        CupLeagueLevel : unsigned Integer
//        LeagueLevel for the cup. 0 = National (LeagueLevel 1-6), 7-9 = Divisional. Only provided if team is still in cup.
//        CupLevel : unsigned Integer
//        Level of the cup. 1 = National/Divisional, 2 = Challenger, 3 = Consolation. Only provided if team is still in cup.
//        CupLevelIndex : unsigned Integer
//        Index of the cup. Always 1 for National and Consolation cups, for Challenger cup: 1 = Emerald, 2 = Ruby, 3 = Sapphire. Only provided if team is still in cup.

/**
 * Created by romain
 * on 22/11/2014.
 */
public class CupDrawable {


    public static int getResource(int CupLeagueLevel, int CupLevel, int CupLevelIndex) {



        // Default icon
        int res = R.drawable.ic_cup_other;

            // National or divisional cup (same icon)
            if (CupLevel == HCupLevel.NATIONAL_OR_DIVISIONAL) {
                res = R.drawable.ic_cup_national;
            } else if (CupLevel == HCupLevel.CONSOLATION) {

                // Consolation icon
                res = R.drawable.ic_cup_consolation;

                // Challenger cup
            } else if (CupLevel == HCupLevel.CHALLENGER) {
                // 1 = Emerald, 2 = Ruby, 3 = Sapphire
                if (CupLevelIndex == 1) {
                    res = R.drawable.ic_cup_emerald;
                } else if (CupLevelIndex == 2) {
                    res = R.drawable.ic_cup_ruby;
                } else {
                    res = R.drawable.ic_cup_sapphire;
                }
            }

        return res;
    }
}
