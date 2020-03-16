package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class PopReportGenerator {

    public PopReportGenerator() {
    }

    public ArrayList<String> getWorldQuery() {
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            String rs = "SELECT city.Name AS 'City name', city.Population AS 'City population' FROM city ORDER BY city.Population DESC;";
            ResultSet rset = statement.executeQuery(rs);
            System.out.println("Cities of the world:" + "\n");
            ArrayList<String> cities = new ArrayList<>();
            while (rset.next()) {
                String city_name = rset.getString("City name");
                String city_pop = rset.getString("City population");
                cities.add(city_name);
                cities.add(city_pop + "\n");
            }
            return cities;
        } catch (Exception e) {
            System.out.println("SQL broken");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getContinentQuery(String name) {
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            String rs = "SELECT city.Name AS 'City name', city.Population AS 'City population' FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Continent LIKE ('" + name + "') ORDER BY city.Population DESC;";
            ResultSet rset = statement.executeQuery(rs);
            System.out.println("\n" + "Cities for the continent of: " + name + "\n");
            ArrayList<String> cities = new ArrayList<>();
            while (rset.next()) {
                String city_name = rset.getString("City name");
                String city_pop = rset.getString("City population");
                cities.add(city_name);
                cities.add(city_pop + "\n");
            }
            return cities;
        } catch (Exception e) {
            System.out.println("SQL broken");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getRegionQuery(String name) {
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            String rs = "SELECT city.Name AS 'City name', city.Population AS 'City population' FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Region LIKE ('" + name + "') ORDER BY city.Population DESC;";
            ResultSet rset = statement.executeQuery(rs);
            System.out.println("\n" + "Cities for the region of: " + name + "\n");
            ArrayList<String> cities = new ArrayList<>();
            while (rset.next()) {
                String city_name = rset.getString("City name");
                String city_pop = rset.getString("City population");
                cities.add(city_name);
                cities.add(city_pop + "\n");
            }
            return cities;
        } catch (Exception e) {
            System.out.println("SQL broken");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getCountryQuery(String name) {
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            String rs = "SELECT city.Name AS 'City name', city.Population AS 'City population' FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE country.Name LIKE ('" + name + "') ORDER BY city.Population DESC;";
            ResultSet rset = statement.executeQuery(rs);
            System.out.println("\n" + "Cities for the country of: " + name + "\n");
            ArrayList<String> cities = new ArrayList<>();
            while (rset.next()) {
                String city_name = rset.getString("City name");
                String city_pop = rset.getString("City population");
                cities.add(city_name);
                cities.add(city_pop + "\n");
            }
            return cities;
        } catch (Exception e) {
            System.out.println("SQL broken");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getDistrictQuery(String name) {
        try {
            DBConnection dbConnection = DBConnection.getInstance();
            Statement statement = dbConnection.con.createStatement();
            String rs = "SELECT city.Name AS 'City name', city.Population AS 'City population' FROM city JOIN country ON city.CountryCode = country.Code " +
                    "WHERE city.District LIKE ('" + name + "') ORDER BY city.Population DESC;";
            ResultSet rset = statement.executeQuery(rs);
            System.out.println("\n" + "Cities for the district of: " + name + "\n");
            ArrayList<String> cities = new ArrayList<>();
            while (rset.next()) {
                String city_name = rset.getString("City name");
                String city_pop = rset.getString("City population");
                cities.add(city_name);
                cities.add(city_pop + "\n");
            }
            return cities;
        } catch (Exception e) {
            System.out.println("SQL broken");
            e.printStackTrace();
            return null;
        }
    }



}

