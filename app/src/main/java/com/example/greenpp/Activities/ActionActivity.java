package com.example.greenpp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.greenpp.Entities.Poubelle;
import com.example.greenpp.Helper.Parameters;
import com.example.greenpp.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class ActionActivity extends AppCompatActivity {

    private Button buttonVider;
    private Button nouvellePoubelle;
    private Poubelle poubelle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        String poubelleJson = getIntent().getExtras().getString("POUBELLE_JSON");
        Gson gson = new Gson();
        this.poubelle = gson.fromJson(poubelleJson, Poubelle.class);
        this.buttonVider = (Button) findViewById(R.id.buttonVider);
        buttonVider.setOnClickListener(view -> {

            RequestQueue queue = Volley.newRequestQueue(ActionActivity.this);
            String url = Parameters.URL_SERVER+Parameters.PORT+"/poubelles/vider";
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                            Intent intent = new Intent(ActionActivity.this, MainActivity.class);
                            ActionActivity.this.startActivity(intent);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // error
                            Log.d("error", String.valueOf(error));
                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String> params = new HashMap<>();
                    System.out.println("Poubelle à vider : " + ActionActivity.this.poubelle.getId().toString());
                    params.put("id",ActionActivity.this.poubelle.getId().toString());
                    return params;
                }
            };
            queue.add(postRequest);


        });

        this.nouvellePoubelle = (Button) findViewById(R.id.buttonNouvelePoubelle);
        this.nouvellePoubelle.setOnClickListener(view -> {
            Intent intent = new Intent(ActionActivity.this, NouvellePoubelleActivity.class);
            ActionActivity.this.startActivity(intent);
        });

    }


    public void onClickButton(View view) {
        System.out.println("helo clicked");
        RequestQueue queue = Volley.newRequestQueue(ActionActivity.this);
        String url = Parameters.URL_SERVER+Parameters.PORT+"/poubelles/testpost";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("error", String.valueOf(error));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("id","1");
                return params;
            }
        };
        queue.add(postRequest);
    }
}
