/*
 * Copyright (C) 2017 InSight Suen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.insightsuen.squarelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * A squared <code>FrameLayout</code>
 */
public class SquareFrameLayout extends FrameLayout implements SquareLayout {

    private int mMatchType = MATCH_WIDTH;

    private int mLength;

    private final ArrayList<View> mMathchParentChildren = new ArrayList<>(1);

    public SquareFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public SquareFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SquareFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = getResources().obtainAttributes(attrs, R.styleable.SquareLayout);
        try {
            mMatchType = ta.getInt(R.styleable.SquareLayout_match, MATCH_WIDTH);
            mLength = ta.getDimensionPixelSize(R.styleable.SquareLayout_length, 0);
        } finally {
            ta.recycle();
        }
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        switch (mMatchType) {
            case MATCH_WIDTH:
                super.onMeasure(widthMeasureSpec, widthMeasureSpec);
                setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
                break;

            case MATCH_HEIGHT:
                super.onMeasure(heightMeasureSpec, heightMeasureSpec);
                setMeasuredDimension(getMeasuredHeight(), getMeasuredHeight());
                break;

            case MATCH_LENGTH:
                super.onMeasure(MeasureSpec.makeMeasureSpec(mLength, MeasureSpec.EXACTLY),
                        MeasureSpec.makeMeasureSpec(mLength, MeasureSpec.EXACTLY));
                break;

            default:
                super.onMeasure(widthMeasureSpec, widthMeasureSpec);
                setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
                break;
        }
    }

    /**
     * @param matchType the match type of <code><SquareLayout/code>
     * @param length    the length px value or <code>MeasureSpec</code>
     */
    public void setMatchType(@MatchType int matchType, int length) {
        mMatchType = matchType;
        switch (mMatchType) {
            case MATCH_WIDTH:
                getLayoutParams().width = length;
                break;

            case MATCH_HEIGHT:
                getLayoutParams().height = length;
                break;

            case MATCH_LENGTH:
                mLength = length;
                break;
        }
        requestLayout();
    }

    @MatchType
    public int getMatchType() {
        return mMatchType;
    }

    public void setLength(@Px int length) {
        mLength = length;
        if (mMatchType == MATCH_LENGTH) {
            requestLayout();
        }
    }

    public void setLengthDimenRes(@DimenRes int lengthDimenRes) {
        mLength = getResources().getDimensionPixelOffset(lengthDimenRes);
        if (mMatchType == MATCH_LENGTH) {
            requestLayout();
        }
    }

    @Px
    public int getLength() {
        return mLength;
    }
}
