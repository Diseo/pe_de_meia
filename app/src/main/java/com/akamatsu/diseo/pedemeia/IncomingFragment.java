package com.akamatsu.diseo.pedemeia;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.akamatsu.diseo.pedemeia.Model.Balance;
import com.akamatsu.diseo.pedemeia.Model.Goal;
import com.akamatsu.diseo.pedemeia.Model.Transaction;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by niccapdevila on 3/26/16.
 */
public class IncomingFragment extends Fragment {

    private Realm realm;
    private Button btn;
    private EditText incomingName;
    private EditText incomingValue;

    public static IncomingFragment newInstance(int instance) {
        IncomingFragment fragment = new IncomingFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_incoming, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Novo ganho"));
        tabLayout.addTab(tabLayout.newTab().setText("Recorrentes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
//        final PagerAdapter adapter = new PagerAdapter
//                (getSupportFragmentManager(), tabLayout.getTabCount());
//        viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this.getActivity()).build();
        realm = Realm.getInstance(realmConfiguration);

        incomingName = (EditText) view.findViewById(R.id.incomingName);
        incomingValue = (EditText) view.findViewById(R.id.incomingValue);

        btn = (Button) view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (incomingName != null & incomingValue != null) {

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            Transaction incoming = realm.createObject(Transaction.class);
                            incoming.setName(incomingName.getText().toString());
                            incoming.setValue(Float.valueOf(incomingValue.getText().toString()));
                        }
                    });
                }
            }
        });

        btn.setEnabled(false); // set button disable initially

        incomingName.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

                if (s.toString().equals("")) {
                    btn.setEnabled(false);
                } else {

                    incomingValue.addTextChangedListener(new TextWatcher() {

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before,
                                                  int count) {
                            // TODO Auto-generated method stub

                            if (s.toString().equals("")) {
                                btn.setEnabled(false);
                            } else {
                                btn.setEnabled(true);
                            }
                        }

                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count,
                                                      int after) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            // TODO Auto-generated method stub

                        }
                    });
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
