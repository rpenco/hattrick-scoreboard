package org.hattrickscoreboardl.utils;

import android.test.AndroidTestCase;
import android.util.Log;

import org.hattrick.chpp.CHPPToken;
import org.hattrick.models.arenas.ArenaDetails;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.HattrickRequest;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;

import java.io.IOException;

/**
 * Main class for testing download file from
 * Hattrick
 * Created by romain on 28/10/2014.
 */
public class HattrickFinderTest extends AndroidTestCase {

    private CHPPToken token;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        token = new CHPPToken();
        token.setSecret(Hattrick.TOKEN_SECRET);
        token.setToken(Hattrick.TOKEN_TOKEN);
    }



    public void CHPPFinder() {

        //Create Hattrick Connexion
        IRequest hconnection = new HattrickRequest(getContext(),token);

        int i = 0;
        int max = 1000;
        while (i < max){

            int arenaID = 137327 + i;

            //Create URI parameter
            IParam hparam = new HattrickParam(ArenaDetails.class, arenaID);


            //Get resource
            try {

                //Get resource
                ArenaDetails result = (ArenaDetails) hconnection.get(hparam);
                if(result.getExpandedCapacity().getTotal() != 0){
                    Log.e("ARENA", "ID: "+result.getArenaID() +", BUILDING!! ");
                    i = max;
                }else
                {
                    Log.e("ARENA", "ID: "+result.getArenaID() +", Capacity: "+result.getCurrentCapacity().getTotal() +" places.");
                }

            } catch (IOException e) {
                AndroidTestCase.fail("Connexion error");
            }

            i++;
        }

    }
}
