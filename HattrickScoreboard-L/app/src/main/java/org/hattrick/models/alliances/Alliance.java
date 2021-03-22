package org.hattrick.models.alliances;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 30/10/2014.
 */
public class Alliance {

    @Element
    int AllianceID;

    @Element
    String AllianceName;

    @Element(required = false)
    String AllianceDescription;

    public int getAllianceID() {
        return AllianceID;
    }

    public String getAllianceName() {
        return AllianceName;
    }

    public String getAllianceDescription() {
        return (AllianceDescription != null)? AllianceDescription : "";
    }
}
