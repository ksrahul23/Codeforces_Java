import java.util.Scanner;

public class BCrimsonTriples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            long triples = 0;
            for (int b = 1; b <= n; b++) {
                long count = n / b;
                triples += (count * count);
            }
            
            System.out.println(triples);
        }
        
        sc.close();
    }
}