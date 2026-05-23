import java.util.*;

public class ASlimesOnALine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if (a < min) {
                    min = a;
                }
                if (a > max) {
                    max = a;
                }
            }
            int ans = (max - min + 1) / 2;
            System.out.println(ans);
        }
    }
}