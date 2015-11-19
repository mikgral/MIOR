package com.mikolajgralczyk.mior;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class RadiationProperties extends ActionBarActivity {


    private Button mRadiationPropertiesButton1;
    private Button mRadiationPropertiesButton2;
    private Button mRadiationPropertiesButton3;
    private Button mRadiationPropertiesButton4;
    private TextView mRadiationTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiation_properties);

        initializeButtonsAndAnswersForRadiationProperties();

    }


    protected void initializeButtonsAndAnswersForRadiationProperties(){
        mRadiationPropertiesButton1 = (Button) findViewById(R.id.radiationPropertiesButton1);
        mRadiationPropertiesButton2 = (Button) findViewById(R.id.radiationPropertiesButton2);
        mRadiationPropertiesButton3 = (Button) findViewById(R.id.radiationPropertiesButton3);
        mRadiationPropertiesButton4 = (Button) findViewById(R.id.radiationPropertiesButton4);
        mRadiationTitleTextView = (TextView) findViewById(R.id.radiationTitleTextView);

        mRadiationPropertiesButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRadiationTitleTextView.setText(R.string.titleAlfa);

            }
        });

        mRadiationPropertiesButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRadiationTitleTextView.setText(R.string.titleBeta);

            }
        });

        mRadiationPropertiesButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRadiationTitleTextView.setText(R.string.titleGamma);

            }
        });

        mRadiationPropertiesButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRadiationTitleTextView.setText(R.string.titleNeutrons);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_radiation_properties, menu);
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
