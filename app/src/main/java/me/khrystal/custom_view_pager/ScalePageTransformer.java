package me.khrystal.custom_view_pager;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * 在此写用途
 *
 * @FileName: me.khrystal.custom_view_pager.ScalePageTransformer.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-03-01 11:45
 */
public class ScalePageTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 1.2f;
    public static final float MIN_SCALE = 0.6f;

    @Override
    public void transformPage(View page, float position) {

        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        //一个公式
        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);
    }
}
