package org.hattrickscoreboard.application.views.dialogs;

import android.content.Context;
import android.util.Log;

import org.hattrick.models.search.SearchRequest;
import org.hattrick.models.search.SearchResponse;
import org.hattrickscoreboard.application.extended.tasks.AsyncFragmentTask;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;

import java.io.IOException;

/**
 * @author Khips
 * @since 27 march 2014
 */
public class SearchTask extends AsyncFragmentTask {

    private static final String TAG = (SearchTask.class).getSimpleName();

    public SearchTask(Context context, FragmentTaskListener listener) {
        super(context, listener);

    }

    @Override
    protected Object doInBackground(Object... params) {

        SearchRequest req = (SearchRequest) params[0];
        Log.i(TAG, "search type: " + req.getSearchType());

        param.setResultClass(req, SearchResponse.class);
        request.setParams(param);
        SearchResponse resp = new SearchResponse();
        try {
            resp = request.get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp;
    }

}
