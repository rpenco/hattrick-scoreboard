package org.hattrickscoreboard.application.views.staff;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.graphics.statics.FileToImage;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DStaff;
import org.hattrickscoreboard.database.relations.RStaff;
import org.khips.tools.KResource;

/**
 * @author Khips
 * @since 14 aot 2014
 */
public class StaffFragment extends HattrickFragment {

    private static final String TAG = (StaffFragment.class).getSimpleName();

    int teamID;
    private RStaff staff;

    public StaffFragment newInstance(int teamID) {
        StaffFragment fragment = new StaffFragment();
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

        if (staff == null) {
            return;
        }

        // Set new layout
        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();
        Log.v(TAG, "display informations on screen...");

        LinearLayout llContainer = ((LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer));

        // Failed on orientation change
        if (staff.getStaff() == null) {
            return;
        }

        for (DStaff stf : staff.getStaff()) {

            LinearLayout staffLayout = (LinearLayout) getActivity()
                    .getLayoutInflater().inflate(R.layout.staff_row, null);

            // Name
            TextView tvName = (TextView) staffLayout.findViewById(R.id.tvName);
            tvName.setText(stf.getName());

            // Type
            String[] staffType = getResources().getStringArray(
                    R.array.staff_type);
            TextView tvType = (TextView) staffLayout.findViewById(R.id.tvType);
            tvType.setText(staffType[stf.getStaffType()]);

            int res = KResource.getResDrawable(getActivity(),
                    "ic_staff_" + stf.getStaffType());
            if (res != -1) {
                ImageView ivType = (ImageView) staffLayout
                        .findViewById(R.id.ivType);
                ivType.setImageResource(res);
            }

            // Cost
            TextView tvCost = (TextView) staffLayout.findViewById(R.id.tvCost);
            tvCost.setText(formatCurrency(stf.getCost()));

            // Cost
            TextView tvLevel = (TextView) staffLayout
                    .findViewById(R.id.tvLevel);
            tvLevel.setText(getString(R.string.staff_label_level,
                    stf.getStaffLevel()));

            // Icon
            ImageView ivAvatar = (ImageView) staffLayout
                    .findViewById(R.id.ivAvatar);
            Bitmap bm = FileToImage.fileToBitmap(getActivity().getCacheDir()
                    + "/avatars/staff_" + stf.getStaffID() + ".png");
            if (bm != null) {
                ivAvatar.setImageBitmap(bm);
            }

            llContainer.addView(staffLayout);
        }
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