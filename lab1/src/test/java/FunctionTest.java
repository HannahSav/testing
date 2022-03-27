import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionTest {
    private Function function = new Function();

    private double eps = 0.1;

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("Test arctg on int values")
    void intAssertion(int values) {
        assertEquals((Double) (function.atan(values, eps)), Math.atan(values), eps);
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, 3, 5, 12345678})
    @DisplayName("Test arctg on big values")
    void bigAssertion(int values) {
        assertEquals(function.atan(values, eps), "No, it's to big to me");
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.15, 0.96, 0.13, 0.92, -0.14, -0.99, 0.123, -0.909})
    @DisplayName("Test arctg on double values")
    void doubleAssertion(double values) {
        assertEquals((Double) function.atan(values, eps), Math.atan(values), eps);
    }
}