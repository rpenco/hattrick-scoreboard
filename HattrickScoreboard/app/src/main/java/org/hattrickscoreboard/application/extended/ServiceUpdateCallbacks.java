package org.hattrickscoreboard.application.extended;

/**
 * Listener for Service update
 *
 * @author Khips
 * @since 24 april 2014
 */
public interface ServiceUpdateCallbacks {

    void onServiceStartUpdate(int code, String from);

    /**
     * Notify update
     *
     * @param code OK (-1) / FAILED
     * @param from Process who has sent broadcast e.g. 'TeamUpdate.FROM'
     */
    void onServiceUpdated(int code, String from);
}
