package com.akamatsu.diseo.pedemeia;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.akamatsu.diseo.pedemeia.Model.Goal;
import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AddGoalActivity extends AppCompatActivity {

    private Realm realm;
    private Button nextBtn;
    private EditText goalName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);
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

        initInstances();
        setupClickListeners();

    }

    private void initInstances() {
        goalName = (EditText) findViewById(R.id.goal_name_input);
        nextBtn = (Button) findViewById(R.id.next_btn);
    }

    public void setupClickListeners(){
        nextBtn.setOnClickListener(new ViewGroup.OnClickListener() {
            @Override
            public void onClick(View v) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        Goal goal = realm.createObject(Goal.class);
                        if (goalName.getText().toString().trim().length() > 0) {
                            goal.setName(goalName.getText().toString());
                        } else {
                            goal.setName("Objetivo " + realm.where(Goal.class).findAll().size());
                        }
                    }
                });

                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }
}
