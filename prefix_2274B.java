import java.util.Scanner;

public class prefix_2274B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            long minS = a[0];
            long maxS = a[0];
            long ans = a[0];

            for (int i = 1; i < n; i++) {
                long x = a[i];

                long bestAi = Math.max(x, Math.max(x - minS, x + maxS));
                ans = Math.max(ans, bestAi);
                long newMinS = Math.min(x, Math.min(minS + x, 2 * minS + x));
                long newMaxS = Math.max(x, Math.max(maxS + x, 2 * maxS + x));

                minS = newMinS;
                maxS = newMaxS;
            }

            System.out.println(ans);
        }
    }
}