package com.daijie.stuenvironment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by liyujie on 2017/4/13.
 */

public class MainFragment extends Fragment {

    RecyclerView mInfoRecyclerView;

    InfoAdapter mInfoAdapter;

    Dormitory mDormitory;

    private static final String EXTRA_DORMITORY = "Dormitory";

    public static MainFragment newInstance(Dormitory dormitory) {
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DORMITORY, dormitory);
        mainFragment.setArguments(args);
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        mDormitory = (Dormitory) args.get(EXTRA_DORMITORY);
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
        mInfoAdapter = new InfoAdapter(getContext(), mDormitory.getEnvironmentInfos());
        mInfoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.VERTICAL, false));
        mInfoRecyclerView.setAdapter(mInfoAdapter);
        mInfoAdapter.setOnItemClickListener(new InfoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(EnvironmentInfo environmentInfo, int position) {
                Toast.makeText(getContext(), environmentInfo.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
