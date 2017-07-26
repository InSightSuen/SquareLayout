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

import android.support.annotation.DimenRes;
import android.support.annotation.IntDef;
import android.support.annotation.Px;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A <code>SquareLayout</code> is a squared <code>ViewGroup</code>, which always has the same width
 * and height value.
 * <p>
 * <p>You can determine the length of a <code>SquareLayout</code> by setting the {@link MatchType}:</p>
 * <p>
 * <p>{@link SquareLayout#MATCH_WIDTH} - the length of this <code>SquareLayout</code> is determined by
 * the {@link android.view.ViewGroup.LayoutParams#width}, and ignore the height. It's the default
 * <code>MatchType</code></p>
 * <p>
 * <p>{@link SquareLayout#MATCH_HEIGHT} - the length of this <code>SquareLayout</code> is determined by
 * the {@link android.view.ViewGroup.LayoutParams#height}, and ignore the wdith.</p>
 * <p>
 * <p>{@link SquareLayout#MATCH_LENGTH} - the length of this <code>SquareLayout</code> is determined by
 * the attr <code>SquareLayout_match</code>. The default value is 0, so you have to give the length
 * value by {@link SquareLayout#setLength(int)}, or {@link SquareLayout#setLengthDimenRes(int)}</p>
 *
 * @attr ref com.insightsuen.squarelayout.R.styleable#SquareLayout_match
 * @attr ref com.insightsuen.squarelayout.R.styleable#SquareLayout_length
 */
public interface SquareLayout {

    /**
     * The match type of SquareLayout, it determines the length of view
     * according to width, or height, or specified length.
     */
    @IntDef({MATCH_WIDTH, MATCH_HEIGHT, MATCH_LENGTH})
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface MatchType {}

    /**
     * The view's length will match the width MeasureSpec, and ignore height MeasureSpec.
     * It's the default {@link MatchType}.
     */
    int MATCH_WIDTH = 0;

    /**
     * The view's length will match the height MeasureSpec, and ignore width MeasureSpec
     */
    int MATCH_HEIGHT = 1;

    /**
     * The view's length will be the specified length, and ignore either width or height MeasureSpec.
     */
    int MATCH_LENGTH = 2;

    /**
     * @param matchType the match type of <code><SquareLayout/code>
     * @param length    the length px value or <code>MeasureSpec</code>
     */
    void setMatchType(@MatchType int matchType, int length);

    /**
     * @return the match type of this SquareLayout
     */
    @MatchType
    int getMatchType();

    /**
     * Set the length value of this <code>SquareLayout</code>. It only work with the MatchType of
     * <code>Match_Length</code>. So if the MatchType is not Match_Length. You should call
     * {@link #setMatchType(int, int)}.
     *
     * @param length the length px value
     * @see #setLengthDimenRes(int)
     */
    void setLength(@Px int length);

    /**
     * Set the length dimen resource of this <code>SquareLayout</code>. It only work with the
     * MatchType of <code>Match_Length</code>. So if the MatchType is not Match_Length. You should
     * call {@link #setMatchType(int, int)}.
     *
     * @param lengthDimenRes the length dimen resource id.
     * @see #setLength(int)
     */
    void setLengthDimenRes(@DimenRes int lengthDimenRes);

    /**
     * @return the length px value set of this SquareLayout. It's not the actually width or
     * height of the view when the MatchType is not {@link #MATCH_LENGTH}.
     */
    @Px
    int getLength();
}
