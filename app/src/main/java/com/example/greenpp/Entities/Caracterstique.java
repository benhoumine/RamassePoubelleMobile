package com.example.greenpp.Entities;

public class Caracterstique {

    private Long id ;
    private Long dureeDeVie ;
    private Long besoinDEau ;
    private Long luminisote ;

    public Caracterstique(Long id, Long dureeDeVie, Long besoinDEau, Long luminisote) {
        super();
        this.id = id;
        this.dureeDeVie = dureeDeVie;
        this.besoinDEau = besoinDEau;
        this.luminisote = luminisote;
    }

    public Caracterstique() {
        super();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getDureeDeVie() {
        return dureeDeVie;
    }
    public void setDureeDeVie(Long dureeDeVie) {
        this.dureeDeVie = dureeDeVie;
    }
    public Long getBesoinDEau() {
        return besoinDEau;
    }
    public void setBesoinDEau(Long besoinDEau) {
        this.besoinDEau = besoinDEau;
    }
    public Long getLuminisote() {
        return luminisote;
    }
    public void setLuminisote(Long luminisote) {
        this.luminisote = luminisote;
    }


}

