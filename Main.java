import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static void solve() {
        int n = fs.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        Arrays.sort(a);
        out.println(a[66]);
    }

    public static void main(String[] args) {
        int t = 1;
        t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
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

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { return null; }
        }
    }
}