package me.khrystal.find_new_slidestrip;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import me.khrystal.pagerslidingtabstripdemo.MyPagerAdapter;
import me.khrystal.pagerslidingtabstripdemo.MyPagerAdapter1;
import me.khrystal.pagerslidingtabstripdemo.R;

/**
 * 在此写用途
 *
 * @FileName: me.khrystal.find_new_slidestrip.FifthActivity.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-02-25 19:01
 */
public class FifthActivity extends AppCompatActivity {
    private SmartTabLayout tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (SmartTabLayout) findViewById(R.id.tabLayout);
        final Resources res = getResources();
        tabs.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                ImageView icon = (ImageView) LayoutInflater.from(FifthActivity.this).inflate(R.layout.custom_tab_icon1, container, false);
                switch (position) {
                    case 0:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_home_white_24dp));
                        icon.setPadding(40,0,40,0);
                        break;
                    case 1:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_search_white_24dp));
                        icon.setPadding(40,0,40,0);
                        break;
                    case 2:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_person_white_24dp));
                        icon.setPadding(40,0,40,0);
                        break;
                    case 3:
                        icon.setImageDrawable(res.getDrawable(R.drawable.ic_flash_on_white_24dp));
                        icon.setPadding(40,0,40,0);
                        break;
                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }
                return icon;
            }
        });

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("Tab " + i);
        }
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), list));

        tabs.setViewPager(pager);
    }
}
