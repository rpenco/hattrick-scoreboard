package org.hattrickscoreboardl.services.process;

/**
 * @author Khips
 * @since 17 mars 2014
 */
public interface ProcessListener {

    /**
     * on start process event
     */
    void onStartProcess();

    /**
     * on finish process event
     *
     * @return < 0 if error else 0
     */
    void onFinishProcess(int code);

}
