package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login_page;
    private ImageView profile , options , play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        play       = findViewById(R.id.buttonPlay);
        options    = findViewById(R.id.buttonOptions);
        profile    = findViewById(R.id.buttonProfile);
        login_page = findViewById( R.id.login_page );

        play.setOnClickListener(this);
        options.setOnClickListener(this);
        profile.setOnClickListener(this);
        login_page.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intentPlay = new Intent(this, PracticeActivity.class);
        Intent intentOptions = new Intent(this, OptionsActivity.class);
        Intent intentProfile = new Intent(this, ProfileActivity.class);
        Intent intentLogin = new Intent(this, LoginActivity.class);
        if (view == play)
            startActivity(intentPlay);
        if (view == options)
            startActivity(intentOptions);
        if (view == profile)
            startActivity(intentProfile);
        if( view == login_page )
            startActivity(intentLogin);

    }
}