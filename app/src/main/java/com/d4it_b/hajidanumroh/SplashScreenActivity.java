package com.d4it_b.hajidanumroh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.d4it_b.hajidanumroh.db.DBHandler;
import com.d4it_b.hajidanumroh.db.DbQueries;
import com.d4it_b.hajidanumroh.model.DetailContent;
import com.d4it_b.hajidanumroh.model.IsiDetailContent;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

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

                    subMenuContents.add(new SubMenuContent(idSubMenu,1, "Pengertian"));
                        detailContents.add(new DetailContent(idDetailContent++, "Umrah adalah berkunjung ke Baitullah (Kabah) untuk melakukan thawaf, sai dan mencukur rambut demi mengharap ridla Allah SWT. Serangkaian pelaksanaan ibadah umrah ini dapat disebut IHTOSAKUR (Ihram, Towaf, Sai dan Cukur). Masing-masing dari rukun umrah harus dilaksanakan secara benar dan tertib.", idSubMenu++, null, null, null, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu,1, "Rukun Umrah"));
                        detailContents.add(new DetailContent(idDetailContent++, "Arti Rukun Umroh.", idSubMenu, null, null,null , 1));

                        detailContents.add(new DetailContent(idDetailContent, "Ihram.", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Berihram dari miqat, praktik pelaksanaan adalah :", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "a.\tBersuci ( mandi & wudlu ) ", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "b.\tBerpakaian ihram", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "c.\tShalat sunnah ihram dua rakaat kemudian berdoa.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "d.\tNiat ihram dari miqat ", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "e.\tBerangkat ke masjidil haram untuk melaksanakan thawaf, sai dan cukur. Selama dalam perjalanan menuju Masjidil Haram disunnahkan membaca talbiyah, shalawat dan doa.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "f.\tMembaca doa ketika memasuki Masjidil Haram", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "g.\tMembaca doa ketika melihat Kabah", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Thawaf.", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Thawaf adalah mengelilingi Kabah tujuh kali dengan tuntutan sebagai berikut :", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "a.\tDiawali dengan melihat lampu hijau disebelah kanan atas yang sudah disetting lurus dengan Hajar Aswad, kemudian menghadapkan seluruh badan ke arah Hajar Aswad. Jika tidak memungkinkan maka cukup dengan sedikit badan. Pada saat memulai thawaf, hukumnya sunnah mencium Hajar Aswad, jika tidak memungkinkan maka cukup melambaikan tangan ke arah Hajar Aswad, kemudian mengecupnya. Pada saat itu sunnah membaca dzikir :", "بِسْمِ اللهِ وَاللهُ أَكْبَرُ", "Artinya:\n" +
                                    "Dengan menyebut nama Allah, Allah Maha Besar.\n", "BISMILLAAHI WALLAAHU AKBAR"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "b.\tSelama thawaf (mengelilingi kabah) Kabah harus selalu berada di sebelah kiri badan.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "c.\tMembaca dzikir mulai dari sudut Hajar Aswad sampai Rukun Yamani", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "d.\tSetiap sampai di Rukun Yamani usahakan mengusapnya atau mengangkat tangan (tanpa mengecup) sambil membaca:", "بِسْمِ اللهِ وَالله أَكْبَرُ", "Artinya:\n" +
                                    "Dengan menyebut nama Allah, Allah Maha Besar.\n", "BISMILLAAHI WALLAHU AKBAR "));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "e.\tMembaca doa mulai dari Rukun Yamani sampai garis lurus Hajar Aswad", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "f.\tSetelah selesai melaksanakan thawaf disunnahkan melakukan beberapa hal berikut; \n" +
                                    "\t•\tDoa di Multazam \n" +
                                    "\t•\tShalat sunnah thawaf dua rakaat di Maqam Ibrahim\n" +
                                    "\t•\tMinum air zam-zam sebelum Sai\n", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Sa'i.", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Sai adalah berjalan dari bukit Shafa ke bukit Marwah, dan sebaliknya sebanyak tujuh kali. Perjalanan dari bukit Shafa ke bukit Marwah atau sebaliknya masing-masing dihitung satu kali. Syarat - syarat sahnya sai:\n" +
                                    "\t•\tDidahului dengan thawaf\n" +
                                    "\t•\tTujuh kali perjalanan antara bukit Shafa dan Marwah\n" +
                                    "\t•\tDilakukan di tempat sai\n" +
                                    "\t•\tTertib\n", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Cukur.", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Tahallul dengan mencukur atau menggunting rambut adalah akhir pelaksanaan ibadah umrah. Rambut yang harus digunting paling sedikit adalah tiga helai rambut. Namun yang lebih utama bagi orang lelaki adalah mencukur semua rambutnya (pelontos). Sedangkan yang mencukur atau yang menggunting adalah orang yang tidak sedang berihram atau orang yang sudah bertahallul.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Tertib.", idSubMenu++, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Tahallul dengan mencukur atau menggunting rambut adalah akhir pelaksanaan ibadah umrah. Rambut yang harus digunting paling sedikit adalah tiga helai rambut. Namun yang lebih utama bagi orang lelaki adalah mencukur semua rambutnya (pelontos). Sedangkan yang mencukur atau yang menggunting adalah orang yang tidak sedang berihram atau orang yang sudah bertahallul.", null, null, null));

                    subMenuContents.add(new SubMenuContent(idSubMenu,1, "Larangan Selama Ihram Sampai Tahallul / Cukur"));
                        detailContents.add(new DetailContent(idDetailContent, "Larangan Khusus Laki-laki", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "a.\tMemakai pakaian berjahit", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "b.\tMemakai sepatu yang menutupi tumit", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "c.\tMenutupi kepala yang melekat seperti topi. Namun jika sangat dingin atau ada luka yang harus di perban maka diperbolehkan.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Khusus Perempuan.", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "a.\tMemakai kaos tangan", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "b.\tMenutupi muka, baik cadar atau masker", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Larangan Umum Bagi Laki-laki dan Perempuan.", idSubMenu++, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "a.\tMemakai wangi-wangian kecuali yang sudah dipakai di badan sebelum niat ihram.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "b.\tMemotong kuku dan mencukur atau mencabut rambut badan.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "c.\tMemburu binatang buruan darat yang liar dan boleh dimakan.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "d.\tMembunuh dan menganiaya binatang buruan darat dengan cara apapun (kecuali binatang yang membahayakan boleh dibunuh)", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "e.\tNikah, menikahkan atau meminang wanita untuk dinikahi/dinikahkan.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "f.\tBercumbu atau bersetubuh.", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "g.\tMencaci, bertengkar atau mengucapkan kata-kata kotor.", null, null, null));
//                    =====================================================================================================
                    subMenuContents.add(new SubMenuContent(idSubMenu,2, "Pengertian Haji"));
                        detailContents.add(new DetailContent(idDetailContent, "\tHaji adalah berkunjung ke Baitullah (Kabah) untuk melakukan beberapa ritual, antara lain wukuf, thawaf, sai, dan amal ibadah lainnya pada masa tertentu demi memenuhi panggilan Allah dan mengharapkan ridla-Nya.\n" +
                                "\tHaji adalah serangkaian ibadah IHWU MAMUZMIN LONTOI SAKUR (ihram, wukuf, mabit di Muzdalifah, mabit di Mina, lontar jumrah, thawaf ifadlah, sai dan cukur). Masing-masing ini harus dilakukan dengan benar pada tempat dan waktu yang telah ditentukan, demi memperoleh ridla Allah.\n" +
                                "\tIbadah haji ini diwajibkan kepada seluruh umat Islam yang memiliki kemampuan fisik, finansial dan lain-lain. Ibadah haji hanya diwajibkan satu kali seumur hidup, jadi ibadah haji berikutnya adalah ibadah haji sunnah, kecuali orang yang nadzar melakukan haji, maka wajib untuk melaksanakannya.\n", idSubMenu++, null, null, null, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu,2, "Rukun dan Wajib Haji"));
                        detailContents.add(new DetailContent(idDetailContent, "Ihram (Rukun Haji)", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tKetentuan waktu ihram haji menurut jumhur ulama boleh dilaksanakan sejak tanggal 1 Syawal sampai terbit fajar tanggal 10 Dzulhijjah. Orang yang ihram haji diluar ketentuan waktu itu maka hajinya tidak sah. Orang yang niat ihram setelah tanggal 10 Dzulhijjah maka menjadi ihram umrah, meskipun dengan niat ihram haji. Ihram haji adalah niat melaksanakan ibadah haji dari miqot dengan ketentuan sebagai berikut:\n" +
                                    "\ta.\tBersuci (mandi dan wudlu)\n" +
                                    "\tb.\tBerpakaian ihram\n" +
                                    "\tc.\tShalat sunnah ihram dua rakaat\n" +
                                    "\td.\tNiat ibadah haji \n", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent++, "Niat Ihram dari Miqot (Wajib Haji)", idSubMenu, null, null, null, 1));

                        detailContents.add(new DetailContent(idDetailContent, "Wukuf di Arafah (Rukun Haji)", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Wukuf di Arafah termasuk salah satu rukun haji yang paling utama. Jamaah haji yang tidak melaksanakan wukuf di Arafah berarti tidak mengerjakan haji. Wukuf dilakukan setelah khutbah dan shalat jama qashar taqdim Dhuhur dan Ashar berjamaah. Wukuf dapat dilaksanakan dengan berjamaah atau sendiri-sendiri, dengan memperbanyak zikir, istighfar dan doa, sesuai dengan sunnah Rasul. Untuk wukuf jamaah haji tidak disyaratkan suci dari hadats besar atau kecil. Karena itu wanita yang sedang haid atau nifas boleh melakukan wukuf. Sedangkan bagi jamaah haji yang sakit, pelaksanaannya dilakukan dengan pelayanan khusus sesuai dengan kondisi kesehatannya.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Mabit di Muzdalifah (Wajib Haji)", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Mabit di Muzdalifah adalah bersinggah di Muzdalifah pada malam tanggal 10 Dzulhijjah setelah wukuf di Arafah. Ketentuan mabit di Muzdalifah adalah keberadaan seseorang di Muzdalifah boleh hanya sesaat setelah lewat tengah malam. Menurut sebagian besar ulama hukumnya Mabit di Muzdalifah adalah wajib. Menurut sebagian ulama yang lain hukumnya sunnah. Bagi yang tiba di Muzdafilah sebelum tengah malam harus menunggu sampai lewat tengah malam. Pada saat mabit hendaknya bertalbiyah, berzikir, beristighfar, berdoa atau membaca Al-Quran selanjutnya mencari kerikil sebanyak 7 atau 49 atau 70 butir. Kerikil dapat diambil dari mana saja, namun disunnahkan dari Muzdalifah.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Mabit di Mina (Wajib Haji)", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Hukum mabit di Mina menurut jumhur ulama adalah wajib. Sebagian ulama menyatakan sunat. Waktu mabit yaitu malam tanggal 11, 12 dan 13 Dzulhijah. Tempat mabit bagi sebagian besar jamaah haji Indonesia adalah Haratul Lisan. Haratul Lisan adalah termasuk wilayah hukum Mabit Mina. Kemungkinan pengembangan wilayah seperti ini sama halnya dengan pengembangan Masjid Nabawi dan Masjidil Haram. Sejak tahun 1984 pemerintahan Arab Saudi telah menetapkan Haratul Lisan sebagai tempat Mabit dan kemudian makin meluas sesuai dengan kondisi perhajian sehingga mulai tahun 2001 sebagian jamaah haji mendapatkan perkemahan yang masuk dalam batas daerah Muzdalifah. Hukum mabit perluasan Mina di tempat tersebut sah dan dapat diterima sebagai daerah perluasan hukum untuk mabit di Mina karena kemah darurat dan bersambung.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Melontar Jumrah Ula, Wustho dan Aqobah (Wajib Haji)", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Hukum melontar jumrah adalah wajib, apabila tidak dapat melaksanakannya maka boleh digantikan kepada orang lain yang sudah melakukan. Jika terpaksa tidak, maka wajib membayar dam/fidyah.\n" +
                                    "Tata cara melontar jamarat :\n" +
                                    "a.\tKerikil masuk Marma (lubang)\n" +
                                    "b.\tMelontar dengan kerikil satu persatu, sedangkan melontar dengan 7 (tujuh) kerikil sekaligus tetap dihitung satu kali lontaran.\n" +
                                    "c.\tMelontar jamarat dengan urutan yang benar yaitu mulai dengan jamrah Ula lalu Wustha dan terakhir Aqabah.\n" +
                                    "d.\tYang dipakai untuk melontar adalah batu kerikil, selain itu tidak sah seperti sandal, payung, dan lain sebagainya.\n" +
                                    "Waktu melontar\n" +
                                    "a.\tPada tanggal 10 Zulhijah yang dilontar adalah jumrah Aqabah saja. Waktu afdhalnya setelah terbit matahari hari Nahr, waktu ikthiar (memilih) bada Dhuhur sampai terbenam matahari dan waktu jawaz (diperbolehkan) adalah mulai lewat tengah malam 10 Dzulhijjah sampai dengan terbit fajar tanggal 11 Dzulhijjah,\n" +
                                    "b.\tPada hari Tasyrik (11, 12 dan 13 Zulhijjah) melontar ketiga jamarat : Ula, Wustha, dan Aqabah. Waktunya sebagai berikut:\n" +
                                    "\t•\tWaktu Afdhal (utama) bada Zawal.\n" +
                                    "\t•\tWaktu Ikhtiar (memilih), yakni setelah ashar sampai malam.\n" +
                                    "\t•\tWaktu Jawaz mulai terbit fajar sampai zawal (tergelincirnya matahari)\n" +
                                    "c.\tBagi orang yang tidak melontar jumrah tepat pada harinya maka boleh melontar pada hari berikutnya selama masih dalam hari Tasyriq.\n", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Thawaf Ifadlah (Rukun Haji)", idSubMenu, null, null, null, 1));

                        detailContents.add(new DetailContent(idDetailContent, "Sai (Rukun Haji)", idSubMenu, null, null, null, 1));
                        detailContents.add(new DetailContent(idDetailContent, "Cukur (Rukun Haji)", idSubMenu, null, null, null, 1));
                        detailContents.add(new DetailContent(idDetailContent, "Thawaf Wada (Wajib Haji)", idSubMenu++, null, null, null, 1));

                        dbQueries.addAllDataSubMenu(subMenuContents);
                        dbQueries.addAllDataDetailContent(detailContents);
                        dbQueries.addAllIsi(isiDetailContents);
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
