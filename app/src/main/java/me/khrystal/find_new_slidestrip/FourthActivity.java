package me.khrystal.find_new_slidestrip;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import me.khrystal.pagerslidingtabstripdemo.MyPagerAdapter1;
import me.khrystal.pagerslidingtabstripdemo.R;
import me.khrystal.utils.DensityUtil;

/**
 * 在此写用途
 *
 * @FileName: me.khrystal.find_new_slidestrip.FourthActivity.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-02-25 17:22
 */
public class FourthActivity extends AppCompatActivity {
    private SmartTabLayout tabs;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (SmartTabLayout) findViewById(R.id.tabLayout);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
       // tabs.setMinimumWidth(DensityUtil.px2dip(this,((float)(width-100)/(float)2)));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Tab " + i);
        }
        pager.setAdapter(new MyPagerAdapter1(getSupportFragmentManager(), list));
        tabs.setViewPager(pager);
    }
}
