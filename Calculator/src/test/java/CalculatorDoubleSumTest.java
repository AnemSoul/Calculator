import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoubleSumTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12;

  // Standard test cases for double addition
  @ParameterizedTest(name = "The sum of {0} and {1} should be {2}")
  @CsvSource({
      "10.1, 20.2, 30.3",
      "-10.5, -20.5, -31.0",
      "15.2, -5.2, 10.0",
      "100.0, 0.0, 100.0",
      "0.0, 0.0, 0.0",
      "-100.0, 100.0, 0.0",
      "1.5, 2.5, 4.0",
      "3.14, 2.86, 6.0",
      "1.0, -1.0, 0.0",
      "0.1, -0.1, 0.0"
  })
  @DisplayName("Standard test cases for double addition")
  public void testNormalCases(double a, double b, double expectedResult) {
    double result = calculator.sum(a, b);
    assertEquals(expectedResult, result, DELTA,
        "The sum of " + a + " and " + b + " should be " + expectedResult);
  }

  // Edge cases for double addition
  @Test
  @DisplayName("Adding Double.MAX_VALUE and -1 is handled correctly")
  public void testSumMaxValueMinusOne() {
    double result = calculator.sum(Double.MAX_VALUE, -1);
    assertEquals(Double.MAX_VALUE - 1, result, DELTA,
        "The sum of Double.MAX_VALUE and -1 should be Double.MAX_VALUE - 1");
  }

  @Test
  @DisplayName("Adding Double.MIN_VALUE and 1 is handled correctly")
  public void testSumMinValuePlusOne() {
    double result = calculator.sum(Double.MIN_VALUE, 1);
    assertEquals(1 + Double.MIN_VALUE, result, DELTA,
        "The sum of Double.MIN_VALUE and 1 should be 1 + Double.MIN_VALUE");
  }

  @Test
  @DisplayName("Adding Double.MAX_VALUE and Double.MIN_VALUE is handled correctly")
  public void testSumMaxValueAndMinValue() {
    double result = calculator.sum(Double.MAX_VALUE, Double.MIN_VALUE);
    assertEquals(Double.MAX_VALUE, result, DELTA,
        "The sum of Double.MAX_VALUE and Double.MIN_VALUE should be Double.MAX_VALUE");
  }

  // Special cases for handling infinity, NaN and zeroes
  @Test
  @DisplayName("Adding positive infinity and any number returns positive infinity")
  public void testSumWithPositiveInfinity() {
    double result = calculator.sum(Double.POSITIVE_INFINITY, 100.0);
    assertEquals(Double.POSITIVE_INFINITY, result, DELTA,
        "The sum of POSITIVE_INFINITY and any number should return POSITIVE_INFINITY");
  }

  @Test
  @DisplayName("Adding negative infinity and any number returns negative infinity")
  public void testSumWithNegativeInfinity() {
    double result = calculator.sum(Double.NEGATIVE_INFINITY, -100.0);
    assertEquals(Double.NEGATIVE_INFINITY, result, DELTA,
        "The sum of NEGATIVE_INFINITY and any number should return NEGATIVE_INFINITY");
  }

  @Test
  @DisplayName("Adding NaN and any number returns NaN")
  public void testSumWithNaN() {
    double result = calculator.sum(Double.NaN, 100.0);
    assertEquals(Double.NaN, result,
        "The sum of NaN and any number should return NaN");
  }

  @Test
  @DisplayName("Adding 0.0 and -0.0 returns 0.0")
  public void testSumWithPositiveAndNegativeZero() {
    double result = calculator.sum(0.0, -0.0);
    assertEquals(0.0, result, DELTA,
        "The sum of 0.0 and -0.0 should return 0.0");
  }

  @Test
  @DisplayName("Adding Double.MAX_VALUE and Double.MAX_VALUE returns positive infinity")
  public void testSumMaxValueWithMaxValue() {
    double result = calculator.sum(Double.MAX_VALUE, Double.MAX_VALUE);
    assertEquals(Double.POSITIVE_INFINITY, result,
        "The sum of Double.MAX_VALUE and Double.MAX_VALUE should return positive infinity");
  }
}