package org.hattrick.models.players;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class PlayerDetails {

    @Element
    @Path("Player")
    int PlayerID;

    @Element
    @Path("Player")
    String FirstName;

    @Element(required = false)
    @Path("Player")
    String NickName;

    @Element
    @Path("Player")
    String LastName;

    @Element
    @Path("Player")
    int PlayerNumber;

    @Element(required = false) /** Owner only **/
    @Path("Player")
    int PlayerCategoryID;

    @Element(required = false) /** Owner only **/
    @Path("Player")
    String OwnerNotes;

    @Element
    @Path("Player")
    int Age;

    @Element
    @Path("Player")
    int AgeDays;

    @Element
    @Path("Player")
    String NextBirthDay;

    @Element
    @Path("Player")
    String ArrivalDate;

    @Element
    @Path("Player")
    int PlayerForm;

    @Element
    @Path("Player")
    int Cards;

    @Element
    @Path("Player")
    int InjuryLevel;

    @Element(required = false) /** HT User only **/
    @Path("Player")
    String Statement;

    @Element(required = false) /** The language the player speaks in his Statement, if existing. Supporter only **/
    @Path("Player")
    int PlayerLanguageID;

    @Element(required = false) /** The language the player speaks in his Statement, if existing. Supporter only **/
    @Path("Player")
    String PlayerLanguage;

    @Path("Player/TrainerData")
    @Element(required = false)
    int TrainerType;

    @Path("Player/TrainerData")
    @Element(required = false)
    int TrainerSkill;

    @Element
    @Path("Player")
    int Agreeability;

    @Element
    @Path("Player")
    int Aggressiveness;

    @Element
    @Path("Player")
    int Honesty;

    @Element
    @Path("Player")
    int Experience;

    @Element
    @Path("Player")
    int Loyalty;

    @Element
    @Path("Player")
    boolean MotherClubBonus;

    @Element
    @Path("Player")
    int Leadership;

    @Element
    @Path("Player")
    int Specialty;


    @Element
    @Path("Player")
    int NativeCountryID;

    @Element
    @Path("Player")
    int NativeLeagueID;

    @Element
    @Path("Player")
    String NativeLeagueName;

    @Element
    @Path("Player")
    int TSI;


    @Element(name="TeamID")
    @Path("Player/OwningTeam")
    int OwningTeamID;

    @Element(name="TeamName")
    @Path("Player/OwningTeam")
    String OwningTeamName;

    @Element
    @Path("Player/OwningTeam")
    int LeagueID;

    @Element
    @Path("Player")
    double Salary;

    @Element
    @Path("Player")
    boolean IsAbroad;

    @Element
    @Path("Player/PlayerSkills")
    int StaminaSkill;

    @Element(required = false)
    @Path("Player/PlayerSkills")
    int KeeperSkill;

    @Element(required = false)
    @Path("Player/PlayerSkills")
    int PlaymakerSkill;

    @Element(required = false)
    @Path("Player/PlayerSkills")
    int ScorerSkill;

    @Element(required = false)
    @Path("Player/PlayerSkills")
    int PassingSkill;

    @Element(required = false)
    @Path("Player/PlayerSkills")
    int WingerSkill;

    @Element(required = false)
    @Path("Player/PlayerSkills")
    int DefenderSkill;

    @Element(required = false)
    @Path("Player/PlayerSkills")
    int SetPiecesSkill;

    @Element
    @Path("Player")
    int Caps;

    @Element
    @Path("Player")
    int CapsU20;

    @Element
    @Path("Player")
    int CareerGoals;

    @Element
    @Path("Player")
    int CareerHattricks;

    @Element
    @Path("Player")
    int LeagueGoals;

    @Element
    @Path("Player")
    int CupGoals;

    @Element
    @Path("Player")
    int FriendliesGoals;

    @Element
    @Path("Player")
    boolean TransferListed;

    @Element(required = false)
    @Path("Player/TransferDetails")
    double AskingPrice;

    @Element(required = false)
    @Path("Player/TransferDetails")
    String Deadline;

    @Element(required = false)
    @Path("Player/TransferDetails")
    double HighestBid;

    @Element(required = false)
    @Path("Player/TransferDetails")
    double MaxBid;


    @Element(name="TeamID", required = false)
    @Path("Player/TransferDetails/BidderTeam")
    int BidderTeamID;

    @Element(name="TeamName", required = false)
    @Path("Player/TransferDetails/BidderTeam")
    String BidderTeamName;

    @Element(required = false)
    @Path("Player/LastMatch")
    String Date;

    @Element(required = false)
    @Path("Player/LastMatch")
    int MatchId;

    @Element(required = false)
    @Path("Player/LastMatch")
    int PositionCode;

    @Element(required = false)
    @Path("Player/LastMatch")
    int PlayedMinutes;

    @Element(required = false)
    @Path("Player/LastMatch")
    double Rating;

    @Element(required = false)
    @Path("Player/LastMatch")
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

    public int getPlayerCategoryID() {
        return PlayerCategoryID;
    }

    public String getOwnerNotes() {
        return OwnerNotes;
    }

    public int getAge() {
        return Age;
    }

    public int getAgeDays() {
        return AgeDays;
    }

    public String getNextBirthDay() {
        return NextBirthDay;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public int getPlayerForm() {
        return PlayerForm;
    }

    public int getCards() {
        return Cards;
    }

    public int getInjuryLevel() {
        return InjuryLevel;
    }

    public String getStatement() {
        return Statement;
    }

    public int getPlayerLanguageID() {
        return PlayerLanguageID;
    }

    public String getPlayerLanguage() {
        return PlayerLanguage;
    }

    public int getTrainerType() {
        return TrainerType;
    }

    public int getTrainerSkill() {
        return TrainerSkill;
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

    public int getExperience() {
        return Experience;
    }

    public int getLoyalty() {
        return Loyalty;
    }

    public boolean getMotherClubBonus() {
        return MotherClubBonus;
    }

    public int getLeadership() {
        return Leadership;
    }

    public int getSpecialty() {
        return Specialty;
    }

    public int getNativeCountryID() {
        return NativeCountryID;
    }

    public int getNativeLeagueID() {
        return NativeLeagueID;
    }

    public String getNativeLeagueName() {
        return NativeLeagueName;
    }

    public int getTSI() {
        return TSI;
    }

    public int getOwningTeamID() {
        return OwningTeamID;
    }

    public String getOwningTeamName() {
        return OwningTeamName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public double getSalary() {
        return Salary;
    }

    public boolean isAbroad() {
        return IsAbroad;
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

    public int getCaps() {
        return Caps;
    }

    public int getCapsU20() {
        return CapsU20;
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

    public int getCupGoals() {
        return CupGoals;
    }

    public int getFriendliesGoals() {
        return FriendliesGoals;
    }

    public boolean isTransferListed() {
        return TransferListed;
    }

    public double getAskingPrice() {
        return AskingPrice;
    }

    public String getDeadline() {
        return Deadline;
    }

    public double getHighestBid() {
        return HighestBid;
    }

    public double getMaxBid() {
        return MaxBid;
    }

    public int getBidderTeamID() {
        return BidderTeamID;
    }

    public String getBidderTeamName() {
        return BidderTeamName;
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
