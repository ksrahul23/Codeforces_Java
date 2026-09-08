import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BDOMINOTILES {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();

            long oddWays = countWays(s, 0, n);
            long evenWays = countWays(s, 1, n);
            long ans = (oddWays * evenWays) % 998244353;
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
    private static int countWays(String s, int start, int n) {
        boolean canStartWith0 = true;
        boolean canStartWith1 = true;
        for (int i = start, step = 0; i < n; i += 2, step++) {
            char c = s.charAt(i);
            if (c != '?') {
                int val = c - '0';
                if (val != (step % 2)) {
                    canStartWith0 = false;
                }
                if (val != (1 - (step % 2))) {
                    canStartWith1 = false;
                }
            }
        }
        int ways = 0;
        if (canStartWith0) ways++;
        if (canStartWith1) ways++;
        return ways;
    }
}