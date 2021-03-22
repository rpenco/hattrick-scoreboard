package org.hattrick.models.managers;

import org.hattrick.models.world.Language;
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
public class ManagerCompendium {

    @Element
    @Path("Manager")
    int UserId;

    @Element
    @Path("Manager")
    String Loginname;

    @Element
    @Path("Manager")
    String SupporterTier;

    @Element
    @Path("Manager")
    Language Language;

    @Element
    @Path("Manager/Country")
    int CountryId;

    @Element
    @Path("Manager/Country")
    String CountryName;


    @ElementList
    @Path("Manager")
    ArrayList<ManagerTeam> Teams;

    @ElementList
    @Path("Manager")
    ArrayList<ManagerNationalTeam> NationalTeamCoach;

    public int getUserId() {
        return UserId;
    }

    public String getLoginname() {
        return Loginname;
    }

    public String getSupporterTier() {
        return SupporterTier;
    }

    public Language getLanguage() {
        return Language;
    }

    public int getCountryId() {
        return CountryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public ArrayList<ManagerTeam> getTeams() {
        return Teams;
    }

    public ArrayList<ManagerNationalTeam> getNationalTeam() {
        return NationalTeamCoach;
    }
}
