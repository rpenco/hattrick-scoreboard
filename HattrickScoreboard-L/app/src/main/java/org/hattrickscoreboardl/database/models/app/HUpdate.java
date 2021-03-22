package org.hattrickscoreboardl.database.models.app;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 27/11/2014.
 */
public class HUpdate extends HModel {

    public HUpdate() {
    }

    String ProcessName;

    String FetchedDate;

    public String getProcessName() {
        return ProcessName;
    }

    public void setProcessName(String processName) {
        ProcessName = processName;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }
}
