package org.hattrickscoreboard.application.views.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.fragments.HattrickFragment;
import org.hattrickscoreboard.application.utils.Preferences;
import org.hattrickscoreboard.application.utils.elements.KTableView;

public final class NotificationFragment extends HattrickFragment {

    @SuppressWarnings("unused")
    private static final String TAG = (NotificationFragment.class)
            .getSimpleName();
    private Preferences pref;

    public NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set new layout
        setStubLayout(R.layout.fragment_default);

        // Populate all
        onPopulateView();
    }

    @Override
    public void onPopulateView() {
        super.onPopulateView();

        View v = getFragmentView();
        if (v == null) {
            return;
        }

        pref = new Preferences(getActivity());

        // Get layout parameters
        LinearLayout llContainer = (LinearLayout) v
                .findViewById(R.id.llContainer);

        // for after update...
        llContainer.removeAllViews();

        // Create background container
        LayoutInflater inflater = (LayoutInflater) getActivity()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View container = inflater.inflate(R.layout.view_container, null);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        applyMarginLayout(layoutParams);
        llContainer.addView(container, layoutParams);

        KTableView tb = new KTableView();
        tb.createTableView(getActivity(), pref.getRGBColor(), container);

        tb.addTitle(toUpperCase(R.string.notification_title_application));

        // Economy
        tb.addCheckboxRow(R.string.notification_label_economy,
                pref.isEconomicalNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setEconomicalNotification(isChecked);
                    }
                });

        // Update training
        tb.addCheckboxRow(R.string.notification_label_training,
                pref.isTrainingNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setTrainingNotification(isChecked);
                    }
                });

        tb.addTitle(toUpperCase(R.string.notification_title_my_teams));

        // Update reminder 1h
        tb.addCheckboxRow(R.string.notification_label_remember_1hour,
                pref.isReminder1HNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setReminder1HNotification(isChecked);
                    }
                });

        // Update reminder 15m
        tb.addCheckboxRow(R.string.notification_label_remember_15min,
                pref.isReminder15MNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setReminder15MNotification(isChecked);
                    }
                });

        // Update kickoff and end of game
        tb.addCheckboxRow(R.string.notification_label_kickoff,
                pref.isKickOffNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setKickOffNotification(isChecked);
                    }
                });

        // Update Half
        tb.addCheckboxRow(R.string.notification_label_halftime,
                pref.isHalfTimeNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setHalfTimeNotification(isChecked);
                    }
                });

        // Update goals
        tb.addCheckboxRow(R.string.notification_label_goals,
                pref.isGoalNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setGoalNotification(isChecked);
                    }
                });

        // Update warning
        tb.addCheckboxRow(R.string.notification_label_cards,
                pref.isWarningNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setWarningNotification(isChecked);
                    }
                });

        // Update warning opponent
        tb.addCheckboxRow(R.string.notification_label_cards_opponent,
                pref.isWarningOppNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setWarningOppNotification(isChecked);
                    }
                });

        // Update injuries
        tb.addCheckboxRow(R.string.notification_label_injuries,
                pref.isInjuriesNotification(), new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setInjuriesNotification(isChecked);
                    }
                });

        // Update injuries opponent
        tb.addCheckboxRow(R.string.notification_label_injuries_opponent,
                pref.isInjuriesOppNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setInjuriesOppNotification(isChecked);
                    }
                });

        tb.addTitle(toUpperCase(R.string.notification_title_other_teams));

        // Update reminder 1h
        tb.addCheckboxRow(R.string.notification_label_remember_1hour,
                pref.isReminder1HFollowedNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setReminder1HFollowedNotification(isChecked);
                    }
                });

        // Update reminder 15m
        tb.addCheckboxRow(R.string.notification_label_remember_15min,
                pref.isReminder15MFollowedNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setReminder15MFollowedNotification(isChecked);
                    }
                });

        // Update kickoff and end of game
        tb.addCheckboxRow(R.string.notification_label_kickoff,
                pref.isKickOffFollowedNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setKickOffFollowedNotification(isChecked);
                    }
                });

        // Update Half
        tb.addCheckboxRow(R.string.notification_label_halftime,
                pref.isHalfTimeFollowedNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setHalfTimeFollowedNotification(isChecked);
                    }
                });

        // Update goals
        tb.addCheckboxRow(R.string.notification_label_goals,
                pref.isGoalFollowedNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setGoalFollowedNotification(isChecked);
                    }
                });

        // Update warning
        tb.addCheckboxRow(R.string.notification_label_cards,
                pref.isWarningFollowedNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setWarningFollowedNotification(isChecked);
                    }
                });

        // // Update warning opponent
        // tb.addCheckboxRow(R.string.notification_label_cards_opponent,
        // pref.isWarningOppFollowedNotification(),
        // new OnCheckedChangeListener() {
        //
        // @Override
        // public void onCheckedChanged(CompoundButton buttonView,
        // boolean isChecked) {
        // pref.setWarningOppFollowedNotification(isChecked);
        // }
        // });

        // Update injuries
        tb.addCheckboxRow(R.string.notification_label_injuries,
                pref.isInjuriesFollowedNotification(),
                new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        pref.setInjuriesFollowedNotification(isChecked);
                    }
                });

        // // Update injuries opponent
        // tb.addCheckboxRow(R.string.notification_label_injuries_opponent,
        // pref.isInjuriesOppFollowedNotification(),
        // new OnCheckedChangeListener() {
        //
        // @Override
        // public void onCheckedChanged(CompoundButton buttonView,
        // boolean isChecked) {
        // pref.setInjuriesOppFollowedNotification(isChecked);
        // }
        // });

    }
}
