package com.akamatsu.diseo.pedemeia.Font;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Avell B155 on 21/07/16.
 */
public class DisplayTextView extends TextView {

    public DisplayTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public DisplayTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public DisplayTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Rubik-Regular.ttf", context);
        setTypeface(customFont);
    }
}
