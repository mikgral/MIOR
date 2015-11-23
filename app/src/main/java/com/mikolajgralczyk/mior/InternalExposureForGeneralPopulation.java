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
import android.widget.Toast;

import java.text.DecimalFormat;


public class InternalExposureForGeneralPopulation extends ActionBarActivity {

    ValuesForObjectsInSpinner[] gastro = {
            new ValuesForObjectsInSpinner("F-18", 0.000000000049d),
            new ValuesForObjectsInSpinner("P-32", 0.0000000024d),
            new ValuesForObjectsInSpinner("Tc-99m", 0.000000000022d),
            new ValuesForObjectsInSpinner("I-131", 0.000000022d),
    };

    ValuesForObjectsInSpinner[] pulmo = {
            new ValuesForObjectsInSpinner("T-3 (F)", 0.0000000000062d),
            new ValuesForObjectsInSpinner("T-3 (M)", 0.000000000045d),
            new ValuesForObjectsInSpinner("T-3 (S)", 0.00000000026d),
            new ValuesForObjectsInSpinner("C-14 (F)",0.0000000002d),
            new ValuesForObjectsInSpinner("C-14 (M)", 0.000000002d),
            new ValuesForObjectsInSpinner("Tc-99m (F)", 0.000000000012d),
            new ValuesForObjectsInSpinner("Tc-99m (M)", 0.000000000019d),
            new ValuesForObjectsInSpinner("Tc-99m (S)", 0.00000000002d),
            new ValuesForObjectsInSpinner("I-131 (F)", 0.0000000074d),
            new ValuesForObjectsInSpinner("I-131 (M)", 0.0000000024d),
            new ValuesForObjectsInSpinner("I-131 (S)", 0.0000000016d),
    };

    private Spinner mChooseWayOfAbsorbingSpinner;
    private Spinner mChooseAtomSpinner;

    private EditText mEnterActivityEditText;

    private Button mCountInternalExposureButton;

    private TextView mAnswerOfInternalExposure;

    private Double valueOfSelectedAtom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_exposure_for_general_population);

        initializeBothSpinnersAndEditText();
        initializeActionForButton();

        mAnswerOfInternalExposure = (TextView) findViewById(R.id.answerOfInternalExposure);
    }

    private void initializeBothSpinnersAndEditText() {

        mEnterActivityEditText = (EditText) findViewById(R.id.enterActivityEditText);
        mChooseWayOfAbsorbingSpinner = (Spinner) findViewById(R.id.chooseWayOfAbsorbingSpinner);
        mChooseAtomSpinner = (Spinner) findViewById(R.id.chooseAtomSpinner);

        ArrayAdapter<CharSequence> adapterForWayOfAbsorbingSpinner = ArrayAdapter.createFromResource(this, R.array.way_of_absorbtion, android.R.layout.simple_spinner_item);
        adapterForWayOfAbsorbingSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mChooseWayOfAbsorbingSpinner.setAdapter(adapterForWayOfAbsorbingSpinner);
        mChooseWayOfAbsorbingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInChooseWayOfAbsorbingSpinner = parent.getItemAtPosition(position).toString();

                if (itemSelectedInChooseWayOfAbsorbingSpinner.equals("Droga pokarmowa")) {
                    SpecificSpinnerAdapter adapterForChooseAtomSpinner = new SpecificSpinnerAdapter(InternalExposureForGeneralPopulation.this, android.R.layout.simple_spinner_item, gastro);
                    adapterForChooseAtomSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    mChooseAtomSpinner.setAdapter(adapterForChooseAtomSpinner);
                    mChooseAtomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            ValuesForObjectsInSpinner value = (ValuesForObjectsInSpinner) (parent.getItemAtPosition(position));
                            valueOfSelectedAtom = value.getValue();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                else if (itemSelectedInChooseWayOfAbsorbingSpinner.equals("Droga oddechowa")) {
                    SpecificSpinnerAdapter adapterForChooseAtomSpinner = new SpecificSpinnerAdapter(InternalExposureForGeneralPopulation.this, android.R.layout.simple_spinner_item, pulmo);
                    adapterForChooseAtomSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    mChooseAtomSpinner.setAdapter(adapterForChooseAtomSpinner);
                    mChooseAtomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            ValuesForObjectsInSpinner value = (ValuesForObjectsInSpinner) (parent.getItemAtPosition(position));
                            valueOfSelectedAtom = value.getValue();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void initializeActionForButton() {

        mCountInternalExposureButton = (Button) findViewById(R.id.countInternalExposureButton);
        mCountInternalExposureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(15);
                    df.setMinimumFractionDigits(0);

                    String answer = String.valueOf(df.format(count()));

                    if (answer.equals("Infinity")) {
                        Toast.makeText(getApplicationContext(), "Dzielenie przez 0 niedozwolone!", Toast.LENGTH_SHORT).show();
                    } else if (answer.equals("null")) {

                    } else {
                        mAnswerOfInternalExposure.setText("Obciążająca dawka skuteczna wynosi " +answer+ " Sv");
                    }
                }

                catch (java.lang.NullPointerException e) {
                    Toast.makeText(getApplicationContext(), "Wypełnij brakujące pola!", Toast.LENGTH_SHORT).show();
                }

                catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "Wypełnij brakujące pola!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Double count() {

        Double activityAmount = Double.parseDouble(mEnterActivityEditText.getText().toString());

        return activityAmount * valueOfSelectedAtom;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_internal_exposure_for_general_population, menu);
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
