package org.hattrick.models.world;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Region {

    @Element
    int RegionID;

    @Element
    String RegionName;

    public int getRegionID() {
        return RegionID;
    }

    public String getRegionName() {
        return RegionName;
    }


}
