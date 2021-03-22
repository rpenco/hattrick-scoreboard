package org.hattrickscoreboardl.ui.views.players;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.players.HPlayer;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.abstracts.HFragment;

import java.util.List;


public final class PlayersFragment extends HFragment {

    static final String TAG = (PlayersFragment.class).getSimpleName();

    HTeam team;
    List<HPlayer> players;
    HPlayer trainer;

    public static PlayersFragment newInstance(HTeam team) {
        PlayersFragment fragment = new PlayersFragment();
        fragment.team = team;
        return fragment;
    }

    @Override
    protected boolean onPrepareData() {

        /////////////////////////////
        //Get data from DB

        if(team != null) {

            players = HPlayer.find(HPlayer.class, "TEAM_ID = ?", String.valueOf(team.getTeamID()));
            if(players == null){
                return false;
            }
        }else{
            return false;
        }
        return true;
    }

    @Override
    protected View onDisplayData() {



        //////////////////////////////////////////
        //Layout Container

        ListView playerList = new ListView(getActivity());
        playerList.setBackgroundResource(R.color.contentBackground);

        PlayersAdapter playersAdapter = new PlayersAdapter(getActivity(),
                players, getFragmentManager());

        playerList.setAdapter(playersAdapter);
        playerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int arg2,
                                    long arg3) {

                // Start player page
                /*Intent i = new Intent(view.getContext(), PlayerActivity.class);
                i.putExtra(PlayerActivity.PLAYERID, (int) view.getTag());
                startActivityForResult(i, 0);*/

            }
        });


        return  playerList;
    }


}
