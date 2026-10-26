import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Arrays.sort(a);
            
            int[] count = new int[n + 2];
            for (int x : a) {
                if (x <= n) {
                    count[x]++;
                }
            }
            
            int mex = 0;
            int availableElements = 0;
            for (int i = 0; i <= n; i++) {
                availableElements += count[i];
                if (availableElements >= k) {
                    availableElements -= k;
                    mex = i + 1;
                } else {
                    break;
                }
            }
            System.out.println(mex);
        }
    }
}