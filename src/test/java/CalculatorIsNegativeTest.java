import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorIsNegativeTest {

  private static final Calculator calculator = new Calculator();

  @Test
  @DisplayName("isNegative(1) should return false")
  public void testIsNegativeForOne() {
    long value = 1L;
    boolean result = calculator.isNegative(value);
    assertFalse(result, "Expected isNegative(1) to return false");
  }

  @Test
  @DisplayName("isNegative(-1) should return true")
  public void testIsNegativeForNegativeOne() {
    long value = -1L;
    boolean result = calculator.isNegative(value);
    assertTrue(result, "Expected isNegative(-1) to return true");
  }

  @Test
  @DisplayName("isNegative(0) should return false")
  public void testIsNegativeForZero() {
    long value = 0L;
    boolean result = calculator.isNegative(value);
    assertFalse(result, "Expected isNegative(0) to return false");
  }

  @Test
  @DisplayName("isNegative(Long.MAX_VALUE) should return false")
  public void testIsNegativeForMaxValue() {
    long value = Long.MAX_VALUE;
    boolean result = calculator.isNegative(value);
    assertFalse(result, "Expected isNegative(Long.MAX_VALUE) to return false");
  }

  @Test
  @DisplayName("isNegative(Long.MIN_VALUE) should return true")
  public void testIsNegativeForMinValue() {
    long value = Long.MIN_VALUE;
    boolean result = calculator.isNegative(value);
    assertTrue(result, "Expected isNegative(Long.MIN_VALUE) to return true");
  }

  @Test
  @DisplayName("isNegative(54321) should return false")
  public void testIsNegativeForRandomPositiveNumber() {
    long value = 54321L;
    boolean result = calculator.isNegative(value);
    assertFalse(result, "Expected isNegative(54321) to return false");
  }

  @Test
  @DisplayName("isNegative(-98765) should return true")
  public void testIsNegativeForRandomNegativeNumber() {
    long value = -98765L;
    boolean result = calculator.isNegative(value);
    assertTrue(result, "Expected isNegative(-98765) to return true");
  }
}