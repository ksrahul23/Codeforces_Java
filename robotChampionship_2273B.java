import java.util.Scanner;

public class robotChampionship_2273B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 2) {
                System.out.println(3);
                System.out.println("3 3 3");
                continue;
            }
            if (n == 3) {
                System.out.println(3);
                System.out.println("4 4 4");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = 2; i <= n + 1; i++) {
                sb.append(i).append(" ");
                count++;
            }
            for (int i = 2 * n; i >= n + 2; i--) {
                sb.append(i).append(" ");
                count++;
            }
            for (int i = 2; i <= n + 1; i++) {
                sb.append(i).append(" ");
                count++;
            }
            System.out.println(count);
            System.out.println(sb.toString().trim());
        }
    }
}