package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register;
    private Button logIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);/*set*/
        register = findViewById(R.id.register);
        register.setOnClickListener(this);
        logIn = findViewById(R.id.logIn);
        logIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intentRegister = new Intent(this, Register1Activity.class);
        Intent intentMain = new Intent(this, MainActivity.class);
        if(v == register)
            startActivity(intentRegister);
        if(v == logIn)
            startActivity(intentMain);
    }
}
