package org.hattrickscoreboardl.ui.views.chpp;


public interface CHPPAuthorizationListener {

    void onError();

    void onAuthenticationError();

    void onAuthenticationSuccess();
}
