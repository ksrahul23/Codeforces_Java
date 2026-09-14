import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n <= 12) {
                sb.append(solveSmall(n)).append("\n");
            } else {
                sb.append(solveLarge(n)).append("\n");
            }
        }
        System.out.print(sb);
    }
    static String solveSmall(int n) {
        int minCost = Integer.MAX_VALUE;
        String best = "";
        
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) > 3) continue;
            
            int[] P = new int[n + 1];
            P[0] = 0;
            int[] counts = new int[3];
            counts[0] = 1;
            
            for (int i = 1; i <= n; i++) {
                int bit = (mask >> (i - 1)) & 1;
                int add = (i % 2 == 1) ? 2 : 1;     // Equivalent to (-1)^i mod 3
                if (bit == 1) {
                    P[i] = (P[i - 1] + add) % 3;
                } else {
                    P[i] = P[i - 1];
                }
                counts[P[i]]++;
            }
            
            int cost = 0;
            for (int c : counts) {
                cost += c * (c - 1) / 2;
            }
            
            if (cost < minCost) {
                minCost = cost;
                StringBuilder s = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    s.append((mask >> (i - 1)) & 1);
                }
                best = s.toString();
            }
        }
        return best;
    }
    static String solveLarge(int n) {
        char[] s = new char[n];
        Arrays.fill(s, '0');
        
        if (n % 6 == 2) {
            int m = (n - 2) / 6;
            s[0] = '1';                  // index 1
            s[2 * m + 1] = '1';          // index 2m + 2
            s[4 * m + 1] = '1';          // index 4m + 2
        } else {
            int[] c = {(n + 1) / 3, (n + 2) / 3, (n + 3) / 3};
            int b1 = -1, b2 = -1;
            
            for (int i = 0; i < 3; i++) {
                if (c[i] % 2 == 0) {    // Identifying an available even block spacing 
                    b2 = c[i];
                    b1 = c[(i + 1) % 3];
                    break;
                }
            }
            s[b1 - 1] = '1';            // index b1
            s[b1 + b2 - 1] = '1';       // index b1 + b2
        }
        return new String(s);
    }
}