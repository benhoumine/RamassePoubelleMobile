package com.example.greenpp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Entities.Plante;
import com.example.greenpp.Helper.Utils;
import com.example.greenpp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.internal.Util;

import static com.example.greenpp.Helper.Utils.makeToast;

public class AddPlantFragment extends Fragment {

    MainActivity activity;
    private View view;
    private static final String TAG = "AddPlantFragment";

    @Bind(R.id.text_plant_name)
    EditText plantName;

    public static AddPlantFragment newInstance() {
        AddPlantFragment fragment = new AddPlantFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("Fragment AddPlant?");
        view = inflater.inflate(R.layout.add_plant_fragement, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        ButterKnife.bind(this, view);
        activity = (MainActivity) getActivity();
    }

    @OnClick(R.id.save_plant_btn)
    public void savePlant(View view) {
        String name = plantName.getText().toString();
        if (!name.trim().equals("")) {
            Utils.plantesData.add(new Plante(name));
            activity.navigateTo(PlantsRecycler.newInstance());
            PlantsRecycler.adapter.addAllItems(Utils.plantesData);
        } else {
            makeToast(activity.getApplicationContext(), "Enter Plant Name");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
