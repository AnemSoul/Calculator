import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoubleMultTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12;

  // Standard test cases for multiplication
  @ParameterizedTest(name = "The product of {0} and {1}, floored, should be {2}")
  @CsvSource({
      "2.5, 2.0, 5.0",
      "-2.5, 2.0, -5.0",
      "3.333, 3.333, 11.0",
      "1000.0, 0.001, 1.0",
      "0.0, 123.456, 0.0",
      "1.0, -123.456, -124.0",
      "-1.0, -123.456, 123.0"
  })
  @DisplayName("Standard test cases for double multiplication with floor")
  public void testNormalCases(double a, double b, double expectedResult) {
    double result = calculator.mult(a, b);
    assertEquals(expectedResult, result, DELTA);
  }

  // Edge cases for multiplication (boundary values)
  @Test
  @DisplayName("Multiplying Double.MAX_VALUE by 1 should return floored Double.MAX_VALUE")
  public void testMultMaxValueByOne() {
    double result = calculator.mult(Double.MAX_VALUE, 1.0);
    assertEquals(Math.floor(Double.MAX_VALUE), result, DELTA);
  }

  @Test
  @DisplayName("Multiplying Double.MIN_VALUE by 1 should return floored Double.MIN_VALUE")
  public void testMultMinValueByOne() {
    double result = calculator.mult(Double.MIN_VALUE, 1.0);
    assertEquals(Math.floor(Double.MIN_VALUE), result, DELTA);
  }

  @Test
  @DisplayName("Multiplying 0 by any number should return 0")
  public void testMultZeroByAnyNumber() {
    double result = calculator.mult(0.0, 123456.789);
    assertEquals(0.0, result, DELTA);
  }

  @Test
  @DisplayName("Multiplying a positive number by itself should return floored square")
  public void testMultPositiveSelf() {
    double value = 1.414;
    double result = calculator.mult(value, value);
    assertEquals(Math.floor(value * value), result, DELTA);
  }

  @Test
  @DisplayName("Multiplying Double.POSITIVE_INFINITY by a positive number should return Double.POSITIVE_INFINITY")
  public void testMultPositiveInfinityByPositiveNumber() {
    double result = calculator.mult(Double.POSITIVE_INFINITY, 2.0);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Multiplying Double.NEGATIVE_INFINITY by a positive number should return Double.NEGATIVE_INFINITY")
  public void testMultNegativeInfinityByPositiveNumber() {
    double result = calculator.mult(Double.NEGATIVE_INFINITY, 2.0);
    assertEquals(Double.NEGATIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Multiplying Double.POSITIVE_INFINITY by 0 should return NaN")
  public void testMultInfinityByZero() {
    double result = calculator.mult(Double.POSITIVE_INFINITY, 0.0);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Multiplying NaN with any number should return NaN")
  public void testMultNaN() {
    double result = calculator.mult(Double.NaN, 123.456);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Multiplying positive zero and negative zero should return negative zero")
  public void testMultPositiveZeroByNegativeZero() {
    double result = calculator.mult(0.0, -0.0);
    assertEquals(-0.0, result);
  }

  @Test
  @DisplayName("Multiplying Double.MAX_VALUE with Double.MIN_VALUE should not overflow")
  public void testMaxAndMinMultiplication() {
    double result = calculator.mult(Double.MAX_VALUE, Double.MIN_VALUE);
    assertEquals(Math.floor(Double.MAX_VALUE * Double.MIN_VALUE), result, DELTA);
  }

  @Test
  @DisplayName("Multiplying large positive values that cause overflow")
  public void testOverflowPositive() {
    double result = calculator.mult(Double.MAX_VALUE, 2.0);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Multiplying large negative values that cause overflow")
  public void testOverflowNegative() {
    double result = calculator.mult(-Double.MAX_VALUE, 2.0);
    assertEquals(Double.NEGATIVE_INFINITY, result);
  }
}