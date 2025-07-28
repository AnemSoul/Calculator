import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoublePowTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12; // Precision for floating-point comparisons

  // Standard test cases
  @ParameterizedTest(name = "{0} raised to the floored power of {1} should be {2}")
  @CsvSource({
      "2.0, 3.0, 8.0",
      "2.0, 2.9, 4.0",
      "2.0, 0.9, 1.0",
      "2.0, -1.5, 0.25",
      "-2.0, 3.0, -8.0",
      "-2.0, 2.9, 4.0",
      "10.0, 0.0, 1.0",
      "0.0, 10.0, 0.0",
      "0.0, 0.0, 1.0",
      "-2.0, -2.3, -0.125",
      "-2.0, -1.7, 0.25",
  })
  @DisplayName("Standard test cases for pow with floor")
  public void testStandardCases(double a, double b, double expectedResult) {
    double result = calculator.pow(a, b);
    assertEquals(expectedResult, result, DELTA);
  }

  // Special cases
  @Test
  @DisplayName("Base 0 raised to positive power should return 0")
  public void testZeroBasePositiveExponent() {
    double result = calculator.pow(0.0, 10.0);
    assertEquals(0.0, result, DELTA);
  }

  @Test
  @DisplayName("Base 0 raised to power 0 should return 1")
  public void testZeroBaseZeroExponent() {
    double result = calculator.pow(0.0, 0.0);
    assertEquals(1.0, result, DELTA); // By definition in `Math.pow()`
  }

  @Test
  @DisplayName("Positive base raised to infinity should return infinity")
  public void testPositiveBasePositiveInfinity() {
    double result = calculator.pow(2.0, Double.POSITIVE_INFINITY);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Negative base raised to odd negative infinity should return -0.0")
  public void testNegativeBaseNegativeInfinity() {
    double result = calculator.pow(-2.0, Double.NEGATIVE_INFINITY);
    assertEquals(0.0, result);
  }

  @Test
  @DisplayName("Base NaN with any exponent should return NaN")
  public void testNaNBase() {
    double result = calculator.pow(Double.NaN, 3.0);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Base with NaN exponent should return NaN")
  public void testNaNExponent() {
    double result = calculator.pow(2.0, Double.NaN);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Positive base raised to negative infinity should return 0.0")
  public void testPositiveBaseNegativeInfinity() {
    double result = calculator.pow(2.0, Double.NEGATIVE_INFINITY);
    assertEquals(0.0, result);
  }

  @Test
  @DisplayName("Negative base raised to even positive infinity should return infinity")
  public void testNegativeBasePositiveInfinity() {
    double result = calculator.pow(-2.0, Double.POSITIVE_INFINITY);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Negative base raised to odd positive infinity should return negative infinity")
  public void testNegativeBaseOddPositiveInfinity() {
    double result = calculator.pow(-2.0, Double.POSITIVE_INFINITY);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Base 1 raised to infinity should return 1")
  public void testOneBaseInfinityExponent() {
    double result = calculator.pow(1.0, Double.POSITIVE_INFINITY);
    assertEquals(1.0, result); // 1 raised to any power is always 1; This test shows the incompleteness of the method
  }

  @Test
  @DisplayName("Base -1 raised to infinity should return NaN")
  public void testNegativeOneBaseInfinityExponent() {
    double result = calculator.pow(-1.0, Double.POSITIVE_INFINITY);
    assertEquals(Double.NaN, result);
  }
}