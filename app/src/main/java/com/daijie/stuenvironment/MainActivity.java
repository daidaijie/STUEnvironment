package com.daijie.stuenvironment;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TextView mTitleTextView;
    TabLayout mTabLayout;
    ViewPager mMainViewPager;

    MainFragmentAdapter mMainFragmentAdapter;

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
        initTab();
    }

    private void initTab() {
        mMainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mMainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager());
        mMainViewPager.setAdapter(mMainFragmentAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mMainViewPager);
        mTabLayout.getTabAt(0).setText("A座");
        mTabLayout.getTabAt(1).setText("B座");
        mTabLayout.getTabAt(2).setText("C座");
        mTabLayout.getTabAt(3).setText("D座");
        mTabLayout.getTabAt(4).setText("E座");
        mTabLayout.getTabAt(5).setText("F座");
        mTabLayout.getTabAt(6).setText("G座");
        mTabLayout.getTabAt(7).setText("至诚");
        mTabLayout.getTabAt(8).setText("弘毅");
        mTabLayout.getTabAt(9).setText("思源");
        mTabLayout.getTabAt(10).setText("知行");
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


