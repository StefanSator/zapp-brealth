package com.example.stefansator.brealth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by StefanSator on 09.06.18.
 */

public class ScrollingTextView extends android.support.v7.widget.AppCompatTextView implements Runnable {
    private static final float DEFAULT_SPEED = 15.0f;

    private Scroller scroller;
    private float speed = DEFAULT_SPEED;
    private boolean continousScrolling = true;

    public ScrollingTextView(Context context) {
        super(context);
        setup(context);
    }

    public ScrollingTextView(Context context, AttributeSet attributes) {
        super(context, attributes);
        setup(context);
    }

    public ScrollingTextView(Context context, float speed) {
        super(context);
        this.speed = speed;
        setup(context);
    }

    private void setup(Context context) {
        scroller = new Scroller(context, new LinearInterpolator());
        setScroller(scroller);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (scroller.isFinished()) {
            scroll();
        }
    }

    private void scroll() {
        int viewHeight = getHeight();
        int visibleHeight = viewHeight - getPaddingBottom() - getPaddingTop();
        int lineHeight = getLineHeight();

        int offset = -1 * visibleHeight;
        int totallineHeight = getLineCount() * lineHeight;
        int distance = totallineHeight + visibleHeight;
        int duration = (int) (distance * speed);

        if (totallineHeight > visibleHeight) {
            scroller.startScroll(0, offset, 0, distance, duration);

            if (continousScrolling) {
                post(this);
            }
        }
    }

    @Override
    public void run() {
        if (scroller.isFinished()) {
            scroller.abortAnimation();
        } else {
            post(this);
        }
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setContinousScrolling(boolean continousScrolling) {
        this.continousScrolling = continousScrolling;
    }

    public boolean isContinousScrolling() {
        return continousScrolling;
    }

    public int getDuration() {
        return scroller.getDuration();
    }
}
