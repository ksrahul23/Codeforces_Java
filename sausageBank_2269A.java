import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            long maxAmount = (1L << (n - k + 1)) + (k - 1) * 2L;
            
            System.out.println(maxAmount);
        }
    }
}