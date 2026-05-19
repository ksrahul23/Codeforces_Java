import java.util.*;

public class CSnowfall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> d6 = new ArrayList<>();
            List<Integer> d2 = new ArrayList<>();
            List<Integer> d3 = new ArrayList<>();
            List<Integer> net = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int v = sc.nextInt();
                if (v % 6 == 0) d6.add(v);
                else if (v % 2 == 0) d2.add(v);
                else if (v % 3 == 0) d3.add(v);
                else net.add(v);
            }
            
            StringBuilder sb = new StringBuilder();
            for (int x : d6) sb.append(x).append(" ");
            for (int x : d2) sb.append(x).append(" ");
            for (int x : net) sb.append(x).append(" ");
            for (int x : d3) sb.append(x).append(" ");
            
            System.out.println(sb.toString().trim());
        }
    }
}