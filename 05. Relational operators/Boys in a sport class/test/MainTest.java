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
        //form problem
        simpleTest(165, 161, 158);
        simpleTest(155, 165, 160);
        simpleTest(161, 161, 165);
        //generated by ChatGpt
        simpleTest(150, 160, 170);
        simpleTest(170, 160, 150);
        simpleTest(160, 170, 150);
        simpleTest(150, 160, 160);
        simpleTest(150, 150, 150);
    }

    private void simpleTest(int int1, int int2, int int3) {
        //Set input stream
        String in = int1 + " " + int2 + " " + int3;
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        outputStreamCaptor.reset();
        Main.main(new String[]{""});

        //Construct expected result
        String expected = String.valueOf(isBetween(int1, int2, int3));

        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

    public static boolean isBetween(int h1, int h2, int h3) {
        return (h1 <= h2 && h2 <= h3) || (h1 >= h2 && h2 >= h3);
    }
}