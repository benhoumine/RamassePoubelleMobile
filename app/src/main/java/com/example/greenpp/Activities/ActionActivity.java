package com.example.greenpp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.greenpp.Entities.Poubelle;
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


            /*String url = Parameters.URL_SERVER+Parameters.PORT+"/poubelles/savepoubelle";
            RequestQueue queue = Volley.newRequestQueue(this);
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            System.out.println("Yesssssss!");

                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            System.out.println(error);

                        }
                    }
            ) {
                @Override
                protected Map<String, String> getParams()
                {
                    Map<String, String> params = new HashMap<>();
                    params.put("poubelle", ActionActivity.this.poubelle.toString());
                    System.out.println("parameter :"+params);
                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap headers = new HashMap();
                    headers.put("Content-Type","application/x-www-form-urlencoded");
                    return headers;

                }
            };
            queue.add(postRequest);*/


        });
    }
}
