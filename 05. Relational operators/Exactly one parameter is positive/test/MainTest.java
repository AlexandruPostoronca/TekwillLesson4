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
        simpleTest(1, 1, 1);
        simpleTest(1, 0, -1);
        simpleTest(2, -1, -1);
        simpleTest(-2, -3, 0);
        simpleTest(-1, -2, -3);
    }

    private void simpleTest(int num1, int num2, int num3) {
        //Set input stream
        String in = num1 + " " + num2 + " " + num3;
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        outputStreamCaptor.reset();
        Main.main(new String[]{""});

        //Construct expected result
        String expected = String.valueOf(isBetween(num1, num2, num3));

        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String message = "For input:\r\n" + in + "\r\nThe output must be:\r\n" + expected + "\r\nActual output:\r\n" + result;
        assertEquals(message, expected, result);
    }

    public static boolean isBetween(int num1, int num2, int num3) {
        return (num1 > 0 && num2 <= 0 && num3 <= 0) ||
                (num1 <= 0 && num2 > 0 && num3 <= 0) ||
                (num1 <= 0 && num2 <= 0 && num3 > 0);
    }
}