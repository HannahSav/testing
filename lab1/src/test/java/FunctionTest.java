import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionTest {
    private Function function = new Function();

    private double eps = 0.01;

    @ParameterizedTest
    @ValueSource(ints = {-4, -3, -2, -1, 0, 1, 2, 3, 4})
    @DisplayName("Test arctg on int values")
    void intAssertion(int values) {
        assertEquals(function.atan(values, eps), Math.atan(values), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.15, 0.96, 1.13, 1.92, -0.14, -0.99, 1.123, -1.909})
    @DisplayName("Test arctg on double values")
    void doubleAssertion(double values) {
        assertEquals(function.atan(values, eps), Math.atan(values), eps);
    }

    @ParameterizedTest
    @ValueSource(ints = {-30, 30})
    @DisplayName("Test arctg on big int values")
    void bigIntAssertion(int values) {
        assertEquals(function.atan(values, eps), Math.atan(values), eps);
    }
}