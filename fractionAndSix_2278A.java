import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String p = sc.next();
            String q = sc.next();
            if (n != m + 3) {
                System.out.println("NO");
                continue;
            }
            int[] count = new int[26];
            for (int i = 0; i < n; i++) {
                count[p.charAt(i) - 'a']++;
            }
            for (int i = 0; i < m; i++) {
                count[q.charAt(i) - 'a']--;
            }
            count['s' - 'a']--;
            count['i' - 'a']--;
            count['x' - 'a']--;
            boolean isPossible = true;
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    isPossible = false;
                    break;
                }
            }   
            if (isPossible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}