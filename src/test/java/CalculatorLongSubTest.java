import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorLongSubTest {

  private static final Calculator calculator = new Calculator();

  // Standard test cases for long subtraction
  @ParameterizedTest(name = "The difference between {0} and {1} should be {2}")
  @CsvSource({
      "20, 10, 10",
      "-20, -10, -10",
      "15, -5, 20",
      "100, 0, 100",
      "0, 100, -100",
      "0, 0, 0"
  })
  @DisplayName("Standard test cases for long subtraction")
  public void testNormalCases(long a, long b, long expectedResult) {
    long result = calculator.sub(a, b);
    assertEquals(expectedResult, result,
        "The result of " + a + " - " + b + " should be " + expectedResult);
  }

  // Edge cases for long subtraction
  @Test
  @DisplayName("Subtracting -1 from Long.MAX_VALUE is handled correctly")
  public void testSubMaxValueMinusNegativeOne() {
    long result = calculator.sub(Long.MAX_VALUE, -1);
    assertEquals(Long.MAX_VALUE + 1, result,
        "The result of Long.MAX_VALUE - (-1) should be Long.MAX_VALUE + 1");
  }

  @Test
  @DisplayName("Subtracting Long.MIN_VALUE from 1 is handled correctly")
  public void testSubOneMinusMinValue() {
    long result = calculator.sub(-1, Long.MIN_VALUE);
    assertEquals(Long.MAX_VALUE, result,
        "The result of -1 - Long.MIN_VALUE should be Long.MAX_VALUE");
  }

  @Test
  @DisplayName("Subtracting Long.MAX_VALUE from Long.MIN_VALUE is handled correctly")
  public void testSubMinValueMinusMaxValue() {
    long result = calculator.sub(Long.MIN_VALUE, Long.MAX_VALUE);
    assertEquals(1, result,
        "The result of Long.MIN_VALUE - Long.MAX_VALUE should be 1");
  }

  @Test
  @DisplayName("Subtracting Long.MIN_VALUE and -1 returns Long.MAX_VALUE due to overflow")
  public void testSubMinValueMinusNegativeOneReturnsMaxValue() {
    long result = calculator.sub(Long.MIN_VALUE, 1);
    assertEquals(Long.MAX_VALUE, result,
        "The result of Long.MIN_VALUE - 1 should be Long.MAX_VALUE");
  }

  // Tests for checking overflow in subtraction
  @Test
  @DisplayName("Subtracting 1 from Long.MAX_VALUE returns Long.MIN_VALUE due to overflow")
  public void testSubMaxValueMinusOneReturnsMinValue() {
    long result = calculator.sub(Long.MAX_VALUE, -1);
    assertEquals(Long.MIN_VALUE, result,
        "The result of Long.MAX_VALUE - (-1) should be Long.MIN_VALUE due to overflow");
  }

  @Test
  @DisplayName("Subtracting Long.MAX_VALUE from itself returns 0")
  public void testSubMaxValueMinusItself() {
    long result = calculator.sub(Long.MAX_VALUE, Long.MAX_VALUE);
    assertEquals(0, result,
        "The result of Long.MAX_VALUE - Long.MAX_VALUE should be 0");
  }
}