package org.hattrick.models.supporters;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class SupporterTeam {

    @Element
    int UserId;

    @Element
    String LoginName;

    @Element
    int TeamId;

    @Element
    String TeamName;

    @Element
    int LeagueID;

    @Element
    String LeagueName;

    @Element
    int LeagueLevelUnitID;

    @Element
    String LeagueLevelUnitName;

    public int getUserId() {
        return UserId;
    }

    public String getLoginName() {
        return LoginName;
    }

    public int getTeamId() {
        return TeamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public String getLeagueName() {
        return LeagueName;
    }

    public int getLeagueLevelUnitID() {
        return LeagueLevelUnitID;
    }

    public String getLeagueLevelUnitName() {
        return LeagueLevelUnitName;
    }
}
