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
public class GoalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private Context mContext;
    private List<Goal> goals = null;

    public GoalAdapter(Context context, List<Goal> feedItemList) {
        this.goals = feedItemList;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
//        View view = new LayoutInflater(viewGroup);
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_goal, null);
            return new VHItem(view);
        } else if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_balance, null);
            return new VHHeader(view);
        }

//        CustomViewHolder viewHolder = new CustomViewHolder(view);
//        return viewHolder;
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof VHItem) {
            Goal goal = getItem(position);
            TextView tv = ((VHItem) holder).tv;
            tv.setText(goal.getName());
            //cast holder to VHItem and set data
        } else if (holder instanceof VHHeader) {
            //cast holder to VHHeader and set data for header.
        }


        //Setting text view title
//        customViewHolder.textView.setText(Html.fromHtml(feedItem.getTitle()));
    }

    @Override
    public int getItemCount() {
        return (null != goals ? goals.size() : 0) + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private Goal getItem(int position) {
        return goals.get(position - 1);
    }

    class VHItem extends RecyclerView.ViewHolder {
        TextView tv;

        public VHItem(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.goalTitle);
        }
    }

    class VHHeader extends RecyclerView.ViewHolder {
        TextView tv;

        public VHHeader(View itemView) {
            super(itemView);
//            this.tv = (TextView) itemView.findViewById(R.id.balanceTitle);
        }
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Goal goal) {
        goals.add(position, goal);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Goal goal) {
        int position = goals.indexOf(goal);
        goals.remove(position);
        notifyItemRemoved(position);
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
