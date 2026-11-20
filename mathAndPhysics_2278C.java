import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            long sum = 0;
            int maxAll = 0;
            int maxInner = 0;
            
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                sum += val;
                if (val > maxAll) {
                    maxAll = val;
                }
                if (i > 0 && i < n - 1) {
                    if (val > maxInner) {
                        maxInner = val;
                    }
                }
            }
            if (maxAll < 2) {
                System.out.println("-1");
            }
            else if (n == 2) {
                System.out.println(sum - 1);
            }
            else {
                if (maxInner >= 2) {
                    System.out.println(sum - 1);
                }
                else {
                    System.out.println(sum - (n - 1));
                }
            }
        }
    }
}