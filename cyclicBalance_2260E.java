import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CyclicBalance {
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
            pref0[i + 1] = pref0[i] + (s.charAt(i) == '0' ? 1 : 0);
            pref1[i + 1] = pref1[i] + (s.charAt(i) == '1' ? 1 : 0);
            
            prefTransitions[i + 1] = prefTransitions[i];
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                prefTransitions[i + 1]++;
            }
        }
        
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            int len = r - l + 1;
            int c0 = pref0[r] - pref0[l - 1];
            int c1 = pref1[r] - pref1[l - 1];
            
            if (len == 1) {
                out.append(3).append("\n");
                continue;
            }
            int transitions = prefTransitions[r] - prefTransitions[l];
            
            if (s.charAt(r - 1) != s.charAt(l - 1)) {
                transitions++;
            }
            int B = transitions / 2;
            int k1 = (c0 + 1) / 2;
            int k2 = (c1 + 1) / 2;
            int k3 = (len - B + 2) / 3;
            
            int k = Math.max(k1, Math.max(k2, k3));
            out.append(4 * k - len).append("\n");
        }
        
        System.out.print(out);
    }
}