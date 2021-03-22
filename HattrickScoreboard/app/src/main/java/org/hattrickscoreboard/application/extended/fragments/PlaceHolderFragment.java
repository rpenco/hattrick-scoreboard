package org.hattrickscoreboard.application.extended.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.views.drawer.DrawerSelection;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class PlaceHolderFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceHolderFragment() {
    }

    public static Fragment newInstance(int sectionNumber, Bundle bundle) {
        return DrawerSelection.selection(sectionNumber, bundle);

    }

    public static Fragment newRightInstance(int leftPosition, Bundle bundle) {

        return DrawerSelection.selectionRight(leftPosition, bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_default, container,
                false);

        return rootView;
    }

}
