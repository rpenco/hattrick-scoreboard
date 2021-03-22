package org.hattrick.models.teams;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class User {

    @Element
    int UserID;

    @Element
    @Path("Language")
    int LanguageID;

    @Element
    @Path("Language")
    String LanguageName;

    @Element(required = false)
    String SupporterTier;

    @Element(required = false)
    String Loginname;

    @Element(required = false)
    String Name;

    @Element(required = false)
    String ICQ;

    @Element(required = false)
    String SignupDate;

    @Element(required = false)
    String ActivationDate;

    @Element(required = false)
    String LastLoginDate;

    public int getUserID() {
        return UserID;
    }

    public int getLanguageID() {
        return LanguageID;
    }

    public String getLanguageName() {
        return LanguageName;
    }

    public String getSupporterTier() {
        return SupporterTier;
    }

    public String getLoginname() {
        return Loginname;
    }

    public String getName() {
        return Name;
    }

    public String getICQ() {
        return ICQ;
    }

    public String getSignupDate() {
        return SignupDate;
    }

    public String getActivationDate() {
       return ActivationDate;
    }

    public String getLastLoginDate() {
        return LastLoginDate;
    }

    // TODO National Team Coach

}
