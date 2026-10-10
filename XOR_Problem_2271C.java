import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class XOR_Problem_2271C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = 0;
            while ((1 << (m + 1)) <= n) {
                m++;
            }
            int v = 1 << (m + 1);
            int len = 2 * v - 1;
            sb.append(len).append("\n");
            
            int[] ans = new int[len];
            if (n == 1) {
                ans = new int[]{1, 1, 1};
            } else if (n == 2 || n == 3) {
                ans = new int[]{2, 2, 1, 0, 2, 0, 1};
            } else {
                for(int i = 0; i < len; i++) {
                    ans[i] = 1;
                }
            }
            for (int i = 0; i < len; i++) {
                sb.append(ans[i]).append(i == len - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}