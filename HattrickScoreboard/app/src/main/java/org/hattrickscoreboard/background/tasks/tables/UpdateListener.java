package org.hattrickscoreboard.background.tasks.tables;

public interface UpdateListener {

    void onUpdateStart(String serviceFrom);

    void onUpdateCanceled(String serviceFrom);

    void onUpdateSuccess(String serviceFrom);
}
