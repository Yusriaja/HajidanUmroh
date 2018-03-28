package com.d4it_b.hajidanumroh;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.d4it_b.hajidanumroh.utils.ThemeUtils;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
	Spinner spinner;
    ArrayList<String> spinnerArray;
    ArrayAdapter<String> spinnerArrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.settings_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                onBackPressed();
            }
        });

        spinnerArray = new ArrayList<String>();
        spinnerArray.add("Dark_Green_Theme");
        spinnerArray.add("Soft_Dark_Green");
        spinnerArray.add("An_Nur_Theme");
        spinner = findViewById(R.id.spinner);
        spinnerArrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

	}

//	ThemeUtils.changeToTheme(SettingsActivity.this, position);

    @Override
    public void onBackPressed() {
        ThemeUtils.changeToTheme(SettingsActivity.this, spinner.getSelectedItemPosition());
        startActivity(new Intent(SettingsActivity.this, MainAct.class));


    }
}
