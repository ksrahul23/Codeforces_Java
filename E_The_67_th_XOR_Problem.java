import java.util.*;
import java.io.*;

public class  E_The_67_th_XOR_Problem {
    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        String line = br.readLine();
        if (line == null) return;
        int t = Integer.parseInt(line.trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] a = new long[n];
            long totalXor = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                totalXor ^= a[i];
            }
            
            long maxVal = 0;
            // The final element is always (Total XOR Sum) ^ a[i]
            for (int i = 0; i < n; i++) {
                maxVal = Math.max(maxVal, totalXor ^ a[i]);
            }
            
            out.println(maxVal);
        }
        out.flush();
    }
}