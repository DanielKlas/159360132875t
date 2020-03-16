package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


class MyTest
{
    @Test
    void DBConnectionTest()
    {
        DBConnection connection = DBConnection.getInstance();
        Boolean Result = connection.connect();
        assertTrue(Result);
    }

    @Test
    void DBdisconnect(){
        DBConnection connection = DBConnection.getInstance();
        connection.connect();
        Boolean Result = connection.disconnect();
        assertTrue(Result);
    }
}