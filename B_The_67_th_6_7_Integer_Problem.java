import java.io.*;
import java.util.*;

public class B_The_67_th_6_7_Integer_Problem {
    static Scanner sc = new Scanner(System.in);
    static void solve() {
        int a[] = new int[7];
        for (int i = 0; i < 7; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum -= a[i];
        }
        sum += a[6];
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    
}