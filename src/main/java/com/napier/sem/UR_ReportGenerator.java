package com.napier.sem;
import java.sql.ResultSet;
import java.sql.Statement;

/* Urban Rural Report Generator. Enables the creation of reports for the following:
    The population of people, people living in cities, and people not living in cities in each continent.
    The population of people, people living in cities, and people not living in cities in each region.
    The population of people, people living in cities, and people not living in cities in each country.
*/


public class UR_ReportGenerator {

    DBConnection dbConnection;
    Statement statement;
    String Holder;
    // Constructor
    public UR_ReportGenerator() {
        try {
            dbConnection = DBConnection.getInstance();
            statement = dbConnection.con.createStatement();

        }
        catch(Exception e){
            System.out.println("Fail Exception thrown");

        }
    }

    // Method to Generate Urban/Rural Reports for each country
    public String GenerateCountry(){
        try {
            String Query = "select c.continent, c.region, c.name, c.population AS CountryPop , SUM(ct.population) AS CityPop  from country c, city ct where c.code = ct.CountryCode group by  c.continent, c.region, c.name;   ";
            ResultSet results = statement.executeQuery(Query);
            while(results.next()) {
                int TotalPop = results.getInt("CountryPop");
                int UrbanPop = results.getInt("CityPop");
                String Name = results.getString("c.name");
                int RuralPop = TotalPop - UrbanPop;
                Holder = "| " + Name + " | Urban Population: " + UrbanPop + " | Rural Population: " + RuralPop + " |";
                System.out.println(Holder);

            }
        }
        catch(Exception e) {
            System.out.println("Fail Generate Country");
            return null;
        }
        return Holder;
    }




}