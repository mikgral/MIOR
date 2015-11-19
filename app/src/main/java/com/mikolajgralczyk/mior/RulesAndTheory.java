package com.mikolajgralczyk.mior;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class RulesAndTheory extends ActionBarActivity {


    private Button mDosesDefinitionsMainButton;
    private Button mDoseLimitsMainButton;
    private Button mWasteMainButton;
    private Button mGlossaryMainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_and_theory);

        initializeButtonsForRulesAndTheory();

    }

    protected void initializeButtonsForRulesAndTheory(){

        mDosesDefinitionsMainButton = (Button) findViewById(R.id.dosesDefinitionsMainButton);
        mDoseLimitsMainButton = (Button) findViewById(R.id.doseLimitsMainButton);
        mWasteMainButton = (Button) findViewById(R.id.wasteMainButton);
        mGlossaryMainButton = (Button) findViewById(R.id.glossaryMainButton);

        //Doses definitions
        mDosesDefinitionsMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent dosesDefinitions = new Intent(RulesAndTheory.this, DosesDefinitions.class);
                startActivityForResult(dosesDefinitions, 0);

            }
        });

        //Dose limits
        mDoseLimitsMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        //Waste
        mWasteMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        //Glossary
        mGlossaryMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rules_and_theory, menu);
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
