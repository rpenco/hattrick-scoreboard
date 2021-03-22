package org.hattrick.models.ladders;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class Ladder {

    @Element
    int LadderId;

    @Element
    String Name;

    @Element
    int Posistion;

    @Element
    String NextMatchDate;

    @Element
    int Wins;

    @Element
    int Lost;

    public int getLadderId() {
        return LadderId;
    }

    public String getName() {
        return Name;
    }

    public int getPosistion() {
        return Posistion;
    }

    public String getNextMatchDate() {
        return NextMatchDate;
    }

    public int getWins() {
        return Wins;
    }

    public int getLost() {
        return Lost;
    }
}
