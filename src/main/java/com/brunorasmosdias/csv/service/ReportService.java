package com.brunorasmosdias.csv.service;

import com.brunorasmosdias.csv.models.Airport;
import com.brunorasmosdias.csv.models.Country;
import com.brunorasmosdias.csv.models.Runway;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

import static java.util.Comparator.comparing;

/**
 * Created by brunoramosdias on 16/01/17.
 */
@Singleton
public class ReportService {

    @Inject
   private AirportService airportService;

    @Inject
   private RunwayService runwayService;

    @Inject
    private CountryService countryService;

    //For Unit Testing Purposes
    public ReportService(AirportService airportService, RunwayService runwayService, CountryService countryService) {
        this.airportService = airportService;
        this.runwayService = runwayService;
        this.countryService = countryService;
    }

    public ReportService() {
    }

    public List<Country> findCountrysWithMostAirports() throws IOException {
        final List<Country> countries = countryService.getAll().stream().map(country -> {
            final List<Airport> airports = airportService.findByCountryCodeWithRunways(country.getCode());
            final List<String> surfaces = getSurfacesFromAirports(airports);
            country.setSurfaces(surfaces);
            country.setAirports(airports);
            return country;
        }).collect(Collectors.toList());
        Comparator<Country> countryComparator = Comparator.comparing(country -> country.getAirportCount());
        Collections.sort(countries,countryComparator.reversed());
        return countries.subList(0,10);
    }

    private List<String> getSurfacesFromAirports(List<Airport> airports) {
        if(airports.isEmpty()){
            return Collections.emptyList();
        }
        final List<List<Runway>> lists = airports.stream().map(airport -> airport.getRunways()).
                filter(runways -> !runways.isEmpty()).collect(Collectors.toList());
        return lists.stream().flatMap(List::stream).map(runway -> runway.getSurface()).distinct().collect(Collectors.toList());
    }

    public List<Country> findCountrysWithLessAirports() throws IOException {
        final List<Country> countries = countryService.getAll().stream().map(country -> {
            final List<Airport> airports = airportService.findByCountryCodeWithRunways(country.getCode());
            final List<String> surfaces = getSurfacesFromAirports(airports);
            country.setAirports(airports);
            country.setSurfaces(surfaces);
            return country;
        }).collect(Collectors.toList());
        Comparator<Country> countryComparator = Comparator.comparing(country -> country.getAirportCount());
        Collections.sort(countries,countryComparator);
        return countries.subList(0,10);
    }

    public void findTheMosComonLeIdent(){

    }

}
