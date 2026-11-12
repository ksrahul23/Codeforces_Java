import java.util.Scanner;
public class lettersDown_2290D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            boolean[] edge = new boolean[26];
            for (int i = 0; i < n / 2; i++) {
                int c1 = s.charAt(i) - 'a';
                int c2 = s.charAt(n - 1 - i) - 'a';
                
                int mn = Math.min(c1, c2);
                int mx = Math.max(c1, c2);
                for (int k = mn; k < mx; k++) {
                    edge[k] = true;
                }
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if (edge[i]) {
                    ans++;
                }
            }
            
            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}