package org.hattrick.models.match;

import org.simpleframework.xml.Element;

public class PlayerLineup {

    @Element
    private String PlayerID;

    @Element
    private String RoleID;

    @Element
    private String FirstName;

    @Element
    private String LastName;

    @Element(required = false)
    private String NickName;

    @Element(required = false)
    private String RatingStars;

    @Element(required = false)
    private String RatingStarsEndOfMatch;

    @Element(required = false)
    private String Behaviour;

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
