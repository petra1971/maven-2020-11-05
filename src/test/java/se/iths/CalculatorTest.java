package se.iths;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private static int countBefore;
    private static int countAfter;
    private static int countBeforeAll;

    @BeforeAll
    public static void beforeAllClass() {
        System.out.println("This executes before all test cases. Count= " + countBeforeAll++);
    }

    @BeforeEach
    public void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + countBefore++);
    }

    @AfterEach
    public void afterClass() {
        System.out.println("This executes after any test case. Count= " + countAfter++);
    }

    @ParameterizedTest
    @ValueSource(ints= {1, 2, 3})
    void testAdd(int n) {
        Calculator calculator = new Calculator();
        assertEquals(1 + n, calculator.add(1, n));
    }

    @ParameterizedTest
    @ValueSource(ints= {1, 2, 3})
    void testSubtract(int n) {
        Calculator calculator = new Calculator();
        assertEquals(1 - n, calculator.subtractVisibleToAll(1, n));
    }

    @Test
    public void testAddInt() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.add(2, 2));
    }
    @DisplayName("Is true if string is null or blank")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(Calculator.isBlank(input));
    }

    @Test
    public void testAddString() {
        Calculator calculator = new Calculator();
        assertEquals("teststräng", calculator.add("test", "sträng"));
    }

    @Test
    public void testReversString() {
        assertEquals("segnälkab", Calculator.reverse("baklänges"));
    }

    @Test
    public void testContainSubstring() {
        assertTrue(Calculator.containsSubstring("Detta är ett test", "test"));
    }

    @Test
    public void testArray() {
        int[] expected = {1, 3, 5, 6};
        int[] actual = {1, 3, 5, 6};
        assertArrayEquals(expected, actual);
        System.out.println("testArray is run");
    }

    @Test
    public void testCheckNumber() {
        assertThrows(ArithmeticException.class,() -> {
            Calculator.checkNumber(11);
        });
    }

    @Test
    void testExpectedException() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        });

    }

}
