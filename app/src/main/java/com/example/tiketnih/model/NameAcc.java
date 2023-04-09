package com.example.tiketnih.model;

import com.google.gson.annotations.SerializedName;

public class NameAcc {
    @SerializedName("name")
    private String namaAcc;

    public NameAcc(String namaAcc) {
        this.namaAcc = namaAcc;
    }

    public String getNamaAcc() {
        return namaAcc;
    }

    public void setNamaAcc(String namaAcc) {
        this.namaAcc = namaAcc;
    }


}
