package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void testReportOne()
    {
        assertEquals(app.test(),0);
    }

    @Test
    void testReportTwo()
    {
        DBConnection connection = DBConnection.getInstance();
        Boolean Result = connection.connect("localhost:33060");
        assertTrue(Result);
    }


}