package com.fusionlab.texteditors;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.a_main_button1).setOnClickListener(this);
        findViewById(R.id.a_main_button2).setOnClickListener(this);
        findViewById(R.id.a_main_button3).setOnClickListener(this);
        findViewById(R.id.a_main_button4).setOnClickListener(this);
        findViewById(R.id.a_main_button5).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent(MainActivity.this, VScrollActivity.class);
        if (id == R.id.a_main_button1) {
            intent = new Intent(MainActivity.this, VScrollActivity.class);
        } else if (id == R.id.a_main_button2) {
            intent = new Intent(MainActivity.this, VScrollWithLineNumbersActivity.class);
        } else if (id == R.id.a_main_button3) {
            intent = new Intent(MainActivity.this, VHScrollActivity.class);
        } else if (id == R.id.a_main_button4) {
            intent = new Intent(MainActivity.this, VHScrollWithLineNumbersActivity.class);
        } else if (id == R.id.a_main_button5) {
            intent = new Intent(MainActivity.this, VHScrollWithFixedLineNumbersActivity.class);
        }
        startActivity(intent);
    }
}