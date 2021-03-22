package org.hattrickscoreboardl.database.models.matches;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HLineup extends HModel {

    public HLineup(){ }

    int MatchID;

    int MatchContextID;

    int TeamID;

    String lineupType; // starting/lineup

    String PlayerID;

    String RoleID;

    String FirstName;

    String LastName;

    String NickName;

    String RatingStars;

    String RatingStarsEndOfMatch;

    String Behaviour;

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public int getMatchContextID() {
        return MatchContextID;
    }

    public void setMatchContextID(int matchContextID) {
        MatchContextID = matchContextID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public String getLineupType() {
        return lineupType;
    }

    public void setLineupType(String lineupType) {
        this.lineupType = lineupType;
    }

    public String getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(String playerID) {
        PlayerID = playerID;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String roleID) {
        RoleID = roleID;
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

    public String getRatingStars() {
        return RatingStars;
    }

    public void setRatingStars(String ratingStars) {
        RatingStars = ratingStars;
    }

    public String getRatingStarsEndOfMatch() {
        return RatingStarsEndOfMatch;
    }

    public void setRatingStarsEndOfMatch(String ratingStarsEndOfMatch) {
        RatingStarsEndOfMatch = ratingStarsEndOfMatch;
    }

    public String getBehaviour() {
        return Behaviour;
    }

    public void setBehaviour(String behaviour) {
        Behaviour = behaviour;
    }
}

