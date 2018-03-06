package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 06/03/2018.
 */

public class IsiDetailContent {
    private int idIsiDetail;
    private int idDetailContent;
    private String str_;

    public IsiDetailContent(int idIsiDetail, int idDetailContent, String str_) {
        this.idIsiDetail = idIsiDetail;
        this.idDetailContent = idDetailContent;
        this.str_ = str_;
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
}
