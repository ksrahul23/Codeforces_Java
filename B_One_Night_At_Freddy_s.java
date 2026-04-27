import java.io.*;
import java.util.*;

public class  B_One_Night_At_Freddy_s {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
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

    private static boolean check(int x, int n, int m, int l, int[] a) {
        if (x >= l) return true;
        if (x == 0) {
            return m == 1 && n >= l && a[n-1] == l;
        }

        long debt = 0;
        int lastTime = 0;

        for (int i = 0; i < n; i++) {
            int time = a[i];
            debt += (time - lastTime);
            
            // If debt > 0, it means danger is accumulating.
            // A flash at time 'time' can reduce the debt by at most x.
            if (debt > 0) {
                debt = Math.max(0, debt - x);
            }
            
            // If the accumulated danger exceeds what (m-1) animatronics 
            // can hold (each holding x), you lose.
            if (debt > (long)(m - 1) * x) {
                return false;
            }
            lastTime = time;
        }

        debt += (l - lastTime);
        return debt <= 0;
    }
}