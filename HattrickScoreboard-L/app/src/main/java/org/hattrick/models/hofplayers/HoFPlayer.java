package org.hattrick.models.hofplayers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(name = "Player")
public class HoFPlayer {

    @Element
    int PlayerId;

    @Element
    String FirstName;


    @Element(required = false)
    String NickName;


    @Element
    String LastName;


    @Element
    int Age;

    @Element
    String NextBirthday;

    @Element
    int CountryID;

    @Element
    String ArrivalDate;

    @Element
    int ExpertType;

    @Element
    String HofDate;

    @Element
    int HofAge;

    public int getPlayerId() {
        return PlayerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getNickName() {
        return NickName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getAge() {
        return Age;
    }

    public String getNextBirthday() {
        return NextBirthday;
    }

    public int getCountryID() {
        return CountryID;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public int getExpertType() {
        return ExpertType;
    }

    public String getHofDate() {
        return HofDate;
    }

    public int getHofAge() {
        return HofAge;
    }
}
