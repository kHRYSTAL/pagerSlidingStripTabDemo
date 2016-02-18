package me.khrystal.pagerslidingtabstripdemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;


import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("Tab " + i);
        }
        pager.setAdapter(new MyPagerAdapter1(getSupportFragmentManager(), list));
        tabs.setViewPager(pager);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setTabsValue();
    }

    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        // 设置Tab是自动填充满屏幕的
        tabs.setShouldExpand(true);

        // 设置Tab的分割线的颜色
        //      tabs.setDividerColor(getResources().getColor(R.color.color_80cbc4));
        // 设置分割线的上下的间距,传入的是dp
        //      tabs.setDividerPaddingTopBottom(12);

        // 设置Tab底部线的高度,传入的是dp
        //      tabs.setUnderlineHeight(1);
        //设置Tab底部线的颜色
        //      tabs.setUnderlineColor(getResources().getColor(R.color.color_1A000000));

        // 设置Tab 指示器Indicator的高度,传入的是dp
        //    tabs.setIndicatorHeight(4);
        // 设置Tab Indicator的颜色
        //      tabs.setIndicatorColor(getResources().getColor(R.color.color_45c01a));

        // 设置Tab标题文字的大小,传入的是dp
        tabs.setTextSize(16);
        // 设置选中Tab文字的颜色
        tabs.setSelectedTextColor(getResources().getColor(R.color.color_45c01a));
        //设置正常Tab文字的颜色
        tabs.setTextColor(getResources().getColor(R.color.color_C231C7));

        //  设置点击Tab时的背景色
        tabs.setTabBackground(R.drawable.background_tab);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        width = width - 50;
        //是否支持动画渐变(颜色渐变和文字大小渐变)
        tabs.setFadeEnabled(true);
        // 设置最大缩放,是正常状态的0.3倍
        tabs.setZoomMax(0.3F);
    }
}
