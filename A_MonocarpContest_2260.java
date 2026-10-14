import java.util.*;
public class A_MonocarpContest_2260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int zeroCount = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                if (a[i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount < 2) {
                System.out.println(-1);
            } else {
                int swapsNeeded = 0;
                if (a[0] == 1) swapsNeeded++;
                if (a[n - 1] == 1) swapsNeeded++;
                
                System.out.println(swapsNeeded);
            }
        }
    }
}
