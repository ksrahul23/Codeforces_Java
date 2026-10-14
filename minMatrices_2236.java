import java.util.Scanner;
public class minMatrices_2236 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (k < n || k > 2 * n - 1) {
                out.append("-1\n");
            } else {
                int[][] A = new int[n][n];
                int m = 2 * n - k;
                int val = 1;
                for (int i = 0; i < m - 1; i++) {
                    A[i][i] = val++;
                }
                A[n - 1][n - 1] = val++;
                for (int j = m - 1; j < n - 1; j++) {
                    A[n - 1][j] = val++;
                }
                for (int i = m - 1; i < n - 1; i++) {
                    A[i][n - 1] = val++;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (A[i][j] == 0) {
                            A[i][j] = val++;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.append(A[i][j]).append(j == n - 1 ? "" : " ");
                    }
                    out.append("\n");
                }
            }
        }
        System.out.print(out);
    }
}