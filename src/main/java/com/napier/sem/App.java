package com.napier.sem;

import javax.swing.plaf.nimbus.State;
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

        PopReportGenerator popReportGenerator= new PopReportGenerator();
        String continentReport = popReportGenerator.getQuery("Continent", "'Asia'");
        System.out.println(continentReport);
        try {
            Statement statement = dbConnection.con.createStatement();
            ResultSet rset = statement.executeQuery(continentReport);
            rset.next();
            String name = rset.getString("Continent");
            long totalPop = rset.getLong("Total Population");
            long urbanPop = rset.getLong("Urban Population");
            float urbanPercent = rset.getFloat("UrbanPercent");
            long ruralPop =rset.getLong("Rural Population");
            float RuralPercent = rset.getFloat("RuralPercent");
            System.out.println("Continent: " + name + "\n");
            System.out.println("Total Pop: " + totalPop + "\n");
            System.out.println("Urban Pop: " + urbanPop + "\n");
            System.out.println("Urban Percent: " + urbanPercent + "\n");
            System.out.println("Rural Pop: " + ruralPop + "\n");
            System.out.println("Rural Percent: " + RuralPercent + "\n");
        }
        catch (Exception e)
        {
            System.out.println("SQL broken");
            e.printStackTrace();
        }

        // Disconnect from database
        dbConnection.disconnect();

    }



}