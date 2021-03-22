package org.hattrickscoreboardl.ui.drawer.componants;

/**
 * Created by romain on 26/10/2014.
 */
public class DrawerTitle extends Drawer {

    private String title;

    public DrawerTitle(String title) {
        this.id = -1;
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

}
