package com.mikolajgralczyk.mior;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {


    private Button mButton1;
    private Button mButton2;
    private Button mButton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMainButtons();

    }

    private void initializeMainButtons(){

        //Rules and Theory
        mButton1 = (Button) findViewById(R.id.mainButton1);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                Intent rulesAndTheory = new Intent(MainActivity.this, RulesAndTheory.class);
                startActivityForResult(rulesAndTheory, 0);

            }
        });


        //Calculations
        mButton2 = (Button) findViewById(R.id.mainButton2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                Intent calculations = new Intent(MainActivity.this, Calculations.class);
                startActivityForResult(calculations, 0);

            }
        });

        //Emergency numbers
        mButton3 = (Button) findViewById(R.id.mainButton3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                Intent emergencyNumbers = new Intent(MainActivity.this, EmergencyNumbers.class);
                startActivityForResult(emergencyNumbers, 0);

            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
