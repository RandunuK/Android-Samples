package com.fusionlab.codeeditor2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SoftInputAssist softInputAssist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //softInputAssist = new SoftInputAssist(this);

    }

    @Override
    protected void onResume() {
        //softInputAssist.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
       // softInputAssist.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
       // softInputAssist.onDestroy();
        super.onDestroy();
    }
}