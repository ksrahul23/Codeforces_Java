import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                if (i % 2 == 0) {
                    b[i] = -a;
                } else {
                    b[i] = a;
                }
            }
            Arrays.sort(b);
            long ans = 0;
            int numSub = (n + 1) / 2; 
            for (int i = 0; i < numSub; i++) {
                ans -= b[i];
            }
            for (int i = numSub; i < n; i++) {
                ans += b[i];
            }
            System.out.println(ans);
        }
    }
}