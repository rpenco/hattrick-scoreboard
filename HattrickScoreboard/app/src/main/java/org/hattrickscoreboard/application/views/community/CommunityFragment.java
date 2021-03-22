package org.hattrickscoreboard.application.views.community;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.extended.tasks.AsyncImageTaskListener;
import org.hattrickscoreboard.application.views.activities.ConsultActivity;
import org.hattrickscoreboard.background.tasks.LogoTask;
import org.hattrickscoreboard.background.tasks.tables.BookmarksUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.relations.RCommunity;

/**
 * @author Khips
 * @since 14 august 2014
 */
public final class CommunityFragment extends HattrickFragment {

    static final String TAG = (CommunityFragment.class).getSimpleName();

    public RCommunity comRes;

    public CommunityFragment newInstance() {
        CommunityFragment fragment = new CommunityFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        CommunityTask task = new CommunityTask(getActivity(), this);
        task.execute();
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        comRes = (RCommunity) result;

        // Prevent crash on orientation change..
        if (comRes == null)
            return;

        // Set new layout
        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();

        LinearLayout llContainer = (LinearLayout) getFragmentView()
                .findViewById(R.id.llContainer);

        if (llContainer == null)
            return;

        DTeam myTeam = ((HattrickApplication) getActivity().getApplication())
                .getSelectedTeam();

        if (comRes.getTeams() != null) {
            for (final DTeam team : comRes.getTeams()) {

                if (team.getTeamID() == myTeam.getTeamID()) {
                    continue;
                }

                final LinearLayout llMatchContainer = (LinearLayout) getActivity()
                        .getLayoutInflater().inflate(
                                R.layout.community_team_row, null);

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                llContainer.addView(llMatchContainer, layoutParams);

                applyMarginLayout(layoutParams);

                // Set informations
                TextView tvTeam = (TextView) llMatchContainer
                        .findViewById(R.id.tvBookTeam);
                tvTeam.setText(team.getTeamName());

                TextView tvManager = (TextView) llMatchContainer
                        .findViewById(R.id.tvBookManager);
                tvManager.setText(team.getLeagueName() + ", "
                        + team.getRegionName() + ", "
                        + team.getLeagueLevelUnitName());

                // SET LOGO

                // Logo team
                if (team.isBot()) {
                    // bot logo
                    ImageView ivLogo = (ImageView) llMatchContainer
                            .findViewById(R.id.ivBookLogo);
                    ivLogo.setImageResource(R.drawable.ic_bot_team_logo);
                } else {

                    if (team.getLogoURL() != null) {

                        // Custom logo
                        LogoTask logoTask = new LogoTask(getActivity(),
                                new AsyncImageTaskListener() {

                                    @Override
                                    public void onImageStart() {
                                    }

                                    @Override
                                    public void onImageResult(Bitmap image) {
                                        ImageView ivLogo = (ImageView) llMatchContainer
                                                .findViewById(R.id.ivBookLogo);
                                        if (ivLogo != null)
                                            ivLogo.setImageBitmap(image);
                                    }
                                });
                        logoTask.execute(team.getLogoURL());
                    }
                }

                // On click
                llMatchContainer.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        // Start consult activity
                        Intent intent = new Intent(getActivity(),
                                ConsultActivity.class);
                        Bundle bdl = new Bundle();
                        bdl.putInt(ConsultActivity.RESULTID, team.getTeamID());
                        bdl.putInt(ConsultActivity.RESULTTYPE, -1);
                        intent.putExtras(bdl);

                        // Start activity
                        startActivity(intent);
                    }
                });
            }
        }
    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(BookmarksUpdate.FROM)) {
            CommunityTask task = new CommunityTask(getActivity(), this);
            task.execute();
        }
    }
}
