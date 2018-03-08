package com.d4it_b.hajidanumroh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.d4it_b.hajidanumroh.model.DetailContent;
import com.d4it_b.hajidanumroh.model.IsiDetailContent;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

import java.util.ArrayList;
import java.util.List;

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

    public DBHandler(Context context) {
        super(context, "db_haji_umroh", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ NAMA_TABLE_UTAMA + " ( "
                + KEY_ID_TABLE_UTAMA + " INTEGER PRIMARY KEY, "
                + KEY_TEXT_TABLE_UTAMA + " TEXT "
                + " ) ");

        db.execSQL("CREATE TABLE " + NAMA_TABLE_SUBMENU + " ( "
                + KEY_ID_SUB_MENU + " INTEGER PRIMARY KEY, "
                + KEY_ID_TABLE_UTAMA + " INTEGER, "
                + KEY_TEXT_SUB_MENU + " TEXT"
                + ")"
        );

        db.execSQL("CREATE TABLE " + NAMA_TABLE_DETAIL_CONTENT + " ( "
                + KEY_ID_DETAIL_CONTENT + " INTEGER PRIMARY KEY, "
                + KEY_ID_SUB_MENU + " INTEGER, "
                + KEY_TEXT_DETAIL_CONTENT + " TEXT, "
                + KEY_ISSET_ISI + " INTEGER "+
                " ) "
        );

        db.execSQL("CREATE TABLE " + NAMA_TABLE_ISI_DETAIL_CONTENT + " ( "
                + KEY_ID_ISI_DETAIL + " INTEGER PRIMARY KEY, "
                + KEY_ID_DETAIL_CONTENT + " INTEGER, "
                + KEY_TEXT_ISI + " TEXT "
                + " ) "
        );
    }

//    memasukan data pada table utama
    public void addMainTable(int idTableUtama, String nama){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID_TABLE_UTAMA, idTableUtama);
        values.put(KEY_TEXT_TABLE_UTAMA, nama);
        db.insert(NAMA_TABLE_UTAMA,null,values);
    }
//=====================================================================

//    memsasukan data pada table sub menu
    public void addAllTableSubMenu(ArrayList<SubMenuContent> subMenuContents){
        for (SubMenuContent subMenuContent : subMenuContents){
            addTableSubMenu(subMenuContent);
        }
    }

    private void addTableSubMenu(SubMenuContent subMenuContent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID_SUB_MENU, subMenuContent.getIdSubMenu());
        values.put(KEY_ID_TABLE_UTAMA, subMenuContent.getIdTableUtama());
        values.put(KEY_TEXT_SUB_MENU, subMenuContent.getStr_());

        db.insert(NAMA_TABLE_SUBMENU, null, values);
    }
//    ======================================================================

//  memasukan data pada table detail content
    public void addAllDetailContent(ArrayList<DetailContent>detailContents){
        for (DetailContent detailContent : detailContents){
            addDetailContent(detailContent);
        }
    }

    private void addDetailContent(DetailContent detailContent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID_DETAIL_CONTENT, detailContent.getIdDetailContent());
        values.put(KEY_ID_SUB_MENU, detailContent.getIdSubMenuContent());
        values.put(KEY_TEXT_DETAIL_CONTENT, detailContent.getStrDetailConten());
        values.put(KEY_ISSET_ISI, detailContent.getIsSetIsi());

        db.insert(NAMA_TABLE_DETAIL_CONTENT, null, values);
    }
//=============================================================================

//    memasukan date pada table isi detail
    public void addAllIsiDetail(ArrayList<IsiDetailContent>isiDetailContents){
        for (IsiDetailContent isiDetailContent : isiDetailContents){
            addIsiDetail(isiDetailContent);
        }
    }

    private void addIsiDetail(IsiDetailContent isiDetailContent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID_ISI_DETAIL, isiDetailContent.getIdIsiDetail());
        values.put(KEY_ID_DETAIL_CONTENT, isiDetailContent.getIdDetailContent());
        values.put(KEY_TEXT_ISI, isiDetailContent.getStr_());

        db.insert(NAMA_TABLE_ISI_DETAIL_CONTENT, null, values);
    }
//    ===========================================================================

//    mengambil data sub menu (umroh, haji dkk)
    public List<SubMenuContent> getAllSubMenu(int idTableUtama){
        List<SubMenuContent> subMenuContents = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM "+ NAMA_TABLE_SUBMENU + " WHERE " + KEY_ID_TABLE_UTAMA + " = " + idTableUtama + " ORDER BY " + KEY_ID_SUB_MENU + " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            subMenuContents.add(new SubMenuContent(res.getInt(0), res.getInt(1), res.getString(2)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return subMenuContents;
    }
//    ==================================================================================

//    mengambil data detail content
    public List<DetailContent> getAllDetailContent(int idSubMenu){
        List<DetailContent> detailContents = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM "+ NAMA_TABLE_DETAIL_CONTENT+ " WHERE " + KEY_ID_SUB_MENU+ " = " + idSubMenu+ " AND "+ KEY_ISSET_ISI + " = 1" +" ORDER BY " + KEY_ID_DETAIL_CONTENT+ " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            detailContents.add(new DetailContent(res.getInt(0), res.getString(2),  res.getInt(1), res.getInt(3)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return detailContents;
    }
//    =====================================================

//    mengambil isi-isi dari detailContent
    public List<IsiDetailContent> getAllIsiDetail(int idDetail){
        List<IsiDetailContent> isiDetailContents = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM "+ NAMA_TABLE_ISI_DETAIL_CONTENT + " WHERE " + KEY_ID_DETAIL_CONTENT+ " = " + idDetail+ " ORDER BY " + KEY_ID_ISI_DETAIL+ " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            isiDetailContents.add(new IsiDetailContent(res.getInt(0),  res.getInt(1), res.getString(2)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return isiDetailContents;
    }
//==========================================================

//    Mengambil Text dari Detail Content
    public ArrayList<String> getTextDetailContent(int idSubMenu){
        ArrayList<String> content = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + NAMA_TABLE_DETAIL_CONTENT + " WHERE " + KEY_ID_SUB_MENU + " = " + idSubMenu;
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            content.add(res.getString(2));
            res.moveToNext();
        }

        res.close();
        db.close();

        return  content;
    }
//    =====================================================

//    Mengambil Text dari table Isi Detail Content
    public ArrayList<String> getTextIsiDetailContent(int idDetailContent){
        ArrayList<String> content = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + NAMA_TABLE_ISI_DETAIL_CONTENT + " WHERE " + KEY_ID_DETAIL_CONTENT + " = " + idDetailContent;
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();
        Log.i("Res", "getTextIsiDetailContent: "+ res.getColumnCount());

        while (!res.isAfterLast()){
            content.add(res.getString(2));
            res.moveToNext();
        }
        res.close();
        db.close();
        return  content;
    }

    public String getTitleAct (int idTable, String namaTable){
        String string = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String query = null;
        if (namaTable.equals(NAMA_TABLE_UTAMA)){
            query = "SELECT "+ KEY_TEXT_TABLE_UTAMA +" FROM " + NAMA_TABLE_UTAMA + " WHERE " + KEY_ID_TABLE_UTAMA + " = " + idTable;
        }else{
            query = "SELECT "+ KEY_TEXT_SUB_MENU +" FROM " + NAMA_TABLE_SUBMENU + " WHERE " + KEY_ID_SUB_MENU + " = " + idTable;
        }

        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        string =  res.getString(0);
        res.close();
        db.close();
        return string;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_UTAMA);
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_SUBMENU);
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_DETAIL_CONTENT);
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE_ISI_DETAIL_CONTENT);

        onCreate(db);
    }
}
