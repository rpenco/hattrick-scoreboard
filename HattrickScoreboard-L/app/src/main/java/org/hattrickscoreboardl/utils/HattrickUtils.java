package org.hattrickscoreboardl.utils;

public class HattrickUtils {

    static final String TAG = (HattrickUtils.class).getSimpleName();


    public static String Truncate(String name, int maxChar) {
        int count = 0;
        String res = "";

        if(name != null){
            String[] words = name.split(" ");
            for(String word : words){
                count += word.length();
                res += " "+word;
                if(count >= maxChar){
                    return res;
                }
            }
        }

        return res;
    }


}
