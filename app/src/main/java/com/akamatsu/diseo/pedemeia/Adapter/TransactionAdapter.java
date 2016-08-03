package com.akamatsu.diseo.pedemeia.Adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.akamatsu.diseo.pedemeia.Font.DisplayTextView;
import com.akamatsu.diseo.pedemeia.Model.Goal;
import com.akamatsu.diseo.pedemeia.Model.Transaction;
import com.akamatsu.diseo.pedemeia.R;

import java.util.List;

/**
 * Created by Avell B155 on 13/07/16.
 */
public class TransactionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<Transaction> transactions = null;

    public TransactionAdapter(Context context, List<Transaction> feedItemList) {
        this.transactions = feedItemList;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.balance_item, null);
        return new VHItem(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Transaction transaction = getItem(position);
        DisplayTextView transactionName = ((VHItem) holder).transactionName;
        transactionName.setText(transaction.getName());
        DisplayTextView transactionValue = ((VHItem) holder).transactionValue;
        transactionValue.setText("R$" + transaction.getValue());
    }

    @Override
    public int getItemCount() {
        return (null != transactions ? transactions.size() : 0);
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    private Transaction getItem(int position) {
        if (transactions == null || transactions.get(position) == null) {
            return null;
        }
        return transactions.get(position);
    }

    class VHItem extends RecyclerView.ViewHolder {
        DisplayTextView transactionName;
        DisplayTextView transactionValue;

        public VHItem(View itemView) {
            super(itemView);
            this.transactionName = (DisplayTextView) itemView.findViewById(R.id.transactionName);
            this.transactionValue = (DisplayTextView) itemView.findViewById(R.id.transactionValue);
        }
    }
}