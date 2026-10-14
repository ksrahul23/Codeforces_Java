import java.util.Scanner;

public class CarrotChopdown_2258 {
    static final int MAXM = 200005;
    static int[][] V = new int[20][MAXM];
    static void precompute() {
        for (int M = 1; M < MAXM; M++) {
            V[0][M] = (M == 1 ? 1 : 0);
        }
        for (int k = 1; k < 20; k++) {
            int X = 1 << (k - 1);
            for (int M = 1; M < MAXM; M++) {
                if (M > X) {
                    V[k][M] = X + V[k - 1][M - X];
                } else {
                    V[k][M] = V[k - 1][M];
                }
            }
        }
    }

    public static void main(String[] args) {
        precompute();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] pref = new int[m + 1];
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val <= m) {
                    pref[val]++;
                }
            }
            for (int i = 1; i <= m; i++) {
                pref[i] += pref[i - 1];
            }
            int[] ans = new int[m + 1];
            int maxK = Math.min(m, 19);

            for (int c = 1; c <= m; c++) {
                int maxM = m / c;
                for (int k = 1; k <= maxK; k++) {
                    int sum = 0;
                    for (int M = 1; M <= maxM; M++) {
                        int L = M * c;
                        int R = Math.min(m, L + c - 1);
                        int count = pref[R] - pref[L - 1];
                        if (count > 0) {
                            sum += count * V[k][M];
                        }
                    }
                    if (sum > ans[k]) {
                        ans[k] = sum;
                    }
                }
            }
            for (int k = 2; k <= m; k++) {
                if (ans[k - 1] > ans[k]) {
                    ans[k] = ans[k - 1];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= m; k++) {
                sb.append(ans[k]).append(k == m ? "" : " ");
            }
            System.out.println(sb.toString());
        }
    }
}