package com.mikolajgralczyk.calculations;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikolajgralczyk.mior.R;


public class Calculations extends ActionBarActivity {

    private Button mUnitCounterMainButton;
    private Button mInternalExposureMainButton;
    private Button mGammaCounterMainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);

        initializeButtonsForCalculations();
    }

    private void initializeButtonsForCalculations() {
        mUnitCounterMainButton = (Button) findViewById(R.id.unitCounterMainButton);
        mInternalExposureMainButton = (Button) findViewById(R.id.internalExposureMainButton);
        mGammaCounterMainButton = (Button) findViewById(R.id.gammaCounterMainButton);

        //Unit counter
        mUnitCounterMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unitCounter = new Intent(Calculations.this, UnitCounter.class);
                startActivityForResult(unitCounter, 0);
            }
        });

        //Internal exposure
        mInternalExposureMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent internalExposure = new Intent(Calculations.this, InternalExposure.class);
                startActivityForResult(internalExposure, 0);
            }
        });

        //Gamma counter
        mGammaCounterMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gammaCounter = new Intent(Calculations.this, GammaCounter.class);
                startActivityForResult(gammaCounter, 0);
            }
        });
    }
}
