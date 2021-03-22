package org.hattrickscoreboard.application.views.drawer;

public class DrawerTeam extends Drawer {

    public String subtitle;
    public int teamID;

    public DrawerTeam(int position, String title, String subtitle, int teamID) {
        this.tag = position;
        this.title = title;
        this.subtitle = subtitle;
        this.teamID = teamID;
    }
}