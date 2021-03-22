package org.hattrick.models.tournaments;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class Tournament {

    @Element
    int TournamentId;

    @Element
    String Name;

    @Element
    int TournamentType;

    @Element
    int Season;

    @Element
    String LogoUrl;

    @Element
    int TrophyType;

    @Element
    int NumberOfTeams;

    @Element
    int NumberOfGroups;

    @Element
    int LastMatchRound;

    @Element
    String FirstMatchRoundDate;

    @Element
    String NextMatchRoundDate;

    @Element
    int IsMatchesOngoing;

    @Element
    @Path("Creator")
    int UserId;

    @Element
    @Path("Creator")
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
