import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoubleSubTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12;

  // Standard test cases for double addition
  @ParameterizedTest(name = "The sum of {0} and {1} should be {2}")
  @CsvSource({
      "20.0, 10.0, 10.0",
      "-20.0, -10.0, -10.0",
      "15.0, -5.0, 20.0",
      "100.000000001, 0.0, 100.000000001",
      "0.0, 100.0, -100.0",
      "0.0, 0.0, 0.0",
      "-100.001, -100.001, 0.0",
      "1.5, 2.5, -1.0",
      "3.14, 2.86, 0.28",
      "1.0, -1.0, 2.0",
      "0.111, 0.111, 0.0"
  })
  @DisplayName("Standard test cases for double addition")
  public void testNormalCases(double a, double b, double expectedResult) {
    double result = calculator.sub(a, b);
    assertEquals(expectedResult, result, DELTA,
        "The sum of " + a + " and " + b + " should be " + expectedResult);
  }

  // Edge cases for double addition
  @Test
  @DisplayName("Subtracting Double.MAX_VALUE and -1 is handled correctly")
  public void testSubMaxValueMinusNegativeOne() {
    double result = calculator.sub(Double.MAX_VALUE, -1);
    assertEquals(Double.MAX_VALUE + 1, result, DELTA,
        "The result of Double.MAX_VALUE - (-1) should be Double.MAX_VALUE + 1");
  }

  @Test
  @DisplayName("Subtracting Double.MIN_VALUE from 1 is handled correctly")
  public void testSubOneMinusMinValue() {
    double result = calculator.sub(1, Double.MIN_VALUE);
    assertEquals(1 - Double.MIN_VALUE, result, DELTA,
        "The result of 1 - Double.MIN_VALUE should be 1 - Double.MIN_VALUE");
  }

  @Test
  @DisplayName("Subtracting Double.MAX_VALUE and Double.MIN_VALUE is handled correctly")
  public void testSubMaxValueWithMinValue() {
    double result = calculator.sub(Double.MAX_VALUE, Double.MIN_VALUE);
    assertEquals(Double.MAX_VALUE - Double.MIN_VALUE, result, DELTA,
        "The result of Double.MAX_VALUE - Double.MIN_VALUE should be Double.MAX_VALUE - Double.MIN_VALUE");
  }


  // Special cases for handling infinity, NaN and zeroes
  @Test
  @DisplayName("Subtracting any number from positive infinity should return positive infinity")
  public void testSubFromPositiveInfinity() {
    double result = calculator.sub(Double.POSITIVE_INFINITY, 100.0);
    assertEquals(Double.POSITIVE_INFINITY, result, DELTA,
        "The result of POSITIVE_INFINITY - 100.0 should be POSITIVE_INFINITY");
  }

  @Test
  @DisplayName("Subtracting any number from negative infinity should return negative infinity")
  public void testSubFromNegativeInfinity() {
    double result = calculator.sub(Double.NEGATIVE_INFINITY, -100.0);
    assertEquals(Double.NEGATIVE_INFINITY, result, DELTA,
        "The result of NEGATIVE_INFINITY - (-100.0) should be NEGATIVE_INFINITY");
  }

  @Test
  @DisplayName("Subtracting NaN from any number should return NaN")
  public void testSubWithNaN() {
    double result = calculator.sub(Double.NaN, 100.0);
    assertEquals(Double.NaN, result,
        "The result of NaN - 100.0 should be NaN");
  }

  @Test
  @DisplayName("Subtracting 0.0 and -0.0 should return 0.0")
  public void testSubWithPositiveAndNegativeZero() {
    double result = calculator.sub(0.0, -0.0);
    assertEquals(0.0, result, DELTA,
        "The result of 0.0 - (-0.0) should be 0.0");
  }

  @Test
  @DisplayName("Subtracting Double.MAX_VALUE from itself should return 0")
  public void testSubMaxValueFromItself() {
    double result = calculator.sub(Double.MAX_VALUE, Double.MAX_VALUE);
    assertEquals(0.0, result, DELTA,
        "The result of Double.MAX_VALUE - Double.MAX_VALUE should be 0.0");
  }

  @Test
  @DisplayName("Subtracting Double.MIN_VALUE from itself should return 0")
  public void testSubMinValueFromItself() {
    double result = calculator.sub(Double.MIN_VALUE, Double.MIN_VALUE);
    assertEquals(0.0, result, DELTA,
        "The result of Double.MIN_VALUE - Double.MIN_VALUE should be 0.0");
  }
}