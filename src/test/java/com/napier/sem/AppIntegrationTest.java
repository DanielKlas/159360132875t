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
        assertTrue(report.contains("Manchester"));
        assertTrue(report.contains("537006"));
    }

        @Test
    void testContinentReport()
    {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String report = popReportGenerator.getGeneralQuery("Continent","Asia")
        assertTrue(report.contains("Asia"));
        assertTrue(report.contains("900937599400"));
    }

    @Test
    void testRegionReport()
    {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String report = popReportGenerator.getGeneralQuery("Region","North America")
        assertTrue(report.contains("North America"));
        assertTrue(report.contains("77796214000"));
    }

    @Test
    void testCountryReport()
    {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String report = popReportGenerator.getGeneralQuery("Country","France");
        assertTrue(report.contains("France"));
        assertTrue(report.contains("2369028000"));
    }

    @Test
    void testDistrictReport()
    {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String report = popReportGenerator.getDistrictQuery("Scotland");
        assertTrue(report.contains("Scotland"));
        assertTrue(report.contains("1429620"));
    }


    @Test
    void testLanguageReport()
    {
        LanguageReportGenerator languageReportGenerator = new LanguageReportGenerator();
        String report = languageReportGenerator.getLanguagesQuery();
        assertTrue(report.contains("Chinese"));
        assertTrue(report.contains("1191843539"));
    }


}