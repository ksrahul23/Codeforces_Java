import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 998244353;
    static final int MAX = 200005;
    static long[] inv = new long[MAX];
    static long[] H = new long[MAX];
    static long[] fact = new long[MAX];

    static {
        inv[1] = 1;
        for (int i = 2; i < MAX; i++) {
            inv[i] = MOD - (MOD / i) * inv[MOD % i] % MOD;
        }
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            H[i] = (H[i - 1] + inv[i]) % MOD;
            fact[i] = (fact[i - 1] * i) % MOD;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Random rnd = new Random();
        String tStr = sc.next();
        int t = Integer.parseInt(tStr);
        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            
            if (n == 1) {
                out.println(0);
                continue;
            }
            for (int i = n - 1; i > 0; i--) {
                int idx = rnd.nextInt(i + 1);
                long tmp = a[idx];
                a[idx] = a[i];
                a[i] = tmp;
            }
            Arrays.sort(a);
            
            long ans = 0;
            for (int k = 0; k < n; k++) {
                int i = k + 1; // Align it linearly to 1-indexing base
                long val = a[k] % MOD;
                if (i < n) {
                    ans = (ans - val + MOD) % MOD;
                }
                if (i > 1) {
                    long coef = (H[n - 1] - H[n - i] + MOD) % MOD;
                    ans = (ans + val * coef % MOD) % MOD;
                }
            }
            ans = (ans * fact[n - 1]) % MOD;
            out.println(ans);
        }
        out.flush();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
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