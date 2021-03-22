package org.hattrick.models.youth;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class YouthPlayerDetails {

    @Element
    @Path("YouthPlayer")
    int YouthPlayerID;

    @Element
    @Path("YouthPlayer")
    String FirstName;

    @Element(required = false)
    @Path("YouthPlayer")
    String NickName;

    @Element
    @Path("YouthPlayer")
    String LastName;

    @Element
    @Path("YouthPlayer")
    int Age;

    @Element
    @Path("YouthPlayer")
    int AgeDays;

    @Element
    @Path("YouthPlayer")
    String ArrivalDate;

    @Element
    @Path("YouthPlayer")
    int CanBePromotedIn;

    @Element
    @Path("YouthPlayer")
    int PlayerNumber;

    @Element(required = false)
    @Path("YouthPlayer")
    String Statement;

    @Element
    @Path("YouthPlayer")
    int Cards;

    @Element
    @Path("YouthPlayer")
    int InjuryLevel;

    @Element
    @Path("YouthPlayer")
    int Specialty;

    @Element
    @Path("YouthPlayer")
    int CareerGoals;

    @Element
    @Path("YouthPlayer")
    int CareerHattricks;

    @Element
    @Path("YouthPlayer")
    int LeagueGoals;

    @Element
    @Path("YouthPlayer")
    int FriendlyGoals;

    @Element
    @Path("YouthPlayer/OwningYouthTeam")
    int YouthTeamID;

    @Element
    @Path("YouthPlayer/OwningYouthTeam")
    String YouthTeamName;

    @Element
    @Path("YouthPlayer/OwningYouthTeam")
    int YouthTeamLeagueID;

    @Element
    @Path("YouthPlayer/OwningYouthTeam/SeniorTeam")
    int SeniorTeamID;

    @Element
    @Path("YouthPlayer/OwningYouthTeam/SeniorTeam")
    String SeniorTeamName;

    @Element
    @Path("YouthPlayer/LastMatch")
    int YouthMatchID;

    @Element
    @Path("YouthPlayer/LastMatch")
    String Date;

    @Element
    @Path("YouthPlayer/LastMatch")
    int PositionCode;

    @Element
    @Path("YouthPlayer/LastMatch")
    int PlayedMinutes;

    @Element
    @Path("YouthPlayer/LastMatch")
    String Rating;

    public int getYouthPlayerID() {
        return YouthPlayerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getNickName() {
        return NickName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }

    public int getAgeDays() {
        return AgeDays;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public int getCanBePromotedIn() {
        return CanBePromotedIn;
    }

    public int getPlayerNumber() {
        return PlayerNumber;
    }

    public String getStatement() {
        return Statement;
    }

    public int getCards() {
        return Cards;
    }

    public int getInjuryLevel() {
        return InjuryLevel;
    }

    public int getSpecialty() {
        return Specialty;
    }

    public int getCareerGoals() {
        return CareerGoals;
    }

    public int getCareerHattricks() {
        return CareerHattricks;
    }

    public int getLeagueGoals() {
        return LeagueGoals;
    }

    public int getFriendlyGoals() {
        return FriendlyGoals;
    }

    public int getYouthTeamID() {
        return YouthTeamID;
    }

    public String getYouthTeamName() {
        return YouthTeamName;
    }

    public int getYouthTeamLeagueID() {
        return YouthTeamLeagueID;
    }

    public int getSeniorTeamID() {
        return SeniorTeamID;
    }

    public String getSeniorTeamName() {
        return SeniorTeamName;
    }

    public int getYouthMatchID() {
        return YouthMatchID;
    }

    public String getDate() {
        return Date;
    }

    public int getPositionCode() {
        return PositionCode;
    }

    public int getPlayedMinutes() {
        return PlayedMinutes;
    }

    public String getRating() {
        return Rating;
    }
}
