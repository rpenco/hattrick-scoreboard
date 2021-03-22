package org.hattrick.models.avatars;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "HattrickData", strict = false)
public class PlayersAvatar {

    @Element
    @Path("Team")
    private String TeamId;

    @ElementList
    @Path("Team")
    private List<PlayerAvatar> Players;

    public String getTeamId() {
        return TeamId;
    }

    public List<PlayerAvatar> getPlayers() {
        return Players;
    }

}
