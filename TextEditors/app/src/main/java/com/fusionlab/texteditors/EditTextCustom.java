package com.fusionlab.texteditors;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class EditTextCustom extends AppCompatEditText {
    private float lineNumberWidth;
    private Rect rect;
    private Paint paintLineNumbers;
    private Rect rectLineNumberBg;
    private Paint paintLineNumbersBg;

    public EditTextCustom(@NonNull Context context) {
        super(context);
        init();
    }

    public EditTextCustom(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextCustom(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        float editorTextSize = getTextSize();
        rectLineNumberBg = new Rect();
        paintLineNumbersBg = new Paint();
        paintLineNumbersBg.setStyle(Paint.Style.FILL_AND_STROKE);
        paintLineNumbersBg.setStrokeWidth(2);
        paintLineNumbersBg.setColor(Color.parseColor("#eeeeee"));

        rect = new Rect();
        paintLineNumbers = new Paint();
        paintLineNumbers.setStyle(Paint.Style.FILL);
        paintLineNumbers.setStrokeWidth(2);
        paintLineNumbers.setColor(Color.parseColor("#616161"));
        paintLineNumbers.setTextSize(editorTextSize);
        float mWidth = paintLineNumbers.measureText("M");
        int paddingLeft = (int) ((int) mWidth * 4.2);
        lineNumberWidth = mWidth * 3.8f;
        rectLineNumberBg.left = 0;
        rectLineNumberBg.right = (int) lineNumberWidth;
        setPadding(paddingLeft, 0, 0, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //draw line numbers & vertical line(rect)
        int baseline = getBaseline();
        int lineCount = getLineCount();
        rectLineNumberBg.top = 0;
        rectLineNumberBg.bottom = getHeight();
        Log.d("bottom8", "onDraw: " + rectLineNumberBg.bottom);
        canvas.drawRect(rectLineNumberBg, paintLineNumbersBg);

        for (int i = 0; i < lineCount; i++) {
            canvas.drawText(" " + (i + 1), rect.left, baseline, paintLineNumbers);
            baseline += getLineHeight();
        }
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
