import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n + 1];
            List<Integer> mismatched = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
                if (p[i] != i) {
                    mismatched.add(i);
                }
            }
            if (mismatched.isEmpty()) {
                System.out.println("YES");
                continue;
            }
            boolean possible = true;
            int m = mismatched.size();
            for (int j = 0; j < m; j++) {
                int originalIndex = mismatched.get(j);
                int targetIndex = mismatched.get(m - 1 - j);
                if (p[originalIndex] != targetIndex) {
                    possible = false;
                    break;
                }
            }
            System.out.println(possible ? "YES" : "NO");
        }
    }
}