import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_2260 {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(); 
        int t = sc.nextInt();
        if (t == -1) return;
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            long totalSum = a + b; 
            long bestNewA = 0;
            for (int i = 60; i >= 0; i--) {
                long bitVal = 1L << i;
                if ((totalSum & bitVal) != 0) {
                    if ((bestNewA | bitVal) <= a) {
                        bestNewA |= bitVal; 
                    }
                }
            }
            
            long minOperations = a - bestNewA;
            out.append(totalSum).append(" ").append(minOperations).append("\n");
        }
        System.out.print(out);
    }

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
            String str = next();
            if (str == null) return -1;
            return Integer.parseInt(str);
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}