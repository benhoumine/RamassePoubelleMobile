package com.example.greenpp.Helper;

import com.example.greenpp.Entities.Employe;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class JsonParser {


    public String JsonParser(String reponse) {

        return "Hello";
    }


    public static ArrayList<Employe> JsonBenevoleArray(String Reponse) {
        ArrayList<Employe> Allbenevole  = new ArrayList<Employe>();

        try{

            JSONObject jsonObj = new JSONObject(Reponse);

            // Getting JSON Array node
            // looping through All Contacts
                Long id = jsonObj.getLong("id");
                String nom = jsonObj.getString("nom");
                String prenom = jsonObj.getString("prenom");
                String poste = jsonObj.getString("poste");
                Allbenevole.add(new Employe(id,nom,prenom,poste));

        }catch(Exception e){

            e.printStackTrace();
        }
            return Allbenevole;
    }


}
