package com.fusionlab.texteditors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VScrollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_scroll);
        setTitle("V-Scroll Editor");
    }
}