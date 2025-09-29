package cli;


import algorithms.InsertionSort;
import algorithms.SelectionSort;
import metrics.PerformanceTracker;


import java.util.Random;
import java.util.Arrays;


public class BenchmarkRunner {
    public static int[] generateRandom(int n, int seed) {
        Random r = new Random(seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = r.nextInt();
        return a;
    }


    public static int[] generateNearlySorted(int n, int swaps, int seed) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i;
        Random r = new Random(seed);
        for (int s = 0; s < swaps; s++) {
            int i = r.nextInt(n);
            int j = r.nextInt(n);
            int t = a[i]; a[i] = a[j]; a[j] = t;
        }
        return a;
    }


    public static void runSingle(int[] arr, String algName) {
        PerformanceTracker t = new PerformanceTracker();
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        if ("insertion".equalsIgnoreCase(algName)) InsertionSort.sort(copy, t);
        else SelectionSort.sort(copy, t);
        long end = System.nanoTime();
        System.out.printf("alg=%s n=%d time_us=%.3f metrics=%s\n", algName, arr.length, (end - start)/1000.0, t.toString());
    }


    public static void main(String[] args) {
        int n = 1000;
        if (args.length >= 1) n = Integer.parseInt(args[0]);
        int seed = 42;
        int[] arr = generateRandom(n, seed);
        runSingle(arr, "insertion");
        runSingle(arr, "selection");


        int[] nearly = generateNearlySorted(n, Math.max(1, n/100), seed);
        runSingle(nearly, "insertion");
        runSingle(nearly, "selection");
    }
}