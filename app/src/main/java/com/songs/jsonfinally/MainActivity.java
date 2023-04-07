package com.songs.jsonfinally;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;



public class MainActivity extends ActionBarActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent homeIntent = new Intent(MainActivity.this, FirstPage.class);
                homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);





    }





    }




