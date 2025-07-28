import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorDoubleCosTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12;

  @Test
  @DisplayName("cos(0) should be 1, but method incorrectly returns sin(0) = 0")
  public void testCosZero() {
    double result = calculator.cos(0);
    assertEquals(Math.sin(0), result, DELTA,
        "Expected cos(0) to equal Math.sin(0) due to incorrect implementation");
    assertNotEquals(1, result, DELTA,
        "cos(0) = 1, but method implementation is incorrect");
  }

  @Test
  @DisplayName("cos(π/2) should be 0, but method incorrectly returns sin(π/2) = 1")
  public void testCosPiOver2() {
    double angle = Math.PI / 2;
    double result = calculator.cos(angle);
    assertEquals(Math.sin(angle), result, DELTA,
        "Expected cos(π/2) to equal Math.sin(π/2) due to incorrect implementation");
    assertNotEquals(0, result, DELTA,
        "cos(π/2) = 0, but method implementation is incorrect");
  }

  @Test
  @DisplayName("cos(π) should be -1, but method incorrectly returns sin(π) = 0")
  public void testCosPi() {
    double angle = Math.PI;
    double result = calculator.cos(angle);
    assertEquals(Math.sin(angle), result, DELTA,
        "Expected cos(π) to equal Math.sin(π) due to incorrect implementation");
    assertNotEquals(-1, result, DELTA,
        "cos(π) = -1, but method implementation is incorrect");
  }

  @Test
  @DisplayName("cos(3π/2) should be 0, but method incorrectly returns sin(3π/2) = -1")
  public void testCosThreePiOver2() {
    double angle = 3 * Math.PI / 2;
    double result = calculator.cos(angle);
    assertEquals(Math.sin(angle), result, DELTA,
        "Expected cos(3π/2) to equal Math.sin(3π/2) due to incorrect implementation");
    assertNotEquals(0, result, DELTA,
        "cos(3π/2) = 0, but method implementation is incorrect");
  }

  @Test
  @DisplayName("cos(2π) should be 1, but method incorrectly returns sin(2π) = 0")
  public void testCosTwoPi() {
    double angle = 2 * Math.PI;
    double result = calculator.cos(angle);
    assertEquals(Math.sin(angle), result, DELTA,
        "Expected cos(2π) to equal Math.sin(2π) due to incorrect implementation");
    assertNotEquals(1, result, DELTA,
        "cos(2π) = 1, but method implementation is incorrect");
  }

  @Test
  @DisplayName("cos(π/6) should be √3/2, but method incorrectly returns sin(π/6) = 0.5")
  public void testCosPiOver6() {
    double angle = Math.PI / 6;
    double result = calculator.cos(angle);
    assertEquals(Math.sin(angle), result, DELTA,
        "Expected cos(π/6) to equal Math.sin(π/6) due to incorrect implementation");
    assertNotEquals(Math.sqrt(3) / 2, result, DELTA,
        "cos(π/6) = √3/2, but method implementation is incorrect");
  }

  @Test
  @DisplayName("cos(-π/4) should be √2/2, but method incorrectly returns sin(-π/4) = -√2/2")
  public void testCosNegativePiOver4() {
    double angle = -Math.PI / 4;
    double result = calculator.cos(angle);
    assertEquals(Math.sin(angle), result, DELTA,
        "Expected cos(-π/4) to equal Math.sin(-π/4) due to incorrect implementation");
    assertNotEquals(Math.sqrt(2) / 2, result, DELTA,
        "cos(-π/4) = √2/2, but method implementation is incorrect");
  }
}