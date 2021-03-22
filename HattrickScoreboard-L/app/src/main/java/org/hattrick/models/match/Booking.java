package org.hattrick.models.match;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Booking {

    @Attribute
    private int Index;

    private int id;

    @Element
    private String BookingPlayerID;

    @Element
    private String BookingPlayerName;

    @Element
    private String BookingTeamID;

    @Element
    private String BookingType;

    @Element
    private String BookingMinute;

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public String getPlayerID() {
        return BookingPlayerID;
    }

    public void setBookingPlayerID(String bookingPlayerID) {
        BookingPlayerID = bookingPlayerID;
    }

    public String getPlayerName() {
        return BookingPlayerName;
    }

    public void setBookingPlayerName(String bookingPlayerName) {
        BookingPlayerName = bookingPlayerName;
    }

    public String getTeamID() {
        return BookingTeamID;
    }

    public void setBookingTeamID(String bookingTeamID) {
        BookingTeamID = bookingTeamID;
    }

    public String getType() {
        return BookingType;
    }

    public void setBookingType(String bookingType) {
        BookingType = bookingType;
    }

    public String getMinute() {
        return BookingMinute;
    }

    public void setBookingMinute(String bookingMinute) {
        BookingMinute = bookingMinute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
