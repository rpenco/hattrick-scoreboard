package org.hattrickscoreboard.application.drawer;

import android.app.Activity;

import org.hattrickscoreboard.application.views.drawer.Drawer;
import org.hattrickscoreboard.application.views.drawer.DrawerHeader;
import org.hattrickscoreboard.application.views.drawer.DrawerItem;
import org.hattrickscoreboard.application.views.drawer.DrawerTeam;
import org.hattrickscoreboard.database.models.DTeam;

import java.util.ArrayList;

/**
 * Create items for navigation drawer
 *
 * @author Khips
 */
public class NavigationDrawerElements {

    ArrayList<Drawer> mItems = new ArrayList<Drawer>();
    private DTeam team;
    private Activity ctx;

    public NavigationDrawerElements(Activity activity) {
        this.ctx = activity;
    }

    /**
     * Initialize drawer
     *
     * @param team
     */
    public void setUp(DTeam team) {
        this.team = team;
        mItems = new ArrayList<Drawer>();
    }

    /**
     * Add item with team information. Use setUp(Dteam team) before.
     */
    public void addTeamSelectionItem(int tag) {

        if (mItems != null && team != null)
            mItems.add(new DrawerTeam(tag, team.getTeamName(), team
                    .getLeagueName()
                    + ", "
                    + team.getRegionName()
                    + ", "
                    + team.getLeagueLevelUnitName(), team.getTeamID()));
    }

    /**
     * Add separator
     *
     * @param resString title
     */
    public void addHeader(int resString) {
        if (mItems != null)
            mItems.add(new DrawerHeader(ctx.getString(resString)));
    }

    /**
     * Add default item
     *
     * @param tag       id
     * @param resString name
     * @param resIcon   icon
     */
    public void addItem(int tag, int resString, int resIcon) {
        if (mItems != null)
            mItems.add(new DrawerItem(tag, ctx.getString(resString), resIcon));
    }

    public ArrayList<Drawer> getDrawer() {
        return mItems;
    }
}
