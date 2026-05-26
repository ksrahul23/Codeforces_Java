import java.util.*;

public class DMeWhenMedianProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            
            int low = 1, high = 2 * n, ans = 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (check(a, b, n, mid)) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }

    static boolean check(int[] a, int[] b, int n, int x) {
        int n_plus = 0;
        int n_minus = 0;
        int last = -1;
        
        for (int i = 0; i < n; i++) {
            int c = (a[i] >= x ? 1 : 0) + (b[i] >= x ? 1 : 0);
            
            if (c == 2) {
                n_plus++;
                last = 2;
            } else if (c == 0) {
                if (last != 0) {
                    n_minus++;
                    last = 0;
                }
            }
        }
        
        return n_plus > n_minus;
    }
}