import java.util.*;
import java.io.*;

public class BEverythingEverywhere {
    // Standard GCD function
    static int findGcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            long goodCount = 0;
            for (int i = 0; i < n - 1; i++) {
                int a = p[i];
                int b = p[i + 1];
                
                int diff = Math.abs(a - b);
                int commonDiv = findGcd(a, b);
                
                if (diff == commonDiv) {
                    goodCount++;
                }
            }
            System.out.println(goodCount);
        }
    }
}