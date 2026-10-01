import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringTokenizer;
import java.io.IOException;

public class kIsImp_2269 {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            long[] a = new long[n];
            long[] prefix = new long[n + 1];
            long totalSum = 0;
            
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
                totalSum += a[i];
                prefix[i + 1] = prefix[i] + a[i];
            }
            
            if (k == 1) {
                out.append(totalSum).append("\n");
                continue;
            }
            int remCount = k - 1;
            long minRemSum = Long.MAX_VALUE;
            
            for (int x = 0; x <= remCount; x++) {
                int y = remCount - x;
                long leftSum = prefix[x];
                long rightSum = prefix[n] - prefix[n - y];
                long currRemSum = leftSum + rightSum;
                
                if (currRemSum < minRemSum) {
                    minRemSum = currRemSum;
                }
            }
            
            out.append(totalSum - minRemSum).append("\n");
        }
        System.out.print(out);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
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