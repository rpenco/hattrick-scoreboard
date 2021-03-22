package org.hattrick.models.players;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "Player", strict = false)
public class Player {

    @Element
    private String PlayerID;

    @Element
    private String FirstName;

    @Element(required = false)
    private String NickName;

    @Element
    private String LastName;

    @Element(required = false)
    private String PlayerNumber;

    @Element
    private String Age;

    @Element
    private String AgeDays;

    @Element
    private String TSI;

    @Element
    private String PlayerForm;

    @Element(required = false)
    private String Statement;

    @Element
    private String Experience;

    @Element
    private String Loyalty;

    @Element
    private boolean MotherClubBonus;

    @Element
    private String Leadership;

    @Element
    private String Salary;

    @Element
    private String IsAbroad;

    @Element
    private String Agreeability;

    @Element
    private String Aggressiveness;

    @Element
    private String Honesty;

    @Element
    private String LeagueGoals;

    @Element
    private String CupGoals;

    @Element
    private String FriendliesGoals;

    @Element
    private String CareerGoals;

    @Element
    private String CareerHattricks;

    @Element
    private String Specialty;

    @Element
    private String TransferListed;

    @Element
    private String NationalTeamID;

    @Element
    private String CountryID;

    @Element
    private String Caps;

    @Element
    private String CapsU20;

    @Element
    private String Cards;

    @Element
    private String InjuryLevel;

    @Element(required = false)
    private String StaminaSkill;

    @Element(required = false)
    private String KeeperSkill;

    @Element(required = false)
    private String PlaymakerSkill;

    @Element(required = false)
    private String ScorerSkill;

    @Element(required = false)
    private String PassingSkill;

    @Element(required = false)
    private String WingerSkill;

    @Element(required = false)
    private String DefenderSkill;

    @Element(required = false)
    private String SetPiecesSkill;

    @Element(required = false)
    private String PlayerCategoryId;

    @Element(required = false)
    @Path("LastMatch")
    private String Date;

    @Element(required = false)
    @Path("LastMatch")
    private int MatchId;

    @Element(required = false)
    @Path("LastMatch")
    private int PositionCode;

    @Element(required = false)
    @Path("LastMatch")
    private int PlayedMinutes;

    @Element(required = false)
    @Path("LastMatch")
    private double Rating;

    @Element(required = false)
    @Path("LastMatch")
    private double RatingEndOfGame;

    public String getPlayerID() {
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

    public String getPlayerNumber() {
        return PlayerNumber;
    }

    public String getAge() {
        return Age;
    }

    public String getAgeDays() {
        return AgeDays;
    }

    public String getTSI() {
        return TSI;
    }

    public String getPlayerForm() {
        return PlayerForm;
    }

    public String getStatement() {
        return Statement;
    }

    public String getExperience() {
        return Experience;
    }

    public String getLoyalty() {
        return Loyalty;
    }

    public boolean isMotherClubBonus() {
        return MotherClubBonus;
    }

    public String getLeadership() {
        return Leadership;
    }

    public String getSalary() {
        return Salary;
    }

    public String getIsAbroad() {
        return IsAbroad;
    }

    public String getAgreeability() {
        return Agreeability;
    }

    public String getAggressiveness() {
        return Aggressiveness;
    }

    public String getHonesty() {
        return Honesty;
    }

    public String getLeagueGoals() {
        return LeagueGoals;
    }

    public String getCupGoals() {
        return CupGoals;
    }

    public String getFriendliesGoals() {
        return FriendliesGoals;
    }

    public String getCareerGoals() {
        return CareerGoals;
    }

    public String getCareerHattricks() {
        return CareerHattricks;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public boolean isTransferListed() {
        return (TransferListed.equals("1")) ? true : false;
    }

    public String getNationalTeamID() {
        return NationalTeamID;
    }

    public String getCountryID() {
        return CountryID;
    }

    public String getCaps() {
        return Caps;
    }

    public String getCapsU20() {
        return CapsU20;
    }

    public String getCards() {
        return Cards;
    }

    public String getInjuryLevel() {
        return InjuryLevel;
    }

    public String getStaminaSkill() {
        return StaminaSkill;
    }

    public String getKeeperSkill() {
        return KeeperSkill;
    }

    public String getPlaymakerSkill() {
        return PlaymakerSkill;
    }

    public String getScorerSkill() {
        return ScorerSkill;
    }

    public String getPassingSkill() {
        return PassingSkill;
    }

    public String getWingerSkill() {
        return WingerSkill;
    }

    public String getDefenderSkill() {
        return DefenderSkill;
    }

    public String getSetPiecesSkill() {
        return SetPiecesSkill;
    }

    public String getPlayerCategoryId() {
        return PlayerCategoryId;
    }

    public String getTransferListed() {
        return TransferListed;
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
