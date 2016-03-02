package me.khrystal.find_new_slidestrip;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * 在此写用途
 *
 * @FileName: me.khrystal.find_new_slidestrip.CustomDurationScroller.java
 * @author: kHRYSTAL
 * @email: 723526676@qq.com
 * @date: 2016-03-01 18:05
 */
public class CustomDurationScroller extends Scroller {

    private double scrollFactor = 1;

    public CustomDurationScroller(Context context) {
        super(context);
    }

    public CustomDurationScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    /**
     * not exist in android 2.3
     *
     * @param context
     * @param interpolator
     * @param flywheel
     */
    // @SuppressLint("NewApi")
    // public CustomDurationScroller(Context context, Interpolator interpolator, boolean flywheel){
    // super(context, interpolator, flywheel);
    // }

    /**
     * Set the factor by which the duration will change
     */
    public void setScrollDurationFactor(double scrollFactor) {
        this.scrollFactor = scrollFactor;
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, (int)(duration * scrollFactor));
    }
}
