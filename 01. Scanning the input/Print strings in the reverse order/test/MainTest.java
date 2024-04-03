import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

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
        simpleTest("Java", "Programming", "Language");
    }

    @Test
    public void test2() {
        simpleTest("one", "two", "three");
    }

    @Test
    public void test3() {
        simpleTest("ala", "bala", "portocala");
    }

    private void simpleTest(String word1, String word2, String word3) {
        String input = word1 + "\n" + word2 + "\n " + word3 + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Main.main(new String[]{});

        String result = outputStreamCaptor.toString().trim();
        assertFalse("The output must not be empty.", result.isEmpty());

        String expectedOutput = word3 + "\r\n" + word2 + "\r\n " + word1 + "\r\n";
        String errorMessage = "The output must be:" + expectedOutput + "\r\nActual output:\r\n" + result;
        String expectedRegex = word3 + "(\\r\\n|\\r|\\n)" + word2 + "(\\r\\n|\\r|\\n)" + word1 + "($|\\r\\n|\\r|\\n)";
        assertTrue(errorMessage, result.matches(expectedRegex));
    }
}