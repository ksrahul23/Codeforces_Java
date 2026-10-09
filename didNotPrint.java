import java.io.*;
import java.util.*;

public class didNotPrint {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
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
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String tStr = fs.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            String s = fs.next();

            boolean[] printed = new boolean[n + 1];
            int[] stack = new int[n];
            int top = 0;

            for (int i = 1; i <= n; i++) {
                char c = s.charAt(i - 1);
                if (c == '1') {
                    stack[top++] = i;
                } else if (c == '2') {
                    if (top > 0) {
                        printed[stack[--top]] = true;
                    } else {
                        printed[i] = true;
                    }
                } else {
                    printed[i] = true;
                }
            }

            int count = 0;
            StringBuilder res = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (!printed[i]) {
                    count++;
                    res.append(i).append(" ");
                }
            }

            out.append(count).append("\n");
            if (count > 0) {
                out.append(res).append("\n");
            } else {
                out.append("\n");
            }
        }
        System.out.print(out);
    }
}