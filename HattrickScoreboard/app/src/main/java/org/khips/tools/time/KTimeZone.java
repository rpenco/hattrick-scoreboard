package org.khips.tools.time;

import java.util.ArrayList;
import java.util.TimeZone;

public class KTimeZone {

    public static String[] timezoneNames() {
        ArrayList<String> result = new ArrayList<String>();
        String[] ids = TimeZone.getAvailableIDs();

        for (int i = 0; i < ids.length; i++) {

            TimeZone d = TimeZone.getTimeZone(ids[i]);

            if (!ids[i].matches(".*/.*")) {
                continue;
            }

            String region = ids[i];//.replaceAll(".*/", "").replaceAll("_", " ");
            int hours = Math.abs(d.getRawOffset()) / 3600000;
            int minutes = Math.abs(d.getRawOffset() / 60000) % 60;
            String sign = d.getRawOffset() >= 0 ? "+" : "-";

            String timeZonePretty = String.format("(UTC %s%02d:%02d) %s",
                    sign, hours, minutes, region);
            result.add(timeZonePretty);
        }

        String[] res = new String[result.size()];
        res = result.toArray(res);
        return res;
    }
}
