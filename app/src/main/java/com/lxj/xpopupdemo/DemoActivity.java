package com.lxj.xpopupdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.interfaces.OnSelectListener;

/**
 * Description:
 * Create by lxj, at 2019/2/2
 */
public class DemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("此页面仅仅为了测试瞬间开启多弹窗");
        textView.setTextSize(30);
        textView.setPadding(40,40,40,40);
        setContentView(textView);


        XPopup.get(this).asBottomList("haha", new String[]{"aaaa", "bbbb", "bbbb", "ddddd"}, new OnSelectListener() {
            @Override
            public void onSelect(int position, String text) {
                Toast.makeText(DemoActivity.this, text, Toast.LENGTH_LONG).show();
            }
        }).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                XPopup.get(DemoActivity.this).asLoading().show();
            }
        },0);
    }
}
