package com.brunoramosdias.csv;

import com.brunorasmosdias.csv.models.Country;
import com.brunorasmosdias.csv.service.AirportService;
import com.brunorasmosdias.csv.service.CountryService;
import com.brunorasmosdias.csv.service.ReportService;
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
public class ReportTest {

    private ReportService reportService;

    @Before
    public void setUp() throws IOException {
        reportService = new ReportService(new AirportService(),new RunwayService(),new CountryService());
    }

    @After
    public void tearDown(){
        reportService = null;
    }

    @Test
    public void testReportsMostAirports() throws IOException {
        final List<Country> countrysWithMostAirports = reportService.findCountrysWithMostAirports();
        Assert.assertTrue("the list must bring 10 countrys", countrysWithMostAirports.size() == 10);
        Assert.assertTrue("The first Country on the list must have more airports than the other or the same as the " +
                "second", countrysWithMostAirports.get(0).getAirports().size() >=
                countrysWithMostAirports.get(1).getAirports().size());
    }

    @Test
    public void testReportLessAirports() throws IOException {
        final List<Country> countrysWithLessAirports = reportService.findCountrysWithLessAirports();
        Assert.assertTrue("the list must bring 10 countrys", countrysWithLessAirports.size() == 10);
        Assert.assertTrue("The first Country on the list must have less airports than the other or the same as the " +
                "seconde", countrysWithLessAirports.get(0).getAirports().size() <=
                countrysWithLessAirports.get(1).getAirports().size());
    }

}
