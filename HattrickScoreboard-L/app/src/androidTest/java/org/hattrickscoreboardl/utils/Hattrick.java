package org.hattrickscoreboardl.utils;

import android.app.Instrumentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by romain on 30/10/2014.
 */
public class Hattrick {

    public static String TOKEN_TOKEN = "fOZ4DjLTw6u3ZZIZ";
    public static String TOKEN_SECRET = "g9qDBDPJd2FgeYNn";
    public static String USER_LOGIN = "khips";
    public static String USER_PASSWORD = "Hattrick-06";
    public static String OVERRIDE_SUPPORTER = "&overrideIsSupporter=";
    public static String OVERRIDE_SILVER = "0";
    public static String OVERRIDE_GOLD = "1";
    public static String OVERRIDE_PLATINUM = "2";
    public static String OVERRIDE_DIAMOND = "3";



    public static String loadFixtureXML(Instrumentation instrumentation, String path, String packagename, String name){

        try {
            InputStream stream = instrumentation.getContext().getResources().getAssets().open(path + packagename+"/"+ name + ".xml");
            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(stream));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
