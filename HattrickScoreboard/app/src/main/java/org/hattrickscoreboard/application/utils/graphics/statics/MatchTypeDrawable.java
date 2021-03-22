package org.hattrickscoreboard.application.utils.graphics.statics;

import android.content.Context;
import android.graphics.drawable.Drawable;

import org.hattrick.constants.HMatchTypeID;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.database.models.DTeam;

public class MatchTypeDrawable {

    public static Drawable getDrawable(Context context, DTeam team,
                                       int matchType) {

        int res = R.drawable.ic_match_series;

        if (matchType == HMatchTypeID.LEAGUE_MATCH) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.QUALIFICATION_MATCH) {
            res = R.drawable.ic_match_qualifer;
        }

        // Specific for new cup system
        if (matchType == HMatchTypeID.CUP_MATCH_STANDARD_LEAGUE_MATCH) {
            return CupTypeDrawable.getDrawable(context, team);
        }

        if (matchType == HMatchTypeID.FRIENDLY_NORMAL_RULES) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.FRIENDLY_CUP_RULES) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.RESERVED1) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.HATTRICK_MASTERS) {
            res = R.drawable.ic_match_master;
        }
        if (matchType == HMatchTypeID.INTERNATIONAL_FRIENDLY_NORMAL_RULES) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.INTERNATION_FRIENDLY_CUP_RULES) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.NATIONAL_TEAMS_COMPETITION_MATCH_NORMAL_RULES) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.NATIONAL_TEAMS_COMPETITION_MATCH_CUP_RULES) {
            res = R.drawable.ic_cup_other;
        }
        if (matchType == HMatchTypeID.NATIONAL_TEAMS_FRIENDLY) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.TOURNAMENT_LEAGUE_MATCH) {
            res = R.drawable.ic_match_tournament;
        }
        if (matchType == HMatchTypeID.TOURNAMENT_PLAYOFF_MATCH) {
            res = R.drawable.ic_match_tournament;
        }
        if (matchType == HMatchTypeID.SINGLE_MATCH) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.LADDER_MATCH) {
            res = R.drawable.ic_match_ladder;
        }
        if (matchType == HMatchTypeID.PREPARATION_MATCH) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.YOUTH_LEAGUE_MATCH) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.YOUTH_FRIENDLY_MATCH) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.RESERVED2) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.YOUTH_FRIENDLY_MATCH_CUP_RULES) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.RESERVED3) {
            res = R.drawable.ic_match_series;
        }
        if (matchType == HMatchTypeID.YOUTH_INTERNATIONAL_FRIENDLY_MATCH) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.YOUTH_INTERNATIONAL_FRIENDLY_MATCH_CUP_RULES) {
            res = R.drawable.ic_match_friendly;
        }
        if (matchType == HMatchTypeID.RESERVED4) {
            res = R.drawable.ic_match_series;
        }

        Drawable d = context.getResources().getDrawable(res);
        return d;
    }
}
