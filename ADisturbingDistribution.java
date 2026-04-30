import java.util.*;

public class ADisturbingDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            long[] dp = new long[n + 1];
            Arrays.fill(dp, Long.MAX_VALUE);
            dp[0] = 0;

            for (int i = 1; i <= n; i++) {
            }
            
            boolean[] used = new boolean[n];
            long totalCost = 0;
            for (int i = 0; i < n; i++) {
                if (used[i]) continue;
                if (a[i] > 1) {
                    totalCost = (totalCost + a[i]);
                    used[i] = true;
                } else {
                    int bestPair = -1;
                    for (int j = i + 1; j < n; j++) {
                        if (!used[j] && a[j] >= a[i]) {
                            bestPair = j;
                            break; 
                        }
                    }
                    if (bestPair != -1) {
                        used[i] = true; 
                    } else {
                        totalCost = (totalCost + 1);
                        used[i] = true;
                    }
                }
            }
            System.out.println(totalCost % 676767677);
        }
    }
}
