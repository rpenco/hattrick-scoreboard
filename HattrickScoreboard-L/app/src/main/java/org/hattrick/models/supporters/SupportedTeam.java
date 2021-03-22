package org.hattrick.models.supporters;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class SupportedTeam {

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


    @Element
    @Path("LastMatch")
    int LastMatchId;

    @Element
    @Path("LastMatch")
    String LastMatchDate;

    @Element
    @Path("LastMatch")
    int LastMatchHomeTeamId;

    @Element
    @Path("LastMatch")
    String LastMatchHomeTeamName;

    @Element
    @Path("LastMatch")
    int LastMatchHomeGoals;

    @Element
    @Path("LastMatch")
    int LastMatchAwayTeamId;

    @Element
    @Path("LastMatch")
    String LastMatchAwayTeamName;

    @Element
    @Path("LastMatch")
    int LastMatchAwayGoals;

    @Element
    @Path("NextMatch")
    int NextMatchId;

    @Element
    @Path("NextMatch")
    String NextMatchMatchDate;

    @Element
    @Path("NextMatch")
    int NextMatchHomeTeamId;

    @Element
    @Path("NextMatch")
    String NextMatchHomeTeamName;

    @Element
    @Path("NextMatch")
    int NextMatchAwayTeamId;

    @Element
    @Path("NextMatch")
    String NextMatchAwayTeamName;


    @Element(required = false)
    @Path("PressAnnouncement")
    String PressAnnouncementSendDate;

    @Element(required = false)
    @Path("PressAnnouncement")
    String PressAnnouncementSubject;

    @Element(required = false)
    @Path("PressAnnouncement")
    String PressAnnouncementBody;

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

    public int getLastMatchId() {
        return LastMatchId;
    }

    public String getLastMatchDate() {
        return LastMatchDate;
    }

    public int getLastMatchHomeTeamId() {
        return LastMatchHomeTeamId;
    }

    public String getLastMatchHomeTeamName() {
        return LastMatchHomeTeamName;
    }

    public int getLastMatchHomeGoals() {
        return LastMatchHomeGoals;
    }

    public int getLastMatchAwayTeamId() {
        return LastMatchAwayTeamId;
    }

    public String getLastMatchAwayTeamName() {
        return LastMatchAwayTeamName;
    }

    public int getLastMatchAwayGoals() {
        return LastMatchAwayGoals;
    }

    public int getNextMatchId() {
        return NextMatchId;
    }

    public String getNextMatchMatchDate() {
        return NextMatchMatchDate;
    }

    public int getNextMatchHomeTeamId() {
        return NextMatchHomeTeamId;
    }

    public String getNextMatchHomeTeamName() {
        return NextMatchHomeTeamName;
    }

    public int getNextMatchAwayTeamId() {
        return NextMatchAwayTeamId;
    }

    public String getNextMatchAwayTeamName() {
        return NextMatchAwayTeamName;
    }

    public String getPressAnnouncementSendDate() {
        return PressAnnouncementSendDate;
    }

    public String getPressAnnouncementSubject() {
        return PressAnnouncementSubject;
    }

    public String getPressAnnouncementBody() {
        return PressAnnouncementBody;
    }
}
