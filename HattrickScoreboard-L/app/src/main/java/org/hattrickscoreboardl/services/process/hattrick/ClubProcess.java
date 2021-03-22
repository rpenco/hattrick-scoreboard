package org.hattrickscoreboardl.services.process.hattrick;

import android.content.Context;

import org.hattrick.models.clubs.Club;
import org.hattrick.models.staffs.Staff;
import org.hattrick.models.staffs.StaffList;
import org.hattrick.providers.HattrickParam;
import org.hattrick.providers.abstracts.IParam;
import org.hattrick.providers.abstracts.IRequest;
import org.hattrickscoreboardl.database.models.club.HClub;
import org.hattrickscoreboardl.database.models.staffs.HStaff;
import org.hattrickscoreboardl.services.loaders.Validity;
import org.hattrickscoreboardl.services.process.HProcess;
import org.hattrickscoreboardl.utils.HattrickDate;

/**
 * Created by romain
 * on 21/11/2014.
 */
public class ClubProcess extends HProcess {

    static final String TAG = (ClubProcess.class).getSimpleName();

    public ClubProcess(Context ctx, IRequest request, boolean forceUpdate) {
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

        //Find club if exist
        HClub hClub = HClub.findOne(HClub.class, "TEAM_ID = ?", "" + teamID);

        ////////////////////////////////////

        //Check if need update
        if(hClub != null){
            if(isUpToDate(hClub.getFetchedDate(), Validity.CLUB)){
                fireSuccess();
                return;
            }
        }else{
            hClub = new HClub();
        }

        ////////////////////////////////////
        //Not exist or need update

        //Create URI parameter (teamID)
        IParam hparam = new HattrickParam(Club.class, teamID);
        Club club = (Club) getResource(TAG, hparam);
        if(club == null){
            return;
        }

        hClub.setTeamID(teamID);
        hClub.setUserID(club.getUserID());
        hClub.setAssistantTrainerLevels(club.getAssistantTrainerLevels());
        hClub.setFinancialDirectorLevels(club.getFinancialDirectorLevels());
        hClub.setFormCoachLevels(club.getFormCoachLevels());
        hClub.setHasPromoted(club.hasPromoted());
        hClub.setInvestment(club.getInvestment());
        hClub.setMedicLevels(club.getMedicLevels());
        hClub.setSpokespersonLevels(club.getSpokespersonLevels());
        hClub.setYouthLevel(club.getYouthLevel());
        hClub.setSportPsychologistLevels(club.getSportPsychologistLevels());
        hClub.setFetchedDate(HattrickDate.getDateTime());
        hClub.save();


        //Get Staff

        //Create URI parameter (teamID)
        hparam = new HattrickParam(StaffList.class, teamID);
        StaffList staffList = (StaffList) getResource(TAG, hparam);
        if(staffList == null){
            return;
        }

        //Remove staff
        HStaff.deleteAll(HStaff.class, "TEAM_ID = ?", String.valueOf(teamID));

        for(int i = 0; i < staffList.getStaffMembers().size(); i++) {

            Staff s = staffList.getStaffMembers().get(i);
            HStaff staff = new HStaff();
            staff.setTeamID(teamID);
            staff.setName(s.getName());
            staff.setCost(s.getCost());
            staff.setHiredDate(s.getHiredDate());
            staff.setStaffId(s.getStaffID());
            staff.setStaffLevel(s.getStaffLevel());
            staff.setStaffType(s.getStaffType());
            staff.save();
        }

        hClub.save();
        fireSuccess();
    }


}
