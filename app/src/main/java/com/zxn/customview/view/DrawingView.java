package com.zxn.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * view中基本图形的绘制.
 * https://blog.csdn.net/moira33/article/details/79111343
 * Created by zxn on 2019/2/16.
 */
public class DrawingView extends View {


    private Paint paint = new Paint();

    public DrawingView(Context context) {
        super(context);
    }


    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(30);
        paint.setColor(Color.parseColor("#FF0000"));
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 100, 600, 1000, paint);
    }
}
