package com.brunorasmosdias.csv.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import com.brunorasmosdias.csv.models.Country;
import com.brunorasmosdias.csv.service.ReportService;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

/**
 * Created by brunoramosdias on 18/01/17.
 */
@Controller
@Path("/airport/reports")
public class ReportController {

    @Inject
    private ReportService reportService;

    @Inject
    private Result result;

    @Get("")
    public void reports(){

    }

    @Get("/top")
    public void top(){
        try {
            final List<Country> countries = reportService.findCountrysWithMostAirports();
            result.include("countries",countries);
        } catch (IOException e) {
            e.printStackTrace();
            result.redirectTo(this.getClass()).reports();
        }
    }

    @Get("/lower")
    public void lower(){
        try {
            final List<Country> countries = reportService.findCountrysWithLessAirports();
            result.include("countries",countries);
        } catch (IOException e) {
            e.printStackTrace();
            result.redirectTo(this.getClass()).reports();
        }
    }

}
