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
        simpleTest(3, 3, 3);
        simpleTest(2, 7, 9);
        simpleTest(40, 100, 20);
        simpleTest(2, 1, 3);
        simpleTest(10, 2, 5);
    }

    private void simpleTest(int int1, int int2, int int3) {
        outputStreamCaptor.reset();
        //Set input stream
        String in = int1 + " " + int2 + " " + int3;
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(new String[]{""});
        //Construct expected result
        String expected = String.valueOf(isBetween(int1, int2, int3));

        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

    public static boolean isBetween(int a, int b, int c) {
        int max = Math.max(b, c);
        int min = Math.min(b, c);
        return a >= min && a <= max;
    }
}