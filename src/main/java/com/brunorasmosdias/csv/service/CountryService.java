package com.brunorasmosdias.csv.service;

import com.brunorasmosdias.csv.models.Airport;
import com.brunorasmosdias.csv.models.Country;
import com.opencsv.CSVReader;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by brunoramosdias on 16/01/17.
 */

@Singleton
public class CountryService {


    @Inject
    AirportService airportService;

    @Inject
    RunwayService runwayService;

    private final List<Country> countries;


    //For Unit Testing Purposes
    public CountryService(AirportService airportService, RunwayService runwayService) throws IOException {
        this.airportService = airportService;
        this.runwayService = runwayService;
        countries = getAll();
    }

    public CountryService() throws IOException {
        countries = getAll();
    }

    public List<Country> getAll() throws IOException {
        try {
            File  countryFile =  new File(getClass().getClassLoader().getResource("countries.csv").getFile());
            CSVReader csvReader = new CSVReader(new FileReader(countryFile));
            final List<String[]> strings = csvReader.readAll();
            List<Country> countries = parseCountries(strings);
            return countries;
        } catch (IOException e) {
            throw  e;
        }

    }

    private List<Country> parseCountries(List<String[]> strings) {
        strings.remove(0);
     return    strings.stream().map(countryData -> new Country(Long.parseLong(countryData[0]),
                                    countryData[1],
                                    countryData[2],
                                    countryData[3],
                                    countryData[4],
                                    countryData[5])).collect(Collectors.toList());
    }

    public List<Country> filterForCodeOrName(String codeOrCountryName) throws IOException {
        return countries.stream()
                .filter(country -> country.getCode().toLowerCase().contains(codeOrCountryName.toLowerCase())
                        || country.getName().toLowerCase().contains(codeOrCountryName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Optional<Country> find(String code) throws IOException {
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst();
    }


    public List<Country> queryForString(String codeOrCountryName) throws IOException {
        try {
         return    filterForCodeOrName(codeOrCountryName).stream().map(country -> {
                final List<Airport> byCountryCode = airportService.findByCountryCode(country.getCode())
                        .stream().map(airport -> {
                            try {
                                airport.setRunways(runwayService.filterRunwaysByAirport(airport.getId()));
                            } catch (IOException e) {
                                airport.setRunways(Collections.emptyList());
                            }
                            return airport;
                        }).collect(Collectors.toList());
                country.setAirports(byCountryCode);
                return country;
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
