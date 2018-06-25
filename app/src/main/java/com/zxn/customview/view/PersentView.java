package com.zxn.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.zxn.customview.R;

public class PersentView extends View {

    private Paint paint;
    private String TAG = "PersentView";
    private RectF rectF;

    //绘制圆的半径
    private float radius;
    private int bgColor;
    private int progressColor;
    private int percentProgress;

    //在代码中创建使用
    public PersentView(Context context) {
        this(context, null);
    }

    //在xml布局中使用的,可以读取属性
    public PersentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        Log.i(TAG, "PersentView: --->2");
    }

    public PersentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        Log.i(TAG, "init: --->");
        paint = new Paint();
        //设置抗锯齿,使线条平滑.
        paint.setAntiAlias(true);
        //设置绘制的边界
        rectF = new RectF();
        //obtainStyledAttributes(
        //            AttributeSet set, @StyleableRes int[] attrs)
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PersentView);
        //getDimension(@StyleableRes int index, float defValue)

        //读取半径属性的值,默认值是50.
        radius = typedArray.getDimension(R.styleable.PersentView_percent_circle_radius, 50);

        //读取圆的背景颜色.
//        bgColor = attrs.getAttributeResourceValue(R.styleable.PersentView_percent_circle_bg, Color.GRAY);
        bgColor = typedArray.getColor(R.styleable.PersentView_percent_circle_bg,Color.GRAY);

        //读取进度颜色
        progressColor = typedArray.getColor(R.styleable.PersentView_percent_progress_color, Color.DKGRAY);

        //读取进度值
        percentProgress = typedArray.getInt(R.styleable.PersentView_percent_circle_progress, 0);

    }

    //重写此函数,来测量view的大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //宽度的测量模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        ViewGroup.LayoutParams params = getLayoutParams();
        //根据宽度的测量模式,做不同的测量处理
        switch (widthMode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY:
//                int size = MeasureSpec.getSize(widthMeasureSpec);
//                int measuredWidth = getMeasuredWidth();
//                Log.i(TAG,"measuredWidth--->"+measuredWidth);
//                int newWidth = measuredWidth * 2;
//                params.width = newWidth;
                break;
            case MeasureSpec.AT_MOST:
                break;
        }
        //根据高度的测量模式,做不同的测量处理
        switch (heightMode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.EXACTLY:
//                int measuredHeight = getMeasuredHeight();
//                Log.i(TAG, "measuredHeight--->"+measuredHeight);
//                int newHeight = measuredHeight * 2;
//                params.height = newHeight;
                break;
            case MeasureSpec.AT_MOST:
                break;
        }
//        setLayoutParams(params);
        //0 << MODE_SHIFT
        // 1 << MODE_SHIFT
        //2 << MODE_SHIFT
        Log.i(TAG, "onMeasure: widthMode--->" + widthMode);
        Log.i(TAG, "onMeasure: heightMode--->" + heightMode);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置圆的颜色,灰色
//        paint.setColor(Color.GRAY);
        paint.setColor(bgColor);
        //设置绘制的样式为,填充整个圆.
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        //绘制一个圆
        //radius = getWidth() / 4;
        if (radius > getWidth() / 2){
            radius =  getWidth() / 2;
        }
        Log.i(TAG, "onDraw: radius--->" + radius);
        //drawCircle(float cx, float cy, float radius, @NonNull Paint paint)
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
//        canvas.drawCircle(0,0,radius,paint);
        //设置绘制扇形的颜色
        //paint.setColor(Color.RED);
        paint.setColor(progressColor);
        //绘制一个扇形
        //drawArc(@NonNull RectF oval, float startAngle, float sweepAngle, boolean useCenter,
        //            @NonNull Paint paint)

        //set(float left, float top, float right, float bottom)
        float left = getWidth() / 2 - radius;
        float top = getWidth() / 2 - radius;
        float right = left + radius * 2;
        float bottom = top + radius * 2;
        rectF.set(left, top, right, bottom);
        float  Max_Pregress= 100;
        float scale = percentProgress/Max_Pregress;
        float sweepAngle= 360 * scale;
        Log.i(TAG, "onDraw: sweepAngle--->"+sweepAngle);
        //sweepAngle为正值则顺时针,为负值的时候逆时针
        //oval:指定绘制的矩形区域
        //startAngle:绘制开始的角度
        //sweepAngle:划过的弧度
        //useCenter:是否指定区域的中心点
        //paint:画笔.
//        canvas.drawArc(rectF, 270, 180, true, paint);
        canvas.drawArc(rectF, 270, sweepAngle, true, paint);
    }
}
