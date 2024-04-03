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
        simpleTest(5, 5, 9);
        simpleTest(5, 9, 5);
        simpleTest(9, 5, 5);
        simpleTest(5, 9, 9);
        simpleTest(5, 5, 5);
        simpleTest(1, 2, 3);
        simpleTest(3, 2, 1);
    }

    private void simpleTest(int num1, int num2, int num3) {
        //Set input stream
        String in = num1 + " " + num2 + " " + num3;
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        outputStreamCaptor.reset();
        Main.main(new String[]{""});

        //Construct expected result
        String expected = String.valueOf(check(num1, num2, num3));

        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String[] arr = {"For input:", in, "The output must be:", expected, "Actual output:", result};
        String message = String.join(System.lineSeparator(), arr);
        assertEquals(message, expected, result);
    }

    public static boolean check(int num1, int num2, int num3) {
        return num1 != num2 && num1 != num3 && num2 != num3;
    }
}