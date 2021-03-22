package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.transfers.TransferSearch;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrick.providers.models.HTransfersSearch;
import org.hattrickscoreboardl.services.UpdateCode;
import org.hattrickscoreboardl.services.process.HProcess;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class TransfersSearchProcess extends HProcess {

    static final String TAG = (TransfersSearchProcess.class).getSimpleName();

    public TransfersSearchProcess(Context ctx, IRequest request, boolean forceUpdate) {
        super(ctx, request, forceUpdate);
    }

    @Override
    protected String getTAG() {
        return TAG;
    }

    @Override
    public void perform(Object... args){
        super.perform(args);

        //Get parameter
        HTransfersSearch search = (HTransfersSearch) args[0];

        //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(TransferSearch.class, search);
        TransferSearch trans = (TransferSearch) getResource(TAG, hparam);
        if(trans == null){
            fireError(TAG, UpdateCode.CODE_PARSER_ERROR);
            return;
        }

        fireSuccess();
    }


}
