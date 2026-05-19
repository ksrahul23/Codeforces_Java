import java.util.Scanner;

public class BRemiliaPlaysSoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long n = sc.nextLong();
            long x1 = sc.nextLong();
            long x2 = sc.nextLong();
            long k = sc.nextLong();
            
            long d = Math.abs(x1 - x2);
            d = Math.min(d, n - d);
            
            System.out.println(Math.min(d + k, n - 1));
        }
    }
}