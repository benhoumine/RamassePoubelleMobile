package com.example.greenpp.Fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.greenpp.Activities.LoginActivity;
import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Entities.Employe;
import com.example.greenpp.Helper.JsonParser;
import com.example.greenpp.Helper.Parameters;
import com.example.greenpp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.greenpp.Helper.Utils.makeToast;

public class SignInFragement extends Fragment {

    LoginActivity activity;
    private View view;



    @Bind(R.id.codeemp)
    EditText login;


    private static final String TAG = "SignInFragement";

    public static SignInFragement newInstance() {
        SignInFragement fragment = new SignInFragement();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sign_in_fragement, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Lunched");
        ButterKnife.bind(this, view);
        activity = (LoginActivity) getActivity();
    }

    @OnClick(R.id.login_button)
    public void login(View view) {
        String name = login.getText().toString();

        if (name.trim().equals("")) {
            makeToast(activity.getApplicationContext(), "SVP, VOTRE CODE EMPLOYE.");
        } else {
            attemptLogin();
        }
    }




    private void attemptLogin() {
        // Store values at the time of the login attempt.
        final String email = this.login.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(activity.getApplicationContext());
        String url = Parameters.URL_SERVER+Parameters.PORT+"/connexion/login?id="+email;
                // Request a string response from the provided URL.

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Employe employe = new Employe(Long.parseLong(email));
                            boolean res = employe.authentification(JsonParser.JsonBenevoleArray(response));
                            if(res){
                                Intent intent = new Intent(activity, MainActivity.class);
                                activity.startActivity(intent);
                                activity.finish();

                            }else{
                                makeToast(activity.getApplicationContext(), "erreur de la connexion.");
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                   makeToast(activity.getApplicationContext(), "Erreur "+error);
                }
            });

            queue.add(stringRequest);
        }
}
