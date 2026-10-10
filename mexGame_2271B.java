import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            
            HashMap<Integer, Integer> counts = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                counts.put(a, counts.getOrDefault(a, 0) + 1);
            }
            
            int M = 0;
            boolean aliceWins = false;
            
            // Find the first integer M that appears strictly less than 2*k times
            while (counts.getOrDefault(M, 0) >= 2 * k) {
                if (counts.get(M) % 2 != 0) {
                    aliceWins = true;
                }
                M++;
            }
            
            // If Alice hasn't already won by exploiting an odd frequency smaller than M
            if (!aliceWins) {
                int freqM = counts.getOrDefault(M, 0);
                if (freqM >= k) {
                    aliceWins = true;
                }
            }
            
            if (aliceWins) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}