import java.util.*;
public class mexGame_2271B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] counts = new int[n + 2];
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (a <= n) {
                    counts[a]++;
                }
            }
            int M = 0;
            while (counts[M] >= 2 * k) {
                M++;
            }
            if (counts[M] == 2 * k - 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}