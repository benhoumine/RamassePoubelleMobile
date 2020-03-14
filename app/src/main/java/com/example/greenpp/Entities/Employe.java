package com.example.greenpp.Entities;

import java.util.ArrayList;

public class Employe {
    private Long id ;
    private String nom;
    private String prenom;
    private String poste;

    public Employe(){

    }

    public Employe(Long id){
             this.id= id ;
    }


    public Employe(Long id, String nom, String prenom, String poste) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }


    public boolean authentification(ArrayList<Employe> employes){

        int i = 0;
        boolean existe = false ;

        while(!existe && i<employes.size()){
            if(employes.get(i).getId().equals(this.id)){
                existe = true;
            }
            i++;
        }

        return existe ;
    }

}
