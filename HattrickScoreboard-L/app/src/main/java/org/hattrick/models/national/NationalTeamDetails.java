package org.hattrick.models.national;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class NationalTeamDetails {

    @Element
    boolean IsPlayingMatch;

    @Element
    @Path ("Team")
    int TeamID;

    @Element
    @Path ("Team")
    String TeamName;

    @Element
    @Path ("Team")
    String ShortTeamName;

    @Element
    @Path ("Team/NationalCoach")
    int NationalCoachUserID;

    @Element
    @Path ("Team/NationalCoach")
    String NationalCoachLoginname;

    @Element
    @Path ("Team/League")
    int LeagueID;

    @Element
    @Path ("Team/League")
    String LeagueName;


    @Element
    @Path ("Team/Trainer")
    int PlayerID;

    @Element
    @Path ("Team/Trainer")
    String PlayerName;

    @Element(required = false)
    @Path ("Team")
    String HomePage;

    @Element(required = false)
    @Path ("Team")
    String Logo;


    @Element
    @Path ("Team")
    String DressURI;


    @Element
    @Path ("Team")
    String DressAlternateURI;

    @Element
    @Path ("Team")
    int Experience433;

    @Element
    @Path ("Team")
    int Experience451;

    @Element
    @Path ("Team")
    int Experience352;

    @Element
    @Path ("Team")
    int Experience532;

    @Element
    @Path ("Team")
    int Experience343;

    @Element
    @Path ("Team")
    int Experience541;

    @Element
    @Path ("Team")
    int Experience523;

    @Element
    @Path ("Team")
    int Experience550;

    @Element
    @Path ("Team")
    int Experience253;

    @Element
    @Path ("Team")
    int Experience442;

    @Element
    @Path ("Team")
    int Morale;

    @Element
    @Path ("Team")
    int SelfConfidence;

    @Element
    @Path ("Team")
    int SupportersPopularity;

    @Element
    @Path ("Team")
    int RatingScore;

    @Element
    @Path ("Team")
    int FanClubSize;

    @Element
    @Path ("Team")
    int Rank;

    public boolean isPlayingMatch() {
        return IsPlayingMatch;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getShortTeamName() {
        return ShortTeamName;
    }

    public int getNationalCoachUserID() {
        return NationalCoachUserID;
    }

    public String getNationalCoachLoginname() {
        return NationalCoachLoginname;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public String getHomePage() {
        return HomePage;
    }

    public String getLogo() {
        return Logo;
    }

    public String getDressURI() {
        return DressURI;
    }

    public String getDressAlternateURI() {
        return DressAlternateURI;
    }

    public int getExperience433() {
        return Experience433;
    }

    public int getExperience451() {
        return Experience451;
    }

    public int getExperience352() {
        return Experience352;
    }

    public int getExperience532() {
        return Experience532;
    }

    public int getExperience343() {
        return Experience343;
    }

    public int getExperience541() {
        return Experience541;
    }

    public int getExperience523() {
        return Experience523;
    }

    public int getExperience550() {
        return Experience550;
    }

    public int getExperience253() {
        return Experience253;
    }

    public int getExperience442() {
        return Experience442;
    }

    public int getMorale() {
        return Morale;
    }

    public int getSelfConfidence() {
        return SelfConfidence;
    }

    public int getSupportersPopularity() {
        return SupportersPopularity;
    }

    public int getRatingScore() {
        return RatingScore;
    }

    public int getFanClubSize() {
        return FanClubSize;
    }

    public int getRank() {
        return Rank;
    }
}
