import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoubleSqrtTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12; // Precision for floating-point comparisons

  // Standard cases for sqrt
  @ParameterizedTest(name = "Square root of absolute value {0} should be {1}")
  @CsvSource({
      "4.0, 2.0",
      "9.0, 3.0",
      "2.25, 1.5",
      "-4.0, 2.0",
      "-9.0, 3.0",
      "0.0025, 0.05",
      "1.0, 1.0"
  })
  @DisplayName("Standard test cases for square root calculation")
  public void testStandardCases(double input, double expected) {
    double result = calculator.sqrt(input);
    assertEquals(expected, result, DELTA);
  }

  // Edge cases:
  @Test
  @DisplayName("Square root of Double.MAX_VALUE should be calculated correctly")
  public void testSqrtMaxValue() {
    double result = calculator.sqrt(Double.MAX_VALUE);
    assertEquals(Math.sqrt(Double.MAX_VALUE), result, DELTA);
  }

  @Test
  @DisplayName("Square root of Double.MIN_VALUE should be calculated correctly")
  public void testSqrtMinValue() {
    double result = calculator.sqrt(Double.MIN_VALUE);
    assertEquals(Math.sqrt(Double.MIN_VALUE), result, DELTA);
  }

  @Test
  @DisplayName("Square root of negative Double.MAX_VALUE should return square root of absolute value")
  public void testSqrtNegativeMaxValue() {
    double result = calculator.sqrt(-Double.MAX_VALUE);
    assertEquals(Math.sqrt(Math.abs(-Double.MAX_VALUE)), result, DELTA);
  }

  @Test
  @DisplayName("Square root of negative Double.MIN_VALUE should return square root of absolute value")
  public void testSqrtNegativeMinValue() {
    double result = calculator.sqrt(-Double.MIN_VALUE);
    assertEquals(Math.sqrt(Math.abs(-Double.MIN_VALUE)), result, DELTA);
  }

  // Special cases:
  @Test
  @DisplayName("Square root of Double.NaN should return Double.NaN")
  public void testSqrtOfNaN() {
    double result = calculator.sqrt(Double.NaN);
    assertEquals(Double.NaN, result); // NaN -> NaN
  }

  @Test
  @DisplayName("Square root of Double.POSITIVE_INFINITY should return Double.POSITIVE_INFINITY")
  public void testSqrtPositiveInfinity() {
    double result = calculator.sqrt(Double.POSITIVE_INFINITY);
    assertEquals(Double.POSITIVE_INFINITY, result, DELTA); // sqrt(∞) -> ∞
  }

  @Test
  @DisplayName("Square root of Double.NEGATIVE_INFINITY should return Double.POSITIVE_INFINITY")
  public void testSqrtNegativeInfinity() {
    double result = calculator.sqrt(Double.NEGATIVE_INFINITY);
    assertEquals(Double.POSITIVE_INFINITY, result, DELTA); // abs(-∞) -> ∞; sqrt(∞) -> ∞
  }

  @Test
  @DisplayName("Square root of very small positive value should return a non-zero number")
  public void testSqrtVerySmallPositiveValue() {
    double input = Double.MIN_VALUE;
    double expected = Math.sqrt(Double.MIN_VALUE);
    double result = calculator.sqrt(input);
    assertEquals(expected, result, DELTA);
  }

  // Edge cases with negative input and zero:
  @Test
  @DisplayName("Square root of -0.0 should return 0.0")
  public void testSqrtNegativeZero() {
    double result = calculator.sqrt(-0.0);
    assertEquals(0.0, result, DELTA);
  }

  @Test
  @DisplayName("Square root of 0.0 should return 0.0")
  public void testSqrtZero() {
    double result = calculator.sqrt(0.0);
    assertEquals(0.0, result, DELTA);
  }
}