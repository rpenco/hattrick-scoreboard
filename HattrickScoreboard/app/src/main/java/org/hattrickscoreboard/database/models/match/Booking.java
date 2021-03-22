package org.hattrickscoreboard.database.models.match;

/**
 * @author Khips
 * @since 6 aot 2014
 */
public class Booking {

    //Specifies whether it was a warning (BookingType=1) or red card (BookingType=2).
    public static int TYPE_WARNING = 1;
    public static int TYPE_REDCARD = 2;

    long _id;
    int MatchID;
    String SourceSystem;
    int PlayerID;
    String PlayerName;
    int TeamID;
    int Type;
    int Minute;

    public long getID() {
        return _id;
    }

    public void setID(long _id) {
        this._id = _id;
    }

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int matchID) {
        MatchID = matchID;
    }

    public String getSourceSystem() {
        return SourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        SourceSystem = sourceSystem;
    }

    public int getPlayerID() {
        return PlayerID;
    }

    public void setPlayerID(int playerID) {
        PlayerID = playerID;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int scorerMinute) {
        Minute = scorerMinute;
    }


}
