import java.util.Arrays;
import java.util.Scanner;

public class AAnotherPuzzleFromPapyrus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            
            long sumA = 0;
            long sumB = 0;
            boolean orig = true;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sumA += a[i];
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                sumB += b[i];
                if (a[i] < b[i]) {
                    orig = false;
                }
            }
            Arrays.sort(a);
            Arrays.sort(b);
            
            boolean sort = true;
            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) {
                    sort = false;
                    break;
                }
            }
            if (!sort) {
                System.out.println("-1");
            } else {
                long ans = sumA - sumB;
                if (!orig) {
                    ans += c;
                }
                System.out.println(ans);
            }
        }
    }
}