package org.hattrickscoreboard.application.views.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.hattrickscoreboard.application.extended.fragments.PlaceHolderFragment;
import org.hattrickscoreboard.application.views.arena.ArenaViewPager;
import org.hattrickscoreboard.application.views.club.ClubViewPager;
import org.hattrickscoreboard.application.views.community.CommunityViewPager;
import org.hattrickscoreboard.application.views.economies.EconomiesViewPager;
import org.hattrickscoreboard.application.views.matches.MatchesViewPager;
import org.hattrickscoreboard.application.views.notifications.NotificationViewPager;
import org.hattrickscoreboard.application.views.players.PlayersViewPager;
import org.hattrickscoreboard.application.views.series.SeriesViewPager;
import org.hattrickscoreboard.application.views.settings.SettingsViewPager;
import org.hattrickscoreboard.application.views.staff.StaffViewPager;
import org.hattrickscoreboard.application.views.training.TrainingViewPager;

/**
 * Organize navigation drawer
 *
 * @author Khips
 * @since 4 august 2014
 */
public class DrawerSelection {

    public static Fragment selection(int drawerTag, Bundle args) {

        if (drawerTag == -1)
            return null;

        // Prepare arguments

        Fragment f = null;

        // Club
        if (drawerTag == 1) {
            f = new ClubViewPager();
        }

        // Arena
        if (drawerTag == 2) {
            f = new ArenaViewPager();
        }

        // Staff
        if (drawerTag == 3) {
            f = new StaffViewPager();
        }

        // Fans

        // Transfers

        // Finances
        if (drawerTag == 6) {
            f = new EconomiesViewPager();
        }

        // Community
        if (drawerTag == 20) {
            f = new CommunityViewPager();
        }

        // SENIOR

        // Senior players
        if (drawerTag == 7) {
            f = new PlayersViewPager();
            args.putBoolean("youth", false);
        }

        // Matches
        if (drawerTag == 8) {
            f = new MatchesViewPager();
            args.putBoolean("youth", false);

        }

        // Series
        if (drawerTag == 9) {
            f = new SeriesViewPager();
            args.putBoolean("youth", false);

        }

        // Training
        if (drawerTag == 10) {
            f = new TrainingViewPager();
            args.putBoolean("youth", false);
        }

        // YOUTH

        // Youth Overview

        // Youth players

        // Youth matchs

        // Youth series

        // Youth training

        // NATIONAL

        // Senior

        // Youth

        // SETTINGS

        // Notifications
        if (drawerTag == 18) {
            f = new NotificationViewPager();

        }

        // Preferences
        if (drawerTag == 19) {
            f = new SettingsViewPager();
        }

        // Send fragment

        if (f == null) {
            return notFoundFragment(drawerTag);
        } else {
            f.setArguments(args);
            return f;
        }

    }

    private static Fragment notFoundFragment(int sectionNumber) {

        PlaceHolderFragment f = new PlaceHolderFragment();
        Bundle args = new Bundle();
        args.putInt(PlaceHolderFragment.ARG_SECTION_NUMBER, sectionNumber);
        f.setArguments(args);
        return f;
    }

    /**
     * Get right fragment in relation with left fragment (tablet only)
     *
     * @param drawerLeftTag
     * @param args
     * @return
     */
    public static Fragment selectionRight(int drawerLeftTag, Bundle args) {

        Fragment f = null;

        // Left Club, right series
        if (drawerLeftTag == 1) {
            f = new SeriesViewPager();
            args.putBoolean("youth", false);
        }

        // Left Staff, right staff stats
        if (drawerLeftTag == 3) {
            f = new StaffViewPager();
        }

        // Left Finances (current week), Right finances (last week)
        if (drawerLeftTag == 6) {
            f = new EconomiesViewPager();
        }

        // Left Matches, right HT-Live
        if (drawerLeftTag == 8) {
            f = new MatchesViewPager();
            args.putBoolean("youth", false);

        }

        // Left Series, Right fixtures
        if (drawerLeftTag == 9) {
            f = new SeriesViewPager();
            args.putBoolean("youth", false);

        }

        // Send fragment

        if (f == null) {
            return notFoundFragment(drawerLeftTag);
        } else {
            f.setArguments(args);
            return f;
        }

    }

}
