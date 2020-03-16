package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    @Test
    void test()
    {
        int i =5;
        assertEquals(i,5);

    }
    @Test
    void DBConnectionTest()
    {
        DBConnection connection = DBConnection.getInstance();
        Boolean Result = connection.connect("db:3306");
        assertTrue(Result);
    }


}