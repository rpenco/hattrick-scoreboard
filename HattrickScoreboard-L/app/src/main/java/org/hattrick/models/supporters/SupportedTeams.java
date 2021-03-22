package org.hattrick.models.supporters;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 01/11/2014.
 */
@Root(strict = false)
public class SupportedTeams {

    @ElementList
    ArrayList<SupportedTeam> SupportedTeams;

    public ArrayList<SupportedTeam> getSupportedTeams() {
        return SupportedTeams;
    }
}
