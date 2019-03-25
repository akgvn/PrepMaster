package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button play, options, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.buttonPlay);
        options = findViewById(R.id.buttonOptions);
        profile = findViewById(R.id.buttonProfile);
        play.setOnClickListener(this);
        options.setOnClickListener(this);
        profile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intentPlay = new Intent(this, PracticeActivity.class);
        Intent intentOptions = new Intent(this, OptionsActivity.class);
        Intent intentProfile = new Intent(this, ProfileActivity.class);
        if (view == play)
            startActivity(intentPlay);
        if (view == options)
            startActivity(intentOptions);
        if (view == profile)
            startActivity(intentProfile);
    }
}