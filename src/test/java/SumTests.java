import org.example.Calculator;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class SumTests {

    static Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvFileSource(resources = "sumDoubleResources.csv")
    public void testDoubleSum(double firstAmount, double secondAmount, double result) {
        assertEquals(calculator.sum(firstAmount, secondAmount), result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "sumLongResources.csv")
    public void testLongSum(long firstAmount, long secondAmount, double result) {
        assertEquals(calculator.sum(firstAmount, secondAmount), result);
    }
}
