package com.zxn.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
    private Paint pathPaint = new Paint();

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

        //绘制直线
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(30);
        paint.setColor(Color.parseColor("#FF0000"));
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100, 100, 600, 1000, paint);

        //path绘制折线
        pathPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        pathPaint.setStrokeWidth(50);
        pathPaint.setColor(Color.parseColor("#66ff66"));
        pathPaint.setStrokeCap(Paint.Cap.ROUND);
        Path path = new Path();
        path.lineTo(200, 600);
        //path.lineTo(400, 0);
        canvas.drawPath(path, pathPaint);

        //path绘制矩形.
        // 移动坐标系到屏幕中心
        canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path1 = new Path();
        path1.addRect(-200, -200, 200, 200, Path.Direction.CW);
        pathPaint.setColor(Color.parseColor("#FF82AB"));
        pathPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path1, pathPaint);

        //绘制多条垂直的直线
        //canvas.translate(getWidth() / 2, getHeight() / 2);
        Path path2 = new Path();
        //lineTo(float x, float y)
        path2.lineTo(0, 500);
        path2.moveTo(200, 0);
        path2.lineTo(200, 500);

        path2.moveTo(400, 0);
        path2.lineTo(400, 500);

        pathPaint.setColor(Color.parseColor("#6600ff"));
        canvas.drawPath(path2, pathPaint);

        pathPaint.setStrokeWidth(50);
        pathPaint.setStrokeCap(Paint.Cap.BUTT);
        pathPaint.setColor(Color.parseColor("#00cc99"));
        path2.reset();
        path2.moveTo(0-50, 500);
        path2.lineTo(getWidth() / 2, 500);
        canvas.drawPath(path2, pathPaint);
    }

}
