package com.nizzi.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {
    private EditText edNickname;
    private EditText edPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edNickname = (EditText) findViewById(R.id.nickname);
        edPhone = (EditText) findViewById(R.id.phone);
        String ednickname = getSharedPreferences("info", MODE_PRIVATE).getString("NICKNAME", "");
        String edphone = getSharedPreferences("info", MODE_PRIVATE).getString("PHONE", "");
        edNickname.setText(ednickname);
        edPhone.setText(edphone);
    }
    public void info (View view){
        String ednickname = edNickname.getText().toString();
        String edphone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", ednickname);
        getIntent().putExtra("EXTRA_PHONE", edphone);
        setResult(RESULT_OK, getIntent());
        finish();

    }
}
