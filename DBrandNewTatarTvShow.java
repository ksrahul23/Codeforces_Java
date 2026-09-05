import java.util.*;

public class DBrandNewTatarTvShow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            int[] v = new int[n];
            int[] c = new int[n];
            int m = 0;
            int current = a[0];
            int count = 1;
            
            for (int i = 1; i < n; i++) {
                if (a[i] == current) {
                    count++;
                } else {
                    v[m] = current;
                    c[m] = count;
                    m++;
                    current = a[i];
                    count = 1;
                }
            }
            v[m] = current;
            c[m] = count;
            m++;
            boolean[] dp = new boolean[m];
            int[] suffFalse = new int[m + 1];
            int r = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                while (r >= 0 && v[r] > v[i] + k) {
                    r--;
                }
                int falseCount = suffFalse[i + 1] - suffFalse[r + 1];
                if (falseCount > 0) {
                    dp[i] = true;
                } else {
                    dp[i] = (c[i] % 2 == 0);
                }   
                suffFalse[i] = suffFalse[i + 1] + (dp[i] ? 0 : 1);
            }
            boolean ok = false;
            for (int i = 0; i < m; i++) {
                if (dp[i]) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}