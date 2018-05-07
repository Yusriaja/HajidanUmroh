package com.d4it_b.hajidanumroh.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by M N D on 23/02/2018.
 */

public class DBHandler extends SQLiteOpenHelper {

//    Nama-Nama Table
    private static final String NAMA_TABLE_UTAMA = "tb_utama";// berisi haji, umroh, dam, doa, sholat,
    private static final String NAMA_TABLE_SUBMENU = "tb_sub_menu"; //berisi submenu dari tiap tb_utama
    private static final String NAMA_TABLE_DETAIL_CONTENT = "tb_detail_content";
    private static final String NAMA_TABLE_ISI_DETAIL_CONTENT = "tb_isi_detail_content";//berisikan jabaran dari tiap2 detail kontent

//    field-field table utama
    private static final String KEY_ID_TABLE_UTAMA = "id_tb_utama";
    private static final String KEY_TEXT_TABLE_UTAMA = "str_tb_utama";

//    field-field tb_submenu
    private static final String KEY_ID_SUB_MENU = "id_sub_menu";
    private static final String KEY_TEXT_SUB_MENU = "str_sub_menu";

//    field-field tb_detail_content
    private static final String KEY_ID_DETAIL_CONTENT = "id_detail_content";
    private static final String KEY_TEXT_DETAIL_CONTENT = "str_detail_content";
    private static final String KEY_ISSET_ISI = "is_iset_isi";

//    field-field tb_isi_detail_content
    private static final String KEY_ID_ISI_DETAIL = "id_isi_detail_content";
    private static final String KEY_TEXT_ISI = "str_isi_detail";

    private SQLiteDatabase mDatabase;

    public static String DB_NAME = "haji_umroh.sqlite";

    private Context context;

    String DB_PATH;
    String divider = "/";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, 8);
        this.context = context;
        DB_PATH = divider + "data" + divider + "data" + divider + context.getPackageName() + divider + "databases/";
    }

    public boolean isDataBaseExists() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();
    }

    public void importDataBaseFromAssets() throws IOException {

        this.getReadableDatabase();

        InputStream myInput = context.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        db.execSQL("CREATE TABLE "+ NAMA_TABLE_UTAMA + " ( "
//                + KEY_ID_TABLE_UTAMA + " INTEGER PRIMARY KEY, "
//                + KEY_TEXT_TABLE_UTAMA + " TEXT "
//                + " ) ");
//
//        db.execSQL("CREATE TABLE " + NAMA_TABLE_SUBMENU + " ( "
//                + KEY_ID_SUB_MENU + " INTEGER PRIMARY KEY, "
//                + KEY_ID_TABLE_UTAMA + " INTEGER, "
//                + KEY_TEXT_SUB_MENU + " TEXT"
//                + ")"
//        );
//
//        db.execSQL("CREATE TABLE " + NAMA_TABLE_DETAIL_CONTENT + " ( "
//                + KEY_ID_DETAIL_CONTENT + " INTEGER PRIMARY KEY, "
//                + KEY_ID_SUB_MENU + " INTEGER, "
//                + KEY_TEXT_DETAIL_CONTENT + " TEXT, "
//                + KEY_ISSET_ISI + " INTEGER "+
//                " ) "
//        );
//
//        db.execSQL("CREATE TABLE " + NAMA_TABLE_ISI_DETAIL_CONTENT + " ( "
//                + KEY_ID_ISI_DETAIL + " INTEGER PRIMARY KEY, "
//                + KEY_ID_DETAIL_CONTENT + " INTEGER, "
//                + KEY_TEXT_ISI + " TEXT "
//                + " ) "
//        );

//        Log.i("db_haji_umroh", "onCreate: "+db.getPath());
//        Toast.makeText(this, "DB Created @ "+, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_UTAMA);
//        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_SUBMENU);
//        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_DETAIL_CONTENT);
//        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_ISI_DETAIL_CONTENT);
//
//        onCreate(db);
    }
}
