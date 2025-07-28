import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorLongSumTest {

  private static final Calculator calculator = new Calculator();

  // Tests for verifying addition of long-type numbers in the Calculator class
  @ParameterizedTest(name = "The sum of {0} and {1} should be {2}")
  @CsvSource({
      "10, 20, 30",
      "-10, -20, -30",
      "15, -5, 10",
      "100, 0, 100",
      "0, 0, 0",
      "-100, 100, 0"
  })
  @DisplayName("Standard test cases for long addition")
  public void testNormalCases(long a, long b, long expectedResult) {
    long result = calculator.sum(a, b);
    assertEquals(expectedResult, result,
        "The sum of " + a + " and " + b + " should be " + expectedResult);
  }

  // Tests for verifying edge cases of long-type numbers during addition
  @Test
  @DisplayName("Adding Long.MAX_VALUE and -1 is handled correctly")
  public void testSumMaxValueMinusOne() {
    long result = calculator.sum(Long.MAX_VALUE, -1);
    assertEquals(Long.MAX_VALUE - 1, result,
        "The sum of Long.MAX_VALUE and -1 should be Long.MAX_VALUE - 1");
  }

  @Test
  @DisplayName("Adding Long.MIN_VALUE and 1 is handled correctly")
  public void testSumMinValuePlusOne() {
    long result = calculator.sum(Long.MIN_VALUE, 1);
    assertEquals(Long.MIN_VALUE + 1, result,
        "The sum of Long.MIN_VALUE and 1 should be Long.MIN_VALUE + 1");
  }

  @Test
  @DisplayName("Adding Long.MAX_VALUE and Long.MIN_VALUE is handled correctly")
  public void testSumMaxValueAndMinValue() {
    long result = calculator.sum(Long.MAX_VALUE, Long.MIN_VALUE);
    assertEquals(-1, result,
        "The sum of Long.MAX_VALUE and Long.MIN_VALUE should be -1");
  }

  // Tests for verifying overflow handling during long addition
  @Test
  @DisplayName("Adding Long.MAX_VALUE and 1 returns Long.MIN_VALUE due to overflow")
  public void testSumLongMaxValuePlusOneReturnsMinValue() {
    long result = calculator.sum(Long.MAX_VALUE, 1);
    assertEquals(Long.MIN_VALUE, result,
        "The sum of Long.MAX_VALUE and 1 should return Long.MIN_VALUE due to overflow");
  }

  @Test
  @DisplayName("Adding Long.MIN_VALUE and -1 returns Long.MAX_VALUE due to underflow")
  public void testSumLongMinValuePlusOneReturnsMaxValue() {
    long result = calculator.sum(Long.MIN_VALUE, -1);
    assertEquals(Long.MAX_VALUE, result,
        "The sum of Long.MIN_VALUE and -1 should return Long.MAX_VALUE due to underflow");
  }
}