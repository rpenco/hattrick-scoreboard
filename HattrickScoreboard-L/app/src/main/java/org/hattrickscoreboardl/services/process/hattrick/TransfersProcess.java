package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.transfers.BidItem;
import org.hattrick.models.transfers.CurrentBids;
import org.hattrick.models.transfers.Transfer;
import org.hattrick.models.transfers.Transfers;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.app.HUpdate;
import org.hattrickscoreboardl.database.models.club.HClub;
import org.hattrickscoreboardl.database.models.transfer.HBid;
import org.hattrickscoreboardl.database.models.transfer.HTransfer;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class TransfersProcess extends HProcess {

    static final String TAG = (TransfersProcess.class).getSimpleName();

    public TransfersProcess(Context ctx, IRequest request, boolean forceUpdate) {
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
        int teamID = (Integer) args[0];

        HUpdate update = HUpdate.findOne(HUpdate.class, "PROCESS_NAME = ?", "" + TAG+"_"+teamID);

        //Check if need update
        if(update != null ){
            if(isUpToDate(update.getFetchedDate(), Validity.TRANSFER)){
                fireSuccess();
                return;
            }
        }else
        {
            update = new HUpdate();
        }

        //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(Transfers.class, teamID);
        Transfers trans = (Transfers) getResource(TAG, hparam);
        if(trans == null){
            return;
        }


        //Save transfers steam
        if(trans.getTransfers() != null){
            for(int i=0; i< trans.getTransfers().size();i++) {

                Transfer t = trans.getTransfers().get(i);

                HTransfer transfer = HTransfer.findOne(HTransfer.class, "TRANSFER_ID = ?", String.valueOf(t.getTransferID()));
                if(transfer == null){
                    transfer = new HTransfer();
                }

                transfer.setTeamID(teamID);
                transfer.setBuyerTeamID(t.getBuyerTeamID());
                transfer.setBuyerTeamName(t.getBuyerTeamName());
                transfer.setDeadline(t.getDeadline());
                transfer.setPlayerID(t.getPlayerID());
                transfer.setPlayerName(t.getPlayerName());
                transfer.setPrice(t.getPrice());
                transfer.setSellerTeamID(t.getSellerTeamID());
                transfer.setSellerTeamName(t.getSellerTeamName());
                transfer.setTransferID(t.getTransferID());
                transfer.setTransferType(t.getTransferType());
                transfer.setTSI(t.getTSI());
                transfer.save();
            }
        }

        //Update club info
        HClub club  = HClub.findOne(HClub.class, "TEAM_ID = ?",teamID+"");
        if(club != null) {

            club.setNumberOfBuys(trans.getNumberOfBuys());
            club.setNumberOfSales(trans.getNumberOfSales());
            club.setTotalSumOfBuys(trans.getTotalSumOfBuys());
            club.setTotalSumOfSales(trans.getTotalSumOfSales());
            club.save();
        }


        //Get current BID

        hparam = new HattrickParam(CurrentBids.class, teamID);
        CurrentBids bids = (CurrentBids) getResource(TAG, hparam);
        if(bids == null){
            return;
        }

        //remove all
        HBid.deleteAll(HBid.class);

        //Save bids
        if(bids.getBidItems() != null){
            for(int i=0; i< bids.getBidItems().size();i++) {

                BidItem b = bids.getBidItems().get(i);

                HBid bid = new HBid();
                bid.setTeamID(teamID);
                bid.setDeadline(b.getDeadline());
                bid.setHighestBidAmount(b.getHighestBidAmount());
                bid.setHighestBidTeamId(b.getHighestBidTeamId());
                bid.setHighestBidTeamName(b.getHighestBidTeamName());
                bid.setPlayerId(b.getPlayerId());
                bid.setPlayerName(b.getPlayerName());
                bid.setTransferId(b.getTransferId());
                bid.save();
            }
        }

        //Save updater
        update.setProcessName(TAG+"_"+teamID);
        update.setFetchedDate(HattrickDate.getDateTime());
        update.save();

        fireSuccess();
    }


}
