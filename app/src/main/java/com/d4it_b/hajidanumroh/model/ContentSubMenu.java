package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 17/03/2018.
 */

public class ContentSubMenu {
    private int id;
    private String str_;

    public ContentSubMenu(int id, String str_) {
        this.id = id;
        this.str_ = str_;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStr_() {
        return str_;
    }

    public void setStr_(String str_) {
        this.str_ = str_;
    }
}
