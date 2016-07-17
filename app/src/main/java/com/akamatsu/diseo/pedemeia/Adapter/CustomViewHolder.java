package com.akamatsu.diseo.pedemeia.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.akamatsu.diseo.pedemeia.R;

/**
 * Created by Avell B155 on 16/07/16.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {
    protected TextView textView;

    public CustomViewHolder(View view) {
        super(view);
        this.textView = (TextView) view.findViewById(R.id.title);
    }
}