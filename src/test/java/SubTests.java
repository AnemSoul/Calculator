import org.example.Calculator;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class SubTests {
    static Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvFileSource(resources = "subDoubleResources.csv")
    public void testDoubleSub(double firstAmount, double secondAmount, double result) {
        assertEquals(calculator.sub(firstAmount, secondAmount), result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "subLongResources.csv")
    public void testLongSub(long firstAmount, long secondAmount, double result) {
        assertEquals(calculator.sub(firstAmount, secondAmount), result);
    }
}
