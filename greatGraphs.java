import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            long[] d = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                d[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(d);
            long totalCost = d[n - 1];
            for (int i = 0; i < n; i++) {
                long positiveCount = n - 1 - i;
                long negativeCount = i;
                totalCost += d[i] * (positiveCount - negativeCount);
            }
            
            sb.append(totalCost).append("\n");
        }
        System.out.print(sb.toString());
    }
}