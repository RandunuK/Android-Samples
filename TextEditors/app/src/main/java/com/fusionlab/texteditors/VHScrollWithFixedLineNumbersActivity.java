package com.fusionlab.texteditors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class VHScrollWithFixedLineNumbersActivity extends AppCompatActivity {
    EditText codeEditorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_h_scroll_with_fixed_line_numbers);
        setTitle("VH-Scroll | fixed line numbers");

        //**NOTE: first line number need to be hardcoded in layout xml**
        EditText lineNumberView = findViewById(R.id.textViewLineNumbers);
        codeEditorView = findViewById(R.id.editTextTextMultiLine2);
        codeEditorView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int editorLineCount = codeEditorView.getLineCount();
                int numberViewLineCount = lineNumberView.getLineCount();
                String lineText = "";

                // editing on the same line
                if (numberViewLineCount - 1 == editorLineCount) {
                    return;
                }

                // remove unwanted line numbers on deletion
                if (numberViewLineCount > editorLineCount) {
                    int length = lineNumberView.getText().length();
                    if (editorLineCount > 0) {
                        int requiredCharCount = 0;
                        if (editorLineCount < 10) { // 10
                            requiredCharCount = editorLineCount * 2;
                        } else if (editorLineCount < 100) { // 100
                            requiredCharCount = (9 * 2) + (editorLineCount - 9) * 3;
                        } else if (editorLineCount < 1000) { // 1000
                            requiredCharCount = (9 * 2) + (90 * 3) + (editorLineCount - 99) * 4;
                        } else if (editorLineCount < 10000) {
                            requiredCharCount = (9 * 2) + (90 * 3) + (4 * 900) + (editorLineCount - 999) * 5;
                        } else if (editorLineCount < 100000) {
                            requiredCharCount = (9 * 2) + (90 * 3) + (4 * 900) + (9000 * 5) + (editorLineCount - 9999) * 6;
                        }

                        // line numbers will be render as below string
                        // 1\n2\n3\n4\n\5\n6\n7\n8\n9\n10\n11
                        lineNumberView.getText().delete(requiredCharCount, length);
                    }
                    return;
                }

                //add new line numbers on insertion
                for (int i = numberViewLineCount; i <= editorLineCount; i++) {
                    lineText = i + "\n";
                    lineNumberView.append(lineText);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        // this line triggers to generate line numbers
        codeEditorView.postDelayed(new Runnable() {
            @Override
            public void run() {
                codeEditorView.append("\n");
            }
        }, 50);
    }
}