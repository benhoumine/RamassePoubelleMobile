package com.example.greenpp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.greenpp.Activities.MainActivity;
import com.example.greenpp.Adapter.PoubelleAdapter;
import com.example.greenpp.Entities.Poubelle;
import com.example.greenpp.Helper.Parameters;
import com.example.greenpp.Interfaces.RecyclerViewClickListener;
import com.example.greenpp.Managers.RecyclerViewManager;
import com.example.greenpp.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.Bind;

import static butterknife.ButterKnife.bind;

public class PoubelleRecycler extends Fragment implements RecyclerViewClickListener {

    MainActivity activity;
    private static final String TAG = "JardinsRecycler";
    TypeToken<List<Poubelle>> list = new TypeToken<List<Poubelle>>() {};
    public static List<Poubelle> poubelles;

    @Bind(R.id.recyclerjardin)
    RecyclerView mainRecyclerView;

    public static PoubelleAdapter adapter;


    public static PoubelleRecycler newInstance() {
        PoubelleRecycler fragment = new PoubelleRecycler();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

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


        RequestQueue queue = Volley.newRequestQueue(activity.getApplicationContext());
        String url = Parameters.URL_SERVER+Parameters.PORT+"/poubelles";
        // Request a string response from the provided URL.

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener() {

            @Override
            public void onResponse(Object response) {
                try {
                    StringBuilder formattedResult = new StringBuilder();
                    JSONObject result = ((JSONObject)response).getJSONObject("_embedded");
                    JSONArray responseJSONArray = result.getJSONArray("poubelles");
                    Gson gson = new Gson();
                    PoubelleRecycler.poubelles = gson.fromJson(responseJSONArray.toString(),  new TypeToken<List<Poubelle>>(){}.getType());
                    for(int i=0; i<poubelles.size(); i++) {
                        poubelles.get(i).setId((long)(i+1));
                        System.out.println("Poubelle " + i + " lat : " + poubelles.get(i).getLatitude() + " long : " + poubelles.get(i).getLongitude());
                        System.out.println("\n\n"+poubelles.get(i).toString());
                    }
                    activity = (MainActivity) getActivity();

                    adapter = new PoubelleAdapter(activity, PoubelleRecycler.this::recyclerViewListClicked,poubelles);
                    RecyclerViewManager.configureRecycleView(activity.getApplicationContext(), mainRecyclerView, adapter);
                    refreshRecyclerView();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("An Error occured while making the request");
            }
        });
        queue.add(jsonObjectRequest);

        /*activity = (MainActivity) getActivity();
        adapter = new PoubelleAdapter(activity, this,PoubelleRecycler.poubelles);
        RecyclerViewManager.configureRecycleView(activity.getApplicationContext(), mainRecyclerView, adapter);
        refreshRecyclerView();*/
    }

    public void refreshRecyclerView() {
        adapter.addAllItems(poubelles);
    }


    @Override
    public void recyclerViewListClicked(View v, int position) {
        System.out.println("Methode recyclerViewListClicked dans Fragment JardinRecycler");
        System.out.println("Vous avez cliqué l'element à la position : " + position);
    }
}
