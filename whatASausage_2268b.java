import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class whatASausage_2268b {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            
            int[] a = new int[n + 1];
            int evenParityCount = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (Integer.bitCount(a[i]) % 2 == 0) {
                    evenParityCount++;
                }
            }
            
            out.append(evenParityCount).append(" ");
            
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (Integer.bitCount(a[p]) % 2 == 0) {
                    evenParityCount--;
                }
                
                a[p] = x;
                if (Integer.bitCount(a[p]) % 2 == 0) {
                    evenParityCount++;
                }
                
                out.append(evenParityCount).append(" ");
            }
            out.append("\n");
        }
        
        System.out.print(out);
    }
}