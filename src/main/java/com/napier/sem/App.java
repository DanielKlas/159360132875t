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
        if (args.length<1)
        {
            dbConnection.connect("db:3306");
        }
        else{
            dbConnection.connect(args[0]);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please select a report type");
            System.out.println("1. Population");
            System.out.println("2. Language");
            System.out.println("3. City");
            System.out.println("4. Urban-Rural");
            System.out.println("0: Exit");
            try {
                String input = reader.readLine();
                System.out.println();
                switch (input) {
                    case "1":
                        PopReportMenu();
                        break;
                    case "2":
                        System.out.println(LanguageReportMenu());
                        break;
                    case "3":
                        CityReportMenu();
                        break;
                    case "4":
                        UrbanRuralReportMenu();
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        // Disconnect from database
        dbConnection.disconnect();
    }

    private static void PopReportMenu() {
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please select a report type");
            System.out.println("1. World");
            System.out.println("2. Continent");
            System.out.println("3. Region");
            System.out.println("4. Country");
            System.out.println("5. District");
            System.out.println("6. City");
            System.out.println("0: Exit");

            try {
                String input = reader.readLine();
                System.out.println();
                switch (input) {
                    case "1":
                        String worldReport = popReportGenerator.getWorldQuery();
                        System.out.println(worldReport);
                        break;
                    case "2":
                        System.out.println("Please enter a continent" + "\n");
                        String continent = reader.readLine();
                        String continentReport = popReportGenerator.getGeneralQuery("Continent", continent);
                        System.out.println(continentReport);
                        break;
                    case "3":
                        System.out.println("Please enter a region" + "\n");
                        String region = reader.readLine();
                        String regionReport = popReportGenerator.getGeneralQuery("Region", region);
                        System.out.println(regionReport);
                        break;
                    case "4":
                        System.out.println("Please enter a country" + "\n");
                        String country = reader.readLine();
                        String countryReport = popReportGenerator.getGeneralQuery("Name", country);
                        System.out.println(countryReport);
                        break;
                    case "5":
                        System.out.println("Please enter a district" + "\n");
                        String district = reader.readLine();
                        String districtReport = popReportGenerator.getDistrictQuery(district);
                        System.out.println(districtReport);
                        break;
                    case "6":
                        System.out.println("Please enter a city" + "\n");
                        String city = reader.readLine();
                        String cityReport = popReportGenerator.getCityQuery(city);
                        System.out.println(cityReport);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }


    private static void CityReportMenu()
    {
        CityReportGenerator cityReportGenerator = new CityReportGenerator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please select a report type");
            System.out.println("1. Cities of the world");
            System.out.println("2. Cities of a continent");
            System.out.println("3. Cities of a region");
            System.out.println("4. Cities of a country");
            System.out.println("5. Cities of a district");
            System.out.println("0: Exit");

            try {
                String input = reader.readLine();
                System.out.println();
                switch (input) {
                    case "1":
                        ArrayList worldReport = cityReportGenerator.getWorldQuery();
                        System.out.println(worldReport);
                        break;
                    case "2":
                        System.out.println("Please enter a continent" + "\n");
                        String continent = reader.readLine();
                        ArrayList continentReport = cityReportGenerator.getContinentQuery(continent);
                        System.out.println(continentReport);
                        break;
                    case "3":
                        System.out.println("Please enter a region" + "\n");
                        String region = reader.readLine();
                        ArrayList regionReport = cityReportGenerator.getRegionQuery(region);
                        System.out.println(regionReport);
                        break;
                    case "4":
                        System.out.println("Please enter a country" + "\n");
                        String country = reader.readLine();
                        ArrayList countryReport = cityReportGenerator.getCountryQuery(country);
                        System.out.println(countryReport);
                        break;
                    case "5":
                        System.out.println("Please enter a district" + "\n");
                        String district = reader.readLine();
                        ArrayList districtReport = cityReportGenerator.getDistrictQuery(district);
                        System.out.println(districtReport);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static void UrbanRuralReportMenu()
    {
        UR_ReportGenerator ur_reportGenerator = new UR_ReportGenerator();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please select a report type");
            System.out.println("1. Country");
            System.out.println("2. Region");
            System.out.println("3. Continent");
            System.out.println("0: Exit");

            try {
                String input = reader.readLine();
                System.out.println();
                switch (input) {
                    case "1":
                        String countryReport = ur_reportGenerator.GenerateCountry();
                        System.out.println(countryReport);
                        break;
                    case "2":
                        String regionReport = ur_reportGenerator.GenerateRegion();
                        System.out.println(regionReport);
                        break;
                    case "3":
                        String continentReport = ur_reportGenerator.GenerateContinent();
                        System.out.println(continentReport);
                        break;
                    case "0":
                        return;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    public static String LanguageReportMenu()
    {
        LanguageReportGenerator languageReportGenerator = new LanguageReportGenerator();
        String languageReport = languageReportGenerator.getLanguagesQuery();
        System.out.println(languageReport);
        return languageReport;
    }
}