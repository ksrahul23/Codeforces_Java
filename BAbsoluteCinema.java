import java.util.*;

public class BAbsoluteCinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            long sumMax = 0;
            long maxMin = 0;   
            for (int i = 0; i < n; i++) {
                long b = sc.nextLong();
                sumMax += Math.max(a[i], b);
                maxMin = Math.max(maxMin, Math.min(a[i], b));
            }
            
            System.out.println(sumMax + maxMin);
        }
    }
}