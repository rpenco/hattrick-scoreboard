package org.hattrickscoreboard.background.process;

import android.content.ContentValues;
import android.util.Log;

import org.hattrick.models.transfers.Transfer;
import org.hattrick.models.transfers.Transfers;
import org.hattrick.providers.params.HQuery;
import org.hattrickscoreboard.application.utils.HattrickDate;
import org.hattrickscoreboard.application.utils.HattrickUpdater;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.database.tables.TransfersTable;

import java.io.IOException;

/**
 * @author Khips
 * @since 17 march 2014
 */
public class TransfersProcess extends HProcess {

    static final String TAG = (TransfersProcess.class).getSimpleName();

    @Override
    public void perform() {
        super.perform();

        HQuery obj = (HQuery) params.getObjectParam();

        boolean needUpdate = datasource
                .needUpdate(TransfersTable.class, forceUpdate,
                        TransfersTable.COL_TEAM_ID + "=" + obj.getTeamID());

        if (!needUpdate) {
            Log.i(TAG, "not need update.");
            fireSuccess();
            return;
        }

        // Result class (XML from CHPP)
        params.setResultClass(Transfers.class);
        request.setParams(params);

        Transfers res;

        // Get CHPP file
        try {
            res = request.get();
        } catch (IOException e) {
            e.printStackTrace();
            fireError(Background.RESULT_ERROR_CONN);
            return;
        }

        // Get current date time
        String fetchedDate = HattrickDate.getDateTime();

        // Insert or update into DB

        for (Transfer transfer : res.getTransfers()) {

            // Foreach staff member

            ContentValues values = new ContentValues();
            values.put(TransfersTable.COL_TEAM_ID,
                    ((HQuery) params.getObjectParam()).getTeamID());
            values.put(TransfersTable.COL_TRANSFER_ID, transfer.getTransferID());
            values.put(TransfersTable.COL_DEAD_LINE, transfer.getDeadline());
            values.put(TransfersTable.COL_TYPE, transfer.getTransferType());
            values.put(TransfersTable.COL_PRICE, transfer.getPrice());
            values.put(TransfersTable.COL_PLAYER_ID, transfer.getPlayerID());
            values.put(TransfersTable.COL_PLAYER_NAME, transfer.getPlayerName());
            values.put(TransfersTable.COL_TSI, transfer.getTSI());
            values.put(TransfersTable.COL_BUYER_TEAM_ID,
                    transfer.getBuyerTeamID());
            values.put(TransfersTable.COL_BUYER_TEAM_NAME,
                    transfer.getBuyerTeamName());
            values.put(TransfersTable.COL_SELLER_TEAM_ID,
                    transfer.getSellerTeamID());
            values.put(TransfersTable.COL_SELLER_TEAM_NAME,
                    transfer.getSellerTeamName());
            values.put(TransfersTable.COL_FETCHED_DATE, fetchedDate);
            values.put(TransfersTable.COL_VALIDITY_TIME,
                    HattrickUpdater.VALIDITY_TRANSFER);

            // Create or update
            datasource.createOrUpdate(
                    TransfersTable.class,
                    values,
                    TransfersTable.COL_TRANSFER_ID + "="
                            + transfer.getTransferID());

        }

        // Send broadcast
        fireSuccess();
    }
}
