import java.util.*;

public class AMarisaStealsReimuSTakeout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int c0 = 0, c1 = 0, c2 = 0;
            for (int i = 0; i < n; i++) {
                int w = sc.nextInt();
                if (w == 0) c0++;
                else if (w == 1) c1++;
                else if (w == 2) c2++;
            }
            
            int ops = 0;
            ops += c0;
            int pairs = Math.min(c1, c2);
            ops += pairs;
            c1 -= pairs;
            c2 -= pairs;
            
            ops += c1 / 3;
            ops += c2 / 3;
            
            System.out.println(ops);
        }
    }
}