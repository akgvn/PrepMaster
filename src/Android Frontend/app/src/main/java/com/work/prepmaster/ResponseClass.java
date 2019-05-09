package com.work.prepmaster;

import android.os.Bundle;

public class ResponseClass {

    private String msg1;

    private String msg2;
    private String sentence;
    public ResponseClass(String msg1, String msg2,String sentence) {
        this.msg1 = msg1;
        this.msg2 = msg2;
        this.sentence = sentence;
    }
    public Bundle getReq() {
        Bundle bundle = new Bundle();
        bundle.putString("msg1", msg1);
        bundle.putString("msg2", msg2);
        bundle.putString("sentence", sentence);
        return bundle;
    }
}
