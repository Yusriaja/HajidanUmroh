package com.d4it_b.hajidanumroh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailHajiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_haji);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DBHandler dbHandler = new DBHandler(this);
        TextView tex_detail_haji = (TextView)findViewById(R.id.tex_detail_haji);

        Bundle bundle = getIntent().getExtras();

        tex_detail_haji.setText(dbHandler.getDetailHaji(bundle.getInt("IdDetailHaji")).getString_detail_haji());
    }

}
