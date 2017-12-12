package com.nizzi.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {
    private final static int REQUEST_BACK = 100 ;
    boolean info = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        if (!info){
            Intent intent = new Intent(this, MainActivity.class);
            startActivityForResult(intent, REQUEST_BACK);
        }
    }
    public void info (View view){
        EditText edNickname = (EditText) findViewById(R.id.nickname);
        EditText edPhone = (EditText) findViewById(R.id.phone);
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("EXTRA_PHONE", phone);

    }
}
