package com.d4it_b.hajidanumroh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.d4it_b.hajidanumroh.model.DetailContent;
import com.d4it_b.hajidanumroh.model.IsiDetailContent;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    int idSubMenu = 1;
    int idDetailContent = 1;
    int idIsiDetail = 1;

    public DBHandler dbHandler;

    ArrayList<SubMenuContent>subMenuContents;
    ArrayList<DetailContent>detailContents;
    ArrayList<IsiDetailContent>isiDetailContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash_screen);

        dbHandler=new DBHandler(this);

        subMenuContents = new ArrayList<>();
        detailContents = new ArrayList<>();
        isiDetailContents = new ArrayList<>();
        Thread thread = new Thread(){
            public void run(){
                try{
                    dbHandler.addMainTable(1, "Umroh");
                    dbHandler.addMainTable(2, "Haji");
                    dbHandler.addMainTable(3, "Sholat");
                    dbHandler.addMainTable(4, "Doa");
                    dbHandler.addMainTable(5, "DAM");

//                    Sub menu Umroh
                    subMenuContents.add(new SubMenuContent(idSubMenu,1,  "Pengertian"));
                        detailContents.add(new DetailContent(idDetailContent++ ,"Umrah adalah berkunjung ke Baitullah (Kabah) untuk melakukan thawaf, sai dan mencukur rambut demi mengharap ridla Allah SWT. Serangkaian pelaksanaan ibadah umrah ini dapat disebut IHTOSAKUR (Ihram, Towaf, Sai dan Cukur). Masing-masing dari rukun umrah harus dilaksanakan secara benar dan tertib." ,idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu,1,  "Rukun Umrah"));
                        detailContents.add(new DetailContent(idDetailContent, "1.\tIhram", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Berihram dari miqat, praktik pelaksanaan adalah :"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tBersuci ( mandi & wudlu ) \n" +
                                                                                                            "b.\tBerpakaian ihram\n" +
                                                                                                            "c.\tShalat sunnah ihram dua rakaat kemudian berdoa.\n" +
                                                                                                            "d.\tNiat ihram dari miqat \n" +
                                                                                                            "e.\tBerangkat ke masjidil haram untuk melaksanakan thawaf, sai dan cukur. Selama dalam perjalanan menuju Masjidil Haram disunnahkan membaca talbiyah, shalawat dan doa.\n" +
                                                                                                            "f.\tMembaca doa ketika memasuki Masjidil Haram\n" +
                                                                                                            "g.\tMembaca doa ketika melihat Kabah\n"));
                        detailContents.add(new DetailContent(idDetailContent, "2.\tThawaf", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Thawaf adalah mengelilingi Kabah tujuh kali dengan tuntutan sebagai berikut :"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tDiawali dengan melihat lampu hijau disebelah kanan atas yang sudah disetting lurus dengan Hajar Aswad, kemudian menghadapkan seluruh badan ke arah Hajar Aswad. Jika tidak memungkinkan maka cukup dengan sedikit badan. Pada saat memulai thawaf, hukumnya sunnah mencium Hajar Aswad, jika tidak memungkinkan maka cukup melambaikan tangan ke arah Hajar Aswad, kemudian mengecupnya. Pada saat itu sunnah membaca dzikir : بِسْمِ اللهِ وَاللهُ أَكْبَرُ BISMILLAAHI WALLAAHU AKBAR\n" +
                                    "Artinya:\n" +
                                    "Dengan menyebut nama Allah, Allah Maha Besar.\n" +
                                    "\n" +
                                    "b.\tSelama thawaf (mengelilingi kabah) Kabah harus selalu berada di sebelah kiri badan.\n" +
                                    "c.\tMembaca dzikir mulai dari sudut Hajar Aswad sampai Rukun Yamani\n" +
                                    "d.\tSetiap sampai di Rukun Yamani usahakan mengusapnya atau mengangkat tangan (tanpa mengecup) sambil membaca:\n" +
                                    "بِسْمِ اللهِ وَالله أَكْبَرُ\n" +
                                    "BISMILLAAHI WALLAHU AKBAR \n" +
                                    "Artinya:\n" +
                                    "Dengan menyebut nama Allah, Allah Maha Besar.\n" +
                                    "e.\tMembaca doa mulai dari Rukun Yamani sampai garis lurus Hajar Aswad\n" +
                                    "f.\tSetelah selesai melaksanakan thawaf disunnahkan melakukan beberapa hal berikut; \n" +
                                    "•\tDoa di Multazam \n" +
                                    "•\tShalat sunnah thawaf dua rakaat di Maqam Ibrahim\n" +
                                    "•\tMinum air zam-zam sebelum Sai\n"));

                        detailContents.add(new DetailContent(idDetailContent, "3.\tSai", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Sai adalah berjalan dari bukit Shafa ke bukit Marwah, dan sebaliknya sebanyak tujuh kali. Perjalanan dari bukit Shafa ke bukit Marwah atau sebaliknya masing-masing dihitung satu kali. Syarat - syarat sahnya sai:"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "•\tDidahului dengan thawaf\n" +
                                                                                                            "•\tTujuh kali perjalanan antara bukit Shafa dan Marwah\n" +
                                                                                                            "•\tDilakukan di tempat sai\n" +
                                                                                                            "•\tTertib\n"));

                        detailContents.add(new DetailContent(idDetailContent, "4.\tCukur", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Tahallul dengan mencukur atau menggunting rambut adalah akhir pelaksanaan ibadah umrah. Rambut yang harus digunting paling sedikit adalah tiga helai rambut. Namun yang lebih utama bagi orang lelaki adalah mencukur semua rambutnya (pelontos). Sedangkan yang mencukur atau yang menggunting adalah orang yang tidak sedang berihram atau orang yang sudah bertahallul."));

                        detailContents.add(new DetailContent(idDetailContent, "5.\tTertib", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Tertib adalah mendahulukan apa yang mestinya didahulukan dan mengakhirkan apa yang mestinya diakhirkan, sebagaimana urutan berikut : 1. Ihram, 2. Thawaf, 3. Sai, dan 4. Cukur / menggunting rambut."));

                    subMenuContents.add(new SubMenuContent(idSubMenu,1,  "Larangan Selama Ihram Sampai Tahallul / Cukur"));
                        detailContents.add(new DetailContent(idDetailContent++, "1.\tLarangan Khusus Laki-laki", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "2.\t Khusus Perempuan", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "3.\tLarangan Umum Bagi Laki-laki dan Perempuan.", idSubMenu++, 1));

//                    ====================================================================================================================
//                    Sub menu Haji
                    subMenuContents.add(new SubMenuContent(idSubMenu, 2, "Pengertian"));
                        detailContents.add(new DetailContent(idDetailContent++, "Haji adalah berkunjung ke Baitullah (Kabah) untuk melakukan beberapa ritual, antara lain wukuf, thawaf, sai, dan amal ibadah lainnya pada masa tertentu demi memenuhi panggilan Allah dan mengharapkan ridla-Nya.\n" +
                            "Haji adalah serangkaian ibadah IHWU MAMUZMIN LONTOI SAKUR (ihram, wukuf, mabit di Muzdalifah, mabit di Mina, lontar jumrah, thawaf ifadlah, sai dan cukur). Masing-masing ini harus dilakukan dengan benar pada tempat dan waktu yang telah ditentukan, demi memperoleh ridla Allah.\n" +
                            "Ibadah haji ini diwajibkan kepada seluruh umat Islam yang memiliki kemampuan fisik, finansial dan lain-lain. Ibadah haji hanya diwajibkan satu kali seumur hidup, jadi ibadah haji berikutnya adalah ibadah haji sunnah, kecuali orang yang nadzar melakukan haji, maka wajib untuk melaksanakannya.\n", idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu++, 2, "Rukun dan Wajib Haji"));
//                    ==============================================================================================================================
//                    Sub menu dam
                    subMenuContents.add(new SubMenuContent(idSubMenu, 5, "Pengertian"));
                        detailContents.add(new DetailContent(idDetailContent++, "Dam dalam pengertian bahasa adalah darah, sedangkan menurut istilah adalah mengalirkan darah (menyembelih) hewan ternak, yaitu kambing, sapi, unta di tanah haram, atau melakukan puasa atau memberikan makanan kepada orang-orang miskin dalam rangka memenuhi ketentuan manasik Haji.", idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu++, 5, "Macam - Macam Dam"));

                    subMenuContents.add(new SubMenuContent(idSubMenu++, 5, "Ketentuan - Ketentuan Dam"));

//                    =================================================================================================================================
//                    Sub menu sholat
                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Lis-Safar"));
                        detailContents.add(new DetailContent(idDetailContent++, "Shalat Sunnah lis-Safar adalah shalat yang sunnah dilakukan bagi setiap orang yang mau bepergian, baik dekat atau jauh.\n" +
                                "Niat Shalat Sunnah Lis-Safar :\n" +
                                "اُصَلِّى سُنَّةً لِلسَّفَرِ رَكْغَتَيْنِ ِللهِ تَعَـالَى : اَللهُ اَكْبَرُ\n" +
                                "USHALLII SUNNATAN LIS-SAFARI RAKATAINI LILLAAHI TAAALAA\n" +
                                "Artinya:\n" +
                                "Saya niat shalat sunnah bepergian dua rakaat karena Allah\n", idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu++, 3, "Shalat Jama"));
                    subMenuContents.add(new SubMenuContent(idSubMenu++, 3, "Shalat Jama Qoshar"));

//                    Sub menu Doa
                    subMenuContents.add(new SubMenuContent(idSubMenu++, 4, "Doa Dalam Perjalanan Keberangkatan"));
                    subMenuContents.add(new SubMenuContent(idSubMenu++, 4, "Doa Ketika Tiba Di Tempat Tujuan"));

                    dbHandler.addAllTableSubMenu(subMenuContents);
                    dbHandler.addAllDetailContent(detailContents);
                    dbHandler.addAllIsiDetail(isiDetailContents);
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
