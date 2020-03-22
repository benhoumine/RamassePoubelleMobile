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
        });
    }
}
