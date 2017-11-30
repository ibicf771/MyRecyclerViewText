package com.myrecyclerview.myrecyclerviewtext;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yangsimin on 2017/11/19.
 */

public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
        Log.d("TestActivity", "ok");
        TextView textView = null;
        Log.d("TestActivity", "textView.getText():" + textView.getText());
        Log.d("TestActivity", "ok");
        if (BuildConfig.DEBUG) Log.d("TestActivity", "ok");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static int indexOf(String str) {
        return ACCESSIBILITY_SERVICE.indexOf(str);
    }

}
