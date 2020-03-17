import com.napier.sem.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitTest {



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
}
