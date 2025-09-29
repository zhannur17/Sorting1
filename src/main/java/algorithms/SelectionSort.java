package algorithms;


import metrics.PerformanceTracker;


public class SelectionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null) throw new IllegalArgumentException("arr is null");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            boolean swapped = false;
            for (int j = i + 1; j < n; j++) {
                tracker.countComparison();
                tracker.countAccess();
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                swap(arr, i, minIdx, tracker);
                swapped = true;
            }
            if (!swapped) break; // early termination: already sorted
        }
    }


    private static void swap(int[] arr, int i, int j, PerformanceTracker tracker) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        tracker.countAccess();
        tracker.countAccess();
        tracker.countSwaps();
    }
}