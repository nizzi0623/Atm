package com.nizzi.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CityActivity extends AppCompatActivity {
    private String[] cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ListView city = (ListView) findViewById(R.id.city);
        cities = new String[] {"基隆市", "新北市", "台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        city.setAdapter(adapter);
        city.setOnClickListener((View.OnClickListener) this);
    }
}
