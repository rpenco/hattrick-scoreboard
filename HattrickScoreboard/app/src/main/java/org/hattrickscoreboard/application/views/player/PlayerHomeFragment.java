package org.hattrickscoreboard.application.views.player;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.LineUpUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.PlayersUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.relations.RPlayer;

public class PlayerHomeFragment extends HattrickFragment {

    static final String TAG = (PlayerHomeFragment.class).getSimpleName();

    int playerID;

    private RPlayer rPlayer;

    public final PlayerHomeFragment newInstance(int playerID) {
        PlayerHomeFragment f = new PlayerHomeFragment();
        f.playerID = playerID;
        return f;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        PlayerTask task = new PlayerTask(getActivity(), this);
        task.execute(playerID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        rPlayer = (RPlayer) result;

        if (rPlayer == null)
            return;

        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    protected void onPopulateView() {
        super.onPopulateView();

        String[] skills = getResources()
                .getStringArray(R.array.hattrick_skills);
        String[] agreeabilities = getResources().getStringArray(
                R.array.hattrick_player_agreeability);
        String[] agressivness = getResources().getStringArray(
                R.array.hattrick_player_agressivness);
        String[] honesties = getResources().getStringArray(
                R.array.hattrick_player_honesty);
        String[] confidences = getResources().getStringArray(
                R.array.hattrick_confidence);
        String[] specialities = getResources().getStringArray(
                R.array.hattrick_player_speciality);

        DPlayer player = rPlayer.getPlayer();
        DTeam team = rPlayer.getTeam();

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

        tb.addRow(getString(R.string.players_label_age, player.getAge(),
                player.getAgeDays(), formatNumber(player.getTSI())));

        tb.addRow(getString(R.string.player_description_form,
                skills[player.getForm()], skills[player.getStaminaSkill()]));

        tb.addRow(getString(
                R.string.player_description_agreeability_aggressiveness_honesty,
                skills[player.getForm()],
                agreeabilities[player.getAgreeability()],
                agressivness[player.getAggressiveness()],
                honesties[player.getHonesty()]));

        tb.addRow(getString(R.string.player_description_experience_leadership,
                skills[player.getExperience()], skills[player.getLeadership()]));

        tb.addRow(getString(R.string.player_description_loyalty,
                skills[player.getLoyalty()]));

        tb.addTitle("EQUIPE");

        tb.addRow(getString(R.string.player_description_owner),
                team.getTeamName());
        tb.addRow(getString(R.string.player_description_salaire),
                formatCurrency(player.getSalary()));
        tb.addRow(getString(R.string.player_description_speciality),
                specialities[player.getSpecialty()]);

        // Add skills view
        PlayerSkills playerSkill = new PlayerSkills(getActivity(), player);
        playerSkill.draw(llContainer);

    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(MatchesUpdate.FROM)
                || from.equals(MatchUpdate.FROM)
                || from.equals(LineUpUpdate.FROM)
                || from.equals(LiveUpdate.FROM)
                || from.equals(PlayersUpdate.FROM)) {

            // Launch task
            PlayerTask task = new PlayerTask(getActivity(), this);
            task.execute(playerID);
        }
    }
}