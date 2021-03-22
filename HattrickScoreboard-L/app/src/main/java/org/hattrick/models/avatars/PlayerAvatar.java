package org.hattrick.models.avatars;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Player", strict = false)
public class PlayerAvatar {

    @Element
    private String PlayerID;

    @Element
    private Avatar Avatar;

    public String getPlayerID() {
        return PlayerID;
    }

    public Avatar getAvatar() {
        return Avatar;
    }


}
