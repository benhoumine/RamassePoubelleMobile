package com.example.greenpp.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.greenpp.Entities.Poubelle;

import java.util.ArrayList;
import java.util.List;

public class PoubelleUtils {

    public static final String BASE_URL = "http://localhost:3000/";
    public static List<Poubelle> poubelles = new ArrayList();
    public static String nomSelectionner = "";

    public PoubelleUtils() {
        System.out.println("Constructeur PoubelleUtils");
    }
    public static void makeToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    static{
        poubelles.add(new Poubelle(1L,3.0925838947296143,45.771724700927734,50.0));
        poubelles.add(new Poubelle(2L,3.1215284,45.7625999,50.0));
        poubelles.add(new Poubelle(3L,6.3016029,46.927027,50.0));
        poubelles.add(new Poubelle(4L,3.1131202,45.7572231,50.0));
        poubelles.add(new Poubelle(5L,4.418675,50.8155663,50.0));
    }

    /*public static void ajouterJardin(Poubelle jardin){
        poubelles.add(jardin);
    }

    public static void ajouterPlanToJardin(Plante p ){
        int i = 0 ;
         for(Poubelle jardin : poubelles){
             if(jardin.getNomJardin().equals(nomSelectionner)){
                 poubelles.get(i).getPlantes().add(p);
             }
             i++;
         }
    }

    public static Poubelle getJardinByName(){
        for(Poubelle jardin : poubelles){
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
            Poubelle jardin = getJardinByName() ;
            for(Plante plante : jardin.getPlantes()){
                besoinEau+= plante.getBesoinEau();
            }
            besoinEau/=jardin.getPlantes().size();
            if(besoinEau>eauInSol){
                lancer = true ;
            }
            return lancer;
    }*/

}
