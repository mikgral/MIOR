package com.mikolajgralczyk.mior;

public class ValuesForObjectsInSpinner {

    private String mText;
    private double mValue;
    private int mName;
    private int mDefinition;

    public ValuesForObjectsInSpinner(String text, int definition) {
        mText = text;
        mDefinition = definition;
    }

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


    public int getName() {
        return mName;
    }

    public void setName(int name) {
        mName = name;
    }

    public int getDefinition() {
        return mDefinition;
    }

    public void setDefinition(int definition) {
        mDefinition = definition;
    }

}
