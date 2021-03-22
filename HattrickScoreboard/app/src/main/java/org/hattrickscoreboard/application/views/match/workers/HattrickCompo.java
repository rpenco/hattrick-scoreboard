package org.hattrickscoreboard.application.views.match.workers;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrick.constants.HMatchRoleID;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.database.models.match.LineUp;
import org.hattrickscoreboard.database.models.match.Match;

import java.util.ArrayList;

public class HattrickCompo {

    static String TAG = (HattrickCompo.class).getSimpleName();

    public static void Compo(Activity activity, ColorTheme theme,
                             LinearLayout llcompo, Match match, ArrayList<LineUp> homeLineUp,
                             ArrayList<LineUp> awayLineUp) {

        // Clear all
        llcompo.removeAllViews();

        // Goal Keeper
        // Create line
        LinearLayout lineHomeGK = createLine(activity, llcompo);
        // Add card
        LinearLayout lcH100 = createCard(activity, lineHomeGK);

        // Defenders
        // Create line
        LinearLayout lineHomeDef = createLine(activity, llcompo);

        // Add card
        LinearLayout lcH101 = createCard(activity, lineHomeDef);
        LinearLayout lcH102 = createCard(activity, lineHomeDef);
        LinearLayout lcH103 = createCard(activity, lineHomeDef);
        LinearLayout lcH104 = createCard(activity, lineHomeDef);
        LinearLayout lcH105 = createCard(activity, lineHomeDef);

        // Middle
        // Create line
        LinearLayout lineHomeMid = createLine(activity, llcompo);
        // Add card
        LinearLayout lcH106 = createCard(activity, lineHomeMid);
        LinearLayout lcH107 = createCard(activity, lineHomeMid);
        LinearLayout lcH108 = createCard(activity, lineHomeMid);
        LinearLayout lcH109 = createCard(activity, lineHomeMid);
        LinearLayout lcH110 = createCard(activity, lineHomeMid);

        // Forward
        // Create line
        LinearLayout lineHomeFor = createLine(activity, llcompo);
        // Add card
        LinearLayout lcH111 = createCard(activity, lineHomeFor);
        LinearLayout lcH112 = createCard(activity, lineHomeFor);
        LinearLayout lcH113 = createCard(activity, lineHomeFor);

        if (homeLineUp != null) {
            for (LineUp player : homeLineUp) {

                addplayer(player, HMatchRoleID.KEEPER, lcH100);
                addplayer(player, HMatchRoleID.RIGHT_BACK, lcH101);
                addplayer(player, HMatchRoleID.RIGHT_CENTRAL_DEFENDER, lcH102);
                addplayer(player, HMatchRoleID.MIDDLE_CENTRAL_DEFENDER, lcH103);
                addplayer(player, HMatchRoleID.LEFT_CENTRAL_DEFENDER, lcH104);
                addplayer(player, HMatchRoleID.LEFT_BACK, lcH105);

                addplayer(player, HMatchRoleID.RIGHT_WINGER, lcH106);
                addplayer(player, HMatchRoleID.RIGHT_INNER_MIDFIELD, lcH107);
                addplayer(player, HMatchRoleID.MIDDLE_INNER_MIDFIELD, lcH108);
                addplayer(player, HMatchRoleID.LEFT_INNER_MIDFELD, lcH109);
                addplayer(player, HMatchRoleID.LEFT_WINGER, lcH110);

                addplayer(player, HMatchRoleID.RIGHT_FORWARD, lcH111);
                addplayer(player, HMatchRoleID.MIDDLE_FORWARD, lcH112);
                addplayer(player, HMatchRoleID.LEFT_FORWARD, lcH113);

            }
        }
        // ////////////

        // Forward
        // Create line
        LinearLayout lineAwayFor = createLine(activity, llcompo);
        // Add card
        LinearLayout lcA111 = createCard(activity, lineAwayFor);
        LinearLayout lcA112 = createCard(activity, lineAwayFor);
        LinearLayout lcA113 = createCard(activity, lineAwayFor);

        // Middle
        // Create line
        LinearLayout lineAwayMid = createLine(activity, llcompo);
        // Add card
        LinearLayout lcA106 = createCard(activity, lineAwayMid);
        LinearLayout lcA107 = createCard(activity, lineAwayMid);
        LinearLayout lcA108 = createCard(activity, lineAwayMid);
        LinearLayout lcA109 = createCard(activity, lineAwayMid);
        LinearLayout lcA110 = createCard(activity, lineAwayMid);

        // Defenders
        // Create line
        LinearLayout lineAwayDef = createLine(activity, llcompo);

        // Add card
        LinearLayout lcA101 = createCard(activity, lineAwayDef);
        LinearLayout lcA102 = createCard(activity, lineAwayDef);
        LinearLayout lcA103 = createCard(activity, lineAwayDef);
        LinearLayout lcA104 = createCard(activity, lineAwayDef);
        LinearLayout lcA105 = createCard(activity, lineAwayDef);

        // Goal Keeper
        // Create line
        LinearLayout lineAwayGK = createLine(activity, llcompo);
        // Add card
        LinearLayout lcA100 = createCard(activity, lineAwayGK);

        if (awayLineUp != null) {
            for (LineUp player : awayLineUp) {

                addplayer(player, HMatchRoleID.KEEPER, lcA100);
                addplayer(player, HMatchRoleID.RIGHT_BACK, lcA101);
                addplayer(player, HMatchRoleID.RIGHT_CENTRAL_DEFENDER, lcA102);
                addplayer(player, HMatchRoleID.MIDDLE_CENTRAL_DEFENDER, lcA103);
                addplayer(player, HMatchRoleID.LEFT_CENTRAL_DEFENDER, lcA104);
                addplayer(player, HMatchRoleID.LEFT_BACK, lcA105);

                addplayer(player, HMatchRoleID.RIGHT_WINGER, lcA106);
                addplayer(player, HMatchRoleID.RIGHT_INNER_MIDFIELD, lcA107);
                addplayer(player, HMatchRoleID.MIDDLE_INNER_MIDFIELD, lcA108);
                addplayer(player, HMatchRoleID.LEFT_INNER_MIDFELD, lcA109);
                addplayer(player, HMatchRoleID.LEFT_WINGER, lcA110);

                addplayer(player, HMatchRoleID.RIGHT_FORWARD, lcA111);
                addplayer(player, HMatchRoleID.MIDDLE_FORWARD, lcA112);
                addplayer(player, HMatchRoleID.LEFT_FORWARD, lcA113);

            }
        }
    }

    private static LinearLayout createLine(Activity activity,
                                           LinearLayout llcompo) {

        LinearLayout llLine = new LinearLayout(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        llLine.setOrientation(LinearLayout.HORIZONTAL);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;

        layoutParams.setMargins(
                activity.getResources().getDimensionPixelSize(
                        R.dimen.margin_layout),
                activity.getResources().getDimensionPixelSize(
                        R.dimen.margin_layout),
                activity.getResources().getDimensionPixelSize(
                        R.dimen.margin_layout), activity.getResources()
                        .getDimensionPixelSize(R.dimen.margin_layout));

        llcompo.addView(llLine, layoutParams);

        return llLine;

    }

    private static LinearLayout createCard(Activity activity, LinearLayout line) {
        LinearLayout llCard = (LinearLayout) activity.getLayoutInflater()
                .inflate(R.layout.row_compo, null);
        llCard.setVisibility(View.INVISIBLE);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(
                activity.getResources().getDimensionPixelSize(
                        R.dimen.margin_layout), 0, activity.getResources()
                        .getDimensionPixelSize(R.dimen.margin_layout), 0);

        line.addView(llCard, layoutParams);
        return llCard;
    }

    private static void populatePlayer(LinearLayout llCard, LineUp player) {

        llCard.setVisibility(View.VISIBLE);

        // Name
        TextView tvPlayerName = (TextView) llCard
                .findViewById(R.id.tvPlayerName);
        tvPlayerName.setText(player.getLastName());

        // Stars
        TextView tvStars = (TextView) llCard.findViewById(R.id.tvStars);
        tvStars.setText("" + player.getRatingStars());

        ImageView ivCaptain = (ImageView) llCard.findViewById(R.id.ivCaptain);
        if (!player.isCaptain()) {
            ivCaptain.setVisibility(View.INVISIBLE);
        }

        ImageView ivSetPieces = (ImageView) llCard.findViewById(R.id.ivSP);
        if (!player.isSetPieces()) {
            ivSetPieces.setVisibility(View.INVISIBLE);
        }

        llCard.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            }
        });

    }

    private static void addplayer(LineUp player, int roleID, LinearLayout llcard) {
        if (player.getRoleID() == roleID) {
            populatePlayer(llcard, player);
        }
    }
}
