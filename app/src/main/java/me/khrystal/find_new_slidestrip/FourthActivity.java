package me.khrystal.find_new_slidestrip;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

import me.khrystal.custom_view_pager.ScalePageTransformer;
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
    LinearLayout container;
    private int currIndex;
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
        container = (LinearLayout)findViewById(R.id.pager_container);

        tabs.setCustomTabView(new SmartTabLayout.TabProvider() {
            @Override
            public View createTabView(ViewGroup container, int position, PagerAdapter adapter) {
                //TextView icon = (TextView) LayoutInflater.from(FourthActivity.this).inflate(R.layout.searc, container, false);
                searchLayout = (RelativeLayout)LayoutInflater.from(FourthActivity.this).inflate(R.layout.custom_tab_search,tabs,false);
                TextView tab = (TextView)searchLayout.findViewById(R.id.custom_text);
                RelativeLayout searchView = (RelativeLayout)searchLayout.findViewById(R.id.custom_search);
                switch (position) {
                    case 0:
                        tab.setText("Tab 4");
                        break;
                    case 1:
                        tab.setText("Tab 0");
                        break;
                    case 2:
                        tab.setText("Tab 1");
                        break;
                    case 3:
                        tab.setText("Tab 2");
                        break;
                    case 4:
                        tab1.setText("Tab 3");
                        return layout;
                    case 5:
                        tab.setText("Tab 4");
                        break;
                    case 6:
                        tab.setText("Tab 0");
                        break;
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
                currIndex = position;
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
                if(state==ViewPager.SCROLL_STATE_IDLE){//当滑动停止时，判断是否到达边界
                    if(currIndex==6){
                        pager.setCurrentItem(1,false);
                    }else if(currIndex==0){
                        pager.setCurrentItem(5,false);
                    }
                }
            }
        });
        int width = wm.getDefaultDisplay().getWidth();
       // tabs.setMinimumWidth(DensityUtil.px2dip(this,((float)(width-100)/(float)2)));
        ArrayList<String> list = new ArrayList<>();
        list.add("Tab 4");
        for (int i = 0; i < 5; i++) {
            list.add("Tab " + i);
        }
        list.add("Tab 0");
        pager.setAdapter(new MyPagerAdapter1(getSupportFragmentManager(), list));

//        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float f, int i1) {
//                int childCount = pager.getChildCount();
//                int width = pager.getChildAt(0).getWidth();
//                int padding = (pager.getWidth() - width) / 2;
//                for (int j = 0; j < childCount; j++) {
//                    View v = pager.getChildAt(j);
//                    //往左 从 padding 到 -(v.getWidth()-padding) 的过程中，由大到小
//                    float rate = 0;
//                    if (v.getLeft() <= padding) {
//                        if (v.getLeft() >= padding - v.getWidth()) {
//                            rate = (padding - v.getLeft()) * 1f / v.getWidth();
//                        } else {
//                            rate = 1;
//                        }
//                        v.setScaleY(1 - rate * 0.1f);
//                    } else {
//                        //往右 从 padding 到 recyclerView.getWidth()-padding 的过程中，由大到小
//                        if (v.getLeft() <= pager.getWidth() - padding) {
//                            rate = (pager.getWidth() - padding - v.getLeft()) * 1f / v.getWidth();
//                        }
//                        v.setScaleY(0.9f + rate * 0.1f);
//                    }
//                }
//                pager.invalidate();
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });
//
//        pager.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
//            @Override
//            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//                if (pager.getChildCount() < 3) {
//                    if (pager.getChildAt(1) != null) {
//                        View v1 = pager.getChildAt(1);
//                        v1.setScaleY(0.9f);
//                    }
//                } else {
//                    if (pager.getChildAt(0) != null) {
//                        View v0 = pager.getChildAt(0);
//                        v0.setScaleY(0.9f);
//                    }
//                    if (pager.getChildAt(2) != null) {
//                        View v2 = pager.getChildAt(2);
//                        v2.setScaleY(0.9f);
//                    }
//                }
//            }
//        });
        pager.setPageTransformer(true,new ScalePageTransformer());

        pager.setOffscreenPageLimit(5);

        pager.setPageMargin(5);
        container.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // dispatch the events to the ViewPager, to solve the problem that we can swipe only the middle view.
                return pager.dispatchTouchEvent(event);
            }
        });
        pager.setCurrentItem(1);
        tabs.setViewPager(pager);
    }


}
