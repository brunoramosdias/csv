package com.brunorasmosdias.csv.controllers;

import br.com.caelum.vraptor.*;
import com.brunorasmosdias.csv.models.Airport;
import com.brunorasmosdias.csv.models.Country;
import com.brunorasmosdias.csv.service.AirportService;
import com.brunorasmosdias.csv.service.CountryService;
import com.brunorasmosdias.csv.service.RunwayService;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by brunoramosdias on 29/12/16.
 */

@Controller
@Path("/airport")
public class AirportController {

    @Inject
   private AirportService airportService;

   @Inject
   private CountryService countryService;

   @Inject
   private RunwayService runwayService;

    @Inject
    private Result result;

    @Get("")
    public void welcome(){

    }


    @Get("/query")
    public void query(List<Country> countries){
     if(countries != null){
      result.include("countries",countries);
     }
    }

    @Post("/query/country")
    public void queryForCountry(String partialCountry){
     try {
      final List<Country> countries = countryService.filterForCodeOrName(partialCountry);
      result.redirectTo(this.getClass()).query(countries);
     } catch (IOException e) {
     }
    }

    @Get("/query/country/{countryCode}")
    public void airportsByCountry(String countryCode){
     try {
      final Optional<Country> countryOptional = countryService.find(countryCode);
      if(countryOptional.isPresent()){
       final Country country = countryOptional.map(countryObject -> {
        countryObject.setAirports(airportService.findByCountryCode(countryObject.getCode()));
        return countryObject;
       }).get();
       result.include("country",country);
      }
     } catch (IOException e) {
      result.redirectTo(this.getClass()).query(null);
     }

    }

    @Get("/query/country/{countryCode}/{airportId}")
    public void runways(String countryCode,Long airportId){
     try {
      final Optional<Country> countryOptional = countryService.find(countryCode);
      if(countryOptional.isPresent()){
       final Country country = countryOptional.map(countryObject -> {
        Optional<Airport> airportOptional = airportService.findAirport(airportId);
        if(airportOptional.isPresent()){
         final Airport airportObject = airportOptional.map(airport -> {
          try {
           airport.setRunways(runwayService.filterRunwaysByAirport(airportId));
          } catch (IOException e) {
           e.printStackTrace();
          }
          return airport;
         }).get();
         List<Airport> airports = new ArrayList<>();
         airports.add(airportObject);
         countryObject.setAirports(airports);
        }
        return countryObject;
       }).get();
       result.include("country",country);
      }
     } catch (IOException e) {
      result.redirectTo(this.getClass()).query(null);
     }

    }

}
