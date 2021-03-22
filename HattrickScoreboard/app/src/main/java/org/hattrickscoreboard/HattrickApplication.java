package org.hattrickscoreboard;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import org.hattrick.chpp.CHPPToken;
import org.hattrick.constants.Hattrick;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.views.drawer.Drawer;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DWorld;
import org.khips.tools.storage.IStorage;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 4 aot 2014
 */
public class HattrickApplication extends Application {

    private static HattrickApplication singleton;

    private HattrickBDD bdd;
    private ArrayList<Drawer> mDrawerItems;
    private ArrayList<DTeam> mTeams;
    private DWorld mWorld;

    private int nbStartProgressBar = 0;

    public HattrickApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    // ///////////////////////////////
    // PROGRESS BAR

    public int progressAddOne() {
        nbStartProgressBar += 1;
        return nbStartProgressBar;
    }

    public int progressRemoveOne() {
        nbStartProgressBar -= 1;
        return nbStartProgressBar;
    }

    // ///////////////////////////////
    // DATABASE

    public HattrickBDD getBDD(Context ctx) {
        if (bdd == null)
            bdd = new HattrickBDD(ctx);
        return bdd;
    }

    // ///////////////////////////////
    // CHPP

    public boolean hasCHPPAuthorization(Context ctx) {
        try {
            String tok = IStorage.internalReadFileString(ctx,
                    Hattrick.TOKEN_FILE);
            CHPPToken token = new CHPPToken();
            token.fromSave(tok);

            if (token.getSecret() == null || token.getToken() == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CHPPToken getCHPPToken(Context ctx) {
        try {
            String tok = IStorage.internalReadFileString(ctx,
                    Hattrick.TOKEN_FILE);
            CHPPToken token = new CHPPToken();
            token.fromSave(tok);
            return token;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    // ///////////////////////////////
    // NAVIGATION DRAWER

    public ArrayList<Drawer> getDrawerItems() {
        return mDrawerItems;
    }

    public void setDrawerItems(ArrayList<Drawer> mDrawerItems) {
        this.mDrawerItems = mDrawerItems;
    }

    // ///////////////////////////////
    // SELECTED TEAM

    public int getSelectedTeamID() {
        Preferences pref = new Preferences(this);
        return pref.getSelectedTeamID();
    }

    public void setSelectedTeamID(int teamID) {
        Preferences pref = new Preferences(this);
        pref.setSelectedTeamID(teamID);
    }

    public DTeam getSelectedTeam() {
        int selected = getSelectedTeamID();
        if (mTeams != null && selected != 0) {
            for (DTeam team : mTeams) {
                if (team.getTeamID() == selected) {
                    return team;
                }
            }
        }
        return null;
    }

    // ///////////////////////////////
    // MY TEAMS

    public ArrayList<DTeam> getMyTeams() {
        return mTeams;
    }

    public void setMyTeams(ArrayList<DTeam> mTeams) {
        this.mTeams = mTeams;
    }

    // ///////////////////////////////
    // USER ID

    public int getMyUserID() {
        Preferences pref = new Preferences(this);
        return pref.getUserID();
    }

    public void setMyUserID(int userID) {
        Preferences pref = new Preferences(this);
        pref.setUserID(userID);
    }

    // ///////////////////////////////
    // WORLD

    public DWorld getMyWorld() {
        return mWorld;
    }

    public void setMyWorld(DWorld world) {
        this.mWorld = world;
    }

}
