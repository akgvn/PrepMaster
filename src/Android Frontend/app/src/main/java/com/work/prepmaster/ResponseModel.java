package com.work.prepmaster;

import android.os.Bundle;

import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    private int sonuc;
    @SerializedName("msg1")
    private String msg1;

    private String msg2;

    @SerializedName("msg3")
    private String msg3;

    public ResponseModel(int sonuc, String msg1, String msg2, String msg3) {
        this.sonuc = sonuc;
        this.msg1 = msg1;
        this.msg2 = msg2;
        this.msg3 = msg3;
    }

    public int getSonuc() {
        return sonuc;
    }

    public Bundle getMesaj() {
        Bundle bundle = new Bundle();
        bundle.putString("msg1",msg1);
        bundle.putString("msg2",msg2);
        bundle.putString("msg3",msg3);
        return bundle;
    }
}
