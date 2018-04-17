package com.d4it_b.hajidanumroh.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.d4it_b.hajidanumroh.model.ContentDetailAct;
import com.d4it_b.hajidanumroh.model.ContentSubMenu;
import com.d4it_b.hajidanumroh.model.DetailContent;
import com.d4it_b.hajidanumroh.model.IsiDetailContent;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by M N D on 14/03/2018.
 */

public class DbQueries {

    Context context;
    public SQLiteDatabase database;
    DBHandler dbHelper;

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
    private static final String KEY_ARAB_DETAIL = "arab_detail";
    private static final String KEY_LATIN_DETAIL = "latin_detail";
    private static final String KEY_ARTI_DETAIL = "arti_detail";

    //    field-field tb_isi_detail_content
    private static final String KEY_ID_ISI_DETAIL = "id_isi_detail_content";
    private static final String KEY_TEXT_ISI = "str_isi_detail";
    private static final String KEY_ARAB_ISI = "arab_isi";
    private static final String KEY_LATIN_ISI = "latin_isi";
    private static final String KEY_ARTI_ISI = "arti_isi";

    public DbQueries(Context context) {
        this.context = context;
    }

    public DbQueries open() throws SQLException {
        dbHelper = new DBHandler(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

//=====================================================================

    public void addAllDataSubMenu(ArrayList<SubMenuContent>subMenuContents){
        for (SubMenuContent subMenuContent : subMenuContents){
            addSubMenu(subMenuContent);
        }
    }

    private void addSubMenu(SubMenuContent subMenuContent) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID_SUB_MENU, subMenuContent.getIdSubMenu());
        values.put(KEY_TEXT_SUB_MENU, subMenuContent.getStr_());
        values.put(KEY_ID_TABLE_UTAMA, subMenuContent.getIdTableUtama());

        db.insert(NAMA_TABLE_SUBMENU, null, values);
    }

    public void addAllDataDetailContent(ArrayList<DetailContent>detailContents){
        for (DetailContent detailContent : detailContents){
            addDetailContent(detailContent);
        }
    }

    private void addDetailContent(DetailContent detailContent) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID_DETAIL_CONTENT, detailContent.getIdDetailContent());
        values.put(KEY_ID_SUB_MENU, detailContent.getIdSubMenuContent());
        values.put(KEY_TEXT_DETAIL_CONTENT, detailContent.getStrDetailConten());
        values.put(KEY_ARAB_DETAIL, detailContent.getArab_detail());
        values.put(KEY_LATIN_DETAIL, detailContent.getLatin_detail());
        values.put(KEY_ARTI_DETAIL, detailContent.getArti_detail());
        values.put(KEY_ISSET_ISI, detailContent.getIsSetIsi());

        db.insert(NAMA_TABLE_DETAIL_CONTENT, null, values);
    }

    public void addAllIsi(ArrayList<IsiDetailContent>isiDetailContents){
        for (IsiDetailContent isiDetailContent : isiDetailContents){
            addIsi(isiDetailContent);
        }
    }

    private void addIsi(IsiDetailContent isiDetailContent) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID_ISI_DETAIL, isiDetailContent.getIdIsiDetail());
        values.put(KEY_ID_DETAIL_CONTENT, isiDetailContent.getIdDetailContent());
        values.put(KEY_TEXT_ISI, isiDetailContent.getStr_());
        values.put(KEY_ARAB_ISI, isiDetailContent.getArab_isi());
        values.put(KEY_LATIN_ISI, isiDetailContent.getLatin_isi());
        values.put(KEY_ARTI_ISI, isiDetailContent.getArti_isi());

        db.insert(NAMA_TABLE_ISI_DETAIL_CONTENT, null, values);
    }

//    ===========================================================================

    //    mengambil data Header

    public List<ContentSubMenu> getGroup(int idTableUtama){
        List<ContentSubMenu> content = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT distinct(id_sub_menu), id_tb_utama, str_sub_menu FROM "+ NAMA_TABLE_SUBMENU + " WHERE " + KEY_ID_TABLE_UTAMA + " = " + idTableUtama + " ORDER BY " + KEY_ID_SUB_MENU + " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        Log.i("hahahahaa", "getGroup: "+query);
        while (!res.isAfterLast()){
            content.add(new ContentSubMenu(res.getInt(0), res.getString(2)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return content;
    }
//    ==================================================================================

    //    mengambil data detail content
    public List<ContentSubMenu> getChild(int idSubMenu){
        List<ContentSubMenu> content= new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT distinct(id_detail_content), str_detail_content FROM "+ NAMA_TABLE_DETAIL_CONTENT+ " WHERE " + KEY_ID_SUB_MENU+ " = " + idSubMenu+ " AND "+ KEY_ISSET_ISI + " = 1" +" ORDER BY " + KEY_ID_DETAIL_CONTENT+ " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            content.add(new ContentSubMenu(res.getInt(0), res.getString(1)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return content;
    }
//    =====================================================

    public ArrayList<ContentDetailAct> getContentDetail(int id, String namaTable){
        ArrayList<ContentDetailAct> content = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query;
        if (namaTable.equals(NAMA_TABLE_DETAIL_CONTENT)) {
            query = " SELECT distinct(" + KEY_TEXT_DETAIL_CONTENT + "), " + KEY_ARAB_DETAIL + ", "+ KEY_LATIN_DETAIL + ", "+KEY_ARTI_DETAIL
                    + " FROM "+ NAMA_TABLE_DETAIL_CONTENT+ " WHERE " + KEY_ID_SUB_MENU + " = " +id;
            Log.i("Halloooo", "getContentDetail: "+query);
        }else{
            query = " SELECT distinct(" + KEY_TEXT_ISI + "), " + KEY_ARAB_ISI + ", "+ KEY_LATIN_ISI + ", "+ KEY_ARTI_ISI
                    + " FROM "+ NAMA_TABLE_ISI_DETAIL_CONTENT + " WHERE " + KEY_ID_DETAIL_CONTENT + " = " +id;
            Log.i("Halloooo", "getContentDetail: "+query);
        }

        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            content.add(new ContentDetailAct(res.getString(0), res.getString(1), res.getString(2), res.getString(3)));
            res.moveToNext();
        }
        return content;
    }

    //    mengambil isi-isi dari detailContent
    public ArrayList<IsiDetailContent> getAllIsiDetail(){
        ArrayList<IsiDetailContent> contents = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM "+ NAMA_TABLE_ISI_DETAIL_CONTENT +" ORDER BY " + KEY_ID_ISI_DETAIL+ " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            contents.add(new IsiDetailContent(res.getInt(0),  res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return contents;
    }

    public ArrayList<SubMenuContent> getAllSubmenu(){
        ArrayList<SubMenuContent> contents = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM "+ NAMA_TABLE_SUBMENU +" ORDER BY " + KEY_ID_SUB_MENU+ " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            contents.add(new SubMenuContent(res.getInt(0), res.getInt(1), res.getString(2)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return contents;
    }

    public ArrayList<DetailContent> getAllDetailContent(){
        ArrayList<DetailContent> contents = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM "+ NAMA_TABLE_DETAIL_CONTENT +" ORDER BY " + KEY_ID_DETAIL_CONTENT+ " ASC";
        Cursor res = db.rawQuery(query , null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            contents.add(new DetailContent(res.getInt(0), res.getString(2), res.getInt(1), res.getString(3), res.getString(5), res.getString(4), res.getInt(6)));
            res.moveToNext();
        }

        res.close();
        db.close();

        return contents;
    }


//==========================================================

    //    Mengambil Text dari Detail Content
//    public ArrayList<String> getTextDetailContent(int idSubMenu){
//        ArrayList<String> content = new ArrayList<>();
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        String query = "SELECT * FROM " + NAMA_TABLE_DETAIL_CONTENT + " WHERE " + KEY_ID_SUB_MENU + " = " + idSubMenu;
//        Cursor res = db.rawQuery(query , null);
//        res.moveToFirst();
//
//        while (!res.isAfterLast()){
//            content.add(res.getString(2));
//            res.moveToNext();
//        }
//
//        res.close();
//        db.close();
//
//        return  content;
//    }
//    =====================================================

    //    Mengambil Text dari table Isi Detail Content
    public ArrayList<String> getTextIsiDetailContent(int idDetailContent){
        ArrayList<String> content = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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

}
