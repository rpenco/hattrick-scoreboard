package org.hattrick.models.tournaments;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class TournamentDetails {

    @Element
    @Path("Tournament")
    int TournamentId;

    @Element
    @Path("Tournament")
    String Name;

    @Element
    @Path("Tournament")
    int TournamentType;

    @Element
    @Path("Tournament")
    int Season;

    @Element
    @Path("Tournament")
    String LogoUrl;

    @Element
    @Path("Tournament")
    int TrophyType;

    @Element
    @Path("Tournament")
    int NumberOfTeams;

    @Element
    @Path("Tournament")
    int NumberOfGroups;

    @Element
    @Path("Tournament")
    int LastMatchRound;

    @Element
    @Path("Tournament")
    String FirstMatchRoundDate;

    @Element
    @Path("Tournament")
    String NextMatchRoundDate;

    @Element
    @Path("Tournament")
    int IsMatchesOngoing;

    @Element
    @Path("Tournament/Creator")
    int UserId;

    @Element
    @Path("Tournament/Creator")
    String Loginname;

    public int getTournamentId() {
        return TournamentId;
    }

    public String getName() {
        return Name;
    }

    public int getTournamentType() {
        return TournamentType;
    }

    public int getSeason() {
        return Season;
    }

    public String getLogoUrl() {
        return LogoUrl;
    }

    public int getTrophyType() {
        return TrophyType;
    }

    public int getNumberOfTeams() {
        return NumberOfTeams;
    }

    public int getNumberOfGroups() {
        return NumberOfGroups;
    }

    public int getLastMatchRound() {
        return LastMatchRound;
    }

    public String getFirstMatchRoundDate() {
        return FirstMatchRoundDate;
    }

    public String getNextMatchRoundDate() {
        return NextMatchRoundDate;
    }

    public int getIsMatchesOngoing() {
        return IsMatchesOngoing;
    }

    public int getUserId() {
        return UserId;
    }

    public String getLoginname() {
        return Loginname;
    }
}
