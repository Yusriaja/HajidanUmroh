package com.d4it_b.hajidanumroh;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.d4it_b.hajidanumroh.model.DetailContent;
import com.d4it_b.hajidanumroh.model.SubMenuContent;

import java.util.ArrayList;

/**
 * Created by M N D on 23/02/2018.
 */

public class DBHandler extends SQLiteOpenHelper {

//    Nama-nama table primary
    private static final String NAMA_TABEL_HAJI="tb_haji";
    private static final String NAMA_TABEL_UMROH="tb_umroh";
    private static final String NAMA_TABEL_SHOLAT="tb_sholat";
    private static final String NAMA_TABEL_DAM="tb_dam";
    private static final String NAMA_TABEL_DOA="tb_doa";

//    Nama-nama table subquery
    private static final String NAMA_TABEL_DETAIL_HAJI="tb_detail_haji";
    private static final String NAMA_TABEL_DETAIL_UMROH="tb_detail_umroh";
    private static final String NAMA_TABEL_DETAIL_SHOLAT="tb_detail_sholat";
    private static final String NAMA_TABEL_DETAIL_DAM="tb_detail_dam";
    private static final String NAMA_TABEL_DETAIL_DOA="tb_detail_doa";

//    field table haji
    private static final String KEY_ID_HAJI ="id_haji";
    private static final String KEY_ID_UMROH ="id_umroh";
    private static final String KEY_STRING_HAJI ="string_haji";

//    field table detail haji
    private static final String KEY_ID_DETAIL_HAJI ="id_detail_haji";
    private static final String KEY_STRING_DETAIL_HAJI ="string_detail_haji";
    public DBHandler(Context context) {
        super(context, "db_haji_umroh", null, 9);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NAMA_TABEL_HAJI + " ( "
                + KEY_ID_HAJI + " INTEGER PRIMARY KEY, "
                + KEY_STRING_HAJI + " TEXT " +" ) " );

        db.execSQL("CREATE TABLE " + NAMA_TABEL_DETAIL_HAJI + " ( "
                + KEY_ID_DETAIL_HAJI + " INTEGER PRIMARY KEY, "
                + KEY_ID_HAJI + " INTEGER, "
                + KEY_STRING_DETAIL_HAJI + " TEXT "+" ) ");
    }

    public void addAllDetail(ArrayList<DetailContent> detailContents, String tabelName){
        for (DetailContent detailContent : detailContents){
            if(tabelName.equals("tb_haji"))
                addDetaiHaji(detailContent);
            else if(tabelName.equals("tb_umroh")){}
                //save to umroh
            else if(tabelName.equals("tb_sholat")){}
            //save to sholat
            else if(tabelName.equals("tb_dam")){}
            //save to dam
            else if(tabelName.equals("tb_doa")){}
            //save to doa
        }
    }

    private void addDetaiHaji(DetailContent detailContent) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID_DETAIL_HAJI, detailContent.getId_detail_haji());
        values.put(KEY_ID_HAJI, detailContent.getId_haji());
        values.put(KEY_STRING_DETAIL_HAJI, detailContent.getString_detail_haji());

        db.insert(NAMA_TABEL_DETAIL_HAJI,null,values);
    }

    public void addAllHaji(ArrayList<SubMenuContent> contents){
        for (SubMenuContent content : contents){
            addHaji(content);
        }
    }

    private void addHaji(SubMenuContent haji) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID_HAJI, haji.getId());
        values.put(KEY_STRING_HAJI, haji.getStrContent());

        Log.i("Masuk", "addHaji: "+ db.insert(NAMA_TABEL_HAJI,null,values));;
    }

    public boolean isHajiEmpty(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + NAMA_TABEL_HAJI;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        cursor.close();

        return count==0;
    }

    public DetailContent getDetailHaji(int idDetailHaji){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from " + NAMA_TABEL_DETAIL_HAJI+ " WHERE " + KEY_ID_DETAIL_HAJI + " = " + idDetailHaji, null);

        DetailContent detailHaji=new DetailContent(res.getInt(0), res.getString(1), res.getInt(2));
        return detailHaji;
    }
    public ArrayList<SubMenuContent> getAll(String tableName){
        ArrayList<SubMenuContent> contents = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from " + tableName+ " ORDER BY " + KEY_ID_HAJI + " ASC ";
        Cursor res = db.rawQuery(query, null);
        res.moveToFirst();

        while (!res.isAfterLast()){
            contents.add(new SubMenuContent(res.getInt(0), res.getString(1)));
            res.moveToNext();
        }
        res.close();
        db.close();
        return contents;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABEL_HAJI);
        db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABEL_DETAIL_HAJI);

    }
}
