package org.hattrickscoreboard.application.views.player;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.hattrickscoreboard.application.views.player.workers.HattrickSkillBar;
import org.hattrickscoreboard.database.models.DPlayer;

public class PlayerSkills {

    DPlayer player;
    Activity ctx;
    String[] skills;

    public PlayerSkills(Activity context, DPlayer player) {
        this.ctx = context;
        this.player = player;
        skills = ctx.getResources().getStringArray(R.array.hattrick_skills);
    }

    public void draw(LinearLayout llparent) {

        // Create background container
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout container = (LinearLayout) inflater.inflate(
                R.layout.view_container, null);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams
                .setMargins(
                        ctx.getResources().getDimensionPixelSize(
                                R.dimen.margin_layout),
                        ctx.getResources().getDimensionPixelSize(
                                R.dimen.margin_layout),
                        ctx.getResources().getDimensionPixelSize(
                                R.dimen.margin_layout), ctx.getResources()
                                .getDimensionPixelSize(R.dimen.margin_layout));

        llparent.addView(container, layoutParams);

        // Add title
        Preferences pref = new Preferences(ctx);
        KTableView tb = new KTableView();
        tb.createTableView(ctx, pref.getRGBColor(), container);

        tb.addTitle(ctx.getString(R.string.player_label_caracteristics)
                .toUpperCase());

        // Create bar skill
        createStatBar(container, R.string.player_label_keeper,
                player.getKeeperSkill(), skills.length);
        createStatBar(container, R.string.player_label_defenser,
                player.getDefenderSkill(), skills.length);
        createStatBar(container, R.string.player_label_playmaker,
                player.getPlaymakerSkill(), skills.length);
        createStatBar(container, R.string.player_label_winger,
                player.getWingerSkill(), skills.length);
        createStatBar(container, R.string.player_label_passing,
                player.getPassingSkill(), skills.length);
        createStatBar(container, R.string.player_label_scorer,
                player.getScorerSkill(), skills.length);
        createStatBar(container, R.string.player_label_setpieces,
                player.getSetpiecesSkill(), skills.length);

    }

    private void createStatBar(LinearLayout parent, int resString,
                               final int value, int max) {

        // Get colors
        Preferences pref = new Preferences(ctx);
        ColorTheme theme = new ColorTheme(pref.getRGBColor());

        // Create layout
        RelativeLayout llStat = (RelativeLayout) ctx.getLayoutInflater()
                .inflate(R.layout.row_skill, null);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        layoutParams
                .setMargins(
                        ctx.getResources().getDimensionPixelSize(
                                R.dimen.margin_layout),
                        ctx.getResources().getDimensionPixelSize(
                                R.dimen.margin_layout),
                        ctx.getResources().getDimensionPixelSize(
                                R.dimen.margin_layout), ctx.getResources()
                                .getDimensionPixelSize(R.dimen.margin_layout));

        parent.addView(llStat, layoutParams);

        // Populate
        TextView tvSkill = (TextView) llStat.findViewById(R.id.tvSkill);
        TextView tvValue = (TextView) llStat.findViewById(R.id.tvValue);
        ImageView ivProgress = (ImageView) llStat.findViewById(R.id.ivProgress);

        // Set values
        tvSkill.setText(resString);
        tvValue.setText("(" + value + ")");

        // Get bitmap
        Bitmap progress = HattrickSkillBar.StatBar(ctx, theme, value, max);
        ivProgress.setImageBitmap(progress);

        llStat.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, skills[value], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
