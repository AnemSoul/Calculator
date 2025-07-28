import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorIsPositiveTest {

  private static final Calculator calculator = new Calculator();

  @Test
  @DisplayName("isPositive(1) should return true")
  public void testIsPositiveForOne() {
    long value = 1L;
    boolean result = calculator.isPositive(value);
    assertTrue(result, "Expected isPositive(1) to return true");
  }

  @Test
  @DisplayName("isPositive(-1) should return false")
  public void testIsPositiveForNegativeOne() {
    long value = -1L;
    boolean result = calculator.isPositive(value);
    assertFalse(result, "Expected isPositive(-1) to return false");
  }

  @Test
  @DisplayName("isPositive(0) should return false")
  public void testIsPositiveForZero() {
    long value = 0L;
    boolean result = calculator.isPositive(value);
    assertFalse(result, "Expected isPositive(0) to return false");
  }

  @Test
  @DisplayName("isPositive(Long.MAX_VALUE) should return true")
  public void testIsPositiveForMaxValue() {
    long value = Long.MAX_VALUE;
    boolean result = calculator.isPositive(value);
    assertTrue(result, "Expected isPositive(Long.MAX_VALUE) to return true");
  }

  @Test
  @DisplayName("isPositive(Long.MIN_VALUE) should return false")
  public void testIsPositiveForMinValue() {
    long value = Long.MIN_VALUE;
    boolean result = calculator.isPositive(value);
    assertFalse(result, "Expected isPositive(Long.MIN_VALUE) to return false");
  }

  @Test
  @DisplayName("isPositive(123456) should return true")
  public void testIsPositiveForRandomPositiveNumber() {
    long value = 123456L;
    boolean result = calculator.isPositive(value);
    assertTrue(result, "Expected isPositive(123456) to return true");
  }

  @Test
  @DisplayName("isPositive(-654321) should return false")
  public void testIsPositiveForRandomNegativeNumber() {
    long value = -654321L;
    boolean result = calculator.isPositive(value);
    assertFalse(result, "Expected isPositive(-654321) to return false");
  }
}