import java.io.*;
import java.util.*;

public class 15K4JR3B_2284A1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
    static int nextInt() throws IOException { return Integer.parseInt(next()); }
    static long nextLong() throws IOException { return Long.parseLong(next()); }

    static void solve() throws IOException {
        long n = nextLong();
        long a = n / 2;
        long b = n - a;
        out.println(a * b);
    }

    public static void main(String[] args) throws IOException {
        int t = nextInt();
        while (t-- > 0) solve();
        out.flush();
    }
}