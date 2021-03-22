package org.hattrick.models.challenges;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(strict = false)
public class Challenges {

    @Element
    @Path("Team")
    int TeamID;

    @Element
    @Path("Team")
    String TeamName;

    @ElementList(required = false)
    @Path("Team")
    ArrayList<Challenge> ChallengesByMe;

    @ElementList(required = false)
    @Path("Team")
    ArrayList<Challenge> OffersByOthers;

    public int getTeamID() {
        return TeamID;
    }

    public String getTeamName() {
        return TeamName;
    }

    public ArrayList<Challenge> getChallengesByMe() {
        return ChallengesByMe;
    }

    public ArrayList<Challenge> getOffersByOthers() {
        return OffersByOthers;
    }
}
