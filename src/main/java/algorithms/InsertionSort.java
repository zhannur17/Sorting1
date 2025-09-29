package algorithms;


import metrics.PerformanceTracker;


public class InsertionSort {
    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null) throw new IllegalArgumentException("arr is null");
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            tracker.countAccess();
            int key = arr[i];

            int lo = 0, hi = i - 1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                tracker.countComparison();
                if (arr[mid] <= key) lo = mid + 1;
                else hi = mid - 1;
            }
            int insertPos = lo;

            if (insertPos != i) {
                tracker.addSwaps(i - insertPos); // counted as element moves
                System.arraycopy(arr, insertPos, arr, insertPos + 1, i - insertPos);
                arr[insertPos] = key;
                tracker.countAccess();
            }
        }
    }
}