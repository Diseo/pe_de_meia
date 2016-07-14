package com.akamatsu.diseo.pedemeia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.akamatsu.diseo.pedemeia.Model.Goal;
import com.akamatsu.diseo.pedemeia.R;

import java.util.List;

/**
 * Created by Avell B155 on 13/07/16.
 */
public class GoalAdapter extends BaseAdapter{
    private LayoutInflater inflater;

    private List<Goal> goals = null;

    public GoalAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Goal> details) {
        this.goals = details;
    }

    @Override
    public int getCount() {
        if (goals == null) {
            return 0;
        }
        return goals.size();
    }

    @Override
    public Object getItem(int position) {
        if (goals == null || goals.get(position) == null) {
            return null;
        }
        return goals.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent) {
        if (currentView == null) {
            currentView = inflater.inflate(R.layout.card_goal, parent, false);
        }

        Goal goal = goals.get(position);

        if (goal != null) {
            ((TextView) currentView.findViewById(R.id.goalTitle)).setText(goal.getName());
        }

        return currentView;
    }
}
