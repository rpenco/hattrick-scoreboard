package org.hattrickscoreboardl.ui.utils;

import org.hattrick.constants.match.HMatchTypeID;
import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.matches.HMatch;

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
public class MatchTypeDrawable {


    public static int getResource(HMatch match) {
        int type  = match.getMatchType();

        if (type == HMatchTypeID.LEAGUE_MATCH){
            return R.drawable.ic_match_series;
        }

        if (type == HMatchTypeID.QUALIFICATION_MATCH){
            return R.drawable.ic_match_qualifer;
        }

        if (type == HMatchTypeID.CUP_MATCH_STANDARD_LEAGUE_MATCH){
            return CupDrawable.getResource(match.getCupLeagueLevel(),match.getCupLevel(),match.getCupLevelIndex());
        }

        if (type == HMatchTypeID.FRIENDLY_NORMAL_RULES){
            return R.drawable.ic_match_friendly;
        }

        if (type == HMatchTypeID.FRIENDLY_CUP_RULES){
            return R.drawable.ic_match_friendly;
        }

        if (type == HMatchTypeID.HATTRICK_MASTERS){
            return R.drawable.ic_match_master;
        }

        if (type == HMatchTypeID.INTERNATIONAL_FRIENDLY_NORMAL_RULES){
            return R.drawable.ic_match_friendly;
        }

        if (type == HMatchTypeID.INTERNATION_FRIENDLY_CUP_RULES){
            return R.drawable.ic_match_friendly;
        }

        if (type == HMatchTypeID.NATIONAL_TEAMS_COMPETITION_MATCH_NORMAL_RULES){
            return R.drawable.ic_match_national;
        }

        if (type == HMatchTypeID.NATIONAL_TEAMS_COMPETITION_MATCH_CUP_RULES){
            return R.drawable.ic_match_national;
        }

        if (type == HMatchTypeID.NATIONAL_TEAMS_FRIENDLY){
            return R.drawable.ic_match_friendly;
        }

        if (type == HMatchTypeID.TOURNAMENT_LEAGUE_MATCH){
            return R.drawable.ic_match_tournament;
        }

        if (type == HMatchTypeID.TOURNAMENT_PLAYOFF_MATCH){
            return R.drawable.ic_match_tournament;
        }

        if (type == HMatchTypeID.SINGLE_MATCH){
            return R.drawable.ic_match_unknown;
        }

        if (type == HMatchTypeID.LADDER_MATCH){
            return R.drawable.ic_match_ladder;
        }

        if (type == HMatchTypeID.PREPARATION_MATCH){
            return R.drawable.ic_match_unknown;
        }

        if (type == HMatchTypeID.YOUTH_LEAGUE_MATCH){
            return R.drawable.ic_match_series;
        }

        if (type == HMatchTypeID.YOUTH_FRIENDLY_MATCH){
            return R.drawable.ic_match_friendly;
        }

        if (type == HMatchTypeID.RESERVED1 || type == HMatchTypeID.RESERVED2 || type == HMatchTypeID.RESERVED3 || type == HMatchTypeID.RESERVED4){
            return R.drawable.ic_match_unknown;
        }

        if (type == HMatchTypeID.YOUTH_FRIENDLY_MATCH_CUP_RULES ){
            return R.drawable.ic_cup_other;
        }

        if (type == HMatchTypeID.YOUTH_INTERNATIONAL_FRIENDLY_MATCH){
            return R.drawable.ic_match_friendly;

        }

        if (type == HMatchTypeID.YOUTH_INTERNATIONAL_FRIENDLY_MATCH_CUP_RULES){
            return R.drawable.ic_match_friendly;
        }

        return R.drawable.ic_match_unknown;
    }
}
