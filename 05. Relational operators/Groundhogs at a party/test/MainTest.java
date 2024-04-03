import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void test() {
        simpleTest(5, true);
        simpleTest(16, false);
        simpleTest(10, false);
        simpleTest(25, true);
        simpleTest(15, true);
        simpleTest(5, false);
        simpleTest(30, false);
        simpleTest(10, true);
        simpleTest(30, true);
    }

    private void simpleTest(int numCups, boolean isWeekend) {
        //Set input stream
        String in = numCups + " " + isWeekend;
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        outputStreamCaptor.reset();
        Main.main(new String[]{""});

        //Construct expected result
        String expected = String.valueOf(check(numCups, isWeekend));

        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String[] arr = {"For input:", in, "The output must be:", expected, "Actual output:", result};
        String message = String.join(System.lineSeparator(), arr);
        assertEquals(message, expected, result);
    }

    public static boolean check(int numCups, boolean isWeekend) {
        return isWeekend ? (numCups >= 15 && numCups <= 25) : (numCups >= 10 && numCups <= 20);
    }
}