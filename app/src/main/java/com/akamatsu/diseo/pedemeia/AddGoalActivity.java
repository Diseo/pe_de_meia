package com.akamatsu.diseo.pedemeia;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    private EditText goalPrice;
    private int step;
    private LinearLayout stepOne;
    private LinearLayout stepTwo;

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
//        AddGoalStep1Fragment one = new AddGoalStep1Fragment();
//        AddGoalStep1Fragment two = new AddGoalStep1Fragment();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().add(R.id.container, one).commit();
//        fm.beginTransaction().add(R.id.container, two, "step2").commit();
        nextBtn = (Button) findViewById(R.id.next_btn);
        goalName = (EditText) findViewById(R.id.goal_name_input);
        goalPrice = (EditText) findViewById(R.id.goal_price_input);

        stepOne = (LinearLayout) findViewById(R.id.stepOne);
        stepTwo = (LinearLayout) findViewById(R.id.stepTwo);
        stepTwo.setVisibility(View.GONE);

        goalPrice.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString().equals("")) {
                    nextBtn.setEnabled(false);
                } else {
                    nextBtn.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        step = 1;
    }

    public void setupClickListeners(){
        nextBtn.setOnClickListener(new ViewGroup.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (step == 1) {
                    stepTwo.setVisibility(View.VISIBLE);
                    stepOne.setVisibility(View.GONE);
                    nextBtn.setEnabled(false);
                    nextBtn.setText("CONCLUIR");
                    step = 2;
                } else {

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            Goal goal = realm.createObject(Goal.class);
                            if (goalName.getText().toString().trim().length() > 0) {
                                goal.setName(goalName.getText().toString());
                            } else {
                                goal.setName("Objetivo " + realm.where(Goal.class).findAll().size());
                            }
                            float price = Float.valueOf(goalPrice.getText().toString());
                            goal.setPrice(price);
                            goal.setDeadline(100f);
                            goal.setInvestedValue(200f);
                        }
                    });

                    finish();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close(); // Remember to close Realm when done.
    }
}
