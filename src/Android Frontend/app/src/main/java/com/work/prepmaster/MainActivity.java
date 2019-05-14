package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView options , play;

    private ImageView task;
    private ImageView dict;
    private ImageView home;
    private ImageView highScore;
    private ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play       = findViewById(R.id.buttonPlay);
        options    = findViewById(R.id.buttonOptions);


        play.setOnClickListener(this);
        options.setOnClickListener(this);

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
    }
    @Override
    public void onClick(View view) {
        if (view == play){
            userControl();
        }
        if (view == options){
            Intent intentOptions = new Intent(this, OptionsActivity.class);
            startActivity(intentOptions);
        }
        if(view == task){
            Intent intentOptions = new Intent( this , OptionsActivity.class );
            startActivity(intentOptions);
        }
        if(view == dict){
            Intent intentDictionary = new Intent( this , Dictionary.class );
            startActivity(intentDictionary);
        }
        if(view == home){
            Intent intentHome = new Intent( this , MainActivity.class );
            startActivity(intentHome);
        }
        if(view == highScore){
            Intent intentStatistic = new Intent( this , StatisticActivity.class );
            startActivity(intentStatistic);
        }
        if(view == profile){
            Intent intentProfile = new Intent( this , ProfileActivity.class );
            startActivity(intentProfile);
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
                            Log.i("MainActivity",response);
                            request(response);
                        }
                        @Override
                        public void onError(ANError error) {
                            Log.e("MainActivity",error.getMessage());
                        }
                    });
    }
    private void request(String response) {
        Gson gson = new Gson();
        ResponseClass responseClass = gson.fromJson(response,ResponseClass.class);
        Bundle bundle;
        if(responseClass.getReq() != null) {
            bundle = responseClass.getReq();
            bundle.putString("questCounter", "5");
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