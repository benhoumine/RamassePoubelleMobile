package com.example.greenpp.Entities;

import java.io.Serializable;

public class Plante implements Serializable {

    private Long id ;

    private String caractertique;
    private Long besoinEau;
    private TypePlante typePlante ;
    private String nomPlante ;

    private Jardin jardin  ;


    public Long getId() {
        return id;
    }

    public Plante(String name){
        super();
        this.nomPlante = name ;
        this.besoinEau = 15L ;
        this.typePlante = TypePlante.ANGIOSPERME;

    }
    public Plante() {
        super();
    }

    public Plante(Long id, String caractertique,Long besoinEau, TypePlante typePlante, String nomPlanent) {
        super();
        this.id = id;
        this.caractertique = caractertique;
        this.besoinEau = besoinEau;
        this.typePlante = typePlante;
        this.nomPlante= nomPlanent;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCaractertique() {
        return caractertique;
    }
    public void setCaractertique(String caractertique) {
        this.caractertique= caractertique;
    }
    public void setBesoinEau(Long besoinEau) {this.besoinEau = besoinEau;}
    public Long getBesoinEau() {return this.besoinEau;}
    public TypePlante getTypePlante() {
        return typePlante;
    }
    public void setTypePlante(TypePlante typePlante) {
        this.typePlante = typePlante;
    }
    public String getNomPlante() {
        return nomPlante;
    }
    public void setNomPlante(String nomPlanent) {
        this.nomPlante = nomPlanent;
    }
}

