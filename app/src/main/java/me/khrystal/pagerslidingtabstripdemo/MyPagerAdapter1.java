package me.khrystal.pagerslidingtabstripdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ASUS on 2016/2/18.
 */
public class MyPagerAdapter1 extends FragmentPagerAdapter {

    private ArrayList<String> titles;


    public MyPagerAdapter1(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        this.titles = list;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putString("title", titles.get(position));
        return FragmentContent.getInstance(b);
    }
}
