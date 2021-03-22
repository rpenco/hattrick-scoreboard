package org.hattrickscoreboard.background.downloader;

import android.content.Context;

import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.background.providers.IParams;
import org.hattrickscoreboard.background.providers.IRequest;
import org.hattrickscoreboard.background.tasks.tables.UpdateListener;
import org.hattrickscoreboard.database.HattrickBDD;
import org.hattrickscoreboard.database.models.DModel;
import org.khips.tools.networks.KNetwork;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class Downloader {

    static final String TAG = (Downloader.class).getSimpleName();
    protected Context context;
    protected HattrickBDD bdd;
    protected UpdateListener listener;
    protected IRequest request;
    protected IParams param;

    public Downloader(Context context, IRequest request, IParams param,
                      HattrickBDD bdd, UpdateListener listener) {
        this.context = context;
        this.request = request;
        this.param = param;
        this.bdd = bdd;
        this.listener = listener;
    }

    protected boolean isValid(Object obj) {
        if (obj == null) {
            return false;
        }

        if (KNetwork.hasInternet(context)) {
            if (HattrickDate.needUpdate(((DModel) obj).getFetchedDate(),
                    ((DModel) obj).getValidityTime())) {
                return false;
            }
        }
        return true;

    }
}