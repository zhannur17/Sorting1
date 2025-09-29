// File: src/test/java/algorithms/InsertionSortTest.java
package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    private void assertSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            assertTrue(a[i - 1] <= a[i], "Array is not sorted at index " + i);
        }
    }

    @Test
    public void testEmpty() {
        int[] a = new int[0];
        PerformanceTracker tracker = new PerformanceTracker();
        InsertionSort.sort(a, tracker);
        assertEquals(0, a.length);
    }

    @Test
    public void testSingle() {
        int[] a = {1};
        InsertionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }

    @Test
    public void testDuplicates() {
        int[] a = {2, 1, 2, 1, 2};
        InsertionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }

    @Test
    public void testReverse() {
        int[] a = {5, 4, 3, 2, 1};
        InsertionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }

    @Test
    public void testAlreadySorted() {
        int[] a = {1, 2, 3, 4, 5};
        InsertionSort.sort(a, new PerformanceTracker());
        assertSorted(a);
    }
}
