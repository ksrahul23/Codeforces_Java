import java.util.Scanner;

public class rhythmicString_2283B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            int maxKept = 0;
            for (int i = 0; i < n; i++) {
                int currentP = a[i];
                int multiplesCount = 0;   
                for (int j = 0; j < n; j++) {
                    if (a[j] % currentP == 0) {
                        multiplesCount++;
                    }
                }
                
                if (multiplesCount > maxKept) {
                    maxKept = multiplesCount;
                }
            }
            System.out.println(n - maxKept);
        }
    }
}