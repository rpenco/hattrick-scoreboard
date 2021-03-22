package org.hattrick.models.live;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "HattrickData", strict = false)
public class Live {

    @Element
    private String FetchedDate;

    @ElementList(required = false)
    private List<LiveMatch> MatchList;

    public String getFetchedDate() {
        return FetchedDate;
    }

    public List<LiveMatch> getMatchList() {
        return MatchList;
    }

}
