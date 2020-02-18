package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

public class LanguageReportGenerator {

    public LanguageReportGenerator() {}

    public String getLanguagesQuery()
    {
        String string = "SELECT countrylanguage.Language AS 'Language spoken', " +
                "SUM(country.Population * (countrylanguage.Percentage/100)) AS 'Population', " +
                "SUM(country.Population * (countrylanguage.Percentage/100)) / (SELECT SUM(country.Population) FROM country) * 100 AS 'Percent of the world' "
                + "FROM country JOIN countrylanguage ON country.Code = countrylanguage.CountryCode "
                + "WHERE countrylanguage.Language IN ('Chinese','English','Hindi','Spanish','Arabic') "
                + "GROUP BY countrylanguage.Language ORDER BY SUM(country.Population) DESC; ";
        return displayLanguagesReport(string);
    }

    private String displayLanguagesReport(String report)
    {
        String display="";
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            ResultSet rset = statement.executeQuery(report);
            while(rset.next()) {
                String languageSpoken = rset.getString("Language spoken");
                long population = rset.getLong("Population");
                double percentage = rset.getDouble("Percent of the world");
                display += "Language spoken: " + languageSpoken + " Population of speakers : " + population + " Percent of the world: " + percentage + "\n";
            }
        }
        catch (Exception e)
        {
            System.out.println("SQL broken");
            e.printStackTrace();
        }
        return display;
    }
}
