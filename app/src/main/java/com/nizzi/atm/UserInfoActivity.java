package com.nizzi.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    private EditText edNickname;
    private EditText edPhone;
    private Spinner ages;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ages = (Spinner) findViewById(R.id.ages);
        ArrayList<String> data = new ArrayList<>();
        for (int i=15; i<=40; i++){
            data.add(i+"");
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, data);
        ages.setAdapter(adapter);
        /* String ednickname = getSharedPreferences("info", MODE_PRIVATE).getString("NICKNAME", "");
        String edphone = getSharedPreferences("info", MODE_PRIVATE).getString("PHONE", "");
        edNickname.setText(ednickname);
        edPhone.setText(edphone);*/
    }
    public void info (View view){
        Log.d(TAG, "ok:" + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        edNickname = (EditText) findViewById(R.id.TextView);
        edPhone = (EditText) findViewById(R.id.phone);
        String ednickname = edNickname.getText().toString();
        String edphone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", ednickname);
        getIntent().putExtra("EXTRA_PHONE", edphone);
        setResult(RESULT_OK, getIntent());
        finish();

    }
}
