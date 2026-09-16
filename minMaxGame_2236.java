import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class minMaxGame_2236 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = in.nextInt();
            int countOnes = 0;
            
            for (int i = 0; i < n; i++) {
                if (in.nextInt() == 1) {
                    countOnes++;
                }
            }
            int elsieTurns = (n - 1) / 2;
            
            if (countOnes > elsieTurns) {
                out.append("Bessie\n");
            } else {
                out.append("Elsie\n");
            }
        }
        System.out.print(out);
    }
}