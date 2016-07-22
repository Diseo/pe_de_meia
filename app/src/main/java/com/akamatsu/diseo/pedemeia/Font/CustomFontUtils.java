package com.akamatsu.diseo.pedemeia.Font;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.akamatsu.diseo.pedemeia.R;

/**
 * Created by Avell B155 on 22/07/16.
 */
public class CustomFontUtils {
    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public static void applyCustomFont(TextView customFontTextView, Context context) {
        Typeface customFont = FontCache.getTypeface("Rubik-Regular.ttf", context);
        customFontTextView.setTypeface(customFont);
    }
}
