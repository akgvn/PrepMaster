package com.work.prepmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatisticActivity extends AppCompatActivity implements View.OnClickListener {
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        back = findViewById(R.id.buttonStatisticBack);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == back)
            onBackPressed();
    }
}
