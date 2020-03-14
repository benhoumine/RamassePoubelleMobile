package com.example.greenpp.Entities;

public enum TypePlante {

    HERMAPHRODITE(0L, "hermaphrodite"),
    ANGIOSPERME(1L, "Angiosperme"),
    DECORATION(2L, "DECORATION"),
    RUSTIQUE(3L, "RUSTIQUE");


    private Long identifiant;
    private String nomPlante;

    public Long getIdentifiant() {
        return identifiant;
    }

    private TypePlante(Long identifiant, String nomPlante) {
        this.identifiant = identifiant;
        this.nomPlante = nomPlante;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
    }

    public String getNomPlante() {
        return nomPlante;
    }

    public void setNomPlante(String nomPlante) {
        this.nomPlante = nomPlante;
    }


}
