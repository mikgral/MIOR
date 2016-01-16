package com.mikolajgralczyk.mior;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class EmergencyNumbers extends ActionBarActivity {


    private Button mFireBrigadeButton;
    private Button mAmbulanceButton;
    private Button mPoliceButton;
    private Button mCezarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_numbers);

        initializeEmergencyCallButtons();

    }


    protected void initializeEmergencyCallButtons(){

        mFireBrigadeButton = (Button) findViewById(R.id.callFireBrigadeButton);
        mFireBrigadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callFireBrigade = new Intent(Intent.ACTION_CALL);
                String fireBrigade = "tel:" + getString(R.string.fireBrigadeNumber);
                callFireBrigade.setData(Uri.parse(fireBrigade));
                startActivity(callFireBrigade);

            }
        });

        mAmbulanceButton = (Button) findViewById(R.id.callAmbulanceButton);
        mAmbulanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callAmbulance = new Intent(Intent.ACTION_CALL);
                String ambulance = "tel:" + getString(R.string.ambulanceNumber);
                callAmbulance.setData(Uri.parse(ambulance));
                startActivity(callAmbulance);

            }
        });

        mPoliceButton = (Button) findViewById(R.id.callPoliceButton);
        mPoliceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callPolice = new Intent(Intent.ACTION_CALL);
                String police = "tel:" + getString(R.string.policeNumber);
                callPolice.setData(Uri.parse(police));
                startActivity(callPolice);

            }
        });

        mCezarButton = (Button) findViewById(R.id.callCEZARButton);
        mCezarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callCezar = new Intent(Intent.ACTION_CALL);
                String cezar = "tel:" + getString(R.string.cezarNumber);
                callCezar.setData(Uri.parse(cezar));
                startActivity(callCezar);

            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_emergency_numbers, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
