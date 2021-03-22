package org.hattrickscoreboard.application.views.match.workers;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.models.match.Match;

import java.util.ArrayList;

public class MatchHighLight {

    static String TAG = (MatchHighLight.class).getSimpleName();
    int tempHomeGoal = 0;
    int tempAwayGoal = 0;
    private Activity act;
    private Match match;
    private ArrayList<LineUp> homeLineUp;
    private ArrayList<LineUp> awayLineUp;

    public MatchHighLight(Activity act, Match match,
                          ArrayList<LineUp> homeLineUp, ArrayList<LineUp> awayLineUp) {
        this.act = act;
        this.match = match;
        this.homeLineUp = homeLineUp;
        this.awayLineUp = awayLineUp;
    }

    public RelativeLayout workEvent(Event event) {

        Log.v(TAG,
                "Events: type:" + event.getEventTypeID() + " variation:"
                        + event.getEventVariation() + " teamID: "
                        + event.getSubjectTeamID());

        RelativeLayout llEvent = null;
        int res = HattrickEventIcon.icon(event);

        // Weather
        if (res == R.drawable.ic_event_30_rain) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_weather_rain));
        }

        if (res == R.drawable.ic_event_31_rain) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_weather_cloudy));
        }

        if (res == R.drawable.ic_event_32_fear) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_weather_fear));
        }
        if (res == R.drawable.ic_event_33_sunny) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_weather_sunny));
        }

        // Best
        if (res == R.drawable.ic_event_41_best_player) {
            llEvent = draw(event, res, getPlayerName(event));
        }

        // Worst
        if (res == R.drawable.ic_event_42_worst_player) {
            llEvent = draw(event, res, getPlayerName(event));
        }

        // Half
        if (res == R.drawable.ic_event_45_half) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_halftime));
        }

        // Walkover (forfait)
        if (res == R.drawable.ic_event_501_502_walkover) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_walkover));
        }

        // Penalty goal
        if (res == R.drawable.ic_event_55_56_57_104_114_124_134_154_164_174_184_penalty_goal) {

            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        // SE goal
        if (res == R.drawable.ic_event_105a109_115a119_125_se_goal) {

            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        // Counter attack goal
        if (res == R.drawable.ic_event_140a143_186_counter_attack) {

            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        // Penalty no goal
        // if (res ==
        // R.drawable.ic_event_58_59_204_214_224_234_254_264_274_284_penalty_no_goal)
        // {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }

        // Extension
        if (res == R.drawable.ic_event_70_extension) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_extension));
        }

        // Penalty contest
        if (res == R.drawable.ic_event_71_penalty_contest) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_penalty_contest));
        }

        // Coin
        if (res == R.drawable.ic_event_73_coin) {
            llEvent = draw(event, res, act.getString(R.string.match_event_coin));
        }

        if (res == R.drawable.ic_event_90_94_injury_playing) {

            llEvent = draw(event, res, getPlayerName(event));
        }

        if (res == R.drawable.ic_event_91_95_injury_leave) {

            llEvent = draw(event, res,
                    getPlayerName(event, event.getSubjectPlayerID()),
                    act.getString(R.string.match_event_substitution,
                            getPlayerName(event, event.getObjectPlayerID())));
        }

        if (res == R.drawable.ic_event_92_badly_injury_leave) {

            llEvent = draw(event, res,
                    getPlayerName(event, event.getSubjectPlayerID()),
                    act.getString(R.string.match_event_substitution,
                            getPlayerName(event, event.getObjectPlayerID())));
        }

        if (res == R.drawable.ic_event_93_96_badly_injury_no_remplace) {

            llEvent = draw(event, res, getPlayerName(event));
        }

        if (res == R.drawable.ic_event_100_110_120_130_150_160_170_180_freekick) {

            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        if (res == R.drawable.ic_event_101_111_121_131_151_161_171_181_goal_middle) {

            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        if (res == R.drawable.ic_event_102_112_122_132_152_162_172_182_goal_left) {

            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        if (res == R.drawable.ic_event_103_113_123_133_153_163_173_183_goal_right) {

            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        if (res == R.drawable.ic_event_185_indirect_freekick) {
            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        if (res == R.drawable.ic_event_187_goal_long) {
            upGoal(event);
            llEvent = draw(event, res, getPlayerName(event), getGoals());
        }

        // if (res ==
        // R.drawable.ic_event_200_210_220_230_250_260_270_280_no_freekick) {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }
        //
        // if (res ==
        // R.drawable.ic_event_201_211_221_231_251_261_271_281_no_goal_middle) {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }
        //
        // if (res ==
        // R.drawable.ic_event_202_212_222_232_252_262_272_282_no_goal_left) {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }
        //
        // if (res ==
        // R.drawable.ic_event_203_213_223_233_253_263_273_283_no_goal_right) {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }
        //
        // if (res == R.drawable.ic_event_285_no_goals_indirect_freekick) {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }
        //
        // if (res == R.drawable.ic_event_287_288_no_goal_long) {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }

        if (res == R.drawable.ic_event_350_531_352_substitution) {

            llEvent = draw(event, res,
                    getPlayerName(event, event.getSubjectPlayerID()),
                    act.getString(R.string.match_event_substitution,
                            getPlayerName(event, event.getObjectPlayerID())));

        }

        if (res == R.drawable.ic_event_510_511_yellow) {
            llEvent = draw(event, res, getPlayerName(event));
        }

        if (res == R.drawable.ic_event_512_513_yellow_red) {
            llEvent = draw(event, res, getPlayerName(event));
        }

        if (res == R.drawable.ic_event_514_red) {
            llEvent = draw(event, res, getPlayerName(event));
        }

        // if (res == R.drawable.ic_event_599_fulltime) {
        // llEvent = draw(event, res, act.getString(R.string.match_event_));
        // }

        if (res == R.drawable.ic_event_tactic_331_pressing) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_tactical_change),
                    act.getString(R.string.match_event_tactical_pressing));
        }

        if (res == R.drawable.ic_event_tactic_332_counter_attack) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_tactical_change),
                    act.getString(R.string.match_event_tactical_counter_attack));
        }

        if (res == R.drawable.ic_event_tactic_333_343_attack_middle) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_tactical_change),
                    act.getString(R.string.match_event_tactical_attack_middle));
        }

        if (res == R.drawable.ic_event_tactic_334_344_attack_wings) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_tactical_change),
                    act.getString(R.string.match_event_tactical_attack_wings));
        }

        if (res == R.drawable.ic_event_tactic_335_creativity) {
            llEvent = draw(
                    event,
                    res,
                    act.getString(R.string.match_event_tactical_change),
                    act.getString(R.string.match_event_tactical_attack_creativity));
        }

        if (res == R.drawable.ic_event_tactic_336_long_shot) {
            llEvent = draw(event, res,
                    act.getString(R.string.match_event_tactical_change),
                    act.getString(R.string.match_event_tactical_long_shot));
        }

        // if (res == R.drawable.ic_event_tactic_360_361_change) {
        // llEvent = draw(event, res,
        // act.getString(R.string.match_event_tactical_change));
        // }

        return llEvent;
    }

    private String getGoals() {
        // return tempHomeGoal + "-" + tempAwayGoal;
        return null;
    }

    private boolean isHomeTeam(Event ev) {
        return (match.getHomeTeamID() == ev.getSubjectTeamID());
    }

    private boolean isAwayTeam(Event ev) {
        return (match.getAwayTeamID() == ev.getSubjectTeamID());
    }

    private void upGoal(Event ev) {
        if (isHomeTeam(ev)) {
            tempHomeGoal += 1;
        } else {
            tempAwayGoal += 1;
        }
    }

    private RelativeLayout draw(Event ev, int resourceID, String text) {
        return draw(ev, resourceID, text, "");
    }

    private RelativeLayout draw(Event ev, int resourceID, String text,
                                String subText) {

        RelativeLayout ret = null;

        if (isHomeTeam(ev)) {
            ret = drawHomeTeam(ev.getMinute(), resourceID, text, subText);
        } else if (isAwayTeam(ev)) {
            ret = drawAwayTeam(ev.getMinute(), resourceID, text, subText);
        } else {
            ret = drawMatch(ev.getMinute(), resourceID, text);
        }

        return ret;
    }

    private RelativeLayout drawMatch(int minute, int resourceID, String text) {

        // Create layout
        RelativeLayout llEvent = (RelativeLayout) act.getLayoutInflater()
                .inflate(R.layout.row_highlight_neutral, null);

        // Get elements
        TextView tvText = (TextView) llEvent.findViewById(R.id.tvEvent);
        TextView homeTime = (TextView) llEvent.findViewById(R.id.tvHomeTime);
        ImageView ivHome = (ImageView) llEvent.findViewById(R.id.ivHomeEvent);

        TextView awayTime = (TextView) llEvent.findViewById(R.id.tvAwayTime);
        ImageView ivAway = (ImageView) llEvent.findViewById(R.id.ivAwayEvent);

        // Set value
        tvText.setText(text);
        homeTime.setText(Integer.toString(minute) + "'");
        awayTime.setText(Integer.toString(minute) + "'");
        ivHome.setImageResource(resourceID);
        ivAway.setImageResource(resourceID);
        return llEvent;

    }

    private RelativeLayout drawHomeTeam(int minute, int resourceID,
                                        String text, String subText) {

        // Create layout
        RelativeLayout llEvent = (RelativeLayout) act.getLayoutInflater()
                .inflate(R.layout.row_highlight, null);

        // Get elements
        TextView homeText = (TextView) llEvent.findViewById(R.id.tvHomeEvent);
        TextView homeSubText = (TextView) llEvent.findViewById(R.id.TvHomeSub);
        TextView homeTime = (TextView) llEvent.findViewById(R.id.tvHomeTime);
        ImageView ivHome = (ImageView) llEvent.findViewById(R.id.ivHomeEvent);

        TextView awayText = (TextView) llEvent.findViewById(R.id.tvAwayEvent);
        TextView awaySubText = (TextView) llEvent.findViewById(R.id.TvAwaySub);
        TextView awayTime = (TextView) llEvent.findViewById(R.id.tvAwayTime);
        ImageView ivAway = (ImageView) llEvent.findViewById(R.id.ivAwayEvent);

        // Hide away element
        awayText.setVisibility(View.INVISIBLE);
        awaySubText.setVisibility(View.INVISIBLE);
        awayTime.setVisibility(View.INVISIBLE);
        ivAway.setVisibility(View.INVISIBLE);

        // Set value
        homeText.setText(text);
        homeSubText.setText(subText);
        homeTime.setText(Integer.toString(minute) + "'");
        ivHome.setImageResource(resourceID);
        return llEvent;

    }

    private RelativeLayout drawAwayTeam(int minute, int resourceID,
                                        String text, String subText) {

        // Create layout
        RelativeLayout llEvent = (RelativeLayout) act.getLayoutInflater()
                .inflate(R.layout.row_highlight, null);

        // Get elements
        TextView homeText = (TextView) llEvent.findViewById(R.id.tvHomeEvent);
        TextView homeSubText = (TextView) llEvent.findViewById(R.id.TvHomeSub);
        TextView homeTime = (TextView) llEvent.findViewById(R.id.tvHomeTime);
        ImageView ivHome = (ImageView) llEvent.findViewById(R.id.ivHomeEvent);

        TextView awayText = (TextView) llEvent.findViewById(R.id.tvAwayEvent);
        TextView awaySubText = (TextView) llEvent.findViewById(R.id.TvAwaySub);
        TextView awayTime = (TextView) llEvent.findViewById(R.id.tvAwayTime);
        ImageView ivAway = (ImageView) llEvent.findViewById(R.id.ivAwayEvent);

        // Hide home element
        homeText.setVisibility(View.INVISIBLE);
        homeSubText.setVisibility(View.INVISIBLE);
        homeTime.setVisibility(View.INVISIBLE);
        ivHome.setVisibility(View.INVISIBLE);

        // Set value
        awayText.setText(text);
        awaySubText.setText(subText);
        awayTime.setText(Integer.toString(minute) + "'");
        ivAway.setImageResource(resourceID);
        return llEvent;

    }

    private String getPlayerName(Event ev) {
        String name = null;

        if (isHomeTeam(ev)) {

            for (LineUp player : homeLineUp) {
                if (player.getPlayerID() == ev.getSubjectPlayerID())
                    return player.getFirstName() + " " + player.getLastName();
            }

        } else {

            for (LineUp player : awayLineUp) {
                if (player.getPlayerID() == ev.getSubjectPlayerID())
                    return player.getFirstName() + " " + player.getLastName();
            }
        }
        return name;
    }

    private String getPlayerName(Event ev, int playerID) {
        String name = null;

        if (isHomeTeam(ev)) {

            for (LineUp player : homeLineUp) {
                if (player.getPlayerID() == playerID)
                    return player.getFirstName() + " " + player.getLastName();
            }

        } else {

            for (LineUp player : awayLineUp) {
                if (player.getPlayerID() == playerID)
                    return player.getFirstName() + " " + player.getLastName();
            }
        }
        return name;
    }
}
