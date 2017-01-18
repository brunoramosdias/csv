package com.brunoramosdias.csv;

import com.brunorasmosdias.csv.models.Runway;
import com.brunorasmosdias.csv.service.RunwayService;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by brunoramosdias on 16/01/17.
 */
public class RunwayTest {

    @Test
    public void testParseRunway() throws IOException {
        RunwayService runwayService = new RunwayService();
        List<Runway> runways = runwayService.getAll();
        Assert.assertTrue("There where multiple records on the csv",runways.size() > 0);
        Assert.assertTrue("The first runway id was 269408",runways.get(0).getId().equals(269408L));
    }
}
