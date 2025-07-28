import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoubleDivTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12;

  // Standard cases for division
  @ParameterizedTest(name = "{0} divided by {1} should be {2}")
  @CsvSource({
      "10.1, 2.0, 5.05",
      "-10.3, 2.0, -5.15",
      "10.8, -2.0, -5.4",
      "-10.9, -2.0, 5.45",
      "0.0, 12345.0, 0.0",
      "12345.0, 1.0, 12345.0",
      "-12345.0, 1.0, -12345.0",
      "1.0, 4.0, 0.25",
      "4.0, 1.0, 4.0"
  })
  @DisplayName("Standard test cases for double division")
  public void testStandardCases(double a, double b, double expectedResult) {
    double result = calculator.div(a, b);
    assertEquals(expectedResult, result, DELTA);
  }

  // Edge cases for division
  @Test
  @DisplayName("Dividing Double.MAX_VALUE by 1 should return Double.MAX_VALUE")
  public void testDivMaxValueByOne() {
    double result = calculator.div(Double.MAX_VALUE, 1.0);
    assertEquals(Double.MAX_VALUE, result, DELTA);
  }

  @Test
  @DisplayName("Dividing Double.MIN_VALUE by 1 should return Double.MIN_VALUE")
  public void testDivMinValueByOne() {
    double result = calculator.div(Double.MIN_VALUE, 1.0);
    assertEquals(Double.MIN_VALUE, result, DELTA);
  }

  @Test
  @DisplayName("Dividing Double.MAX_VALUE by Double.MAX_VALUE should return 1.0")
  public void testDivMaxValueByMaxValue() {
    double result = calculator.div(Double.MAX_VALUE, Double.MAX_VALUE);
    assertEquals(1.0, result, DELTA);
  }

  @Test
  @DisplayName("Dividing Double.MIN_VALUE by Double.MIN_VALUE should return 1.0")
  public void testDivMinValueByMinValue() {
    double result = calculator.div(Double.MIN_VALUE, Double.MIN_VALUE);
    assertEquals(1.0, result, DELTA);
  }

  @Test
  @DisplayName("Dividing Double.MIN_VALUE by -1 should return -Double.MIN_VALUE")
  public void testDivMinValueByNegativeOne() {
    double result = calculator.div(Double.MIN_VALUE, -1.0);
    assertEquals(-Double.MIN_VALUE, result, DELTA);
  }

  @Test
  @DisplayName("Dividing Double.MAX_VALUE by 2 should return half of Double.MAX_VALUE")
  public void testDivMaxValueByTwo() {
    double result = calculator.div(Double.MAX_VALUE, 2.0);
    assertEquals(Double.MAX_VALUE / 2, result, DELTA);
  }

  @Test
  @DisplayName("Dividing Double.MIN_VALUE by 2 should return half of Double.MIN_VALUE")
  public void testDivMinValueByTwo() {
    double result = calculator.div(Double.MIN_VALUE, 2.0);
    assertEquals(Double.MIN_VALUE / 2, result, DELTA);
  }

  // Cases involving Infinity
  @Test
  @DisplayName("Dividing positive number by 0 should return positive infinity")
  public void testDivisionByZeroPositive() {
    double result = calculator.div(12345.0, 0.0);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Dividing negative number by 0 should return negative infinity")
  public void testDivisionByZeroNegative() {
    double result = calculator.div(-12345.0, 0.0);
    assertEquals(Double.NEGATIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Dividing 0 by 0 should return NaN")
  public void testDivisionZeroByZero() {
    double result = calculator.div(0.0, 0.0);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Dividing positive infinity by positive number should return positive infinity")
  public void testDivPositiveInfinityByPositive() {
    double result = calculator.div(Double.POSITIVE_INFINITY, 12345.0);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Dividing negative infinity by positive number should return negative infinity")
  public void testDivNegativeInfinityByPositive() {
    double result = calculator.div(Double.NEGATIVE_INFINITY, 12345.0);
    assertEquals(Double.NEGATIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Dividing positive infinity by negative number should return negative infinity")
  public void testDivPositiveInfinityByNegative() {
    double result = calculator.div(Double.POSITIVE_INFINITY, -12345.0);
    assertEquals(Double.NEGATIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Dividing negative infinity by negative number should return positive infinity")
  public void testDivNegativeInfinityByNegative() {
    double result = calculator.div(Double.NEGATIVE_INFINITY, -12345.0);
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  @DisplayName("Dividing NaN by any number should return NaN")
  public void testDivNaNByAnyNumber() {
    double result = calculator.div(Double.NaN, 12345.0);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Dividing any number by NaN should return NaN")
  public void testDivAnyNumberByNaN() {
    double result = calculator.div(12345.0, Double.NaN);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Dividing positive infinity by positive infinity should return NaN")
  public void testDivPositiveInfinityByPositiveInfinity() {
    double result = calculator.div(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Dividing negative infinity by negative infinity should return NaN")
  public void testDivNegativeInfinityByNegativeInfinity() {
    double result = calculator.div(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Dividing positive infinity by negative infinity should return NaN")
  public void testDivPosInfinityByNegInfinity() {
    double result = calculator.div(Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
    assertEquals(Double.NaN, result);
  }

  @Test
  @DisplayName("Dividing negative infinity by positive infinity should return NaN")
  public void testDivNegInfinityByPosInfinity() {
    double result = calculator.div(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    assertEquals(Double.NaN, result);
  }
}