package com.mikolajgralczyk.mior;

// TODO dokończyć odpowiedź wyniku

import android.content.Context;
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


public class GammaCounter extends ActionBarActivity {

    private Spinner mMainSpinnerInGammaCounter;
    private Spinner mChooseAtomGammaSpinner;

    private TextView mSymbol2TextView;
    private TextView mSymbol3TextView;
    private TextView mSymbol4TextView;
    private TextView mSymbol5TextView;
    private TextView mAnswerGammaCounterTextView;

    private EditText mEnter1AmountGammaCounterEditText;
    private EditText mEnter2AmountGammaCounterEditText;
    private EditText mEnter3AmountGammaCounterEditText;
    private EditText mEnter4AmountGammaCounterEditText;

    private String itemSelectedInMainSpinner;
    private double valueOfSelectedAtom;

    private Button mCountGammaButton;


    ValuesForObjectsInSpinner[] obj = {
            new ValuesForObjectsInSpinner("Na-22", 0.0296d),
            new ValuesForObjectsInSpinner("Na-24", 0.0449d),
            new ValuesForObjectsInSpinner("K-42", 0.0045d),
            new ValuesForObjectsInSpinner("Sc-46", 0.0261d),
            new ValuesForObjectsInSpinner("Cr-51", 0.0005d),
            new ValuesForObjectsInSpinner("Mn-56", 0.0197d),
            new ValuesForObjectsInSpinner("Fe-59", 0.016d),
            new ValuesForObjectsInSpinner("Co-60", 0.0308d),
            new ValuesForObjectsInSpinner("Se-75", 0.0048d),
            new ValuesForObjectsInSpinner("Sr-85", 0.0071d),
            new ValuesForObjectsInSpinner("Rb-86", 0.0012d),
            new ValuesForObjectsInSpinner("Mo-99", 0.0042d),
            new ValuesForObjectsInSpinner("Tc-99m", 0.0014d),
            new ValuesForObjectsInSpinner("Ag-110", 0.0341d),
            new ValuesForObjectsInSpinner("Ag-111", 0.0005d),
            new ValuesForObjectsInSpinner("I-131", 0.0054d),
            new ValuesForObjectsInSpinner("Cs-134", 0.021d),
            new ValuesForObjectsInSpinner("Cs-137", 0.008d),
            new ValuesForObjectsInSpinner("Ba-140", 0.0026d),
            new ValuesForObjectsInSpinner("La-140", 0.0283d),
            new ValuesForObjectsInSpinner("Ce-141", 0.0009d),
            new ValuesForObjectsInSpinner("Pr-144", 0.0004d),
            new ValuesForObjectsInSpinner("Eu-152", 0.0149d),
            new ValuesForObjectsInSpinner("Eu-154", 0.0155d),
            new ValuesForObjectsInSpinner("Yb-169", 0.0042d),
            new ValuesForObjectsInSpinner("Tm-170", 0.00007d),
            new ValuesForObjectsInSpinner("Ir-192", 0.0109d),
            new ValuesForObjectsInSpinner("Au-198", 0.0054d),
            new ValuesForObjectsInSpinner("Tl-202", 0.0062d),
            new ValuesForObjectsInSpinner("Hg-203", 0.0031d),
            new ValuesForObjectsInSpinner("Ra-226", 0.0214d),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamma_counter);


        initializeBothSpinners();
        initializeRestWidgets();
        initializeAnswerButton();

/*
        mTrySpinner = (Spinner) findViewById(R.id.trySpinner);
        mTryTextView = (TextView) findViewById(R.id.tryTextView);

        SpecificSpinnerAdapter adapter = new SpecificSpinnerAdapter(GammaCounter.this, android.R.layout.simple_spinner_item, obj);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mTrySpinner.setAdapter(adapter);
        mTrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ValuesForObjectsInSpinner obj = (ValuesForObjectsInSpinner) (parent.getItemAtPosition(position));
                mTryTextView.setText(String.valueOf(obj.getValue()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
*/

    }

    private void initializeBothSpinners() {

        mMainSpinnerInGammaCounter = (Spinner) findViewById(R.id.mainSpinnerInGammaCounter);
        mChooseAtomGammaSpinner = (Spinner) findViewById(R.id.chooseAtomGammaSpinner);


        ArrayAdapter<CharSequence> adapterForMainSpinner = ArrayAdapter.createFromResource(this, R.array.gamma_counter_elements_to_choose, android.R.layout.simple_spinner_item);
        adapterForMainSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMainSpinnerInGammaCounter.setAdapter(adapterForMainSpinner);
        mMainSpinnerInGammaCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                itemSelectedInMainSpinner = parent.getItemAtPosition(pos).toString();
                updateSymbolTextViews(itemSelectedInMainSpinner);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO
            }

        });


        SpecificSpinnerAdapter adapterForChooseAtomSpinner = new SpecificSpinnerAdapter(GammaCounter.this, android.R.layout.simple_spinner_item, obj);
        adapterForChooseAtomSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mChooseAtomGammaSpinner.setAdapter(adapterForChooseAtomSpinner);
        mChooseAtomGammaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                ValuesForObjectsInSpinner obj = (ValuesForObjectsInSpinner) (parent.getItemAtPosition(pos));
                valueOfSelectedAtom = obj.getValue();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO
            }

        });

    }

    private void initializeRestWidgets() {

        mSymbol2TextView = (TextView) findViewById(R.id.symbol2TextView);
        mSymbol3TextView = (TextView) findViewById(R.id.symbol3TextView);
        mSymbol4TextView = (TextView) findViewById(R.id.symbol4TextView);
        mSymbol5TextView = (TextView) findViewById(R.id.symbol5TextView);
        mAnswerGammaCounterTextView = (TextView) findViewById(R.id.answerGammaCounterTextView);

        mEnter1AmountGammaCounterEditText = (EditText) findViewById(R.id.enter1AmountGammaCounterEditText);
        mEnter2AmountGammaCounterEditText = (EditText) findViewById(R.id.enter2AmountGammaCounterEditText);
        mEnter3AmountGammaCounterEditText = (EditText) findViewById(R.id.enter3AmountGammaCounterEditText);
        mEnter4AmountGammaCounterEditText = (EditText) findViewById(R.id.enter4AmountGammaCounterEditText);

    }

    private void updateSymbolTextViews(String itemSelected) {

        if (itemSelected.equals("Dawka pochłonięta w powietrzu")) {
            mSymbol2TextView.setText(R.string.activity);
            mSymbol3TextView.setText(R.string.time);
            mSymbol4TextView.setText(R.string.distance);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected.equals("Aktywność źródła")) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.time);
            mSymbol4TextView.setText(R.string.distance);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected.equals("Czas ekspozycji")) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.activity);
            mSymbol4TextView.setText(R.string.distance);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected.equals("Czas ekspozycji")) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.activity);
            mSymbol4TextView.setText(R.string.distance);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected.equals("Odległość od źródła")) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.activity);
            mSymbol4TextView.setText(R.string.time);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected.equals("Krotność osłony")) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.activity);
            mSymbol4TextView.setText(R.string.time);
            mSymbol5TextView.setText(R.string.distance);
        }
    }

    private void initializeAnswerButton() {

        mCountGammaButton = (Button) findViewById(R.id.countGammaButton);

        mCountGammaButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        DecimalFormat df = new DecimalFormat();
                        df.setMaximumFractionDigits(3);
                        df.setMinimumFractionDigits(0);

                        String answer = String.valueOf(df.format(count()));

                        if (answer.equals("Infinity")) {
                            Toast.makeText(getApplicationContext(), "Dzielenie przez 0 niedozwolone!", Toast.LENGTH_SHORT).show();
                        } else if (answer.equals("null")) {

                        } else {
                            mAnswerGammaCounterTextView.setText(answer);
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

        Double answer = null;

        Double symbol1;
        Double symbol2;
        Double symbol3;
        Double symbol4;

        String editText1 = mEnter1AmountGammaCounterEditText.getText().toString();
        String editText2 = mEnter2AmountGammaCounterEditText.getText().toString();
        String editText3 = mEnter3AmountGammaCounterEditText.getText().toString();
        String editText4 = mEnter4AmountGammaCounterEditText.getText().toString();

        if (editText1.length()>0 && editText2.length()>0 && editText3.length()>0 && editText4.length()>0) {
            symbol1 = Double.parseDouble(editText1);
            symbol2 = Double.parseDouble(editText2);
            symbol3 = Double.parseDouble(editText3);
            symbol4 = Double.parseDouble(editText4);

            if (itemSelectedInMainSpinner.equals("Dawka pochłonięta w powietrzu")) {
                answer = ((valueOfSelectedAtom * symbol1 * symbol2) / (symbol4 * Math.pow(symbol3, 2))) * 0.087;
            } else if (itemSelectedInMainSpinner.equals("Aktywność źródła")) {
                answer = (symbol1 * 0.087 * symbol4 * Math.pow(symbol3, 2)) / (valueOfSelectedAtom * symbol2);
            } else if (itemSelectedInMainSpinner.equals("Czas ekspozycji")) {
                answer = (symbol1 * 0.087 * symbol4 * Math.pow(symbol3, 2)) / (valueOfSelectedAtom * symbol2);
            } else if (itemSelectedInMainSpinner.equals("Odległość od źródła")) {
                answer = Math.sqrt((valueOfSelectedAtom * symbol2 * symbol3) / symbol4 * symbol1 * 0.087);
            } else if (itemSelectedInMainSpinner.equals("Krotność osłony")) {
                answer = (valueOfSelectedAtom * symbol2 * symbol3) / (symbol1 * 0.087 * Math.pow(symbol4, 2));
            }
        }

//        Double symbol1 = Double.parseDouble(mEnter1AmountGammaCounterEditText.getText().toString());
//        Double symbol2 = Double.parseDouble(mEnter2AmountGammaCounterEditText.getText().toString());
//        Double symbol3 = Double.parseDouble(mEnter3AmountGammaCounterEditText.getText().toString());
//        Double symbol4 = Double.parseDouble(mEnter4AmountGammaCounterEditText.getText().toString());


//        else if (editText1 == null || editText2 == null || editText3 == null || editText4 == null) {
//            Toast.makeText(getApplicationContext(), "Wypełnij brakujące pola!", Toast.LENGTH_SHORT).show();
//        }
        else {
            Toast.makeText(getApplicationContext(), "Wypełnij brakujące pola!", Toast.LENGTH_SHORT).show();
//            if (itemSelectedInMainSpinner.equals("Dawka pochłonięta w powietrzu")) {
//                answer = ((valueOfSelectedAtom * symbol1 * symbol2) / (symbol4 * Math.pow(symbol3, 2))) * 0.087;
//            } else if (itemSelectedInMainSpinner.equals("Aktywność źródła")) {
//                answer = (symbol1 * 0.087 * symbol4 * Math.pow(symbol3, 2)) / (valueOfSelectedAtom * symbol2);
//            } else if (itemSelectedInMainSpinner.equals("Czas ekspozycji")) {
//                answer = (symbol1 * 0.087 * symbol4 * Math.pow(symbol3, 2)) / (valueOfSelectedAtom * symbol2);
//            } else if (itemSelectedInMainSpinner.equals("Odległość od źródła")) {
//                answer = Math.sqrt((valueOfSelectedAtom * symbol2 * symbol3) / symbol4 * symbol1 * 0.087);
//            } else if (itemSelectedInMainSpinner.equals("Krotność osłony")) {
//                answer = (valueOfSelectedAtom * symbol2 * symbol3) / (symbol1 * 0.087 * Math.pow(symbol4, 2));
//            }
        }

        return answer;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gamma_counter, menu);
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
