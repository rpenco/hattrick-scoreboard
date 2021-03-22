package org.hattrick.models.training;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "HattrickData", strict = false)
public class Training {

    @Element
    @Path("Team")
    String TeamID;

    @Element
    @Path("Team")
    String TrainingLevel;

    @Element
    @Path("Team")
    String TrainingType;

    @Element
    @Path("Team")
    String StaminaTrainingPart;

    @Element
    @Path("Team")
    String LastTrainingTrainingType;

    @Element
    @Path("Team")
    String LastTrainingTrainingLevel;

    @Element
    @Path("Team")
    String LastTrainingStaminaTrainingPart;

    @Element
    @Path("Team/Trainer")
    String TrainerID;

    @Element
    @Path("Team/Trainer")
    String ArrivalDate;

    @Element
    @Path("Team")
    String Morale;

    @Element
    @Path("Team")
    String SelfConfidence;

    @Element
    @Path("Team")
    String Experience442;

    @Element
    @Path("Team")
    String Experience433;

    @Element
    @Path("Team")
    String Experience451;

    @Element
    @Path("Team")
    String Experience352;

    @Element
    @Path("Team")
    String Experience532;

    @Element
    @Path("Team")
    String Experience343;

    @Element
    @Path("Team")
    String Experience541;

    @Element
    @Path("Team")
    String Experience523;

    @Element
    @Path("Team")
    String Experience550;

    @Element
    @Path("Team")
    String Experience253;

    public String getTeamID() {
        return TeamID;
    }

    public String getTrainingLevel() {
        return TrainingLevel;
    }

    public String getTrainingType() {
        return TrainingType;
    }

    public String getStaminaTrainingPart() {
        return StaminaTrainingPart;
    }

    public String getLastTrainingTrainingType() {
        return LastTrainingTrainingType;
    }

    public String getLastTrainingTrainingLevel() {
        return LastTrainingTrainingLevel;
    }

    public String getLastTrainingStaminaTrainingPart() {
        return LastTrainingStaminaTrainingPart;
    }

    public String getTrainerID() {
        return TrainerID;
    }

    public String getTrainerArrivalDate() {
        return ArrivalDate;
    }

    public String getMorale() {
        return Morale;
    }

    public String getSelfConfidence() {
        return SelfConfidence;
    }

    public String getExperience442() {
        return Experience442;
    }

    public String getExperience433() {
        return Experience433;
    }

    public String getExperience451() {
        return Experience451;
    }

    public String getExperience352() {
        return Experience352;
    }

    public String getExperience532() {
        return Experience532;
    }

    public String getExperience343() {
        return Experience343;
    }

    public String getExperience541() {
        return Experience541;
    }

    public String getExperience523() {
        return Experience523;
    }

    public String getExperience550() {
        return Experience550;
    }

    public String getExperience253() {
        return Experience253;
    }

}
