package com.work.prepmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileOptionsActivity extends AppCompatActivity implements View.OnClickListener {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_options);
        back = findViewById(R.id.buttonProfileOptionsBack);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == back)
            onBackPressed();
    }
}
