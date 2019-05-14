package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class Register1Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView userName;
    private TextView eMail;
    private TextView password;
    private TextView rePassword;
    private Button register;
    private Button logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        userName = findViewById(R.id.txtUserName);
        eMail = findViewById(R.id.txtEMail);
        password = findViewById(R.id.txtPassword);
        rePassword = findViewById(R.id.txtRePassword);
        register = findViewById(R.id.btnBeRegister);
        logIn = findViewById(R.id.btnLogIn);
        logIn.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intentLogIn = new Intent(this, MainActivity.class);
        String pass = password.getText().toString();
        String rePass = rePassword.getText().toString();
        if(v == register){
            if(pass.equals(rePass)){
                post();
            }
            else
                Toast.makeText(this, "Passwords are different", Toast.LENGTH_SHORT).show();
        }
        if(v == logIn){
            startActivity(intentLogIn);
        }
    }
    private void post() {
        AndroidNetworking.post("http://bilimtadinda.com/cankahard/uye_ol.php")
                .addBodyParameter("user_nick_name" , userName.getText().toString())
                .addBodyParameter("user_email" , eMail.getText().toString())
                .addBodyParameter("user_password" , password.getText().toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsString(new StringRequestListener() {
                    @Override
                    public void onResponse(String  response) {
                        Log.i("Register1Activity",response);
                        request(response);
                    }
                    @Override
                    public void onError(ANError error) {
                        Log.e("Register1Activity",error.getMessage());
                    }
                });
    }
    private void request(String response) {
        Gson gson = new Gson();
        ResponsePost responsePost = gson.fromJson(response,ResponsePost.class);
        Intent intentLogIn = new Intent(this, LoginActivity.class);
        if(responsePost.getPost() == 6) {
            startActivity(intentLogIn);
            Toast.makeText(this, "! Success !", Toast.LENGTH_SHORT).show();
        }
        else if(responsePost.getPost() == 5)
            Toast.makeText(this, "eMail already exists", Toast.LENGTH_SHORT).show();
        else if(responsePost.getPost() == 4)
            Toast.makeText(this, "user name already exists", Toast.LENGTH_SHORT).show();
        else if(responsePost.getPost() == 3)
            Toast.makeText(this, "Character overflow", Toast.LENGTH_SHORT).show();
        else if(responsePost.getPost() == 2)
            Toast.makeText(this, "Texts can't be empty.", Toast.LENGTH_SHORT).show();
        else if(responsePost.getPost() == 1)
            Toast.makeText(this, "System error", Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this, "\"Failed\"", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
