import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

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
        simpleTest("Hello\nJava\nFuture programmer\n");
    }

    @Test
    public void test2() {
        simpleTest("Hello Java Future programmer");
    }

    @Test
    public void test3() {
        simpleTest("ala bala portocala sandala");
    }

    @Test
    public void test4() {
        simpleTest("we will rock you");
    }

    @Test
    public void test5() {
        simpleTest("we\nwill rock\nyou\n");
    }

    private void simpleTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Main.main(new String[]{""});

        String[] arr = input.split("\\s+");
        String expected = String.join("\r\n", arr);

        String result = outputStreamCaptor.toString().trim();

        String errorMessage = "For input:\n" + input + "\nThe output must be:" +
                              expected + "\r\nActual output:\r\n" + result;

        String expectedRegex = String.join("($|\\r\\n|\\r|\\n)", arr);
        assertTrue(errorMessage, result.matches(expectedRegex));
    }
}