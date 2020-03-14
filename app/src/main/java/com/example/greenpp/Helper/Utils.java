package com.example.greenpp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.greenpp.Entities.Jardin;
import com.example.greenpp.Entities.Plante;
import com.example.greenpp.Entities.TypePlante;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Utils {

    public static final String BASE_URL = "http://localhost:3000/";
    public static List<Plante> plantesData = new ArrayList();
    public static List<Jardin> jardins = new ArrayList();
    public static String nomSelectionner = "";

    public static void makeToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    static{
        Plante p1 = new Plante(1L, "",20L, TypePlante.ANGIOSPERME, "sunflower") ;
        Plante p2 = new Plante(2L, "",3L, TypePlante.DECORATION, "rose") ;
        Plante p3 = new Plante(3L, "",5L, TypePlante.ANGIOSPERME, "potage") ;
        List<Plante> l1 = new ArrayList() ; l1.add(p1); l1.add(p2);
        List<Plante> l2 = new ArrayList() ; l2.add(p1); l2.add(p2);l2.add(p3);
        List<Plante> l3 = new ArrayList() ; l3.add(p1); l3.add(p3);

        jardins.add(new Jardin(1L,"Jardin le coq", 300L,l1));
        jardins.add(new Jardin(2L,"11 Janvier", 350L,l2));
        jardins.add(new Jardin(3L,"Test Jardin", 500L,l3));

    }

    public static void ajouterJardin(Jardin jardin){
        jardins.add(jardin);
    }

    public static void ajouterPlanToJardin(Plante p ){
        int i = 0 ;
         for(Jardin jardin : jardins){
             if(jardin.getNomJardin().equals(nomSelectionner)){
                 jardins.get(i).getPlantes().add(p);
             }
             i++;
         }
    }

    public static Jardin getJardinByName(){
        for(Jardin jardin : jardins){
            if(jardin.getNomJardin().equals(nomSelectionner)){
                return jardin ;
            }
        }
        return  null ;
    }


    public static boolean isLancer(){
        Random r = new Random();
            Long eauInSol = Long.parseLong(String.valueOf(r.nextInt(13)));
            boolean lancer = false;
            Long besoinEau = 0L ;
            Jardin jardin = getJardinByName() ;
            for(Plante plante : jardin.getPlantes()){
                besoinEau+= plante.getBesoinEau();
            }
            besoinEau/=jardin.getPlantes().size();
            if(besoinEau>eauInSol){
                lancer = true ;
            }
            return lancer;
    }

}
