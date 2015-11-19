package com.mikolajgralczyk.mior;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpecificSpinnerAdapter extends ArrayAdapter<ValuesForObjectsInSpinner> {

    private Context mContext;
    private ValuesForObjectsInSpinner[] mMyObjs;

    public SpecificSpinnerAdapter(Context context, int textViewResourceId, ValuesForObjectsInSpinner[] myObjs) {
        super(context, textViewResourceId, myObjs);
        this.mContext = context;
        this.mMyObjs = myObjs;
    }

    public int getCount(){
        return mMyObjs.length;
    }

    public ValuesForObjectsInSpinner getItem(int position){
        return mMyObjs[position];
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setText(mMyObjs[position].getText());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(mContext);
        label.setText(mMyObjs[position].getText());
        return label;
    }
}

