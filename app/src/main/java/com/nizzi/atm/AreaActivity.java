package com.nizzi.atm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class AreaActivity extends AppCompatActivity {
    private String[] areas;
    private ListView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        area = (ListView) findViewById(R.id.area);


    }
}
