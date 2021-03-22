package org.hattrickscoreboardl.ui.utils.spinners;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.hattrickscoreboardl.R;

import java.util.List;

/**
 * Created by romain
 * on 11/12/2014.
 */
public class SimpleSpinner extends Spinner {

    List<String> items;
    ArrayAdapter<String> adapter;

    public SimpleSpinner(Context context) {
        super(context);
        setInitAttributes();
    }

    private void setInitAttributes() {
        setBackgroundResource(R.drawable.background_content2);
    }

    public void setItems(List<String> items){
        this.items = items;

        adapter = new ArrayAdapter<String>(
                getContext(),android.R.layout.simple_spinner_item, items);

//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setAdapter(adapter);
    }

    public List<String> getItem(){
        return items;
    }

}
