package com.akamatsu.diseo.pedemeia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by niccapdevila on 3/26/16.
 */
public class OutgoingFragment extends Fragment {

    public static OutgoingFragment newInstance(int instance) {
        OutgoingFragment fragment = new OutgoingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outgoing, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}