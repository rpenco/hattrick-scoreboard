package org.hattrickscoreboard.application.views.dialogs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.hattrick.models.search.SearchRequest;
import org.hattrick.models.search.SearchResponse;
import org.hattrick.models.search.SearchResult;
import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.extended.tasks.FragmentTaskListener;
import org.hattrickscoreboard.application.utils.ColorTheme;
import org.hattrickscoreboard.application.utils.elements.KTableView;
import org.hattrickscoreboard.application.views.activities.ConsultActivity;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 29 march 2014
 */
public class SearchDialog extends DialogFragment {

    static String TAG = (SearchDialog.class).getSimpleName();

    Button dialogButton;
    Button btnSearch;
    LinearLayout llBackground;
    LinearLayout llFooter;

    TextView tvHeader;
    LinearLayout llSearch;
    LinearLayout llResult;
    EditText etSearch;
    Spinner spType;
    RadioGroup radioGroup;

    SearchRequest request;

    ColorTheme colorTheme;
    ProgressBar pbResult;
    KTableView tableView;

    public SearchDialog() {

    }

    public void setColoredTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_dialog, container);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Find
        dialogButton = (Button) view.findViewById(R.id.btnOK);
        btnSearch = (Button) view.findViewById(R.id.btnSearch);

        llBackground = (LinearLayout) view.findViewById(R.id.llBackground);
        llFooter = (LinearLayout) view.findViewById(R.id.llOK);
        llSearch = (LinearLayout) view.findViewById(R.id.llSearch);
        etSearch = (EditText) view.findViewById(R.id.etSearch);
        llResult = (LinearLayout) view.findViewById(R.id.llResult);
        spType = (Spinner) view.findViewById(R.id.spType);
        radioGroup = (RadioGroup) view.findViewById(R.id.rbParam);
        pbResult = (ProgressBar) view.findViewById(R.id.pbResult);
        tvHeader = (TextView) view.findViewById(R.id.tvHeader);

        // Set Colors
        llBackground.setBackgroundColor(colorTheme.getRGB());
        llFooter.setBackgroundColor(colorTheme.getColorDusky());
        tvHeader.setBackgroundColor(colorTheme.getColorDusky());

        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Hide progress circle
        pbResult.setVisibility(View.GONE);

        // Quit
        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dismiss();
            }
        });

        // Search
        btnSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Search..
                runHattrickSearch();
            }
        });

    }

    /**
     * Do search
     */
    private void runHattrickSearch() {

        // Remove progress and result
        clearResult();

        request = new SearchRequest();

        // Text
        String value = etSearch.getText().toString();

        // 3 characters minimum
        if (value.length() < 3) {
            displayError("Min 3 characters ...");
            return;
        }

        // Type of search
        // Debug search teams only
        int type = 4;// spType.getSelectedItemPosition();
        request.setSearchType(type);

        // Name or ID
        int rSelected = radioGroup.getCheckedRadioButtonId();

        // Name
        if (rSelected == R.id.rName) {

            // Set value
            request.setSearchString(value);

        } else { // ID

            try {
                // Set ID
                request.setSearchID(Integer.parseInt(value));

            } catch (NumberFormatException e) {
                displayError("Add number...");
                return;
            }
        }

        // Do research
        // Service
        SearchTask task = new SearchTask(getActivity(),
                new FragmentTaskListener() {

                    @Override
                    public void onTaskStart() {

                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                displaySearch();
                            }
                        });
                    }

                    @Override
                    public void onTaskFinish(final Object result) {
                        Log.v(TAG, "finish search");

                        // Remove progress bar
                        clearResult();

                        // Get result
                        final SearchResponse response = (SearchResponse) result;

                        // If not exist
                        if (response == null
                                || response.getSearchResults() == null) {
                            Log.i(TAG,
                                    "response or response.getSearchResults == null");
                            displayNoResult();
                            return;
                        }

                        // If OK
                        if (response.getSearchResults().size() > 0) {

                            displayResult(response.getSearchResults(),
                                    response.getSearchType());

                        } else {

                            Log.i(TAG, "response.getSearchResults size == 0");
                            displayNoResult();
                        }

                    }
                });
        task.execute(request);

    }

    /**
     * Display loading bar and remove all results
     */
    private void displaySearch() {

        pbResult.setVisibility(View.VISIBLE);

    }

    /**
     * Remove progress bar
     */
    private void clearResult() {
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                llResult.removeAllViews();
                pbResult.setVisibility(View.GONE);
            }
        });
    }

    private void displayNoResult() {

        tableView = new KTableView();
        tableView.createTableView(getActivity(), colorTheme.getRGB(), llResult);

        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                tableView.addRow("No result.", "");
            }
        });
    }

    private void displayError(final String value) {

        tableView = new KTableView();
        tableView.createTableView(getActivity(), colorTheme.getRGB(), llResult);
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                tableView.addRow(value, "");
            }
        });
    }

    private void displayResult(ArrayList<SearchResult> result, final int type) {

        // Create table
        tableView = new KTableView();
        tableView.createTableView(getActivity(), colorTheme.getRGB(), llResult);
        tableView.addTitle(getString(R.string.search_title_result,
                result.size()));

        for (int i = 0; i < result.size(); i++) {

            // Get result
            final SearchResult res = result.get(i);

            // Add line...
            tableView.addRowColored(res.getResultName(), "Display",
                    new OnClickListener() {

                        @Override
                        public void onClick(View v) {

                            // Start consult activity
                            Intent intent = new Intent(getActivity(),
                                    ConsultActivity.class);
                            intent.putExtra(ConsultActivity.RESULTID,
                                    res.getResultID());
                            intent.putExtra(ConsultActivity.RESULTTYPE, type);

                            // Start activity
                            startActivity(intent);

                            // Close search dialog
                            dismiss();
                        }
                    });

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
