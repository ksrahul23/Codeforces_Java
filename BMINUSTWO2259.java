import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BMINUSTWO2259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            int odd = 0;
            int mod0 = 0;
            int mod2 = 0;
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int val = Integer.parseInt(st.nextToken());
                
                if (val % 2 != 0) {
                    odd++;
                } else if (val % 4 == 0) {
                    mod0++;
                } else {
                    mod2++;
                }
            }
            int maxFrequency = Math.max(odd, Math.max(mod0, mod2));
            System.out.println(maxFrequency);
        }
    }
}
