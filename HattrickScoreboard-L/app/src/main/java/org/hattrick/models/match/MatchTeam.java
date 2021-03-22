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
    private int Goals;

    @Element(required = false)
    private int TacticType;

    @Element(required = false)
    private int TacticSkill;

    @Element(required = false)
    private int RatingMidfield;

    @Element(required = false)
    private int RatingRightDef;

    @Element(required = false)
    private int RatingMidDef;

    @Element(required = false)
    private int RatingLeftDef;

    @Element(required = false)
    private int RatingRightAtt;

    @Element(required = false)
    private int RatingMidAtt;

    @Element(required = false)
    private int RatingLeftAtt;

    @Element(required = false)
    private int TeamAttitude;

    @Element(required = false)
    private int RatingIndirectSetPiecesDef;

    @Element(required = false)
    private int RatingIndirectSetPiecesAtt;

    public String getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getDressURI() {
        return DressURI;
    }

    public String getFormation() {
        return Formation;
    }

    public int getGoals() {
        return Goals;
    }

    public int getTacticType() {
        return TacticType;
    }

    public int getTacticSkill() {
        return TacticSkill;
    }

    public int getRatingMidfield() {
        return RatingMidfield;
    }

    public int getRatingRightDef() {
        return RatingRightDef;
    }

    public int getRatingMidDef() {
        return RatingMidDef;
    }

    public int getRatingLeftDef() {
        return RatingLeftDef;
    }

    public int getRatingRightAtt() {
        return RatingRightAtt;
    }

    public int getRatingMidAtt() {
        return RatingMidAtt;
    }

    public int getRatingLeftAtt() {
        return RatingLeftAtt;
    }

    public int getTeamAttitude() {
        return TeamAttitude;
    }

    public int getRatingIndirectSetPiecesDef() {
        return RatingIndirectSetPiecesDef;
    }

    public int getRatingIndirectSetPiecesAtt() {
        return RatingIndirectSetPiecesAtt;
    }
}
