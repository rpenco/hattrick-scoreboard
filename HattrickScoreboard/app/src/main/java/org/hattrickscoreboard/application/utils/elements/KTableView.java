package org.hattrickscoreboard.application.utils.elements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TableLayout;
import android.widget.TextView;

import org.hattrickscoreboard.R;
import org.hattrickscoreboard.application.utils.ColorTheme;

public class KTableView {

    TableLayout.LayoutParams tableParams;
    TableLayout tableLayout;
    Context ctx;
    ColorTheme colorTheme;

    String title;
    View view;

    public void createTableView(Context context, int rgbColor, View v) {
        ctx = context;
        view = v;
        colorTheme = new ColorTheme(rgbColor);

    }

    public void addTitle(String cell1) {

        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row_title, null);

        // Set title
        TextView label = (TextView) v.findViewById(R.id.tvLabel);

        label.setText(cell1);
        ((ViewGroup) view).addView(v);
    }

    public View addRow(String cell1, String cell2, Boolean colored,
                       Boolean cell2Clickable, int resourceColor) {

        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row_table, null);

        TextView label = (TextView) v.findViewById(R.id.tvLabel);
        TextView value = (TextView) v.findViewById(R.id.tvValue);

        label.setText(cell1);

        if (cell2 != null)
            value.setText(cell2);

        if (colored) {
            value.setTextColor(colorTheme.getRGB());
        }

        // If custom color
        if (resourceColor > 0) {
            value.setTextColor(ctx.getResources().getColorStateList(
                    resourceColor));
        }

        ((ViewGroup) view).addView(v);

        return v;
    }

    public void addRowColor(String cell1, String cell2, int resourceColor) {
        addRow(cell1, cell2, false, false, resourceColor);
    }

    public void addRow(String cell1, String cell2, Boolean colored) {
        addRow(cell1, cell2, colored, false, -1);
    }

    public void addRow(String cell1) {
        addRow(cell1, null, false, false, -1);
    }

    public void addRow(String cell1, String cell2) {
        addRow(cell1, cell2, false, false, -1);
    }

    public void addRow(int stringResource, String cell2) {
        addRow(ctx.getString(stringResource), cell2, false, false, -1);
    }

    public void addRowColored(String cell1, String cell2) {
        addRow(cell1, cell2, true, false, -1);
    }

    public void addRowColored(int stringResource, String cell2) {
        addRow(ctx.getString(stringResource), cell2, true, false, -1);
    }

    public void addCheckboxRow(int resourceID, boolean checked,
                               OnCheckedChangeListener onCheckedChangeListener) {

        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row_checkbox, null);

        CheckBox checkbox = (CheckBox) v.findViewById(R.id.checkBox);

        // Set text
        checkbox.setText(ctx.getString(resourceID));

        // Default value
        checkbox.setChecked(checked);

        checkbox.setOnCheckedChangeListener(onCheckedChangeListener);
        ((ViewGroup) view).addView(v);

    }

    @SuppressWarnings("deprecation")
    public void addRowColored(String cell1, String cell2,
                              OnClickListener onClickListener) {

        View v = addRow(cell1, cell2, true, true, -1);
        v.setBackgroundDrawable(ctx.getResources().getDrawable(
                R.drawable.button_listview));
        v.setOnClickListener(onClickListener);

    }
}
