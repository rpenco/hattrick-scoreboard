package org.hattrickscoreboardl.ui.views.players;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.ui.utils.FlagDrawable;
import org.hattrickscoreboardl.utils.HattrickPlayerStars;

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
        tvAge.setText(context.getString(R.string.players_age_ageday, age, ageday,
                formatNumber(tsi)));
    }

    public void setForm(int form) {
        String[] skill = context.getResources().getStringArray(
                R.array.hattrick_skills);
        tvForm.setText(context.getString(R.string.players_form,
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
            ivCards.setImageResource(R.drawable.ic_event_510_511_yellow);
        } else if (cards == 2) {
            ivCards.setImageResource(R.drawable.ic_event_512_513_yellow_red);
        } else if (cards == 3) {
            ivCards.setImageResource(R.drawable.ic_event_514_red);
        }
    }

    public void setTransfer(boolean istransferlisted) {
        if (!istransferlisted) {
            ivTransfer.setVisibility(View.INVISIBLE);
        }
    }

    public void setInjury(int injury) {
        switch (injury){
            case -1:
                ivInjury.setVisibility(View.GONE);
                tvInjuryLevel.setVisibility(View.GONE);
                break;
            case 0:
                ivInjury.setImageResource(R.drawable.ic_event_90_94_injury_playing);
                tvInjuryLevel.setVisibility(View.GONE);
                break;
            default:
                ivInjury.setImageResource(R.drawable.ic_injury);
                tvInjuryLevel.setText(Integer.toString(injury));
        }
    }

    public void setAvatar(int teamID, int playerID) {

/*        Bitmap bm = FileToImage.fileToBitmap(context.getCacheDir()
                + "/avatars/avatar_" + playerID + ".png");
        if (bm != null) {
            ivAvatar.setImageBitmap(bm);
        }*/
    }

    public void setStars(double startStars, double endStarts) {

        View v = HattrickPlayerStars.draw(context, startStars, endStarts);
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