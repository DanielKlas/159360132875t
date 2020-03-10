package com.napier.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    /**
     * Connection to MariaDB database
     */


    /**
     * DBConnection acts as a singleton
     */
    private static DBConnection instance;
    public static DBConnection getInstance(){
        if (instance==null)
        {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection con =null;

    private DBConnection(){}
    /**
     * Connect to the MariaDB database.
     */
    public boolean connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("org.mariadb.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mariadb://"+location+"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                return true;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
        return false;
    }

    /**
     * Disconnect from the MariaDB database.
     */
    public boolean disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
        return true;
    }
}
