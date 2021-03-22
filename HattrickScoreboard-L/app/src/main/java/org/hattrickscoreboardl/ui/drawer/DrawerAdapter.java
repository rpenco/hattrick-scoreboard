package org.hattrickscoreboardl.ui.drawer;

import android.content.Context;
import android.content.res.Resources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.hattrickscoreboardl.R;
import org.hattrickscoreboardl.database.models.nationals.HNationalTeam;
import org.hattrickscoreboardl.database.models.teams.HTeam;
import org.hattrickscoreboardl.ui.componants.HImageView;
import org.hattrickscoreboardl.ui.componants.HTextView;
import org.hattrickscoreboardl.ui.drawer.componants.Drawer;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerItem;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerNationalTeam;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerTeam;
import org.hattrickscoreboardl.ui.drawer.componants.DrawerTitle;
import org.hattrickscoreboardl.ui.views.club.components.LogoUploader;
import org.hattrickscoreboardl.utils.Dimen;

import java.util.List;

/**
 * Created by romain on 26/10/2014.
 */
public class DrawerAdapter extends ArrayAdapter {

    static final String TAG = (DrawerAdapter.class).getSimpleName();

    List<Drawer> items;

    public DrawerAdapter(Context context, int resource, List<Drawer> items) {
        super(context, resource);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Drawer d = items.get(position);

        Resources r = getContext().getResources();

        //Default dimension
        int iHeight = (int) r.getDimension(R.dimen.navigation_drawer_item_height);
        int p72 = (int) r.getDimension(R.dimen.spacing_72);
        int p16 = (int) r.getDimension(R.dimen.spacing_16);
        int p8 = (int) r.getDimension(R.dimen.spacing_8);

        int ivSize = (int) r.getDimension(R.dimen.drawer_item_imageview_size);
        int iPagging = (int) r.getDimension(R.dimen.drawer_item_imageview_inside_padding);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

        //Default team
        if(d instanceof DrawerTeam) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View v = inflater.inflate(R.layout.drawer_team, null, false);

            //Item
            DrawerTeam dTeam = (DrawerTeam) d;
            v.setTag(dTeam);

            //Team
            HTeam team = dTeam.getTeam();

            ImageView ivLogo = (ImageView) v.findViewById(R.id.ivLogo);
            TextView tvTeamName = (TextView) v.findViewById(R.id.tvTeamName);
            TextView tvSeries = (TextView) v.findViewById(R.id.tvSeries);

            tvTeamName.setText(team.getTeamName());
            tvSeries.setText(team.getPosition()+"e en "+team.getLeagueLevelUnitName());


            ivLogo.setScaleType(ImageView.ScaleType.FIT_CENTER);
            LogoUploader logoUploader = new LogoUploader();
            logoUploader.upload(getContext(),ivLogo,team);

            return v;
        }


        //Default item
        if(d instanceof DrawerItem) {

            //Layout
            LinearLayout v = new LinearLayout(getContext());
            v.setOrientation(LinearLayout.HORIZONTAL);
//            v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, iHeight));
            v.setPadding(0, 0, 0, 0);

            //Item
            DrawerItem dItem = (DrawerItem) d;
            v.setTag(dItem);

            //Icon & Text
            HImageView icon = new HImageView(getContext());
            icon.setLayoutParams(new LinearLayout.LayoutParams(ivSize, ivSize));
            icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            icon.setImageResource(dItem.getIcon());
            icon.setPadding(p16, 0, 0, 0);
            v.addView(icon);

            HTextView tv = new HTextView(getContext());
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tv.setText(dItem.getTitle());
            tv.setTextColor(getContext().getResources().getColor(R.color.textview));
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setPadding(p72,p16,0,0);

            v.addView(tv);

            return v;
        }

        //Title item
        if(d instanceof DrawerTitle) {

            LinearLayout v = new LinearLayout(getContext());
            v.setClickable(false);
            v.setLongClickable(false);
            v.setFocusable(false);
            
            //Item
            DrawerTitle dItem = (DrawerTitle) d;
            v.setTag(dItem);

            //Layout
            v.setOrientation(LinearLayout.VERTICAL);
            int p = Dimen.dimen(getContext(),R.dimen.paddingItem);
            v.setPadding(p, p, p, p);
            v.setFocusable(false);
            v.setClickable(false);

            //Head separator
            LinearLayout sep = new LinearLayout(getContext());
            sep.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            sep.setBackgroundColor(getContext().getResources().getColor(R.color.drawerTitleSeparator));
            v.addView(sep);

            //Title
            HTextView tv = new HTextView(getContext());
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tv.setText(dItem.getTitle());
            tv.setTextColor(getContext().getResources().getColor(R.color.drawerTitle));
            tv.setTextSize(Dimen.dimen(getContext(), R.dimen.drawerTitle));
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setPadding(p,p,0,p);

            v.addView(tv);
            return v;
        }



        //Default item
        if(d instanceof DrawerNationalTeam) {

            LinearLayout v = new LinearLayout(getContext());
//            v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, iHeight));
            v.setOrientation(LinearLayout.HORIZONTAL);
            v.setPadding(0, 0, 0, 0);

            //Item
            DrawerNationalTeam dItem = (DrawerNationalTeam) d;
            HNationalTeam team = dItem.getTeam();
            v.setTag(dItem);

            //Icon & Text
            HImageView icon = new HImageView(getContext());
            icon.setLayoutParams(new LinearLayout.LayoutParams(ivSize, ivSize));
            icon.setPadding(iPagging,iPagging,iPagging,iPagging);
            icon.setImageResource(R.drawable.ic_menu_national);
            v.addView(icon);

            HTextView tv = new HTextView(getContext());
            tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tv.setText("Equipe de "+team.getTeamName());
            tv.setTextColor(getContext().getResources().getColor(R.color.textview));
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setPadding(p16,0,0,0);

            v.addView(tv);

            return v;
        }

        return super.getView(position, convertView, parent);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        if(items.get(position) instanceof DrawerTitle){
            return false;
        }
        return true;
    }
}
