package org.hattrickscoreboard.application.views.match.workers;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.database.models.match.Event;

public class HattrickEventIcon {

    static String TAG = (HattrickEventIcon.class).getSimpleName();

    /**
     * Return drawable resource
     *
     * @param event
     * @return
     */
    public static int icon(Event event) {
        int res = 0;
        int type = event.getEventTypeID();

        // Tactic
        if (type == 20) {
            return R.drawable.ic_event_20_tactical;
        }

        // Weather
        if (type == 30) {
            return R.drawable.ic_event_30_rain;
        }

        // Weather
        if (type == 31) {
            return R.drawable.ic_event_31_rain;
        }

        // Weather
        if (type == 32) {
            return R.drawable.ic_event_32_fear;
        }

        // Weather
        if (type == 33) {
            return R.drawable.ic_event_33_sunny;
        }

        // Best
        if (type == 41) {
            return R.drawable.ic_event_41_best_player;
        }

        // Worst
        if (type == 42) {
            return R.drawable.ic_event_42_worst_player;
        }

        // Half
        if (type == 45) {
            return R.drawable.ic_event_45_half;
        }

        if (eval(type, 55, 56, 57, 104, 114, 124, 134, 154, 164, 174, 184)) {
            return R.drawable.ic_event_55_56_57_104_114_124_134_154_164_174_184_penalty_goal;
        }

        if (eval(type, 58, 59, 204, 214, 224, 234, 254, 264, 274, 284)) {
            return R.drawable.ic_event_58_59_204_214_224_234_254_264_274_284_penalty_no_goal;
        }

        if (eval(type, 70)) {
            return R.drawable.ic_event_70_extension;
        }

        if (eval(type, 71)) {
            return R.drawable.ic_event_71_penalty_contest;
        }

        if (eval(type, 73)) {
            return R.drawable.ic_event_73_coin;
        }

        if (eval(type, 90, 94)) {
            return R.drawable.ic_event_90_94_injury_playing;
        }

        if (eval(type, 91, 95)) {
            return R.drawable.ic_event_91_95_injury_leave;
        }

        if (eval(type, 92)) {
            return R.drawable.ic_event_92_badly_injury_leave;
        }
        if (eval(type, 93, 96)) {
            return R.drawable.ic_event_93_96_badly_injury_no_remplace;
        }
        if (eval(type, 100, 110, 120, 130, 150, 160, 170, 180)) {
            return R.drawable.ic_event_100_110_120_130_150_160_170_180_freekick;
        }
        if (eval(type, 101, 111, 121, 131, 151, 161, 171, 181)) {
            return R.drawable.ic_event_101_111_121_131_151_161_171_181_goal_middle;
        }
        if (eval(type, 102, 112, 122, 132, 152, 162, 172, 182)) {
            return R.drawable.ic_event_102_112_122_132_152_162_172_182_goal_left;
        }
        if (eval(type, 103, 113, 123, 133, 153, 163, 173, 183)) {
            return R.drawable.ic_event_103_113_123_133_153_163_173_183_goal_right;
        }
        if (eval(type, 185)) {
            return R.drawable.ic_event_185_indirect_freekick;
        }
        if (eval(type, 187)) {
            return R.drawable.ic_event_187_goal_long;
        }
        if (eval(type, 200, 210, 220, 230, 250, 260, 270, 280)) {
            return R.drawable.ic_event_200_210_220_230_250_260_270_280_no_freekick;
        }
        if (eval(type, 201, 211, 221, 231, 251, 261, 271, 281)) {
            return R.drawable.ic_event_201_211_221_231_251_261_271_281_no_goal_middle;
        }
        if (eval(type, 202, 212, 222, 232, 252, 262, 272, 282)) {
            return R.drawable.ic_event_202_212_222_232_252_262_272_282_no_goal_left;
        }
        if (eval(type, 203, 213, 223, 233, 253, 263, 273, 283)) {
            return R.drawable.ic_event_203_213_223_233_253_263_273_283_no_goal_right;
        }
        if (eval(type, 285)) {
            return R.drawable.ic_event_285_no_goals_indirect_freekick;
        }
        if (eval(type, 287, 288)) {
            return R.drawable.ic_event_287_288_no_goal_long;
        }
        if (eval(type, 350, 531, 352)) {
            return R.drawable.ic_event_350_531_352_substitution;
        }

        // Forfait
        if (eval(type, 500, 501, 502)) {
            return R.drawable.ic_event_501_502_walkover;
        }

        if (eval(type, 510, 511)) {
            return R.drawable.ic_event_510_511_yellow;
        }
        if (eval(type, 512, 513)) {
            return R.drawable.ic_event_512_513_yellow_red;
        }
        if (eval(type, 514)) {
            return R.drawable.ic_event_514_red;
        }
        if (eval(type, 599)) {
            return R.drawable.ic_event_599_fulltime;
        }
        if (eval(type, 331)) {
            return R.drawable.ic_event_tactic_331_pressing;
        }
        if (eval(type, 332)) {
            return R.drawable.ic_event_tactic_332_counter_attack;
        }
        if (eval(type, 333, 343)) {
            return R.drawable.ic_event_tactic_333_343_attack_middle;
        }
        if (eval(type, 334, 344)) {
            return R.drawable.ic_event_tactic_334_344_attack_wings;
        }
        if (eval(type, 335)) {
            return R.drawable.ic_event_tactic_335_creativity;
        }
        if (eval(type, 336)) {
            return R.drawable.ic_event_tactic_336_long_shot;
        }
        if (eval(type, 360, 361)) {
            return R.drawable.ic_event_tactic_360_361_change;
        }

        // SE - goal
        if (eval(type, 105, 106, 107, 108, 109, 115, 116, 117, 118, 119, 125)) {
            return R.drawable.ic_event_105a109_115a119_125_se_goal;
        }

        // Counter attack - goal
        if (eval(type, 140, 141, 142, 143, 186)) {
            return R.drawable.ic_event_140a143_186_counter_attack;
        }

        return res;
    }

    /**
     * easy method for multi if(type == num1 || type == num2...)
     *
     * @param type
     * @param numbers
     * @return
     */
    private static boolean eval(int type, int... numbers) {
        for (int i : numbers) {
            if (type == i)
                return true;
        }
        return false;
    }
}
