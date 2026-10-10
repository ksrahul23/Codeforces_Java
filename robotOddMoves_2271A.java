import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                sb.append(0).append("\n");
            } else if ((a % 2 == b % 2) && b <= a) {
                // Visited at the end of the a-th operation
                sb.append(a).append("\n");
            } else if ((a % 2 != b % 2) && b <= a + 1) {
                // Visited midway through the (a + 1)-th operation
                sb.append(a + 1).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        System.out.print(sb);
    }
}