package com.d4it_b.hajidanumroh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.d4it_b.hajidanumroh.model.SubMenuContent;
import com.d4it_b.hajidanumroh.model.DetailContent;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    public int idHaji = 0;
    public int counIdHaji = 1;
    public int idDetailHaji = 1;
    public DBHandler dbHandler;
    ArrayList<SubMenuContent> dataHaji;
    ArrayList<DetailContent> dataDetailHaji;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash_screen);

        dbHandler=new DBHandler(this);
        dataHaji = new ArrayList<>();
        dataDetailHaji = new ArrayList<>();

        Thread thread = new Thread(){
            public void run(){
                try{
                    dataHaji.add(new SubMenuContent(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new SubMenuContent(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new SubMenuContent(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new SubMenuContent(idHaji++, "Data Haji "+idHaji));
                    dataHaji.add(new SubMenuContent(idHaji++, "Data Haji "+idHaji));

                    dataDetailHaji.add(new DetailContent(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailContent(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailContent(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailContent(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));
                    dataDetailHaji.add(new DetailContent(idDetailHaji++, "DetailHaji" + counIdHaji, counIdHaji++ ));

//                    if (dbHandler.isHajiEmpty()){
                        dbHandler.addAllHaji(dataHaji);
                        dbHandler.addAllDetail(dataDetailHaji,"tb_haji");
//                    }
                    sleep(4000);
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
