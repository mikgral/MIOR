package com.mikolajgralczyk.mior;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


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

    protected void initializeButtonsForCalculations() {

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculations, menu);
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
