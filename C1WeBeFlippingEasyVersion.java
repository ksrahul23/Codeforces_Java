import java.util.*;

public class C1WeBeFlippingEasyVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            List<Integer> p = new ArrayList<>();
            int f = 0;
            for (int i = n - 1; i >= 0; i--) {
                int c = a[i];
                if (f % 2 != 0) {
                    c = -c;
                }
                if (c > 0) {
                    p.add(i + 1);
                    f++;
                }
            }
            sb.append(p.size()).append("\n");
            for (int i = 0; i < p.size(); i++) {
                sb.append(p.get(i)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}