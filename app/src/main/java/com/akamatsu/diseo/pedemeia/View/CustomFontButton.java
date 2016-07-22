package com.akamatsu.diseo.pedemeia.View;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.akamatsu.diseo.pedemeia.Font.CustomFontUtils;
import com.akamatsu.diseo.pedemeia.Font.FontCache;

/**
 * Created by Avell B155 on 22/07/16.
 */
public class CustomFontButton extends Button {

    public CustomFontButton(Context context) {
        super(context);

        CustomFontUtils.applyCustomFont(this, context);
    }

    public CustomFontButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        CustomFontUtils.applyCustomFont(this, context);
    }

    public CustomFontButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        CustomFontUtils.applyCustomFont(this, context);
    }
}
