package me.khrystal.utils;

import android.content.Context;

/**
 * 在此写用途
 *
 * @FileName: me.khrystal.utils.DensityUtil.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-02-25 17:32
 */
public class DensityUtil {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
