import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeapSortTest {

    private HeapSort heap = new HeapSort();

     @Test
     @Tag("SortedTest")
     @DisplayName("Already sort one")
    public void alreadySortedTest() {
        double[] input = {1, 2, 3, 4, 5, 6, 7};
        double[] expected = {1, 2, 3, 4, 5, 6, 7};
        heap.sort(input);
        assertArrayEquals(expected, input, 0.0);
    }

    @Test
    @Tag("SortedTest")
    @DisplayName("Empty array")
    public void emptyArrayTest() {
        double[] input = {};
        double[] expected = {};
        heap.sort(input);
        assertArrayEquals(expected, input, 0.0);
    }

    @Test
    @Tag("SortedTest")
    @DisplayName("Simple test")
    public void simpleTest() {
        double[] input = {2, 1, -3, -8, 9, 4};
        double[] expected = {-8, -3, 1, 2, 4, 9};
        heap.sort(input);
        assertArrayEquals(expected, input, 0.0);
    }

    @Test
    @Tag("SortedTest")
    @DisplayName("One element test")
    public void oneElemTest() {
        double[] input = {1};
        double[] expected = {1};
        heap.sort(input);
        assertArrayEquals(expected, input, 0.0);
    }

    @Test
    @Tag("SortedTest")
    @DisplayName("Big number test")
    public void bigNumberTest() {
        double[] input = {12134, Integer.MAX_VALUE, 8, Integer.MIN_VALUE, 0, 1, -6767};
        double[] expected = {Integer.MIN_VALUE, -6767, 0, 1, 8, 12134, Integer.MAX_VALUE};
        heap.sort(input);
        assertArrayEquals(expected, input, 0.0);
    }

    @Test
    @Tag("SortedTest")
    @DisplayName("Double elements test")
    public void DoubleElemTest() {
        double[] input = {1.1, 1.5, 2.2, -1.1, 3.3};
        double[] expected = {-1.1, 1.1, 1.5, 2.2, 3.3};
        heap.sort(input);
        assertArrayEquals(expected, input, 0.0);
    }

    @Tag("LargestTest")
    @Test
    @DisplayName("Find Largest if it's parent")
    public void LargestTest() {
        double[] input = {3.78, 3.77, 3.76};
        assertEquals(heap.findLargest(0, 3, 0, input), 0, 0.0);
    }

    @Test
    @Tag("LargestTest")
    @DisplayName("Find Largest if it's first child")
    public void LargestChildTest() {
        double[] input = {3.77, 3.78, 3.76};
        assertEquals(heap.findLargest(0, 3, 0, input), 1, 0.0);
    }

    @Test
    @Tag("LargestTest")
    @DisplayName("Find Largest if it's second child")
    public void LargestSecondChildTest() {
        double[] input = {3.76, 3.78, 3.87};
        assertEquals(heap.findLargest(0, 3, 0, input), 2, 0.0);
    }

    @Test
    @Tag("LargestTest")
    @DisplayName("Find Largest if only one child")
    public void OnlyOneChildTest() {
        double[] input = {3.76, 3.78, 3.87, 4.78};
        assertEquals(heap.findLargest(1, 4, 1, input), 3, 0.0);
    }

    @Test
    @Tag("LargestTest")
    @DisplayName("Find Largest with no child")
    public void NoChildTest() {
        double[] input = {3.76, 3.78, 3.87, 4.78};
        assertEquals(heap.findLargest(3, 4, 3, input), 3, 0.0);
    }
}