// File: src/test/java/algorithms/SelectionSortTest.java
package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {

    private void assertSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            assertTrue(a[i - 1] <= a[i], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testEmpty() {
        int[] a = new int[0];
        SelectionSort.sort(a, new PerformanceTracker());
        assertEquals(0, a.length);
    }

    @Test
    public void testSingle() {
        int[] a = {5};
        SelectionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }

    @Test
    public void testReverse() {
        int[] a = {9, 7, 5, 3, 1};
        SelectionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }

    @Test
    public void testDuplicates() {
        int[] a = {4, 2, 4, 2, 4};
        SelectionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }

    @Test
    public void testAlreadySorted() {
        int[] a = {1, 2, 3, 4, 5};
        SelectionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }
}
