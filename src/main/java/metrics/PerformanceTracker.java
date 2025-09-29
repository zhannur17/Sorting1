package metrics;


public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long accesses = 0; // element reads/writes


    public void countComparison() { comparisons++; }
    public void countSwaps() { swaps++; }
    public void addSwaps(long k) { swaps += k; }
    public void countAccess() { accesses++; }


    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }


    public void reset() { comparisons = swaps = accesses = 0; }


    @Override
    public String toString() {
        return String.format("comparisons=%d, swaps=%d, accesses=%d", comparisons, swaps, accesses);
    }
}