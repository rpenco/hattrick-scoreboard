package org.hattrick.models.club;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Club {

    public
    @Element
    @Path("Team/YouthSquad")
    boolean HasPromoted;
    @Element
    int UserID;
    @Element
    @Path("Team")
    int TeamID;
    @Element
    @Path("Team")
    String TeamName;
    @Element
    @Path("Team/Staff")
    int AssistantTrainerLevels;
    @Element
    @Path("Team/Staff")
    int FinancialDirectorLevels;
    @Element
    @Path("Team/Staff")
    int FormCoachLevels;
    @Element
    @Path("Team/Staff")
    int MedicLevels;
    @Element
    @Path("Team/Staff")
    int SpokespersonLevels;
    @Element
    @Path("Team/Staff")
    int SportPsychologistLevels;
    @Element
    @Path("Team/YouthSquad")
    int Investment;
    @Element
    @Path("Team/YouthSquad")
    int YouthLevel;

    public int getUserID() {
        return UserID;
    }

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public int getAssistantTrainerLevels() {
        return AssistantTrainerLevels;
    }

    public int getFinancialDirectorLevels() {
        return FinancialDirectorLevels;
    }

    public int getFormCoachLevels() {
        return FormCoachLevels;
    }

    public int getMedicLevels() {
        return MedicLevels;
    }

    public int getSpokespersonLevels() {
        return SpokespersonLevels;
    }

    public int getSportPsychologistLevels() {
        return SportPsychologistLevels;
    }

    public int getInvestment() {
        return Investment;
    }

    public boolean isHasPromoted() {
        return HasPromoted;
    }

    public int getYouthLevel() {
        return YouthLevel;
    }

}
