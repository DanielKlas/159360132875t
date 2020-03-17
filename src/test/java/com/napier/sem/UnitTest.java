package com.napier.sem;

import com.napier.sem.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitTest {

        @Test
        void DBConnectionTest()
        {
            DBConnection connection = DBConnection.getInstance();
           Boolean Result = connection.connect("localhost:33060");
            assertTrue(Result);
        }

        @Test
        void DBdisconnect(){
            DBConnection connection = DBConnection.getInstance();
            connection.connect("localhost:33060");
            Boolean Result = connection.disconnect();
            assertTrue(Result);
        }

}
