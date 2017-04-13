package com.daijie.stuenvironment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liyujie on 2017/4/13.
 */

public class MainFragment extends Fragment {

    RecyclerView mInfoRecyclerView;

    InfoAdapter mInfoAdapter;

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        initView(view);

        return view;
    }

    private void initView(View view) {
        initRecyclerView(view);
    }

    private void initRecyclerView(View view) {
        mInfoRecyclerView = (RecyclerView) view.findViewById(R.id.infoRecyclerView);
        mInfoAdapter = new InfoAdapter();
        mInfoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
        mInfoRecyclerView.setAdapter(mInfoAdapter);
    }
}
