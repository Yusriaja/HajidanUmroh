package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 23/02/2018.
 */

public class DetailContent {
    private int idDetailContent;
    private String strDetailConten;
    private int idSubMenuContent;
    private String arab_detail;
    private String arti_detail;
    private String latin_detail;
    private int isSetIsi; // 0 jika tidak ada dan 1 jika ada

    public DetailContent(int idDetailContent, String strDetailConten, int idSubMenuContent, String arab_detail, String arti_detail, String latin_detail, int isSetIsi) {
        this.idDetailContent = idDetailContent;
        this.strDetailConten = strDetailConten;
        this.idSubMenuContent = idSubMenuContent;
        this.arab_detail = arab_detail;
        this.arti_detail = arti_detail;
        this.latin_detail = latin_detail;
        this.isSetIsi = isSetIsi;
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

    public int getIsSetIsi() {
        return isSetIsi;
    }

    public void setIsSetIsi(int isSetIsi) {
        this.isSetIsi = isSetIsi;
    }

    public String getArab_detail() {
        return arab_detail;
    }

    public void setArab_detail(String arab_detail) {
        this.arab_detail = arab_detail;
    }

    public String getArti_detail() {
        return arti_detail;
    }

    public void setArti_detail(String arti_detail) {
        this.arti_detail = arti_detail;
    }

    public String getLatin_detail() {
        return latin_detail;
    }

    public void setLatin_detail(String latin_detail) {
        this.latin_detail = latin_detail;
    }
}
