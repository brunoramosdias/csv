package com.brunorasmosdias.csv.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by brunoramosdias on 06/01/17.
 */
public class Airport implements Serializable{

    private static final long serialVersionUID = -7875909662395551672L;
    private Long id;
    private String ident;
    private String type;
    private String name;
    private Float latitude_deg;
    private Float longitude_deg;
    private Float elevation_ft;
    private String continent;
    private String iso_country;
    private String iso_region;
    private String municipality;
    private String scheduled_service;
    private String gps_code;
    private String iata_code;
    private String local_code;
    private String home_link;
    private String wikipedia_link;
    private String keywords;

    private List<Runway> runways;

    public Long getId() {
        return id;
    }

    public Airport(Long id,
                   String ident,
                   String type,
                   String name,
                   Float latitude_deg,
                   Float longitude_deg,
                   Float elevation_ft,
                   String continent,
                   String iso_country,
                   String iso_region,
                   String municipality,
                   String scheduled_service,
                   String gps_code,
                   String iata_code,
                   String local_code,
                   String home_link,
                   String wikipedia_link,
                   String keywords) {
        this.id = id;
        this.ident = ident;
        this.type = type;
        this.name = name;
        this.latitude_deg = latitude_deg;
        this.longitude_deg = longitude_deg;
        this.elevation_ft = elevation_ft;
        this.continent = continent;
        this.iso_country = iso_country;
        this.iso_region = iso_region;
        this.municipality = municipality;
        this.scheduled_service = scheduled_service;
        this.gps_code = gps_code;
        this.iata_code = iata_code;
        this.local_code = local_code;
        this.home_link = home_link;
        this.wikipedia_link = wikipedia_link;
        this.keywords = keywords;
    }

    public String getIdent() {
        return ident;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Float getLatitude_deg() {
        return latitude_deg;
    }

    public Float getLongitude_deg() {
        return longitude_deg;
    }

    public Float getElevation_ft() {
        return elevation_ft;
    }

    public String getContinent() {
        return continent;
    }

    public String getIso_country() {
        return iso_country;
    }

    public String getIso_region() {
        return iso_region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getScheduled_service() {
        return scheduled_service;
    }

    public String getGps_code() {
        return gps_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public String getLocal_code() {
        return local_code;
    }

    public String getHome_link() {
        return home_link;
    }

    public String getWikipedia_link() {
        return wikipedia_link;
    }

    public String getKeywords() {
        return keywords;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public void setRunways(List<Runway> runways) {
        this.runways = runways;
    }
}
