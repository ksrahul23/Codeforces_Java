import java.io.*;
import java.util.*;

public class A_The_67_th_Integer_Problem {
    static Scanner sc = new Scanner(System.in);
    static void solve() {
        int n = sc.nextInt();
        System.out.println((n >= 67) ? 67 : n);
    }

    public static void main(String[] args) {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}
