import java.io.*;
import java.util.*;

public class C_The_67_th_Permutation_Problem {
    static Scanner sc = new Scanner(System.in);

    static void solve() {
        int n = sc.nextInt();
        int small = 1;
        int large = n + 1;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(small++).append(" ");
            sb.append(large++).append(" ");
            sb.append(large++).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) {
        int t = 1;
        t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }
}