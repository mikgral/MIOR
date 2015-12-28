package com.mikolajgralczyk.theory;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.mikolajgralczyk.mior.R;

public class Dictionary extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
