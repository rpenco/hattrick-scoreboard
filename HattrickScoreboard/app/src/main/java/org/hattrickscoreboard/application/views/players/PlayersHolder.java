package org.hattrickscoreboard.application.views.players;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.graphics.statics.FileToImage;
import org.hattrickscoreboard.application.utils.graphics.statics.FlagDrawable;
import org.hattrickscoreboard.application.views.player.workers.HattrickPlayerStars;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PlayersHolder {

    int playerID;
    TextView tvName;
    TextView tvAge;
    TextView tvForm;
    TextView tvInjuryLevel;

    ImageView ivCards;
    ImageView ivTransfer;
    ImageView ivInjury;
    ImageView ivFlag;
    ImageView ivAvatar;

    LinearLayout llStars;

    Context context;
    Resources res;

    public PlayersHolder(Context context) {
        this.context = context;
        res = context.getResources();
    }

    public void setName(int number, String firstname, String nickname,
                        String lastname) {
        String str;
        if (number != 100) {
            str = number + ". " + firstname + " ";
        } else {
            str = firstname + " ";
        }
        if (nickname != null) {
            str += "'" + nickname + "' ";
        }
        str += lastname;

        tvName.setText(str);
    }

    public void setAge(int age, int ageday, int tsi) {
        tvAge.setText(context.getString(R.string.players_label_age, age, ageday,
                formatNumber(tsi)));
    }

    public void setForm(int form) {
        String[] skill = context.getResources().getStringArray(
                R.array.hattrick_skills);
        tvForm.setText(context.getString(R.string.players_label_form,
                skill[form]));
    }

    public void setFlag(int countryID) {
        Drawable d = FlagDrawable.getFlag(context, countryID);
        if (d != null) {
            ivFlag.setImageDrawable(d);
        }
    }

    public void setCards(int cards) {
        if (cards == 0) {
            ivCards.setVisibility(View.GONE);
        } else if (cards == 1) {
            ivCards.setImageResource(R.drawable.ic_yellow_card);
        } else if (cards == 2) {
            ivCards.setImageResource(R.drawable.ic_yellow_double_card);
        } else if (cards == 3) {
            ivCards.setImageResource(R.drawable.ic_red_card);
        }
    }

    public void setTransfer(boolean istransferlisted) {
        if (!istransferlisted) {
            ivTransfer.setVisibility(View.GONE);
        }
    }

    public void setInjury(int injury) {
        if (injury == -1) {
            ivInjury.setVisibility(View.GONE);
        } else if (injury > 0) {
            ivInjury.setImageResource(R.drawable.ic_injury);
            tvInjuryLevel.setText(Integer.toString(injury));
        }
    }

    public void setAvatar(int teamID, int playerID) {

        Bitmap bm = FileToImage.fileToBitmap(context.getCacheDir()
                + "/avatars/avatar_" + playerID + ".png");
        if (bm != null) {
            ivAvatar.setImageBitmap(bm);
        }
    }

    public void setStars(double lastmatchrank) {

        View v = HattrickPlayerStars.draw(context, lastmatchrank);
        llStars.addView(v);
    }

    private String formatNumber(double number) {

        DecimalFormatSymbols format = new DecimalFormatSymbols();
        format.setGroupingSeparator(' ');
        format.setDecimalSeparator(',');
        DecimalFormat value = new DecimalFormat("#,###", format);
        return value.format(number);

    }
}