package org.hattrickscoreboardl;

import android.content.Context;

import com.orm.SugarApp;

import org.hattrick.chpp.CHPPToken;
import org.hattrick.constants.Hattrick;
import org.hattrickscoreboardl.services.loaders.Loader;
import org.hattrickscoreboardl.utils.Storage;

/**
 * @author Khips
 * @since 4 aot 2014
 */
public class HattrickApplication extends SugarApp {

    private static HattrickApplication singleton;

    //For manager loading
    private Loader loader = new Loader();

    private int selectedNationalTeamID = 3006;
    private int selectedNationalU20TeamID = 3197;

    public HattrickApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public Loader getLoader(){
        return loader;
    }

    // ///////////////////////////////
    // CHPP

    public boolean hasCHPPAuthorization(Context ctx) {
        try {
            String tok = Storage.internalReadFileString(ctx,
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
        /*
        CHPPToken token = new CHPPToken();
        token.setToken(Hattrick.TOKEN_TOKEN);
        token.setSecret(Hattrick.TOKEN_SECRET);
        return token;*/
        try {
            String tok = Storage.internalReadFileString(ctx,Hattrick.TOKEN_FILE);
            CHPPToken token = new CHPPToken();
            token.fromSave(tok);

            if(token.getSecret() != null && token.getToken() != null)
                return token;
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public int getSelectedNationalTeamID() {
        return selectedNationalTeamID;
    }

    public int getSelectedNationalU20TeamID() {
        return selectedNationalU20TeamID;
    }
}
