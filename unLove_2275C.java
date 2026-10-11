import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] freq = new int[60010];
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = n - 4;
            int[] v = new int[m];
            for (int i = 0; i < m; i++) {
                v[i] = a[i] + a[i+2] - a[i+4];
            }
            long validPairs = 0;
            for (int i = 0; i < m; i++) {
                int val = v[i] + 30005;
                validPairs += freq[val];
                freq[val]++;
            }
            for (int i = 0; i < m - 2; i++) {
                if (v[i] == v[i + 2]) {
                    validPairs--;
                }
            }
            for (int i = 0; i < m - 4; i++) {
                if (v[i] == v[i + 4]) {
                    validPairs--;
                }
            }
            
            System.out.println(validPairs);
            for (int i = 0; i < m; i++) {
                freq[v[i] + 30005] = 0;
            }
        }
    }
}