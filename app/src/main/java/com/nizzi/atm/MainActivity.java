package com.nizzi.atm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.TintContextWrapper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity {
    private final static int REQUEST_LOGIN = 102;
    private final static int REQUEST_INFO = 105;
    boolean logon = false;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_LOGIN:
            if (resultCode == RESULT_OK){
                String userid = data.getStringExtra("EXRA_USERID");
                String passwd = data.getStringExtra("LOGIN_PASSWORD");
                Toast.makeText(this, "Login ID" + userid, Toast.LENGTH_LONG).show();
                getSharedPreferences("atm", MODE_PRIVATE).edit().putString("USERID", userid).apply();
            }else{
                finish();
            }
            break;
            case REQUEST_INFO:
                if (resultCode == RESULT_OK){
                    String ednickname = data.getStringExtra("EXTRA_NICKNAME");
                    String edphone = data.getStringExtra("EXTRA_PHONE");
                    Toast.makeText(this, "暱稱：" + ednickname + "電話：" + edphone, Toast.LENGTH_LONG).show();
                    //getSharedPreferences("info", MODE_PRIVATE).edit().putString("NICKNAME", ednickname).putString("PHONE", edphone).apply();

                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startActivity(new Intent(this, UserInfoActivity.class));

        if (!logon){
            Intent intent = new Intent(this, LoginActivity.class);
            //startActivity(intent);
            startActivityForResult(intent, REQUEST_LOGIN);
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userinfo = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivityForResult(userinfo, REQUEST_INFO);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
