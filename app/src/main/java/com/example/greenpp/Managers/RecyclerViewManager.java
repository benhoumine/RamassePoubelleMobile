package com.example.greenpp.Managers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.greenpp.Adapter.PlantAdapter;

public class RecyclerViewManager {

    public static void configureRecycleView(Context context, RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
}
