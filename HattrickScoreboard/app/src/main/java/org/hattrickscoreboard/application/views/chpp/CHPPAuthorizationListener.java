package org.hattrickscoreboard.application.views.chpp;


public interface CHPPAuthorizationListener {

    void onError();

    void onAuthenticationError();

    void onAuthenticationSuccess();
}
