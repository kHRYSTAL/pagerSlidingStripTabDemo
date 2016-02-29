package me.khrystal.find_new_slidestrip;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private RelativeLayout searchLayout;
    private TextView tab1;
    private RelativeLayout searchView1;
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (SmartTabLayout) findViewById(R.id.tabLayout);
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        layout = (RelativeLayout) LayoutInflater.from(FourthActivity.this).inflate(R.layout.custom_tab_search,tabs,false);
        tab1 = (TextView) layout.findViewById(R.id.custom_text);
        searchView1 = (RelativeLayout) layout.findViewById(R.id.custom_search);


        tabs.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                //TextView icon = (TextView) LayoutInflater.from(FourthActivity.this).inflate(R.layout.searc, container, false);
                searchLayout = (RelativeLayout)LayoutInflater.from(FourthActivity.this).inflate(R.layout.custom_tab_search,tabs,false);
                TextView tab = (TextView)searchLayout.findViewById(R.id.custom_text);
                RelativeLayout searchView = (RelativeLayout)searchLayout.findViewById(R.id.custom_search);
                switch (position) {
                    case 0:
                        tab.setText("Tab 0");
                        break;
                    case 1:
                        tab.setText("Tab 1");
                        break;
                    case 2:
                        tab.setText("Tab 2");
                        break;
                    case 3:
                        tab.setText("Tab 3");
                        break;
                    case 4:
                        tab1.setText("Tab 4");
                        return layout;

                    default:
                        throw new IllegalStateException("Invalid position: " + position);
                }
                return searchLayout;
            }
        });
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==4){
                    tab1.setVisibility(View.GONE);
                    searchView1.setVisibility(View.VISIBLE);
                }else {
                    tab1.setVisibility(View.VISIBLE);
                    searchView1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
