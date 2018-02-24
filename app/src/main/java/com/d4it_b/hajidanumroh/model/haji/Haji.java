package com.d4it_b.hajidanumroh.model.haji;

/**
 * Created by M N D on 23/02/2018.
 */

public class Haji {
    private int id_haji;
    private String string_haji;

    public Haji(int id_haji, String string_haji) {
        this.id_haji = id_haji;
        this.string_haji = string_haji;
    }

    public int getId_haji() {
        return id_haji;
    }

    public void setId_haji(int id_haji) {
        this.id_haji = id_haji;
    }

    public String getString_haji() {
        return string_haji;
    }

    public void setString_haji(String string_haji) {
        this.string_haji = string_haji;
    }
}
