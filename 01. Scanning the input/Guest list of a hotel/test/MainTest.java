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
        simpleTest("Jane Kate\nJohn\nMary\n");
    }

    @Test
    public void test2() {
        simpleTest("Guest1 Guest2\nGuest3 Guest4\n");
    }

    @Test
    public void test3() {
        simpleTest("Sergiu Ionut Andrei Mihai");
    }

    @Test
    public void test4() {
        simpleTest("Alexandru Maria Dragos Adriana");
    }

    @Test
    public void test5() {
        simpleTest("Joseph \nPiotr Eugene\nJack\n");
    }

    private void simpleTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{""});

        String[] arr = reverseArray(input.split("\\s+"));
        String expected = String.join("\r\n", arr);

        String result = outputStreamCaptor.toString().trim();

        String errorMessage = "For input:\n" + input + "\nThe output must be:\n" +
                              expected + "\nActual output:\n" + result;

        String expectedRegex = String.join("($|\\r\\n|\\r|\\n)", arr);
        assertTrue(errorMessage, result.matches(expectedRegex));
    }

    private String[] reverseArray(String[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
}