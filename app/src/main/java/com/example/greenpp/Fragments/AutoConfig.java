package com.example.greenpp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Helper.Utils;
import com.example.greenpp.Notification.BuildNotification;
import com.example.greenpp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AutoConfig extends Fragment {
    
    private BuildNotification buildNotification;
    MainActivity activity;
    private View view;
    private static final String TAG = "AutoConfig";

    @Bind(R.id.auto_config)
    SwitchCompat switchCompat;

    public static AutoConfig newInstance() {
        AutoConfig fragment = new AutoConfig();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.auto_config_fragement, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        ButterKnife.bind(this, view);
        activity = (MainActivity) getActivity();
        init();
    }

    private void init() {
        buildNotification = new BuildNotification(NotificationManagerCompat.from(activity.getApplicationContext()),
                activity.getApplicationContext(),
                MainActivity.class);
        switchCompat.setChecked(true);
        if (Utils.isLancer()) {
            BuildNotification.NOTIFICATION_DESCRIPTION = BuildNotification.NOTIFICATION_DESCRIPTION = "Automatic watering enabled. Watering will be lunched immidiately";
        } else {
            BuildNotification.NOTIFICATION_DESCRIPTION = BuildNotification.NOTIFICATION_DESCRIPTION = "Automatic watering enabled. Next Operation will take in 2 hours.";
        }
        buildNotification.displayNotification();
    }
}
