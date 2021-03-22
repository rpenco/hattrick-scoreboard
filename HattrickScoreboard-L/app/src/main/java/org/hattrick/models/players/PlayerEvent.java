package org.hattrick.models.players;

import org.simpleframework.xml.Element;

/**
 * Created by romain
 * on 01/11/2014.
 */
public class PlayerEvent {

    @Element
    String EventDate;

    @Element
    int PlayerEventTypeID;

    @Element
    String EventText;

    public String getEventDate() {
        return EventDate;
    }

    public int getPlayerEventTypeID() {
        return PlayerEventTypeID;
    }

    public String getEventText() {
        return EventText;
    }
}
