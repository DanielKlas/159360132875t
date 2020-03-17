package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.dbConnection.connect("localhost:33060");
    }

    @Test
    void testWorldReport()
    {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String report = popReportGenerator.getWorldQuery();
        assertEquals(report,"World \n" + "Population: 6078749450\n");
    }

    @Test
    void testCityReport()
    {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String report = popReportGenerator.getCityQuery("Manchester");
        assertEquals(report,"Manchester \n" + "Population: 537006\n");
    }

    @Test
    void testDistrictReport()
    {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String report = popReportGenerator.getDistrictQuery("Scotland");
        assertEquals(report,"Scotland \n" +"Population: 1429620\n");
    }


    @Test
    void testLanguageReport()
    {
        LanguageReportGenerator languageReportGenerator = new LanguageReportGenerator();
        String report = languageReportGenerator.getLanguagesQuery();
        assertTrue(report.length()>0);
    }


}