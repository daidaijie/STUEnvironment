package com.daijie.stuenvironment;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TextView mTitleTextView;

    protected int mStatusBarHeight;
    protected int mDeviceWidth;
    protected int mDeviceHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        initSize();
        initView();
    }

    private void initSize() {
        mDeviceWidth = getWindowManager().getDefaultDisplay().getWidth();
        mDeviceHeight = getWindowManager().getDefaultDisplay().getHeight();
        mStatusBarHeight = getStatusBarHeight();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            mDeviceHeight -= mStatusBarHeight;
        }
    }

    protected int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private void initView() {
        initToolbar();
    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitleTextView = (TextView) findViewById(R.id.titleTextView);
        //透明状态栏并且适应Toolbar的高度
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup.LayoutParams layoutParams = mToolbar.getLayoutParams();
            layoutParams.height = layoutParams.height + mStatusBarHeight;
        }
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getResources().getString(R.string.app_name));
    }

    private void setTitle(String title) {
        mTitleTextView.setText(title);
    }
}


