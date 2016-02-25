package me.khrystal.find_new_slidestrip;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import me.khrystal.pagerslidingtabstripdemo.MyPagerAdapter1;
import me.khrystal.pagerslidingtabstripdemo.PagerSlidingTabStrip;
import me.khrystal.pagerslidingtabstripdemo.R;

public class ThirdActivity extends AppCompatActivity {
    private SmartTabLayout tabs;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (SmartTabLayout) findViewById(R.id.tabLayout);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Tab " + i);
        }
        pager.setAdapter(new MyPagerAdapter1(getSupportFragmentManager(), list));
        tabs.setViewPager(pager);
    }
}
