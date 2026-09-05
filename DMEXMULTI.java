import java.io.*;
import java.util.*;

public class DMEXMULTI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer>[] pos = new ArrayList[n + 2];
            for (int i = 0; i < pos.length; i++) {
                pos[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] <= n) {
                    pos[a[i]].add(i);
                }
            }

            int countZeros = pos[0].size();\
            if (countZeros == 0) {
                out.append("YES\n");
                for (int i = 0; i < n; i++) {
                    out.append('A');
                }
                out.append("\n");
                continue;
            }
            if (countZeros == 1) {
                out.append("NO\n");
                continue;
            }
            char[] ans = new char[n];
            Arrays.fill(ans, 'C');
            int k = 0;
            while (pos[k].size() >= 2) {
                k++;
            }

            for (int v = 0; v < k; v++) {
                int firstIndex = pos[v].get(0);
                int secondIndex = pos[v].get(1);
                ans[firstIndex] = 'A';
                ans[secondIndex] = 'B';
            }

            out.append("YES\n");
            out.append(new String(ans)).append("\n");
        }
        System.out.print(out);
    }
}