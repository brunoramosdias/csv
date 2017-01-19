package com.brunorasmosdias.csv.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by brunoramosdias on 06/01/17.
 */
public class Country implements Serializable{

    private static final long serialVersionUID = -3563174547490602905L;
    private Long id;
    private String code;
    private String name;
    private String continent;
    private String wikipedia_link;
    private String keywords;
    private List<Airport> airports;
    private int airportCount;
    private List<String> surfaces;

    public Country(Long id, String code, String name, String continent, String wikipedia_link, String keywords) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.wikipedia_link = wikipedia_link;
        this.keywords = keywords;
        this.airportCount = 0;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getWikipedia_link() {
        return wikipedia_link;
    }

    public String getKeywords() {
        return keywords;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
        if(airports != null){
            airportCount = airports.size();
        }
    }

    public int getAirportCount() {
        return airportCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (!getId().equals(country.getId())) return false;
        if (!getCode().equals(country.getCode())) return false;
        return getName().equals(country.getName());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getCode().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    public List<String> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<String> surfaces) {
        this.surfaces = surfaces;
    }
}
