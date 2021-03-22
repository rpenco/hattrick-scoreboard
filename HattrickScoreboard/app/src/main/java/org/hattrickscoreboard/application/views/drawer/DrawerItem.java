package org.hattrickscoreboard.application.views.drawer;

/**
 * Item
 *
 * @author Khips
 * @since 4 august 2014
 */
public class DrawerItem extends Drawer {

    public int icon;

    public DrawerItem(int tag, String title, int icon) {
        this.tag = tag;
        this.title = title;
        this.icon = icon;
    }

    public DrawerItem(int tag, String title, int icon, boolean changeTitle) {
        this.tag = tag;
        this.title = title;
        this.icon = icon;
        this.changeTitle = changeTitle;
    }
}