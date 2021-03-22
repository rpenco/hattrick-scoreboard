package org.hattrick.models.arenas;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ExpandedCapacity {

    @Element(required = false)
    String ExpansionDate;

    @Element(required = false)
    int Terraces;

    @Element(required = false)
    int Basic;

    @Element(required = false)
    int Roof;

    @Element(required = false)
    int VIP;

    @Element(required = false)
    int Total;

    public String getExpansionDate() {
        return ExpansionDate;
    }

    public int getTerraces() {
        return Terraces;
    }

    public int getBasic() {
        return Basic;
    }

    public int getRoof() {
        return Roof;
    }

    public int getVIP() {
        return VIP;
    }

    public int getTotal() {
        return Total;
    }

}
