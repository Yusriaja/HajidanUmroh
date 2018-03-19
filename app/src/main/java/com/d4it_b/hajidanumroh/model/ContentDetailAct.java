package com.d4it_b.hajidanumroh.model;

/**
 * Created by M N D on 17/03/2018.
 */

public class ContentDetailAct {
    private String text;
    private String Arab;
    private String Latin;
    private String Arti;

    public ContentDetailAct(String text, String arab, String latin, String arti) {
        this.text = text;
        Arab = arab;
        Latin = latin;
        Arti = arti;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getArab() {
        return Arab;
    }

    public void setArab(String arab) {
        Arab = arab;
    }

    public String getLatin() {
        return Latin;
    }

    public void setLatin(String latin) {
        Latin = latin;
    }

    public String getArti() {
        return Arti;
    }

    public void setArti(String arti) {
        Arti = arti;
    }
}
