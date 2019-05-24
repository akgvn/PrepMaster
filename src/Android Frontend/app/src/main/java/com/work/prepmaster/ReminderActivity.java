package com.work.prepmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

import java.util.Random;

import static android.os.SystemClock.sleep;

public class ReminderActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back;
    private Button next;
    private Button ans1;
    private Button ans2;
    private Button ans3;
    private Button ans4;
    private TextView question;

    private ImageView task;
    private ImageView dict;
    private ImageView home;
    private ImageView highScore;
    private ImageView profile;

    private String userName;
    private String str;
    private String wId;
    private String grade = "1";
    private boolean hold = true;

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

        task = findViewById(R.id.imgviewTask);
        task.setOnClickListener(this);

        dict = findViewById(R.id.imgviewSozluk);
        dict.setOnClickListener(this);

        home = findViewById(R.id.imgviewHome);
        home.setOnClickListener(this);

        highScore = findViewById(R.id.imgviewHighScore);
        highScore.setOnClickListener(this);

        profile = findViewById(R.id.imgviewProfile);
        profile.setOnClickListener(this);

        init();
    }

    private void init(){
        SharedPreferences sharedPref = this.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        userName = sharedPref.getString("userName", "");
        getQuest();
    }

    @Override
    public void onClick(View view) {
        if(view == back)
            onBackPressed();
        else if(view == next){
            logAnswer();
            hold = true;
            sleep(5000);
            getQuest();
            grade = "1";
        }
        else if(view == task){
            Intent intentOptions = new Intent( this , OptionsActivity.class );
            startActivity(intentOptions);
        }
        else if(view == dict){
            Intent intentDictionary = new Intent( this , Dictionary.class );
            startActivity(intentDictionary);
        }
        else if(view == home){
            Intent intentHome = new Intent( this , MainActivity.class );
            startActivity(intentHome);
        }
        else if(view == highScore){
            Intent intentStatistic = new Intent( this , StatisticActivity.class );
            startActivity(intentStatistic);
        }
        else if(view == profile){
            Intent intentProfile = new Intent( this , ProfileActivity.class );
            startActivity(intentProfile);
        }
        else if(hold){
            hold = false;
            if(view == ans1){
                if(ans1.getText().toString().equals(str)){
                    Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
                    grade = "5";
                }
                else
                    Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
            }
            else if(view == ans2){
                if(ans2.getText().toString().equals(str)){
                    Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
                    grade = "5";
                }
                else
                    Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
            }
            else if(view == ans3){
                if(ans3.getText().toString().equals(str)){
                    Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
                    grade = "5";
                }
                else
                    Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
            }
            else if(view == ans4){
                if(ans4.getText().toString().equals(str)){
                    Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
                    grade = "5";
                }
                else
                    Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "You already choose", Toast.LENGTH_SHORT).show();
        }
    }
    private void getQuest() {
        AndroidNetworking.post("http://bilimtadinda.com/cankahard/remind.php")
                .addBodyParameter("user_nick_name" , userName)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String  response) {
                        Log.i("ReminderActivity",response);
                        request(response);
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ReminderActivity",error.getMessage());
                    }
                });
    }
    private void request(String response) {
        Gson gson = new Gson();
        ResponseClass responseClass = gson.fromJson(response,ResponseClass.class);
        Bundle bundle;
        if(responseClass.getReq() != null) {
            bundle = responseClass.getReq();
            if(bundle.getString("sentence").equals("")){
                Toast.makeText(this, "All Finished", Toast.LENGTH_SHORT).show();
                finish();
            }
            else {
                wId = bundle.getString("id");
                changeButton(bundle);
                question.setText(bundle.getString("sentence"));
                ans1.setText(bundle.getString("msg1"));
                ans2.setText(bundle.getString("msg3"));
                ans3.setText(bundle.getString("msg4"));
                ans4.setText(bundle.getString("msg5"));
            }
        }

        else{
            Toast.makeText(this, "\"Failed\"", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void logAnswer() {
        AndroidNetworking.post("http://bilimtadinda.com/cankahard/answered.php")
                .addBodyParameter("user_nick_name" , userName)
                .addBodyParameter("word_id" , wId)
                .addBodyParameter("grade" , grade)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String  response) {
                        Log.i("ReminderActivity",response);
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("ReminderActivity",error.getMessage());
                    }
                });
    }

    private void changeButton(Bundle bundle){
        Random rand = new Random();
        int rnd = rand.nextInt(4) + 1;
        str = bundle.getString("msg1");
        if(rnd == 2){
            bundle.putString("msg1", bundle.getString("msg3"));
            bundle.putString("msg3", str);
        }
        else if(rnd == 3){
            bundle.putString("msg1", bundle.getString("msg4"));
            bundle.putString("msg4", str);
        }
        else if(rnd == 4){
            bundle.putString("msg1", bundle.getString("msg5"));
            bundle.putString("msg5", str);
        }
    }
}
