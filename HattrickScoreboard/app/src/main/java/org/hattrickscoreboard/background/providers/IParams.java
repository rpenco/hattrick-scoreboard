package org.hattrickscoreboard.background.providers;

import org.hattrick.providers.exceptions.HParamsProcessException;


public interface IParams {


    void setResultClass(Object param, Class<?> classnameResult);

    Class<?> getResultClass();

    void setResultClass(Class<?> classname);

    Object getObjectParam();

    void setObjectParam(Object obj);

    String processParam() throws HParamsProcessException;
}
