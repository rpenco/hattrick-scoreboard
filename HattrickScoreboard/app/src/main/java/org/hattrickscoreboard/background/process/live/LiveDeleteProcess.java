package org.hattrickscoreboard.background.process.live;

import org.hattrick.models.live.Live;
import org.hattrick.providers.params.HLiveQuery;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.process.HProcess;
import org.hattrickscoreboard.database.tables.LiveTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class LiveDeleteProcess extends HProcess {

    static final String TAG = (LiveDeleteProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        HLiveQuery query = (HLiveQuery) params.getObjectParam();

        // Result class (XML from CHPP)
        params.setResultClass(Live.class);
        request.setParams(params);

        // Get file
        try {
            request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        datasource.delete(LiveTable.class, LiveTable.COL_MATCH_ID + "="
                + query.getMatchID() + " AND " + LiveTable.COL_SOURCE_SYSTEM
                + "='" + query.getSourceSystem() + "'");

        // Send broadcast
        fireSuccess();
    }
}
