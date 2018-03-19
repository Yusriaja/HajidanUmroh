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
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Thawaf adalah mengelilingi Kabah sebanyak tujuh kali dimulai dan diakhiri pada arah sejajar dari Hajar Aswad. Sedangkan thawaf ifadlah adalah thawaf yang merupakan salah satu rukun haji. Jika thawaf ifadlah ini tidak dilaksanakan maka hajinya tidak sah. Orang haji yang sedang sakit maka thawafnya dengan pelayanan khusus. Thawaf ifadlah juga disebut dengan thawaf ziyarah dan thawaf rukun. Waktu pelaksanaan thawaf ifadlah adalah sebagai berikut:\n" +
                                    "a.\tMenurut imam Syafii dan imam Ahmad bin Hanbal waktu pelaksanaan thawaf ifadlah adalah sejak lewatnya tengah malam dari malam hari Nahr (tanggal 10 Dzulhijjah), dan tidak ada batas waktu akhirnya. Namun demikian, kalau ada kesempatan agar segera melakukannya. Orang yang belum melaksanakan thawaf ifadlah maka belum boleh bersetubuh antara suami istri.\n" +
                                    "b.\tMenurut fatwa MUI thawaf ifadlah boleh dilakukan sebelum melontar jumrah Aqobah.\n", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Sai (Rukun Haji)", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Pelaksanaan sai haji sama dengan pelaksanaan sai Umrah. Sai hanya dapat dilaksanakan setelah melaksanakan thawaf ifadlah atau thawaf umrah. Tidak ada sai sunnah.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Cukur (Rukun Haji)", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Cara melaksanakan cukur dalam haji sama dengan praktik pelaksanaan cukur dalam umrah. Waktu Cukur Haji :\n" +
                                    "a.\tMenurut ulama madzhab Syafii cukur boleh dilaksanakan pada hari nahr sesudah melontar jumrah Aqobah. Bagi orang yang mendahulukan thawaf ifadlah sebelum lontar jumrah Aqobah maka boleh mencukur / menggunting rambut setelah thawaf dan sai.\n" +
                                    "b.\tMenurut ulama madzhab Hanbali pelaksanaan cukur boleh diakhirkan sampai pada hari-hari tasyriq.\n", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Thawaf Wada (Wajib Haji)", idSubMenu++, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Thawaf wada adalah thawaf penghormatan terakhir kepada Baitullah. Thawaf wada dilakukan sebagaimana thawaf-thawaf yang lain, yakni dimulai dari hajar aswad sampai kembali ke arah hajar aswad lagi sebanyak tujuh kali. Hanya saja dalam thawaf wada tidak sunnah berlari-lari kecil, cukup berjalan kaki biasa. Waktu pelaksanaan thawaf wada adalah setelah ada ketentuan dari petugas untuk meninggalkan Makkah. Thawaf wada hukumnya wajib. Jamaah haji / umrah yang tidak mengerjakan thawaf wada diwajibkan membayar dam (menyembelih kambing). Wanita yang sedang haid / nifas tidak diwajibkan thawaf wada. Penghormatan kepada Baitullah cukup dengan memandangnya dari pintu Masjid. Dalam hadits dijelaskan bahwa orang yang hendak berangkat keluar dari Makkah belum boleh meninggalkan Makkah sebelum melakukan thawaf wada terlebih dahulu.", null, null, null));
//==========================================================================================================================================
                    subMenuContents.add(new SubMenuContent(idSubMenu,5, "Pengertian Dam "));
                        detailContents.add(new DetailContent(idDetailContent++, "Dam dalam pengertian bahasa adalah darah, sedangkan menurut istilah adalah mengalirkan darah (menyembelih) hewan ternak, yaitu kambing, sapi, unta di tanah haram, atau melakukan puasa atau memberikan makanan kepada orang-orang miskin dalam rangka memenuhi ketentuan manasik Haji", idSubMenu++, null, null, null, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu,5, "Macam - Macam Dam"));
                        detailContents.add(new DetailContent(idDetailContent, "Dam Nusuk ", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Dam Nusuk adalah dam yang dikenakan kepada orang yang melaksanakan Haji Tamattu atau Qiran (bukan dam karena melakukan kesalahan).", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Dam Isaah", idSubMenu++, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "adalah dam yang dikenakan kepada orang yang melanggar aturan atau melaksanakan kesalahan, yaitu:\n" +
                                    "a.\tMeninggalkan salah satu wajib haji atau umrah yang terdiri dari:\n" +
                                    "\t\t•\tTidak berihram dari Miqat\n" +
                                    "\t\t•\tTidak mabit di Muzdalifah\n" +
                                    "\t\t•\tTidak mabit di Mina\n" +
                                    "\t\t•\tTidak melontar jumrah\n" +
                                    "\t\t•\tTidak thawaf wada\n" +
                                    "b.\tMelanggar aturan haji atau umrah:\n" +
                                    "\t\t•\tApabila melanggar larangan ihram berupa mencukur rambut, memotong kuku, atau memakai pakaian yang bertangkup bagi laki-laki, dan menutup muka (cadar/masker) atau memakai sarung tangan bagi wanita dan wangi-wangian bagi laki-laki/wanita wajib membayar fidyah dengan jalan memilih diantara menyembelih seekor kambing, bersedekah kepada 6 (enam) orang miskin dan setiap orang setengah sha (= 2 mud + 1,5 kilo gram beras/makanan yang mengenyangkan) atau berpuasa 3 (tiga) hari.\n" +
                                    "\t\t•\tApabila melanggar larangan ihram berupa membunuh hewan buruan darat yang halal dimakan, maka wajib membayar fidyah atau bersedekah dengan makanan seharga hewan tersebut. Apabila tidak mampu boleh mengganti dengan puasa. Bilangan puasanya disesuaikan menurut banyaknya makanan yang harus disediakan, yaitu satu hari puasa sama dengan satu mud makanan (+ ¾ % kilo gram).\n" +
                                    "\t\t•\tApabila suami istri melanggar ihram dengan bersetubuh sebelum tahallul awal, maka batal hajinya dan wajib membayar dam kifarat menyembelih seekor unta atau sapi atau 7 (tujuh) ekor kambing.\n" +
                                    "\t\t•\tApabila suami istri melanggar larangan dengan bersetubuh setelah tahallul awal, maka tidak batal hajinya tetapi wajib membayar dam yaitu menyembelih seekor unta atau sapi. Pendapat lain mengatakan cukup seekor kambing.\n" +
                                    "\t\t•\tApabila mengadakan akad nikah diwaktu ihram, maka pernikahannya itu batal, tetapi yang bersangkutan tidak membayar dam dan ihram tidak batal.\n" +
                                    "\t\t•\tApabila melakukan rafas, fusuk dan jidal ibadah Hajinya sah akan tetapi gugur pahala hajinya dan tidak kena dam/fidayah.\n", null, null, null));

                    subMenuContents.add(new SubMenuContent(idSubMenu,5, "Ketentuan - Ketentuan Dam "));
                        detailContents.add(new DetailContent(idDetailContent++, "Hukumnya wajib7", idSubMenu, null, null, null, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "Dapat berupa hewan, puasa, atau memberikan makanan kepada orang miskin, sesuai dengan pelanggaran yang dilakukan.", idSubMenu, null, null, null, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "Jika dam berupa hewan maka harus disembelih di tanah haram Makkah, tidak boleh di tempat lain, ", idSubMenu, null, null, null, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "Sunnah disembelih pada hari raya Idul Adlha, namun jika berhalangan maka boleh disembelih di hari-hari yang lain.", idSubMenu, null, null, null, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "Orang yang membayar dam hewan tidak boleh sama sekali memakan dagingnya, wajib disedekahkan semuanya kepada orang miskin. ", idSubMenu, null, null, null, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "Tidak boleh dihadiahkan kepada orang kaya.", idSubMenu++, null, null, null, 1));
//=======================================================================================================================
                    subMenuContents.add(new SubMenuContent(idSubMenu,3, "Shalat Sunnah Lis-Safar"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Lis-Safar", idSubMenu, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Shalat Sunnah lis-Safar adalah shalat yang sunnah dilakukan bagi setiap orang yang mau bepergian, baik dekat atau jauh", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent++, "Niat Shalat Sunnah Lis-Safar", idSubMenu++, null, null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, "اُصَلِّى سُنَّةً لِلسَّفَرِ رَكْغَتَيْنِ ِللهِ تَعَـالَى : اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat sunnah bepergian dua rakaat karena Allah\n", "USHALLII SUNNATAN LIS-SAFARI RAKATAINI LILLAAHI TAAALAA"));


                    subMenuContents.add(new SubMenuContent(idSubMenu,3, "Shalat Jama"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Sholat Jama", idSubMenu, null,null, null, 0));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Jama secara etimologi adalah mengumpulkan. Sedangkan yang dimaksudkan jama dalam konteks ini adalah mengumpulkan antara dua shalat fardlu dan mengerjakannya dalam waktu yang sama. Shalat yang dapat dijama adalah Dhuhur dengan Ashar; Maghrib dengan Isya. Shalat jama boleh dilakukan oleh orang yang sedang bepergian jauh sekitar lebih kurang 90 kilo meter, dan bukan bepergian yang bertujuan kedurhakaan/kemaksiatan.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Jama Taqdim", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Jama Taqdim adalah mengumpulkan dua shalat dan dikerjakan pada waktu shalat yang pertama, mengumpulkan antara Dhuhur dan Ashar dan dikerjakan pada waktu Dhuhur, mengumpulkan antara Maghrib dan Isya dan dikumpulkan pada waktu Maghrib.\n" +
                                    "Syarat-syarat Jama Taqdim :\n" +
                                    "a.\tHarus dimulai dari shalat yang terdahulu, dimulai dari Dhuhur kemudian Ashar, dimulai dari Maghrib kemudian Isya.\n" +
                                    "b.\tPada saat melaksanakan shalat yang pertama harus niat bahwa shalat Ashar di jama taqdim ke Dhuhur, bahwa shalat Isya dijama taqdim ke Maghrib.\n" +
                                    "c.\tSetelah usai melaksanakan shalat yang pertama harus segera melaksanakan shalat yang kedua, tidak boleh dipisah dengan bacaan dzikir yang panjang.\n" +
                                    "\n" +
                                    "Niat Jama Taqdim\n", null, null, null));

                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, null, " اُصَليِّ فَرْضَ الظُّهْرِ اَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَجْمُوْعَتً بِاالْعَصْرِ جَمْعَ تَقْدِيْمٍ اَدَاءً لِلَّهِ تَعَالَى", "Artinya:\n" +
                                    "Saya niat shalat fardlu Dhuhur empat rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Ashar tepat waktu karena Allah\n", "USHALLII FARDLAD DHUHRI ARBAA RAKAAATIN MUSTAQBILAL QIBLATI MAJMUITATAN BILASHRI JAMA TAQDIIMIN ADAA-AN LIL-LAAHI TAAALAA"));

                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, " اُصَليِّ فَرْضَ الْمَغْرِبِ ثَلاَثَ رَكْعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَجْمُوْعَةً بِاالْعِشَاءِ جَمْعَ تَقْدِيْمٍ اَدَاءً لِلَّهِ تَعَالَى", "Artinya:\n" +
                                    "Saya niat shalat fardlu Maghrib tiga rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Isya tepat waktu karena Allah\n", "USHALLII FARDLAL MAGHRIBI TSALAATSA RAKA-AATIN MUSTAQBILAL QIBLATI MAJMUITATAN BIL-TSYAAI JAMA TAQDIIMIN ADAA-AN LIL-LAAHI TAAALAA"));

                        detailContents.add(new DetailContent(idDetailContent, "Jama Takhir", idSubMenu++, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Jama Takhir adalah mengumpulkan dua shalat dan dikerjakan pada waktu shalat yang belakang, mengumpulkan Dhuhur dan Ashar dan dikerjakan pada waktu Ashar, menngumpulkan Maghrib dan Isya dan dikerjakan pada waktu Isya.\n" +
                                    "Sedangkan syarat jama takhir adalah harus berniat bahwa shalat Dhuhur dijama ke shalat Ashar, bahwa shalat Maghrib dijama ke shalat Isya. Niat dilakukan pada waktunya shalat yang pertama. Jadi, ketika waktu Dhuhur sudah masuk maka harus niat bahwa shalat Dhuhur dijama ke shalat Ashar; ketika waktu Maghrib sudah masuk maka harus niat bahwa shalat Maghrib dijama ke shalat Isya.\n" +
                                    "Niat Jama Takhir\n", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, null, "نَوَيْتُ جَمْعَ صَلاَةِ الظُّهْرِ اِلَى صَلاَةِ الْعَصْرِ جَمْعَ تَأْخِيْرِ لِلَّهِ تَعَالَى", "Artinya:\n" +
                                    "Saya niat men-jama takhir shalat Dhuhur ke shalat Ashar karena Allah.\n", "NAWAITU JAMA SHALATID DHUHRI ILAA SHALAATIL ASHRI JAM A TAKHIIRIN LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, " نَوَيْتُ جَمْعَ صَلاَةِ الْمَغْرِبِ اِلَى صَلاَةِ الْعِشَاءِ جَمْعَ تَأْخِيْرِ ِللهِ تَعَالَى", "Artinya:\n" +
                                    "Saya niat men-jama takhir shalat Maghrib ke shalat Isya karena Allah.\n", "NAWAITU JAMA SHALATIL MAGHRIBI ILAA SHALAATIL TSYAAI JAMA TAKHIIRIN LIL-LAAHI TAAALAA "));

                    subMenuContents.add(new SubMenuContent(idSubMenu,3, "Shalat Qoshar"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Qoshar", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Qashar secara etimologi adalah pendek. Sedangkan qashar secara terminologi adalah memperpendek shalat, dari empat rakaat menjadi dua rakaat. Shalat-shalat yang boleh di qashar adalah shalat Dhuhur, Ashar dan Isya. \n" +
                                    "Syarat-syarat qashar ada empat:\n" +
                                    "\t1.\tHarus dalam perjalanan jauh yang bukan tujuan kemaksiatan\n" +
                                    "\t2.\tHarus shalat yang empat rakaat (Dhuhur, Ashar dan Isya)\n" +
                                    "\t3.\tHarus niat qashar\n" +
                                    "\t4.\tTidak bermakmum kepada orang yang menyempurnakan shalatnya empat rakaat.\n", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Shalat Qoshar", idSubMenu++, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, null, "اُصَليِّ فَرْضَ الظُّهْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءًقَصْرًا اِمَامًا/مَأْمُوْمًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat fardlu Dhuhur dua rakaat, menghadap kiblat, tepat waktu dan di-qashar karena Allah \n", "USHALLII FARDLAD DHUHRI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, null, "اُصَليِّ فَرْضَ العَصْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرً اِمَامًا/مَأْمُوْمًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat fardlu Ashar dua rakaat, menghadap kiblat, tepat waktu dan diqashar karena Allah", "USHALLII FARDLAL ASHRI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, "اُصَليِّ فَرْضَ الْعِشَاءِ ركْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرً اِمَامًا/مَأْمُوْمًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat fardlu Isya dua rakaat, menghadap kiblat, tepat waktu dan diqashar karena Allah.\n", "USHALLII FARDLAL ISYAAI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA"));

                    subMenuContents.add(new SubMenuContent(idSubMenu,3, "Shalat Jama Qoshar"));
                        detailContents.add(new DetailContent(idDetailContent, "Jama Taqdim Qoshar:", idSubMenu++, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Menjama taqdim (mengumpulkan) pelaksanakan shalat Ashar ke waktu shalat Dhuhur atau shalat Isya ke waktu shalat Maghrib. Disamping dijama juga diqoshar (diperpendek menjadi dua rakaat), selain shalat Maghrib.\n" +
                                    "Niat Jama Taqdim Qoshar\n", null, null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, null, "اُصَليِّ فَرْضَ الْظُهْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ مَجْمُوْعَةً بِاالْعَصْرِ جَمْعَ تَقْدِيْمٍ قَصْرًا اَدَاءً مَاءْمُومًا/اِمَامًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat fadrlu Dhuhur dua rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Ashar dan di qoshar, tepat waktu karena Allah\n", "USHALLII FARDLAD DHUHRI RAKATAINI MUSTAQBILAL QIBLATI MAJMUUATAN BIL-ASHRI JAMA TAQDIIMIN QASHRAN ADAA-AN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, null, " اُصَليِّ فَرْضَ الْعَصْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرً مَاءْمُومًا/ اِمَامًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat fardlu Ashar dua rakaat, menghadap kiblat, tepat waktu dan diqashar karena Allah.\n", "USHALLII FARDLAL ASHRI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN MAMUUMAN / IMAAMAN LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, null, "ُصَليِّ فَرْضَ المَغْرِبِ ثَلاَثَ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ مَجْمُوْعَةً بِالْعِشَاءِجَمْعَ تَقْدِيْمٍ اَدَاءً اِمَامًا/مَاءْمُومًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat fadrlu Maghrib tiga rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Isya tepat waktu karena Allah\n", "USHALLII FARDLAL MAGHRIBI TSALAATSA RAKAAATIN MUSTAQBILAL QIBLATI MAJMUUATAN BIL-ISYAAI\tJAMA\tTAQDIIMIN\tADAA-AN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, "ُصَليِّ فَرْضَ الْعِشَاءِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرًا اِمَامًا/مَاءْمُومًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat fardlu Isya dua rakaat, menghadap kiblat, tepat waktu dan di-qashar karena Allah.", "USHALLII FARDLU ISYAAI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA"));

                        detailContents.add(new DetailContent(idDetailContent, "Jama Takhir Qoshar", idSubMenu++, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Menjama takhir (mengumpulkan) shalat Dhuhur ke waktu shalat Ashar atau shalat Maghrib ke waktu shalat Isya. Disamping dijama juga diqoshar (diperpendek menjadi dua rakaat), selain shalat Maghrib.\n" +
                                    "Pada saat takbiratul ihram harus berniat qashar, namun tidak lagi perlu berniat jama, karena niat jamanya sudah dilakukan pada waktunya shalat yang pertama.\n", null, null, null));

                    subMenuContents.add(new SubMenuContent(idSubMenu,3, "Shalat Jenazah"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Jenazah", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Praktik pelaksanaannya adalah empat kali takbir tanpa ruku, sujud dan tahiyyat. Takbir yang pertama adalah takbiratul ihram, yang pada saat takbir harus berniat. Sedangkan takbir yang kedua, ketiga dan keempat adalah takbir intiqal, takbir yang menandai perpindahan dari satu rukun ke rukun yang lain.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Niat dan Doa Sholat Jenazah", idSubMenu++, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Niat Untuk Jenazah Laki-laki", "أُصَلِّى عَلَى هَذَا الْمَيِّتِ فَرْضَ كِفَايَةٍ أَرْبَعَ تَكْبِيْرَاتٍ مَأْمُوْمًا/أِمَامًا لِلَّهِ تَعَالَى. أللهُ أَكْبَرُ ", "Artinya:\n" +
                                    "Saya niat shalat untuk jenazah lelaki ini fardu kifayah dengan empat kali takbir, menjadi makmum/imam karena Allah\n", "USHALLII ALAA HAADZAL MAYYITI FARDLA KIFAAYATIN ARBAA TAKBIIRAATIN MAMUUMAN/IMAAMAM LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Niat Untuk Jenazah Perempuan", "أُصَلِّى عَلَى هَذَهِ الْمَيِّتِ فَرْضَ كِفَايَةٍ أَرْبَعَ تَكْبِيْرَاتٍ مَأْمُوْمًا/أِمَامًا لِلَّهِ تَعَالَى. أللهُ أَكْبَرُ ", "Artinya:\n" +
                                    "Saya niat shalat untuk jenazah perempuan ini fardu kifayah dengan empat kali takbir, menjadi makmum/imam karena Allah", "USHALLII ALAA HAADZIHIL MAYYITATI FARDLA KIFAAYATIN ARBAA TAKBIIRAATIN MAMUUMAN/IMAAMAM LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Jika jenis kelamin jenazahnya tidak diketahui atau jenazahnya banyak maka bagi makmum cukup niat sebagai berikut:", "أُصَلِّى عَلَى مَنْ صَلاَّ عَلَيْهِ اْلاِمَامُ فَرْضَ كِفَايَةٍ أَرْبَعَ تَكْبِيْرَاتٍ أِمَامًا لِلَّهِ تَعَالَى ", "Artinya :\n" +
                                    "Saya niat shalat untuk orang yang dishalati imam, fardu kifayah dengan empat kali takbir menjadi makmum karena Allah.\n", "USHALLII ALAA MAN SHALLAA ALAIHIL IMAAMU FARDLA KIFAAYATIN ARBAA TAKBIIRAATIN MAMUUMAN LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Setelah takbir yang pertama membaca al-Fatihah", "اَلْفَاتِحَةُ", null, null));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Setelah takbir yang kedua membaca shalawat", "اَللَّهُمَّ صَلِّى عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى أَلِ سَيِّدِنَا مُحَمَّدٍ كَمَا صَلَيْتَ عَلَى سَيِّدِنَا اِبْرَهِيْمَ وَعَلَى أَلِ سَيِّدِنَا أِبْرَهِيْمَ فِى اْلعَالَمِيْنَ أِنَّكَ حَمِيْدٌ مَجِيْدٌ", "Artinya:\n" +
                                    "Ya Allah limpahkan shalawat (rahmat) kepada nabi Muhammad dan keluarganya sebagaimana Engkau melimpahkan shalawat kepada nabi Ibrahim dan keluarganya di seluruh alam semesta, sesunguhnya Engkau adalah Maha Terpuji dan Maha Agung.", "ALAAHUMMA SHALLI ALAA SAYYIDINAA MUHAMMADIN WA ALAA AALI SAYYIDINAA MUHAMMADIN KAMAA SHALLAITA ALAA SAYYIDINAA IBRAAHIIMA WA ALAA AALI SAYYIDINAA IBRAAHIIMA FIL AALAMIINA INNAKA HAMIIDUN MAJIID"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Setelah takbir yang ketiga membaca doa", "اَللَّهُمَّ غْفِرْلَهُ وَارْحَمْهُ وَعَافِهِ وَاعْفُ عَنْهُ اَللَّهُمَّ اَبْدِ لَهُ دَارًاخَيْرًا مِنْ دَارِهِ وَزَوْجًا خَيْرًا مِنْ زَوْجِهِ وَأَهْلاًّ خَيْرً مِنْ أَهْلِهِ، اَللَّهُمَّ اِنَّهُ نَزَلَ بِكَ وَاَنْتَ خَيْرُ مَنْزُوْلٍ بِهِ اَللَّهُمَّ اَكْرِمْ نُزُلَهُ وَوَسِّعْ مَدْ خَلَهُ", "Ya Allah, ampunilah dia, kasihanilah, sehatkan dan maafkan dia. Ya Allah berilah ganti dia rumah yang lebih baik, istri yang lebih baik dan keluarga yang lebih baik. Ya Allah, sesungguhnya dia bertempat tinggal bersama-Mu, Engkau sebaik-sebaiknya yang ditempat tinggali dia. Ya Allah muliakan tempat tinggalnya dan luaskan tempat masuknya.", "ALLAAHUMMAGHFIR LAHUU WARHAMHU WA AAFIHI WATU ANHU, ALLAAHUMMA ABDILHU DAARAN KHAIRAN MIN DAARIHII WA ZAUJAN KHAIRAN MIN ZAUJIHII WA AHLAN KHAIRAN MIN AHLIHII, ALAAHUMMA INNAHUU NAZALA BIKA WA ANTA KHAIRU MANZUULIN BIHII, ALLAAHUMMA AKRIM NUZULAHUU WA WASSI MADKHALAHUU"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Setelah takbir yang keempat membaca doa berikut kemudian salam", "اَللَّهُمَّ لاَتَحْرِمْنَا أَجْرَهُ وَلاَتَفْتِنَّا بَعْدَهُ وَاغْفِرْلَنَا وَلَهُ أَلسَّلاَمُ عَلَيْكُمْ وَرَحْمَةُ اللهِ وَبَرَكَاتُهُ", "Artinya:\n" +
                                    "Ya Allah, jangan Engkau tutupi kepada kami pahala dia, jangan Engkau fitnah kami setelah kematian dia dan ampunilah kami dan dia.", "ALLAAHUMMA LAA TAHRIMNAA AJRAHUU WA LAA TAFTINNAA BADAHUU WAGHFIR LANAA WA LAHUU. AS-SALAAMU ALAIKUM WA RAHMATUL LAAHI WA BARKAATUH"));

                    subMenuContents.add(new SubMenuContent(idSubMenu,3, "Shalat Sunnah Rawatib"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Rawatib", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Shalat sunnah Rawatib adalah shalat sunnah yang mengikuti pelaksanaan shalat fardlu, baik yang dilakukan sebelumnya maupun sesudahnya.", null, null, null));

                        detailContents.add(new DetailContent(idDetailContent, "Dua Rakaat Sebelum Subuh (Shalat Sunnah Fajar)", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, "ُصَلِّى سُنَّةَ الصُّبْحِ قَبْلِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : أَللهُ أَكْبَرْ" +
                                    "اُصَلِّى سُنَّةَ اْلفَجْرِ رَكْعَتَيْنِ لِلَّهِ تَعَـالَى\n", "Artinya:\n" +
                                    "Saya niat shalat sunnat sebelum Subuh dua rakaat karena Allah/saya niat shalat sunnah Fajar dua rakaat karena Allah\n", "USHALLII SUNNATAS SHUBHI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA USHALLII SUNNATAL FAJRI RAKATAINI LIL-LAAHI TAAALAA "));

                        detailContents.add(new DetailContent(idDetailContent, "Empat Rakaat Sebelum dan Sesudah Dhuhur", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Praktik pelaksanaannya yaitu empat rakaat dijadikan dua kali salam. Jadi setiap dua rakaat salam, kemudian ditambah dua rakaat lagi.", "اُصَلِّى سُنَّةَ الظُّهْرِقَبْلِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : أَللهُ أَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat sunnat sesudah Dhuhur dua rakaat karena Allah\n", "USHALLII SUNNATAD DHUHRI BADIYATAN RAKATAINI LIL-LAAHI TAAALAA"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, "اُصَلِّى سُنَّةَ الظُّهْرِ بَعْدِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : أَللهُ أَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat sunnat sebelum Dhuhur dua rakaat karena Allah\n", "USHALLII SUNNATAD DHUHRI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA"));

                        detailContents.add(new DetailContent(idDetailContent, "Empat Rakaat Sebelum Ashar", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Sebagaimana penjelasan di atas bahwa empat rakaat ini dijadikan dua salam. ", " اُصَلِّى سُنَّةَ اْلعَصْرِقَبْلِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat sunnat sebelum Ashar dua rakaat karena Allah", "USHALLII SUNNATAL ASHRI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA "));

                        detailContents.add(new DetailContent(idDetailContent, "Dua Rakaat Sebelum Maghrib", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Ulama fikih berbeda pendapat tentang shalat sunnah Qabliyah Maghrib ini. Menurut imam Nawawi sunnah melakukan shalat dua rakaat sebelum Maghrib, tetapi menurut sebagian ulama yang lain bahwa shalat dua rakaat sebelum Maghrib tidak disunnahkan", "اُصَلِّى سُنَّةَالْمَغْرِبِ قَبْلِيَة رَكْعَتَيْنِ الله تَعَـالَى : اَللهُ اَكْبَرْ", "Artinya:\n" +
                                    "Saya niat shalat sunnah sebelum Maghrib dua rakaat karena Allah\n", "USHALLII SUNNATAL MAGHRIBI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA "));

                        detailContents.add(new DetailContent(idDetailContent, "Empat Rakaat Setelah Maghrib", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Sebagaimana penjelasan di atas bahwa empat rakaat ini dijadikan dua salam.", "اُصَلِّى سُنَّةَالْمَغْرِبِ بَعْدِيَّةً رَكْعَتَيْنِ الله تَعَـالَى : اَللهُ اَكْبَرُ", "Artinya:\n" +
                                    "Saya niat shalat sunnah setelah Maghrib dua rakaat karena Allah", "USHALLII SUNNATAL MAGHRIBI BADIYATAN RAKATAINI LIL-LAAHI TA AALAA"));

                        detailContents.add(new DetailContent(idDetailContent, "Dua Rakaat Sebelum Isya ", idSubMenu, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, "اُصَلِّى سُنَّةَالْعِشَاءِ قَبْلِيَةً رَكْعَتَيْنِ للهِ تَعَـالَى : اللهُ اَكْبَرْ", "Artinya:\n" +
                                    "Saya niat shalat sunnah sebelum Isya dua rakaat karena Allah", "USHALLII SUNNATAL TSYAAI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA"));

                        detailContents.add(new DetailContent(idDetailContent, "Dua Rakaat Setelah Isya", idSubMenu++, null,null, null, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, null, "اُصَلِّى سُنَّةَالْعِشَاءِ بَعْدِيَّةًبَعْدِيَّةً رَكْعَتَيْنِ الله تَعَـالَى : اللهُ اَكْبَرْ", "Artinya:\n" +
                                    "Saya niat shalat sunnah setelah Isya dua rakaat karena Allah", "USHALLII SUNNATAL ISYAAI BADIYATAN RAKATAINI LIL-LAAHI TAAALAA"));

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
