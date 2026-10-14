import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

public class XOR_Problem_2271C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = 31 - Integer.numberOfLeadingZeros(n);
            int k = (1 << (m + 2)) - 1;
            out.println(k);
            for (int i = 1; i <= k; i++) {
                if (i % 4 != 0) {
                    out.print(1);
                } else {
                    int tz = Integer.numberOfTrailingZeros(i / 4);
                    out.print(1 << (tz + 1));
                }
                
                // Add space or newline
                if (i == k) {
                    out.println();
                } else {
                    out.print(" ");
                }
            }
        }
        
        out.flush();
        out.close();
        br.close();
    }
}