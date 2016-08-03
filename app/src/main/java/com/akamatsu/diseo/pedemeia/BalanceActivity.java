package com.akamatsu.diseo.pedemeia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.akamatsu.diseo.pedemeia.Adapter.GoalAdapter;
import com.akamatsu.diseo.pedemeia.Adapter.TransactionAdapter;
import com.akamatsu.diseo.pedemeia.Model.Goal;
import com.akamatsu.diseo.pedemeia.Model.Transaction;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BalanceActivity extends AppCompatActivity {

    private Realm realm;
    private RecyclerView mRecyclerView;
    private TransactionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assert toolbar != null;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(realmConfiguration);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        final List<Transaction> transactions = new ArrayList<>(realm.where(Transaction.class).findAll());
        adapter = new TransactionAdapter(this, transactions);
        mRecyclerView.setAdapter(adapter);

        initInstances();
        setupClickListeners();
    }

    private void initInstances() {

    }

    public void setupClickListeners() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }
}
