import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kIsImp_2269C {
    public static void main(String[] args) throws IOException {
        // Utilizing BufferedReader for fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tStr = br.readLine();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr.trim());
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            long[] a = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            long ans = 0;
            
            if (n >= 2 * k - 1) {
                int L = k - 1;
                // Add the maximum of each corresponding prefix and suffix pairs
                for (int i = 0; i < L; i++) {
                    ans += Math.max(a[i], a[n - 1 - i]);
                }
                // Add all the middle elements which will be guaranteed to be fully removed
                for (int i = k - 1; i <= n - k; i++) {
                    ans += a[i];
                }
            } else {
                int L = n - k + 1;
                // Since n < 2k - 1, we can only pull from outer valid pairs before length drops below k
                for (int i = 0; i < L; i++) {
                    ans += Math.max(a[i], a[n - 1 - i]);
                }
            }
            out.append(ans).append("\n");
        }
        System.out.print(out);
    }
}