import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            
            // Check if it's already sorted
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
            
            // Case 1: First character is '1'. 
            // It is impossible to turn s[0] to '0'. The whole string must become all '1's.
            if (s.charAt(0) == '1') {
                int zeros = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') zeros++;
                }
                out.println(zeros);
            } 
            // Case 2: First character is '0'.
            else {
                int f = -1;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '1') {
                        f = i;
                        break;
                    }
                }
                
                // Track number of '0's in a suffix to get $O(1)$ lookups
                int[] suffZeros = new int[n + 1];
                for (int i = n - 1; i >= 0; i--) {
                    suffZeros[i] = suffZeros[i + 1] + (s.charAt(i) == '0' ? 1 : 0);
                }
                
                int onesInPref = 0;
                // Accumulate ones in the locked prefix before the first '1' 
                // which structurally consists only of '0's (so it starts at 0)
                for (int i = 0; i < f; i++) {
                    if (s.charAt(i) == '1') onesInPref++;
                }
                
                int minCost = Integer.MAX_VALUE;
                // Evaluate viable split points k, marking boundaries for 0-to-1 switch
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