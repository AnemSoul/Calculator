import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorLongDivTest {

  private static final Calculator calculator = new Calculator();

  // Standard cases for division
  @ParameterizedTest(name = "{0} divided by {1} should be {2}")
  @CsvSource({
      "10, 2, 5",
      "9, 3, 3",
      "-10, 2, -5",
      "10, -2, -5",
      "0, 12345, 0",
      "-15, -3, 5",
      "100, 1, 100",
      "-100, 1, -100"
  })
  @DisplayName("Standard test cases for long division")
  public void testStandardCases(long a, long b, long expectedResult) {
    long result = calculator.div(a, b);
    assertEquals(expectedResult, result);
  }

  // Edge cases for division
  @Test
  @DisplayName("Dividing Long.MAX_VALUE by 1 should return Long.MAX_VALUE")
  public void testDivMaxValueByOne() {
    long result = calculator.div(Long.MAX_VALUE, 1);
    assertEquals(Long.MAX_VALUE, result);
  }

  @Test
  @DisplayName("Dividing Long.MIN_VALUE by 1 should return Long.MIN_VALUE")
  public void testDivMinValueByOne() {
    long result = calculator.div(Long.MIN_VALUE, 1);
    assertEquals(Long.MIN_VALUE, result);
  }

  @Test
  @DisplayName("Dividing Long.MAX_VALUE by Long.MAX_VALUE should return 1")
  public void testDivMaxValueByMaxValue() {
    long result = calculator.div(Long.MAX_VALUE, Long.MAX_VALUE);
    assertEquals(1, result);
  }

  @Test
  @DisplayName("Dividing Long.MIN_VALUE by Long.MIN_VALUE should return 1")
  public void testDivMinValueByMinValue() {
    long result = calculator.div(Long.MIN_VALUE, Long.MIN_VALUE);
    assertEquals(1, result);
  }

  @Test
  @DisplayName("Dividing Long.MIN_VALUE by -1 should cause overflow and return Long.MIN_VALUE")
  public void testDivMinValueByNegativeOne() {
    long result = calculator.div(Long.MIN_VALUE, -1);
    assertEquals(Long.MIN_VALUE, result);
  }

  @Test
  @DisplayName("Dividing Long.MAX_VALUE by 2 should return half of Long.MAX_VALUE")
  public void testDivMaxValueByTwo() {
    long result = calculator.div(Long.MAX_VALUE, 2);
    assertEquals(Long.MAX_VALUE / 2, result);
  }

  @Test
  @DisplayName("Dividing Long.MIN_VALUE by 2 should return half of Long.MIN_VALUE")
  public void testDivMinValueByTwo() {
    long result = calculator.div(Long.MIN_VALUE, 2);
    assertEquals(Long.MIN_VALUE / 2, result);
  }

  // Special case: Division by zero
  @Test
  @DisplayName("Dividing by zero should throw NumberFormatException")
  public void testDivisionByZero() {
    assertThrows(NumberFormatException.class, () -> calculator.div(12345, 0),
        "Division by zero should throw a NumberFormatException");
  }

  @Test
  @DisplayName("Dividing by zero (negative denominator) should throw NumberFormatException")
  public void testDivisionByZeroNegative() {
    assertThrows(NumberFormatException.class, () -> calculator.div(-12345, 0),
        "Division by zero should throw a NumberFormatException");
  }
}