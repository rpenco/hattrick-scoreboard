package org.hattrickscoreboard.application.views.match;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.views.match.workers.HattrickEventIcon;
import org.hattrickscoreboard.database.models.match.Event;
import org.hattrickscoreboard.database.models.match.Match;

import java.util.ArrayList;

public class EventsAdapter extends BaseAdapter {

    static final String TAG = (EventsAdapter.class).getSimpleName();

    Match match;
    ArrayList<Event> events;

    private Context context;

    public EventsAdapter(Context context, Match match, ArrayList<Event> events,
                         FragmentManager fm) {

        this.context = context;
        this.match = match;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Event getItem(int item) {
        return events.get(item);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Prepare view holder
        EventHolder eventHolder;

        // if (convertView == null) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.row_event, parent, false);

        // well set up the ViewHolder
        eventHolder = new EventHolder(context);

        eventHolder.tvEvent = (TextView) convertView.findViewById(R.id.tvEvent);
        eventHolder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
        eventHolder.llTeamColor = (LinearLayout) convertView
                .findViewById(R.id.llTeamColor);
        eventHolder.ivEvent = (ImageView) convertView
                .findViewById(R.id.ivEvent);

        // store the holder with the view.
        convertView.setTag(eventHolder);

        // } else {
        // playersHolder = (PlayersHolder) convertView.getTag();
        // }

        // Set values
        Event event = events.get(position);

        eventHolder.setEventText(event.getEventText());
        eventHolder.setEventTime(event.getMinute());

        eventHolder.setEventIcon(HattrickEventIcon.icon(event));

        int color = 0;
        if (event.getSubjectTeamID() == match.getHomeTeamID()) {
            color = R.color.home_team;
        } else if (event.getSubjectTeamID() == match.getAwayTeamID()) {
            color = R.color.away_team;
        }

        eventHolder.setTeamColor(color);

        return convertView;
    }
}
