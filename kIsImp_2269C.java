import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];
            long totalSum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                totalSum += a[i];
            }
            if (k == 1) {
                System.out.println(totalSum);
                continue;
            }
            int len = k - 1;
            long currentWindowSum = 0;
            for (int i = 0; i < len; i++) {
                currentWindowSum += a[i];
            }
            long minWindowSum = currentWindowSum;
            for (int i = len; i < n; i++) {
                currentWindowSum += a[i] - a[i - len];
                if (currentWindowSum < minWindowSum) {
                    minWindowSum = currentWindowSum;
                }
            }
            System.out.println(totalSum - minWindowSum);
        }
    }
}