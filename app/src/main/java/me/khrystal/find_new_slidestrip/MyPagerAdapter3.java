package me.khrystal.find_new_slidestrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.khrystal.pagerslidingtabstripdemo.FragmentContent;

/**
 * 在此写用途
 *
 * @FileName: me.khrystal.find_new_slidestrip.MyPagerAdapter3.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-03-01 16:59
 */
public class MyPagerAdapter3  extends FragmentPagerAdapter {

    private ArrayList<String> titles;


    public MyPagerAdapter3(FragmentManager fm, ArrayList<String> list) {
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
        b.putString("title", titles.get(position%titles.size()));
        return FragmentWebContent.getInstance(b);
    }
}
