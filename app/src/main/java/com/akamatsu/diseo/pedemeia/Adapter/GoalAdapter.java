package com.akamatsu.diseo.pedemeia.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.CustomViewHolder>{
    private Context mContext;
    private List<Goal> goals = null;

    public GoalAdapter(Context context, List<Goal> feedItemList) {
        this.goals = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_goal, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Goal goal = goals.get(i);

        customViewHolder.tv.setText(goal.getName());

        //Setting text view title
//        customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));
    }

    @Override
    public int getItemCount() {
        return (null != goals ? goals.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv;

        public CustomViewHolder(View view) {
            super(view);
            this.tv = (TextView) view.findViewById(R.id.goalTitle);
        }
    }
}


//    public void setData(List<Goal> details) {
//        this.goals = details;
//    }
//
//    @Override
//    public int getItemCount() {
//        if (goals == null) {
//            return 0;
//        }
//        return goals.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        if (goals == null || goals.get(position) == null) {
//            return null;
//        }
//        return goals.get(position);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int position, View currentView, ViewGroup parent) {
//        if (currentView == null) {
//            currentView = inflater.inflate(R.layout.card_goal, parent, false);
//        }
//
//        Goal goal = goals.get(position);
//
//        if (goal != null) {
//            ((TextView) currentView.findViewById(R.id.goalTitle)).setText(goal.getName());
//        }
//
//        return currentView;
//    }
//}
