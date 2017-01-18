package com.brunorasmosdias.csv.service;

import com.brunorasmosdias.csv.models.Airport;
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
 * Created by brunoramosdias on 29/12/16.
 */
@Singleton
public class AirportService {

    @Inject
    private RunwayService runwayService;


    private final List<Airport> airports;

    public AirportService() {
        airports = getAll();
    }

    public AirportService(RunwayService runwayService) {
        this.runwayService = runwayService;
        airports = getAll();
    }

    public List<Airport> getAll(){
        try {
           File aiportFile =  new File(getClass().getClassLoader().getResource("airports.csv").getFile());
           CSVReader csvReader = new CSVReader(new FileReader(aiportFile));
            final List<String[]> strings = csvReader.readAll();
            return parseAirports(strings);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<Airport> parseAirports(List<String[]> strings) {
        strings.remove(0);
        return strings.parallelStream().map(airportData -> new Airport(Long.parseLong(airportData[0]),
                                      airportData[1],
                                      airportData[2],
                                      airportData[3],
                                      Float.parseFloat(airportData[4]),
                                      Float.parseFloat(airportData[5]),
                                      null,
                                      airportData[7],
                                      airportData[8],
                                      airportData[9],
                                      airportData[10],
                                      airportData[11],
                                      airportData[12],
                                      airportData[13],
                                      airportData[14],
                                      airportData[15],
                                      airportData[16],
                                      airportData[17])).collect(Collectors.toList());
    }




    public List<Airport> findByCountryCode(String countryCode){
       return airports.stream().filter(airport -> airport.getIso_country().equals(countryCode)).collect(Collectors.toList());
    }

    public List<Airport> findByCountryCodeWithRunways(String countryCode) {
        return findByCountryCode(countryCode).stream().map(airport -> {
            try {
                airport.setRunways(runwayService.filterRunwaysByAirport(airport.getId()));
            } catch (IOException e) {
                airport.setRunways(Collections.emptyList());
            }
            return airport;
        }).collect(Collectors.toList());
    }

    public Optional<Airport> findAirport(Long airportId) {
        return airports.stream().filter(airport -> airport.getId().equals(airportId)).findFirst();
    }
}
