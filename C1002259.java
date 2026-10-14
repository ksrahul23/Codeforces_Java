import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class C1002259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int first1 = -1;
            int last1 = -1;
            int firstMinus1 = -1;
            int lastMinus1 = -1;
            
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == 1) {
                    if (first1 == -1) first1 = i;
                    last1 = i;
                } else if (a[i] == -1) {
                    if (firstMinus1 == -1) firstMinus1 = i;
                    lastMinus1 = i;
                }
            }
            if (firstMinus1 != -1 && (first1 == -1 || firstMinus1 < first1)) {
                a[firstMinus1] = 1;
            }
            if (lastMinus1 != -1 && (last1 == -1 || lastMinus1 > last1)) {
                a[lastMinus1] = 1;
            }
            for (int i = 0; i < n; i++) {
                if (a[i] == -1) {
                    a[i] = 0;
                }
                sb.append(a[i]).append(i == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
