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

    String [] str;

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
        if(bundle.isEmpty()){
            str = bundle.getStringArray("practice");
            question.setText(str[0]);
            ans1.setText(str[1]);
            ans2.setText(str[2]);
            ans3.setText(str[3]);
            ans4.setText(str[4]);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == back)
            onBackPressed();
        else if(view == ans1){
            if(ans1.getText() == str[1])
                Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
        }
        else if(view == ans2){
            if(ans2.getText() == str[1])
                Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
        }
        else if(view == ans3){
            if(ans3.getText() == str[1])
                Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
        }
        else if(view == ans4){
            if(ans4.getText() == str[1])
                Toast.makeText(this, "! Correct !", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "! Wrong !", Toast.LENGTH_SHORT).show();
        }
    }
}
