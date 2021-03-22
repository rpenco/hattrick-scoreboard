package org.hattrickscoreboard.application.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;

import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Khips
 * @since 19 march 2014
 */
public class Preferences {

    final static String PREFERENCESNAME = (Preferences.class).getSimpleName();

    private SharedPreferences preferences;
    private Editor editor;

    public Preferences(Context context) {
        preferences = context.getSharedPreferences(PREFERENCESNAME,
                Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.commit();
    }

    public void clearAll() {
        editor.clear().commit();
    }

    // ////////////////////////////////
    // LANGUAGE

    public String getSelectedLocale(Context ctx) {
        Locale current = ctx.getResources().getConfiguration().locale;
        return preferences.getString("locale", current.getLanguage() + "_"
                + current.getCountry());
    }

    public void setSelectedLocale(String locale) {
        editor.putString("locale", locale).commit();
    }

    // ////////////////////////////////
    // TIMEZONE

    public String getSelectedTimeZone(Context ctx) {
        String timezoneID = TimeZone.getDefault().getID();
        return preferences.getString("timezone", timezoneID);
    }

    public void setSelectedTimeZone(String timezone) {
        editor.putString("timezone", timezone).commit();
    }

    // ////////////////////////////////
    // FIRST LAUNCH

    public boolean isFirstLaunch() {
        return preferences.getBoolean("firstLaunch", true);
    }

    public void setFirstLaunch(boolean first) {
        editor.putBoolean("firstLaunch", first).commit();
    }

    // ////////////////////////////////
    // THEME COLOR

    public int getRGBColor() {
        int rgb = preferences.getInt("color", Color.parseColor("#46824c"));
        return rgb;
    }

    public void setRGBColor(int color) {
        editor.putInt("color", color).commit();
    }

    public void setRGBColor(int r, int g, int b) {
        editor.putInt("color", Color.rgb(r, g, b)).commit();
    }

    // ////////////////////////////////
    // USER ID

    public int getUserID() {
        return preferences.getInt("userID", 0);
    }

    public void setUserID(int userID) {
        editor.putInt("userID", userID).commit();
    }

    // ////////////////////////////////
    // TEAM

    public int getSelectedTeamID() {
        return preferences.getInt("selectedTeam", 0);
    }

    public void setSelectedTeamID(int selectedTeamID) {
        editor.putInt("selectedTeam", selectedTeamID).commit();
    }

    // ////////////////////////////////
    // WORLDS

    public int getSelectedWorldID() {
        return preferences.getInt("selectedWorld", 0);
    }

    public void setSelectedWorldID(int selectedTeamID) {
        editor.putInt("selectedWorld", selectedTeamID).commit();
    }

    // ////////////////////////////////
    // NUMBERS

    public String getNumberFormat() {
        return preferences.getString("numberFormat", "# ###,##");
    }

    public void setNumberFormat(String format) {
        editor.putString("numberFormat", "# ###,##").commit();
    }

    // ////////////////////////////////
    // NOTIFICATIONS

    public boolean isEconomicalNotification() {
        return preferences.getBoolean("economicalNotif", true);
    }

    public void setEconomicalNotification(boolean isChecked) {
        editor.putBoolean("economicalNotif", isChecked).commit();
    }

    public boolean isTrainingNotification() {
        return preferences.getBoolean("trainingNotif", true);
    }

    public void setTrainingNotification(boolean isChecked) {
        editor.putBoolean("trainingNotif", isChecked).commit();
    }

    // MY TEAMS
    public boolean isReminder1HNotification() {
        return preferences.getBoolean("reminder1HNotif", true);
    }

    public void setReminder1HNotification(boolean isChecked) {
        editor.putBoolean("reminder1HNotif", isChecked).commit();
    }

    public boolean isReminder15MNotification() {
        return preferences.getBoolean("reminder15MNotif", true);
    }

    public void setReminder15MNotification(boolean isChecked) {
        editor.putBoolean("reminder15MNotif", isChecked).commit();
    }

    public boolean isKickOffNotification() {
        return preferences.getBoolean("kickoffNotif", true);
    }

    public void setKickOffNotification(boolean isChecked) {
        editor.putBoolean("kickoffNotif", isChecked).commit();
    }

    public boolean isHalfTimeNotification() {
        return preferences.getBoolean("halftimeNotif", true);
    }

    public void setHalfTimeNotification(boolean isChecked) {
        editor.putBoolean("halftimeNotif", isChecked).commit();
    }

    public boolean isGoalNotification() {
        return preferences.getBoolean("goalNotif", true);
    }

    public void setGoalNotification(boolean isChecked) {
        editor.putBoolean("goalNotif", isChecked).commit();
    }

    public boolean isWarningNotification() {
        return preferences.getBoolean("warningNotif", true);
    }

    public void setWarningNotification(boolean isChecked) {
        editor.putBoolean("warningNotif", isChecked).commit();
    }

    public boolean isWarningOppNotification() {
        return preferences.getBoolean("warningOppNotif", true);
    }

    public void setWarningOppNotification(boolean isChecked) {
        editor.putBoolean("warningOppNotif", isChecked).commit();
    }

    public boolean isInjuriesNotification() {
        return preferences.getBoolean("injuriesNotif", true);
    }

    public void setInjuriesNotification(boolean isChecked) {
        editor.putBoolean("injuriesNotif", isChecked).commit();
    }

    public boolean isInjuriesOppNotification() {
        return preferences.getBoolean("injuriesOppNotif", true);
    }

    public void setInjuriesOppNotification(boolean isChecked) {
        editor.putBoolean("injuriesOppNotif", isChecked).commit();
    }

    // NATIONALES

    public boolean isReminder1HNationalNotification() {
        return preferences.getBoolean("reminder1HNationalNotif", true);
    }

    public void setReminder1HNationalNotification(boolean isChecked) {
        editor.putBoolean("reminder1HNationalNotif", isChecked).commit();
    }

    public boolean isReminder15MNationalNotification() {
        return preferences.getBoolean("reminder15MNationalNotif", true);
    }

    public void setReminder15MNationalNotification(boolean isChecked) {
        editor.putBoolean("reminder15MNationalNotif", isChecked).commit();
    }

    public boolean isKickOffNationalNotification() {
        return preferences.getBoolean("kickoffNationalNotif", true);
    }

    public void setKickOffNationalNotification(boolean isChecked) {
        editor.putBoolean("kickoffNationalNotif", isChecked).commit();
    }

    public boolean isHalfTimeNationalNotification() {
        return preferences.getBoolean("halftimeNationalNotif", true);
    }

    public void setHalfTimeNationalNotification(boolean isChecked) {
        editor.putBoolean("halftimeNationalNotif", isChecked).commit();
    }

    public boolean isGoalNationalNotification() {
        return preferences.getBoolean("goalNationalNotif", true);
    }

    public void setGoalNationalNotification(boolean isChecked) {
        editor.putBoolean("goalNationalNotif", isChecked).commit();
    }

    public boolean isWarningNationalNotification() {
        return preferences.getBoolean("warningNationalNotif", true);
    }

    public void setWarningNationalNotification(boolean isChecked) {
        editor.putBoolean("warningNationalNotif", isChecked).commit();
    }

    public boolean isWarningOppNationalNotification() {
        return preferences.getBoolean("warningOppNationalNotif", true);
    }

    public void setWarningOppNationalNotification(boolean isChecked) {
        editor.putBoolean("warningOppNationalNotif", isChecked).commit();
    }

    public boolean isInjuriesNationalNotification() {
        return preferences.getBoolean("injuriesNationalNotif", true);
    }

    public void setInjuriesNationalNotification(boolean isChecked) {
        editor.putBoolean("injuriesNationalNotif", isChecked).commit();
    }

    public boolean isInjuriesOppNationalNotification() {
        return preferences.getBoolean("injuriesOppNationalNotif", true);
    }

    public void setInjuriesOppNationalNotification(boolean isChecked) {
        editor.putBoolean("injuriesOppNationalNotif", isChecked).commit();
    }

    // OTHERS TEAMS

    public boolean isReminder1HFollowedNotification() {
        return preferences.getBoolean("reminder1HFollowedNotif", true);
    }

    public void setReminder1HFollowedNotification(boolean isChecked) {
        editor.putBoolean("reminder1HFollowedNotif", isChecked).commit();
    }

    public boolean isReminder15MFollowedNotification() {
        return preferences.getBoolean("reminder15MFollowedNotif", true);
    }

    public void setReminder15MFollowedNotification(boolean isChecked) {
        editor.putBoolean("reminder15MFollowedNotif", isChecked).commit();
    }

    public boolean isKickOffFollowedNotification() {
        return preferences.getBoolean("kickoffFollowedNotif", true);
    }

    public void setKickOffFollowedNotification(boolean isChecked) {
        editor.putBoolean("kickoffFollowedNotif", isChecked).commit();
    }

    public boolean isHalfTimeFollowedNotification() {
        return preferences.getBoolean("halftimeFollowedNotif", true);
    }

    public void setHalfTimeFollowedNotification(boolean isChecked) {
        editor.putBoolean("halftimeFollowedNotif", isChecked).commit();
    }

    public boolean isGoalFollowedNotification() {
        return preferences.getBoolean("goalFollowedNotif", true);
    }

    public void setGoalFollowedNotification(boolean isChecked) {
        editor.putBoolean("goalFollowedNotif", isChecked).commit();
    }

    public boolean isWarningFollowedNotification() {
        return preferences.getBoolean("warningFollowedNotif", true);
    }

    public void setWarningFollowedNotification(boolean isChecked) {
        editor.putBoolean("warningFollowedNotif", isChecked).commit();
    }

    public boolean isWarningOppFollowedNotification() {
        return preferences.getBoolean("warningOppFollowedNotif", true);
    }

    public void setWarningOppFollowedNotification(boolean isChecked) {
        editor.putBoolean("warningOppFollowedNotif", isChecked).commit();
    }

    public boolean isInjuriesFollowedNotification() {
        return preferences.getBoolean("injuriesFollowedNotif", true);
    }

    public void setInjuriesFollowedNotification(boolean isChecked) {
        editor.putBoolean("injuriesFollowedNotif", isChecked).commit();
    }

    public boolean isInjuriesOppFollowedNotification() {
        return preferences.getBoolean("injuriesOppFollowedNotif", true);
    }

    public void setInjuriesOppFollowedNotification(boolean isChecked) {
        editor.putBoolean("injuriesOppFollowedNotif", isChecked).commit();
    }

}
