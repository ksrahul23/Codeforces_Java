import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            // k must be bounded between n and 2n - 1 inclusive
            if (k < n || k > 2 * n - 1) {
                out.append("-1\n");
            } else {
                int[][] A = new int[n][n];
                int m = 2 * n - k;
                int val = 1;

                // 1. Place the first m - 1 smallest elements on the main diagonal
                for (int i = 0; i < m - 1; i++) {
                    A[i][i] = val++;
                }

                // 2. Place the next smallest at the bottom-right corner
                A[n - 1][n - 1] = val++;

                // 3. Fill the rest of the bottom row (for distinct column minimums)
                for (int j = m - 1; j < n - 1; j++) {
                    A[n - 1][j] = val++;
                }

                // 4. Fill the rest of the rightmost column (for distinct row minimums)
                for (int i = m - 1; i < n - 1; i++) {
                    A[i][n - 1] = val++;
                }

                // 5. Fill all remaining unoccupied cells with larger numbers
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (A[i][j] == 0) {
                            A[i][j] = val++;
                        }
                    }
                }

                // Append the constructed matrix to the output string builder
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.append(A[i][j]).append(j == n - 1 ? "" : " ");
                    }
                    out.append("\n");
                }
            }
        }
        
        // Print all outputs efficiently
        System.out.print(out);
        scanner.close();
    }
}