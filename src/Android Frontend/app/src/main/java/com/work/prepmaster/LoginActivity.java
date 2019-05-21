package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {
    private Button register;
    private Button logIn;
    private EditText userName;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register);
        register.setOnClickListener(this);

        logIn = findViewById(R.id.logIn);
        logIn.setOnClickListener(this);

        userName = findViewById(R.id.user_name);

        password = findViewById(R.id.password);
    }

    @Override
    public void onClick(View v) {
        Intent intentRegister = new Intent(this, Register1Activity.class);
        if(v == register)
            startActivity(intentRegister);
        if(v == logIn)
            post();
    }
    private void post() {
        AndroidNetworking.post("http://bilimtadinda.com/cankahard/giris_yap.php")
                .addBodyParameter("user_nick_name" , userName.getText().toString())
                .addBodyParameter("user_password" , password.getText().toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String  response) {
                        Log.i("LoginActivity",response);
                        request(response);
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("LoginActivity",error.getMessage());
                    }
                });
    }
    private void request(String response) {
        Gson gson = new Gson();
        ResponsePost responsePost = gson.fromJson(response,ResponsePost.class);
        Intent intentStart = new Intent(this, MainActivity.class);
        if(responsePost.getPost() == 1) {
            intentStart.putExtra("userName", userName.getText().toString());
            startActivity(intentStart);
            Toast.makeText(this, "! Welcome !", Toast.LENGTH_SHORT).show();
        }
        else if(responsePost.getPost() == 2)
            Toast.makeText(this, " Invalid logIn ", Toast.LENGTH_SHORT).show();
        else if(responsePost.getPost() == 3)
            Toast.makeText(this, " Long input ", Toast.LENGTH_SHORT).show();
        else if(responsePost.getPost() == 4)
            Toast.makeText(this, " Empty argument ", Toast.LENGTH_SHORT).show();
        else if(responsePost.getPost() == 5)
            Toast.makeText(this, " Invalid variable ", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this, "\"Failed\"", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
