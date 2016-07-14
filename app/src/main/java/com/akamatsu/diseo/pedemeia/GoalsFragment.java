package com.akamatsu.diseo.pedemeia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.akamatsu.diseo.pedemeia.Adapter.GoalAdapter;
import com.akamatsu.diseo.pedemeia.Model.Goal;

import java.util.ArrayList;
import java.util.Collection;
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
    private ListView mListView;
    private GoalAdapter mAdapter;

    public static GoalsFragment newInstance(int instance) {
        GoalsFragment fragment = new GoalsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goals_test, container, false);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this.getActivity()).build();
        realm = Realm.getInstance(realmConfiguration);

        RealmQuery<Goal> query = realm.where(Goal.class);
        RealmResults<Goal> result1 = query.findAll();

//        TextView firstGoal = (TextView) view.findViewById(R.id.goalTitle);
//        firstGoal.setText(result1.get(1).getName());
//        TextView numGoals = (TextView) view.findViewById(R.id.balanceTitle);
//        numGoals.setText("Balanço (" + realm.where(Goal.class).count() + ")");

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();

//        if(mAdapter == null) {
            List<Goal> goals = new ArrayList<Goal>(realm.where(Goal.class).findAll());

            mAdapter = new GoalAdapter(this.getActivity());
            mAdapter.setData(goals);

            mListView = (ListView) getActivity().findViewById(R.id.list_view);
            mListView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            mListView.invalidate();
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
