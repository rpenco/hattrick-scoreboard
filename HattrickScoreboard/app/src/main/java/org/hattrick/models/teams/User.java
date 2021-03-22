package org.hattrick.models.teams;

import android.annotation.SuppressLint;

import org.hattrick.constants.Hattrick;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    @SuppressLint("SimpleDateFormat")
    public Date getSignupDate() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    Hattrick.DATETIME);
            ParsePosition pos = new ParsePosition(0);
            return formatter.parse(SignupDate, pos);
        } catch (RuntimeException e) {
            // e.printStackTrace();
        }
        return new Date();
    }

    @SuppressLint("SimpleDateFormat")
    public Date getActivationDate() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    Hattrick.DATETIME);
            ParsePosition pos = new ParsePosition(0);
            return formatter.parse(ActivationDate, pos);
        } catch (RuntimeException e) {
            // e.printStackTrace();
        }
        return new Date();

    }

    @SuppressLint("SimpleDateFormat")
    public Date getLastLoginDate() {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(
                    Hattrick.DATETIME);
            ParsePosition pos = new ParsePosition(0);
            return formatter.parse(LastLoginDate, pos);
        } catch (RuntimeException e) {
            // e.printStackTrace();
        }
        return new Date();
    }

    // TODO National Team Coach

}
