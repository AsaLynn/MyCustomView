package com.zxn.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zxn.customview.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class CustomTitleBar extends LinearLayout {
    @ViewInject(R.id.tv_title)
    TextView titleTv;


    public CustomTitleBar(Context context) {
        super(context);
        initView(null);
    }

    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    public CustomTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        View view = LayoutInflater
                .from(getContext())
                .inflate(R.layout.layout_group, this, true);
        x.view().inject(this, view);
        if (null != attrs) {
            TypedArray typedArray = getContext()
                    .obtainStyledAttributes(attrs, R.styleable.CustomTitleBar);
            String title = typedArray.getString(R.styleable.CustomTitleBar_title_text);
            titleTv.setText(title);
            int bgColor = typedArray.getColor(R.styleable.CustomTitleBar_customtitlebar_bg, Color.GRAY);
            this.setBackgroundColor(bgColor);
        }
    }
}
