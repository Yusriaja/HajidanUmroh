package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 23/02/2018.
 */

public class SubMenuContent {
   private int idSubMenu;
   private int idTableUtama;
   private String str_;

    public SubMenuContent(int idSubMenu, int idTableUtama, String str_) {
        this.idSubMenu = idSubMenu;
        this.idTableUtama = idTableUtama;
        this.str_ = str_;
    }

    public int getIdSubMenu() {
        return idSubMenu;
    }

    public void setIdSubMenu(int idSubMenu) {
        this.idSubMenu = idSubMenu;
    }

    public int getIdTableUtama() {
        return idTableUtama;
    }

    public void setIdTableUtama(int idTableUtama) {
        this.idTableUtama = idTableUtama;
    }

    public String getStr_() {
        return str_;
    }

    public void setStr_(String str_) {
        this.str_ = str_;
    }
}
