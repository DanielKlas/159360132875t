package com.napier.sem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static DBConnection dbConnection = DBConnection.getInstance();

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        dbConnection.connect();

        PopReportGenerator popReportGenerator = new PopReportGenerator();

        String worldReport = popReportGenerator.getWorldQuery();
        System.out.println(worldReport);

        String continentReport = popReportGenerator.getGeneralQuery("Continent", "Asia");
        System.out.println(continentReport);

        String regionReport = popReportGenerator.getGeneralQuery("Region", "North America");
        System.out.println(regionReport);

        String countryReport = popReportGenerator.getGeneralQuery("Name", "France");
        System.out.println(countryReport);

        String districtReport = popReportGenerator.getDistrictQuery("Scotland");
        System.out.println(districtReport);

        String cityReport = popReportGenerator.getCityQuery("Manchester");
        System.out.println(cityReport);

        // Philip Section
        System.out.println("---------------BEGINNING OF URBAN RURAL REPORTS-------------");
        UR_ReportGenerator urgenerator = new UR_ReportGenerator();
        String URCountryReport = urgenerator.GenerateCountry();

        System.out.println("\n\n ------------------REGION BASED REPORTS --------------------");
        urgenerator.GenerateRegion();

        System.out.println("------------------CONTINENT BASED REPORTS--------------------------");
        urgenerator.GenerateRegion();
        System.out.println("-----------------END OF URBAN RURAL REPORTS------------------------");
        // End of Philip Section
        // Disconnect from database
        dbConnection.disconnect();
    }
}