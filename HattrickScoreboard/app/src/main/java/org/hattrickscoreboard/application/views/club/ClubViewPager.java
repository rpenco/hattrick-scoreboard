package org.hattrickscoreboard.application.views.club;

import android.app.Activity;
import android.os.Bundle;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.extended.fragments.HattrickViewPagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class ClubViewPager extends HattrickViewPagerFragment {

    static final String TAG = (ClubViewPager.class).getSimpleName();

    public ClubViewPager() {
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (getActivity().getActionBar() != null) {
            getActivity().getActionBar().setSubtitle(R.string.menu_overview);
        }
    }

    @Override
    public List<HattrickFragment> getFragments() {

        List<HattrickFragment> fList = new ArrayList<HattrickFragment>();

        // Club informations
        fList.add(new ClubFragment().newInstance(getTeamID()));
        titles.add(toUpperCase(R.string.club_title_home));

        // TrophyList Flags
        // fList.add(new TrophyFragment().newInstance(getTeamID()));
        // titles.add(toUpperCase(R.string.title_success));

        // Guestbook & Press
        // fList.add(new GuestbookFragment().newInstance(getTeamID()));
        // titles.add("Livre d'or");

        // MySupporters & SupportedTeams
        // fList.add(new SupportersFragment().newInstance(getTeamID()));
        // titles.add("Supporters");

        // Achievements
        // fList.add(new AchievementsFragment().newInstance(getTeamID()));
        // titles.add("Russites");

        // Hall of Fame Players
        // fList.add(new TempleFragment().newInstance(getTeamID()));
        // titles.add("Temple");

        return fList;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}