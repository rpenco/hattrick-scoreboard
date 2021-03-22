package org.hattrickscoreboard.application.views.drawer;

/**
 * Element of navigation drawer
 *
 * @author Khips
 * @since 4 august 2014
 */
public class Drawer {

    // ID reference to fragment..
    public int tag;

    // Main text fragment
    public String title;

    // Object?
    public Object object;

    // ?
    public boolean changeTitle = true;

    public Drawer() {

    }

    public Drawer(int tag, String title, Object object) {
        this.object = object;
        this.title = title;
        this.tag = tag;
    }

}
