package com.akamatsu.diseo.pedemeia.View;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akamatsu.diseo.pedemeia.Font.CustomFontUtils;

/**
 * Created by Avell B155 on 22/07/16.
 */
public class CustomFontTabLayout extends TabLayout {
    private Typeface mTypeface;

    public CustomFontTabLayout(Context context) {
        super(context);
    }

    public CustomFontTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomFontTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addTab(Tab tab) {
        super.addTab(tab);

        ViewGroup mainView = (ViewGroup) getChildAt(0);
        ViewGroup tabView = (ViewGroup) mainView.getChildAt(tab.getPosition());
        View tabViewChild = tabView.getChildAt(1);
        CustomFontUtils.applyCustomFont((TextView) tabViewChild, getContext());
//        ((TextView) tabViewChild).setAllCaps(false);
    }

}
