package com.mikolajgralczyk.theory;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mikolajgralczyk.mior.R;


public class RulesAndTheory extends ActionBarActivity {


//    private Button mDosesDefinitionsMainButton;
    private Button mDoseLimitsMainButton;
    private Button mLinksMainButton;
    private Button mGlossaryMainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_and_theory);

        initializeButtonsForRulesAndTheory();

    }

    protected void initializeButtonsForRulesAndTheory(){

//        mDosesDefinitionsMainButton = (Button) findViewById(R.id.dosesDefinitionsMainButton);
        mDoseLimitsMainButton = (Button) findViewById(R.id.doseLimitsMainButton);
        mLinksMainButton = (Button) findViewById(R.id.linksMainButton);
        mGlossaryMainButton = (Button) findViewById(R.id.glossaryMainButton);

//        //Doses definitions
//        mDosesDefinitionsMainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent dosesDefinitions = new Intent(RulesAndTheory.this, DosesDefinitions.class);
//                startActivityForResult(dosesDefinitions, 0);
//
//            }
//        });

        //Dose limits
        mDoseLimitsMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent doseLimits = new Intent(RulesAndTheory.this, DoseLimits.class);
                startActivityForResult(doseLimits, 0);

            }
        });

        //Links
        mLinksMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent links = new Intent(RulesAndTheory.this, Links.class);
                startActivityForResult(links, 0);

            }
        });

        //Glossary
        mGlossaryMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent dictionary = new Intent(RulesAndTheory.this, Dictionary.class);
                startActivityForResult(dictionary, 0);

            }
        });
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_rules_and_theory, menu);
//
////        // Get the SearchView and set the searchable configuration
////        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
////        SearchView searchView = (SearchView) menu.findItem(R.id.searchView).getActionView();
////        // Assumes current activity is the searchable activity
////        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
////        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
//
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
