import java.util.*;

public class BTatarTvShow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int[] counts = new int[k];
            
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') {
                    counts[i % k]++;
                }
            }
            boolean possible = true;
            for (int i = 0; i < k; i++) {
                if (counts[i] % 2 != 0) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}