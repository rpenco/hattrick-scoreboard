package org.hattrickscoreboardl.database.models.teams;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class HUser extends HModel {


    public HUser(){}

    int UserID;

    int LanguageID;

    String SupporterTier;

    String Loginname;

    String Name;

    String ICQ;

    String SignupDate;

    String ActivationDate;

    String LastLoginDate;

    String FetchedDate;

    public int getUserID() {
        return UserID;
    }

    public int getLanguageID() {
        return LanguageID;
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

    public String getFetchedDate() {
        return FetchedDate;
    }


    public void setUserID(int userID) {
        UserID = userID;
    }

    public void setLanguageID(int languageID) {
        LanguageID = languageID;
    }

    public void setSupporterTier(String supporterTier) {
        SupporterTier = supporterTier;
    }

    public void setLoginname(String loginname) {
        Loginname = loginname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setICQ(String ICQ) {
        this.ICQ = ICQ;
    }

    public void setSignupDate(String signupDate) {
        SignupDate = signupDate;
    }

    public void setActivationDate(String activationDate) {
        ActivationDate = activationDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        LastLoginDate = lastLoginDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }


    //Facilities
    public boolean isSupporterTier() {
        return (!"none".equals(SupporterTier));
    }
}

