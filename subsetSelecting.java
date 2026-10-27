import java.util.Scanner;

public class subsetSelecting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            int[] a = new int[n];
            int[] cnt = new int[n + 2]; 
            
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                if (a[i] <= n) {
                    cnt[a[i]]++;
                }
            }
            
            int ans = 0;
            int currentSum = 0;
            
            for (int j = 0; j <= n; j++) {
                if (cnt[j] == 0) {
                    ans = j;
                    break;
                }
                
                currentSum += cnt[j];
                if (currentSum < (j + 1) * k) {
                    ans = j;
                    break;
                }
                
                ans = j + 1; 
            }
            
            System.out.println(ans);
        }
    }
}