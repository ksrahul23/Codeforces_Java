import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class introductiontotheNicheInternet {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            // Sort the array in ascending order
            Arrays.sort(a);

            long[] res = new long[n];
            int idx = 0;

            // 1. Put the largest k elements in ascending order at the front
            for (int i = n - k; i < n; i++) {
                res[idx++] = a[i];
            }

            // 2. Put the remaining n - k elements in descending order at the back
            for (int i = n - k - 1; i >= 0; i--) {
                res[idx++] = a[i];
            }

            // 3. Validate if the constructed array yields exactly k pleasant donations
            int pleasantCount = 0;
            long currentSum = 0;

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    pleasantCount++;
                } else {
                    // a[i] >= average of previous elements  =>  a[i] * i >= currentSum
                    if (res[i] * i >= currentSum) {
                        pleasantCount++;
                    }
                }
                currentSum += res[i];
            }

            // 4. Output the result
            if (pleasantCount == k) {
                out.append("YES\n");
                for (int i = 0; i < n; i++) {
                    out.append(res[i]).append(i == n - 1 ? "" : " ");
                }
                out.append("\n");
            } else {
                out.append("NO\n");
            }
        }
        System.out.print(out);
    }

    // Fast IO template for Competitive Programming
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}