package com.mikolajgralczyk.calculations;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.mikolajgralczyk.mior.R;


public class InternalExposure extends ActionBarActivity {

    private Button mCounterButton;
    private WebView mIntroductionToIEWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_exposure);

        initializeButtons();
        initializeIntroduction();
    }

    private void initializeButtons() {
        mCounterButton = (Button) findViewById(R.id.counterButton);
        mCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIEGPActivity = new Intent(InternalExposure.this, InternalExposureCounter.class);
                startActivityForResult(startIEGPActivity, 0);
            }
        });
    }

    private void initializeIntroduction() {
        mIntroductionToIEWebView = (WebView) findViewById(R.id.introductionToIEWebView);
        WebSettings websettings = mIntroductionToIEWebView.getSettings();
        websettings.setDefaultTextEncodingName("utf-8");
        mIntroductionToIEWebView.loadData(getString(R.string.introductionToIE), "text/html; charset=utf-8", null);
    }
}
