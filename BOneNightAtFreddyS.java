import java.util.*;
import java.io.*;

public class BOneNightAtFreddyS {
    public static void main(String[] args) throws IOException {
        // Using StringTokenizer and BufferedReader for speed
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            int[] a = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int low = 0, high = l, ans = l;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (check(mid, n, m, l, a)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }

    public static boolean check(int x, int n, int m, int l, int[] a) {
        // If the gap after the last flash is bigger than x, we can't win
        if (l - a[n] > x) return false;
        
        int[] dp = new int[n + 1];
        int max_dp_minus_a = -2000000000; // Stores max(dp[j] - a[j])
        int max_dp = 0;                  // Stores max(dp[j])
        int ptr = 0;

        for (int i = 1; i <= n; i++) {
            // Case: a[i] - a[j] > x
            // We can move the pointer forward and update max_dp
            while (ptr < i && a[i] - a[ptr] > x) {
                max_dp = Math.max(max_dp, dp[ptr]);
                ptr++;
            }
            
            // Option 1: The gap is large (clear x points)
            dp[i] = max_dp + x;
            
            // Option 2: The gap is small (clear exactly a[i] - a[j])
            // We need the best j in the range [ptr, i-1]
            // For the sake of simplicity and the given constraints (sum of m*l),
            // a simple loop here is generally acceptable.
            for (int j = ptr; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + (a[i] - a[j]));
            }
        }

        // Check if remaining danger can be distributed across m animatronics
        return (long)l - dp[n] <= (long)m * x;
    }
}