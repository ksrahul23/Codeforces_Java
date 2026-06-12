import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                int n = sc.nextInt();
                long sum = 0;
                long minHeight = Long.MAX_VALUE;
                
                for (int i = 1; i <= n; i++) {
                    long val = sc.nextLong();
                    sum += val;
                    long currentMax = sum / i;
                    if (currentMax < minHeight) {
                        minHeight = currentMax;
                    }
                    sb.append(minHeight).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
        sc.close();
    }
}