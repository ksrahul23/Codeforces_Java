import java.io.*;
import java.util.*;

public class blackGrayWhite_2283D {
    static int[] head, to, next;
    static int edgeCount;
    static int[] branch, q;

    static void addEdge(int u, int v) {
        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;
    }

    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        int noTsts = sc.nextInt();
        
        // 3 * 10^5 + slightly more for safety buffer
        int MAX_N = 300005;
        head = new int[MAX_N];
        to = new int[MAX_N * 2];
        next = new int[MAX_N * 2];
        branch = new int[MAX_N];
        q = new int[MAX_N];

        StringBuilder out = new StringBuilder();

        for (int t = 0; t < noTsts; t++) {
            int n = sc.nextInt();

            // Only clear the part of the graph array we are about to use to maintain O(N) complexity
            Arrays.fill(head, 1, n + 1, -1);
            edgeCount = 0;

            for (int i = 0; i < n - 1; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                addEdge(u, v);
                addEdge(v, u);
            }

            if (n % 2 == 0) {
                out.append(n + 1).append("\n");
            } else {
                int[] candidates = {n, n + 1, n + 2};
                int[] uNodes = {n, (n + 1) / 2, 1};
                
                int bestK = n;

                for (int i = 0; i < 3; i++) {
                    int k = candidates[i];
                    int U = uNodes[i];

                    Arrays.fill(branch, 1, n + 1, 0);
                    branch[U] = U;
                    
                    // Root the tree at U, and label all nodes by which branch of U they fall into
                    for (int e = head[U]; e != -1; e = next[e]) {
                        int v = to[e];
                        branch[v] = v;
                        
                        int headQ = 0, tailQ = 0;
                        q[tailQ++] = v;

                        while (headQ < tailQ) {
                            int curr = q[headQ++];
                            for (int e2 = head[curr]; e2 != -1; e2 = next[e2]) {
                                int nxt = to[e2];
                                if (nxt != U && branch[nxt] == 0) {
                                    branch[nxt] = v;
                                    q[tailQ++] = nxt;
                                }
                            }
                        }
                    }

                    boolean works = false;
                    for (int x = 1; x <= n; x++) {
                        int y = k - x;
                        // Checking only for valid pairs
                        if (y > x && y <= n) {
                            // If they are in different branches, their simple path must pass through U
                            if (branch[x] != branch[y]) {
                                works = true;
                                break;
                            }
                        }
                    }

                    if (works) {
                        bestK = k;
                        break;
                    }
                }
                out.append(bestK).append("\n");
            }
        }
        System.out.print(out);
    }
    
    static class FastScanner {
        InputStream in;
        byte[] buf = new byte[1 << 16];
        int head, tail;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int nextInt() throws IOException {
            int c = read();
            while (c <= 32) c = read();
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }
    }
}