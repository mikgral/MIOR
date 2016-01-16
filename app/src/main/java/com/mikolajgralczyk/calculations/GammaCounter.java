package com.mikolajgralczyk.calculations;

// TODO wyczyścić kod
// TODO gruntownie przetestować

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mikolajgralczyk.mior.R;
import com.mikolajgralczyk.mior.SetMetricPrefix;
import com.mikolajgralczyk.mior.SpecificSpinnerAdapter;
import com.mikolajgralczyk.mior.ValuesForObjectsInSpinner;

public class GammaCounter extends ActionBarActivity {
    private Spinner mMainSpinnerInGammaCounter;
    private Spinner mChooseAtomGammaSpinner;

    private TextView mSymbol2TextView;
    private TextView mSymbol3TextView;
    private TextView mSymbol4TextView;
    private TextView mSymbol5TextView;
    private TextView mAnswerGammaCounterTextView;
    private TextView mMoreInfoTextView;

    private EditText mEnter1AmountGammaCounterEditText;
    private EditText mEnter2AmountGammaCounterEditText;
    private EditText mEnter3AmountGammaCounterEditText;
    private EditText mEnter4AmountGammaCounterEditText;

    private int itemSelectedInMainSpinner;
    private double valueOfSelectedAtom;

    private Button mCountGammaButton;

    private Double symbol1;
    private Double symbol2;
    private Double symbol3;
    private Double symbol4;

    ValuesForObjectsInSpinner[] obj = {
            new ValuesForObjectsInSpinner("Na-24", 0.0449d),
            new ValuesForObjectsInSpinner("Fe-59", 0.016d),
            new ValuesForObjectsInSpinner("Co-60", 0.0308d),
            new ValuesForObjectsInSpinner("Mo-99", 0.0042d),
            new ValuesForObjectsInSpinner("Tc-99m", 0.0014d),
            new ValuesForObjectsInSpinner("I-131", 0.0054d),
            new ValuesForObjectsInSpinner("Cs-134", 0.021d),
            new ValuesForObjectsInSpinner("Cs-137", 0.008d),
            new ValuesForObjectsInSpinner("Tm-170", 0.00007d),
            new ValuesForObjectsInSpinner("Ir-192", 0.0109d),
            new ValuesForObjectsInSpinner("Au-198", 0.0054d),
            new ValuesForObjectsInSpinner("Tl-202", 0.0062d),
            new ValuesForObjectsInSpinner("Ra-226", 0.0214d),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamma_counter);

        initializeBothSpinners();
        initializeRestWidgets();
        initializeAnswerButton();
    }

    private void initializeBothSpinners() {
        mMainSpinnerInGammaCounter = (Spinner) findViewById(R.id.mainSpinnerInGammaCounter);
        mChooseAtomGammaSpinner = (Spinner) findViewById(R.id.chooseAtomGammaSpinner);

        ArrayAdapter<CharSequence> adapterForMainSpinner = ArrayAdapter.createFromResource(this,
                R.array.gamma_counter_elements_to_choose, android.R.layout.simple_spinner_item);
        adapterForMainSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMainSpinnerInGammaCounter.setAdapter(adapterForMainSpinner);
        mMainSpinnerInGammaCounter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                itemSelectedInMainSpinner = pos;
                updateSymbolTextViews(itemSelectedInMainSpinner);
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // Intentionally left blank
            }
        });

        SpecificSpinnerAdapter adapterForChooseAtomSpinner = new SpecificSpinnerAdapter(GammaCounter.this,
                android.R.layout.simple_spinner_item, obj);
        adapterForChooseAtomSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mChooseAtomGammaSpinner.setAdapter(adapterForChooseAtomSpinner);
        mChooseAtomGammaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                ValuesForObjectsInSpinner obj = (ValuesForObjectsInSpinner) (parent.getItemAtPosition(pos));
                valueOfSelectedAtom = obj.getValue();
            }
            public void onNothingSelected(AdapterView<?> arg0) {
                // Intentionally left blank
            }
        });

    }

    private void initializeRestWidgets() {
        mSymbol2TextView = (TextView) findViewById(R.id.symbol2TextView);
        mSymbol3TextView = (TextView) findViewById(R.id.symbol3TextView);
        mSymbol4TextView = (TextView) findViewById(R.id.symbol4TextView);
        mSymbol5TextView = (TextView) findViewById(R.id.symbol5TextView);
        mAnswerGammaCounterTextView = (TextView) findViewById(R.id.answerGammaCounterTextView);
        mMoreInfoTextView = (TextView) findViewById(R.id.moreInfoTextView);

        mEnter1AmountGammaCounterEditText = (EditText) findViewById(R.id.enter1AmountGammaCounterEditText);
        mEnter2AmountGammaCounterEditText = (EditText) findViewById(R.id.enter2AmountGammaCounterEditText);
        mEnter3AmountGammaCounterEditText = (EditText) findViewById(R.id.enter3AmountGammaCounterEditText);
        mEnter4AmountGammaCounterEditText = (EditText) findViewById(R.id.enter4AmountGammaCounterEditText);
    }

    private void updateSymbolTextViews(int itemSelected) {
        if (itemSelected == 0) {
            mSymbol2TextView.setText(R.string.activity);
            mSymbol3TextView.setText(R.string.time);
            mSymbol4TextView.setText(R.string.distance);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected == 1) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.time);
            mSymbol4TextView.setText(R.string.distance);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected == 2) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.activity);
            mSymbol4TextView.setText(R.string.distance);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected == 3) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.activity);
            mSymbol4TextView.setText(R.string.time);
            mSymbol5TextView.setText(R.string.coverFold);
        }

        else if (itemSelected == 4) {
            mSymbol2TextView.setText(R.string.dose);
            mSymbol3TextView.setText(R.string.activity);
            mSymbol4TextView.setText(R.string.time);
            mSymbol5TextView.setText(R.string.distance);
        }
    }

    private void defineSymbols() {
        symbol1 = Double.parseDouble(mEnter1AmountGammaCounterEditText.getText().toString());
        symbol2 = Double.parseDouble(mEnter2AmountGammaCounterEditText.getText().toString());
        symbol3 = Double.parseDouble(mEnter3AmountGammaCounterEditText.getText().toString());
        symbol4 = Double.parseDouble(mEnter4AmountGammaCounterEditText.getText().toString());
    }

    private void initializeAnswerButton() {
        mCountGammaButton = (Button) findViewById(R.id.countGammaButton);
        mCountGammaButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
//                        DecimalFormat df = new DecimalFormat();
//                        df.setMaximumFractionDigits(5);
//                        df.setMinimumFractionDigits(0);
//
//                        String answer = String.valueOf(df.format(count()));

                        Double output = count();
                        SetMetricPrefix ans = new SetMetricPrefix(output);
                        SetMetricPrefix ansForAbsorbedDose = new SetMetricPrefix(output*0.87);
                        String answerForDoseAndActivity = ans.setUsingStandardSI();
                        String answerForAnsorbedDose = ansForAbsorbedDose.setUsingStandardSI();
                        String answerForTime = ans.setForTime();
                        String answerForDistance = ans.setForDistance();
                        String answerForCoverFold = ans.setExactOutput();


//                        if (output == Double.NEGATIVE_INFINITY || output == Double.POSITIVE_INFINITY) {
                        if (Double.isInfinite(output)) {
                            mAnswerGammaCounterTextView.setText("");
                            mMoreInfoTextView.setText("");
                            Toast.makeText(getApplicationContext(), R.string.divideByZeroAlert, Toast.LENGTH_SHORT).show();
                        } else if (Double.isNaN(output)) {
                            mAnswerGammaCounterTextView.setText("");
                            mMoreInfoTextView.setText("");
                            Toast.makeText(getApplicationContext(), R.string.fillInProperlyFieldsAlert, Toast.LENGTH_SHORT).show();
                        } else {
                            if (itemSelectedInMainSpinner == 0) {
                                mAnswerGammaCounterTextView.setText(getString(R.string.doseAnswer1) + answerForDoseAndActivity + "Sv" +
                                getString(R.string.doseAnswer2) + answerForAnsorbedDose + "Gy");
                                setPopulationCategory(output);
                            }
                            else if (itemSelectedInMainSpinner == 1) {
                                mAnswerGammaCounterTextView.setText(getString(R.string.activityAnswer) + answerForDoseAndActivity + "Bq");
                                mMoreInfoTextView.setText("");
                            }
                            else if (itemSelectedInMainSpinner == 2) {
                                mAnswerGammaCounterTextView.setText(getString(R.string.timeAnswer) + answerForTime);
                                mMoreInfoTextView.setText("");
                            }
                            else if (itemSelectedInMainSpinner == 3) {
                                mAnswerGammaCounterTextView.setText(getString(R.string.distanceAnswer) + answerForDistance);
                                countControlledAndSupervisedArea();
                            }
                            else if (itemSelectedInMainSpinner == 4) {
                                mAnswerGammaCounterTextView.setText(getString(R.string.coverFoldAnswer) + answerForCoverFold);
                                mMoreInfoTextView.setText(R.string.coverFoldInfo);
                            }
                        }
                    }

//                    catch (NullPointerException e) {
                    catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), R.string.fillInMissingFieldsAlert, Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    private Double count() {
        Double answer = null;
//
//        Double symbol1;
//        Double symbol2;
//        Double symbol3;
//        Double symbol4;
//
//        String editText1 = mEnter1AmountGammaCounterEditText.getText().toString();
//        String editText2 = mEnter2AmountGammaCounterEditText.getText().toString();
//        String editText3 = mEnter3AmountGammaCounterEditText.getText().toString();
//        String editText4 = mEnter4AmountGammaCounterEditText.getText().toString();
//
//        if (editText1.length()>0 && editText2.length()>0 && editText3.length()>0 && editText4.length()>0) {
//            symbol1 = Double.parseDouble(editText1);
//            symbol2 = Double.parseDouble(editText2);
//            symbol3 = Double.parseDouble(editText3);
//            symbol4 = Double.parseDouble(editText4);
//

        defineSymbols();

            if (itemSelectedInMainSpinner == 0) {
                answer = (((valueOfSelectedAtom * symbol1 * symbol2) / (symbol4 * Math.pow(symbol3, 2))) / 0.087) / 1000;
            } else if (itemSelectedInMainSpinner == 1) {
                answer = (((symbol1 * 0.087) * symbol4 * Math.pow(symbol3, 2)) / (valueOfSelectedAtom * symbol2)) * 1000000000;
            } else if (itemSelectedInMainSpinner == 2) {
                answer = ((symbol1 * 0.087) * symbol4 * Math.pow(symbol3, 2)) / (valueOfSelectedAtom * symbol2);
            } else if (itemSelectedInMainSpinner == 3) {
                answer = Math.sqrt((valueOfSelectedAtom * symbol2 * symbol3) / symbol4 * (symbol1 * 0.087));
            } else if (itemSelectedInMainSpinner == 4) {
                answer = (valueOfSelectedAtom * symbol2 * symbol3) / ((symbol1 * 0.087) * Math.pow(symbol4, 2));
            }


//        else Toast.makeText(getApplicationContext(), R.string.fillInMissingFieldsAlert, Toast.LENGTH_SHORT).show();

        return answer;
    }

    private void setPopulationCategory(Double output) {
        output = output * 50;

        if (output > 0.02)
            mMoreInfoTextView.setText(R.string.over20mSvInfo);
        else if (output <= 0.02 && output > 0.006)
            mMoreInfoTextView.setText(R.string.categoryAInfo);
        else if (output <= 0.006 && output >= 0.001)
            mMoreInfoTextView.setText(R.string.categoryBInfo);
        else if (output < 0.001)
            mMoreInfoTextView.setText(R.string.generalPopulationInfo);
    }

    private void countControlledAndSupervisedArea() {
        Double l20mSv;
        Double l6mSv;
        Double l1mSv;
//
//        Double symbol2;
//        Double symbol3;
//        Double symbol4;
//
//        String editText2 = mEnter2AmountGammaCounterEditText.getText().toString();
//        String editText3 = mEnter3AmountGammaCounterEditText.getText().toString();
//        String editText4 = mEnter4AmountGammaCounterEditText.getText().toString();
//
//        symbol2 = Double.parseDouble(editText2);
//        symbol3 = Double.parseDouble(editText3);
//        symbol4 = Double.parseDouble(editText4);


//        defineSymbols();
        l20mSv = Math.sqrt((valueOfSelectedAtom * symbol2 * symbol3) / (symbol4 * 0.0348));
        l6mSv = Math.sqrt((valueOfSelectedAtom * symbol2 * symbol3) / (symbol4 * 0.01044));
        l1mSv = Math.sqrt((valueOfSelectedAtom * symbol2 * symbol3) / (symbol4 * 0.00174));

        SetMetricPrefix ans20mSv = new SetMetricPrefix(l20mSv);
        String answer20mSv = ans20mSv.setForDistance();
        SetMetricPrefix ans6mSv = new SetMetricPrefix(l6mSv);
        String answer6mSv = ans6mSv.setForDistance();
        SetMetricPrefix ans1mSv = new SetMetricPrefix(l1mSv);
        String answer1mSv = ans1mSv.setForDistance();

        mMoreInfoTextView.setText(getString(R.string.infoAboutZone1) + answer20mSv + getString(R.string.infoAboutZone2)
            + answer6mSv + getString(R.string.infoAboutZone3) + answer6mSv + getString(R.string.infoAboutZone2)
            + answer1mSv + getString(R.string.infoAboutZone4));
        }
}

