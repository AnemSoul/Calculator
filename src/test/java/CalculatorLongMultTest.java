import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorLongMultTest {

  private static final Calculator calculator = new Calculator();

  // Standard test cases for multiplication
  @ParameterizedTest(name = "The product of {0} and {1} should be {2}")
  @CsvSource({
      "2, 3, 6",
      "-2, 3, -6",
      "0, 1000, 0",
      "1000, 0, 0",
      "1, 123456, 123456",
      "123456, 1, 123456",
      "-1, -123456, 123456"
  })
  @DisplayName("Standard test cases for long multiplication")
  public void testNormalCases(long a, long b, long expectedResult) {
    long result = calculator.mult(a, b);
    assertEquals(expectedResult, result,
        "The product of " + a + " and " + b + " should be " + expectedResult);
  }

  // Edge cases for multiplication (boundary values)
  @Test
  @DisplayName("Multiplying Long.MAX_VALUE by 1 should return Long.MAX_VALUE")
  public void testMultMaxValueByOne() {
    long result = calculator.mult(Long.MAX_VALUE, 1);
    assertEquals(Long.MAX_VALUE, result,
        "The product of Long.MAX_VALUE and 1 should be Long.MAX_VALUE");
  }

  @Test
  @DisplayName("Multiplying Long.MIN_VALUE by 1 should return Long.MIN_VALUE")
  public void testMultMinValueByOne() {
    long result = calculator.mult(Long.MIN_VALUE, 1);
    assertEquals(Long.MIN_VALUE, result,
        "The product of Long.MIN_VALUE and 1 should be Long.MIN_VALUE");
  }

  @Test
  @DisplayName("Multiplying Long.MAX_VALUE by 0 should return 0")
  public void testMultMaxValueByZero() {
    long result = calculator.mult(Long.MAX_VALUE, 0);
    assertEquals(0, result,
        "The product of Long.MAX_VALUE and 0 should be 0");
  }

  @Test
  @DisplayName("Multiplying Long.MIN_VALUE by 0 should return 0")
  public void testMultMinValueByZero() {
    long result = calculator.mult(Long.MIN_VALUE, 0);
    assertEquals(0, result,
        "The product of Long.MIN_VALUE and 0 should be 0");
  }

  @Test
  @DisplayName("Multiplying Long.MAX_VALUE by -1 should return -Long.MAX_VALUE")
  public void testMultMaxValueByNegativeOne() {
    long result = calculator.mult(Long.MAX_VALUE, -1);
    assertEquals(-Long.MAX_VALUE, result,
        "The product of Long.MAX_VALUE and -1 should be -Long.MAX_VALUE");
  }

  @Test
  @DisplayName("Multiplying Long.MIN_VALUE by -1 should cause overflow and return Long.MIN_VALUE")
  public void testMultMinValueByNegativeOne() {
    long result = calculator.mult(Long.MIN_VALUE, -1);
    assertEquals(Long.MIN_VALUE, result,
        "The product of Long.MIN_VALUE and -1 should cause overflow and return Long.MIN_VALUE");
  }

  @Test
  @DisplayName("Multiplying Long.MAX_VALUE and 2 should cause overflow")
  public void testMultMaxValueByTwoCausesOverflow() {
    long result = calculator.mult(Long.MAX_VALUE, 2);
    assertEquals(-2, result,
        "The product of Long.MAX_VALUE and 2 should cause overflow and result in -2");
  }

  @Test
  @DisplayName("Multiplying Long.MIN_VALUE and 2 should cause overflow")
  public void testMultMinValueByTwoCausesOverflow() {
    long result = calculator.mult(Long.MIN_VALUE, 2);
    assertEquals(0, result,
        "The product of Long.MIN_VALUE and 2 should cause overflow");
  }

  // Special cases for multiplication
  @Test
  @DisplayName("Multiplying 0 by 0 should return 0")
  public void testMultZeroByZero() {
    long result = calculator.mult(0, 0);
    assertEquals(0, result,
        "The product of 0 and 0 should be 0");
  }

  @Test
  @DisplayName("Multiplying a positive number by itself")
  public void testMultSelfPositive() {
    long value = 12345;
    long result = calculator.mult(value, value);
    assertEquals(value * value, result,
        "The product of " + value + " and itself should be " + (value * value));
  }

  @Test
  @DisplayName("Multiplying a negative number by itself")
  public void testMultSelfNegative() {
    long value = -12345;
    long result = calculator.mult(value, value);
    assertEquals(value * value, result,
        "The product of " + value + " and itself should be " + (value * value));
  }
}