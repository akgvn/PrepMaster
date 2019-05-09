package com.work.prepmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login_page;
    private ImageView profile , options , play ,dictionary;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        play       = findViewById(R.id.buttonPlay);
        options    = findViewById(R.id.buttonOptions);
        profile    = findViewById(R.id.buttonProfile);
        login_page = findViewById( R.id.login_page );
        dictionary = findViewById( R.id.imgviewSozluk );

        play.setOnClickListener(this);
        options.setOnClickListener(this);
        profile.setOnClickListener(this);
        login_page.setOnClickListener(this);
        dictionary.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == play){
            Intent intentPlay = new Intent(this, PracticeActivity.class);
            userControl();
            intentPlay.putExtras(bundle);
            startActivity(intentPlay);
        }
        if (view == options){
            Intent intentOptions = new Intent(this, OptionsActivity.class);
            startActivity(intentOptions);
        }
        if (view == profile){
            Intent intentProfile = new Intent(this, ProfileActivity.class);
            startActivity(intentProfile);
        }
        if( view == login_page ){
            Intent intentLogin = new Intent(this, LoginActivity.class);
            startActivity(intentLogin);
        }
        if( view == dictionary ){
            Intent intentDictionary = new Intent( this , Dictionary.class );
            startActivity(intentDictionary);
        }

    }
    private void userControl() {
            AndroidNetworking.post("http://bilimtadinda.com/cankahard/servis.php")
                    .addBodyParameter("selection" , "1")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String  response) {
                            Log.i("MainActivity",response);
                            request(response);
                        }
                        @Override
                        public void onError(ANError error) {
                            Log.e("MainActivity",error.getMessage());
                        }
                    });
    }
    private void request(String response) {
        Gson gson = new Gson();
        ResponseClass responseClass = gson.fromJson(response,ResponseClass.class);
        if(responseClass.getReq() != null) {
            bundle = responseClass.getReq();
            Toast.makeText(this, "1" , Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "\"Failed\"", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}