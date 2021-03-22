package org.hattrick.models.tournaments;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class Tournaments {

    @ElementList
    ArrayList<Tournament> Tournaments;

    public ArrayList<Tournament> getTournaments() {
        return Tournaments;
    }
}
