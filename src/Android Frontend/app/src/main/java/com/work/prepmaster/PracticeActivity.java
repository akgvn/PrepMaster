package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class PracticeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back;
    private Button next;
    private Button ans1;
    private Button ans2;
    private Button ans3;
    private Button ans4;
    private TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        back = findViewById(R.id.buttonPracticeBack);
        back.setOnClickListener(this);

        next = findViewById(R.id.buttonNext);
        next.setOnClickListener(this);

        ans1 = findViewById(R.id.answer1);
        ans1.setOnClickListener(this);

        ans2 = findViewById(R.id.answer2);
        ans2.setOnClickListener(this);

        ans3 = findViewById(R.id.answer3);
        ans3.setOnClickListener(this);

        ans4 = findViewById(R.id.answer4);
        ans4.setOnClickListener(this);

        question = findViewById(R.id.Question);

        init();
    }

    private void init() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            question.setText(bundle.getString("sentence"));
            ans1.setText(bundle.getString("msg1"));
            ans2.setText(bundle.getString("msg3"));
            ans3.setText(bundle.getString("msg4"));
            ans4.setText(bundle.getString("msg5"));
        }
    }

    @Override
    public void onClick(View view) {
        if(view == back)
            onBackPressed();
        else if(view == ans1)
            Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
        else if(view == ans2)
            Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
        else if(view == ans3)
            Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
        else if(view == ans4)
            Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
        else if(view == next){
            userControl();
        }
    }
    private void userControl() {
        AndroidNetworking.post("http://bilimtadinda.com/cankahard/servis.php")
                .addBodyParameter("selection" , "1")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String  response) {
                        Log.i("PracticeActivity",response);
                        request(response);
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("PracticeActivity",error.getMessage());
                    }
                });
    }
    private void request(String response) {
        Gson gson = new Gson();
        ResponseClass responseClass = gson.fromJson(response,ResponseClass.class);
        Bundle bundle;
        if(responseClass.getReq() != null) {
            bundle = responseClass.getReq();
            Intent intentPlay = new Intent(this, PracticeActivity.class);
            if(bundle != null) {
                intentPlay.putExtras(bundle);
                startActivity(intentPlay);
            }
        }
        else{
            Toast.makeText(this, "\"Failed\"", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
