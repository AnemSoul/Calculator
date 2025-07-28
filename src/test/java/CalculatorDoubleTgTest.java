import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorDoubleTgTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12; // Precision for floating-point comparisons

  @Test
  @DisplayName("tan(0) should equal sin(0) / cos(0)")
  public void testTanEqualsSinDividedByCos_Zero() {
    double angle = 0;
    double sinValue = calculator.sin(angle);
    double cosValue = calculator.cos(angle);
    double expectedResult = sinValue / cosValue;

    double result = calculator.tg(angle);

    assertEquals(expectedResult, result, DELTA,
        "Expected tan(0) to equal sin(0) / cos(0)");
  }

  @Test
  @DisplayName("tan(π/4) should equal sin(π/4) / cos(π/4)")
  public void testTanEqualsSinDividedByCos_PiOver4() {
    double angle = Math.PI / 4;
    double sinValue = calculator.sin(angle);
    double cosValue = calculator.cos(angle);
    double expectedResult = sinValue / cosValue;

    double result = calculator.tg(angle);

    assertEquals(expectedResult, result, DELTA,
        "Expected tan(π/4) to equal sin(π/4) / cos(π/4)");
  }

  @Test
  @DisplayName("tan(-π/4) should equal sin(-π/4) / cos(-π/4)")
  public void testTanEqualsSinDividedByCos_NegativePiOver4() {
    double angle = -Math.PI / 4;
    double sinValue = calculator.sin(angle);
    double cosValue = calculator.cos(angle);
    double expectedResult = sinValue / cosValue;

    double result = calculator.tg(angle);

    assertEquals(expectedResult, result, DELTA,
        "Expected tan(-π/4) to equal sin(-π/4) / cos(-π/4)");
  }

  @Test
  @DisplayName("tan(π/2) should throw ArithmeticException due to division by zero in sin(π/2) / cos(π/2)")
  public void testTanEqualsSinDividedByCos_PiOver2() {
    double angle = Math.PI / 2;

    double sinValue = calculator.sin(angle);
    double cosValue = calculator.cos(angle);

    assertThrows(ArithmeticException.class, () -> {
      double expectedResult = sinValue / cosValue; // This will attempt division by zero
      double result = calculator.tg(angle);
      assertEquals(expectedResult, result); // This case won't reach
    }, "Expected ArithmeticException for tan(π/2)");
  }

  @Test
  @DisplayName("tan(3π/4) should equal sin(3π/4) / cos(3π/4)")
  public void testTanEqualsSinDividedByCos_ThreePiOver4() {
    double angle = 3 * Math.PI / 4;
    double sinValue = calculator.sin(angle);
    double cosValue = calculator.cos(angle);
    double expectedResult = sinValue / cosValue;

    double result = calculator.tg(angle);

    assertEquals(expectedResult, result, DELTA,
        "Expected tan(3π/4) to equal sin(3π/4) / cos(3π/4)");
  }

  /**
   * Periodicity test for tan: tan(a) = sin(a) / cos(a).
   */
  @Test
  @DisplayName("tan(a) should equal tan(a + π)")
  public void testPeriodicTanEqualsSinDividedByCos() {
    double angle = Math.PI / 4;
    double shiftedAngle = angle + Math.PI;

    // Calculations for angle
    double sinValue = calculator.sin(angle);
    double cosValue = calculator.cos(angle);
    double expectedResult = sinValue / cosValue;

    // Calculations for periodic shifted angle
    double sinShiftedValue = calculator.sin(shiftedAngle);
    double cosShiftedValue = calculator.cos(shiftedAngle);
    double expectedShiftedResult = sinShiftedValue / cosShiftedValue;

    double tanAngle = calculator.tg(angle);
    double tanShiftedAngle = calculator.tg(shiftedAngle);

    // Validate tan(a)
    assertEquals(expectedResult, tanAngle, DELTA,
        "Expected tan(a) to equal sin(a) / cos(a)");
    // Validate tan(a + π)
    assertEquals(expectedShiftedResult, tanShiftedAngle, DELTA,
        "Expected tan(a + π) to equal sin(a + π) / cos(a + π)");
    // Validate periodicity
    assertEquals(tanAngle, tanShiftedAngle, DELTA,
        "Expected tan(a) to equal tan(a + π)");
  }
}