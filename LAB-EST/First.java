import java.util.*;

class First {
    public int subarraySumClosest(int[] nums, int K) {
        int n = nums.length;
        
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        long[] sorted = Arrays.copyOf(prefix, n + 1);
        Arrays.sort(sorted);

        long best = Long.MAX_VALUE;
        long bestSum = 0;

        for (long p : prefix) {
            long target = p - K;

            int idx = Arrays.binarySearch(sorted, target);
            if (idx < 0) idx = -idx - 1;

            if (idx < sorted.length) {
                long diff = Math.abs((p - sorted[idx]) - K);
                if (diff < best) {
                    best = diff;
                    bestSum = p - sorted[idx];
                }
            }
            if (idx - 1 >= 0) {
                long diff = Math.abs((p - sorted[idx - 1]) - K);
                if (diff < best) {
                    best = diff;
                    bestSum = p - sorted[idx - 1];
                }
            }
        }

        return (int) bestSum;
    }
}
