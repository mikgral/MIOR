package com.mikolajgralczyk.calculations;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mikolajgralczyk.mior.R;

import java.text.DecimalFormat;

public class UnitCounter extends ActionBarActivity {

    private Spinner mSpinner1UnitCounter;
    private Spinner mSpinner2UnitCounter;
    private EditText mEnterAmountEditText;

    private TextView mUnitTextView1;
    private TextView mUnitTextView2;
    private TextView mUnitTextView3;
    private TextView mUnitTextView4;
    private TextView mUnitTextView5;
    private TextView mUnitTextView6;
    private TextView mInfoUnitCounterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_counter);

        addItemsToMainSpinner();
        addListenerToMainSpinner();
        initializeTextViews();
        mEnterAmountEditText = (EditText) findViewById(R.id.enterAmountEditText);
    }

    private void initializeTextViews() {
        mUnitTextView1 = (TextView) findViewById(R.id.unitTextView1);
        mUnitTextView2 = (TextView) findViewById(R.id.unitTextView2);
        mUnitTextView3 = (TextView) findViewById(R.id.unitTextView3);
        mUnitTextView4 = (TextView) findViewById(R.id.unitTextView4);
        mUnitTextView5 = (TextView) findViewById(R.id.unitTextView5);
        mUnitTextView6 = (TextView) findViewById(R.id.unitTextView6);
        mInfoUnitCounterTextView = (TextView) findViewById(R.id.infoUnitCounterTextView);
    }

    private void addItemsToMainSpinner() {
        mSpinner1UnitCounter = (Spinner) findViewById(R.id.spinner1UnitCounter);
        ArrayAdapter<CharSequence> spinner1UnitCounterAdapter = ArrayAdapter.createFromResource(this,
                R.array.main_types, android.R.layout.simple_spinner_item);
        spinner1UnitCounterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner1UnitCounter.setAdapter(spinner1UnitCounterAdapter);
    }

    private void addListenerToMainSpinner() {
        mSpinner1UnitCounter = (Spinner) findViewById(R.id.spinner1UnitCounter);
        mSpinner1UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                initializeSecondSpinner(pos);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // Intentionally left blank
            }
        });
    }

    private void initializeSecondSpinner(int currentItemSelected) {
        if (currentItemSelected == 0)
            initializeAbsorbedDoseSpinner();
        else if (currentItemSelected == 1)
            initializeEquivalentDoseSpinner();
        else if (currentItemSelected == 2)
            initializeExposureDoseSpinner();
    }

    private void initializeAbsorbedDoseSpinner() {
        mSpinner2UnitCounter = (Spinner) findViewById(R.id.spinner2UnitCounter);
        ArrayAdapter<CharSequence> spinnerAbsorbedDoseAdapter = ArrayAdapter.createFromResource(this,
                R.array.absorbed_dose, android.R.layout.simple_spinner_item);
        spinnerAbsorbedDoseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner2UnitCounter.setAdapter(spinnerAbsorbedDoseAdapter);

        mSpinner2UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInAbsorbedDoseSpinner = parent.getItemAtPosition(pos).toString();
                updateViewForAbsorbedDose(itemSelectedInAbsorbedDoseSpinner);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // Intentionally left blank
            }
        });
    }

    private void initializeEquivalentDoseSpinner() {
        mSpinner2UnitCounter = (Spinner) findViewById(R.id.spinner2UnitCounter);
        ArrayAdapter<CharSequence> spinnerEquivalentDoseAdapter = ArrayAdapter.createFromResource(this,
                R.array.equivalent_dose, android.R.layout.simple_spinner_item);
        spinnerEquivalentDoseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner2UnitCounter.setAdapter(spinnerEquivalentDoseAdapter);

        mSpinner2UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInEquivalentDoseSpinner = parent.getItemAtPosition(pos).toString();
                updateViewForEquivalentDose(itemSelectedInEquivalentDoseSpinner);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // Intentionally left blank
            }
        });
    }

    private void initializeExposureDoseSpinner() {
        mSpinner2UnitCounter = (Spinner) findViewById(R.id.spinner2UnitCounter);
        ArrayAdapter<CharSequence> spinnerExposureDoseAdapter = ArrayAdapter.createFromResource(this,
                R.array.exposure_dose, android.R.layout.simple_spinner_item);
        spinnerExposureDoseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner2UnitCounter.setAdapter(spinnerExposureDoseAdapter);

        mSpinner2UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInExposureDoseSpinner = parent.getItemAtPosition(pos).toString();
                updateViewForExposureDose(itemSelectedInExposureDoseSpinner);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // Intentionally left blank
            }
        });
    }

    private void updateViewForAbsorbedDose(String selectedItem) {
        try {
            double quantityToConvert = Double.parseDouble(mEnterAmountEditText.getText().toString());

            switch (selectedItem) {
                case "rad":
                    updateTextViewsFromRad(quantityToConvert);
                    break;
                case "mrad":
                    convertToRadAndUpdateTextViews(quantityToConvert, 1000d);
                    break;
                case "Gy":
                    convertToRadAndUpdateTextViews(quantityToConvert, 0.01d);
                    break;
                case "cGy":
                    convertToRadAndUpdateTextViews(quantityToConvert, 1d);
                    break;
                case "Sv":
                    convertToRadAndUpdateTextViews(quantityToConvert, 0.011494d);
                    break;
                case "mSv":
                    convertToRadAndUpdateTextViews(quantityToConvert, 11.494d);
            }
        }

        catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), R.string.fillInMissingFieldAlert, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateViewForEquivalentDose(String selectedItem) {
        try {
            double quantityToConvert = Double.parseDouble(mEnterAmountEditText.getText().toString());

            switch (selectedItem) {
                case "rem":
                    updateTextViewsFromRem(quantityToConvert);
                    break;
                case "mrem":
                    convertToRemAndUpdateTextViews(quantityToConvert, 1000d);
                    break;
                case "Sv":
                    convertToRemAndUpdateTextViews(quantityToConvert, 0.01d);
                    break;
                case "mSv":
                    convertToRemAndUpdateTextViews(quantityToConvert, 10d);
                    break;
                case "µSv":
                    convertToRemAndUpdateTextViews(quantityToConvert, 10000d);
                    break;
            }
        }

        catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), R.string.fillInMissingFieldAlert, Toast.LENGTH_LONG).show();
        }
    }

    private void updateViewForExposureDose(String selectedItem) {
        try {
            double quantityToConvert = Double.parseDouble(mEnterAmountEditText.getText().toString());

            switch (selectedItem) {
                case "R":
                    updateTextViewsFromR(quantityToConvert);
                    break;
                case "mR":
                    convertToRAndUpdateTextViews(quantityToConvert, 1000d);
                    break;
                case "C/kg":
                    convertToRAndUpdateTextViews(quantityToConvert, 0.000258d);
                    break;
                case "mC/kg":
                    convertToRAndUpdateTextViews(quantityToConvert, 0.258d);
                    break;
                case "cGy":
                    convertToRAndUpdateTextViews(quantityToConvert, 0.87d);
                    break;
                case "mSv":
                    convertToRAndUpdateTextViews(quantityToConvert, 10d);
            }
        }

        catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), R.string.fillInMissingFieldAlert, Toast.LENGTH_SHORT).show();
        }
    }

    private void updateTextViewsFromRad(double quantity) {
        updateTargetTextView(quantity, "rad", mUnitTextView1);
        updateTargetTextView(quantity * 1000d, "mrad", mUnitTextView2);
        updateTargetTextView(quantity * 0.01d, "Gy", mUnitTextView3);
        updateTargetTextView(quantity * 1d, "cGy", mUnitTextView4);
        updateTargetTextView(quantity * 0.011494, "Sv*", mUnitTextView5);
        updateTargetTextView(quantity * 11.494d, "mSv*", mUnitTextView6);
        mInfoUnitCounterTextView.setText(R.string.warningForAbsorbedDose);
    }

    private void convertToRadAndUpdateTextViews(double quantityToConvert, double unitValue) {
        double quantityForRad = quantityToConvert / unitValue;
        updateTextViewsFromRad(quantityForRad);
    }

    private void updateTextViewsFromRem(double quantity) {
        updateTargetTextView(quantity, "rem", mUnitTextView1);
        updateTargetTextView(quantity * 1000d, "mrem", mUnitTextView2);
        updateTargetTextView(quantity * 0.01d, "Sv", mUnitTextView3);
        updateTargetTextView(quantity * 10d, "mSv", mUnitTextView4);
        updateTargetTextView(quantity * 10000d, "μSv", mUnitTextView5);
        mUnitTextView6.setText("");
        mInfoUnitCounterTextView.setText("");
    }

    private void convertToRemAndUpdateTextViews(double quantityToConvert, double unitValue) {
        double quantityForRem = quantityToConvert / unitValue;
        updateTextViewsFromRem(quantityForRem);
    }

    private void updateTextViewsFromR(double quantity) {
        updateTargetTextView(quantity, "R", mUnitTextView1);
        updateTargetTextView(quantity * 1000d, "mR", mUnitTextView2);
        updateTargetTextView(quantity * 0.000258d, "C/kg", mUnitTextView3);
        updateTargetTextView(quantity * 0.258d, "mC/kg", mUnitTextView4);
        updateTargetTextView(quantity * 0.87d, "cGy*", mUnitTextView5);
        updateTargetTextView(quantity * 10d, "mSv**", mUnitTextView6);
        mInfoUnitCounterTextView.setText(R.string.warningForExposureDose);
    }

    private void convertToRAndUpdateTextViews(double quantityToConvert, double unitValue) {
        double quantityForR = quantityToConvert / unitValue;
        updateTextViewsFromR(quantityForR);
    }

    private void updateTargetTextView(double quantity, String unit, TextView targetTextView) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        df.setMinimumFractionDigits(0);
        String targetString = df.format(quantity) + " " + unit;
        targetTextView.setText(targetString);
    }
}