package com.zxn.customview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

@ContentView(R.layout.activity_empty)
public class EmptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = {R.id.btn1, R.id.btn2,R.id.btn3,R.id.btn4})
    private void onButton(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.btn2:
                //
                startActivity(new Intent(this,GroupViewActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(this,GroupView2Activity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(this,DrawingActivity.class));
                break;
        }
    }
}
