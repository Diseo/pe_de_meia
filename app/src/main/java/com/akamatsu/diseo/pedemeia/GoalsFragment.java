package com.akamatsu.diseo.pedemeia;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.akamatsu.diseo.pedemeia.Adapter.GoalAdapter;
import com.akamatsu.diseo.pedemeia.Model.Goal;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by niccapdevila on 3/26/16.
 */
public class GoalsFragment extends Fragment {

    private Realm realm;
    private RecyclerView mRecyclerView;
    private GoalAdapter adapter;
    private RelativeLayout balance;

    public static GoalsFragment newInstance(int instance) {
        GoalsFragment fragment = new GoalsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goals, container, false);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this.getActivity()).build();
        realm = Realm.getInstance(realmConfiguration);

        RealmQuery<Goal> query = realm.where(Goal.class);
        RealmResults<Goal> result1 = query.findAll();

        // Initialize recycler view
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));


//        TextView firstGoal = (TextView) view.findViewById(R.id.goalTitle);
//        firstGoal.setText(result1.get(1).getName());
//        TextView numGoals = (TextView) view.findViewById(R.id.balanceTitle);
//        numGoals.setText("Balanço (" + realm.where(Goal.class).count() + ")");

//        adapter = new GoalAdapter(this.getActivity(), goals);
//        mRecyclerView.setAdapter(adapter);
//        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
//        itemAnimator.setAddDuration(5000);
//        itemAnimator.setRemoveDuration(1000);
//        mRecyclerView.setItemAnimator(itemAnimator);

//        mRecyclerView.invalidate();

        return view;
    }

    private void showDetails(int position) {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

        final List<Goal> goals = new ArrayList<Goal>(realm.where(Goal.class).findAll());
        adapter = new GoalAdapter(this.getActivity(), goals);
        mRecyclerView.setAdapter(adapter);



//        if(mAdapter == null) {
//            List<Goal> goals = new ArrayList<Goal>(realm.where(Goal.class).findAll());
//
//            mAdapter = new GoalAdapter(this.getActivity(), goals);
//
//            mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.list_view);
//            mRecyclerView.setAdapter(mAdapter);
//            mAdapter.notifyDataSetChanged();
//            mRecyclerView.invalidate();
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
