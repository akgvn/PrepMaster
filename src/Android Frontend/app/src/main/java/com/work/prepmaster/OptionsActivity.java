package com.work.prepmaster;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
import android.widget.Button;
import android.widget.ImageView;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView task;
    private ImageView dict;
    private ImageView home;
    private ImageView highScore;
    private ImageView profile;
    private Button buttunQuit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        buttunQuit = findViewById(R.id.buttonQuit);
        buttunQuit.setOnClickListener(this);

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
        if(view == task){
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
        else if(view == buttunQuit){
            SharedPreferences sharedPref = this.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("userName", "");
            editor.commit();
            System.exit(0);
        }
    }
}