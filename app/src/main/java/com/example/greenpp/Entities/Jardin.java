package com.example.greenpp.Entities;

import java.util.ArrayList;
import java.util.List;

public class Jardin {

    private Long id ;
    private String nomJardin ;
    private Long surface ;

    private List<Plante> plantes;

    public Jardin() {
        super();
        this.plantes = new ArrayList();

    }

    public Jardin(Long id, String nomJardin , Long surface) {
        super();
        this.plantes = new ArrayList();
        this.id = id;
        this.nomJardin = nomJardin;
        this.surface = surface ;
    }

    public Jardin(Long id, String nomJardin , Long surface , List<Plante> plantes ) {
        super();
        this.id = id;
        this.nomJardin = nomJardin;
        this.surface = surface ;
        this.plantes = plantes ;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomJardin() {
        return nomJardin;
    }
    public void setNomJardin(String nomJardin) {
        this.nomJardin = nomJardin;
    }
    public Long getSurface() {
        return surface;
    }
    public void setPlantes(List<Plante> plantes) {
        this.plantes = plantes;
    }
    public List<Plante> getPlantes() {
        return plantes;
    }
    public void setSurface(Long surface) {
        this.surface = surface;
    }




}
