package com.zxn.customview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by zxn on 2019-2-16 12:05:48.
 */
public class DrawingActivity extends AppCompatActivity {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public static void jumpTo(Context context, String param1) {
        Intent intent = new Intent(context, DrawingActivity.class);
        intent.putExtra(ARG_PARAM1, param1);
        context.startActivity(intent);
    }

    public static void jumpTo(Context context) {
        Intent intent = new Intent(context, DrawingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);
        mParam1 = getIntent().getStringExtra(ARG_PARAM1);
    }
}
