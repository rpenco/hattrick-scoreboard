package org.hattrick.models.match;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Injury {

    @Attribute
    private int Index;

    private int id;

    @Element
    private String InjuryPlayerID;

    @Element
    private String InjuryPlayerName;

    @Element
    private String InjuryTeamID;

    @Element
    private String InjuryType;

    @Element
    private String InjuryMinute;

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public String getPlayerID() {
        return InjuryPlayerID;
    }

    public void setInjuryPlayerID(String injuryPlayerID) {
        InjuryPlayerID = injuryPlayerID;
    }

    public String getPlayerName() {
        return InjuryPlayerName;
    }

    public void setInjuryPlayerName(String injuryPlayerName) {
        InjuryPlayerName = injuryPlayerName;
    }

    public String getTeamID() {
        return InjuryTeamID;
    }

    public void setInjuryTeamID(String injuryTeamID) {
        InjuryTeamID = injuryTeamID;
    }

    public String getType() {
        return InjuryType;
    }

    public void setInjuryType(String injuryType) {
        InjuryType = injuryType;
    }

    public String getMinute() {
        return InjuryMinute;
    }

    public void setInjuryMinute(String injuryMinute) {
        InjuryMinute = injuryMinute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
