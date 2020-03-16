package com.napier.sem;

import java.util.ArrayList;

public class App
{
    public static DBConnection dbConnection = DBConnection.getInstance();

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        dbConnection.connect();
        //Population Reports

        PopReportGenerator popReportGenerator = new PopReportGenerator();

        ArrayList worldReport = popReportGenerator.getWorldQuery();
        System.out.println(worldReport);

        ArrayList continentReport = popReportGenerator.getContinentQuery("Europe");
        System.out.println(continentReport);

        ArrayList regionReport = popReportGenerator.getRegionQuery("Caribbean");
        System.out.println(regionReport);

        ArrayList countryReport = popReportGenerator.getCountryQuery("Poland");
        System.out.println(countryReport);

        ArrayList districtReport = popReportGenerator.getDistrictQuery("Noord-Brabant");
        System.out.println(districtReport);

        // Disconnect from database
        dbConnection.disconnect();
    }
}