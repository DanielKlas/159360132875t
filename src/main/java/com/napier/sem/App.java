package com.napier.sem;

import org.mariadb.jdbc.MariaDbConnection;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        // Connect to MariaDB on local system - we're using port 27000
        MariaDbConnection mariaDbConnection = new MariaDbConnection("localhost");
        // Get a database - will create when we use it
        MongoDatabase database = MariaDbDataSource("world");
        // Get a collection from the database
        MongoCollection<Document> collection = database.getCollection("test");
        // Create a document to store
        Document doc = new Document("name", "Kevin Chalmers")
                .append("class", "Software Engineering Methods")
                .append("year", "2018/19")
                .append("result", new Document("CW", 95).append("EX", 85));
        // Add document to collection
        collection.insertOne(doc);

        // Check document in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}
