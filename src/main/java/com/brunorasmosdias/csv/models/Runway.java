package com.brunorasmosdias.csv.models;

import java.io.Serializable;

/**
 * Created by brunoramosdias on 06/01/17.
 */
public class Runway implements Serializable{

    private static final long serialVersionUID = -108144952982493089L;

    private Long id;
    private Long airport_ref;
    private String airport_ident;
    private Double length_ft;
    private Double width_ft;
    private String surface;
    private boolean lighted;
    private boolean closed;
    private String le_ident;
    private Float le_latitude_deg;
    private Float le_longitude_deg;
    private Double le_elevation_ft;
    private Float le_heading_degT;
    private String le_displaced_threshold_ft;
    private String he_ident;
    private String he_latitude_deg;
    private String he_longitude_deg;
    private String he_elevation_ft;
    private String he_heading_degT;
    private String he_displaced_threshold_ft;

    public Runway(Long id,
                  Long airport_ref,
                  String airport_ident,
                  Double length_ft,
                  Double width_ft,
                  String surface,
                  boolean lighted,
                  boolean closed,
                  String le_ident,
                  Float le_latitude_deg,
                  Float le_longitude_deg,
                  Double le_elevation_ft,
                  Float le_heading_degT,
                  String le_displaced_threshold_ft,
                  String he_ident,
                  String he_latitude_deg,
                  String he_longitude_deg,
                  String he_elevation_ft,
                  String he_heading_degT,
                  String he_displaced_threshold_ft) {
        this.id = id;
        this.airport_ref = airport_ref;
        this.airport_ident = airport_ident;
        this.length_ft = length_ft;
        this.width_ft = width_ft;
        this.surface = surface;
        this.lighted = lighted;
        this.closed = closed;
        this.le_ident = le_ident;
        this.le_latitude_deg = le_latitude_deg;
        this.le_longitude_deg = le_longitude_deg;
        this.le_elevation_ft = le_elevation_ft;
        this.le_heading_degT = le_heading_degT;
        this.le_displaced_threshold_ft = le_displaced_threshold_ft;
        this.he_ident = he_ident;
        this.he_latitude_deg = he_latitude_deg;
        this.he_longitude_deg = he_longitude_deg;
        this.he_elevation_ft = he_elevation_ft;
        this.he_heading_degT = he_heading_degT;
        this.he_displaced_threshold_ft = he_displaced_threshold_ft;
    }

    public Long getId() {
        return id;
    }

    public Long getAirport_ref() {
        return airport_ref;
    }

    public String getAirport_ident() {
        return airport_ident;
    }

    public Double getLength_ft() {
        return length_ft;
    }

    public Double getWidth_ft() {
        return width_ft;
    }

    public String getSurface() {
        return surface;
    }

    public boolean isLighted() {
        return lighted;
    }

    public boolean isClosed() {
        return closed;
    }

    public String getLe_ident() {
        return le_ident;
    }

    public Float getLe_latitude_deg() {
        return le_latitude_deg;
    }

    public Float getLe_longitude_deg() {
        return le_longitude_deg;
    }

    public Double getLe_elevation_ft() {
        return le_elevation_ft;
    }

    public Float getLe_heading_degT() {
        return le_heading_degT;
    }

    public String getLe_displaced_threshold_ft() {
        return le_displaced_threshold_ft;
    }

    public String getHe_ident() {
        return he_ident;
    }

    public String getHe_latitude_deg() {
        return he_latitude_deg;
    }

    public String getHe_longitude_deg() {
        return he_longitude_deg;
    }

    public String getHe_elevation_ft() {
        return he_elevation_ft;
    }

    public String getHe_heading_degT() {
        return he_heading_degT;
    }

    public String getHe_displaced_threshold_ft() {
        return he_displaced_threshold_ft;
    }
}
