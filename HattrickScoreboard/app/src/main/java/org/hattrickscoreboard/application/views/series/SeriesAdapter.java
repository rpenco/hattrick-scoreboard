package org.hattrickscoreboard.application.views.series;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.database.models.DSeries;

import java.util.ArrayList;

public class SeriesAdapter extends BaseAdapter {

    @SuppressWarnings("unused")
    private static final String TAG = (SeriesAdapter.class).getSimpleName();

    public ArrayList<DSeries> leaguelist;
    private Context context;
    private int teamID;

    public SeriesAdapter(Context context, int teamID,
                         ArrayList<DSeries> league, FragmentManager fm) {
        this.context = context;
        this.leaguelist = league;
        this.teamID = teamID;
    }

    @Override
    public int getCount() {
        if (leaguelist != null)
            return leaguelist.size();
        return 0;
    }

    @Override
    public DSeries getItem(int item) {
        return leaguelist.get(item);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Prepare view holder
        SeriesHolder seriesHolder;

//		if (convertView == null) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_serieslist, parent,
                false);

        // well set up the ViewHolder
        seriesHolder = new SeriesHolder(context);

        seriesHolder.tvPos = (TextView) convertView
                .findViewById(R.id.tvPos);
        seriesHolder.tvName = (TextView) convertView
                .findViewById(R.id.tvName);
        seriesHolder.tvMatches = (TextView) convertView
                .findViewById(R.id.tvMatches);
        seriesHolder.tvGoals = (TextView) convertView
                .findViewById(R.id.tvGoals);
        seriesHolder.tvDiff = (TextView) convertView
                .findViewById(R.id.tvDiff);
        seriesHolder.tvPts = (TextView) convertView
                .findViewById(R.id.tvPts);
        seriesHolder.ivPos = (ImageView) convertView
                .findViewById(R.id.ivPos);
        seriesHolder.ivLogo = (ImageView) convertView
                .findViewById(R.id.ivLogoBadge);

        // store the holder with the view.
        convertView.setTag(seriesHolder);

        // } else {
        // seriesHolder = (SeriesHolder) convertView.getTag();
        // }

        // Set values
        DSeries team = leaguelist.get(position);

        seriesHolder.consultedTeamID(teamID);
        seriesHolder.teamID = team.getTeamID();
        seriesHolder.setPos(team.getPosition(), team.getPositionChange());
        seriesHolder.setName(team.getTeamName());
        seriesHolder.setMatches(team.getMatches());
        seriesHolder.setGoals(team.getGoalsFor(), team.getGoalsAgainst());
        seriesHolder.setDiff(team.getGoalsFor(), team.getGoalsAgainst());
        seriesHolder.setPts(team.getPoints());
        seriesHolder.setLogo(team.getTeamID());
        return convertView;
    }

}
