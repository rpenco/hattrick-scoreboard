package org.hattrickscoreboardl.services;

/**
 * Notify application
 */
public interface UpdateListener {

    void onUpdateStart(String from);

    void onUpdateSuccess(String from);

    void onUpdateError(String from, int code);

}
