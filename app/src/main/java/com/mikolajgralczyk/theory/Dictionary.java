package com.mikolajgralczyk.theory;

//TODO definicje wpisać!

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mikolajgralczyk.mior.R;
import com.mikolajgralczyk.mior.SpecificSpinnerAdapter;
import com.mikolajgralczyk.mior.ValuesForObjectsInSpinner;

public class Dictionary extends ActionBarActivity {

    private ListView mListView;

    ValuesForObjectsInSpinner[] mTerms = {
            new ValuesForObjectsInSpinner("aktywność", R.string.activityDEF),
            new ValuesForObjectsInSpinner("ALARA", R.string.alaraDEF),
            new ValuesForObjectsInSpinner("bezpieczeństwo jądrowe", R.string.nuclearSafetyDEF),
            new ValuesForObjectsInSpinner("czas martwy", R.string.deadTimeDEF),
            new ValuesForObjectsInSpinner("dawka pochłonięta", R.string.absorbedDoseDEF),
            new ValuesForObjectsInSpinner("dawka równoważna", R.string.equivalentDoseDEF),
            new ValuesForObjectsInSpinner("dawka skuteczna", R.string.effectiveDoseDEF),
            new ValuesForObjectsInSpinner("dawka zbiorowa", R.string.collectiveDoseDEF),
            new ValuesForObjectsInSpinner("LET", R.string.letDEF),
            new ValuesForObjectsInSpinner("ochrona radiologiczna", R.string.radiationProtectionDEF),
            new ValuesForObjectsInSpinner("odpad", R.string.wasteDEF),
            new ValuesForObjectsInSpinner("skażenie promieniotwórcze", R.string.radioactiveContaminationDEF),
            new ValuesForObjectsInSpinner("teren kontrolowany", R.string.controlledAreaDEF),
            new ValuesForObjectsInSpinner("teren nadzorowany", R.string.supervisedAreaDEF),
            new ValuesForObjectsInSpinner("współczynnik osłabienia", R.string.attenuationFactorDEF),
            new ValuesForObjectsInSpinner("zdarzenie radioacyjne", R.string.radiationEventDEF),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        mListView = (ListView) findViewById(R.id.listView);
        SpecificSpinnerAdapter adapterForChooseCategorySpinner = new SpecificSpinnerAdapter(Dictionary.this,
                android.R.layout.simple_list_item_1, mTerms);
        mListView.setAdapter(adapterForChooseCategorySpinner);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ValuesForObjectsInSpinner term = (ValuesForObjectsInSpinner) (parent.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(), getString(term.getDefinition()), Toast.LENGTH_SHORT).show();
                Intent showDefinition = new Intent(Dictionary.this, ShowDefinition.class);
                showDefinition.putExtra(ShowDefinition.SHOW_DEFINITION, term.getDefinition());
                startActivityForResult(showDefinition, 0);
            }
        });
    }
}
