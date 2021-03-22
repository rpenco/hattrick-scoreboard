package org.hattrick.providers;

import org.hattrick.providers.abstracts.IParam;

/**
 * @author Khips
 * @since 27 mars 2014
 */
public class HattrickParam extends IParam {

    static final String TAG = (HattrickParam.class).getSimpleName();

    //Class used by parser
    private Class<?> parserClass;

    // Parameters
    private Object object;

    public HattrickParam(Class<?> parserClass, Object param){

        this.parserClass = parserClass;
        this.object = param;
    }

    public Class<?> getParserClass() {
        return parserClass;
    }

    public Object getObjectParam() {
        return object;
    }

}
