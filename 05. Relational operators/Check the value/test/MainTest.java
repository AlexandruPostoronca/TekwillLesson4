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
        simpleTest(-1);
        simpleTest(0);
        simpleTest(1);
        simpleTest(9);
        simpleTest(10);
        simpleTest(11);
        simpleTest(100);
    }

    private void simpleTest(int value) {
        outputStreamCaptor.reset();
        //Set input stream
        String in = String.valueOf(value);
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(new String[]{""});

        //Construct expected result
        String expected = String.valueOf(check(value));

        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

    public static boolean check(int a) {
        return a < 10;
    }
}