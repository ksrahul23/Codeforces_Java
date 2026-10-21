import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            
            // Find a district that belongs to a different gang than the first district
            int diffIdx = -1;
            for (int i = 1; i < n; i++) {
                if (a[i] != a[0]) {
                    diffIdx = i;
                    break;
                }
            }
            
            // If all districts belong to the same gang
            if (diffIdx == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                // Connect districts
                for (int i = 1; i < n; i++) {
                    if (a[i] != a[0]) {
                        // If it's a different gang than district 1, connect it to district 1
                        System.out.println(1 + " " + (i + 1));
                    } else {
                        // If it's the same gang as district 1, connect it to diffIdx
                        System.out.println((diffIdx + 1) + " " + (i + 1));
                    }
                }
            }
        }
        sc.close();
    }
}