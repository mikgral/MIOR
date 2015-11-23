package com.mikolajgralczyk.mior;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    //TODO mUnitTextView6 do poprawy w całej klasie (wyświetla się wartość uSv po ostatnim wyborze

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_counter);

        addItemsToMainSpinner();

        addListenerToMainSpinner();

        initializeTextViews();

        mEnterAmountEditText = (EditText) findViewById(R.id.enterAmountEditText);

    }

    protected void initializeTextViews() {

        mUnitTextView1 = (TextView) findViewById(R.id.unitTextView1);
        mUnitTextView2 = (TextView) findViewById(R.id.unitTextView2);
        mUnitTextView3 = (TextView) findViewById(R.id.unitTextView3);
        mUnitTextView4 = (TextView) findViewById(R.id.unitTextView4);
        mUnitTextView5 = (TextView) findViewById(R.id.unitTextView5);
        mUnitTextView6 = (TextView) findViewById(R.id.unitTextView6);

    }

    protected void addItemsToMainSpinner() {

        mSpinner1UnitCounter = (Spinner) findViewById(R.id.spinner1UnitCounter);

        ArrayAdapter<CharSequence> spinner1UnitCounterAdapter = ArrayAdapter.createFromResource(this, R.array.main_types, android.R.layout.simple_spinner_item );

        spinner1UnitCounterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner1UnitCounter.setAdapter(spinner1UnitCounterAdapter);

    }

    protected void addListenerToMainSpinner() {
        mSpinner1UnitCounter = (Spinner) findViewById(R.id.spinner1UnitCounter);
        mSpinner1UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInMainSpinner = parent.getItemAtPosition(pos).toString();

                initializeSecondSpinner(itemSelectedInMainSpinner);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO maybe add something here later
            }
        });
    }

    protected void initializeSecondSpinner(String currentItem) {
        if(currentItem.equals("Dawka pochłonięta")) {
            initializeAbsorbedDoseSpinner();
        }

        else if (currentItem.equals("Równoważnik dawki")) {
            initializeEquivalentDoseSpinner();
        }

        else if (currentItem.equals("Dawka ekspozycyjna")) {
            initializeExposureDoseSpinner();
        }

        else if (currentItem.equals("Dawka w powietrzu")) {
            initializeInAirDoseSpinner();
        }

    }


    protected void initializeAbsorbedDoseSpinner() {
        mSpinner2UnitCounter = (Spinner) findViewById(R.id.spinner2UnitCounter);

        ArrayAdapter<CharSequence> spinnerAbsorbedDoseAdapter = ArrayAdapter.createFromResource(this, R.array.absorbed_dose, android.R.layout.simple_spinner_item);

        spinnerAbsorbedDoseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner2UnitCounter.setAdapter(spinnerAbsorbedDoseAdapter);

        mSpinner2UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInAbsorbedDoseSpinner = parent.getItemAtPosition(pos).toString();

                updateViewForAbsorbedDose(itemSelectedInAbsorbedDoseSpinner);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO
            }
        });
    }

    protected void initializeEquivalentDoseSpinner() {
        mSpinner2UnitCounter = (Spinner) findViewById(R.id.spinner2UnitCounter);

        ArrayAdapter<CharSequence> spinnerEquivalentDoseAdapter = ArrayAdapter.createFromResource(this, R.array.equivalent_dose, android.R.layout.simple_spinner_item);

        spinnerEquivalentDoseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner2UnitCounter.setAdapter(spinnerEquivalentDoseAdapter);

        mSpinner2UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInEquivalentDoseSpinner = parent.getItemAtPosition(pos).toString();

                updateViewForEquivalentDose(itemSelectedInEquivalentDoseSpinner);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO
            }
        });
    }

    protected void initializeExposureDoseSpinner() {
        mSpinner2UnitCounter = (Spinner) findViewById(R.id.spinner2UnitCounter);

        ArrayAdapter<CharSequence> spinnerExposureDoseAdapter = ArrayAdapter.createFromResource(this, R.array.exposure_dose, android.R.layout.simple_spinner_item);

        spinnerExposureDoseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner2UnitCounter.setAdapter(spinnerExposureDoseAdapter);

        mSpinner2UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInExposureDoseSpinner = parent.getItemAtPosition(pos).toString();

                updateViewForExposureDose(itemSelectedInExposureDoseSpinner);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO
            }
        });
    }

    protected void initializeInAirDoseSpinner() {
        mSpinner2UnitCounter = (Spinner) findViewById(R.id.spinner2UnitCounter);

        ArrayAdapter<CharSequence> spinnerInAirDoseAdapter = ArrayAdapter.createFromResource(this, R.array.in_air_dose, android.R.layout.simple_spinner_item);

        spinnerInAirDoseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinner2UnitCounter.setAdapter(spinnerInAirDoseAdapter);

        mSpinner2UnitCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {
                String itemSelectedInInAirDoseSpinner = parent.getItemAtPosition(pos).toString();

                updateViewForInAirDose(itemSelectedInInAirDoseSpinner);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO
            }
        });
    }


    protected void updateViewForAbsorbedDose (String selectedItem) {

        double quantityToConvert = Double.parseDouble(mEnterAmountEditText.getText().toString());

        if (selectedItem.equals("rad")) {

            updateTextViewsFromRad(quantityToConvert);
        }

        else if (selectedItem.equals("mrad")) {

            convertToRadAndUpdateTextViews(quantityToConvert, 1000d);
        }

        else if (selectedItem.equals("Gy")) {

            convertToRadAndUpdateTextViews(quantityToConvert, 100.0d);
        }

        else if (selectedItem.equals("mGy")) {

            convertToRadAndUpdateTextViews(quantityToConvert, 0.1d);
        }

        else if (selectedItem.equals("µGy")) {

            convertToRadAndUpdateTextViews(quantityToConvert, 0.0001d);
        }
    }

    protected void updateViewForEquivalentDose (String selectedItem) {

        double quantityToConvert = Double.parseDouble(mEnterAmountEditText.getText().toString());

        if (selectedItem.equals("rem")) {

            updateTextViewsFromRem(quantityToConvert);
        }

        else if (selectedItem.equals("mrem")) {

            convertToRemAndUpdateTextViews(quantityToConvert, 1000d);
        }

        else if (selectedItem.equals("Sv")) {

            convertToRadAndUpdateTextViews(quantityToConvert, 100.0d);
        }

        else if (selectedItem.equals("mSv")) {

            convertToRadAndUpdateTextViews(quantityToConvert, 0.1d);
        }

        else if (selectedItem.equals("µSv")) {

            convertToRadAndUpdateTextViews(quantityToConvert, 0.0001d);
        }
    }

    protected void updateViewForExposureDose (String selectedItem) {

        double quantityToConvert = Double.parseDouble(mEnterAmountEditText.getText().toString());

        if (selectedItem.equals("R")) {

            updateTextViewsFromR(quantityToConvert);
        }

        else if (selectedItem.equals("mR")) {

            convertToRAndUpdateTextViews(quantityToConvert, 1000d);
        }

        else if (selectedItem.equals("C/kg")) {

            convertToRAndUpdateTextViews(quantityToConvert, 3876.0d);
        }

        else if (selectedItem.equals("mC/kg")) {

            convertToRAndUpdateTextViews(quantityToConvert, 3.876d);
        }

        else if (selectedItem.equals("µC/kg")) {

            convertToRAndUpdateTextViews(quantityToConvert, 0.003876d);
        }
    }

    protected void updateViewForInAirDose (String selectedItem) {

        double quantityToConvert = Double.parseDouble(mEnterAmountEditText.getText().toString());

        if (selectedItem.equals("Gy")) {

            updateTextViewsFromGy(quantityToConvert);
        }

        else if (selectedItem.equals("cGy")) {

            convertToGyAndUpdateTextViews(quantityToConvert, 100d);
        }

        else if (selectedItem.equals("mGy")) {

            convertToGyAndUpdateTextViews(quantityToConvert, 1000d);
        }

        else if (selectedItem.equals("Sv")) {

            convertToGyAndUpdateTextViews(quantityToConvert, 0.000000087d);
        }

        else if (selectedItem.equals("mSv")) {

            convertToGyAndUpdateTextViews(quantityToConvert, 0.00087d);
        }

        else if (selectedItem.equals("µSv")) {

            convertToGyAndUpdateTextViews(quantityToConvert, 0.87d);
        }
    }



    protected void updateTextViewsFromRad (double quantity) {

        updateTargetTextView(quantity, "rad", mUnitTextView1);
        updateTargetTextView(quantity*1000d, "mrad", mUnitTextView2);
        updateTargetTextView(quantity*100.0d, "Gy", mUnitTextView3);
        updateTargetTextView(quantity*0.1d, "mGy", mUnitTextView4);
        updateTargetTextView(quantity*0.0001d, "μGy", mUnitTextView5);

    }

    protected void convertToRadAndUpdateTextViews (double quantityToConvert, double unitValue) {

        double quantityForRad = quantityToConvert / unitValue;

        updateTextViewsFromRad(quantityForRad);
    }


    protected void updateTextViewsFromRem (double quantity) {

        updateTargetTextView(quantity, "rem", mUnitTextView1);
        updateTargetTextView(quantity*1000d, "mrem", mUnitTextView2);
        updateTargetTextView(quantity*100.0d, "Sv", mUnitTextView3);
        updateTargetTextView(quantity*0.1d, "mSv", mUnitTextView4);
        updateTargetTextView(quantity*0.0001d, "μSv", mUnitTextView5);

    }

    protected void convertToRemAndUpdateTextViews (double quantityToConvert, double unitValue) {

        double quantityForRem = quantityToConvert / unitValue;

        updateTextViewsFromRem(quantityForRem);
    }


    protected void updateTextViewsFromR (double quantity) {

        updateTargetTextView(quantity, "R", mUnitTextView1);
        updateTargetTextView(quantity*1000d, "mR", mUnitTextView2);
        updateTargetTextView(quantity*3876.0d, "C/kg", mUnitTextView3);
        updateTargetTextView(quantity*3.876d, "mC/kg", mUnitTextView4);
        updateTargetTextView(quantity*0.003876d, "μC/kg", mUnitTextView5);

    }

    protected void convertToRAndUpdateTextViews (double quantityToConvert, double unitValue) {

        double quantityForR = quantityToConvert / unitValue;

        updateTextViewsFromR(quantityForR);
    }


    protected void updateTextViewsFromGy (double quantity) {

        updateTargetTextView(quantity, "Gy", mUnitTextView1);
        updateTargetTextView(quantity*100d, "cGy", mUnitTextView2);
        updateTargetTextView(quantity*1000d, "mGy", mUnitTextView3);
        updateTargetTextView(quantity*0.000000087d, "Sv", mUnitTextView4);
        updateTargetTextView(quantity*0.00087d, "mSv", mUnitTextView5);
        updateTargetTextView(quantity*0.87d, "µSv", mUnitTextView6);

    }

    protected void convertToGyAndUpdateTextViews (double quantityToConvert, double unitValue) {

        double quantityForGy = quantityToConvert / unitValue;

        updateTextViewsFromGy(quantityForGy);
    }





    protected void updateTargetTextView (double quantity, String unit, TextView targetTextView) {

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(6);
        df.setMinimumFractionDigits(0);
        String targetString = df.format(quantity) + " " + unit;

        targetTextView.setText(targetString);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_unit_counter, menu);
        return true;


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
