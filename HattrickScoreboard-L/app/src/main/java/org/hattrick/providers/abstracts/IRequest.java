package org.hattrick.providers.abstracts;

import android.content.Context;

import org.hattrick.providers.exceptions.ParserException;

import java.io.IOException;


public abstract class IRequest {

    private Context ctx;

    public IRequest(Context ctx){
        this.ctx = ctx;
    }

    public Object get(IParam params) throws IOException, ParserException {
        return  onPostExecute(
                    onExecute(
                        onPreExecute(params)));
    }

    protected Context getContext(){
        return this.ctx;
    }

    protected Object onPreExecute(Object params){
        return params;
    }

    protected Object onExecute(Object param){
        return null;
    }

    protected Object onPostExecute(Object result) throws ParserException {
        return result;
    }

}
