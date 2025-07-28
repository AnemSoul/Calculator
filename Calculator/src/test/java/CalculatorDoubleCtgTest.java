import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorDoubleCtgTest {

  private static final Calculator calculator = new Calculator();
  private static final double DELTA = 1e-12; // Precision for floating-point comparisons

  @Test
  @DisplayName("tanh(0) should return 0")
  public void testTanhZero() {
    double result = calculator.ctg(0);
    assertEquals(0.0, result, DELTA, "Expected tanh(0) to return 0");
  }

  @Test
  @DisplayName("tanh(0.5) should return a value close to 0.462117")
  public void testTanhSmallPositive() {
    double result = calculator.ctg(0.5);
    assertEquals(0.4621171572600098, result, DELTA, "Expected tanh(0.5) to return ~0.462117");
  }

  @Test
  @DisplayName("tanh(-0.5) should return a value close to -0.462117")
  public void testTanhSmallNegative() {
    double result = calculator.ctg(-0.5);
    assertEquals(-0.4621171572600098, result, DELTA, "Expected tanh(-0.5) to return ~-0.462117");
  }

  @Test
  @DisplayName("tanh(20) should approximately return 1")
  public void testTanhLargePositive() {
    double result = calculator.ctg(20);
    assertEquals(1.0, result, DELTA, "Expected tanh(20) to return ~1");
  }

  @Test
  @DisplayName("tanh(-20) should approximately return -1")
  public void testTanhLargeNegative() {
    double result = calculator.ctg(-20);
    assertEquals(-1.0, result, DELTA, "Expected tanh(-20) to return ~-1");
  }

  @Test
  @DisplayName("tanh(+Infinity) should return 1")
  public void testTanhPositiveInfinity() {
    double result = calculator.ctg(Double.POSITIVE_INFINITY);
    assertEquals(1.0, result, DELTA, "Expected tanh(+Infinity) to return 1");
  }

  @Test
  @DisplayName("tanh(-Infinity) should return -1")
  public void testTanhNegativeInfinity() {
    double result = calculator.ctg(Double.NEGATIVE_INFINITY);
    assertEquals(-1.0, result, DELTA, "Expected tanh(-Infinity) to return -1");
  }

  @Test
  @DisplayName("tanh(NaN) should return NaN")
  public void testTanhNaN() {
    double result = calculator.ctg(Double.NaN);
    assertEquals(Double.NaN, result, "Expected tanh(NaN) to return NaN");
  }
}