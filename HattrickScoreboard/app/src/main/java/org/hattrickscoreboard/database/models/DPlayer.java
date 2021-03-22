package org.hattrickscoreboard.database.models;

public class DPlayer extends DModel {

    long _id;
    int teamId;
    int playerId;
    String firstname;
    String nickname;
    String lastname;
    int number;
    int age;
    int ageDays;
    int TSI;
    int form;
    String statement;
    int experience;
    int loyalty;
    boolean motherclubBonus;
    int leadership;
    double salary;
    boolean isAbroad;
    int agreeability;
    int aggressiveness;
    int honesty;
    int leaguegoals;
    int cupgoals;
    int friendliesGoals;
    int careerGoals;
    int careerHattricks;
    int specialty;
    boolean transferListed;
    int nationalteamId;
    int countryId;
    int caps;
    int capsU20;
    int cards;
    int injuryLevel;
    int staminaSkill;
    int keeperSkill;
    int playmakerSkill;
    int scorerSkill;
    int passingSkill;
    int wingerSkill;
    int defenderSkill;
    int setpiecesSkill;
    int categoryId;
    String lastMatchDate;
    int lastMatchId;
    int lastMatchPositionCode;
    int lastMatchPlayedMinutes;
    double lastMatchRating;
    double lastMatchRatingEndOfGame;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerID() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeDays() {
        return ageDays;
    }

    public void setAgeDays(int ageDays) {
        this.ageDays = ageDays;
    }

    public int getTSI() {
        return TSI;
    }

    public void setTSI(int tSI) {
        TSI = tSI;
    }

    public int getForm() {
        return form;
    }

    public void setForm(int form) {
        this.form = form;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }

    public boolean isMotherclubBonus() {
        return motherclubBonus;
    }

    public void setMotherclubBonus(boolean motherclubBonus) {
        this.motherclubBonus = motherclubBonus;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isAbroad() {
        return isAbroad;
    }

    public void setAbroad(boolean isAbroad) {
        this.isAbroad = isAbroad;
    }

    public int getAgreeability() {
        return agreeability;
    }

    public void setAgreeability(int agreeability) {
        this.agreeability = agreeability;
    }

    public int getAggressiveness() {
        return aggressiveness;
    }

    public void setAggressiveness(int aggressiveness) {
        this.aggressiveness = aggressiveness;
    }

    public int getHonesty() {
        return honesty;
    }

    public void setHonesty(int honesty) {
        this.honesty = honesty;
    }

    public int getLeaguegoals() {
        return leaguegoals;
    }

    public void setLeaguegoals(int leaguegoals) {
        this.leaguegoals = leaguegoals;
    }

    public int getCupgoals() {
        return cupgoals;
    }

    public void setCupgoals(int cupgoals) {
        this.cupgoals = cupgoals;
    }

    public int getFriendliesGoals() {
        return friendliesGoals;
    }

    public void setFriendliesGoals(int friendliesGoals) {
        this.friendliesGoals = friendliesGoals;
    }

    public int getCareerGoals() {
        return careerGoals;
    }

    public void setCareerGoals(int careerGoals) {
        this.careerGoals = careerGoals;
    }

    public int getCareerHattricks() {
        return careerHattricks;
    }

    public void setCareerHattricks(int careerHattricks) {
        this.careerHattricks = careerHattricks;
    }

    public int getSpecialty() {
        return specialty;
    }

    public void setSpecialty(int specialty) {
        this.specialty = specialty;
    }

    public boolean isTransferListed() {
        return transferListed;
    }

    public void setTransferListed(boolean transferListed) {
        this.transferListed = transferListed;
    }

    public int getNationalteamId() {
        return nationalteamId;
    }

    public void setNationalteamId(int nationalteamId) {
        this.nationalteamId = nationalteamId;
    }

    public int getCountryID() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getCaps() {
        return caps;
    }

    public void setCaps(int caps) {
        this.caps = caps;
    }

    public int getCapsU20() {
        return capsU20;
    }

    public void setCapsU20(int capsU20) {
        this.capsU20 = capsU20;
    }

    public int getCards() {
        return cards;
    }

    public void setCards(int cards) {
        this.cards = cards;
    }

    public int getInjuryLevel() {
        return injuryLevel;
    }

    public void setInjuryLevel(int injuryLevel) {
        this.injuryLevel = injuryLevel;
    }

    public int getStaminaSkill() {
        return staminaSkill;
    }

    public void setStaminaSkill(int staminaSkill) {
        this.staminaSkill = staminaSkill;
    }

    public int getKeeperSkill() {
        return keeperSkill;
    }

    public void setKeeperSkill(int keeperSkill) {
        this.keeperSkill = keeperSkill;
    }

    public int getPlaymakerSkill() {
        return playmakerSkill;
    }

    public void setPlaymakerSkill(int playmakerSkill) {
        this.playmakerSkill = playmakerSkill;
    }

    public int getScorerSkill() {
        return scorerSkill;
    }

    public void setScorerSkill(int scorerSkill) {
        this.scorerSkill = scorerSkill;
    }

    public int getPassingSkill() {
        return passingSkill;
    }

    public void setPassingSkill(int passingSkill) {
        this.passingSkill = passingSkill;
    }

    public int getWingerSkill() {
        return wingerSkill;
    }

    public void setWingerSkill(int wingerSkill) {
        this.wingerSkill = wingerSkill;
    }

    public int getDefenderSkill() {
        return defenderSkill;
    }

    public void setDefenderSkill(int defenderSkill) {
        this.defenderSkill = defenderSkill;
    }

    public int getSetpiecesSkill() {
        return setpiecesSkill;
    }

    public void setSetpiecesSkill(int setpiecesSkill) {
        this.setpiecesSkill = setpiecesSkill;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getLastMatchDate() {
        return lastMatchDate;
    }

    public void setLastMatchDate(String lastMatchDate) {
        this.lastMatchDate = lastMatchDate;
    }

    public int getLastMatchId() {
        return lastMatchId;
    }

    public void setLastMatchId(int lastMatchId) {
        this.lastMatchId = lastMatchId;
    }

    public int getLastMatchPositionCode() {
        return lastMatchPositionCode;
    }

    public void setLastMatchPositionCode(int lastMatchPositionCode) {
        this.lastMatchPositionCode = lastMatchPositionCode;
    }

    public int getLastMatchPlayedMinutes() {
        return lastMatchPlayedMinutes;
    }

    public void setLastMatchPlayedMinutes(int lastMatchPlayedMinutes) {
        this.lastMatchPlayedMinutes = lastMatchPlayedMinutes;
    }

    public double getLastMatchRating() {
        return lastMatchRating;
    }

    public void setLastMatchRating(double lastMatchRating) {
        this.lastMatchRating = lastMatchRating;
    }

    public double getLastMatchRatingEndOfGame() {
        return lastMatchRatingEndOfGame;
    }

    public void setLastMatchRatingEndOfGame(double lastMatchRatingEndOfGame) {
        this.lastMatchRatingEndOfGame = lastMatchRatingEndOfGame;
    }

}
