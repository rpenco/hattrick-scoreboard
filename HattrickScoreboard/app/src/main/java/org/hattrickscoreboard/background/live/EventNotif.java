package org.hattrickscoreboard.background.live;

import org.hattrickscoreboard.R;

public class EventNotif {

    public static int SOUND_EVENT = R.raw.app_event;
    public static int SOUND_MATCH_KICKOFF = R.raw.match_start;
    public static int SOUND_MATCH_HALFTIME = R.raw.half_time;
    public static int SOUND_MATCH_FULLTIME = R.raw.full_time;
    public static int SOUND_MATCH_GOAL = R.raw.match_goal;

    String text1;
    String text2;
    int sound;
    boolean notify;

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

}
