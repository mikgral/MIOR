package com.mikolajgralczyk.mior;


public class ValuesForObjectsInSpinner {

    private String mText;
    private double mValue;

    public ValuesForObjectsInSpinner(String text, double value) {
        mText = text;
        mValue = value;
    }


    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public double getValue() {
        return mValue;
    }

    public void setValue(double value) {
        mValue = value;
    }
}
