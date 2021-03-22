package org.hattrick.models.match;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class MatchTeam {

    @ElementUnion({@Element(name = "HomeTeamID"),
            @Element(name = "AwayTeamID")})
    private String TeamID;

    @ElementUnion({@Element(name = "HomeTeamName"),
            @Element(name = "AwayTeamName")})
    private String TeamName;

    @Element(required = false)
    private String DressURI;

    @Element(required = false)
    private String Formation;

    @ElementUnion({@Element(name = "HomeGoals", required = false),
            @Element(name = "AwayGoals", required = false)})
    private String Goals;

    @Element(required = false)
    private String TacticType;

    @Element(required = false)
    private String TacticSkill;

    @Element(required = false)
    private String RatingMidfield;

    @Element(required = false)
    private String RatingRightDef;

    @Element(required = false)
    private String RatingMidDef;

    @Element(required = false)
    private String RatingLeftDef;

    @Element(required = false)
    private String RatingRightAtt;

    @Element(required = false)
    private String RatingMidAtt;

    @Element(required = false)
    private String RatingLeftAtt;

    @Element(required = false)
    private String TeamAttitude;

    @Element(required = false)
    private String RatingIndirectSetPiecesDef;

    @Element(required = false)
    private String RatingIndirectSetPiecesAtt;

    public String getTeamID() {
        return TeamID;
    }

    public void setTeamID(String teamID) {
        TeamID = teamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getDressURI() {
        return DressURI;
    }

    public void setDressURI(String dressURI) {
        DressURI = dressURI;
    }

    public String getFormation() {
        return Formation;
    }

    public void setFormation(String formation) {
        Formation = formation;
    }

    public String getGoals() {
        return Goals;
    }

    public void setGoals(String goals) {
        Goals = goals;
    }

    public String getTacticType() {
        return TacticType;
    }

    public void setTacticType(String tacticType) {
        TacticType = tacticType;
    }

    public String getTacticSkill() {
        return TacticSkill;
    }

    public void setTacticSkill(String tacticSkill) {
        TacticSkill = tacticSkill;
    }

    public String getRatingMidfield() {
        return RatingMidfield;
    }

    public void setRatingMidfield(String ratingMidfield) {
        RatingMidfield = ratingMidfield;
    }

    public String getRatingRightDef() {
        return RatingRightDef;
    }

    public void setRatingRightDef(String ratingRightDef) {
        RatingRightDef = ratingRightDef;
    }

    public String getRatingMidDef() {
        return RatingMidDef;
    }

    public void setRatingMidDef(String ratingMidDef) {
        RatingMidDef = ratingMidDef;
    }

    public String getRatingLeftDef() {
        return RatingLeftDef;
    }

    public void setRatingLeftDef(String ratingLeftDef) {
        RatingLeftDef = ratingLeftDef;
    }

    public String getRatingRightAtt() {
        return RatingRightAtt;
    }

    public void setRatingRightAtt(String ratingRightAtt) {
        RatingRightAtt = ratingRightAtt;
    }

    public String getRatingMidAtt() {
        return RatingMidAtt;
    }

    public void setRatingMidAtt(String ratingMidAtt) {
        RatingMidAtt = ratingMidAtt;
    }

    public String getRatingLeftAtt() {
        return RatingLeftAtt;
    }

    public void setRatingLeftAtt(String ratingLeftAtt) {
        RatingLeftAtt = ratingLeftAtt;
    }

    public String getTeamAttitude() {
        return TeamAttitude;
    }

    public void setTeamAttitude(String teamAttitude) {
        TeamAttitude = teamAttitude;
    }

    public String getRatingIndirectSetPiecesDef() {
        return RatingIndirectSetPiecesDef;
    }

    public void setRatingIndirectSetPiecesDef(String ratingIndirectSetPiecesDef) {
        RatingIndirectSetPiecesDef = ratingIndirectSetPiecesDef;
    }

    public String getRatingIndirectSetPiecesAtt() {
        return RatingIndirectSetPiecesAtt;
    }

    public void setRatingIndirectSetPiecesAtt(String ratingIndirectSetPiecesAtt) {
        RatingIndirectSetPiecesAtt = ratingIndirectSetPiecesAtt;
    }

}
