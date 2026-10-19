import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class caveMan {
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int head, tail;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        public int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = stream.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        if (t == -1) return;
        
        PrintWriter out = new PrintWriter(System.out);

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int[] degree = new int[n + 1];
            for (int i = 0; i < m; i++) {
                int u = fs.nextInt();
                int v = fs.nextInt();
                degree[u]++;
                degree[v]++;
            }

            boolean hasIsolated = false;
            int maxDegree = 0;
            
            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) {
                    hasIsolated = true;
                }
                if (degree[i] > maxDegree) {
                    maxDegree = degree[i];
                }
            }

            if (hasIsolated) {
                out.println("Brain Melt");
            } else if (maxDegree == n - 1 && m == n - 1) {
                out.println("2");
            } else {
                out.println("Many");
            }
        }
        out.flush();
    }
}