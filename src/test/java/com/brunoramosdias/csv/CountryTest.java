package com.brunoramosdias.csv;

import com.brunorasmosdias.csv.models.Country;
import com.brunorasmosdias.csv.service.AirportService;
import com.brunorasmosdias.csv.service.CountryService;
import com.brunorasmosdias.csv.service.RunwayService;
import org.junit.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by brunoramosdias on 16/01/17.
 */
public class CountryTest {

    private  CountryService countryService;

    @Before
    public void setUp() throws IOException {
         countryService = new CountryService(new AirportService(),new RunwayService());
    }

    @After
    public void tearDown(){
        countryService = null;
    }

    @Test
    public void testParseCountrys() throws IOException {
        List<Country> countries = countryService.getAll();
        Assert.assertTrue("There where multiple country Records on the csv",countries.size() > 0);
        Assert.assertTrue("the first country id was 302672", countries.get(0).getId().equals(302672L));
    }

    @Test
    public void testFilter() throws IOException{
        final List<Country> countries = countryService.filterForCodeOrName("Zimb");
        Country country = new Country(302612L,"ZW","Zimbabwe","AF","http://en.wikipedia.org/wiki/Zimbabwe","");
        Assert.assertTrue("The partial search returned Zimbabwe",countries.contains(country));
    }

    @Test
    public void testAirportByCountryName() throws IOException {
        final List<Country> countries = countryService.queryForString("zw");
        Country country = new Country(302612L,"ZW","Zimbabwe","AF","http://en.wikipedia.org/wiki/Zimbabwe","");
        Assert.assertTrue("The partial search returned Zimbabwe",countries.contains(country));
        Assert.assertTrue("The only contry with zw on the code or name is Zimbabwe",countries.get(0).equals(country));
        Assert.assertTrue("Zimbabwe has at least one airport",countries.get(0).getAirports().size() > 0);
    }
}
