package com.brunorasmosdias.csv.service;

import com.brunorasmosdias.csv.models.Country;
import com.brunorasmosdias.csv.models.Runway;
import com.opencsv.CSVReader;

import javax.inject.Singleton;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by brunoramosdias on 16/01/17.
 */

@Singleton
public class RunwayService {


    private final List<Runway> runways;

    public RunwayService() throws IOException {
        runways = getAll();
    }

    public List<Runway> getAll() throws IOException {
        final List<String[]> strings;
        try {
            File runwayFile =  new File(getClass().getClassLoader().getResource("runways.csv").getFile());
            CSVReader csvReader = new CSVReader(new FileReader(runwayFile));
            strings = csvReader.readAll();
            return parseRunways(strings);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private List<Runway> parseRunways(List<String[]> strings) {
        strings.remove(0);
        return   strings.stream().map(runwayData -> new Runway(Long.parseLong(runwayData[0]),
                Long.parseLong(runwayData[1]),
                runwayData[2],
                runwayData[3].length() > 0 ? Double.parseDouble(runwayData[3]):null,
                runwayData[4].length() > 0 ? Double.parseDouble(runwayData[4]):null,
                runwayData[5],
                Boolean.valueOf(runwayData[6]),
                Boolean.valueOf(runwayData[7]),
                runwayData[8],
                runwayData[9].length() > 0 ? Float.parseFloat(runwayData[9]):null,
                runwayData[10].length() > 0 ? Float.parseFloat(runwayData[10]): null,
                runwayData[11].length() > 0 ? Double.parseDouble(runwayData[11]):null,
                runwayData[12].length() > 0 ? Float.parseFloat(runwayData[12]):null,
                runwayData[13],
                runwayData[14],
                runwayData[15],
                runwayData[16],
                runwayData[17],
                runwayData[18],
                runwayData[19])).collect(Collectors.toList());
    }

    public List<Runway> filterRunwaysByAirport(Long airportId) throws IOException {
        return   runways.stream().filter(runway -> runway.getAirport_ref().equals(airportId)).collect(Collectors.toList());
    }

}
