package com.example.greenpp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Adapter.PlantAdapter;
import com.example.greenpp.Helper.Utils;
import com.example.greenpp.Managers.RecyclerViewManager;
import com.example.greenpp.R;

import butterknife.Bind;
import butterknife.OnClick;

import static butterknife.ButterKnife.bind;

public class PlantsRecycler extends Fragment {

    MainActivity activity;
    private static final String TAG = "PlantsRecycler";

    @Bind(R.id.recycler)
    RecyclerView mainRecyclerView;

    public static PlantAdapter adapter;


    public static PlantsRecycler newInstance() {
        PlantsRecycler fragment = new PlantsRecycler();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.plants_recycler_fragement, container, false);
        bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        activity = (MainActivity) getActivity();
        init();
    }

    void init() {
        activity = (MainActivity) getActivity();
        adapter = new PlantAdapter(activity, Utils.plantesData);
        RecyclerViewManager.configureRecycleView(activity.getApplicationContext(), mainRecyclerView, adapter);
        refreshRecyclerView();
    }

    public void refreshRecyclerView() {
        adapter.addAllItems(Utils.plantesData);
    }


    @OnClick(R.id.add_new_plant)
    public void addPlant(View view) {
        activity.navigateTo(AddPlantFragment.newInstance());
    }

}
