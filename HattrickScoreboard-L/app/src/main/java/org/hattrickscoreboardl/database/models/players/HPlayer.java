package org.hattrickscoreboardl.database.models.players;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HPlayer extends HModel {

    public HPlayer(){}

    
    int teamID;

    int PlayerID;

    String FirstName;

    String NickName;

    String LastName;

    int PlayerNumber;

    int Age;

    int AgeDays;

    int TSI;

    int PlayerForm;

    String Statement;

    int Experience;

    int Loyalty;

    boolean MotherClubBonus;

    int Leadership;

    double Salary;

    boolean IsAbroad;

    int Agreeability;

    int Aggressiveness;

    int Honesty;

    int LeagueGoals;

    int CupGoals;

    int FriendliesGoals;

    int CareerGoals;

    int CareerHattricks;

    int Specialty;

    boolean TransferListed;

    int NationalTeamID;

    int CountryID;

    int Caps;

    int CapsU20;

    int Cards;

    int InjuryLevel;

    int StaminaSkill;

    int KeeperSkill;

    int PlaymakerSkill;

    int ScorerSkill;

    int PassingSkill;

    int WingerSkill;

    int DefenderSkill;

    int SetPiecesSkill;

    int PlayerCategoryID;

    String LastMatchDate;

    int LastMatchId;

    int LastMatchPositionCode;

    int LastMatchPlayedMinutes;

    double LastMatchRating;

    double LastMatchRatingEndOfGame;

    //From details;

    /** Owner only **/

    /** Owner only **/
    String OwnerNotes;

    String NextBirthDay;

    String ArrivalDate;

    /** The language the player speaks in his Statement, if existing. Supporter only **/
    int PlayerLanguageID;

    /** The language the player speaks in his Statement, if existing. Supporter only **/
    String PlayerLanguage;

    int TrainerType;

    int TrainerSkill;

    int NativeCountryID;

    int NativeLeagueID;

    String NativeLeagueName;

    int LeagueID;

    double TransferAskingPrice;

    String TransferDeadline;

    double TransferHighestBid;

    double TransferMaxBid;

    int TransferBidderTeamID;

    String TransferBidderTeamName;


    //Only for Youth player

    boolean isYouth;

    boolean CanBePromotedIn;

    //Getter

    public int getTeamID() {
        return teamID;
    }

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

    public double getSalary() {
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

    public int getPlayerCategoryID() {
        return PlayerCategoryID;
    }

    public String getLastMatchDate() {
        return LastMatchDate;
    }

    public int getLastMatchId() {
        return LastMatchId;
    }

    public int getLastMatchPositionCode() {
        return LastMatchPositionCode;
    }

    public int getLastMatchPlayedMinutes() {
        return LastMatchPlayedMinutes;
    }

    public double getLastMatchRating() {
        return LastMatchRating;
    }

    public double getLastMatchRatingEndOfGame() {
        return LastMatchRatingEndOfGame;
    }

    public String getOwnerNotes() {
        return OwnerNotes;
    }

    public String getNextBirthDay() {
        return NextBirthDay;
    }

    public String getArrivalDate() {
        return ArrivalDate;
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

    public int getNativeCountryID() {
        return NativeCountryID;
    }

    public int getNativeLeagueID() {
        return NativeLeagueID;
    }

    public String getNativeLeagueName() {
        return NativeLeagueName;
    }

    public int getLeagueID() {
        return LeagueID;
    }

    public double getTransferAskingPrice() {
        return TransferAskingPrice;
    }

    public String getTransferDeadline() {
        return TransferDeadline;
    }

    public double getTransferHighestBid() {
        return TransferHighestBid;
    }

    public double getTransferMaxBid() {
        return TransferMaxBid;
    }

    public int getTransferBidderTeamID() {
        return TransferBidderTeamID;
    }

    public String getTransferBidderTeamName() {
        return TransferBidderTeamName;
    }

    public boolean isYouth() {
        return isYouth;
    }

    public boolean isCanBePromotedIn() {
        return CanBePromotedIn;
    }

    //Setter

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setAgeDays(int ageDays) {
        AgeDays = ageDays;
    }

    public void setTSI(int TSI) {
        this.TSI = TSI;
    }

    public void setPlayerForm(int playerForm) {
        PlayerForm = playerForm;
    }

    public void setStatement(String statement) {
        Statement = statement;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public void setLoyalty(int loyalty) {
        Loyalty = loyalty;
    }

    public void setMotherClubBonus(boolean motherClubBonus) {
        MotherClubBonus = motherClubBonus;
    }

    public void setLeadership(int leadership) {
        Leadership = leadership;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public void setAbroad(boolean isAbroad) {
        IsAbroad = isAbroad;
    }

    public void setAgreeability(int agreeability) {
        Agreeability = agreeability;
    }

    public void setAggressiveness(int aggressiveness) {
        Aggressiveness = aggressiveness;
    }

    public void setHonesty(int honesty) {
        Honesty = honesty;
    }

    public void setLeagueGoals(int leagueGoals) {
        LeagueGoals = leagueGoals;
    }

    public void setCupGoals(int cupGoals) {
        CupGoals = cupGoals;
    }

    public void setFriendliesGoals(int friendliesGoals) {
        FriendliesGoals = friendliesGoals;
    }

    public void setCareerGoals(int careerGoals) {
        CareerGoals = careerGoals;
    }

    public void setCareerHattricks(int careerHattricks) {
        CareerHattricks = careerHattricks;
    }

    public void setSpecialty(int specialty) {
        Specialty = specialty;
    }

    public void setTransferListed(boolean transferListed) {
        TransferListed = transferListed;
    }

    public void setNationalTeamID(int nationalTeamID) {
        NationalTeamID = nationalTeamID;
    }

    public void setCountryID(int countryID) {
        CountryID = countryID;
    }

    public void setCaps(int caps) {
        Caps = caps;
    }

    public void setCapsU20(int capsU20) {
        CapsU20 = capsU20;
    }

    public void setCards(int cards) {
        Cards = cards;
    }

    public void setInjuryLevel(int injuryLevel) {
        InjuryLevel = injuryLevel;
    }

    public void setStaminaSkill(int staminaSkill) {
        StaminaSkill = staminaSkill;
    }

    public void setKeeperSkill(int keeperSkill) {
        KeeperSkill = keeperSkill;
    }

    public void setPlaymakerSkill(int playmakerSkill) {
        PlaymakerSkill = playmakerSkill;
    }

    public void setScorerSkill(int scorerSkill) {
        ScorerSkill = scorerSkill;
    }

    public void setPassingSkill(int passingSkill) {
        PassingSkill = passingSkill;
    }

    public void setWingerSkill(int wingerSkill) {
        WingerSkill = wingerSkill;
    }

    public void setDefenderSkill(int defenderSkill) {
        DefenderSkill = defenderSkill;
    }

    public void setSetPiecesSkill(int setPiecesSkill) {
        SetPiecesSkill = setPiecesSkill;
    }

    public void setPlayerCategoryID(int playerCategoryID) {
        PlayerCategoryID = playerCategoryID;
    }

    public void setLastMatchDate(String lastMatchDate) {
        LastMatchDate = lastMatchDate;
    }

    public void setLastMatchId(int lastMatchId) {
        LastMatchId = lastMatchId;
    }

    public void setLastMatchPositionCode(int lastMatchPositionCode) {
        LastMatchPositionCode = lastMatchPositionCode;
    }

    public void setLastMatchPlayedMinutes(int lastMatchPlayedMinutes) {
        LastMatchPlayedMinutes = lastMatchPlayedMinutes;
    }

    public void setLastMatchRating(double lastMatchRating) {
        LastMatchRating = lastMatchRating;
    }

    public void setLastMatchRatingEndOfGame(double lastMatchRatingEndOfGame) {
        LastMatchRatingEndOfGame = lastMatchRatingEndOfGame;
    }

    public void setOwnerNotes(String ownerNotes) {
        OwnerNotes = ownerNotes;
    }

    public void setNextBirthDay(String nextBirthDay) {
        NextBirthDay = nextBirthDay;
    }

    public void setArrivalDate(String arrivalDate) {
        ArrivalDate = arrivalDate;
    }

    public void setPlayerLanguageID(int playerLanguageID) {
        PlayerLanguageID = playerLanguageID;
    }

    public void setPlayerLanguage(String playerLanguage) {
        PlayerLanguage = playerLanguage;
    }

    public void setTrainerType(int trainerType) {
        TrainerType = trainerType;
    }

    public void setTrainerSkill(int trainerSkill) {
        TrainerSkill = trainerSkill;
    }

    public void setNativeCountryID(int nativeCountryID) {
        NativeCountryID = nativeCountryID;
    }

    public void setNativeLeagueID(int nativeLeagueID) {
        NativeLeagueID = nativeLeagueID;
    }

    public void setNativeLeagueName(String nativeLeagueName) {
        NativeLeagueName = nativeLeagueName;
    }

    public void setLeagueID(int leagueID) {
        LeagueID = leagueID;
    }

    public void setTransferAskingPrice(double transferAskingPrice) {
        TransferAskingPrice = transferAskingPrice;
    }

    public void setTransferDeadline(String transferDeadline) {
        TransferDeadline = transferDeadline;
    }

    public void setTransferHighestBid(double transferHighestBid) {
        TransferHighestBid = transferHighestBid;
    }

    public void setTransferMaxBid(double transferMaxBid) {
        TransferMaxBid = transferMaxBid;
    }

    public void setTransferBidderTeamID(int transferBidderTeamID) {
        TransferBidderTeamID = transferBidderTeamID;
    }

    public void setTransferBidderTeamName(String transferBidderTeamName) {
        TransferBidderTeamName = transferBidderTeamName;
    }

    public void setYouth(boolean isYouth) {
        this.isYouth = isYouth;
    }

    public void setCanBePromotedIn(boolean canBePromotedIn) {
        CanBePromotedIn = canBePromotedIn;
    }
}
