package org.hattrick.models.transfers;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by romain
 * on 30/10/2014.
 */
@Root(strict = false)
public class CurrentBids {

    @Element
    int TeamId;

    @ElementList(required = false)
    ArrayList<BidItem> BidItems;

    public int getTeamId() {
        return TeamId;
    }

    public ArrayList<BidItem> getBidItems() {
        return BidItems;
    }
}
