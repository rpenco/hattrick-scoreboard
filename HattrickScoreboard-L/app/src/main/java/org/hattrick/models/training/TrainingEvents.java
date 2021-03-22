package org.hattrick.models.training;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class TrainingEvents {

    @Element
    @Path("Player")
    int PlayerID;

    @ElementList
    @Path("Player")
    ArrayList<TrainingEvent> TrainingEvents;

    public int getPlayerID() {
        return PlayerID;
    }

    public ArrayList<TrainingEvent> getTrainingEvents() {
        return TrainingEvents;
    }
}
