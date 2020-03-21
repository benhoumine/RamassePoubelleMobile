package com.example.greenpp.Entities;

public class Poubelle {
    private static final long serialVersionUID = 1L;

    private Long id  ;
    private Double longitude ;
    private Double latitude ;
    private Double capacity ;
    private String adresse;
    private Double contenu;

    public Poubelle(Long id, Double longitude, Double latitude, Double capacity, String adresse, Double contenu) {
        super();
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.capacity = capacity;
        this.adresse = adresse;
        this.contenu = contenu;
    }

    public Poubelle(Long id, Double longitude, Double latitude, Double capacity, String adresse) {
        super();
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.capacity = capacity;
        this.adresse = adresse;
    }

    public Poubelle() {
    }
    public Poubelle(Long id, Double longitude, Double latitude, Double capacity) {
        super();
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.capacity = capacity;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getCapacity() {
        return capacity;
    }
    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getContenu() {
        return contenu;
    }

    public void setContenu(Double contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Poubelle{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", capacity=" + capacity +
                ", adresse='" + adresse + '\'' +
                ", contenu=" + contenu +
                '}';
    }
}
