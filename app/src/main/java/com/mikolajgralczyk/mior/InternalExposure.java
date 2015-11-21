package com.mikolajgralczyk.mior;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;


public class InternalExposure extends ActionBarActivity {

    private Button mGeneralPopulationButton;
    private Button mEmployeesButton;
    private WebView mIntroductionToIEWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_exposure);

        initializeButtons();
        initializeIntroduction();
    }

    private void initializeButtons() {
        mGeneralPopulationButton = (Button) findViewById(R.id.generalPopulationButton);
        mEmployeesButton = (Button) findViewById(R.id.employeesButton);

        mGeneralPopulationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIEGPActivity = new Intent(InternalExposure.this, InternalExposureForGeneralPopulation.class);
                startActivityForResult(startIEGPActivity, 0);

            }
        });

        mEmployeesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIEEActivity = new Intent(InternalExposure.this, InternalExposureForEmployees.class);
                startActivityForResult(startIEEActivity, 0);

            }
        });
    }

    private void initializeIntroduction() {
        mIntroductionToIEWebView = (WebView) findViewById(R.id.introductionToIEWebView);
        WebSettings websettings = mIntroductionToIEWebView.getSettings();
        websettings.setDefaultTextEncodingName("utf-8");
        mIntroductionToIEWebView.loadData(getString(R.string.introductionToIE), "text/html; charset=utf-8", null);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_internal_exposure, menu);
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
