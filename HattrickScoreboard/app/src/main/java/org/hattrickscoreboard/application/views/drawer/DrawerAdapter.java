package org.hattrickscoreboard.application.views.drawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.graphics.LogoBadgeUploader;

import java.util.List;

/**
 * @author Khips
 * @since 4 august 2014
 */
public class DrawerAdapter extends ArrayAdapter<Drawer> {

    static final String TAG = (DrawerAdapter.class).getSimpleName();

    List<Drawer> items;
    Context context;

    public DrawerAdapter(Context context, int resource, List<Drawer> drawerItems) {
        super(context, resource, drawerItems);
        this.context = context;
        this.items = drawerItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Drawer item = items.get(position);

        View rowView;

        // ////////////////////////////////////
        // Header
        // ////////////////////////////////////

        if (item instanceof DrawerHeader) {

            DrawerHeader headerItem = (DrawerHeader) item;
            rowView = inflater.inflate(R.layout.drawer_header, parent, false);

            rowView.setTag(item.tag);
            ((TextView) rowView.findViewById(R.id.tvMenu))
                    .setText(headerItem.title);
            return rowView;
        } else

            // ////////////////////////////////////
            // User && National Team
            // ////////////////////////////////////

            if (item instanceof DrawerTeam) {

                DrawerTeam teamItem = (DrawerTeam) item;

                rowView = inflater
                        .inflate(R.layout.drawer_item_team, parent, false);

                rowView.setTag(item.tag);

                ((TextView) rowView.findViewById(R.id.tvMenu))
                        .setText(teamItem.title);
                ((TextView) rowView.findViewById(R.id.tvSubMenu))
                        .setText(teamItem.subtitle);

                ImageView ivLogo = (ImageView) rowView.findViewById(R.id.ivMenu);
                LogoBadgeUploader.upload(getContext(), ivLogo, teamItem.teamID);

            } else {

                // ////////////////////////////////////
                // Item
                // ////////////////////////////////////

                DrawerItem itemItem = (DrawerItem) item;

                rowView = inflater.inflate(R.layout.drawer_item, parent, false);
                rowView.setTag(item.tag);

                ((TextView) rowView.findViewById(R.id.tvMenu))
                        .setText(itemItem.title);

                // ImageView
                ((ImageView) rowView.findViewById(R.id.ivMenu))
                        .setImageResource(itemItem.icon);

            }

        return rowView;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Drawer getItem(int position) {
        return items.get(position);
    }

}
