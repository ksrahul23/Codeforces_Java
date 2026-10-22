import java.util.Scanner;

public class gettingZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // Use StringBuilder for faster output operations
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int minOps = 15; // Max operations is at most 15 (multiply by 2 fifteen times)
            
            // Try adding x (from 0 to 15) before doing any multiplications
            for (int x = 0; x <= 15; x++) {
                int val = (a + x) % 32768;
                int currentOps = x;
                
                if (val != 0) {
                    // Integer.numberOfTrailingZeros finds the number of trailing 0 bits.
                    // We need 15 trailing zero bits to make the number divisible by 2^15 (32768).
                    int trailingZeros = Integer.numberOfTrailingZeros(val);
                    currentOps += Math.max(0, 15 - trailingZeros);
                }
                
                minOps = Math.min(minOps, currentOps);
            }
            
            sb.append(minOps).append(" ");
        }
        
        System.out.println(sb.toString().trim());
    }
}