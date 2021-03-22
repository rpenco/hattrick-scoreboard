package org.hattrickscoreboard.application.utils.elements;

import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Khips
 * @since 30 march 2014
 */
public class TextViewColored {

    String colorLabel = "#333";
    String colorValue;
    String colorText = "#2C2B29";
    String colorText2 = "grey";

    TextView textView;
    ArrayList<String> elements = new ArrayList<String>();

    public TextViewColored(View view, int colorValue) {
        this.colorValue = String.format("#%06X", (0xFFFFFF & colorValue));
        this.textView = (TextView) view;
    }

    public TextViewColored addLabel(String label) {
        elements.add("<font color='" + colorLabel + "'>" + label + "</font>");
        return this;
    }

    public TextViewColored addValue(String value) {
        elements.add("<font color='" + colorValue + "'>" + value + "</font>");
        return this;
    }

    public TextViewColored addText(String text) {
        elements.add("<font color='" + colorText + "'>" + text + "</font>");
        return this;
    }

    public TextViewColored addText2(String text) {
        elements.add("<font color='" + colorText2 + "'>" + text + "</font>");
        return this;
    }

    String toText() {
        String listString = "";

        for (String s : elements) {
            listString += s + " ";
        }
        return listString;
    }

    public void setText() {
        if (textView != null)
            textView.setText(Html.fromHtml(toText()),
                    TextView.BufferType.SPANNABLE);
    }

    public void setVisibility(int visibility) {
        textView.setVisibility(visibility);
    }

    public TextView getTextView() {
        return textView;
    }

}
