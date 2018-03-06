package com.wmpscc.refreshnewclothes;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by wmpscc on 2018/2/23.
 */

public class AvoidRVTouchClash extends RecyclerView {
    private int fPos = 0;
    private int ePos = 0;
    private int last = 0;
    private int dy = 0;

    public AvoidRVTouchClash(Context context) {
        super(context);
    }

    public AvoidRVTouchClash(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AvoidRVTouchClash(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setVisibleItemPos(int fPos, int ePos, int dy) {
        this.fPos = fPos;
        this.ePos = ePos;
        this.dy = Math.abs(dy);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        boolean intercept = false;
        if (e.getAction() == MotionEvent.ACTION_MOVE) {
            if (ePos == 2 && fPos == 2) {
                intercept = false;
            } else if (dy > 80 || dy == last) {
                intercept = true;
            } else {
                intercept = true;
            }
        }
        return intercept;
    }
}
