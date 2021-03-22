package org.hattrickscoreboardl.services.process;

import android.content.Context;
import android.util.Log;

import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrick.providers.exceptions.ParserException;
import org.hattrickscoreboardl.services.UpdateCode;
import org.hattrickscoreboardl.services.UpdateListener;
import org.hattrickscoreboardl.services.loaders.Validity;

import java.io.IOException;

/**
 * Created by romain
 * on 21/11/2014.
 */
public abstract class HProcess {

    Context context;
    protected IRequest request;
    boolean forceUpdate;
    UpdateListener listener;

    public HProcess(Context ctx, IRequest request, boolean forceUpdate){
        this.context = ctx;
        this.request = request;
        this.forceUpdate = forceUpdate;
    }

    protected abstract String getTAG();

    public void setListener(UpdateListener listener){
        this.listener = listener;
    }

    public void perform(Object... args) {
        fireStart();
    }

    protected void fireStart() {

        if(listener != null)
            listener.onUpdateStart(getTAG());

    }

    protected void fireError(String TAG, int code) {

        if(listener != null)
            listener.onUpdateError(getTAG(), code);


    }

    protected void fireSuccess() {

        if(listener != null)
            listener.onUpdateSuccess(getTAG());

    }

    /**
     * Check if row is up to date
     * @param fetchedDate row fetched date
     * @param validity
     * @return
     */
    protected boolean isUpToDate(String fetchedDate, int validity){

        return Validity.isUpToDate(getTAG(),forceUpdate,fetchedDate,validity);
    }


    protected <T> Object getResource(String TAG, IParam hparam){


        //Get resource
        T res = null;
        try {
            res = (T) request.get(hparam);
        } catch (IOException e) {
            e.printStackTrace();
            fireError(TAG, UpdateCode.CODE_UNKNOWN_ERROR);
        } catch (ParserException e) {

            Log.e(TAG,"Exception: "+e.getCode()+" : "+e.getContent());
            e.printStackTrace();
            fireError(TAG, UpdateCode.CODE_UNKNOWN_ERROR);
        }
        return  res;
    }


}
