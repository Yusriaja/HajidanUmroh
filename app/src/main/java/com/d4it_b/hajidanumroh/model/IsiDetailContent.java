package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 06/03/2018.
 */

public class IsiDetailContent {
    private int idIsiDetail;
    private int idDetailContent;
    private String str_;
    private String arab_isi;
    private String arti_isi;
    private String latin_isi;

    public IsiDetailContent(int idIsiDetail, int idDetailContent, String str_, String arab_isi, String arti_isi, String latin_isi) {
        this.idIsiDetail = idIsiDetail;
        this.idDetailContent = idDetailContent;
        this.str_ = str_;
        this.arab_isi = arab_isi;
        this.arti_isi = arti_isi;
        this.latin_isi = latin_isi;
    }

    public int getIdIsiDetail() {
        return idIsiDetail;
    }

    public void setIdIsiDetail(int idIsiDetail) {
        this.idIsiDetail = idIsiDetail;
    }

    public int getIdDetailContent() {
        return idDetailContent;
    }

    public void setIdDetailContent(int idDetailContent) {
        this.idDetailContent = idDetailContent;
    }

    public String getStr_() {
        return str_;
    }

    public void setStr_(String str_) {
        this.str_ = str_;
    }

    public String getArab_isi() {
        return arab_isi;
    }

    public void setArab_isi(String arab_isi) {
        this.arab_isi = arab_isi;
    }

    public String getArti_isi() {
        return arti_isi;
    }

    public void setArti_isi(String arti_isi) {
        this.arti_isi = arti_isi;
    }

    public String getLatin_isi() {
        return latin_isi;
    }

    public void setLatin_isi(String latin_isi) {
        this.latin_isi = latin_isi;
    }
}
