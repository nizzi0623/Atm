package com.nizzi.atm;

import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        EditText edUserid = (EditText) findViewById(R.id.userid);
        EditText edPassword = (EditText) findViewById(R.id.password);
        String userid = edUserid.getText().toString();
        String password = edPassword.getText().toString();
        if ("jack".equals(userid) && "1234".equals(password)){
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID", userid);
            getIntent().putExtra("LOGIN_PASSWORD", password);
            setResult(RESULT_OK, getIntent());
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setTitle("Atm")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK", null)
                    .show();
        }
    }
}
