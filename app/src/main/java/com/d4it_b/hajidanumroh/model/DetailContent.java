package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 23/02/2018.
 */

public class DetailContent {
    private int idDetailContent;
    private String strDetailConten;
    private int idSubMenuContent;

    public DetailContent(int idDetailContent, String strDetailConten, int idSubMenuContent) {
        this.idDetailContent = idDetailContent;
        this.strDetailConten = strDetailConten;
        this.idSubMenuContent = idSubMenuContent;
    }

    public int getIdDetailContent() {
        return idDetailContent;
    }

    public void setIdDetailContent(int idDetailContent) {
        this.idDetailContent = idDetailContent;
    }

    public String getStrDetailConten() {
        return strDetailConten;
    }

    public void setStrDetailConten(String strDetailConten) {
        this.strDetailConten = strDetailConten;
    }

    public int getIdSubMenuContent() {
        return idSubMenuContent;
    }

    public void setIdSubMenuContent(int idSubMenuContent) {
        this.idSubMenuContent = idSubMenuContent;
    }
    //    private int id_detail_haji;
//    private String string_detail_haji;
//    private int id_haji;
//
//    public DetailContent(int id_detail_haji, String string_detail_haji, int id_haji) {
//        this.id_detail_haji = id_detail_haji;
//        this.string_detail_haji = string_detail_haji;
//        this.id_haji = id_haji;
//    }
//
//    public int getId_detail_haji() {
//        return id_detail_haji;
//    }
//
//    public void setId_detail_haji(int id_detail_haji) {
//        this.id_detail_haji = id_detail_haji;
//    }
//
//    public String getString_detail_haji() {
//        return string_detail_haji;
//    }
//
//    public void setString_detail_haji(String string_detail_haji) {
//        this.string_detail_haji = string_detail_haji;
//    }
//
//    public int getId_haji() {
//        return id_haji;
//    }
//
//    public void setId_haji(int id_haji) {
//        this.id_haji = id_haji;
//    }
}
