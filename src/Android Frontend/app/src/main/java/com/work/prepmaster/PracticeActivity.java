package com.work.prepmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back;
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
        else
            Toast.makeText(this, "Amk", Toast.LENGTH_SHORT).show();
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
    }
}
