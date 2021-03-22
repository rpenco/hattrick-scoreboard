package org.hattrickscoreboard.application.views.player;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.graphics.statics.FileToImage;
import org.hattrickscoreboard.application.utils.graphics.statics.FlagDrawable;
import org.hattrickscoreboard.background.tasks.tables.PlayersUpdate;
import org.hattrickscoreboard.background.tasks.tables.TeamUpdate;
import org.hattrickscoreboard.database.models.DPlayer;
import org.hattrickscoreboard.database.relations.RPlayer;

public class PlayerHeadFragment extends HattrickFragment {

    static final String TAG = (PlayerHeadFragment.class).getSimpleName();

    int playerID;

    private RPlayer rPlayer;

    public final PlayerHeadFragment newInstance(int playerID) {
        PlayerHeadFragment f = new PlayerHeadFragment();
        f.playerID = playerID;
        return f;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Launch task
        PlayerTask task = new PlayerTask(getActivity(), this);
        task.execute(playerID);
    }

    @Override
    public void onTaskFinish(Object result) {
        super.onTaskFinish(result);

        rPlayer = (RPlayer) result;

        if (rPlayer == null)
            return;

        setStubLayout(R.layout.fragment_player_head);

        // Populate all
        onPopulateView();
    }

    @Override
    protected void onPopulateView() {
        super.onPopulateView();

        DPlayer player = rPlayer.getPlayer();

        // Prevent back action which close view
        if (getFragmentView() == null)
            return;

        // Get resources
        TextView tvLastName = (TextView) getFragmentView().findViewById(
                R.id.tvLastName);
        TextView tvFirstName = (TextView) getFragmentView().findViewById(
                R.id.tvFistName);
        TextView tvNickName = (TextView) getFragmentView().findViewById(
                R.id.tvNickName);

        TextView tvInjury = (TextView) getFragmentView().findViewById(
                R.id.tvInjuryLevel);

        ImageView ivAvatar = (ImageView) getFragmentView().findViewById(
                R.id.ivAvatar);

        ImageView ivFlag = (ImageView) getFragmentView().findViewById(
                R.id.ivFlag);

        ImageView ivInjury = (ImageView) getFragmentView().findViewById(
                R.id.ivInjury);

        ImageView ivTransfer = (ImageView) getFragmentView().findViewById(
                R.id.ivTransfer);

        ImageView ivCards = (ImageView) getFragmentView().findViewById(
                R.id.ivCard);

        // Last name
        // if (player.getNumber() != 100) {
        // tvLastName
        // .setText(player.getNumber() + ". " + player.getLastName());
        // } else {
        tvLastName.setText(player.getLastName());
        // }

        // Nickname
        if (player.getNickname() != null) {
            tvNickName.setText(player.getNickname());
        } else {
            tvNickName.setVisibility(View.GONE);
        }

        // First name
        tvFirstName.setText(player.getFirstname());

        // Avatar
        Bitmap bm = FileToImage.fileToBitmap(getActivity().getCacheDir()
                + "/avatars/avatar_" + playerID + ".png");
        if (bm != null) {
            ivAvatar.setImageBitmap(bm);
        }

        // Injury
        if (player.getInjuryLevel() == -1) {
            ivInjury.setVisibility(View.GONE);
        } else if (player.getInjuryLevel() > 0) {
            ivInjury.setImageResource(R.drawable.ic_injury);
            tvInjury.setText(Integer.toString(player.getInjuryLevel()));
        }

        // Transfer
        if (!player.isTransferListed()) {
            ivTransfer.setVisibility(View.GONE);
        }

        // Cards
        if (player.getCards() == 0) {
            ivCards.setVisibility(View.GONE);
        } else if (player.getCards() == 1) {
            ivCards.setImageResource(R.drawable.ic_yellow_card);
        } else if (player.getCards() == 2) {
            ivCards.setImageResource(R.drawable.ic_yellow_double_card);
        } else if (player.getCards() == 3) {
            ivCards.setImageResource(R.drawable.ic_red_card);
        }

        // Country
        Drawable d = FlagDrawable.getFlag(getActivity(), player.getCountryID());
        if (d != null) {
            ivFlag.setImageDrawable(d);
        }
    }

    @Override
    public void onServiceUpdated(int code, String from) {
        super.onServiceUpdated(code, from);

        if (from.equals(TeamUpdate.FROM) || from.equals(PlayersUpdate.FROM)) {

            // Launch task
            PlayerTask task = new PlayerTask(getActivity(), this);
            task.execute(playerID);
        }
    }
}