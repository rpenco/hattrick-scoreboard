package org.hattrickscoreboard.application.extended.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;

import org.hattrickscoreboard.HattrickApplication;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.background.constant.Background;
import org.hattrickscoreboard.background.services.BackgroundService;
import org.khips.extensions.progressbars.ButteryProgressBar;

/**
 * @author Khips
 * @since 23 april 2014
 */
public class HattrickFragment extends HFragment implements FragmentTaskListener {

    static final String TAG = (HattrickFragment.class).getSimpleName();
    /**
     * Broadcast receiver from intent service
     */
    BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null) {
                if (intent.getExtras() != null) {

                    // Get Code
                    int code = intent.getExtras().getInt(
                            BackgroundService.RESULT);

                    // Get process from
                    String from = intent.getExtras().getString(
                            BackgroundService.FROM);

                    Log.i(TAG, "Broadcast code: " + code + " from: " + from);

                    // Notify
                    if (code == Background.RESULT_START) {
                        onServiceStartUpdate(code, from);
                    } else {
                        onServiceUpdated(code, from);
                    }

                }
            }

        }
    };
    // For loading view
    private ViewStub stub;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate fragment stub
        view = inflater.inflate(R.layout.fragment_loading, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get id stub
        stub = ((ViewStub) view.findViewById(R.id.stub_import));
    }

    /**
     * Change layout before populate view
     *
     * @param layout
     */
    protected void setStubLayout(int layout) {

        // Define new next layout
        if (stub != null) {
            stub.setLayoutResource(layout);
        }
    }

    /**
     * Call it for change layout and populate view. Call setStubLayout before...
     */
    protected void onPopulateView() {

        // Display new layout
        if (stub == null) {
            Log.v(TAG, "Failed to find stubview.");
            if (view == null) {
                Log.v(TAG, "Failed to find view.");
            }
            return;
        } else {

            // Suppress loading image
            final ProgressBar ivBackLoading = ((ProgressBar) view
                    .findViewById(R.id.pb_loading));
            if (getActivity() != null) {
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if (ivBackLoading != null) {
                            ivBackLoading.setVisibility(View.GONE);
                        }
                    }
                });

                // Display new layout
                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        if (stub != null)
                            view = stub.inflate();
                    }
                });
            }
            // Delete stub after inflate (else crash)
            stub = null;

        }

    }

    /**
     * Get fragment view
     *
     * @return
     */
    protected View getFragmentView() {
        return view;
    }

    // ////////////////////////////////////

    /**
     * Get stub view
     *
     * @return
     */
    protected View getStubView() {
        return stub;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (receiver != null) {
            getActivity().registerReceiver(receiver,
                    new IntentFilter(BackgroundService.INTENT));
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (receiver != null) {
            getActivity().unregisterReceiver(receiver);
        }
    }

    @Override
    public void onTaskStart() {
        Log.v(TAG, "task started...");
        startProgressBar();
    }

    @Override
    public void onTaskFinish(Object result) {
        Log.v(TAG, "...task finished ");
        stopProgressBar();
    }

    public void onServiceStartUpdate(int code, String from) {
        Log.v(TAG, "Services started...: " + from);
        startProgressBar();
    }

    public void onServiceUpdated(int code, String from) {
        Log.v(TAG, "...Service updated: " + from);
        stopProgressBar();
    }

    /**
     * Display loading progress bar on action bar
     */
    private void startProgressBar() {

        int nbProgress = 0;
        if (getActivity() != null) {
            if (((HattrickApplication) getActivity().getApplication()) != null) {
                nbProgress = ((HattrickApplication) getActivity()
                        .getApplication()).progressAddOne();
            }
        }

        if (nbProgress > 0) {
            if (getActivity() != null) {
                ButteryProgressBar progressBar = (ButteryProgressBar) getActivity()
                        .findViewById(R.id.action_progressbar);
                if (progressBar != null) {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    /**
     * Hide loading progress bar on action bar
     */
    private void stopProgressBar() {

        int nbProgress = 0;
        if (getActivity() != null) {
            if (((HattrickApplication) getActivity().getApplication()) != null) {
                nbProgress = ((HattrickApplication) getActivity()
                        .getApplication()).progressRemoveOne();
            }
        }

        if (nbProgress == 0) {

            if (getActivity() != null) {
                ButteryProgressBar progressBar = (ButteryProgressBar) getActivity()
                        .findViewById(R.id.action_progressbar);
                if (progressBar != null) {
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        }

    }

    protected boolean displayRightFragment(Activity ctx, Bundle args,
                                           Fragment fright) {

        // Tablet format
        // Create right part if exist (Tablet!)
        View v = ctx.findViewById(R.id.content_right);
        if (v != null) {

            // Set tablet mode
            args.putBoolean("tablet", true);
            args.putBoolean("rightFragment", true);

            FragmentManager fragmentManager = ctx.getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_right, fright).commit();

            return true;
        }

        return false;
    }
}
