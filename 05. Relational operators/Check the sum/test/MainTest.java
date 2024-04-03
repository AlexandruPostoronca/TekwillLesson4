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
    public void test1() {
        simpleTest(20, -5, 15);
    }

    @Test
    public void test2() {
        simpleTest(4, 16, 7);
    }

    @Test
    public void test3() {
        simpleTest(10, 5, 10);
    }

    @Test
    public void test4() {
        simpleTest(4, 8, 12);
    }

    @Test
    public void test5() {
        simpleTest(20, 20, 5);
    }

    @Test
    public void test6() {
        simpleTest(1, 2, 3);
    }

    @Test
    public void test7() {
        simpleTest(20, 15, 5);
    }

    @Test
    public void test8() {
        simpleTest(-10, -5, -15);
    }

    @Test
    public void test9() {
        simpleTest(8, 6, 4);
    }

    private void simpleTest(int int1, int int2, int int3) {
        //Set input stream
        String in = int1 + " " + int2 + " " + int3;
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        Main.main(new String[]{""});

        //Construct expected result
        String expected = String.valueOf(isSum(int1, int2, int3));

        //Get the result
        String result = outputStreamCaptor.toString().trim();

        //Check the result
        String[] arr = {"For input:", in, "The output must be:", expected, "Actual output:", result};
        String message = String.join(System.lineSeparator(), arr);
        assertEquals(message, expected, result);
    }

    public static boolean isSum(int a, int b, int c) {
        return a + b == 20 || a + c == 20 || b + c == 20;
    }
}