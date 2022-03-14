import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSortTest {

    private HeapSort heap = new HeapSort();

     @Test
     @DisplayName("Already sort one")
    public void alreadySortedTest() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        heap.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    @DisplayName("Empty array")
    public void emptyArrayTest() {
        int[] input = {};
        int[] expected = {};
        heap.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    @DisplayName("Simple test")
    public void simpleTest() {
        int[] input = {2, 1, -3, -8, 9, 4};
        int[] expected = {-8, -3, 1, 2, 4, 9};
        heap.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    @DisplayName("One element test")
    public void oneElemTest() {
        int[] input = {1};
        int[] expected = {1};
        heap.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    @DisplayName("Big number test")
    public void bigNumberTest() {
        int[] input = {12134, Integer.MAX_VALUE, 8, Integer.MIN_VALUE, 0, 1, -6767};
        int[] expected = {Integer.MIN_VALUE, -6767, 0, 1, 8, 12134, Integer.MAX_VALUE};
        heap.sort(input);
        assertArrayEquals(expected, input);
    }
}