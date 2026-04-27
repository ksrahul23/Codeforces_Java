import java.util.*;
import java.io.*;

public class C_Red_Black_Pairs {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            
            int[] dp = new int[n + 1];
            Arrays.fill(dp, (int)1e9);
            dp[0] = 0;
            
            for (int i = 1; i <= n; i++) {
                int costV_R = (s1.charAt(i-1) == 'B' ? 1 : 0) + (s2.charAt(i-1) == 'B' ? 1 : 0);
                int costV_B = (s1.charAt(i-1) == 'R' ? 1 : 0) + (s2.charAt(i-1) == 'R' ? 1 : 0);
                
                dp[i] = Math.min(dp[i], dp[i-1] + Math.min(costV_R, costV_B));
                if (i >= 2) {
                    int costH_topR = (s1.charAt(i-2) == 'B' ? 1 : 0) + (s1.charAt(i-1) == 'B' ? 1 : 0);
                    int costH_topB = (s1.charAt(i-2) == 'R' ? 1 : 0) + (s1.charAt(i-1) == 'R' ? 1 : 0);
            
                    int costH_botR = (s2.charAt(i-2) == 'B' ? 1 : 0) + (s2.charAt(i-1) == 'B' ? 1 : 0);
                    int costH_botB = (s2.charAt(i-2) == 'R' ? 1 : 0) + (s2.charAt(i-1) == 'R' ? 1 : 0);
                    
                    int totalH = Math.min(costH_topR, costH_topB) + Math.min(costH_botR, costH_botB);
                    dp[i] = Math.min(dp[i], dp[i-2] + totalH);
                }
            }
            System.out.println(dp[n]);
        }
    }
}