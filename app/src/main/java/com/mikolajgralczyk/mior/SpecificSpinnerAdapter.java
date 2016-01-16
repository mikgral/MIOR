package com.mikolajgralczyk.mior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpecificSpinnerAdapter extends ArrayAdapter<ValuesForObjectsInSpinner> {

    private ValuesForObjectsInSpinner[] mMyObjs;
    private int mTextViewResourceId;

    public SpecificSpinnerAdapter(Context context, int textViewResourceId, ValuesForObjectsInSpinner[] myObjs) {
        super(context, textViewResourceId, myObjs);
        this.mMyObjs = myObjs;
        this.mTextViewResourceId = textViewResourceId;

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
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mTextViewResourceId, parent, false);
        }
        TextView label = (TextView) convertView;
        label.setText(mMyObjs[position].getText());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mTextViewResourceId, parent, false);
        }
        TextView label = (TextView) convertView;
        label.setText(mMyObjs[position].getText());
        return label;
    }
}

