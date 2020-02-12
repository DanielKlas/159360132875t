package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

public class PopReportGenerator {

    public PopReportGenerator(){ }

    public String getGeneralQuery(String queryVar, String name)
    {
        String string =
                "SELECT country.%s, sum(country.population) as 'Total Population', " +
                        "sum(city.population) as 'Urban Population', " +
                        "sum(city.Population) / sum(country.Population) as 'UrbanPercent', " +
                        "sum(country.Population) - sum(city.population) as 'Rural Population', " +
                        "(sum(country.population) - sum(city.population))/ sum(country.population) as 'RuralPercent' " +
                        "FROM country JOIN city ON country.Code=city.CountryCode " +
                        "WHERE country.%s LIKE '%s' GROUP BY country.%s;";
        String format = String.format(string,queryVar,queryVar,name,queryVar);
        return displayGeneralQuery(format,queryVar);
    }

    public String getWorldQuery()
    {
        String string = "SELECT sum(country.Population) as 'Population' FROM country";
        return displayWorldQuery(string);
    }

    public String getDistrictQuery(String name)
    {
        String string = "SELECT sum(city.Population) as Population FROM city WHERE city.District LIKE '%s';";
        String format = String.format(string,name);
        return displayDistrictReport(format,name);
    }
    
    public String getCityQuery(String name)
    {
        String string = "SELECT sum(city.Population) as Population FROM city WHERE city.Name Like '%s'";
        String format = String.format(string,name);
        return displayCityReport(format,name);
    }

    private String displayGeneralQuery(String report, String queryVar)
    {
        String display = null;
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            ResultSet rset = statement.executeQuery(report);
            rset.next();
            String name = rset.getString(queryVar);
            long totalPop = rset.getLong("Total Population");
            long urbanPop = rset.getLong("Urban Population");
            float urbanPercent = rset.getFloat("UrbanPercent");
            long ruralPop =rset.getLong("Rural Population");
            float RuralPercent = rset.getFloat("RuralPercent");
            display =  queryVar + ": " + name + "\n" +
                    "Total Pop: " + totalPop + "\n" +
                    "Urban Pop: " + urbanPop + "\n" +
                    "Urban Percent: " + urbanPercent + "\n" +
                    "Rural Pop: " + ruralPop + "\n" +
                    "Rural Percent: " + RuralPercent + "\n";
        }
        catch (Exception e)
        {
            System.out.println("SQL broken");
            e.printStackTrace();
            display = "Report failed";
        }
        return display;
    }

    private String displayWorldQuery(String report)
    {
        String display = null;
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            ResultSet rset = statement.executeQuery(report);
            rset.next();
            long pop = rset.getLong("Population");
            display= "World \n" + "Population: " + pop + "\n";
        }
        catch (Exception e)
        {
            System.out.println("SQL broken");
            e.printStackTrace();
        }
        return display;
    }

    private String displayDistrictReport(String report, String name)
    {
        String display=null;
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            ResultSet rset = statement.executeQuery(report);
            rset.next();
            long pop = rset.getLong("Population");
            display= name +"\n" + "Population: " + pop + "\n";
        }
        catch (Exception e)
        {
            System.out.println("SQL broken");
            e.printStackTrace();
        }
        return display;
    }

    private String displayCityReport(String report, String name)
    {
        String display=null;
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            ResultSet rset = statement.executeQuery(report);
            rset.next();
            long pop = rset.getLong("Population");
            display = (name +  "\n" + "Population: " + pop + "\n");
        }
        catch (Exception e)
        {
            System.out.println("SQL broken");
            e.printStackTrace();
        }
        return display;
    }
}
