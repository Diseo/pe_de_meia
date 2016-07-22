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

        CustomFontUtils.applyCustomFont(this, context);
    }

    public DisplayTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        CustomFontUtils.applyCustomFont(this, context);
    }

    public DisplayTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        CustomFontUtils.applyCustomFont(this, context);
    }
}
