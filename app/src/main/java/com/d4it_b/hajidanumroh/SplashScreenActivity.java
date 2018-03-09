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
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Sunnah Lis-Safar", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tShalat Sunnah lis-Safar adalah shalat yang sunnah dilakukan bagi setiap orang yang mau bepergian, baik dekat atau jauh.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Sunnah Lis-Safar", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Niat Shalat Sunnah Lis-Safar :\n" +
                                    "\" +\n" +
                                    "                                \"اُصَلِّى سُنَّةً لِلسَّفَرِ رَكْغَتَيْنِ ِللهِ تَعَـالَى : اَللهُ اَكْبَرُ\\n\" +\n" +
                                    "                                \"USHALLII SUNNATAN LIS-SAFARI RAKATAINI LILLAAHI TAAALAA\\n\" +\n" +
                                    "                                \"Artinya:\\n\" +\n" +
                                    "                                \"Saya niat shalat sunnah bepergian dua rakaat karena Allah"));

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

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Qoshar"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Qoshar", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tQashar secara etimologi adalah pendek. Sedangkan qashar secara terminologi adalah memperpendek shalat, dari empat rakaat menjadi dua rakaat. Shalat-shalat yang boleh di qashar adalah shalat Dhuhur, Ashar dan Isya. \n"+
                                    "Syarat-syarat qashar ada empat:\n" +
                                    "\t1.\tHarus dalam perjalanan jauh yang bukan tujuan kemaksiatan\n" +
                                    "\t2.\tHarus shalat yang empat rakaat (Dhuhur, Ashar dan Isya)\n" +
                                    "\t3.\tHarus niat qashar\n" +
                                    "\t4.\tTidak bermakmum kepada orang yang menyempurnakan shalatnya empat rakaat.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Sunnah Lis-Safar", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "اُصَليِّ فَرْضَ الظُّهْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءًقَصْرًا اِمَامًا/مَأْمُوْمًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ\n" +
                                    "USHALLII FARDLAD DHUHRI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fardlu Dhuhur dua rakaat, menghadap kiblat, tepat waktu dan di-qashar karena Allah \n" +
                                    "\n" +
                                    "اُصَليِّ فَرْضَ العَصْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرً اِمَامًا/مَأْمُوْمًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ\n" +
                                    "USHALLII FARDLAL ASHRI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fardlu Ashar dua rakaat, menghadap kiblat, tepat waktu dan diqashar karena Allah \n" +
                                    " \n" +
                                    "اُصَليِّ فَرْضَ الْعِشَاءِ ركْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرً اِمَامًا/مَأْمُوْمًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ\n" +
                                    "USHALLII FARDLAL ISYAAI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fardlu Isya dua rakaat, menghadap kiblat, tepat waktu dan diqashar karena Allah.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Jama Qoshar"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shala Jama' Qoshar", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tAdalah shalat yang disamping dijama juga diqoshar. Segala ketentuannya sama dengan ketentuan yang telah disebutkan diatas."));

                        detailContents.add(new DetailContent(idDetailContent, "1.\tJama Taqdim Qoshar:", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tMenjama taqdim (mengumpulkan) pelaksanakan shalat Ashar ke waktu shalat Dhuhur atau shalat Isya ke waktu shalat Maghrib. Disamping dijama juga diqoshar (diperpendek menjadi dua rakaat), selain shalat Maghrib."));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Niat Jama Taqdim Qoshar\n" +
                                    "اُصَليِّ فَرْضَ الْظُهْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ مَجْمُوْعَةً بِاالْعَصْرِ جَمْعَ تَقْدِيْمٍ قَصْرًا اَدَاءً مَاءْمُومًا/اِمَامًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ\n" +
                                    "USHALLII FARDLAD DHUHRI RAKATAINI MUSTAQBILAL QIBLATI MAJMUUATAN BIL-ASHRI JAMA TAQDIIMIN QASHRAN ADAA-AN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fadrlu Dhuhur dua rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Ashar dan di qoshar, tepat waktu karena Allah\n" +
                                    "\n" +
                                    " اُصَليِّ فَرْضَ الْعَصْرِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرً مَاءْمُومًا/ اِمَامًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ\n" +
                                    "USHALLII FARDLAL ASHRI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN MAMUUMAN / IMAAMAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fardlu Ashar dua rakaat, menghadap kiblat, tepat waktu dan diqashar karena Allah.\n" +
                                    "\n" +
                                    "اُصَليِّ فَرْضَ المَغْرِبِ ثَلاَثَ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ مَجْمُوْعَةً بِالْعِشَاءِجَمْعَ تَقْدِيْمٍ اَدَاءً اِمَامًا/مَاءْمُومًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ\n" +
                                    "USHALLII FARDLAL MAGHRIBI TSALAATSA RAKAAATIN MUSTAQBILAL QIBLATI MAJMUUATAN BIL-ISYAAI\tJAMA\tTAQDIIMIN\tADAA-AN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fadrlu Maghrib tiga rakaat dalam keadaan menghadap kiblat dijama taqdim dengan shalat Isya tepat waktu karena Allah\n" +
                                    "\n" +
                                    "اُصَليِّ فَرْضَ الْعِشَاءِ رَكْعَتَيْنِ مُسْتَقْبِلَ اْلقِبْلَةِ اَدَاءً قَصْرًا اِمَامًا/مَاءْمُومًا لِلَّهِ تَعَالَى: اَللهُ اَكْبَرُ\n" +
                                    "USHALLII FARDLU ISYAAI RAKATAINI MUSTAQBILAL QIBLATI ADAA-AN QASHRAN IMAAMAN/MAMUUMAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat fardlu Isya dua rakaat, menghadap kiblat, tepat waktu dan di-qashar karena Allah. \n"));

                        detailContents.add(new DetailContent(idDetailContent, "2.\tJama Takhir Qoshar:", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tMenjama takhir (mengumpulkan) shalat Dhuhur ke waktu shalat Ashar atau shalat Maghrib ke waktu shalat Isya. Disamping dijama juga diqoshar (diperpendek menjadi dua rakaat), selain shalat Maghrib.\n" +
                                    "\tPada saat takbiratul ihram harus berniat qashar, namun tidak lagi perlu berniat jama, karena niat jamanya sudah dilakukan pada waktunya shalat yang pertama.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Janazah"));
                        detailContents.add(new DetailContent(idDetailContent++, "\tPraktik pelaksanaannya adalah empat kali takbir tanpa ruku, sujud dan tahiyyat. Takbir yang pertama adalah takbiratul ihram, yang pada saat takbir harus berniat. Sedangkan takbir yang kedua, ketiga dan keempat adalah takbir intiqal, takbir yang menandai perpindahan dari satu rukun ke rukun yang lain.", idSubMenu, 0));
                        detailContents.add(new DetailContent(idDetailContent++, "Niat Untuk Jenazah Laki-laki\n" +
                                "أُصَلِّى عَلَى هَذَا الْمَيِّتِ فَرْضَ كِفَايَةٍ أَرْبَعَ تَكْبِيْرَاتٍ مَأْمُوْمًا/أِمَامًا لِلَّهِ تَعَالَى. أللهُ أَكْبَرُ \n" +
                                "USHALLII ALAA HAADZAL MAYYITI FARDLA KIFAAYATIN ARBAA TAKBIIRAATIN MAMUUMAN/IMAAMAM LIL-LAAHI TAAALAA\n" +
                                "Artinya:\n" +
                                "Saya niat shalat untuk jenazah lelaki ini fardu kifayah dengan empat kali takbir, menjadi makmum/imam karena Allah\n" +
                                "\n" +
                                "Niat Untuk Jenazah Perempuan\n" +
                                "أُصَلِّى عَلَى هَذَهِ الْمَيِّتِ فَرْضَ كِفَايَةٍ أَرْبَعَ تَكْبِيْرَاتٍ مَأْمُوْمًا/أِمَامًا لِلَّهِ تَعَالَى. أللهُ أَكْبَرُ \n" +
                                "USHALLII ALAA HAADZIHIL MAYYITATI FARDLA KIFAAYATIN ARBAA TAKBIIRAATIN MAMUUMAN/IMAAMAM LIL-LAAHI TAAALAA\n" +
                                "Artinya:\n" +
                                "Saya niat shalat untuk jenazah perempuan ini fardu kifayah dengan empat kali takbir, menjadi makmum/imam karena Allah\n" +
                                "\n" +
                                "Jika jenis kelamin jenazahnya tidak diketahui atau jenazahnya banyak maka bagi makmum cukup niat sebagai berikut:\n" +
                                "أُصَلِّى عَلَى مَنْ صَلاَّ عَلَيْهِ اْلاِمَامُ فَرْضَ كِفَايَةٍ أَرْبَعَ تَكْبِيْرَاتٍ أِمَامًا لِلَّهِ تَعَالَى \n" +
                                "USHALLII ALAA MAN SHALLAA ALAIHIL IMAAMU FARDLA KIFAAYATIN ARBAA TAKBIIRAATIN MAMUUMAN LIL-LAAHI TAAALAA\n" +
                                "Artinya :\n" +
                                "Saya niat shalat untuk orang yang dishalati imam, fardu kifayah dengan empat kali takbir menjadi makmum karena Allah.\n" +
                                "\n" +
                                "Setelah takbir yang pertama membaca al-Fatihah\n" +
                                "اَلْفَاتِحَةُ\n" +
                                "Setelah takbir yang kedua membaca shalawat\n" +
                                "اَللَّهُمَّ صَلِّى عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى أَلِ سَيِّدِنَا مُحَمَّدٍ كَمَا صَلَيْتَ عَلَى سَيِّدِنَا اِبْرَهِيْمَ وَعَلَى أَلِ سَيِّدِنَا أِبْرَهِيْمَ فِى اْلعَالَمِيْنَ أِنَّكَ حَمِيْدٌ مَجِيْدٌ\n" +
                                "ALAAHUMMA SHALLI ALAA SAYYIDINAA MUHAMMADIN WA ALAA AALI SAYYIDINAA MUHAMMADIN KAMAA SHALLAITA ALAA SAYYIDINAA IBRAAHIIMA WA ALAA AALI SAYYIDINAA IBRAAHIIMA FIL AALAMIINA INNAKA HAMIIDUN MAJIID\n" +
                                "Artinya:\n" +
                                "Ya Allah limpahkan shalawat (rahmat) kepada nabi Muhammad dan keluarganya sebagaimana Engkau melimpahkan shalawat kepada nabi Ibrahim dan keluarganya di seluruh alam semesta, sesunguhnya Engkau adalah Maha Terpuji dan Maha Agung.\n" +
                                "\n" +
                                "Setelah takbir yang ketiga membaca doa\n" +
                                "اَللَّهُمَّ غْفِرْلَهُ وَارْحَمْهُ وَعَافِهِ وَاعْفُ عَنْهُ اَللَّهُمَّ اَبْدِ لَهُ دَارًاخَيْرًا مِنْ دَارِهِ وَزَوْجًا خَيْرًا مِنْ زَوْجِهِ وَأَهْلاًّ خَيْرً مِنْ أَهْلِهِ، اَللَّهُمَّ اِنَّهُ نَزَلَ بِكَ وَاَنْتَ خَيْرُ مَنْزُوْلٍ بِهِ اَللَّهُمَّ اَكْرِمْ نُزُلَهُ وَوَسِّعْ مَدْ خَلَهُ\n" +
                                "ALLAAHUMMAGHFIR LAHUU WARHAMHU WA AAFIHI WATU ANHU, ALLAAHUMMA ABDILHU DAARAN KHAIRAN MIN DAARIHII WA ZAUJAN KHAIRAN MIN ZAUJIHII WA AHLAN KHAIRAN MIN AHLIHII, ALAAHUMMA INNAHUU NAZALA BIKA WA ANTA KHAIRU MANZUULIN BIHII, ALLAAHUMMA AKRIM NUZULAHUU WA WASSI MADKHALAHUU\n" +
                                "Artinya:\n" +
                                "Ya Allah, ampunilah dia, kasihanilah, sehatkan dan maafkan dia. Ya Allah berilah ganti dia rumah yang lebih baik, istri yang lebih baik dan keluarga yang lebih baik. Ya Allah, sesungguhnya dia bertempat tinggal bersama-Mu, Engkau sebaik-sebaiknya yang ditempat tinggali dia. Ya Allah muliakan tempat tinggalnya dan luaskan tempat masuknya.\n" +
                                "\n" +
                                "Setelah takbir yang keempat membaca doa berikut kemudian salam\n" +
                                "اَللَّهُمَّ لاَتَحْرِمْنَا أَجْرَهُ وَلاَتَفْتِنَّا بَعْدَهُ وَاغْفِرْلَنَا وَلَهُ أَلسَّلاَمُ عَلَيْكُمْ وَرَحْمَةُ اللهِ وَبَرَكَاتُهُ\n" +
                                "\n" +
                                "ALLAAHUMMA LAA TAHRIMNAA AJRAHUU WA LAA TAFTINNAA BADAHUU WAGHFIR LANAA WA LAHUU. AS-SALAAMU ALAIKUM WA RAHMATUL LAAHI WA BARKAATUH\n" +
                                "Artinya:\n" +
                                "Ya Allah, jangan Engkau tutupi kepada kami pahala dia, jangan Engkau fitnah kami setelah kematian dia dan ampunilah kami dan dia.\n", idSubMenu++, 0));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Rawatib"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Rawatib", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tShalat sunnah Rawatib adalah shalat sunnah yang mengikuti pelaksanaan shalat fardlu, baik yang dilakukan sebelumnya maupun sesudahnya"));

                        detailContents.add(new DetailContent(idDetailContent, "1.\tDua Rakaat Sebelum Subuh (Shalat Sunnah Fajar)", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "اُصَلِّى سُنَّةَ الصُّبْحِ قَبْلِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : أَللهُ أَكْبَرْ\n" +
                                    "اُصَلِّى سُنَّةَ اْلفَجْرِ رَكْعَتَيْنِ لِلَّهِ تَعَـالَى \n" +
                                    "Niatnya:\n" +
                                    "USHALLII SUNNATAS SHUBHI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA USHALLII SUNNATAL FAJRI RAKATAINI LIL-LAAHI TAAALAA \n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnat sebelum Subuh dua rakaat karena Allah/saya niat shalat sunnah Fajar dua rakaat karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "2.\tEmpat Rakaat Sebelum dan Sesudah Dhuhur", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tPraktik pelaksanaannya yaitu empat rakaat dijadikan dua kali salam. Jadi setiap dua rakaat salam, kemudian ditambah dua rakaat lagi."));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Niatnya:\n" +
                                    "اُصَلِّى سُنَّةَ الظُّهْرِقَبْلِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : أَللهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAD DHUHRI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnat sebelum Dhuhur dua rakaat karena Allah\n" +
                                    "\n" +
                                    "اُصَلِّى سُنَّةَ الظُّهْرِ بَعْدِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : أَللهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAD DHUHRI BADIYATAN RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnat sesudah Dhuhur dua rakaat karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "3.\tEmpat Rakaat Sebelum Ashar", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tSebagaimana penjelasan di atas bahwa empat rakaat ini dijadikan dua salam. "));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Niatnya:\n" +
                                    " اُصَلِّى سُنَّةَ اْلعَصْرِقَبْلِيَةً رَكْعَتَيْنِ لِلَّهِ تَعَـالَى : اَللهُ اَكْبَرُ\n" +
                                    "USHALLII SUNNATAL ASHRI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA \n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnat sebelum Ashar dua rakaat karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "4.\tDua Rakaat Sebelum Maghrib", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tUlama fikih berbeda pendapat tentang shalat sunnah Qabliyah Maghrib ini. Menurut imam Nawawi sunnah melakukan shalat dua rakaat sebelum Maghrib, tetapi menurut sebagian ulama yang lain bahwa shalat dua rakaat sebelum Maghrib tidak disunnahkan"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tNiatnya:\n" +
                                    "اُصَلِّى سُنَّةَالْمَغْرِبِ قَبْلِيَة رَكْعَتَيْنِ الله تَعَـالَى : اَللهُ اَكْبَرْ\n" +
                                    "USHALLII SUNNATAL MAGHRIBI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA \n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah sebelum Maghrib dua rakaat karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "5.\tEmpat Rakaat Setelah Maghrib", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "\tUlama fikih berbeda pendapat tentang shalat sunnah Qabliyah Maghrib ini. Menurut imam Nawawi sunnah melakukan shalat dua rakaat sebelum Maghrib, tetapi menurut sebagian ulama yang lain bahwa shalat dua rakaat sebelum Maghrib tidak disunnahkan"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tNiatnya:\n" +
                                    "اُصَلِّى سُنَّةَالْمَغْرِبِ قَبْلِيَة رَكْعَتَيْنِ الله تَعَـالَى : اَللهُ اَكْبَرْ\n" +
                                    "USHALLII SUNNATAL MAGHRIBI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA \n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah sebelum Maghrib dua rakaat karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "6.\tDua Rakaat Sebelum Isya ", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Niatnya:\n" +
                                    "اُصَلِّى سُنَّةَالْعِشَاءِ قَبْلِيَةً رَكْعَتَيْنِ للهِ تَعَـالَى : اللهُ اَكْبَرْ\n" +
                                    "USHALLII SUNNATAL TSYAAI QABLIYATAN RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah sebelum Isya dua rakaat karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "7.\tDua Rakaat Setelah Isya", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tNiatnya:x\n" +
                                    "اُصَلِّى سُنَّةَالْعِشَاءِ بَعْدِيَّةًبَعْدِيَّةً رَكْعَتَيْنِ الله تَعَـالَى : اللهُ اَكْبَرْ\n" +
                                    "USHALLII SUNNATAL ISYAAI BADIYATAN RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah setelah Isya dua rakaat karena Allah\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Tahajjud"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Tahajjud", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tTahhajjud secara etimologi adalah bangun malam atau tidak tidur malam. Sedangkan Tahajjud dalam pengertian terminologisnya adalah shalat sunnah yang dilakukan di malam hari setelah bangun tidur, baik di awal, pertengahan maupun akhir malam. Jadi, shalat malam yang dilakukan sebelum tidur tidak dapat disebut dengan shalat Tahajjud, melainkan disebut shalat Qiyamul-lail.\n" +
                                    "\tKarena besarnya pahala dan keutamaan shalat tahajjud, umat Islam sangat dianjurkan untuk selalu melakukannya, meskipun hanya dua rakaat. Bahkan makruh meninggalkan shalat Tahajjud bagi orang yang sudah biasa melakukannya.\n" +
                                    "\tDalam shalat Tahajjud tidak ada batas maksimum jumlah rakaatnya. Tetapi menurut sebagian ulama batas maksimum adalah dua belas rakaat, dan batas minimum dua rakaat.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Shalat Sunnah Tahajjud", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "اُصَلِّى سُنَّةَ التَّهَجُّدِ بَعْدِيَّةً رَكْعَتَيْنِِا للهِ تَعَـالَى : اَللهُ اَكْبَرُ\n" +
                                    "USHALLII SUNNATAT TAHAJJUDI RAKATAINI LIL-LAAHI TAAALAA \n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah Tahajjud dua rakaat karena Allah\n" +
                                    " \n" +
                                    "Pada rakaat pertama setelah membaca surat al-Fatihah, membaca surat Al-Kafiruun atau ayat-ayat sebagai berikut;\n" +
                                    "لله مَا فِي السَّمَوَاتِ وَمَا فِي الأرْضِ وَإِنْ تُبْدُوْا مَا فِي أَنْفُسِكُمْ أَوْ تُخْفُوهُ يُحَاسِبْكُمْ بِهِ اللهُ فَيَغْفِرُ لِمَنْ يَشَاءُ وَيُعَذِّبُ مَنْ يَشَاءُ وَالله عَلَى كُلِّ شَيْءٍ قَدِيرٌ . آمَنَ الرَّسُوْلُ بِمَا أُنْزِلَ إِلَيْهِ مِنْ رَبِّهِ وَالْمُؤْمِنُونَ كُلٌّ آمَنَ بِاللهِ وَمَلاَئِكَتِهِ وَكُتُبِهِ وَرُسُلِهِ لاَنُفَرِّقُ بَيْنَ أَحَدٍ مِنْ رُسُلِهِ وَقَالُوْا سَمِعْنَا وَأَطَعْنَا غُفْرَانَكَ رَبَّنَا وَإِلَيْكَ الْمَصِيْرُ . لاَ يُكَلِّفُ اللَّهُ نَفْسًا إِلاَّ وُسْعَهَا لَهَا مَا كَسَبَتْ وَعَلَيْهَا مَااكْتَسَبَتْ رَبَّنَا لاَ تُؤَاخِذْنَا إِنْ نَسِيْنَا أَوْ أَخْطَأْنَا رَبَّنَا وَلاَ تَحْمِلْ عَلَيْنَا إِصْرًا كَمَا حَمَلْتَهُ عَلَى الَّذِيْنَ مِنْ قَبْلِنَا رَبَّنَا وَلاَ تُحَمِّلْنَا مَا لاَ طَاقَةَ لَنَا بِهِ وَاعْفُ عَنَّا وَاغْفِرْ لَنَا وَارْحَمْنَا أَنْتَ مَوْلاَنَا فَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِينَ.\n" +
                                    "Pada rakaat yang kedua setelah membaca al-Fatihah, membaca surat Al-Ikhlas atau ayat-ayat berikut ini;\n" +
                                    " شَهِدَ اللهُ أَنَّهُ لاَ إِلَهَ إِلاَّ هُوَ وَالْمَلاَئِكَةُ وَأُولُوْ الْعِلْمِ قَائِمًا بِالْقِسْطِ لاَ إِلَهَ إِلاَّ هُوَ الْعَزِيزُ الْحَكِيْمُ. إِنَّ الدِّيْنَ عِنْدَ اللهِ اْلإِسْلاَمُ، قُلِ اللَّهُمَّ مَالِكَ الْمُلْكِ تُؤْتِى الْمُلْكَ  مَنْ تَشَاءُ وَتَنْزِعُ الْمُلْكَ مِمَّنْ تَشَاءُ وَتُعِزُّ مَنْ تَشَاءُ وَتُذِلُّ مَنْ تَشَاءُ بِيَدِكَ الْخَيْرُ اِنَّكَ عَلَى كُلِّ شَيْئٍ قَدِيْرٌ. تُوْلِجُ اللَّيْلَ فِى النَّهَارِ وَتُوْلِجُ النَّهَارَ فِى اللَّيْلَ وَتُحْزِجُ الْحَيَّ مِنَ الْمَيِّتِ وَتُحْزِجُ الْمَيِّتَ مِنَ الْحَيِّ وَتَرْزُ قُ مَنْ تَشَاءُ بِغَيْرِ حِسَابِ.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Doa Shalat Sunnah Tahajjud", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "الدُّعَـاءُ:\n" +
                                            " اللَّهُمَّ لَكَ الْحَمْدُ، أَنْتَ قَيُّوْمُ السَّمَوَاتِ وَاْلأَرْضِ وَمَنْ فِيْهِنَّ، وَلَكَ الْحَمْدُ أَنْتَ نُوْرُ السَّمَوَاتِ وَاْلأَرْضِ وَمَنْ فِيهِنَّ، وَلَكَ الْحَمْدُ أَنْتَ مَلِكُ السَّمَوَاتِ وَاْلأَرْضِ وَمَنْ فِيهِنَّ، وَلَكَ الْحَمْدُ, أَنْتَ الْحَقُّ, وَوَعْدُكَ الْحَقُّ, وَلِقَاؤُكَ حَقٌّ, وَقَوْلُكَ حَقٌّ, وَالْجَنَّةُ حَقٌّ, وَالنَّارُ حَقٌّ, وَالنَّبِيُّوْنَ حَقٌّ وَمُحَمَّدٌ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ حَقٌّ، وَالسَّاعَةُ حَقٌّ, أَللَّهُمَّ لَكَ أَسْلَمْتُ، وَبِكَ آمَنْتُ، وَعَلَيْكَ تَوَكَّلْتُ، وَإِلَيْكَ أَنَبْتُ، وَبِكَ خَاصَمْتُ، وَإِلَيْكَ حَاكَمْتُ، فَاغْفِرْ لِيْ مَا قَدَّمْتُ وَمَا أَخَّرْتُ وَمَا أَسْرَرْتُ وَمَا أَعْلَنْتُ أَنْتَ الْمُقَدِّمُ وَأَنْتَ الْمُؤَخِّرُ لآَإِلَهَ إِلاَّ أَنْتَ وَلاَحَوْلَ وَلاَ قُوَّةَ اِلاَّ بِاللهِ، رَبِّ اَدْخِلْنِيْ مُدْخَلَ صِدْقٍ وَاَخْرِجْنِيْ مُخْرَجَ صِدْقٍ وَاجْعَلْ لِىْ مِنْ لَدُنْكَ سُلْطَا نًا نَصِيْرًا \n" +
                                            "Artinya:\n" +
                                            "Ya Allah, bagi-Mu puja dan puji. Engkaulah penjaga langit dan bumi serta isinya. Bagi-Mu pula puja puji, Engkaulah cahaya langit dan bumi serta isinya. Bagi-Mu pula puja dan puji, Engkaulah penguasa langit dan bumi serta isinya. Bagi-mu puja dan puji, Engkau Yang Maha Benar, janji-Mu benar, pertemuan dengan-Mu benar, firman-Mu benar, surga benar, neraka benar, para nabi benar, nabi Muhammad SAW. benar dan hari akhir benar. Ya Allah hanya kepada-Mu aku pasrah diri, kepada-Mu aku beriman, kepada-Mu aku pasrah diri, kepada-Mu aku kembali, karena-Mu aku bertikai dan kepada-Mu aku berhakim (meminta keputusan hukum), maka ampunilah dosa-dosaku yang dahulu dan yang kemudian, dosa-dosa yang tersembunyi dan yang terang-terangan. Engkau Maha Mendahulukan dan Maha Mengkemudiankan. Tidak ada Tuhan selain Engkau. Tidak ada daya dan kekuatan selain dengan pertolongan Allah. Wahai Tuhanku, masukkan aku di dalam tempat yang benar, keluarkan aku di tempat yang benar dan jadikan aku dari sisi-Mu sebagai pemimpin yang menolong.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Tasbih "));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Tasbih ", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Shalat Tasbih adalah shalat sunnah yang di dalamnya membaca:\n" +
                                    "سُبْحَانَ اللهِ وَالْحَمْدُ لِلَّهِ وَلاَ إِلَهَ إِلاَّ اللهُ وَاللهُ أَكْبَرُ\n" +
                                    "\n" +
                                    "SUBHAANAL-LAAHI WAL-HAMDULIL-LAAHI WA LAA ILAAHA ILLALLAAHU WAL-LAAHU AKBAR\n" +
                                    "\n" +
                                    "Dzikir tersebut dibaca sebanyak 300 X dalam empat rakaat, dengan rincian sebagai berikut: \n" +
                                    "Setelah membaca al-Fatihah & ayat al-Quran 15 kali \n" +
                                    "a.\tPada saat Ruku\t\t\t\t\t\t\t\t\t\t\t10 kali\n" +
                                    "b.\tPada saat Itidal\t\t\t\t\t\t\t\t\t\t\t10 kali\n" +
                                    "c.\tPada saat Sujud pertama\t\t\t\t\t\t\t10 kali\n" +
                                    "d.\tPada saat duduk di antara kedua sujud\t10 kali\n" +
                                    "c.\tPada saat sujud yang kedua\t\t\t\t\t\t10 kali\n" +
                                    "d.\tPada saat duduk Istirahat\t\t\t\t\t\t\t10 kali\n" +
                                    "Jumlah \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t75 kali\n" +
                                    "Dan selanjutnya pada rakaat berikutnya sampai empat rakaat. Sehingga jumlah keseluruhan tasbih yang dibaca sebanyak 300 kali.\n" +
                                    "Shalat Tasbih ini jika dilaksanakan pada malam hari maka dilakukan dua-dua, yakni setiap dua rakaat membaca tahiyyat dan salam. Jika dilakukan pada siang hari maka boleh dikumpulkan menjadi satu kali salam, juga boleh dilakukan dua dua rakaat sebagaimana pada malam hari.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Shalat Sunnah Tasbih ", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "1.\tNiat shatat Tasbih yang dua rakaat\n" +
                                    "أُصَلِّى سُنَّةَ التَّسْبِيحِ رَكْعَتَيْنِ لِلَّهِ تَعالىَ\n" +
                                    "USHALLII SUNNATAT TASBIIHI RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat Tasbih dua rakaat karena Allah.\n" +
                                    "\n" +
                                    "2.\tNiat shalat Tasbih yang empat rakaat\n" +
                                    "أُصَلِّى سُنَّةَ التَّسْبِيحِ أَرْبَعَ رَكَعَاتٍ لِلَّهِ تَعالىَ\n" +
                                    "USHALLII SUNNATAT TASBIIHI ARBAA RAKAAATIN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat Tasbih empat rakaat karena Allah.\n" +
                                    "\n" +
                                    "Jumlah Rakaat Shalat Tasbih :\n" +
                                    "Shalat Tasbih ini harus empat rakaat, tidak boleh kurang juga tidak boleh lebih, sebab tasbih yang harus dibaca sebanyak 300x, setiap rakaat 75x.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Doa Shalat Sunnah Tasbih ", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "a)\tDoa berikut ini dibaca setelah membaca tahiyat akhir sebelum salam.\n" +
                                    "اَللَّهُمَّ اِنِّيْ اَسْأَلُكَ تَوْفِيْقَ اَهْلِ الْهُدَى وَاَعْمَالَ اَهْلِ الْيَقِيْنِ وَمُنَاصَحَةَ اَهْلِ التَّوْبَةِ وَعَزْمِ اَهْلِ الصَّبْرِ وَجِدَّ اَهْلِ الْخَشْيَةِ وَطَلَبَ اَهْلِ الرَّغْبَةِ وَتَعَبُّدَ اَهْلِ الْوَرَعِ وَعِرْفَانَ اَهْلِ الْعِلْمِ حَتَّ اَخَافَكَ. اَللَّهُمَّ اِنِّيْ اَسْأَلَكَ مَخَافَةً تَحْجُزُ نِيْ عَنْ مَعَاصِيْكَ حَتَّى اَعْمَلَ بِطَاعَتِكَ عَمَلاً اَسْتَحِقُّ بِهِ رِضَاكَ وَحَتَّى اَنَا صِحَكَ فِى التَّوْبَةِ خَوْفًا مِنْكَ وَحَقَّ اَخْلِصَ لَكَ النَّضِيْحَةَ حُبًّا لَكَ وَحَتَّ اَتَوَكَّلَ عَلَيْكَ فِى اْلاُمُوْرِ كُلِّهَا حُسْنَ ظَنٍّ بِكَ سُبْحَانَكَ يَاخَالِقَ النُّوْرِ، رَبَّنَا اَتْمِمْ لَنَا نُوْرَنَا وَاغْفِرْلَنَا اِنَّكَ عَلَى كُلِّ شَيْئٍ قَدِيْرٌ بِرَحْمَتِكَ يَاأَرْحَمَ الرَّاحِمِيْنَ.\n" +
                                    "Artinya:\n" +
                                    "Ya Allah, sesungguhnya aku memohon kepada-Mu keberhasilan orang-orang yang mendapatkan petunjuk, amal ibadah orang-orang yang yakin (kepada-Mu), ketulusan orang-orang yang bertaubah, kemauan yang kuat orang-orang yang sabar, kesungguhan orang-orang yang takut (kepada-Mu), permohonan orang-orang yang cinta (kepada-Mu), ibadah orang-orang yang wara, pengetahuan orang-orang yang berilmu, sehingga aku merasa takut kepada-Mu. Ya Allah, sesungguhnya aku memohon kepada-Mu rasa takut yang dapat menghalangi aku dari kemaksiatan, sehingga aku beramal taat kepada-Mu dengan amal di mana aku berhak mendapatkan ridlo-Mu, dan sehingga aku tulus bertaubah kepada-Mu karena perasaan takut kepada-Mu, dan sehingga aku ikhlas karena-Mu dalam memberi nasehat karena cinta kepada-Mu, dan sehingga aku pasrah kepada-Mu dalam segala urusanku, karena berbaik sangka kepada-Mu, Maha Suci Engkau, wahai Dzat Pencipta cahaya. Wahai Tuhan kami sempurnakanlah cahaya kami, ampunilah (dosa-dosa) kami, sesungguhnya Engkau Maha Kuasa terhadap segala sesuatu, dengan rahmat-Mu wahai Yang Maha Pengasih.\n" +
                                    "\n" +
                                    "b)\tAdapun setelah salam berdoa sesuai dengan hajat yang diinginkan atau membaca sayyidul istighfar. \n" +
                                    "(سَيِّدُاْلاِسْتِتِعْفَارُ)\n" +
                                    "اَللَّهُمَّ اَنْتَ رَبِّيْ لاَاِلَهَ اِلاَّ اَنْتَ خَلَقْتَنِيْ وَاَنَا عَبْدُكَ وَ اَنَا عَلَى عَهْدِكَ وَوَ عْدِكَ مَااسْتَطَعْتُ، اَعُوْذُبِكَ مِنْ شَرِّمَاصَنَعْتُ، أَبُوْءُلَكَ بِنِعْمَتِكَ عََلَيَّ  وَاَبُوْءُ بِذَنْ بِيْ فَاغْفِرْلِيْ فَاِنَّهُ لاَيَغْفِرُ الذُّنُوْبَ اِلاَّاَنْتَ\n" +
                                    "ALLAAHUMMA ANTA RABBII LAA ILAAHA ILLAA ANTA KHALAQTANII WA ANA ABDUKA WA ANA ALAA AHDIKA WA WATDIKA MASTATHATU, AUUDZU BIKA MIN SYARRI MAA SHANATU ABUU-U LAKA BINITMATIKA ALAYYA WA ABUU-U BI DZANBII FAGHFIR LII FAINNAHUU LAA YAGHFIRUD DZUNUUBA ILLAA ANTA\n" +
                                    "Artinya:\n" +
                                    "Ya Allah, Engkau Tuhanku, tidak ada Tuhan selain Engkau yang menciptakanku, aku hamba-Mu dan aku selalu menepati janji-janji-Mu sesuai dengan kekuatanku, aku berlindung kepada-Mu dari jelek-jeleknya sesuatu yang aku lakukan, aku kembali kepada-Mu dengan membawa nimat-Mu dan aku kembali dengan membawa dosa maka mpunilah aku, sesungguhnya tidak ada yang dapat mengampuni dosa kecuali Engkau.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Witir"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Witir", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\tShalat Witir adalah shalat sunnah yang jumlah rakaatnya ganjil. Waktunya adalah sesudah melaksanakan shalat Isya sampai terbitnya fajar. Shalat Witir sunnah bahkan lebih utama dijadikan sebagai shalat malam yang terakhir atau penutup. \n" +
                                    "\tJumlah Rakaatnya\n" +
                                    "\tShalat witir maksimum sebelas rakaat, dan minimum satu rakaat. Jika melakukan shalat witir lebih dari satu rakaat maka jumlah rakaatnya harus ganjil, yakni tiga, lima, tujuh, sembilan atau sebelas. Cara pelaksanaannya ada dua macam :\n" +
                                    "\t-\tPertama, semua rakaat dikumpulkan menjadi satu kali tahiyyat dan salam. Misalnya tiga rakaat, langsung disambung menjadi satu kali salam-an.\n" +
                                    "\t-\tKedua, dilakukan dua-dua rakaat, yakni setiap dua rakaat membaca tahiyyat dan salam, kemudian diakhiri dengan satu rakaat, sebagai rakaat ganjil penutup.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Shalat Sunnah Witir", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "1.\tNiat Untuk Yang Satu Rakaat\n" +
                                    " اُصَلِّي سُنَّةَ الوِتْرِ رَكَعَةً لِلَّهِ تَعَالىَ. اَللَّهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAL WITRI RAKATAN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah Witir satu rakaat karena Allah\n"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent, "2.\tNiat Untuk Yang Dua Rakaat\n" +
                                    "اُصَلِّي سُنَّةَ الوِتْرِ رَكَعَتَيْنِ لِلَّهِ تَعَالىَ. اَللَّهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAN MINAL-WITRI RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah Witir dua rakaat karena Allah\n"));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "3.\tNiat Untuk Yang Tiga Rakaat\n" +
                                    "اُصَلِّي سُنَّةَ الوِتْرِ رَكَعَا تٍ لِلَّهِ تَعَالىَ. اَللَّهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAL WITRI TSALAATSA RAKAAATIN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah Witir tiga rakaat karena Allah\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Do'a Shalat Sunnah Witir", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "سُبْحَانَ الْمَلِكِ الْقُدُّوْسُ 3 ×\n" +
                                    "سُبُّوْحٌ قُدُّوْسٌ رَبُّناَ وَرَبُّ الْمَلاَ ئِكَةِ وَالرُّوْحِ.3×\n" +
                                    "اَشْهَدُاَنْ لاَ اِلَهَ اِلاَّاللهُ اَسْتَغْفِرُاللهَ اَسْأَلُكَ رِضَاكَ وَالْجَنَّةَ وَاَعُوْذُبِكَ مِنْ سَخَطِكَ وَالنَّارِ 3×. اَللَّهُمَّ إِنَّكَ عَفُوٌّ كَرِيْمٌ تُحِبُّ الْعَفْوَ فَاعْفُ عَنَّا. 3 × يَا كَرِيْمُ. \n" +
                                    "SUBHAANAL MALIKIL QUDDUS (3x) SUBBUUHUN QUDDUUSUN RABBUNAA WA RABBUL MALAAIKATI WAR-RUUH (3x) ASYHADU AN LAA ILAAHA ILLA-LAAHU ASTAGHFIRUL-LAAHA AS-ALUKA RIDLAAKA WAL-JANNATA WA AUUDZU BIKA MIN SAKHATHIKA WAN-NAAR (3x) ALLAAHUMMA INNAKA AFUWWUN KARIIMUN TUHIBBUL AFWA FAFU ANNAA (3x)\n" +
                                    "Artinya:\n" +
                                    "Maha Suci Dzat Yang Maha Raja lagi Maha Suci. Yang Maha Suci adalah Tuhan kami, para malaikat dan malaikat Jibril. Aku bersaksi tidak ada Tuhan selain Allah. Aku memohon ampun kepada-Nya. Aku memohon ridlo-Mu dan surga, dan aku berlindung kepada-Mu dari murka-Mu dan neraka. Ya Allah, sesungguhnya Engkau Maha Mengampuni, Maha Pemurah dan senang mengampuni, maka ampunilah kami, wahai Yang Maha Pemurah.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Hajat"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Hajat", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Shalat Hajat adalah shalat sunnah yang dilakukan karena ada kebutuhan atau kepentingan, baik kepada Allah maupun kepada sesama manusia. Shalat Hajat boleh dilakukan kapan saja, selain waktu-waktu yang dilarang."));

                        detailContents.add(new DetailContent(idDetailContent, "1.\tShalat Hajat dua rakaat sebagaimana biasa.", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "•\tRakaat pertama setelah Al-Fatihah membaca surat al-Kafiruun 10 kali.\n" +
                                    "•\tRakaat kedua setalah al-Fatihah membaca surat Al-Ikhlas 10 kali.\n" +
                                    "Setelah shalat memuji Allah, membaca shalawat kepada nabi Muhammad SAW. dan membaca doa sebagaimana tertulis dalam teks hadits di atas atau doa yang tertulis pada point berikut.\n" +
                                    "Niat Shalat Hajat Dua Rakaat\n" +
                                    "أُصَلِّى سُنَّةً لِقَضَاءِ الْحَاجَةِ رَكْعَتَيْنِ ِللهِ تَعَالَى. اَللَّهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAN LI QADLAAIL HAAJATI RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat untuk terpenuhinya hajat dua rakaat karena Allah.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "2.\tShalat Hajat empat rakaat dengan cara sebagai berikut.", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "•\tRakaat pertama setelah al-Fatihah membaca surat al-Ikhlas 10 kali\n" +
                                    "•\tRakaat kedua setelah al-Fatihah membaca surat al-Ikhlas 20 kali\n" +
                                    "•\tRakaat ketiga setelah al-Fatihah membaca surat al-Ikhlas 30 kali\n" +
                                    "•\tRakaat keempat setelah al-Fatihah membaca surat al-Ikhlas 40 kali\n" +
                                    "Niat Shalat Hajat Empat Rakaat\n" +
                                    "اُصَلِّى سُنَّةً لِقَضَاءِ الْحَاجَةِ مِنْ جَلْبِ النَّعْمَاءِ وَكَشْفِ الْبَلْوَى وَدَفْعِ اْلاَعْدَاءِ خُصُوْصًا .... رَكْعَتَيْنِ/اَرْبَعَ رَكَعَاتٍ  ِللهِ تَعَالَى.\n" +
                                    "\n" +
                                    "USHALLII SUNNATAN LI QADLAAIL HAAJATI MIN JALBIN NAMAA-I WA KASYFIL BALWAA WA DAFIL ADAA-I KHUSHUUSHAN……….RAKATAINI/ARBAA RAKAAATIN LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah untuk dipenuhinya hajat, berupa ditarikkan segala kenikmatan, dihindarkan dari petaka dan jauhkan dari musuh, dua/empat rakaat karena Allah SWT.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "2.\tDzikir ", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "اَللَّهُمَّ صَلِّ عَلَى سَيِّدِيْنَا مُحَمَّدٍ صَلاَّةً تُوَسِّعُ بِهَا عَلَيْنَا اْلاَرْزَاقَ وَتُحَسِّنُ بِهَا لَنَا اْلاَخْلاَقَ وَعَلَى اَلِهِ وَصَحْبِهِ وَسَلِّمْ.\n" +
                                    "\n" +
                                    "ALAAHUMMA SHALLI ALAA SAYYIDINAA MUHAMMADIN SHALAATAN TUWASSIU BIHAA ALAINAL ARZAAQA WA TUHASSINU BIHAA LANAL AKHLAAQA WA ALAA AALIHII WA SHAHBIHII WA SALLIM (50 x)\n" +
                                    "Artinya:\n" +
                                    "Ya limpahkanlah shalawat dan salam kepada nabi Muhammad, keluarga dan sahabatnya, dengan shalawat yang dapat meluaskan rizki kami dan memperbaiki akhlaq kami.\n" +
                                    " اَسْتَغْفِرُاللهَ الْعَظِيْمَ لِيْ وَلِوَالِدَيَّ وَلِجَمِيْعِ الْمُسْلِمِيْنَ وَالْمُسْلِمَاتِ وَالْمُؤْمِنِيْنَ وَالْمُؤْمِنَاتِ اَلاَحْيَاءِ مِنْهُمْ وَاْلاَمْوَاتِ.\n" +
                                    "\n" +
                                    "ASTAGHFIRUL-LAAHAL ADHIIMA LII WA LIWAALIDAYYA WA LI JAMIIIL MUSLIMIINA WAL MUSLIMAATI WAL MU \"MINIINA. WAL MUMIINAATI AL-AHYAAI MINHUM WAL AMWAATI (50 x)\n" +
                                    "Artinya:\n" +
                                    "Aku memohon ampunan kepada Allah, untukku sendiri, kedua orang tuaku, seluruh orang-orang Islam, baik laki-laki maupun perempuan, dan seluruh orang-orang yang beriman, baik laki-laki maupun perempuan, baik yang rnasih hidup maupun yang sudah mati.\n" +
                                    "\n" +
                                    "لاَحَوْلاَ وَلاَ قُوَّةَ اِلاَّ بِاللهِ الْعَلِيِّ الْعَظِيْمِ.\n" +
                                    "LA HAULA WA LAA QUWWATA ILLAA BIL-LAAHIL ALIYYIL ADHIIM\n" +
                                    "Artinya:\n" +
                                    "Tidak ada daya dan kekuatan selain pertolongan Allah Yang Maha Tinggi dan Maha Agung.\n" +
                                    "اَلدُّعَاءُ: \n" +
                                    "بِسْمِ اللهِ الرَّحْمَنِ الرَّحِيْمِ\n" +
                                    "وَاَسْأَلُكَ بِاَسْمَائِكَ يَاكَافِيْ يَاوَافِيْ يَاشَافِيْ يَامُعَافِيْ يَامُجِيْبَ دَعْوَةِ الْمُضْطَرِيْنَ يَاقَضِيَ يَارَاضِيَ يَاهَادِيْ يَاعَلِيُّ يَاوَافِيْ سُبْحَانَكَ لاَاِلَهَ اِلاَّ اَنْتَ غَوْثُ الْغَوْثِ خَلِّصْنَا مِنَ النَّارِ يَارَبِّ يَارَبِّ يَامَنْ اَظْهَرَ الْجَمِيْلَ وَسَتَرَ الْقَبِيْحَ يَامَنْ لاَيُؤَاخِذُ الجَرِيْمَةَ وَلاَ تَهْتِكُ السِّتْرَ يَاعَظِيْمَ الْعَفْوِ يَاحَسَنَةَ التَّزَوُّجِ يَاوَاسِعَ الْمَغْفِرَةِ يَابَاصِطَ الْيَدَيْنِ بِرَحْمَتِكَ يَاصَاحِبَ كُلِّ النَّجَواى يَاكَاشِفَ الْبَلْوَى يَامُنْتَهَى كُلِّ الشَّكْوَى يَكَرِيْمَ الصِّفَاتِ يَاعَظِيْمَ الْعَفْوِ سُبْحَانَكَ لاَاِلَهَ اِلاَّ اَنْتَ غَوْثُ الْغَوْثِ خَلِّصْنَا مِنَ النَّارِ 11x\n" +
                                    "\n" +
                                    "Artinya:\n" +
                                    "Aku memohon kepada-Mu dengan nama-nama-Mu, wahai Yang Maha Mencukupi, Yang Maha Menyempurnakan, Yang Maha Menyembuhkan, Yang Maha Menyehatkan, Yang Maha Mengabulkan permohonan orang-orang yang terdesak, Yang Maha Memutuskan, Yang Maha Meridloi, Yang Maha Menunjukkan, Yang Maha Tinggi, Yang Maha Menyempurnakan, Maha Suci Engkau, tidak ada Tuhan selain Engkau, penolong orang-orang yang memohon pertolongan, selamatkan kami dari api neraka, wahai Tuhan kami, wahai Yang Menampakkan kebaikan Dan menutupi kejelekan, Yang Tidak Menyiksa sebab dosa, Yang Tidak Merobek taber, Yang Maha Agung ampunannya, Yang Maha Bagus dalam memberikan pasangan, Yang Maha Luas ampunannya Yang Membentangkan kedua tangan, dengan rahmat-Mu wahai Dzat Yang Memiliki segala bisikan, Yang Maha Penyingkap cobaan, Yang Menjadi akhir setiap pengaduan, Yang Maha Mulia sifat-sifat-Nya, Yang Maha Besar ampunannya, Maha Suci Engkau, tidak ada Tuhan selain Engkau, penolong orang-orang yang memohon pertolongan, selamatkan kami dari neraka, wahai Tuhan kami.\n" +
                                    "\n" +
                                    "بِسْمِ اللهِ الرَّحْمَنِ الرَّحِيْمِ\n" +
                                    "اَلْحَمْدُ ِللهِ رَبِّ الْعَالَمِيْنَ، اَللَّهُمَّ صَلِّ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى اَلِ سَيِّدِنَا مُحَمَّدٍ وَصَحْبِهِ وَسَلِّمْ، لاَاِلَهَ اِلاَّاللهُ الْعَظِيْمُ الْحَلِيْمُ لاَاِلَهَ اِلاَّ اللهُ رَبُّ الْعَرْشِ الْعِظِيْمُ لاَاِلَهَ اِلاَّاللهُ رَبُّ السَّمَوَاتِ وَرَبُّ اْلاَرْضِ وَرَبُّ الْعَرْشِ الْكَرِيْمِ اَللَّهُمَّ كَاشِفَ الْغَمِّ مُفَرِّجَ الْهَمِّ مُجِيْبَ دَعْوَةِ الْمُضْطَرِّيْنَ اِذَا دَعَوْكَ رَحْمَنَ الدُّنْيَا وَالآخِرَةِ وَرَحِيْمَهُمَا اِرْحَمْنَا فِيْ حَاجَتِنَا هَذِهِ .... بِقَضَائِهَا وَنَجَاحِهَا رَحْمَةً تُغْنِيْنَا بِهَا عَمَّنْ سِوَاكَ، اَللَّهُمَّ اِنَّا نَسْأَلُكَ مُوْجِبَاتِ رَحْمَتِكَ وَعَزَا ائِمَ مَغْفِرَتِكَ وَالْعِصْمَةَ مِنْ كُلِّ ذَنْبٍ وَالْغَنِيْمَةَ مِنْ كُلِّ بِرٍّ وَالسَّلاَمَةَ مِنْ كُلِّ اِثْمٍ لاَتَدَعْ لِيْ ذَنْبًا اِلاَّ غَفَرْتَهُ وَلاَ هَمًّا اِلاَّ فَرَّجْتَهُ وَلاَ مَرَضًا اِلاَّ شَفَيْتَهُ وَلاَ حَاجَةً اِلاَّ قَضَيْتَهَا يَااَرْحَمَ الرَّاحِمِيْنَ 3\n" +
                                    "\n" +
                                    "\n" +
                                    "Artinya:\n" +
                                    "Dengan menyebut nama Allah Yang Maha Pengasih lagi Maha Penyayang. Segala puji bagi Allah, Tuhan semesta. Ya Allah, limpahkan shalawat dan salam kepada nabi Muhammad, keluarga dan sahabatnya. Tidak ada Tuhan selain Allah Yang Maha Agung dan Yang Maha Pemurah hati. Tidak ada Tuhan selain Allah Yang Memiliki Arasy yang besar. Tidak ada Tuhan selain Allah, Tuhan langit dan bumi dan pemilik Arasy yang mulia. Ya Allah, Maha Penyingkap kesusahan, Melapangkan kecemasan, Mengabulkan permohonan orang-orang yang terdesak jika mereka memohon kepada-Mu, pengasih di dunia dan akhirat lagi penyayang di dunia dan akhirat, kasihanilah kami dalam hajat kami ini…………dengan merealisasikan dan menyukseskannya, dengan kasih sayang yang mencukupkan kami dengannya dari orang selain-Mu. Ya Allah, kami memohon kepada-Mu segala sesuatu yang menyebabkan kasih sayang-Mu dan ampunan-Mu, terjaga dari segala dosa, kaya dari segala kebaikan, selamat dari segala dosa. jangan Engkau tinggalkan bagiku dosa kecuali Engkau ampuni, jangan Engkau tinggalkan bagiku kecemasan kecuali Engkau lapang-kan, jangan Engkau tinggalkan bagiku penyakit kecuali Engkau sembuhkan, jangan Engkau tinggalkan bagiku hajat kecuali Engkau realisasikan. Wahai Yang Maha Pengasih.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Dluha"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Dluha", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Shalat Dluha adalah shalat sunnah yang dilakukan di pagi hari, sejak naiknya matahari dalam ketinggian sepenggalah sampai tengah hari. Shalat Dluha maksimum delapan rakaat. Ada sebagaian ulama yang berpendapat sampai dua belas rakaat, sedangkan batas minimum adalah dua rakaat.\n" +
                                    "Surat yang dibaca sebagai berikut:\n" +
                                    "\t-\tRakaat pertama surat Al-Syams atau surat Al-Kafiruun.\n" +
                                    "\t-\tRakaat kedua surat Al-Dluha atau surat Al-Ikhlas.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Shalat Sunnah Dluha", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "أصَلِّي سُنَّةَ الضُحَى رَكَعَتَيْنِ لِلَّهِ تَعالىَ. اَللَّهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAD DLUHAA RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat Dluha dua rakaat karena Allah SWT.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Do'a Shalat Sunnah Dluha", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "\n" +
                                    " اللَّهُمَّ إِنَّ الضُّحَاءَ ضُحَاءُكَ وَالْبَهَاءَ بَهَائُكَ وَالْجَمَالَ جَمَالُكَ وَالْقُوَّةَ قُوَّتُكَ وَالْقُدْرَةَ قُدْرَتُكَ وَالْعِصْمَةَ عِصْمَتُكَ . اللَّهُمَّ إِنْ كَانَ رِزْقِي فِي الْسَمَاءِ فَأَنْزِلْهُ وَإِنْ كَانَ فِيْ الأَرْضِ فأَخْرِجْهُ وَإِنْ كَانَ مَعْسِرًا فَيَسِّرْهُ وَإِنْ كَانَ حَرَامًا فَطَهِّرْهُ وَإِنْ كَانَ بَعِيْدًا فَقَرِّبْهُ  وَاِنْ كَانَ قَلِيْلاً فَكَثِّرْهُ وَاِنْ كَانَ كَثِيْرًا فَبَارِكْ لِيْ فِيْهِ وَاَوْصِلْهُ اِلَيَّ حَيْثُ كُنْتُ وَلاَ تَنْقُلْنِيْ اِلَيْهِ حَيْثُ كَانَ وَاجْمَلْ يَدَيَّ الْعُلْيَا بِالاِعْطَاءِ وَلاَ تَجْعَلْهُمَا السُّفْلَى بِالاِسْتِعْطَاءِ اِنَّكَ عَلَى كُلِّ شَيْئٍ قَدِيْرٌ بِحَقِّ ضُحَائِكَ وَبَهَائِكَ وَجَمَالِكَ وَقُوَّتِكَ وَقُدْرَتِكَ وَعِصْمَتِكَ وَلاَ حَوْلَ وَلاَقُوَّةَ اِلاَّ بِكَ اَتِنِىْ مَااَتَيْتَ عِبَادَكَ الصَّالِحِيْنَ وَصَلَّى اللهُ عَلَى سَيِّدِنَا مُحَمَّدٍ وَعَلَى اَلِهِ وَصَحْبِهِ وَسَلَّمْ سُبْحَانَ رَبِّكَ رَبِّ الْعِزَّةِ عَمَّايَصِفُوْنَ وَسَلاَمٌ عَلَى الْمُرْسَلِيْنَ وَالْحَمْدُللهِ رَبِّ الْعَالَمِيْنَ.\n" +
                                    "Artinya:\n" +
                                    "Ya Allah, sesungguhnya waktu Dluha adalah waktu Dluha-Mu, kecakapan adalah kecakapan-Mu, keindahan adalah keindahan-Mu, kekuatan adalah kekuatan-Mu, kemampuan adalah kemampuan-Mu dan keterpeliharaan adalah keterpeliharaan-Mu. Ya Allah, jika rizkiku berada di langit maka Engkau turunkan, jika berada di dalam bumi maka Engkau keluarkan, jika sulit maka Engkau mudahkan, jika haram maka Engkau bersihkan, jika jauh maka Engkau dekatkan, jika sedikit maka Engkau perbanyak, jika banyak maka Engkau berkahkan, sampaikan rizkiku padaku di mana aku berada, jangan Engkau pindahkan aku ke tempatnya, jadikanlah kedua tanganku berada di atas dengan memberi, jangan Engkau jadikan kedua tanganku berada di bawah dengan meminta, sesungguhnya Engkau Maha Kuasa atas segala sesuatu, dengan kebenaran waktu Dluha-Mu, kecakapan-Mu, keindahan-Mu, kekuatan-Mu, kemampuan-Mu dan keterpeliharaan-Mu. Tidak ada daya dan kekuatan kecuali dengan pertolongan-Mu, berilah aku sesuatu yang telah Engkau berikan kepada hamba-hamba-Mu yang saleh Limpahkan shalawat dan salam kepada nabi Muhammad SAW., keluarga dan para sahabatnya. Segala puji bagi Allah, Tuhan semesta.\n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Tahiyyatil Masjid"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Tahiyyatil Masjid", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Shalat Tahiyyatil Masjid adalah shalat penghormatan kepada masjid. Shalat ini disunnahkan bagi orang yang bermaksud duduk di dalam masjid, kecuali Masjidil Haram. Orang yang masuk Masjidil Haram disunnahkan thawaf kemudian shalat dua rakaat di maqam Ibrahim."));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Shalat Tahiyyatil Masjid", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, " أُصَلِّى سُنَّةً لِتَحِيَّةِ الْمَسْجِدِ رَكْعَتَيْنِ للهِ تَعَالَى. اَللَّهُ أَكْبَرُ\n" +
                                    "USHALLII SUNNATAN LI TAHIYYATIL MASJIDI RAKATAINI LIL-LAAHI TAAALAA\n" +
                                    "Artinya : \n" +
                                    "Saya niat shalat sunnah untuk menghormati masjid dua rakaaat karena Allah. \n"));

                    subMenuContents.add(new SubMenuContent(idSubMenu, 3, "Shalat Sunnah Istikharah"));
                        detailContents.add(new DetailContent(idDetailContent, "Pengertian Shalat Sunnah Istikharah", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "Shalat sunnah Istikharah adalah shalat yang dilakukan untuk memohon pilihan yang baik dari sesuatu yang akan dilakukan. "));

                        detailContents.add(new DetailContent(idDetailContent, "Niat Shalat Sunnah Istikharah", idSubMenu, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "أُصَلِّى سُنَّةَ اْلاِسْتِخَارَةِ رَكْعَتَيْنِ للهِ تَعَالَى\n" +
                                    "Artinya:\n" +
                                    "Saya niat shalat sunnah Istikharah dua rakaat karena Allah.\n"));

                        detailContents.add(new DetailContent(idDetailContent, "Do'a Shalat Sunnah Istikharah", idSubMenu++, 1));
                            isiDetailContents.add(new IsiDetailContent(idIsiDetail++, idDetailContent++, "اَلاَ يَعْلَمُ مَنْ خَلَقَ وَهُوَ الَّطِيْفُ اْلخَبِيْرُ.\n" +
                                    "ALAA YALAMU MAN KHALAQA WA HUWAL LATHIIFUL KHABIIR, 333X\n" +
                                    "Artinya:\n" +
                                    "Ingatlah, Maha Mengetahui Dzat yang Menciptakan, Dia Maha Lembut dan Maha Mengetahui\n" +
                                    "هُوَاللهُ\n" +
                                    "HUWAL-LAAH, 1000x-5000x\n" +
                                    "\n" +
                                    "Artinya:\n" +
                                    "Dialah Allah \n" +
                                    "Kemudian membaca dzikir ini maka berdoa seperti yang tertera dalam hadits di atas. Setelah melakukan shalat, dzikir dan doa maka lakukan sesuatu yang sesuai dengan kelapangan dada.\n"));
// ======================================================================================================================================
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
