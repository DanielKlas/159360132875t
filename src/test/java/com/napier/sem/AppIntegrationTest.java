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
        PopReportGenerator popReportGenerator = new PopReportGenerator();
        String worldQuery = popReportGenerator.getWorldQuery();
        assertEquals("World \n" + "Population: " + 607879450 + "\n",worldQuery);
    }
}