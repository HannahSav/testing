import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionTest {
    private Function function = new Function();

    @ParameterizedTest
    @ValueSource(ints = {-4, -3, -2, -1, 0, 1, 2, 3, 4})
    @DisplayName("Test arctg on int values")
    void intAssertion(int values) {
        assertEquals(function.atan1(values), Math.atan(values), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0.9, 1.1, 1.9, -0.1, -0.9, 1.1, -1.9})
    @DisplayName("Test arctg on double values")
    void doubleAssertion(double values) {
        assertEquals(function.atan1(values), Math.atan(values), 0.001);
    }
}