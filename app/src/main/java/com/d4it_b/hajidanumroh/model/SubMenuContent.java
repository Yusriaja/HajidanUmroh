package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 23/02/2018.
 */

public class SubMenuContent {
    private int id;
    private String strContent;

    public SubMenuContent(int id, String strContent) {
        this.id = id;
        this.strContent = strContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrContent() {
        return strContent;
    }

    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }
}
