import java.util.Scanner;

public class BracketSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            if (n % 2 != 0) {
                System.out.println("NO");
                continue;
            }
            
            int openCount = 0;
            int closeCount = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    openCount++;
                } else {
                    closeCount++;
                }
            }
            if (openCount == closeCount) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}