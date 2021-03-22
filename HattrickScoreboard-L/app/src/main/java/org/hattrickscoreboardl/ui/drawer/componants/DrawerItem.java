package org.hattrickscoreboardl.ui.drawer.componants;

/**
 * Created by romain on 26/10/2014.
 */
public class DrawerItem extends Drawer {

    private String title;
    private int icon;

    public DrawerItem(int id, String title, int icon) {
        this.id = id;
        this.title = title;
        this.icon = icon;
    }

    public String getTitle(){
        return title;
    }

    public int getIcon(){
        return icon;
    }
}
