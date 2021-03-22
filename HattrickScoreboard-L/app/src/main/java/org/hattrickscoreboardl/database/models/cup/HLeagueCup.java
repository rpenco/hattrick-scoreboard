package org.hattrickscoreboardl.database.models.cup;

import org.hattrickscoreboardl.database.models.HModel;

/**
 * Created by romain
 * on 26/11/2014.
 */
public class HLeagueCup extends HModel {

    int CupID;

    int CupSeason;

    int CupRound;

    String CupName;

    String FetchedDate;

    public int getCupID() {
        return CupID;
    }

    public void setCupID(int cupID) {
        CupID = cupID;
    }

    public int getCupSeason() {
        return CupSeason;
    }

    public void setCupSeason(int cupSeason) {
        CupSeason = cupSeason;
    }

    public int getCupRound() {
        return CupRound;
    }

    public void setCupRound(int cupRound) {
        CupRound = cupRound;
    }

    public String getCupName() {
        return CupName;
    }

    public void setCupName(String cupName) {
        CupName = cupName;
    }

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        FetchedDate = fetchedDate;
    }
}
