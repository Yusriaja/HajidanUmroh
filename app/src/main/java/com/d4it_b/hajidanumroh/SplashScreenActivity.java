package com.d4it_b.hajidanumroh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.d4it_b.hajidanumroh.model.haji.DetailHaji;
import com.d4it_b.hajidanumroh.model.haji.Haji;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    public int idHaji = 1;
    public int counIdHaji = 1;
    public int idDetailHaji = 1;
    public DBHandler dbHandler;
    ArrayList<Haji> dataHaji;
    ArrayList<DetailHaji> dataDetailHaji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        dbHandler=new DBHandler(this);
        dataHaji = new ArrayList<>();
        dataDetailHaji = new ArrayList<>();

        Thread thread = new Thread(){
            public void run(){
                try{
                    dataHaji.add(new Haji(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new Haji(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new Haji(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new Haji(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new Haji(idHaji++, "Data Haji "+idHaji));

                    dataDetailHaji.add(new DetailHaji(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailHaji(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailHaji(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailHaji(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailHaji(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));

//                    if (dbHandler.isHajiEmpty()){
                        dbHandler.addAllHaji(dataHaji);
                        dbHandler.addAllDetailHaji(dataDetailHaji);
//                    }
                    sleep(4000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
