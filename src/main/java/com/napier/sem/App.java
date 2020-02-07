package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static DBConnection dbConnection = DBConnection.getInstance();
    public static void main(String[] args)
    {
            // Create new Application
            App a = new App();

            // Connect to database
            dbConnection.connect();

            // Disconnect from database
            dbConnection.disconnect();

    }



}