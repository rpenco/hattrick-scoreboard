package org.hattrickscoreboard.application.utils.graphics.statics;

import android.content.Context;
import android.graphics.drawable.Drawable;

import org.hattrick.constants.HCupLevel;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.database.models.DTeam;

public class CupTypeDrawable {

    public static Drawable getDrawable(Context context, DTeam team) {

        // Default icon
        int res = R.drawable.ic_cup_other;

        if (team != null) {
            // National or divisional cup (same icon)
            if (team.getCupLevel() == HCupLevel.NATIONAL_OR_DIVISIONAL) {
                res = R.drawable.ic_cup_national;

            } else if (team.getCupLevel() == HCupLevel.CONSOLATION) {
                // Consolation icon
                res = R.drawable.ic_cup_consolation;

                // Challenger cup
            } else if (team.getCupLevel() == HCupLevel.CHALLENGER) {
                // 1 = Emerald, 2 = Ruby, 3 = Sapphire
                if (team.getCupLevelIndex() == 1) {
                    res = R.drawable.ic_cup_emerald;
                } else if (team.getCupLevelIndex() == 2) {
                    res = R.drawable.ic_cup_ruby;
                } else {
                    res = R.drawable.ic_cup_sapphire;
                }
            }
        }

        Drawable d = context.getResources().getDrawable(res);
        return d;
    }
}
