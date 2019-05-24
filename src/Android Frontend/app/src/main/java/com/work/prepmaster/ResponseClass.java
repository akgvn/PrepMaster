package com.work.prepmaster;

import android.os.Bundle;

public class ResponseClass {

    private String msg1;
    private String msg2;
    private String msg3;
    private String msg4;
    private String msg5;
    private String sentence;
    private String id;
    public ResponseClass(String msg1, String msg2, String msg3, String msg4, String msg5, String sentence, String id) {
        this.msg1 = msg1;
        this.msg2 = msg2;
        this.msg3 = msg3;
        this.msg4 = msg4;
        this.msg5 = msg5;
        this.sentence = sentence;
        this.id = id;
    }
    public Bundle getReq() {
        Bundle bundle = new Bundle();
        bundle.putString("msg1", msg1);
        bundle.putString("msg2", msg2);
        bundle.putString("msg3", msg3);
        bundle.putString("msg4", msg4);
        bundle.putString("msg5", msg5);
        bundle.putString("sentence", sentence);
        bundle.putString("id", id);
        return bundle;
    }
}
