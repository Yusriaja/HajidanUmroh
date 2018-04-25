package com.d4it_b.hajidanumroh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.d4it_b.hajidanumroh.db.DBHandler;
import com.d4it_b.hajidanumroh.db.DbQueries;
import com.d4it_b.hajidanumroh.model.DetailContent;
import com.d4it_b.hajidanumroh.model.IsiDetailContent;
import com.d4it_b.hajidanumroh.model.SubMenuContent;
import com.d4it_b.hajidanumroh.utils.ThemeUtils;

import java.io.IOException;
import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    int idSubMenu = 1;
    int idDetailContent = 1;
    int idIsiDetail = 1;

    public DBHandler dbHandler;

    DbQueries dbQueries;

    ArrayList<SubMenuContent>subMenuContents;
    ArrayList<DetailContent>detailContents;
    ArrayList<IsiDetailContent>isiDetailContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.act_splash_screen);

        dbHandler=new DBHandler(this);
        dbQueries = new DbQueries(getApplicationContext());

        subMenuContents = new ArrayList<>();
        detailContents = new ArrayList<>();
        isiDetailContents = new ArrayList<>();
        if (!dbHandler.isDataBaseExists()){
            try {
                dbHandler.importDataBaseFromAssets();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Thread thread = new Thread(){
            public void run(){

                try{

                    dbQueries.open();
//                        dbQueries.addAllDataSubMenu(subMenuContents);
//                        dbQueries.addAllDataDetailContent(detailContents);
//                        dbQueries.addAllIsi(isiDetailContents);
                    sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreenActivity.this, MainAct.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
