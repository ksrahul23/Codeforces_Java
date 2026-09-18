import java.util.*;

public class signOfPrefixSums_2260D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            long low = 1, high = (long) 1e12;
            long ans = -1;
            while (low <= high) {
                long mid = low + (high - low) / 2;
                if (check(s, n, mid)) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println(ans);
        }
    }
    
    static boolean check(String s, int n, long C) {
        long L = 0, R = 0;
        for (int i = 0; i < n; i++) {
            long oldL = L, oldR = R;
            long L_new = L - C;
            long R_new = R + C;
            
            char ch = s.charAt(i);
            if (ch == '+') {
                if (L_new < 1) L_new = 1;
            } else if (ch == '-') {
                if (R_new > -1) R_new = -1;
            } else {
                if (L_new < 0) L_new = 0;
                if (R_new > 0) R_new = 0;
            }
            
            if (L_new > R_new) return false;
            
            if (oldL == oldR) {
                long H = oldL;
                if (L_new <= H && H <= R_new) {
                    if (L_new == H && R_new == H) return false;
                    if (L_new == H) L_new = H + 1;
                    else if (R_new == H) R_new = H - 1;
                }
            }
            if (L_new > R_new) return false;   
            L = L_new;
            R = R_new;
        }   
        return true;
    }
}