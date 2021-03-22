package org.hattrickscoreboard.application.views.staff;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.relations.RStaff;

/**
 * @author Khips
 * @since 14 aot 2014
 */
public class StaffStatsFragment extends HattrickFragment {

    static final String TAG = (StaffStatsFragment.class).getSimpleName();

    // Selected team
    int teamID;

    private RStaff staff;

    public StaffStatsFragment newInstance(int teamID) {
        StaffStatsFragment fragment = new StaffStatsFragment();
        fragment.teamID = teamID;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        StaffTask task = new StaffTask(getActivity(), this);
        task.execute(teamID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        staff = (RStaff) result;
        if (staff == null)
            return;

        // Set new layout
        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();
        Log.v(TAG, "display informations on screen...");

        // Failed on orientation change
        if (staff.getStaff() == null)
            return;

        // Prepare stats
        StaffStat trainers = new StaffStat(staff.getStaffType(1));
        StaffStat medic = new StaffStat(staff.getStaffType(2));
        StaffStat spokesmen = new StaffStat(staff.getStaffType(3));
        StaffStat psy = new StaffStat(staff.getStaffType(4));
        StaffStat form = new StaffStat(staff.getStaffType(5));
        StaffStat financial = new StaffStat(staff.getStaffType(6));

        StaffStat staffs = new StaffStat(staff.getStaff());

        // Get layout parameters
        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        // for after update...
        llContainer.removeAllViews();

        // Create background container
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View container = inflater.inflate(R.layout.view_container, null);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        applyMarginLayout(layoutParams);
        llContainer.addView(container, layoutParams);

        // Create table

        Preferences pref = new Preferences(getActivity());
        KTableView tb = new KTableView();
        tb.createTableView(getActivity(), pref.getRGBColor(), container);

        String[] staffType = getResources().getStringArray(R.array.staff_type);

        tb.addTitle(toUpperCase(getString(R.string.label_summary)));
        tb.addRow(staffType[1], formatCurrency(trainers.cost()));
        tb.addRow(staffType[2], formatCurrency(medic.cost()));
        tb.addRow(staffType[3], formatCurrency(spokesmen.cost()));
        tb.addRow(staffType[4], formatCurrency(psy.cost()));
        tb.addRow(staffType[5], formatCurrency(form.cost()));
        tb.addRow(staffType[6], formatCurrency(financial.cost()));

        tb.addTitle(toUpperCase(getString(R.string.label_total)));
        tb.addRow(getString(R.string.menu_staff), "" + staffs.size());
        tb.addRow(getString(R.string.staff_label_cost),
                formatCurrency(staffs.cost()));

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        Log.v(TAG, "Receive broadcast: [" + code + "] from '" + from + "'.");

        if (from.equals(TeamUpdate.FROM)) {

            StaffTask task = new StaffTask(getActivity(), this);
            task.execute(teamID);
        }
    }

}