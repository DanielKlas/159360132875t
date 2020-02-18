package com.napier.sem;
import java.sql.ResultSet;
import java.sql.Statement;

public class LanguageReportGenerator {
    public String getLanguagesQuery(String name)
    {
        String string = "SELECT countrylanguage.Language AS 'Language spoken', SUM(country.Population) AS 'Population', ((SUM(country.Population) / 6078749450) * 100) AS 'Percent of the world' "
                + "FROM country JOIN countrylanguage ON country.Code = countrylanguage.CountryCode"
                + "WHERE countrylanguage.Language IN ('Chinese','English','Hindi','Spanish','Arabic')"
                + "GROUP BY countrylanguage.Language ORDER BY SUM(country.Population) DESC;";
        String format = String.format(string,name);
        return displayLanguagesReport(format,name);
    }

    private String displayLanguagesReport(String report, String name)
    {
        String display=null;
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            ResultSet rset = statement.executeQuery(report);
            rset.next();
            String languageSpoken = rset.getString("Language spoken");
            int population = rset.getInt("Population");
            int percentage = rset.getInt("Percent of the world");
            display = "Language spoken: " + languageSpoken + "Population of speakers : " + population + "Percent of the world: " + percentage;
        }
        catch (Exception e)
        {
            System.out.println("SQL broken");
            e.printStackTrace();
        }
        return display;
    }

}
