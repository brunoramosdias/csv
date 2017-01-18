package com.brunoramosdias.csv;

import com.brunorasmosdias.csv.models.Airport;
import com.brunorasmosdias.csv.service.AirportService;
import com.brunorasmosdias.csv.service.CountryService;
import com.brunorasmosdias.csv.service.RunwayService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by brunoramosdias on 16/01/17.
 */

public class AirportTest {


    private AirportService airportService;

    @Before
    public void setUp() throws IOException {
        airportService = new AirportService(new RunwayService());
    }

    @After
    public void tearDown(){
        airportService = null;
    }

    @Test
    public void testParseAirports() throws FileNotFoundException {
        airportService = new AirportService();
        List<Airport> airports = airportService.getAll();
        Assert.assertTrue("There where multiple records on the csv",airports.size() > 0);
        Assert.assertTrue("The first airport id was 6523",airports.get(0).getId().equals(6523L));
    }

    @Test
    public  void testGetByCountryCode(){
        final List<Airport> zwAirports = airportService.findByCountryCodeWithRunways("ZW");
        Assert.assertTrue("There are multiple airports in zimbabwe",zwAirports.size() > 1);
        Assert.assertTrue("There are 2 runways on Kwekwe East Airport",zwAirports.get(0).getRunways().size() == 2);
    }
}
