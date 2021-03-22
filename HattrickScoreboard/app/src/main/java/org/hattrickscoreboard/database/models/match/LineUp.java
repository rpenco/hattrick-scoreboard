package org.hattrickscoreboard.database.models.match;

/**
 * @author Khips
 * @since 7 aot 2014
 */
public class LineUp {

    long _id;
    int MatchID;
    String SourceSystem;
    int PlayerID;
    int TeamID;
    String FirstName;
    String LastName;
    String NickName;
    int StartingRoleID;
    int RoleID;
    int Behaviour;
    int StartingBehaviour;
    double RatingStars;
    double RatingStarsEndOfMatch;
    boolean Captain;
    boolean SetPieces;

    public long getID() {
        return _id;
    }

    public void setID(long _id) {
        this._id = _id;
    }

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int roleID) {
        RoleID = roleID;
    }

    public int getBehaviour() {
        return Behaviour;
    }

    public void setBehaviour(int behaviour) {
        Behaviour = behaviour;
    }

    public double getRatingStars() {
        return RatingStars;
    }

    public void setRatingStars(String ratingStars) {
        if (ratingStars != null)
            RatingStars = Double.parseDouble(ratingStars);
    }

    public double getRatingStarsEndOfMatch() {
        return RatingStarsEndOfMatch;
    }

    public void setRatingStarsEndOfMatch(String ratingStarsEndOfMatch) {
        if (ratingStarsEndOfMatch != null)
            RatingStarsEndOfMatch = Double.parseDouble(ratingStarsEndOfMatch);
    }

    public boolean isCaptain() {
        return Captain;
    }

    public void setCaptain(String lineup) {
        Captain = lineup.equals("1");
    }

    public boolean isSetPieces() {
        return SetPieces;
    }

    public void setSetPieces(String startingLineup) {
        SetPieces = startingLineup.equals("1");
    }

    public int getStartingRoleID() {
        return StartingRoleID;
    }

    public void setStartingRoleID(int startingRoleID) {
        StartingRoleID = startingRoleID;
    }

    public int getStartingBehaviour() {
        return StartingBehaviour;
    }

    public void setStartingBehaviour(int startingBehaviour) {
        StartingBehaviour = startingBehaviour;
    }

}
