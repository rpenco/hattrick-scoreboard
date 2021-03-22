package org.hattrick.models.youth;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class YouthPlayer {

    @Element
    int YouthPlayerID;

    @Element
    String FirstName;

    @Element(required = false)
    String NickName;

    @Element
    String LastName;

    public int getYouthPlayerID() {
        return YouthPlayerID;
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
}
