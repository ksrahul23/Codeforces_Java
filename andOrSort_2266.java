import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

public class andOrSort_2266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
                    sorted = false;
                    break;
                }
            }
            if (sorted) {
                out.println(0);
                continue;
            }
            if (s.charAt(0) == '1') {
                int zeros = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') zeros++;
                }
                out.println(zeros);
            } 
            else {
                int f = -1;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        f = i;
                        break;
                    }
                }
                int[] suffZeros = new int[n + 1];
                for (int i = n - 1; i >= 0; i--) {
                    suffZeros[i] = suffZeros[i + 1] + (s.charAt(i) == '0' ? 1 : 0);
                }
                
                int onesInPref = 0;
                for (int i = 0; i < f; i++) {
                    if (s.charAt(i) == '1') onesInPref++;
                }
                int minCost = Integer.MAX_VALUE;
                for (int k = f; k <= n; k++) {
                    int cost = onesInPref + suffZeros[k];
                    minCost = Math.min(minCost, cost);
                    if (k < n && s.charAt(k) == '1') {
                        onesInPref++;
                    }
                }
                out.println(minCost);
            }
        }
        out.flush();
    }
}