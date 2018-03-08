package com.d4it_b.hajidanumroh;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.d4it_b.hajidanumroh.adapter.AdapterDetail;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TextView textView, labelActivity;
    private AdapterDetail adapterDetail;
    private ArrayList<String> listDetail;

    private RecyclerView.LayoutManager mLayoutManager;

    private DBHandler dbHandler;

    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_haji);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapterDetail = new AdapterDetail(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        cardView = (CardView)findViewById(R.id.card_view);
        textView = (TextView)findViewById(R.id.title_detail);
        labelActivity = (TextView)findViewById(R.id.activityLabel);

        dbHandler = new DBHandler(this);

        listDetail = new ArrayList<>();

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Honej.ttf");

        textView.setText(getIntent().getExtras().getString("title"));
        labelActivity.setTypeface(tf);

        if (getIntent().getIntExtra("isSetIsi", 0) != 0){
            labelActivity.setText(dbHandler.getTitleAct(getIntent().getIntExtra("idTitle", 0), "tb_sub_menu"));
            listDetail = dbHandler.getTextIsiDetailContent(getIntent().getIntExtra("id", 0));
            adapterDetail.setData(listDetail);
        }else{
            labelActivity.setText(dbHandler.getTitleAct(getIntent().getIntExtra("idTitle", 0), "tb_utama"));
            listDetail = dbHandler.getTextDetailContent(getIntent().getIntExtra("id", 0));
            adapterDetail.setData(listDetail);
        }
        mRecyclerView.setAdapter(adapterDetail);
    }

}
