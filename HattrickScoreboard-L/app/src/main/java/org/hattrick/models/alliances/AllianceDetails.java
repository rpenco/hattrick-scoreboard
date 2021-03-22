package org.hattrick.models.alliances;

import org.hattrick.models.world.Language;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

@Root(strict = false)
public class AllianceDetails {

    @Element
    @Path("Alliance")
    int AllianceID;

    @Element
    @Path("Alliance")
    String AllianceName;

    @Element
    @Path("Alliance")
    String Abbreviation;

    @Element(required = false)
    @Path("Alliance")
    String Description;

    @Element
    @Path("Alliance")
    String LogoURL;

    @Element
    @Path("Alliance")
    String TopRole;

    @Element
    @Path("Alliance")
    int TopUserID;

    @Element
    @Path("Alliance")
    String TopLoginname;

    @Element
    @Path("Alliance")
    String CreationDate;

    @Element(required = false)
    @Path("Alliance")
    String HomePageURL;

    @Element
    @Path("Alliance")
    int NumberOfMembers;

    @ElementList
    @Path("Alliance")
    ArrayList<Language> Languages;

    @Element(required = false)
    @Path("Alliance")
    String Message;

    @Element(required = false)
    @Path("Alliance")
    String Rules;

    @Element(required = false)
    @Path("Alliance/UserRole")
    int RoleId;

    @Element(required = false)
    @Path("Alliance/UserRole")
    String RoleName;

    public String getRoleName() {
        return RoleName;
    }

    public int getAllianceID() {
        return AllianceID;
    }

    public String getAllianceName() {
        return AllianceName;
    }

    public String getAbbreviation() {
        return Abbreviation;
    }

    public String getDescription() {
        return Description;
    }

    public String getLogoURL() {
        return LogoURL;
    }

    public String getTopRole() {
        return TopRole;
    }

    public int getTopUserID() {
        return TopUserID;
    }

    public String getTopLoginname() {
        return TopLoginname;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public String getHomePageURL() {
        return (HomePageURL == null)? "" : HomePageURL;
    }

    public int getNumberOfMembers() {
        return NumberOfMembers;
    }

    public ArrayList<Language> getLanguages() {
        return Languages;
    }

    public String getMessage() {
        return (Message == null)? "" : Message;
    }

    public String getRules() {
        return (Rules == null)? "" : Rules;
    }

    public int getRoleId() {
        return RoleId;
    }

}
