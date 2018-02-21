package com.wmpscc.refreshnewclothes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by wmpscc on 2018/2/20.
 */

public class AdImageView extends AppCompatImageView {
    public AdImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private int mDy;
    private int mMinDy;

    public void setDy(int dy) {
        if (getDrawable() == null) {
            return;
        }
        mDy = dy - mMinDy;
        if (mDy <= 0) {
            mDy = 0;
        }
        if (mDy > getDrawable().getBounds().height() - mMinDy) {
            mDy = getDrawable().getBounds().height() - mMinDy;
        }
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMinDy = h - oldh;
    }

    public int getDy() {
        return mDy;
    }

    @Override
    protected boolean setFrame(int l, int t, int r, int b) {
        boolean changed = super.setFrame(l, t, r, b);
        if (getScaleType() == ScaleType.MATRIX) {
            transformMatrix();
        }

        return changed;
    }

    private void transformMatrix() {
        Matrix matrix = getImageMatrix();
        matrix.reset();
        Drawable drawable = getDrawable();
        float h = getHeight();
        float w = getWidth();
        float ch = drawable.getIntrinsicHeight();
        float cw = drawable.getIntrinsicWidth();
        float widthScaleFactor = w / cw;
        float heightScaleFactor = h / ch;

        matrix.postScale(1, 1, 0, 0);
        setImageMatrix(matrix);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable drawable = getDrawable();
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, w, h);
        canvas.save();
        canvas.translate(0, -getDy());
        super.onDraw(canvas);
        canvas.restore();
    }


}
