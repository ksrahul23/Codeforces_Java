import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CyclicBalance2260E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int[] pref0 = new int[n + 1];
        int[] pref1 = new int[n + 1];
        int[] prefTransitions = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            pref0[i + 1] = pref0[i] + (c == '0' ? 1 : 0);
            pref1[i + 1] = pref1[i] + (c == '1' ? 1 : 0);
            
            prefTransitions[i + 1] = prefTransitions[i];
            if (i > 0 && c != s.charAt(i - 1)) {
                prefTransitions[i + 1]++;
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int len = r - l + 1;
            int c0 = pref0[r] - pref0[l - 1];
            int c1 = pref1[r] - pref1[l - 1];
            int transitions = prefTransitions[r] - prefTransitions[l];
            
            if (s.charAt(r - 1) != s.charAt(l - 1)) {
                transitions++;
            }
            int B = transitions / 2;
            int k1 = (c0 + 1) / 2;       // Enough 0s overall (2k >= c0)
            int k2 = (c1 + 1) / 2;       // Enough 1s overall (2k >= c1)
            int k3 = (len - B + 2) / 3;  // Enough spots to break excessive 00s and 11s (3k >= n - B)
            int k4 = B;
            int k = Math.max(Math.max(k1, k2), Math.max(k3, k4));
            out.println(4 * k - len);
        }
        
        out.flush();
        out.close();
    }
}