package org.hattrickscoreboardl.database.models.app;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 27/11/2014.
 */
public class HNotification extends HModel {

    public HNotification() {
    }

    //TYPE = {LIVE / TRAINING / ECONOMY / TRANSFER / ...}
    int type;

    //Code de la notification (pour modifier/supprimer la notif)
    int code;

    // teamID, matchID / ...
    int param1;

    // sourcesystem / ...
    String parm2;

    public int getType() {
        return type;
    }

    public int getCode() {
        return code;
    }

    public int getParam1() {
        return param1;
    }

    public String getParm2() {
        return parm2;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public void setParm2(String parm2) {
        this.parm2 = parm2;
    }
}
