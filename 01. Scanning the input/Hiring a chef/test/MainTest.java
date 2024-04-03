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
        simpleTest("John", 5, "chicken");
    }

    @Test
    public void test2() {
        simpleTest("Alexandru", 6, "pizza");
    }

    @Test
    public void test3() {
        simpleTest("Marcela", 10, "cheesecake");
    }

    @Test
    public void test4() {
        simpleTest("Maria", 4, "sarmale");
    }

    @Test
    public void test5() {
        simpleTest("Eugene", 8, "fusion");
    }

    private void simpleTest(String name, int experience, String cuisine) {
        String input = name + "\n" + experience + "\n" + cuisine;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{""});

        String result = outputStreamCaptor.toString().trim();

        String expected = "The form for " + name + " is completed. We will contact you if we need a chef who cooks " +
                cuisine + " dishes and has " + experience + " years of experience.";

        String errorMessage = "For input:\n" + input + "\nThe output must be:\n" +
                              expected + "\nActual output:\n" + result;

        assertEquals(errorMessage, expected, result);
    }
}