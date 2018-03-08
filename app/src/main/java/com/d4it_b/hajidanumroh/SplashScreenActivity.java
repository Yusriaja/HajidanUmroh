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
                        detailContents.add(new DetailContent(idDetailContent++ ,"\tUmrah adalah berkunjung ke Baitullah (Kabah) untuk melakukan thawaf, sai dan mencukur rambut demi mengharap ridla Allah SWT. Serangkaian pelaksanaan ibadah umrah ini dapat disebut IHTOSAKUR (Ihram, Towaf, Sai dan Cukur). Masing-masing dari rukun umrah harus dilaksanakan secara benar dan tertib." ,idSubMenu++, 0));

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
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tDiawali dengan melihat lampu hijau disebelah kanan atas yang sudah disetting lurus dengan Hajar Aswad, kemudian menghadapkan seluruh badan ke arah Hajar Aswad. Jika tidak memungkinkan maka cukup dengan sedikit badan. Pada saat memulai thawaf, hukumnya sunnah mencium Hajar Aswad, jika tidak memungkinkan maka cukup melambaikan tangan ke arah Hajar Aswad, kemudian mengecupnya. Pada saat itu sunnah membaca dzikir : \n بِسْمِ اللهِ وَاللهُ أَكْبَرُ\n BISMILLAAHI WALLAAHU AKBAR\n" +
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
                                    "\t•\tDoa di Multazam \n" +
                                    "\t•\tShalat sunnah thawaf dua rakaat di Maqam Ibrahim\n" +
                                    "\t•\tMinum air zam-zam sebelum Sai\n"));

                        detailContents.add(new DetailContent(idDetailContent, "3.\tSai", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Sai adalah berjalan dari bukit Shafa ke bukit Marwah, dan sebaliknya sebanyak tujuh kali. Perjalanan dari bukit Shafa ke bukit Marwah atau sebaliknya masing-masing dihitung satu kali. Syarat - syarat sahnya sai:"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "•\tDidahului dengan thawaf\n" +
                                                                                                            "•\tTujuh kali perjalanan antara bukit Shafa dan Marwah\n" +
                                                                                                            "•\tDilakukan di tempat sai\n" +
                                                                                                            "•\tTertib\n"));

                        detailContents.add(new DetailContent(idDetailContent, "4.\tCukur", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tTahallul dengan mencukur atau menggunting rambut adalah akhir pelaksanaan ibadah umrah. Rambut yang harus digunting paling sedikit adalah tiga helai rambut. Namun yang lebih utama bagi orang lelaki adalah mencukur semua rambutnya (pelontos). Sedangkan yang mencukur atau yang menggunting adalah orang yang tidak sedang berihram atau orang yang sudah bertahallul."));

                        detailContents.add(new DetailContent(idDetailContent, "5.\tTertib", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tTertib adalah mendahulukan apa yang mestinya didahulukan dan mengakhirkan apa yang mestinya diakhirkan, sebagaimana urutan berikut : 1. Ihram, 2. Thawaf, 3. Sai, dan 4. Cukur / menggunting rambut."));

                    subMenuContents.add(new SubMenuContent(idSubMenu,1,  "Larangan Selama Ihram Sampai Tahallul / Cukur"));
                        detailContents.add(new DetailContent(idDetailContent, "1.\tLarangan Khusus Laki-laki", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tMemakai pakaian berjahit\n" +
                                    "b.\tMemakai sepatu yang menutupi tumit\n" +
                                    "c.\tMenutupi kepala yang melekat seperti topi. Namun jika sangat dingin atau ada luka yang harus di perban maka diperbolehkan.\n"));
                        detailContents.add(new DetailContent(idDetailContent, "2.\t Khusus Perempuan", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tMemakai kaos tangan\n" +
                                    "b.\tMenutupi muka, baik cadar atau masker\n"));
                        detailContents.add(new DetailContent(idDetailContent, "3.\tLarangan Umum Bagi Laki-laki dan Perempuan.", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tMemakai wangi-wangian kecuali yang sudah dipakai di badan sebelum niat ihram.\n" +
                                    "b.\tMemotong kuku dan mencukur atau mencabut rambut badan.\n" +
                                    "c.\tMemburu binatang buruan darat yang liar dan boleh dimakan.\n" +
                                    "d.\tMembunuh dan menganiaya binatang buruan darat dengan cara apapun (kecuali binatang yang membahayakan boleh dibunuh)\n" +
                                    "e.\tNikah, menikahkan atau meminang wanita untuk dinikahi/dinikahkan.\n" +
                                    "f.\tBercumbu atau bersetubuh.\n" +
                                    "g.\tMencaci, bertengkar atau mengucapkan kata-kata kotor.\n"));


//                    ====================================================================================================================
//                    Sub menu Haji
                    subMenuContents.add(new SubMenuContent(idSubMenu, 2, "Pengertian"));
                        detailContents.add(new DetailContent(idDetailContent++, "\tHaji adalah berkunjung ke Baitullah (Kabah) untuk melakukan beberapa ritual, antara lain wukuf, thawaf, sai, dan amal ibadah lainnya pada masa tertentu demi memenuhi panggilan Allah dan mengharapkan ridla-Nya.\n" +
                            "\tHaji adalah serangkaian ibadah IHWU MAMUZMIN LONTOI SAKUR (ihram, wukuf, mabit di Muzdalifah, mabit di Mina, lontar jumrah, thawaf ifadlah, sai dan cukur). Masing-masing ini harus dilakukan dengan benar pada tempat dan waktu yang telah ditentukan, demi memperoleh ridla Allah.\n" +
                            "\tIbadah haji ini diwajibkan kepada seluruh umat Islam yang memiliki kemampuan fisik, finansial dan lain-lain. Ibadah haji hanya diwajibkan satu kali seumur hidup, jadi ibadah haji berikutnya adalah ibadah haji sunnah, kecuali orang yang nadzar melakukan haji, maka wajib untuk melaksanakannya.\n", idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 2, "Rukun dan Wajib Haji"));
                        detailContents.add(new DetailContent(idDetailContent, "1.\tIhram (Rukun Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tKetentuan waktu ihram haji menurut jumhur ulama boleh dilaksanakan sejak tanggal 1 Syawal sampai terbit fajar tanggal 10 Dzulhijjah. Orang yang ihram haji diluar ketentuan waktu itu maka hajinya tidak sah. Orang yang niat ihram setelah tanggal 10 Dzulhijjah maka menjadi ihram umrah, meskipun dengan niat ihram haji. Ihram haji adalah niat melaksanakan ibadah haji dari miqot dengan ketentuan sebagai berikut:"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tBersuci (mandi dan wudlu)\n" +
                                    "b.\tBerpakaian ihram\n" +
                                    "c.\tShalat sunnah ihram dua rakaat\n" +
                                    "d.\tNiat ibadah haji \n"));
                        detailContents.add(new DetailContent(idDetailContent++, "2.\tNiat Ihram dari Miqot (Wajib Haji)", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent, "3.\tWukuf di Arafah (Rukun Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tWukuf di Arafah termasuk salah satu rukun haji yang paling utama. Jamaah haji yang tidak melaksanakan wukuf di Arafah berarti tidak mengerjakan haji. Wukuf dilakukan setelah khutbah dan shalat jama qashar taqdim Dhuhur dan Ashar berjamaah. Wukuf dapat dilaksanakan dengan berjamaah atau sendiri-sendiri, dengan memperbanyak zikir, istighfar dan doa, sesuai dengan sunnah Rasul. Untuk wukuf jamaah haji tidak disyaratkan suci dari hadats besar atau kecil. Karena itu wanita yang sedang haid atau nifas boleh melakukan wukuf. Sedangkan bagi jamaah haji yang sakit, pelaksanaannya dilakukan dengan pelayanan khusus sesuai dengan kondisi kesehatannya."));

                        detailContents.add(new DetailContent(idDetailContent, "4.\tMabit di Muzdalifah (Wajib Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tMabit di Muzdalifah adalah bersinggah di Muzdalifah pada malam tanggal 10 Dzulhijjah setelah wukuf di Arafah. Ketentuan mabit di Muzdalifah adalah keberadaan seseorang di Muzdalifah boleh hanya sesaat setelah lewat tengah malam. Menurut sebagian besar ulama hukumnya Mabit di Muzdalifah adalah wajib. Menurut sebagian ulama yang lain hukumnya sunnah. Bagi yang tiba di Muzdafilah sebelum tengah malam harus menunggu sampai lewat tengah malam. Pada saat mabit hendaknya bertalbiyah, berzikir, beristighfar, berdoa atau membaca Al-Quran selanjutnya mencari kerikil sebanyak 7 atau 49 atau 70 butir. Kerikil dapat diambil dari mana saja, namun disunnahkan dari Muzdalifah."));

                        detailContents.add(new DetailContent(idDetailContent, "5.\tMabit di Mina (Wajib Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tHukum mabit di Mina menurut jumhur ulama adalah wajib. Sebagian ulama menyatakan sunat. Waktu mabit yaitu malam tanggal 11, 12 dan 13 Dzulhijah. Tempat mabit bagi sebagian besar jamaah haji Indonesia adalah Haratul Lisan. Haratul Lisan adalah termasuk wilayah hukum Mabit Mina. Kemungkinan pengembangan wilayah seperti ini sama halnya dengan pengembangan Masjid Nabawi dan Masjidil Haram. Sejak tahun 1984 pemerintahan Arab Saudi telah menetapkan Haratul Lisan sebagai tempat Mabit dan kemudian makin meluas sesuai dengan kondisi perhajian sehingga mulai tahun 2001 sebagian jamaah haji mendapatkan perkemahan yang masuk dalam batas daerah Muzdalifah. Hukum mabit perluasan Mina di tempat tersebut sah dan dapat diterima sebagai daerah perluasan hukum untuk mabit di Mina karena kemah darurat dan bersambung."));

                        detailContents.add(new DetailContent(idDetailContent, "6.\tMelontar Jumrah Ula, Wustho dan Aqobah (Wajib Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tHukum melontar jumrah adalah wajib, apabila tidak dapat melaksanakannya maka boleh digantikan kepada orang lain yang sudah melakukan. Jika terpaksa tidak, maka wajib membayar dam/fidyah."));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Tata cara melontar jamarat :"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\ta.\tKerikil masuk Marma (lubang)\n" +
                                    "\tb.\tMelontar dengan kerikil satu persatu, sedangkan melontar dengan 7 (tujuh) kerikil sekaligus tetap dihitung satu kali lontaran.\n" +
                                    "\tc.\tMelontar jamarat dengan urutan yang benar yaitu mulai dengan jamrah Ula lalu Wustha dan terakhir Aqabah.\n" +
                                    "\td.\tYang dipakai untuk melontar adalah batu kerikil, selain itu tidak sah seperti sandal, payung, dan lain sebagainya.\n"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Waktu melontar"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\ta.\tPada tanggal 10 Zulhijah yang dilontar adalah jumrah Aqabah saja. Waktu afdhalnya setelah terbit matahari hari Nahr, waktu ikthiar (memilih) bada Dhuhur sampai terbenam matahari dan waktu jawaz (diperbolehkan) adalah mulai lewat tengah malam 10 Dzulhijjah sampai dengan terbit fajar tanggal 11 Dzulhijjah,\n" +
                                    "\tb.\tPada hari Tasyrik (11, 12 dan 13 Zulhijjah) melontar ketiga jamarat : Ula, Wustha, dan Aqabah. Waktunya sebagai berikut:\n" +
                                    "\t\t•\tWaktu Afdhal (utama) bada Zawal.\n" +
                                    "\t\t•\tWaktu Ikhtiar (memilih), yakni setelah ashar sampai malam.\n" +
                                    "\t\t•\tWaktu Jawaz mulai terbit fajar sampai zawal (tergelincirnya matahari)\n" +
                                    "\tc.\tBagi orang yang tidak melontar jumrah tepat pada harinya maka boleh melontar pada hari berikutnya selama masih dalam hari Tasyriq.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "7.\tThawaf Ifadlah (Rukun Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tThawaf adalah mengelilingi Kabah sebanyak tujuh kali dimulai dan diakhiri pada arah sejajar dari Hajar Aswad. Sedangkan thawaf ifadlah adalah thawaf yang merupakan salah satu rukun haji. Jika thawaf ifadlah ini tidak dilaksanakan maka hajinya tidak sah. Orang haji yang sedang sakit maka thawafnya dengan pelayanan khusus. Thawaf ifadlah juga disebut dengan thawaf ziyarah dan thawaf rukun. Waktu pelaksanaan thawaf ifadlah adalah sebagai berikut:"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tMenurut imam Syafii dan imam Ahmad bin Hanbal waktu pelaksanaan thawaf ifadlah adalah sejak lewatnya tengah malam dari malam hari Nahr (tanggal 10 Dzulhijjah), dan tidak ada batas waktu akhirnya. Namun demikian, kalau ada kesempatan agar segera melakukannya. Orang yang belum melaksanakan thawaf ifadlah maka belum boleh bersetubuh antara suami istri.\n" +
                                    "b.\tMenurut fatwa MUI thawaf ifadlah boleh dilakukan sebelum melontar jumrah Aqobah."));

                        detailContents.add(new DetailContent(idDetailContent, "8.\tSai (Rukun Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tPelaksanaan sai haji sama dengan pelaksanaan sai Umrah. Sai hanya dapat dilaksanakan setelah melaksanakan thawaf ifadlah atau thawaf umrah. Tidak ada sai sunnah."));

                        detailContents.add(new DetailContent(idDetailContent, "9.\tCukur (Rukun Haji)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tCara melaksanakan cukur dalam haji sama dengan praktik pelaksanaan cukur dalam umrah. Waktu Cukur Haji :"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\ta.\tMenurut ulama madzhab Syafii cukur boleh dilaksanakan pada hari nahr sesudah melontar jumrah Aqobah. Bagi orang yang mendahulukan thawaf ifadlah sebelum lontar jumrah Aqobah maka boleh mencukur / menggunting rambut setelah thawaf dan sai.\n" +
                                    "\tb.\tMenurut ulama madzhab Hanbali pelaksanaan cukur boleh diakhirkan sampai pada hari-hari tasyriq.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "10.\tThawaf Wada (Wajib Haji)    ", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tThawaf wada adalah thawaf penghormatan terakhir kepada Baitullah. Thawaf wada dilakukan sebagaimana thawaf-thawaf yang lain, yakni dimulai dari hajar aswad sampai kembali ke arah hajar aswad lagi sebanyak tujuh kali. Hanya saja dalam thawaf wada tidak sunnah berlari-lari kecil, cukup berjalan kaki biasa. Waktu pelaksanaan thawaf wada adalah setelah ada ketentuan dari petugas untuk meninggalkan Makkah. Thawaf wada hukumnya wajib. Jamaah haji / umrah yang tidak mengerjakan thawaf wada diwajibkan membayar dam (menyembelih kambing). Wanita yang sedang haid / nifas tidak diwajibkan thawaf wada. Penghormatan kepada Baitullah cukup dengan memandangnya dari pintu Masjid. Dalam hadits dijelaskan bahwa orang yang hendak berangkat keluar dari Makkah belum boleh meninggalkan Makkah sebelum melakukan thawaf wada terlebih dahulu."));
//                    ==============================================================================================================================
//                    Sub menu dam
                    subMenuContents.add(new SubMenuContent(idSubMenu, 5, "Pengertian"));
                        detailContents.add(new DetailContent(idDetailContent++, "Dam dalam pengertian bahasa adalah darah, sedangkan menurut istilah adalah mengalirkan darah (menyembelih) hewan ternak, yaitu kambing, sapi, unta di tanah haram, atau melakukan puasa atau memberikan makanan kepada orang-orang miskin dalam rangka memenuhi ketentuan manasik Haji.", idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 5, "Macam - Macam Dam"));
                        detailContents.add(new DetailContent(idDetailContent, "1.\tDam Nusuk ", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tadalah dam yang dikenakan kepada orang yang melaksanakan Haji Tamattu atau Qiran (bukan dam karena melakukan kesalahan)."));

                        detailContents.add(new DetailContent(idDetailContent, "2.\tDam Isaah ", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tadalah dam yang dikenakan kepada orang yang melanggar aturan atau melaksanakan kesalahan, yaitu:"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a.\tMeninggalkan salah satu wajib haji atau umrah yang terdiri dari:\n" +
                                    "•\t\tTidak berihram dari Miqat\n" +
                                    "•\t\tTidak mabit di Muzdalifah\n" +
                                    "•\t\tTidak mabit di Mina\n" +
                                    "•\t\tTidak melontar jumrah\n" +
                                    "•\t\tTidak thawaf wada\n" +
                                    "b.\tMelanggar aturan haji atau umrah:\n" +
                                    "•\t\tApabila melanggar larangan ihram berupa mencukur rambut, memotong kuku, atau memakai pakaian yang bertangkup bagi laki-laki, dan menutup muka (cadar/masker) atau memakai sarung tangan bagi wanita dan wangi-wangian bagi laki-laki/wanita wajib membayar fidyah dengan jalan memilih diantara menyembelih seekor kambing, bersedekah kepada 6 (enam) orang miskin dan setiap orang setengah sha (= 2 mud + 1,5 kilo gram beras/makanan yang mengenyangkan) atau berpuasa 3 (tiga) hari.\n" +
                                    "•\t\tApabila melanggar larangan ihram berupa membunuh hewan buruan darat yang halal dimakan, maka wajib membayar fidyah atau bersedekah dengan makanan seharga hewan tersebut. Apabila tidak mampu boleh mengganti dengan puasa. Bilangan puasanya disesuaikan menurut banyaknya makanan yang harus disediakan, yaitu satu hari puasa sama dengan satu mud makanan (+ ¾ % kilo gram).\n" +
                                    "•\t\tApabila suami istri melanggar ihram dengan bersetubuh sebelum tahallul awal, maka batal hajinya dan wajib membayar dam kifarat menyembelih seekor unta atau sapi atau 7 (tujuh) ekor kambing.\n" +
                                    "•\t\tApabila suami istri melanggar larangan dengan bersetubuh setelah tahallul awal, maka tidak batal hajinya tetapi wajib membayar dam yaitu menyembelih seekor unta atau sapi. Pendapat lain mengatakan cukup seekor kambing.\n" +
                                    "•\t\tApabila mengadakan akad nikah diwaktu ihram, maka pernikahannya itu batal, tetapi yang bersangkutan tidak membayar dam dan ihram tidak batal.\n" +
                                    "•\t\tApabila melakukan rafas, fusuk dan jidal ibadah Hajinya sah akan tetapi gugur pahala hajinya dan tidak kena dam/fidayah.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 5, "Ketentuan - Ketentuan Dam"));
                        detailContents.add(new DetailContent(idDetailContent++, "1.\tHukumnya wajib7", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "2.\tDapat berupa hewan, puasa, atau memberikan makanan kepada orang miskin, sesuai dengan pelanggaran yang dilakukan.", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "3.\tJika dam berupa hewan maka harus disembelih di tanah haram Makkah, tidak boleh di tempat lain, ", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "4.\tSunnah disembelih pada hari raya Idul Adlha, namun jika berhalangan maka boleh disembelih di hari-hari yang lain.", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "5.\tOrang yang membayar dam hewan tidak boleh sama sekali memakan dagingnya, wajib disedekahkan semuanya kepada orang miskin. ", idSubMenu, 1));
                        detailContents.add(new DetailContent(idDetailContent++, "6.\tTidak boleh dihadiahkan kepada orang kaya.", idSubMenu++, 1));
//                    =================================================================================================================================
//                    Sub menu sholat
                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Lis-Safar"));
                        detailContents.add(new DetailContent(idDetailContent++, "Shalat Sunnah lis-Safar adalah shalat yang sunnah dilakukan bagi setiap orang yang mau bepergian, baik dekat atau jauh.\n" +
                                "Niat Shalat Sunnah Lis-Safar :\n" +
                                "اُصَلِّى سُنَّةً لِلسَّفَرِ رَكْغَتَيْنِ ِللهِ تَعَـالَى : اَللهُ اَكْبَرُ\n" +
                                "USHALLII SUNNATAN LIS-SAFARI RAKATAINI LILLAAHI TAAALAA\n" +
                                "Artinya:\n" +
                                "Saya niat shalat sunnah bepergian dua rakaat karena Allah\n", idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Jama"));
                        detailContents.add(new DetailContent(idDetailContent, "Penjelasan Shalat Jama", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Jama secara etimologi adalah mengumpulkan. Sedangkan yang dimaksudkan jama dalam konteks ini adalah mengumpulkan antara dua shalat fardlu dan mengerjakannya dalam waktu yang sama. Shalat yang dapat dijama adalah Dhuhur dengan Ashar; Maghrib dengan Isya. Shalat jama boleh dilakukan oleh orang yang sedang bepergian jauh sekitar lebih kurang 90 kilo meter, dan bukan bepergian yang bertujuan kedurhakaan/kemaksiatan."));

                        detailContents.add(new DetailContent(idDetailContent, "1.\tJama Taqdim", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Jama Taqdim adalah mengumpulkan dua shalat dan dikerjakan pada waktu shalat yang pertama, mengumpulkan antara Dhuhur dan Ashar dan dikerjakan pada waktu Dhuhur, mengumpulkan antara Maghrib dan Isya dan dikumpulkan pada waktu Maghrib."));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "Syarat-syarat Jama Taqdim :\n" +
                                    "\ta.\tHarus dimulai dari shalat yang terdahulu, dimulai dari Dhuhur kemudian Ashar, dimulai dari Maghrib kemudian Isya.\n" +
                                    "\tb.\tPada saat melaksanakan shalat yang pertama harus niat bahwa shalat Ashar di jama taqdim ke Dhuhur, bahwa shalat Isya dijama taqdim ke Maghrib.\n" +
                                    "\tc.\tSetelah usai melaksanakan shalat yang pertama harus segera melaksanakan shalat yang kedua, tidak boleh dipisah dengan bacaan dzikir yang panjang.\n"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Niat Jama Taqdim\n" +
                                    " اُصَليِّ فَرْضَ الظُّهْرِ اَرْبَعَ رَكَعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَجْمُوْعَتً بِاالْعَصْرِ جَمْعَ تَقْدِيْمٍ اَدَاءً لِلَّهِ تَعَالَى\n" +
                                    "USHALLII FARDLAD DHUHRI ARBAA RAKAAATIN MUSTAQBILAL QIBLATI MAJMUITATAN BILASHRI JAMA TAQDIIMIN ADAA-AN LIL-LAAHI TAAALAA\n" +
                                    " Artinya:\n" +
                                    "Saya niat shalat fardlu Dhuhur empat rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Ashar tepat waktu karena Allah\n" +
                                    "\n" +
                                    " اُصَليِّ فَرْضَ الْمَغْرِبِ ثَلاَثَ رَكْعَاتٍ مُسْتَقْبِلَ الْقِبْلَةِ مَجْمُوْعَةً بِاالْعِشَاءِ جَمْعَ تَقْدِيْمٍ اَدَاءً لِلَّهِ تَعَالَى\n" +
                                    "USHALLII FARDLAL MAGHRIBI TSALAATSA RAKA-AATIN MUSTAQBILAL QIBLATI MAJMUITATAN BIL-TSYAAI JAMA TAQDIIMIN ADAA-AN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fardlu Maghrib tiga rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Isya tepat waktu karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "2.\tJama Takhir", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tJama Takhir adalah mengumpulkan dua shalat dan dikerjakan pada waktu shalat yang belakang, mengumpulkan Dhuhur dan Ashar dan dikerjakan pada waktu Ashar, menngumpulkan Maghrib dan Isya dan dikerjakan pada waktu Isya.\n" +
                                    "\tSedangkan syarat jama takhir adalah harus berniat bahwa shalat Dhuhur dijama ke shalat Ashar, bahwa shalat Maghrib dijama ke shalat Isya. Niat dilakukan pada waktunya shalat yang pertama. Jadi, ketika waktu Dhuhur sudah masuk maka harus niat bahwa shalat Dhuhur dijama ke shalat Ashar; ketika waktu Maghrib sudah masuk maka harus niat bahwa shalat Maghrib dijama ke shalat Isya.\n"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Niat Jama Takhir\n" +
                                    "نَوَيْتُ جَمْعَ صَلاَةِ الظُّهْرِ اِلَى صَلاَةِ الْعَصْرِ جَمْعَ تَأْخِيْرِ لِلَّهِ تَعَالَى\n" +
                                    "NAWAITU JAMA SHALATID DHUHRI ILAA SHALAATIL ASHRI JAM A TAKHIIRIN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat men-jama takhir shalat Dhuhur ke shalat Ashar karena Allah.\n" +
                                    " نَوَيْتُ جَمْعَ صَلاَةِ الْمَغْرِبِ اِلَى صَلاَةِ الْعِشَاءِ جَمْعَ تَأْخِيْرِ ِللهِ تَعَالَى\n" +
                                    "NAWAITU JAMA SHALATIL MAGHRIBI ILAA SHALAATIL TSYAAI JAMA TAKHIIRIN LIL-LAAHI TAAALAA \n" +
                                    "Artinya:\n" +
                                    "Saya niat men-jama takhir shalat Maghrib ke shalat Isya karena Allah.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu++, 3, "Shalat Jama Qoshar"));

//                    ======================================================================================================================================
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
