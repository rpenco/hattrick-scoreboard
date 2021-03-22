package org.hattrick.models.national;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class NationalTeam {

    @Element
    int NationalTeamID;

    @Element
    String NationalTeamName;

    @Element
    String Dress;

    @Element
    int RatingScores;


    @Element
    int LeagueId;

    public int getNationalTeamId() {
        return NationalTeamID;
    }

    public String getNationalTeamName() {
        return NationalTeamName;
    }

    public String getDress() {
        return Dress;
    }

    public int getRatingScores() {
        return RatingScores;
    }

    public int getLeagueId() {
        return LeagueId;
    }
}
