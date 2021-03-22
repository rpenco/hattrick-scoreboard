package org.hattrickscoreboard.database.models;

/**
 * Generic object from database
 *
 * @author Khips
 * @since 11 aot 2014
 */
public class DModel {

    protected String FetchedDate;
    protected int ValidityTime;

    public String getFetchedDate() {
        return FetchedDate;
    }

    public void setFetchedDate(String fetchedDate) {
        this.FetchedDate = fetchedDate;
    }

    public int getValidityTime() {
        return ValidityTime;
    }

    public void setValidityTime(int validityTime) {
        this.ValidityTime = validityTime;
    }
}
