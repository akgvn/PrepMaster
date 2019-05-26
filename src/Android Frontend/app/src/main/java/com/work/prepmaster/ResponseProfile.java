package com.work.prepmaster;

import android.os.Bundle;

public class ResponseProfile {

    private String user_score;
    private String user_true_ans;
    private String user_false_ans;
    public ResponseProfile(String user_score, String user_true_ans, String user_false_ans) {
        this.user_false_ans = user_false_ans;
        this.user_score = user_score;
        this.user_true_ans = user_true_ans;
    }
    public Bundle getReq() {
        Bundle bundle = new Bundle();
        bundle.putString("userScore", user_score);
        bundle.putString("userTrue", user_true_ans);
        bundle.putString("userFalse", user_false_ans);
        return bundle;
    }
}
