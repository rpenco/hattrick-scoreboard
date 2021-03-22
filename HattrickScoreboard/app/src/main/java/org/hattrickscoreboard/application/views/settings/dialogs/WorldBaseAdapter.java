package org.hattrickscoreboard.application.views.settings.dialogs;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.graphics.statics.FlagDrawable;
import org.hattrickscoreboard.database.models.DWorld;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 15 aot 2014
 */
public class WorldBaseAdapter extends ArrayAdapter<DWorld> {

    ArrayList<DWorld> worlds;
    LayoutInflater mInflater;
    Activity ctx;
    DWorld worldSelected;
    OnClickListener onClickListener;

    public WorldBaseAdapter(Activity activity, ArrayList<DWorld> worlds,
                            DWorld worldSelected, OnClickListener onClickListener) {
        super(activity, R.layout.row_worlds, worlds);
        this.worlds = worlds;
        this.ctx = activity;
        this.worldSelected = worldSelected;
        this.onClickListener = onClickListener;
    }

    @Override
    public int getCount() {
        return worlds.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public DWorld getItem(int arg0) {
        return worlds.get(arg0);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup arg2) {

        WorldHolder holder;

        if (convertView == null) {
            LayoutInflater mInflater = ctx.getLayoutInflater();
            convertView = mInflater.inflate(R.layout.row_worlds, null);
            holder = new WorldHolder();

            holder.tvWorldName = (TextView) convertView
                    .findViewById(R.id.tvWorldName);
            holder.tvWorldLine1 = (TextView) convertView
                    .findViewById(R.id.tvWorldLine1);
            holder.tvWorldLine2 = (TextView) convertView
                    .findViewById(R.id.tvWorldLine2);

            holder.tvWorldName = (TextView) convertView
                    .findViewById(R.id.tvWorldName);

            holder.ivWorldFlag = (ImageView) convertView
                    .findViewById(R.id.ivWorldFlag);

            holder.cbSelected = (CheckBox) convertView
                    .findViewById(R.id.cbSelected);
            convertView.setTag(holder);

        } else {
            holder = (WorldHolder) convertView.getTag();
        }

        DWorld world = worlds.get(pos);

        holder.world = world;

        holder.tvWorldName.setText(world.getCountryName().toUpperCase());
        holder.tvWorldLine1.setText("Devise: " + world.getCurrencyName());
        holder.tvWorldLine2.setText("Format: "
                + world.getDateFormat().toLowerCase() + " "
                + world.getTimeFormat().toLowerCase());

        holder.cbSelected.setChecked((world.getCountryID() == worldSelected
                .getCountryID()));

        Drawable d = FlagDrawable.getFlag(ctx, world.getCountryID());
        if (d != null) {
            holder.ivWorldFlag.setImageDrawable(d);
        }

        convertView.setOnClickListener(onClickListener);
        return convertView;

    }


}