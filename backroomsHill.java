import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] posParity = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int val = Integer.parseInt(st.nextToken());
                posParity[val] = i % 2; 
            }
            int oddCount = (n + 1) / 2;
            int evenCount = n / 2;
            boolean possible = true;
            for (int x = 1; x <= n; x++) {
                if (oddCount > evenCount && posParity[x] == 0) {
                    possible = false;
                    break;
                }
                if (evenCount > oddCount && posParity[x] == 1) {
                    possible = false;
                    break;
                }
                if (posParity[x] == 1) {
                    oddCount--;
                } else {
                    evenCount--;
                }
            }
            sb.append(possible ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}