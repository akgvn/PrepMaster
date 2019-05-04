package com.work.prepmaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;
import android.util.Log;
import android.widget.ArrayAdapter;

public class Dictionary extends AppCompatActivity implements View.OnClickListener {
    private EditText userNameEt;
    private Button loginBtn;
    private String[] str = new String[3];
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        init();
    }
    private void init() {
        userNameEt = findViewById(R.id.kullanici_adi_et_id);
        list = findViewById(R.id.listView1);
        loginBtn = findViewById(R.id.login_btn_id);
        loginBtn.setOnClickListener(this);
        str[0] = "";
        str[1] = "";
        str[2] = "";
    }
    @Override
    public void onClick(View v) {
        if(v == loginBtn){
            String userName = userNameEt.getText().toString().trim();
            userControl(userName);
        }
    }
    private void userControl(final String word) {
        if(word.isEmpty()){
            Toast.makeText(this, "Please fill it!", Toast.LENGTH_SHORT).show();
        }
        else{
            AndroidNetworking.post("http://bilimtadinda.com/cankasoft/aranacak_kelime/servis.php")
                    .addBodyParameter("word", word)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String  response) {
                            Log.i("Dictionary",response);
                            cevapaBak(response);
                        }
                        @Override
                        public void onError(ANError error) {
                            Log.e("Dictionary",error.getMessage());
                        }
                    });
        }
    }
    private void cevapaBak(String response) {
        Gson gson = new Gson();
        ResponseModel responseModel = gson.fromJson(response,ResponseModel.class);
        if(responseModel.getSonuc() == 1){
            Bundle bundle;
            bundle = responseModel.getMesaj();
            if(bundle != null){
                str[0] = bundle.getString("msg1");
                str[1] = bundle.getString("msg2");
                str[2] = bundle.getString("msg3");
            }
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, str);
            list.setAdapter(arrayAdapter);
        }
        else{
            Toast.makeText(this, "\"Failed\"", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
