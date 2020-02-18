import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitTest {



    class MyTest
    {
        @Test
        void unitTest()
        {
            String line;
            String pattern = "(.*)(\\d+)(.*)";

            Pattern r = Pattern.compile(pattern);

            assertEquals(5, 5);
        }
    }
}
