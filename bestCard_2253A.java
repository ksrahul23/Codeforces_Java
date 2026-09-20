import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of test cases
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        // Process each test case
        while (t-- > 0) {
            int n = scanner.nextInt();
            
            // If n + 1 is prime, there is a card that wins against all
            if (isPrime(n + 1)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; 
            }
        }
        return true;
    }
}