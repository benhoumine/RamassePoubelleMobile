package com.example.greenpp.Activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.greenpp.Fragments.SignInFragement;
import com.example.greenpp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Activité Login");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        navigateTo(SignInFragement.newInstance());
    }

    public void navigateTo(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(fragment.getClass().toString());
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }


}
