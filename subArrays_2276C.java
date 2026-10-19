import java.util.Scanner;

public class subArrays_2276C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                long val = sc.nextLong();
                p[i] = (int) ((p[i - 1] + val) % k);
            }
            
            int[] count = new int[k];
            long ans = 0;
            
            for (int j = k + 1; j <= n; j++) {
                count[p[j - k - 1]]++;
                ans += count[p[j]];
            }   
            System.out.println(ans);
        }
    }
}