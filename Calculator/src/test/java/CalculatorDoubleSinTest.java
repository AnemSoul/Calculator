import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoubleSinTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12; // Precision for floating-point comparisons

  @Test
  @DisplayName("sin(0) should return 0")
  public void testSinZero() {
    double result = calculator.sin(0);
    assertEquals(0, result, DELTA, "Expected sin(0) to return 0");
  }

  @Test
  @DisplayName("sin(π/2) should return 1")
  public void testSinPiOver2() {
    double angle = Math.PI / 2;
    double result = calculator.sin(angle);
    assertEquals(1, result, DELTA, "Expected sin(π/2) to return 1");
  }

  @Test
  @DisplayName("sin(π) should return 0")
  public void testSinPi() {
    double angle = Math.PI;
    double result = calculator.sin(angle);
    assertEquals(0, result, DELTA, "Expected sin(π) to return 0");
  }

  @Test
  @DisplayName("sin(3π/2) should return -1")
  public void testSinThreePiOver2() {
    double angle = 3 * Math.PI / 2;
    double result = calculator.sin(angle);
    assertEquals(-1, result, DELTA, "Expected sin(3π/2) to return -1");
  }

  @Test
  @DisplayName("sin(2π) should return 0")
  public void testSinTwoPi() {
    double angle = 2 * Math.PI;
    double result = calculator.sin(angle);
    assertEquals(0, result, DELTA, "Expected sin(2π) to return 0");
  }

  @Test
  @DisplayName("sin(π/4) should return √2/2")
  public void testSinPiOver4() {
    double angle = Math.PI / 4;
    double result = calculator.sin(angle);
    assertEquals(Math.sqrt(2) / 2, result, DELTA, "Expected sin(π/4) to return √2/2");
  }

  @Test
  @DisplayName("sin(-π/4) should return -√2/2")
  public void testSinNegativePiOver4() {
    double angle = -Math.PI / 4;
    double result = calculator.sin(angle);
    assertEquals(-Math.sqrt(2) / 2, result, DELTA, "Expected sin(-π/4) to return -√2/2");
  }

  @Test
  @DisplayName("sin(a) should equal sin(a + 2π)")
  public void testSinPeriodicity() {
    double angle = Math.PI / 6;      // π/6
    double shiftedAngle = angle + 2 * Math.PI; // π/6 + 2π
    double result = calculator.sin(angle);
    double periodicResult = calculator.sin(shiftedAngle);

    assertEquals(result, periodicResult, DELTA, "Expected sin(a) to equal sin(a + 2π)");
  }

  @Test
  @DisplayName("sin(a) should equal -sin(-a)")
  public void testSinSymmetry() {
    double angle = Math.PI / 3; // π/3
    double result = calculator.sin(angle);
    double symmetricResult = calculator.sin(-angle);

    assertEquals(result, -symmetricResult, DELTA, "Expected sin(a) to equal -sin(-a)");
  }

  @Test
  @DisplayName("sin(NaN) should return NaN")
  public void testSinNaN() {
    double result = calculator.sin(Double.NaN);
    assertEquals(Double.NaN, result, "Expected sin(NaN) to return NaN");
  }

  @Test
  @DisplayName("sin(+Infinity) should return NaN")
  public void testSinPositiveInfinity() {
    double result = calculator.sin(Double.POSITIVE_INFINITY);
    assertEquals(Double.NaN, result, "Expected sin(+Infinity) to return NaN");
  }

  @Test
  @DisplayName("sin(-Infinity) should return NaN")
  public void testSinNegativeInfinity() {
    double result = calculator.sin(Double.NEGATIVE_INFINITY);
    assertEquals(Double.NaN, result, "Expected sin(-Infinity) to return NaN");
  }
}