package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back, options, statistic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        back = findViewById(R.id.buttonProfileBack);
        back.setOnClickListener(this);
        //options = findViewById(R.id.buttonProfileOptions);
        //options.setOnClickListener(this);
        //statistic = findViewById(R.id.buttonStatistic);
        //statistic.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intentOptions = new Intent(this,ProfileOptionsActivity.class);
        Intent intentStatistic = new Intent(this,StatisticActivity.class);
        if(view == back)
            onBackPressed();
        //if(view == options)
           // startActivity(intentOptions);
      //  if(view == statistic)
         //   startActivity(intentStatistic);
        //commit için ölesine ekledni
    }
}
