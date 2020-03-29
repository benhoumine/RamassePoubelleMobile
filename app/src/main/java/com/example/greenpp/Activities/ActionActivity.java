package com.example.greenpp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class ActionActivity extends AppCompatActivity {

    private Button buttonVider;
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
            this.poubelle.setCapacity(0.0);
            //Update capacity in bdd


            String url = Parameters.URL_SERVER+Parameters.PORT+"/poubelles/save?id="+this.poubelle.getId().toString();
            RequestQueue queue = Volley.newRequestQueue(this.getApplicationContext());

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    /*Poubelle poubelle = new Poubelle();
                    boolean res = employe.authentification(JsonParser.JsonBenevoleArray(response));
                    if(res){
                        System.out.println("Poubelle mis à jour !!!");

                    }else{
                        System.out.println("Errrrrrrrrrrrrrrrrrrrrooooooooooooooooor");
                    }*/
                    System.out.println("Response : " + response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error);
                }
            });

            queue.add(stringRequest);


        });
    }
}
