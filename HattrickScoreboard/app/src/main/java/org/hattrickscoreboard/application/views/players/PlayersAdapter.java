package org.hattrickscoreboard.application.views.players;

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
import org.hattrickscoreboard.database.models.DPlayer;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 14 august 2014
 */
public class PlayersAdapter extends BaseAdapter {

    @SuppressWarnings("unused")
    private static final String TAG = (PlayersAdapter.class).getSimpleName();

    private ArrayList<DPlayer> playerslist;
    private Context context;

    public PlayersAdapter(Context context, ArrayList<DPlayer> players,
                          FragmentManager fm) {
        this.context = context;
        this.playerslist = players;
    }

    @Override
    public int getCount() {
        return playerslist.size();
    }

    @Override
    public DPlayer getItem(int item) {
        return playerslist.get(item);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Prepare view holder
        PlayersHolder playersHolder;
        DPlayer player = playerslist.get(position);

        // if (convertView == null) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.players_row, parent, false);

        // well set up the ViewHolder
        playersHolder = new PlayersHolder(context);

        playersHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
        playersHolder.tvAge = (TextView) convertView.findViewById(R.id.tvAge);
        playersHolder.tvForm = (TextView) convertView.findViewById(R.id.tvForm);
        playersHolder.tvInjuryLevel = (TextView) convertView
                .findViewById(R.id.tvInjuryLevel);
        playersHolder.llStars = (LinearLayout) convertView
                .findViewById(R.id.llStars);

        playersHolder.ivFlag = (ImageView) convertView
                .findViewById(R.id.ivFlag);
        playersHolder.ivCards = (ImageView) convertView
                .findViewById(R.id.ivCard);
        playersHolder.ivTransfer = (ImageView) convertView
                .findViewById(R.id.ivTransfer);
        playersHolder.ivInjury = (ImageView) convertView
                .findViewById(R.id.ivInjury);
        playersHolder.ivAvatar = (ImageView) convertView
                .findViewById(R.id.ivAvatar);

        // store the holder with the view.
        // convertView.setTag(playersHolder);
        convertView.setTag(player.getPlayerID());

        // } else {
        // playersHolder = (PlayersHolder) convertView.getTag();
        // }

        // Set values

        playersHolder.playerID = player.getPlayerID();
        playersHolder.setAge(player.getAge(), player.getAgeDays(),
                player.getTSI());
        playersHolder.setAvatar(player.getTeamId(), player.getPlayerID());
        playersHolder.setCards(player.getCards());
        playersHolder.setFlag(player.getCountryID());
        playersHolder.setForm(player.getForm());
        playersHolder.setInjury(player.getInjuryLevel());
        playersHolder.setName(player.getNumber(), player.getFirstname(),
                player.getNickname(), player.getLastName());
        playersHolder.setStars(player.getLastMatchRating());
        playersHolder.setTransfer(player.isTransferListed());

        return convertView;
    }
}
