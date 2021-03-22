package org.hattrickscoreboard.application.views.training;

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
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.DTraining;

public class TrainingFragment extends HattrickFragment {

    static final String TAG = (TrainingFragment.class).getSimpleName();

    int teamID;
    DTeam team;

    private DTraining training;

    public TrainingFragment newInstance(int teamID) {
        TrainingFragment fragment = new TrainingFragment();
        fragment.teamID = teamID;
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        TrainingTask task = new TrainingTask(getActivity(), this);
        task.execute(teamID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        // Get result
        training = (DTraining) result;

        if (training == null) {
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

        if (llContainer == null) {
            return;
        }

        Preferences pref = new Preferences(getActivity());

        String[] spirits = getResources().getStringArray(
                R.array.hattrick_spirit);
        String[] self = getResources().getStringArray(
                R.array.hattrick_confidence);
        String[] trainings = getResources().getStringArray(
                R.array.hattrick_skills);

        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 10, 10, 10);

        // Create background container
        View containerSummary = inflater.inflate(R.layout.view_container, null);
        llContainer.addView(containerSummary, layoutParams);

        // Create table
        KTableView tbs = new KTableView();
        tbs.createTableView(getActivity(), pref.getRGBColor(), containerSummary);
        tbs.addTitle(toUpperCase(R.string.training_title_team));
        tbs.addRowColored(R.string.training_label_team_spririt,
                spirits[training.getMorale()] + " (" + training.getMorale()
                        + ")");
        tbs.addRowColored(
                R.string.training_label_self_confidence,
                self[training.getSelfConfidence()] + " ("
                        + training.getSelfConfidence() + ")");

        // Create background container
        View container = inflater.inflate(R.layout.view_container, null);
        llContainer.addView(container, layoutParams);

        // Create table
        KTableView tb = new KTableView();
        tb.createTableView(getActivity(), pref.getRGBColor(), container);
        tb.addTitle(toUpperCase(R.string.training_label_level));
        tb.addRowColored(
                R.string.training_label_experience_550,
                trainings[training.getExperience550()] + " ("
                        + training.getExperience550() + ")");
        tb.addRowColored(
                R.string.training_label_experience_541,
                trainings[training.getExperience541()] + " ("
                        + training.getExperience541() + ")");
        tb.addRowColored(
                R.string.training_label_experience_532,
                trainings[training.getExperience532()] + " ("
                        + training.getExperience532() + ")");
        tb.addRowColored(
                R.string.training_label_experience_523,
                trainings[training.getExperience523()] + " ("
                        + training.getExperience523() + ")");
        tb.addRowColored(
                R.string.training_label_experience_451,
                trainings[training.getExperience451()] + " ("
                        + training.getExperience451() + ")");
        tb.addRowColored(
                R.string.training_label_experience_442,
                trainings[training.getExperience442()] + " ("
                        + training.getExperience442() + ")");
        tb.addRowColored(
                R.string.training_label_experience_433,
                trainings[training.getExperience433()] + " ("
                        + training.getExperience433() + ")");
        tb.addRowColored(
                R.string.training_label_experience_352,
                trainings[training.getExperience352()] + " ("
                        + training.getExperience352() + ")");
        tb.addRowColored(
                R.string.training_label_experience_343,
                trainings[training.getExperience343()] + " ("
                        + training.getExperience343() + ")");
        tb.addRowColored(
                R.string.training_label_experience_253,
                trainings[training.getExperience253()] + " ("
                        + training.getExperience253() + ")");

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        Log.v(TAG, "Receive broadcast: [" + code + "] from '" + from + "'.");

        if (from.equals(TeamUpdate.FROM)) {
            TrainingTask task = new TrainingTask(getActivity(), this);
            task.execute(teamID);
        }
    }
}