package org.hattrick.models.players;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "Player", strict = false)
public class Player {

    @Element
     int PlayerID;

    @Element
     String FirstName;

    @Element(required = false)
     String NickName;

    @Element
     String LastName;

    @Element(required = false)
     int PlayerNumber;

    @Element
     int Age;

    @Element
     int AgeDays;

    @Element
     int TSI;

    @Element
     int PlayerForm;

    @Element(required = false)
     String Statement;

    @Element
     int Experience;

    @Element
     int Loyalty;

    @Element
     boolean MotherClubBonus;

    @Element
     int Leadership;

    @Element
     int Salary;

    @Element
    boolean IsAbroad;

    @Element
     int Agreeability;

    @Element
     int Aggressiveness;

    @Element
     int Honesty;

    @Element
     int LeagueGoals;

    @Element
     int CupGoals;

    @Element
     int FriendliesGoals;

    @Element
     int CareerGoals;

    @Element
     int CareerHattricks;

    @Element
     int Specialty;

    @Element
    boolean TransferListed;

    @Element
     int NationalTeamID;

    @Element
     int CountryID;

    @Element
     int Caps;

    @Element
     int CapsU20;

    @Element
     int Cards;

    @Element
     int InjuryLevel;

    @Element(required = false)
     int StaminaSkill;

    @Element(required = false)
     int KeeperSkill;

    @Element(required = false)
     int PlaymakerSkill;

    @Element(required = false)
     int ScorerSkill;

    @Element(required = false)
     int PassingSkill;

    @Element(required = false)
     int WingerSkill;

    @Element(required = false)
     int DefenderSkill;

    @Element(required = false)
     int SetPiecesSkill;

    @Element(required = false)
     int PlayerCategoryId;

    @Element(required = false)
    @Path("LastMatch")
     String Date;

    @Element(required = false)
    @Path("LastMatch")
     int MatchId;

    @Element(required = false)
    @Path("LastMatch")
     int PositionCode;

    @Element(required = false)
    @Path("LastMatch")
     int PlayedMinutes;

    @Element(required = false)
    @Path("LastMatch")
     double Rating;

    @Element(required = false)
    @Path("LastMatch")
     double RatingEndOfGame;

    public int getPlayerID() {
        return PlayerID;
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

    public int getPlayerNumber() {
        return PlayerNumber;
    }

    public int getAge() {
        return Age;
    }

    public int getAgeDays() {
        return AgeDays;
    }

    public int getTSI() {
        return TSI;
    }

    public int getPlayerForm() {
        return PlayerForm;
    }

    public String getStatement() {
        return Statement;
    }

    public int getExperience() {
        return Experience;
    }

    public int getLoyalty() {
        return Loyalty;
    }

    public boolean isMotherClubBonus() {
        return MotherClubBonus;
    }

    public int getLeadership() {
        return Leadership;
    }

    public int getSalary() {
        return Salary;
    }

    public boolean isAbroad() {
        return IsAbroad;
    }

    public int getAgreeability() {
        return Agreeability;
    }

    public int getAggressiveness() {
        return Aggressiveness;
    }

    public int getHonesty() {
        return Honesty;
    }

    public int getLeagueGoals() {
        return LeagueGoals;
    }

    public int getCupGoals() {
        return CupGoals;
    }

    public int getFriendliesGoals() {
        return FriendliesGoals;
    }

    public int getCareerGoals() {
        return CareerGoals;
    }

    public int getCareerHattricks() {
        return CareerHattricks;
    }

    public int getSpecialty() {
        return Specialty;
    }

    public boolean isTransferListed() {
        return TransferListed;
    }

    public int getNationalTeamID() {
        return NationalTeamID;
    }

    public int getCountryID() {
        return CountryID;
    }

    public int getCaps() {
        return Caps;
    }

    public int getCapsU20() {
        return CapsU20;
    }

    public int getCards() {
        return Cards;
    }

    public int getInjuryLevel() {
        return InjuryLevel;
    }

    public int getStaminaSkill() {
        return StaminaSkill;
    }

    public int getKeeperSkill() {
        return KeeperSkill;
    }

    public int getPlaymakerSkill() {
        return PlaymakerSkill;
    }

    public int getScorerSkill() {
        return ScorerSkill;
    }

    public int getPassingSkill() {
        return PassingSkill;
    }

    public int getWingerSkill() {
        return WingerSkill;
    }

    public int getDefenderSkill() {
        return DefenderSkill;
    }

    public int getSetPiecesSkill() {
        return SetPiecesSkill;
    }

    public int getPlayerCategoryId() {
        return PlayerCategoryId;
    }

    public String getDate() {
        return Date;
    }

    public int getMatchId() {
        return MatchId;
    }

    public int getPositionCode() {
        return PositionCode;
    }

    public int getPlayedMinutes() {
        return PlayedMinutes;
    }

    public double getRating() {
        return Rating;
    }

    public double getRatingEndOfGame() {
        return RatingEndOfGame;
    }
}
