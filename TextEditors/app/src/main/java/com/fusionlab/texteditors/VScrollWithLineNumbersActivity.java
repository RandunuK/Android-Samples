package com.fusionlab.texteditors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VScrollWithLineNumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_scroll_with_line_numbers);
        setTitle("V-Scroll Editor | line numbers");
    }
}