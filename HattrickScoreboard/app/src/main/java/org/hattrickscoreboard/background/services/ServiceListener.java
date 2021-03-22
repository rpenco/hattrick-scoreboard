package org.hattrickscoreboard.background.services;

public interface ServiceListener {

    void onServiceStart();

    void onServiceError(int code);

    void onServiceUpdated();
}
