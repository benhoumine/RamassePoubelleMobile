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
import com.example.greenpp.Adapter.JardinAdapter;
import com.example.greenpp.Adapter.PlantAdapter;
import com.example.greenpp.Helper.Utils;
import com.example.greenpp.Interfaces.RecyclerViewClickListener;
import com.example.greenpp.Managers.RecyclerViewManager;
import com.example.greenpp.R;

import butterknife.Bind;
import butterknife.OnClick;

import static butterknife.ButterKnife.bind;

public class JardinRecycler extends Fragment implements RecyclerViewClickListener {

    MainActivity activity;
    private static final String TAG = "JardinsRecycler";

    @Bind(R.id.recyclerjardin)
    RecyclerView mainRecyclerView;

    public static JardinAdapter adapter;


    public static JardinRecycler newInstance() {
        JardinRecycler fragment = new JardinRecycler();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("FragmentJardinRecycler");
        View view = inflater.inflate(R.layout.jardins_recycler_fragement, container, false);
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
        adapter = new JardinAdapter(activity, this,Utils.jardins);
        RecyclerViewManager.configureRecycleView(activity.getApplicationContext(), mainRecyclerView, adapter);
        refreshRecyclerView();
    }

    public void refreshRecyclerView() {
        adapter.addAllItems(Utils.jardins);
    }


    @Override
    public void recyclerViewListClicked(View v, int position) {
        System.out.println("Methode recyclerViewListClicked dans Fragment JardinRecycler");
        System.out.println("Vous avez cliqué l'element à la position : " + position);
    }
}
