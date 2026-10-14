import java.util.Scanner;

public class AMOO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            
            int cost = 0;
            for (int i = 0; i < n; i += k) {
                boolean hasZero = false;
                for (int j = 0; j < k; j++) {
                    if (s.charAt(i + j) == '0') {
                        hasZero = true;
                        break;
                    }
                }
                if (!hasZero) {
                    cost++;
                }
            }
            System.out.println(cost);
        }
    }
}