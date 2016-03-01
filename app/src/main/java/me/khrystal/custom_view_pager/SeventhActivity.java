package me.khrystal.custom_view_pager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import me.khrystal.pagerslidingtabstripdemo.MyPagerAdapter1;
import me.khrystal.pagerslidingtabstripdemo.R;

/**
 * 在此写用途
 *
 * @FileName: me.khrystal.custom_view_pager.SeventhActivity.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-03-01 11:42
 */
public class SeventhActivity extends AppCompatActivity{
    private ClipViewPager mViewPager;
    private SmartTabLayout tabs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);


        mViewPager = (ClipViewPager) findViewById(R.id.viewpager);
        mViewPager.setPageTransformer(true, new ScalePageTransformer());
        tabs = (SmartTabLayout)findViewById(R.id.tabLayout);
        findViewById(R.id.page_container).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return mViewPager.dispatchTouchEvent(event);
            }
        });

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Tab " + i);
        }
        mViewPager.setAdapter(new MyPagerAdapter1(getSupportFragmentManager(), list));
        tabs.setViewPager(mViewPager);


    }
}
