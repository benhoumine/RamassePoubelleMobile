package com.example.greenpp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.greenpp.Entities.Poubelle;
import com.example.greenpp.Helper.Parameters;
import com.example.greenpp.R;

import java.util.HashMap;
import java.util.Map;

public class NouvellePoubelleActivity extends AppCompatActivity {

    Button buttonAjouter;
    EditText editTextAdresse;
    EditText editTextCapacite;
    EditText editTextLatitude;
    EditText editTextLongitude;
    Poubelle nouvellePoubelle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_poubelle);

        editTextAdresse = (EditText) findViewById(R.id.editTextAdresse);
        editTextCapacite = (EditText) findViewById(R.id.editTextCapacité);
        editTextLatitude = (EditText) findViewById(R.id.editTextLatitude);
        editTextLongitude = (EditText) findViewById(R.id.editTextLongitude);

        buttonAjouter = (Button) findViewById(R.id.buttonAjouter);
        buttonAjouter.setOnClickListener(view -> {
            //Enregistrement de la poubelle
            this.nouvellePoubelle = new Poubelle(1L,
                    Double.parseDouble(editTextLongitude.getText().toString()),
                    Double.parseDouble(editTextLatitude.getText().toString()),
                    Double.parseDouble(editTextCapacite.getText().toString()),
                    editTextAdresse.getText().toString(),
                    0.0
            );

            System.out.println("Poubelle à enregistrer : " + this.nouvellePoubelle.toString());


            RequestQueue queue = Volley.newRequestQueue(NouvellePoubelleActivity.this);
            String url = Parameters.URL_SERVER+Parameters.PORT+"/poubelles/nouvelle";
            StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response) {
                            // response
                            Log.d("Response", response);
                            //Rédirection MainActivity
                            Intent intent = new Intent(NouvellePoubelleActivity.this, MainActivity.class);
                            NouvellePoubelleActivity.this.startActivity(intent);
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
                    params.put("poubelle",NouvellePoubelleActivity.this.nouvellePoubelle.toString());
                    return params;
                }
            };
            queue.add(postRequest);

        });
    }
}
