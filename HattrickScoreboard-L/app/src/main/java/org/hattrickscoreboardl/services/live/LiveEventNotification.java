package org.hattrickscoreboardl.services.live;

import android.content.Context;
import android.util.Log;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.live.HLive;
import org.hattrickscoreboardl.database.models.live.HLiveEvent;
import org.hattrickscoreboardl.database.models.nationals.HNationalTeam;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.SplashscreenActivity;
import org.hattrickscoreboardl.utils.HattrickEventIcon;
import org.hattrickscoreboardl.utils.Notification;
import org.hattrickscoreboardl.utils.Preferences;

import java.util.ArrayList;
import java.util.List;

public class LiveEventNotification {

    static final String TAG = (LiveEventNotification.class).getSimpleName();

    Context ctx;
    Notification notif;
    HLive live;
    Preferences pref;
    List<HTeam> myTeams;
    List<HNationalTeam> myNationalTeams;
    boolean needNotification;

    public LiveEventNotification(Context context, HLive live){
        this.ctx = context;
        this.notif = new Notification(ctx);
        this.live = live;
        this.pref = new Preferences(ctx);

        //Get my teams
        myTeams = HTeam.find(HTeam.class, "USER_ID = ?", String.valueOf(pref.get(Preferences.USER_ID, 0)));
        myNationalTeams = HNationalTeam.find(HNationalTeam.class, "LEAGUE_ID = ?", String.valueOf(pref.get(Preferences.NATIONAL_LEAGUE_ID, 0)));

    }

    ///////////////////////////////

    String homeAwayTeamsScores(){
        return ctx.getString(R.string.notif_teams_scores_home_away, live.getHomeTeamName(),
                live.getAwayTeamName(), live.getHomeGoals(), live.getAwayGoals());
    }

    String homeAwayTeams(){
        return ctx.getString(R.string.notif_teams_home_away, live.getHomeTeamName(),
                live.getAwayTeamName());
    }

    ///////////////////////////////


    public  void notifKickoff(){
        if(isNotificationEnableKickoff()) {
            notifCompact(ctx.getString(R.string.notif_kickoff));
        }
    }

    public void notifHaftTime() {
        if(isNotificationEnableHalftime()) {
            notifCompact(ctx.getString(R.string.notif_halftime));
        }
    }

    public  void notifFullTime(){
        if(isNotificationEnableKickoff()) {
            notifCompact(ctx.getString(R.string.notif_fulltime));
        }
    }

    public  void notifWalkover(){
        if(isNotificationEnableKickoff()) {
            notifCompact(ctx.getString(R.string.notif_walkover));
        }
    }

    public void notifReminder1hour() {
        if(isNotificationEnable1H()) {
            notifCompact(homeAwayTeams(), ctx.getString(R.string.notif_kickoff_reminder_hour));
        }
    }

    public void notifReminder30Minutes() {
        if(isNotificationEnable30M()) {
            notifCompact(homeAwayTeams(), ctx.getString(R.string.notif_kickoff_reminder_minutes, 30));
        }
    }

    ///////////////////////////////

    void notifCompact(String title, String text){
        notif.notifyCompact(SplashscreenActivity.class,title,
                text, live.getId());
    }

    void notifCompact(String text){
        notifCompact(homeAwayTeamsScores(), text);
    }

    void notifExpended(String[] texts){
        notif.notifyExpended(SplashscreenActivity.class, homeAwayTeamsScores(),
                ctx.getString(R.string.notif_expended_to_show), texts, live.getId());
    }

    public void notif(List<HLiveEvent> events){

        List<String> lines = new ArrayList<String>();
        needNotification = false;

        for(HLiveEvent event : events){

            //Get correspondant line
            String line = getText(event);
            if(line != null){
                Log.i(TAG, "matchID: " + live.getMatchID() + ", Event: " + line);
                lines.add(line);
            }

        }

        //If one line need notification > notify all lines
        if(needNotification) {
            String[] evts = new String[lines.size()];
            evts = lines.toArray(evts);

            //Set notifications
            if (evts.length > 1) {
                //Send notifications
                notifExpended(evts);

            } else if (evts.length == 1) {

                //Send notification
                notifCompact(evts[0]);
            }
        }
    }

    String getText(HLiveEvent event){

        // Get icon
        int res = HattrickEventIcon.icon(event.getEventTypeID());

        // Kickoff
        if (res == R.drawable.ic_event_31_rain
                || res == R.drawable.ic_event_32_fear
                || res == R.drawable.ic_event_33_sunny
                || res == R.drawable.ic_event_30_rain) {

            needNotification  = (needNotification == false)? isNotificationEnableKickoff() : true;
            return ctx.getString(R.string.notif_kickoff);
        }

        // Half-time
        if (res == R.drawable.ic_event_45_half) {

            needNotification  = (needNotification == false)? isNotificationEnableHalftime() : true;
            return ctx.getString(R.string.notif_halftime);
        }

        // Walkover (forfait)
        if (res == R.drawable.ic_event_501_502_walkover) {

            needNotification  = (needNotification == false)? isNotificationEnableKickoff() : true;
            return ctx.getString(R.string.notif_walkover);
        }

        // Penalty goal
        if (res == R.drawable.ic_event_55_56_57_104_114_124_134_154_164_174_184_penalty_goal) {

            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;

            //%1$s', But de %2$s (%3$s) sur pénalty.
            return ctx.getString(R.string.notif_goal_penalty, event.getMinute(), event.getSubjectPlayerName());
        }

        // SE goal
        if (res == R.drawable.ic_event_105a109_115a119_125_se_goal) {

            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;

            //%1$s', But de %2$s (%3$s) sur un exploit individuel.
            return ctx.getString(R.string.notif_goal_se, event.getMinute(), event.getSubjectPlayerName());
        }

        // Counter goal
        if (res == R.drawable.ic_event_140a143_186_counter_attack) {
            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;
            //%1$s', But de %2$s (%3$s) sur contre-attaque.
            return ctx.getString(R.string.notif_goal_counter_attack, event.getMinute(), event.getSubjectPlayerName());
        }

        // Extension
        if (res == R.drawable.ic_event_70_extension) {
            needNotification  = (needNotification == false)? isNotificationEnableHalftime() : true;
            return ctx.getString(R.string.notif_extension);
        }

        // Penalty contest
        if (res == R.drawable.ic_event_71_penalty_contest) {
            needNotification  = (needNotification == false)? isNotificationEnableHalftime() : true;
            return ctx.getString(R.string.notif_penalty_contest);
        }

        // Coin
        if (res == R.drawable.ic_event_73_coin) {
            needNotification  = (needNotification == false)? isNotificationEnableHalftime() : true;
            return ctx.getString(R.string.notif_coin);
        }

        if (res == R.drawable.ic_event_90_94_injury_playing) {
            needNotification  = (needNotification == false)? isNotificationEnableInjuries() : true;
            //%1$s', Blessure légère de %2$s (%3$s)
            return ctx.getString(R.string.notif_injury, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_91_95_injury_leave) {
            needNotification  = (needNotification == false)? isNotificationEnableInjuries() : true;
            return ctx.getString(R.string.notif_injury_leave, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_92_badly_injury_leave) {
            needNotification  = (needNotification == false)? isNotificationEnableInjuries() : true;
            return ctx.getString(R.string.notif_badly_injury_leave, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_93_96_badly_injury_no_remplace) {
            needNotification  = (needNotification == false)? isNotificationEnableInjuries() : true;
            return ctx.getString(R.string.notif_badly_injury_no_leave, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_100_110_120_130_150_160_170_180_freekick) {
            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;
            //%1$s', But de %2$s (%3$s) sur coup franc.
            return ctx.getString(R.string.notif_goal_freekick, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_101_111_121_131_151_161_171_181_goal_middle) {
            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;
            return ctx.getString(R.string.notif_goal_middle, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_102_112_122_132_152_162_172_182_goal_left) {
            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;
            return ctx.getString(R.string.notif_goal_left, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_103_113_123_133_153_163_173_183_goal_right) {
            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;
            return ctx.getString(R.string.notif_goal_right, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_185_indirect_freekick) {
            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;
            return ctx.getString(R.string.notif_goal_indirect_freekick, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_187_goal_long) {
            needNotification  = (needNotification == false)? isNotificationEnableGoals() : true;
            return ctx.getString(R.string.notif_goal_long, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_510_511_yellow) {
            needNotification  = (needNotification == false)? isNotificationEnableCards() : true;
            return ctx.getString(R.string.notif_yellow_card, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_512_513_yellow_red) {
            needNotification  = (needNotification == false)? isNotificationEnableCards() : true;
            return ctx.getString(R.string.notif_yellow_red_card, event.getMinute(), event.getSubjectPlayerName());
        }

        if (res == R.drawable.ic_event_514_red) {
            needNotification  = (needNotification == false)? isNotificationEnableCards() : true;
            return ctx.getString(R.string.notif_red_card, event.getMinute(), event.getSubjectPlayerName());
        }

        return null;
    }


    ///////////////////////////////

    boolean isMyPrimaryTeam(){

        for(HTeam team : myTeams){
            if(team.isPrimaryClub()) {
                if (team.getTeamID() == live.getHomeTeamID()
                        || team.getTeamID() == live.getAwayTeamID())
                    return true;
            }
        }
        return false;
    }

    boolean isMySecondaryTeam(){
        for(HTeam team : myTeams){
            if(!team.isPrimaryClub()) {
                if (team.getTeamID() == live.getHomeTeamID()
                        || team.getTeamID() == live.getAwayTeamID())
                    return true;
            }
        }
        return false;
    }

    boolean isMyNationalTeam(){

        for(HNationalTeam team : myNationalTeams){
            if(team.getLeagueOfficeTypeID() == 2) {
                if (team.getTeamID() == live.getHomeTeamID()
                        || team.getTeamID() == live.getAwayTeamID())
                    return true;
            }
        }
        return false;
    }

    boolean isMyNationalU20Team(){

        for(HNationalTeam team : myNationalTeams){
            if(team.getLeagueOfficeTypeID() == 4) {
                if (team.getTeamID() == live.getHomeTeamID()
                        || team.getTeamID() == live.getAwayTeamID())
                    return true;
            }
        }

        return false;
    }


    boolean isNotificationEnable1H(){
        if(isMyPrimaryTeam()){
            return pref.get(Preferences.NOTIF_1STTEAM_REMINDER_1H, true);
        }else{
            if(isMySecondaryTeam()){
                return pref.get(Preferences.NOTIF_2NDTEAM_REMINDER_1H, true);
            }else{
                if(isMyNationalTeam()){
                    return pref.get(Preferences.NOTIF_NATIONAL_REMINDER_1H, true);
                }else{
                    if(isMyNationalU20Team()){
                        return pref.get(Preferences.NOTIF_U20_REMINDER_1H, true);
                    }
                    else{
                        return pref.get(Preferences.NOTIF_OTHERTEAM_REMINDER_1H, true);
                    }
                }
            }
        }
    }

    boolean isNotificationEnable30M(){
        if(isMyPrimaryTeam()){
            return pref.get(Preferences.NOTIF_1STTEAM_REMINDER_30M, true);
        }else{
            if(isMySecondaryTeam()){
                return pref.get(Preferences.NOTIF_2NDTEAM_REMINDER_30M, true);
            }else{
                if(isMyNationalTeam()){
                    return pref.get(Preferences.NOTIF_NATIONAL_REMINDER_30M, true);
                }else{
                    if(isMyNationalU20Team()){
                        return pref.get(Preferences.NOTIF_U20_REMINDER_30M, true);
                    }
                    else{
                        return pref.get(Preferences.NOTIF_OTHERTEAM_REMINDER_30M, true);
                    }
                }
            }
        }
    }

    boolean isNotificationEnableKickoff(){
        if(isMyPrimaryTeam()){
            return pref.get(Preferences.NOTIF_1STTEAM_KICKOFF, true);
        }else{
            if(isMySecondaryTeam()){
                return pref.get(Preferences.NOTIF_2NDTEAM_KICKOFF, true);
            }else{
                if(isMyNationalTeam()){
                    return pref.get(Preferences.NOTIF_NATIONAL_KICKOFF, true);
                }else{
                    if(isMyNationalU20Team()){
                        return pref.get(Preferences.NOTIF_U20_KICKOFF, true);
                    }
                    else{
                        return pref.get(Preferences.NOTIF_OTHERTEAM_KICKOFF, true);
                    }
                }
            }
        }
    }

    boolean isNotificationEnableGoals(){
        if(isMyPrimaryTeam()){
            return pref.get(Preferences.NOTIF_1STTEAM_GOALS, true);
        }else{
            if(isMySecondaryTeam()){
                return pref.get(Preferences.NOTIF_2NDTEAM_GOALS, true);
            }else{
                if(isMyNationalTeam()){
                    return pref.get(Preferences.NOTIF_NATIONAL_GOALS, true);
                }else{
                    if(isMyNationalU20Team()){
                        return pref.get(Preferences.NOTIF_U20_GOALS, true);
                    }
                    else{
                        return pref.get(Preferences.NOTIF_OTHERTEAM_GOALS, true);
                    }
                }
            }
        }
    }

    boolean isNotificationEnableInjuries(){
        if(isMyPrimaryTeam()){
            return pref.get(Preferences.NOTIF_1STTEAM_INJURIES, true);
        }else{
            if(isMySecondaryTeam()){
                return pref.get(Preferences.NOTIF_2NDTEAM_INJURIES, true);
            }else{
                if(isMyNationalTeam()){
                    return pref.get(Preferences.NOTIF_NATIONAL_INJURIES, true);
                }else{
                    if(isMyNationalU20Team()){
                        return pref.get(Preferences.NOTIF_U20_INJURIES, true);
                    }
                    else{
                        return pref.get(Preferences.NOTIF_OTHERTEAM_INJURIES, true);
                    }
                }
            }
        }
    }

    boolean isNotificationEnableHalftime(){
        if(isMyPrimaryTeam()){
            return pref.get(Preferences.NOTIF_1STTEAM_HALFTIME, true);
        }else{
            if(isMySecondaryTeam()){
                return pref.get(Preferences.NOTIF_2NDTEAM_HALFTIME, true);
            }else{
                if(isMyNationalTeam()){
                    return pref.get(Preferences.NOTIF_NATIONAL_HALFTIME, true);
                }else{
                    if(isMyNationalU20Team()){
                        return pref.get(Preferences.NOTIF_U20_HALFTIME, true);
                    }
                    else{
                        return pref.get(Preferences.NOTIF_OTHERTEAM_HALFTIME, true);
                    }
                }
            }
        }
    }

    boolean isNotificationEnableCards(){
        if(isMyPrimaryTeam()){
            return pref.get(Preferences.NOTIF_1STTEAM_CARDS, true);
        }else{
            if(isMySecondaryTeam()){
                return pref.get(Preferences.NOTIF_2NDTEAM_CARDS, true);
            }else{
                if(isMyNationalTeam()){
                    return pref.get(Preferences.NOTIF_NATIONAL_CARDS, true);
                }else{
                    if(isMyNationalU20Team()){
                        return pref.get(Preferences.NOTIF_U20_CARDS, true);
                    }
                    else{
                        return pref.get(Preferences.NOTIF_OTHERTEAM_CARDS, true);
                    }
                }
            }
        }
    }
}
