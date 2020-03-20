package com.example.greenpp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeFragment extends Fragment {

    MainActivity activity;
    private View view;
    private static final String TAG = "WelcomeFragment";

    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("Fragment Welcome");
        view = inflater.inflate(R.layout.welcome_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        ButterKnife.bind(this, view);
        activity = (MainActivity) getActivity();
    }

    @OnClick(R.id.start_btn)
    public void start(View view) {
        Log.i(TAG, "start: Clicked");
        activity.navigateTo(PoubelleRecycler.newInstance());
    }
}
