package com.fusionlab.texteditors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VHScrollWithLineNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_h_scroll_with_line_numbers);
        setTitle("VH-Scroll Editor | line numbers");
    }
}