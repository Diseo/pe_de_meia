package com.akamatsu.diseo.pedemeia;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Avell B155 on 27/07/16.
 */
public class AddGoalStep1Fragment extends Fragment {

    public static AddGoalStep1Fragment newInstance(int instance) {
        AddGoalStep1Fragment fragment = new AddGoalStep1Fragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_goal_step1, container, false);

        return view;
    }
}
