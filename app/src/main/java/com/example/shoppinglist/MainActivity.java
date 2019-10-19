package com.example.shoppinglist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int Time=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Runnable r= new Runnable() {
            @Override
            public void run() {
                Intent homeIntent =new Intent(MainActivity.this,Login.class);
                startActivity(homeIntent);
                finish();
            }
        };
        new Handler().postDelayed( r, Time);
    }
}
