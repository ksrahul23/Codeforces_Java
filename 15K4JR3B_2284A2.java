import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 15K4JR3B_2284A2  {
    static long maxX = 0;
    static long target = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] parts = br.readLine().trim().split("\\s+");
            
            int[] counts = new int[100];
            for (int i = 0; i < n; i++) {
                counts[Integer.parseInt(parts[i])]++;
            }

            // Compress the powers of two to reduce the items space
            for (int i = 0; i < 99; i++) {
                if (counts[i] >= 3) {
                    int pairs = (counts[i] - 1) / 2;
                    counts[i] -= pairs * 2;
                    counts[i + 1] += pairs;
                }
            }

            List<Long> items = new ArrayList<>();
            long totalSum = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < counts[i]; j++) {
                    long val = 1L << i;
                    items.add(val);
                    totalSum += val;
                }
            }

            // Sort in descending order to make Branch and Bound aggressively prune the tree
            items.sort(Collections.reverseOrder());

            target = totalSum / 2;
            maxX = 0;
            
            // Generate suffix sums for pruning
            long[] suffixSum = new long[items.size()];
            long runningSum = 0;
            for (int i = items.size() - 1; i >= 0; i--) {
                runningSum += items.get(i);
                suffixSum[i] = runningSum;
            }

            dfs(0, 0, items, suffixSum);

            long ans = maxX * (totalSum - maxX);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int idx, long currentSum, List<Long> items, long[] suffixSum) {
        if (currentSum > target) return;
        if (idx == items.size()) {
            if (currentSum > maxX) {
                maxX = currentSum;
            }
            return;
        }
        if (currentSum + suffixSum[idx] <= maxX) return;
        dfs(idx + 1, currentSum + items.get(idx), items, suffixSum);
        dfs(idx + 1, currentSum, items, suffixSum);
    }
}