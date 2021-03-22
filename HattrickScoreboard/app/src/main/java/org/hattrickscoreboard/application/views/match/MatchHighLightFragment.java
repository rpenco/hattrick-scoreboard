package org.hattrickscoreboard.application.views.match;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.graphics.statics.MatchTypeDrawable;
import org.hattrickscoreboard.application.views.match.workers.MatchHighLight;
import org.hattrickscoreboard.background.tasks.live.LiveUpdate;
import org.hattrickscoreboard.background.tasks.match.LineUpUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchUpdate;
import org.hattrickscoreboard.background.tasks.match.MatchesUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DTeam;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.models.match.Match;
import org.hattrickscoreboard.database.models.match.Referee;
import org.hattrickscoreboard.database.relations.RMatch;

import java.util.ArrayList;

public class MatchHighLightFragment extends HattrickFragment {

    static final String TAG = (MatchHighLightFragment.class).getSimpleName();

    int matchID;
    String sourceSystem;

    RMatch matchRes;

    public final MatchHighLightFragment newInstance(int matchID,
                                                    String sourceSystem) {
        MatchHighLightFragment f = new MatchHighLightFragment();
        f.matchID = matchID;
        f.sourceSystem = sourceSystem;
        return f;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        MatchTask task = new MatchTask(getActivity(), this);
        task.execute(matchID, sourceSystem);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        matchRes = (RMatch) result;

        if (matchRes == null)
            return;

        setStubLayout(R.layout.fragment_highlight);

        // Populate all
        onPopulateView();
    }

    protected void onPopulateView() {
        super.onPopulateView();

        Match match = matchRes.getMatch();
        DTeam homeTeam = matchRes.getHomeTeam();
        ArrayList<Referee> referees = matchRes.getReferees();
        ArrayList<Event> events = matchRes.getEvents();
        ArrayList<LineUp> homeLineUp = matchRes.getHomeLineup();
        ArrayList<LineUp> awayLineUp = matchRes.getAwayLineup();

        View v = getFragmentView();

        if (v == null)
            return;

        // Set date
        TextView tvDate = (TextView) v.findViewById(R.id.tvDate);
        tvDate.setText(formatDateTime(match.getMatchDate()));

        // Set referee
        if (referees != null && referees.size() > 0) {
            TextView tvReferee = (TextView) v.findViewById(R.id.tvReferee);
            tvReferee.setText(referees.get(0).getRefereeName() + "");
        }

        // Set arena
        if (match.getArenaName() != null) {
            TextView tvArena = (TextView) v.findViewById(R.id.tvArena);
            tvArena.setText(match.getArenaName());
        }

        // Set spectator
        if (match.getSoldTotal() > 0) {
            TextView tvSpectators = (TextView) v
                    .findViewById(R.id.tvSpectators);
            tvSpectators.setText(formatNumber(match.getSoldTotal()));
        }

        // Set match type
        ImageView ivType = (ImageView) v.findViewById(R.id.ivMatchType);
        ivType.setImageDrawable(MatchTypeDrawable.getDrawable(getActivity(),
                homeTeam, match.getMatchType()));

        LinearLayout llHighlight = (LinearLayout) v
                .findViewById(R.id.llHighlight);

        // Clear (fix bug)
        llHighlight.removeAllViews();

        // Not all informations
        if (homeLineUp == null && awayLineUp == null) {
            return;
        }

        // Set worker for highlight
        MatchHighLight worker = new MatchHighLight(getActivity(), match,
                homeLineUp, awayLineUp);

        // Set highlight
        for (Event ev : events) {

            RelativeLayout llEvent = worker.workEvent(ev);

            if (llEvent != null) {
                llHighlight.addView(llEvent);
            }
        }

    }

    ;

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(MatchesUpdate.FROM)
                || from.equals(MatchUpdate.FROM)
                || from.equals(LineUpUpdate.FROM)
                || from.equals(LiveUpdate.FROM)) {

            MatchTask task = new MatchTask(getActivity(), this);
            task.execute(matchID, sourceSystem);
        }
    }
}